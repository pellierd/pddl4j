/*
 * Copyright (c) 2010 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PDDL4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
 */

package pddl4j.examples.ahsp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Properties;

import pddl4j.heuristics.HeuristicToolKit;
import pddl4j.heuristics.Heuristic;
import pddl4j.parser.Domain;
import pddl4j.parser.Parser;
import pddl4j.parser.Problem;
import pddl4j.preprocessing.CodedProblem;
import pddl4j.preprocessing.Preprocessing;
import pddl4j.util.BitOp;
import pddl4j.util.BitState;
import pddl4j.util.CondBitExp;
import pddl4j.util.MemoryAgent;

/**
 * This class implements a simple forward planner based on A* algorithm.
 * 
 * @author D. Pellier
 * @version 1.0 - 14.06.2010
 */
public final class AHSP {
	
	/**
	 * The default heuristic.
	 */
	private static final Heuristic.Type DEFAULT_HEURISTIC = Heuristic.Type.FAST_FORWARD;

	/**
	 * The default CPU time allocated to the search in seconds.
	 */
	private static final int DEFAULT_CPU_TIME = 600;

	/**
	 * The default weight of the heuristic.
	 */
	private static final double DEFAULT_WHEIGHT = 1.00;

	/**
	 * The default trace level.
	 */
	private static final int DEFAULT_TRACE_LEVEL = 1;

	/**
	 * The enumeration of the arguments of the planner.
	 */
	private enum Argument {
		/** The planning domain. */
		DOMAIN,
		/** The planning problem. */
		PROBLEM,
		/** The heuristic to use. */
		HEURISTIC_TYPE,
		/** The weight of the heuristic. */
		WEIGHT,
		/** The global time slot allocated to the search. */
		CPU_TIME,
		/** The trace level. */
		TRACE_LEVEL
	}
	
	/**
	 * The time needed to search a solution plan.
	 */
	private long searching_time;

	/**
	 * The time needed to encode the planning problem.
	 */
	private long preprocessing_time;

	/**
	 * The memory used in bytes to search a solution plan.
	 */
	private long searching_memory;

	/**
	 * The memory used in bytes to encode problem.
	 */
	private long problem_memory;

	/**
	 * The number of node explored.
	 */
	private int nb_of_explored_nodes;
	
	/**
	 * The arguments of the planner.
	 */
	private Properties arguments;
	
	/**
	 * Creates a new planner.
	 * 
	 * @param arguments the arguments of the planner.
	 */
	private AHSP(final Properties arguments) {
		this.arguments = arguments;
	}

	/**
	 * This method parses the PDDL files and encodes the corresponding planning problem into a
	 * compact representation.
	 * 
	 * @return the encoded problem.
	 */
	public CodedProblem parseAndEncode() {
		final Parser parser = new Parser();
		final String ops = (String) this.arguments.get(AHSP.Argument.DOMAIN);
		final String facts = (String) this.arguments.get(AHSP.Argument.PROBLEM);
		try {
			parser.parse(ops, facts);
		} catch (FileNotFoundException e) {
		}
		if (!parser.getErrorManager().isEmpty()) {
			parser.getErrorManager().printAll();
			System.exit(0);
		}
		final Domain domain = parser.getDomain();
		final Problem problem = parser.getProblem();
		final int traceLevel = (Integer) this.arguments.get(AHSP.Argument.TRACE_LEVEL);
		if (traceLevel > 0 && traceLevel != 8) {
			System.out.println();
			System.out.println("Parsing domain file \"" + new File(ops).getName()
					+ "\" done successfully");
			System.out.println("Parsing problem file \"" + new File(facts).getName()
					+ "\" done successfully\n");
		}
		if (traceLevel == 8) {
			Preprocessing.setLogLevel(0);
		} else {
			Preprocessing.setLogLevel(Math.max(0, traceLevel - 1));
		}
		long begin = System.currentTimeMillis();
		final CodedProblem pb = Preprocessing.encode(domain, problem);
		long end = System.currentTimeMillis();
		this.preprocessing_time = end - begin;
		this.problem_memory = MemoryAgent.deepSizeOf(pb);
		return pb;
	}

	/**
	 * Search a solution plan to a specified domain and problem.
	 * 
	 * @param pb the problem to solve.
	 */
	public void search(final CodedProblem pb) {
		
		List<String> plan = null;
		if (pb.isSolvable()) plan = this.AStarSearch(pb);
		
		// The rest it is just to print the result
		final int traceLevel = (Integer) this.arguments.get(AHSP.Argument.TRACE_LEVEL);
		if (traceLevel > 0 && traceLevel != 8) {
			if (pb.isSolvable()) {
				if (plan != null) {
					System.out.printf("\nfound plan as follows:\n\n");
					for (int i = 0; i < plan.size(); i++) {
						System.out.printf("time step %4d: %s\n", i, plan.get(i));
					}
				} else {
					System.out.printf("\nno plan found\n\n");
				}
			} else {
				System.out.printf("goal can be simplified to FALSE. no plan will solve it\n\n");
			}
			System.out.printf("\ntime spent: %8.2f seconds preprocessing ("
					+ pb.getOperators().size() + " ops, " + pb.getRevelantFacts().size()
					+ " facts)\n", (this.preprocessing_time / 1000.0));
			System.out.printf("            %8.2f seconds searching\n",
					(this.searching_time / 1000.0));
			System.out.printf("            %8.2f seconds total time\n",
					((this.preprocessing_time + searching_time) / 1000.0));
			System.out.printf("\n");
			System.out.printf("memory used: %8.2f MBytes for problem representation\n",
					+(this.problem_memory / (1024.0 * 1024.0)));
			System.out.printf("             %8.2f MBytes for searching\n",
					+(this.searching_memory / (1024.0 * 1024.0)));
			System.out.printf("             %8.2f MBytes total\n",
					+((this.problem_memory + this.searching_memory) / (1024.0 * 1024.0)));
			System.out.printf("\n\n");
		}
		if (traceLevel == 8) {
			String problem = (String) this.arguments.get(AHSP.Argument.PROBLEM);
			String[] str_array = problem.split("/");
			String pb_file = str_array[str_array.length - 1];
			String pb_name = pb_file.substring(0, pb_file.indexOf("."));
			System.out.printf("%5s %8d %8d %8.2f %8.2f %10d", pb_name, pb.getOperators().size(), 
					pb.getRevelantFacts().size(), (this.preprocessing_time / 1000.0),
					(this.problem_memory / (1024.0 * 1024.0)), this.nb_of_explored_nodes);
			if (plan != null) {
				System.out.printf("%8.2f %8.2f %8.2f %8.2f %5d\n", (this.searching_time / 1000.0),
						((this.preprocessing_time + searching_time) / 1000.0),
						(this.searching_memory / (1024.0 * 1024.0)),
						((this.problem_memory + this.searching_memory) / (1024.0 * 1024.0)),
						plan.size());
			} else {
				System.out.printf("%8s %8s %8s %8s %5s\n", "-", "-", "-", "-", "-");
			}
		}
	}
	
	/**
	 * Solves the planning problem and returns the first solution plan found. This method must be
	 * completed.
	 * 
	 * @param problem the coded planning problem to solve.
	 * @return a solution plan or null if it does not exist.
	 */
	private List<String> AStarSearch(final CodedProblem problem) {
		final long begin = System.currentTimeMillis();
		final Heuristic.Type type = (Heuristic.Type) this.arguments.get(AHSP.Argument.HEURISTIC_TYPE);
		final Heuristic heuristic = HeuristicToolKit.createHeuristic(type, problem);
		// Get the initial state from the planning problem
		final BitState init = new BitState(problem.getInit());
		// Initialize the closed list of nodes (store the nodes explored)
		final Map<BitState, Node> closeSet = new HashMap<BitState, Node>();
		final Map<BitState, Node> openSet = new HashMap<BitState, Node>();
		// Initialize the opened list (store the pending node)
		final double weight = (Double) this.arguments.get(AHSP.Argument.WEIGHT);
		// The list stores the node ordered according to the A* (f = g + h) function
		final PriorityQueue<Node> open = new PriorityQueue<Node>(100, new Comparator<Node>() {
			public int compare(final Node n1, final Node n2) {
				final double diff = n1.f(weight) - n2.f(weight);
				if (diff < 0) {
					return -1;
				} else if (diff > 0) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		// Creates the root node of the tree search
		final Node root = new Node(init, null, -1, 0, heuristic.estimate(init, problem.getGoal()));
		// Adds the root to the list of pending nodes
		open.add(root);
		openSet.put(init, root);
		List<String> plan = null;

		final int CPUTime = (Integer) this.arguments.get(AHSP.Argument.CPU_TIME);
		// Start of the search
		while (!open.isEmpty() && plan == null && this.searching_time < CPUTime) {
			// Pop the first node in the pending list open
			final Node current = open.poll();
			openSet.remove(current);
			closeSet.put(current, current);
			// If the goal is satisfy in the current node then extract the plan and return it
			if (current.satisfy(problem.getGoal())) {
				plan = this.extract(current, problem);
			} else {
				// Try to apply the operators of the problem to this node
				int index = 0;
				for (BitOp op : problem.getOperators()) {
					// Test if a specified operator is applicable in the current state
					if (op.isApplicable(current)) {
						Node state = new Node(current);
						// Apply the effect of the applicable operator
						for (CondBitExp ce : op.getCondEffects()) {
							// Test if the condition of the effect is satisfied in the current state
							if (current.satisfy(ce.getCondition())) {
								// Apply the effect to the successor node
								state.apply(ce.getEffects());
							}
						}
						final int g = current.getCost() + 1;
						Node result = openSet.get(state);  
						if(result == null) {
							result = closeSet.get(state);
							if (result != null) {
								if (g < result.getCost()) {
									result.setCost(g);
									result.setParent(current);
									result.setOperator(index);
									open.add(result);
									openSet.put(result, result);
									closeSet.remove(result);
								}
							} else {
								state.setCost(g);
								state.setParent(current);
								state.setOperator(index);
								state.setHeuristic(heuristic.estimate(state, problem.getGoal()));
								open.add(state);
								openSet.put(state, state);
							}
						} else if(g < result.getCost()) {
							result.setCost(g);
							result.setParent(current);
							result.setOperator(index);
						}						
						
					}
					index++;
				}
			}
			// Take time to compute the searching time
			long end = System.currentTimeMillis();
			// Compute the searching time
			this.searching_time = end - begin;
		}
		// Compute the memory used by the search
		this.searching_memory += MemoryAgent.deepSizeOf(closeSet) + MemoryAgent.deepSizeOf(openSet)
				+ MemoryAgent.deepSizeOf(open);
		this.searching_memory += MemoryAgent.deepSizeOf(heuristic);
		this.nb_of_explored_nodes = closeSet.size();
		// return the plan computed or null if no plan was found
		return plan;
	}

	/**
	 * Extracts a plan from a specified node.
	 * 
	 * @param node the node.
	 * @param problem the problem.
	 * @return the plan extracted from the specified node.
	 */
	private List<String> extract(final Node node, final CodedProblem problem) {
		Node n = node;
		final LinkedList<String> plan = new LinkedList<String>();
		while (n.getOperator() != -1) {
			final BitOp op = problem.getOperators().get(n.getOperator());
			if (!op.isDummy()) {
				plan.addFirst(problem.toShortString(op));
			}
			n = n.getParent();
		}
		return plan;
	}

	/**
	 * The main method of the <code>AHSP</code> example. The command line syntax is as follow:
	 * 
	 * <pre>
	 * usage of AHSP:
	 * 
 	 * OPTIONS   DESCRIPTIONS
  	 * 
	 * -o <str>    operator file name
	 * -f <str>    fact file name
	 * -w <num>    the weight used in the a star search (preset: 1)
	 * -t <num>    specifies the maximum CPU-time in seconds (preset: 300)
	 * -u <num>    specifies the heuristic to used (preset: 0)
	 *      0      ff heuristic
	 *      1      sum heuristic
	 *      2      sum mutex heuristic
 	 *      3      adjusted sum heuristic
	 *      4      adjusted sum 2 heuristic
	 *      5      adjusted sum 2M heuristic
	 *      6      combo heuristic
	 *      7      max heuristic
	 *      8      set-level heuristic
	 * -i <num>    run-time information level (preset: 1)
	 *      0      nothing
	 *      1      info on action number, search and plan
	 *      2      1 + info on problem constants, types and predicates
	 *      3      1 + 2 + loaded operators, initial and goal state
	 *      4      1 + predicates and their inertia status
	 *      5      1 + 4 + goal state and operators with unary inertia encoded
	 *      6      1 + actions, initial and goal state after expansion of variables
	 *      7      1 + final domain representation
	 *      8      line representation:
	 *                - problem name
	 *                - number of operators
 	 *               - number of facts
	 *                - preprocessing time in seconds
	 *                - memory used for problem representation in MBytes
	 *                - number of states explored
	 *                - searching time in seconds
	 *                - memory used for searching in MBytes
	 *                - global memory used in MBytes
	 *                - solution plan length
	 *      > 100  1 + various debugging information
	 * -h          print this message
	 * 
	 * </pre>
	 * 
	 * @param args the arguments of the command line.
	 */
	public static void main(String[] args) {
		// Parse the command line
		final Properties arguments = AHSP.parseArguments(args);
		// Create the planner
		AHSP planner = new AHSP(arguments);
		// Parse and encode the PDDL file into compact representation
		final CodedProblem problem = planner.parseAndEncode();
		// Search for a solution and print the result
		planner.search(problem);
	}

	/**
	 * This method parse the command line and return the arguments.
	 * 
	 * @param args the arguments from the command line.
	 * @return The arguments of the planner.
	 */
	private static Properties parseArguments(String[] args) {
		final Properties arguments = AHSP.getDefaultArguments();
		try {
			for (int i = 0; i < args.length; i++) {
				if (args[i].equalsIgnoreCase("-o") && ((i + 1) < args.length)) {
					arguments.put(AHSP.Argument.DOMAIN, args[i + 1]);
					if (!new File(args[i + 1]).exists()) {
						System.out.println("operators file does not exist");
						System.exit(0);
					}
					i++;
				} else if (args[i].equalsIgnoreCase("-f") && ((i + 1) < args.length)) {
					arguments.put(AHSP.Argument.PROBLEM, args[i + 1]);
					if (!new File(args[i + 1]).exists()) {
						System.out.println("facts file does not exist");
						System.exit(0);
					}
					i++;
				} else if (args[i].equalsIgnoreCase("-t") && ((i + 1) < args.length)) {
					final int cpu = Integer.valueOf(args[i + 1]) * 1000;
					if (cpu < 0) AHSP.printUsage();
					i++;
					arguments.put(AHSP.Argument.CPU_TIME, cpu);
				} else if (args[i].equalsIgnoreCase("-u") && ((i + 1) < args.length)) {
					final int heuristic = Integer.valueOf(args[i + 1]);
					if (heuristic < 0 || heuristic > 8) AHSP.printUsage();
					if (heuristic == 0) {
						arguments.put(AHSP.Argument.HEURISTIC_TYPE, Heuristic.Type.FAST_FORWARD);
					} else if (heuristic == 1) {
						arguments.put(AHSP.Argument.HEURISTIC_TYPE, Heuristic.Type.SUM);
					} else if (heuristic == 2) {
						arguments.put(AHSP.Argument.HEURISTIC_TYPE, Heuristic.Type.SUM_MUTEX);
					} else if (heuristic == 3) {
						arguments.put(AHSP.Argument.HEURISTIC_TYPE, Heuristic.Type.AJUSTED_SUM);
					} else if (heuristic == 4) {
						arguments.put(AHSP.Argument.HEURISTIC_TYPE, Heuristic.Type.AJUSTED_SUM2);
					} else if (heuristic == 5) {
						arguments.put(AHSP.Argument.HEURISTIC_TYPE, Heuristic.Type.AJUSTED_SUM2M);
					} else if (heuristic == 6) {
						arguments.put(AHSP.Argument.HEURISTIC_TYPE, Heuristic.Type.COMBO);
					} else if (heuristic == 7) {
						arguments.put(AHSP.Argument.HEURISTIC_TYPE, Heuristic.Type.MAX);
					} else {
						arguments.put(AHSP.Argument.HEURISTIC_TYPE, Heuristic.Type.SET_LEVEL);
					}
					i++;
				} else if (args[i].equalsIgnoreCase("-w") && ((i + 1) < args.length)) {
					final double weight = Double.valueOf(args[i + 1]);
					if (weight < 0) AHSP.printUsage();
					arguments.put(AHSP.Argument.WEIGHT, weight);
					i++;
				} else if (args[i].equalsIgnoreCase("-i") && ((i + 1) < args.length)) {
					final int level = Integer.valueOf(args[i + 1]);
					if (level < 0) AHSP.printUsage();
					arguments.put(AHSP.Argument.TRACE_LEVEL, level);
					i++;
				} else {
					AHSP.printUsage();
				}
			}
			if (arguments.get(AHSP.Argument.DOMAIN) == null
					|| arguments.get(AHSP.Argument.PROBLEM) == null) {
				AHSP.printUsage();
			}
		} catch (Throwable t) {
			AHSP.printUsage();
		}
		return arguments;
	}

	/**
	 * This method print the usage of the command-line planner.
	 */
	private static void printUsage() {
		System.out.println("\nusage of ahsp:\n");
		System.out.println("OPTIONS   DESCRIPTIONS\n");
		System.out.println("-o <str>    operator file name");
		System.out.println("-f <str>    fact file name");
		System.out.println("-w <num>    the weight used in the a star seach (preset: 1)");
		System.out.println("-t <num>    specifies the maximum CPU-time in seconds (preset: 300)");
		System.out.println("-u <num>    specifies the heuristic to used (preset: 0)");
		System.out.println("     0      ff heuristic");
		System.out.println("     1      sum heuristic");
		System.out.println("     2      sum mutex heuristic");
		System.out.println("     3      adjusted sum heuristic");
		System.out.println("     4      adjusted sum 2 heuristic");
		System.out.println("     5      adjusted sum 2M heuristic");
		System.out.println("     6      combo heuristic");
		System.out.println("     7      max heuristic");
		System.out.println("     8      set-level heuristic");
		System.out.println("-i <num>    run-time information level (preset: 1)");
		System.out.println("     0      nothing");
		System.out.println("     1      info on action number, search and plan");
		System.out.println("     2      1 + info on problem constants, types and predicates");
		System.out.println("     3      1 + 2 + loaded operators, initial and goal state");
		System.out.println("     4      1 + predicates and their inertia status");
		System.out.println("     5      1 + 4 + goal state and operators with unary inertia encoded");
		System.out.println("     6      1 + actions, initial and goal state after expansion of variables");
		System.out.println("     7      1 + final domain representation");
		System.out.println("     8      line representation:");
		System.out.println("               - problem name");
		System.out.println("               - number of operators");
		System.out.println("               - number of facts");
		System.out.println("               - preprocessing time in seconds");
		System.out.println("               - memory used for problem representation in MBytes");
		System.out.println("               - number of states explored");
		System.out.println("               - searching time in seconds");
		System.out.println("               - memory used for searching in MBytes");
		System.out.println("               - global memory used in MBytes");
		System.out.println("               - solution plan length");
		System.out.println("     > 100  1 + various debugging information");
		System.out.println("-h          print this message\n\n");
		System.exit(0);
	}

	/**
	 * This method return the default arguments of the planner.
	 * 
	 * @return the default arguments of the planner.
	 */
	private static Properties getDefaultArguments() {
		final Properties options = new Properties();
		options.put(AHSP.Argument.HEURISTIC_TYPE, AHSP.DEFAULT_HEURISTIC);
		options.put(AHSP.Argument.WEIGHT, AHSP.DEFAULT_WHEIGHT);
		options.put(AHSP.Argument.CPU_TIME, AHSP.DEFAULT_CPU_TIME * 1000);
		options.put(AHSP.Argument.TRACE_LEVEL, AHSP.DEFAULT_TRACE_LEVEL);
		return options;
	}
}