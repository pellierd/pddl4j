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

package pddl4j.heuristics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

import pddl4j.preprocessing.CodedProblem;
import pddl4j.util.BitExp;
import pddl4j.util.BitMatrix;
import pddl4j.util.BitOp;
import pddl4j.util.BitState;
import pddl4j.util.BitVector;
import pddl4j.util.CondBitExp;
import pddl4j.util.IntExp;

/**
 * This abstract class implements the basic methods used by all heuristics based on the computation
 * of a planning graph with mutual exclusions. 
 * <p>
 * This implementation is based on the implementation of
 * the STAN planner proposed D. Long and M. Fox. To have more information about this implementation
 * see D. Long, M. Fox (1999). Efficient Implementation of the Plan Graph in STAN. Journal of
 * Artificial Intelligence Research, 10(1):87-115.
 * 
 * @author Damien Pellier
 * @version 1.0 20.08.2010
 */
public abstract class GraphHeuristic extends AbstractHeuristic {

	/**
	 * The array used to store the apparition level of the propositions.
	 */
	private int[] propositions_level;

	/**
	 * The array used to store the preconditions of the operators.
	 */
	private BitVector[] preconditions;

	/**
	 * The array used to store the effects of the operators.
	 */
	private BitVector[] effects;

	/**
	 * The dependences between the actions.
	 */
	private BitMatrix operators_dependences;

	/**
	 * The list of operators mutual exclusions of the planning graph stored by level.
	 */
	private List<BitMatrix> operators_mutex;

	/**
	 * The list of propositions mutual exclusions of the planning graph stored by level.
	 */
	private List<BitMatrix> propositions_mutex;

	/**
	 * The bit vector that contains the goal of the planning problem.
	 */
	private BitVector bvgoal;

	/**
	 * The bit vector that represents the propositions layer of the planning graph.
	 */
	private BitVector props_layer;

	/**
	 * The bit vector that represents the operators layer of the planning graph.
	 */
	private BitVector ops_layer;

	/**
	 * The array that contains the string representation of the propositions. This array can be used
	 * only if the debug flag is true.
	 */
	private String[] propositions;

	/**
	 * The array that contains the string representation of the operators. This array can be used
	 * only if the debug flag is true.
	 */
	private String[] operators;
	
	/**
	 * The flag used to indicate if the goal is reached after the expansion of the planning graph.
	 */
	private boolean goal_reached;
	
	/**
	 * The flag used to indicate if the planning graph has reached its level off.
	 */
	private boolean level_off;
	
	/**
	 * The list that contains for each level and for each proposition which operators produce it.
	 */
	private List<BitMatrix> achievers;

	/**
	 * The number of propositions of the problem.
	 */
	private int nb_propositions;
	
	/**
	 * The number of operators of the problem.
	 */
	private int nb_operators;
	
	/**
	 * The index of first negative propositions.
	 */
	private int neg_offset;
	
	/**
	 * The bit vector used to store the new operators during the planning graph expansion.
	 */
	private BitVector new_operators;

	/**
	 * The flag used to debug.
	 */
	private boolean debug;

	/**
	 * Creates a new RelaxedGraphHeuristic heuristic.
	 * 
	 * @param problem the problem to be solved.
	 */
	protected GraphHeuristic(final CodedProblem problem) {
		super(problem);
		this.debug = false;

		// Get the number of relevant facts of the problem
		this.neg_offset = super.getRevelantFacts().size();

		// The number of propositions of the problem
		this.nb_propositions = this.neg_offset * 2;

		// If debug flag is true we compute the string representation of the problem propositions
		if (this.debug) {
			// The array that contains string representation of the problem propositions
			this.propositions = new String[this.nb_propositions];
			for (int i = 0; i < this.neg_offset; i++) {
				IntExp prop = super.getRevelantFacts().get(i);
				this.propositions[i] = problem.toString(prop);
				this.propositions[i + this.neg_offset] = "(not " + this.propositions[i] + ")";
			}
		}

		// Compute the number of unconditional operators of the problem
		this.nb_operators = this.nb_propositions;
		final List<BitOp> operators = problem.getOperators();
		for (BitOp op : operators) {
			this.nb_operators += op.getCondEffects().size();
		}

		// If debug flag is true we create the array that contains the string representation of the
		// unconditional operators of the planning problem
		if (debug) {
			this.operators = new String[this.nb_operators];
		}

		// Initialize the two arrays that wil contain the preconditions and the effects of the
		// unconditional operators of the planning problem
		this.preconditions = new BitVector[this.nb_operators];
		this.effects = new BitVector[this.nb_operators];

		// Create the NOOP operators
		for (int i = 0; i < this.neg_offset; i++) {

			// Positive NOOP actions
			final IntExp proposition = super.getRevelantFacts().get(i);
			if (debug) {
				this.operators[i] = "noop(" + problem.toString(proposition) + ")";
			}
			final BitVector precond = new BitVector();
			precond.set(i);
			this.preconditions[i] = precond;
			final BitVector effect = new BitVector();
			effect.set(i);
			this.effects[i] = effect;

			// Negative NOOP action
			int neg_i = i + this.neg_offset;
			if (debug) {
				this.operators[neg_i] = "noop(not (" + problem.toString(proposition)+ "))";
			}
			final BitVector neg_precond = new BitVector();
			neg_precond.set(neg_i);
			this.preconditions[neg_i] = neg_precond;
			final BitVector neg_effect = new BitVector();
			neg_effect.set(neg_i);
			this.effects[neg_i] = neg_effect;
		}

		// Start enumerating the unconditional ops_layer
		int uncond_op_index = this.nb_propositions;
		for (int op_index = 0; op_index < operators.size(); op_index++) {
			final BitOp op = operators.get(op_index);
			final List<CondBitExp> effects = op.getCondEffects();
			// For each conditional effect we create a new operator
			for (int ce_index = 0; ce_index < effects.size(); ce_index++) {
				final CondBitExp c_effect = effects.get(ce_index);
				if (debug) {
					this.operators[uncond_op_index] = "(" + problem.toShortString(op) + ")_" + ce_index;
				}
				final BitVector precond = new BitVector();
				precond.or(op.getPreconditions().getPositive());
				precond.or(c_effect.getCondition().getPositive());
				BitVector neg = op.getPreconditions().getNegative();
				for (int p = neg.nextSetBit(0); p >= 0; p = neg.nextSetBit(p + 1)) {
					precond.set(p + this.neg_offset);
				}
				neg = c_effect.getCondition().getNegative();
				for (int p = neg.nextSetBit(0); p >= 0; p = neg.nextSetBit(p + 1)) {
					precond.set(p + this.neg_offset);
				}
				this.preconditions[uncond_op_index] = precond;
				final BitVector effect = new BitVector();
				effect.or(c_effect.getEffects().getPositive());
				neg = c_effect.getEffects().getNegative();
				for (int p = neg.nextSetBit(0); p >= 0; p = neg.nextSetBit(p + 1)) {
					effect.set(p + this.neg_offset);
				}
				this.effects[uncond_op_index] = effect;
				uncond_op_index++;
			}
		}

		// Set the goal to the state representation
		this.bvgoal = new BitVector();
		this.bvgoal.or(super.getGoal().getPositive());
		final BitVector neg = super.getGoal().getNegative();
		for (int p = neg.nextSetBit(0); p >= 0; p = neg.nextSetBit(p + 1)) {
			this.bvgoal.set(p + this.neg_offset);
		}

		// Compute static dependence between operators
		this.operators_dependences = new BitMatrix(this.nb_operators);
		for (int i = 0; i < this.nb_operators; i++) {
			for (int j = 0; j < this.nb_operators; j++) {
				if (i > j && this.areDependent(i, j)) {
					this.operators_dependences.set(i, j);
					this.operators_dependences.set(j, i);
				}
			}
		}

		// Initialize the array that must contain the level of the positive props_layer
		this.propositions_level = new int[this.nb_propositions];
		// Initialize the array that must contain propositions mutex
		this.propositions_mutex = new ArrayList<BitMatrix>();
		// Initialize the array that must contain operators mutex
		this.operators_mutex = new ArrayList<BitMatrix>();
		// Initialize the array that must contain achievers
		this.achievers = new ArrayList<BitMatrix>();
		// The bit vector that is used to store the new operators during expansion
		this.new_operators = new BitVector();
	}
	
	/**
	 * Set the goal of the problem to solve in order to compute the heuristic.
	 * 
	 * @param goal the goal.
	 * @throws NullPointerException if <code>goal == null</code>.
	 */
	protected final void setGoal(final BitExp goal) throws NullPointerException {
		super.setGoal(goal);
		// Set the goal to the state representation
		this.bvgoal = new BitVector();
		this.bvgoal.or(super.getGoal().getPositive());
		final BitVector neg = goal.getNegative();
		for (int p = neg.nextSetBit(0); p >= 0; p = neg.nextSetBit(p + 1)) {
			this.bvgoal.set(p + this.neg_offset);
		}
	}
	
	/**
	 * This method creates the relaxed planning graph from a specified initial state.
	 * 
	 * @param state the initial state of the relaxed planning graph.
	 * @return the level of the graph built.
	 */
	protected final int expandPlanningGraph(final BitState state) {

		// The array that contains the level of the positive proposition apparition
		Arrays.fill(this.propositions_level, Integer.MAX_VALUE);

		// Initialize the initial props_layer level of the planning graph
		this.props_layer = new BitVector();
		this.props_layer.or(state);

		// Initialize the first proposition level with the specified state
		this.props_layer.flip(this.neg_offset, this.nb_propositions);
		for (int p = state.nextSetBit(0); p >= 0; p = state.nextSetBit(p + 1)) {
			this.props_layer.clear(p + this.neg_offset);
		}
		for (int p = this.props_layer.nextSetBit(0); p >= 0; p = this.props_layer.nextSetBit(p + 1)) {
			this.propositions_level[p] = 0;
		}

		// Initialize the initial actions level of the planning graph
		this.ops_layer = new BitVector();

		// The current level of the planning graph (the first level is 0)
		int k = 0;
		// Initialize the propositions mutex at level with an empty bit matrix
		this.propositions_mutex.add(new BitMatrix(this.nb_propositions));

		// Initialize the boolean flag used to indicate if the goal is reached to false
		this.goal_reached = false;
		// Initialize the boolean flag used to indicate if level of the graph is off to false
		this.level_off = false;

		// Start the expansion of the planning graph
		while (!this.goal_reached && !this.level_off) {
			this.level_off = true;
			// Update the achiever of the level by adding achiever at previous level
			final BitMatrix achievers = new BitMatrix(this.nb_propositions, this.nb_operators);
			this.achievers.add(achievers);
			if (k > 0) {
				final BitMatrix ak_1 = this.achievers.get(k - 1);
				for (int p = 0; p < this.nb_propositions; p++) {
					achievers.getRow(p).or(ak_1.getRow(p));
				}
			}
			// Clear the bit vector that will contain the operator to add at the next level
			this.new_operators.clear();
			// Initialize the bit vector that will contain the propositions to add at the next level
			final BitVector new_propositions = new BitVector();
			// Add the NOOP operators
			this.ops_layer.or(this.props_layer);
			// try only the operator not already in the planning graph
			for (int op = this.ops_layer.nextClearBit(this.nb_propositions); op > 0
					&& op < this.nb_operators; op = this.ops_layer.nextClearBit(op + 1)) {
				if (this.props_layer.include(this.preconditions[op])
						&& this.isMutexFree(this.preconditions[op], k)) {
					this.ops_layer.set(op);
					new_operators.set(op);
					final BitVector effects = this.effects[op];
					new_propositions.or(effects);
					// Update the achiever to speed up the mutex computation
					for (int p = effects.nextSetBit(0); p >= 0; p = effects.nextSetBit(p + 1)) {
						achievers.set(p, op);
					}
					// If an operator is added so the graph is not level off
					this.level_off = false;
				}
			}

			// Add the new effects of the applicable operator to the propositions layer
			this.props_layer.or(new_propositions);
			// Update the level of the new propositions
			for (int p = new_propositions.nextSetBit(0); p >= 0; p = new_propositions
					.nextSetBit(p + 1)) {
				if (this.propositions_level[p] == Integer.MAX_VALUE) {
					this.propositions_level[p] = k;
				}
			}
			// Update the operators mutexes at level k
			this.updateOperatorsMutex(k);
			// Update the propositions mutexes at level k + 1
			this.updatePropositionsMutex(k + 1);
			// Increment the level of the planning graph
			k++;
			// Check if the goal is reached
			this.goal_reached = (this.props_layer.include(this.bvgoal) && this.isMutexFree(this.bvgoal,
					k));
		}
		return k;
	}

	/**
	 * Updates the propositions mutex at a specified level of the planning graph.
	 * 
	 * @param k the level.
	 */
	private void updatePropositionsMutex(final int k) {
		this.propositions_mutex.add(new BitMatrix(this.nb_propositions));
		final BitMatrix pm_k = new BitMatrix(nb_propositions);
		final BitMatrix pmk_1 = this.propositions_mutex.get(k - 1);
		this.propositions_mutex.add(pm_k);
		for (int pi = this.props_layer.nextSetBit(0); pi >= 0; pi = this.props_layer
				.nextSetBit(pi + 1)) {
			for (int pj = this.props_layer.nextSetBit(0); pj >= 0; pj = this.props_layer
					.nextSetBit(pj + 1)) {
				if (pi > pj && this.arePropositionsMutex(pi, pj, k)) {
					pm_k.set(pi, pj);
					pm_k.set(pj, pi);
				}
			}
		}
		this.level_off = pm_k.equals(pmk_1);
	}

	/**
	 * Updates the operators mutex at a specified level of the planning graph.
	 * 
	 * @param k the level.
	 */
	private void updateOperatorsMutex(final int k) {
		if (k > 1) {
			// Update the old mutex first
			final BitMatrix omk = new BitMatrix(this.nb_operators);
			this.operators_mutex.add(omk);
			final BitMatrix omk_1 = this.operators_mutex.get(k - 1);
			for (int oi = this.ops_layer.nextSetBit(0); oi >= 0; oi = this.ops_layer
					.nextSetBit(oi + 1)) {
				for (int oj = this.ops_layer.nextSetBit(0); oj >= 0; oj = this.ops_layer
						.nextSetBit(oj + 1)) {
					if (oi > oj && omk_1.get(oi, oj) && this.areOperatorsMutex(oi, oj, k)) {
						omk.set(oi, oj);
						omk.set(oj, oi);
					} else {
						this.level_off = false;
					}
				}
			}
			// then update the mutex of the new operators
			for (int oi = this.new_operators.nextSetBit(0); oi >= 0; oi = this.new_operators
					.nextSetBit(oi + 1)) {
				for (int oj = this.ops_layer.nextSetBit(0); oj >= 0; oj = this.ops_layer
						.nextSetBit(oj + 1)) {
					if (oi > oj && this.areOperatorsMutex(oi, oj, k)) {
						omk.set(oi, oj);
						omk.set(oj, oi);
						this.level_off = false;
					}
				}
			}
		} else { // Special case of the level k
			final BitMatrix omk = new BitMatrix(this.nb_operators);
			this.operators_mutex.add(omk);
			for (int oi = this.ops_layer.nextSetBit(0); oi >= 0; oi = this.ops_layer
					.nextSetBit(oi + 1)) {
				for (int oj = this.ops_layer.nextSetBit(0); oj >= 0; oj = this.ops_layer
						.nextSetBit(oj + 1)) {
					if (oi > oj && this.areOperatorsMutex(oi, oj, k)) {
						omk.set(oi, oj);
						omk.set(oj, oi);
						this.level_off = false;
					}
				}
			}
		}
	}

	/**
	 * Computes the sum heuristic.
	 * 
	 * @return the sum heuristic value.
	 * @see pddl4j.heuristics.Sum
	 */
	protected final int getSumValue() {
		int value = 0;
		for (int p = this.bvgoal.nextSetBit(0); p >= 0; p = this.bvgoal.nextSetBit(p + 1)) {
			value += this.propositions_level[p];
		}
		return value;
	}

	/**
	 * Returns <code>true</code> if two operator are mutex at a specified level. Two ops_layer are
	 * mutex if the ops_layer are dependent or an operator has a mutex precondition at level k;
	 * 
	 * @param oi the first fact.
	 * @param oj the second fact.
	 * @param k the level where the test must be done.
	 * @return <code>true</code> if two operator are mutex at a specified level;
	 *         <code>false</code> otherwise.
	 */
	private boolean areOperatorsMutex(final int oi, final int oj, final int k) {
		if (k == 0)
			return this.operators_dependences.get(oi, oj);
		if (!this.operators_dependences.get(oi, oj)) {
			boolean mutex = false;
			final BitVector ppi = this.preconditions[oi];
			final BitVector ppj = this.preconditions[oj];
			final BitMatrix mk = this.propositions_mutex.get(k);
			int mi = ppi.nextSetBit(0);
			while (mi >= 0 && !mutex) {
				mutex = mk.getRow(mi).intersects(ppj);
				mi = ppi.nextSetBit(mi + 1);
			}
			return mutex;
		}
		return true;
	}

	/**
	 * Returns <code>true</code> if two facts are mutex at a specified level. Two facts are mutex
	 * if at least one operator that produce the facts are mutex in the previous level k - 1.
	 * 
	 * @param pi the first fact.
	 * @param pj the second fact.
	 * @param k the level where the test must be done.
	 * @return <code>true</code> if two facts are mutex at a specified level; <code>false</code>
	 *         otherwise.
	 */
	private boolean arePropositionsMutex(final int pi, final int pj, final int k) {
		boolean mutex = (pj == (pi + super.getRevelantFacts().size()));
		if (!mutex && k > 0) {
			final BitMatrix ak = this.achievers.get(k - 1);
			final BitSet rak = ak.getRow(pi);
			final BitSet rbk = ak.getRow(pj);
			// Test if there is one operator that produce pi and pj
			if (rak.intersects(rbk))
				return false;
			final BitMatrix mak = this.operators_mutex.get(k - 1);
			mutex = true;
			int ra = rak.nextSetBit(0);
			while (ra >= 0 && mutex) {
				int rb = rbk.nextSetBit(0);
				while (rb >= 0 && mutex) {
					mutex = mak.get(ra, rb);
					rb = rbk.nextSetBit(rb + 1);
				}
				ra = rak.nextSetBit(ra + 1);
			}
		}
		return mutex;
	}

	/**
	 * Returns <code>true</code> if a set of facts is mutex free in a specified proposition level
	 * of the planning graph.
	 * 
	 * @param state the facts to be tested.
	 * @param k the level of the graph at which the test is done.
	 * @return <code>true</code> if a set of facts is mutex free in a specified proposition level
	 *         of the planning graph, <code>false</code> otherwise.
	 */
	private boolean isMutexFree(final BitVector state, final int k) {
		boolean free = true;
		final BitMatrix mk = this.propositions_mutex.get(k);
		int i = state.nextSetBit(0);
		while (i >= 0 && free) {
			free = !mk.getRow(i).intersects(state);
			i = state.nextSetBit(i + 1);
		}
		return free;
	}

	/**
	 * Returns <code>true</code> if two ops_layer are dependent, i.e, if an operator delete an
	 * precondition or an add effect of the other.
	 * 
	 * @param oi The first operator.
	 * @param oj The second operator
	 * @return <code>true</code> if two ops_layer are dependent, <code>false</code> otherwise.
	 */
	private boolean areDependent(final int oi, final int oj) {
		final BitVector eff_oi = this.effects[oi];
		final BitVector eff_oj = this.effects[oj];
		final BitVector pre_oi = this.preconditions[oi];
		final BitVector pre_oj = this.preconditions[oj];
		return !this.areConsistantStates(eff_oi, eff_oj)
				|| !this.areConsistantStates(eff_oi, pre_oj)
				|| !this.areConsistantStates(eff_oj, pre_oi)
				|| !this.areConsistantStates(pre_oi, pre_oj);
	}

	/**
	 * Returns <code>true</code> if two states are consistent.
	 * 
	 * @param s1 The first state.
	 * @param s2 The second state.
	 * @return <code>true</code> if two states are consistent; <code>false</code> otherwise.
	 */
	private boolean areConsistantStates(BitVector s1, BitVector s2) {
		final BitVector state = new BitVector(s1);
		state.or(s2);
		final int offset = super.getRevelantFacts().size();
		for (int p = state.nextSetBit(0); p >= 0 && p < offset; p = state.nextSetBit(p + 1)) {
			if (state.get(p + offset))
				return false;
		}
		return true;
	}

	/**
	 * Return <code>true</code> if the goal is reached in the last proposition level of the
	 * expanded planning graph.
	 * 
	 * @return <code>true</code> if the goal is reached in the last proposition level of the
	 *         expanded planning graph; <code>false</code> otherwise.
	 */
	protected final boolean isGoalReachable() {
		return this.goal_reached;
	}
}
