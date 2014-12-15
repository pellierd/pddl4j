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

import java.util.Arrays;
import java.util.List;

import pddl4j.preprocessing.CodedProblem;
import pddl4j.util.BitExp;
import pddl4j.util.BitOp;
import pddl4j.util.BitState;
import pddl4j.util.BitVector;
import pddl4j.util.CondBitExp;

/**
 * This abstract class implements the basic methods used by all heuristics based on the computation
 * of a relaxed planning graph ignoring negative effects. This implementation is based on the
 * implementation of the fast forward planner proposed by J. Hoffmann. The relaxed planning computed
 * does not compute mutual exclusion. To have more information about this implementation see
 * Hoffmann, J. and Nebel, B. (2001). The FF Planning System: Fast Plan Generation Through Heuristic
 * Search. Journal of Artificial Intelligence Research, 14(1):253-302.
 * 
 * @author Damien Pellier
 * @version 1.0 20.08.2010
 */
public abstract class RelaxedGraphHeuristic extends AbstractHeuristic {

	/**
	 * The array of unconditional operators of the problem.
	 */
	private int[][] unconditional_operators;

	/**
	 * The array used to store for each operator its number of preconditions
	 */
	private int[] precond_cardinality;

	/**
	 * The array used to store the first level of apparition of an operator.
	 */
	private int[] operators_level;

	/**
	 * The array used to store the number of precondition encountered for each operator.
	 */
	private int[] precond_counters;

	/**
	 * The array used to store the difficulty of the operators.
	 */
	private int[] operators_difficulty;

	/**
	 * The array used to store the apparition level of the positive propositions.
	 */
	private int[] p_prop_level;

	/**
	 * The array used to store the apparition level of the negative propositions.
	 */
	private int[] n_prop_level;

	/**
	 * The array used to store the preconditions' edges for each operator.
	 */
	private BitExp[] precond_edges;

	/**
	 * The array used to store the effects' edges for each operator.
	 */
	private BitExp[] effects_edges;

	/**
	 * The array used to store the preconditions of the operators.
	 */
	private BitExp[] preconditions;

	/**
	 * The array used to store the effects of the operators.
	 */
	private BitExp[] effects;

	/**
	 * The array used to store the unconditional effect of the operators.
	 */
	private BitExp[] unconditional_effects;

	/**
	 * The counter used to count the number of goal propositions reached.
	 */
	private int goal_counter;

	/**
	 * The number of goal propositions to reach.
	 */
	public int goal_cardinality;
	
	/**
	 * The level of the graph.
	 */
	private int level;
	
	/**
	 * Creates a new RelaxedGraphHeuristic heuristic.
	 * 
	 * @param problem the problem to be solved.
	 */
	protected RelaxedGraphHeuristic(final CodedProblem problem) {
		super(problem);
		// Get the number of relevant facts of the problem
		final int nb_relevant_facts = super.getRevelantFacts().size();
		// Get the number of operators of the problem
		final int nb_operators = super.getOperators().size();
		// Compute the number of unconditional operators
		int nb_uncond_operators = 0;
		final List<BitOp> operators = problem.getOperators();
		for (BitOp op : operators) {
			nb_uncond_operators += op.getCondEffects().size();
		}
		// Initialize the array that must contain the level of the positive propositions
		this.p_prop_level = new int[nb_relevant_facts];
		// Initialize the array that must contain the level of the negative propositions
		this.n_prop_level = new int[nb_relevant_facts];
		// Initialize the array that must contain the level of the operators
		this.operators_level = new int[nb_uncond_operators];
		// Initialize the array that must contain the difficulty of the operators
		this.operators_difficulty = new int[nb_uncond_operators];
		// Initialize the array that must contain for each operator the number of its precondition
		// reached
		this.precond_counters = new int[nb_uncond_operators];
		// Initialize the array that must contain for each operator its preconditions
		this.preconditions = new BitExp[nb_uncond_operators];
		// Initialize the array that must contain for each operator its effects
		this.effects = new BitExp[nb_uncond_operators];
		// Initialize the array that must contain for each operator its unconditional effects
		this.unconditional_effects = new BitExp[nb_operators];
		for (int i = 0; i < this.unconditional_effects.length; i++) {
			this.unconditional_effects[i] = new BitExp();
		}
		// The array that contains for each proposition the list of its unconditional operators
		this.unconditional_operators = new int[nb_uncond_operators][];
		// Initialize the array that must contain for each operator its preconditions' edges
		this.precond_edges = new BitExp[nb_relevant_facts];
		for (int i = 0; i < this.precond_edges.length; i++) {
			this.precond_edges[i] = new BitExp();
		}
		// Initialize the array that must contain for each operator its effects' edges
		this.effects_edges = new BitExp[nb_relevant_facts];
		for (int i = 0; i < this.effects_edges.length; i++) {
			this.effects_edges[i] = new BitExp();
		}
		// Initialize the number of proposition of the goal
		this.goal_cardinality = super.getGoal().cardinality();
		// The array that contains for each operator the number of propositions of its preconditions
		this.precond_cardinality = new int[nb_uncond_operators];

		// The index of the unconditional operators
		int uncond_op_index = 0;

		// Start enumerating the unconditional operators
		for (int op_index = 0; op_index < operators.size(); op_index++) {
			final BitOp op = operators.get(op_index);
			final List<CondBitExp> effects = op.getCondEffects();

			// For each conditional effect we create a new operator
			for (int ce_index = 0; ce_index < effects.size(); ce_index++) {
				final CondBitExp c_effect = effects.get(ce_index);
				final int[] eff = { op_index, ce_index };
				this.unconditional_operators[uncond_op_index] = eff;

				// We pre-compute the preconditions' edges
				final BitExp pre = new BitExp(op.getPreconditions());
				final BitVector p_pre = pre.getPositive();
				final BitVector n_pre = pre.getNegative();
				p_pre.or(c_effect.getCondition().getPositive());
				n_pre.or(c_effect.getCondition().getNegative());
				for (int p = p_pre.nextSetBit(0); p >= 0; p = p_pre.nextSetBit(p + 1)) {
					this.precond_edges[p].getPositive().set(uncond_op_index);
				}
				for (int p = n_pre.nextSetBit(0); p >= 0; p = n_pre.nextSetBit(p + 1)) {
					this.precond_edges[p].getNegative().set(uncond_op_index);
				}

				// We set the preconditions of the unconditional operator
				this.preconditions[uncond_op_index] = pre;

				// We pre-compute the effects' edges
				final BitExp effect = c_effect.getEffects();
				final BitVector p_eff = effect.getPositive();
				final BitVector n_eff = effect.getNegative();
				for (int p = p_eff.nextSetBit(0); p >= 0; p = p_eff.nextSetBit(p + 1)) {
					this.effects_edges[p].getPositive().set(uncond_op_index);
				}
				for (int p = n_eff.nextSetBit(0); p >= 0; p = n_eff.nextSetBit(p + 1)) {
					this.effects_edges[p].getNegative().set(uncond_op_index);
				}

				// We set the effects of the unconditional operator
				this.effects[uncond_op_index] = effect;

				// We initialize the number of precondition of the unconditional operator
				this.precond_cardinality[uncond_op_index] = pre.cardinality();

				// We initialize the unconditional effects of the operator
				if (c_effect.getCondition().isEmpty()) {
					final BitExp uncond_eff = this.unconditional_effects[op_index];
					final BitExp cond_eff = c_effect.getEffects();
					uncond_eff.getPositive().or(cond_eff.getPositive());
					uncond_eff.getNegative().or(cond_eff.getNegative());
				}

				// We increment the counter of unconditional operator
				uncond_op_index++;
			}
		}

		// A hack for the operator without precondition
		for (int i = 0; i < nb_uncond_operators; i++) {
			if (this.preconditions[i].isEmpty()) {
				for (BitExp p_edge : precond_edges) {
					p_edge.getPositive().set(i);
					p_edge.getNegative().set(i);
				}
			}
		}

	}

	/**
	 * Set the goal of the the relaxed problem to solve in order to compute the heuristic.
	 * 
	 * @param goal the goal.
	 * @throws NullPointerException if <code>goal == null</code>.
	 */
	protected final void setGoal(final BitExp goal) throws NullPointerException {
		super.setGoal(goal);
		this.goal_cardinality = goal.cardinality();
	}
	
	/**
	 * This method creates the relaxed planning graph from a specified initial state.
	 * 
	 * @param state the initial state of the relaxed planning graph.
	 * @return the level of the graph built.
	 */
	protected final int expandRelaxedPlanningGraph(final BitState state) {

		Arrays.fill(this.operators_level, Integer.MAX_VALUE);
		// The array that contains the level of the positive proposition apparition
		Arrays.fill(this.p_prop_level, Integer.MAX_VALUE);
		// The array that contains the level of the negative proposition apparition
		Arrays.fill(this.n_prop_level, Integer.MAX_VALUE);
		// The array that contains the counter of precondition encounter for each operator
		Arrays.fill(this.precond_counters, 0);
		// The array that contains the difficulty value for each operator
		Arrays.fill(this.operators_difficulty, Integer.MAX_VALUE);

		// The positive goal to reach
		final BitVector p_goal = super.getGoal().getPositive();
		// The negative goal to reach
		final BitVector n_goal = super.getGoal().getNegative();
		// The counter used to store the number of goal reach.
		this.goal_counter = 0;

		// The current level of the connectivity graph (the first level is 0)
		this.level = 0;
		// The bit vector used to store the positive propositions of the graph
		BitVector p_pk = new BitVector(state);
		// The bit vector used to store the negative propositions of the graph
		BitVector n_pk = new BitVector();
		n_pk.flip(0, super.getRevelantFacts().size());
		n_pk.andNot(state);
		// All positive goal of the initial state are set to appear at level 0
		for (int p = p_pk.nextSetBit(0); p >= 0; p = p_pk.nextSetBit(p + 1)) {
			this.p_prop_level[p] = 0;
			if (p_goal.get(p)) {
				this.goal_counter++;
			}
		}
		// All negative goal of the initial state are set to appear at level 0
		for (int p = n_pk.nextSetBit(0); p >= 0; p = n_pk.nextSetBit(p + 1)) {
			this.n_prop_level[p] = 0;
			if (n_goal.get(p)) {
				this.goal_counter++;
			}
		}

		// The positive accumulator used to store the set of positive proposition already reached
		final BitVector p_acc = new BitVector();
		// The negative accumulator used to store the set of negative proposition already reached
		final BitVector n_acc = new BitVector();

		// We start building the relaxed planning graph
		// The graph is expanded until the goal and the fixed point of the graph is not reached
		while (this.goal_counter != this.goal_cardinality && (!p_pk.isEmpty() || !n_pk.isEmpty())) {
			// A bit vector used to store the new operator to add
			final BitVector new_ops = new BitVector();
			// For each positive proposition of the proposition layer
			for (int p = p_pk.nextSetBit(0); p >= 0; p = p_pk.nextSetBit(p + 1)) {
				// We get the operator that have this positive proposition as precondition
				final BitVector p_edges = this.precond_edges[p].getPositive();
				// We mark the positive proposition p has explored
				p_acc.set(p);
				// We update the counter associated to the operator precondition
				for (int pe = p_edges.nextSetBit(0); pe >= 0; pe = p_edges.nextSetBit(pe + 1)) {
					// If the operator has a no-empty set of preconditions we increment its counter
					if (this.precond_cardinality[pe] != 0)
						this.precond_counters[pe]++;
					// Finally, if the all the preconditions of an operator hold we mark the
					// operator has new operator for the level
					if (this.precond_counters[pe] == this.precond_cardinality[pe]) {
						new_ops.set(pe);
					}
				}
			}
			// For each negative proposition of the proposition layer
			for (int p = n_pk.nextSetBit(0); p >= 0; p = n_pk.nextSetBit(p + 1)) {
				// We get the operator that have this positive proposition as precondition
				final BitVector n_edges = this.precond_edges[p].getNegative();
				// We mark the negative proposition p has explored
				n_acc.set(p);
				// We update the counter associated to the operator precondition
				for (int pe = n_edges.nextSetBit(0); pe >= 0; pe = n_edges.nextSetBit(pe + 1)) {
					// If the operator has a no-empty set of preconditions we increment its counter
					if (this.precond_cardinality[pe] != 0)
						this.precond_counters[pe]++;
					// Finally, if the all the preconditions of an operator hold we mark the
					// operator has new operator for the level
					if (this.precond_counters[pe] == this.precond_cardinality[pe]) {
						new_ops.set(pe);
					}
				}
			}
			// The bit vector used to the store the new positive proposition at the next level
			final BitVector p_new_props = new BitVector();
			// The bit vector used to the store the new negative proposition at the next level
			final BitVector n_new_props = new BitVector();
			// For each new operator at level k
			for (int o = new_ops.nextSetBit(0); o >= 0; o = new_ops.nextSetBit(o + 1)) {
				// We mark o as appearing at the level k
				this.operators_level[o] = this.level;
				// We accumulate the positive effects of o for the next proposition level k
				p_new_props.or(this.effects[o].getPositive());
				// We accumulate the negative effects of o for the next proposition level k
				n_new_props.or(this.effects[o].getNegative());
				// Then we compute the difficulty of operator as the sum of the level of their
				// preconditions
				this.operators_difficulty[o] = 0;
				// First the sum of the positive preconditions
				final BitVector p_pre = this.preconditions[o].getPositive();
				for (int p = p_pre.nextSetBit(0); p >= 0; p = p_pre.nextSetBit(p + 1)) {
					this.operators_difficulty[o] += this.p_prop_level[p];
				}
				// First the sum of the negative preconditions
				final BitVector n_pre = this.preconditions[o].getNegative();
				for (int p = n_pre.nextSetBit(0); p >= 0; p = n_pre.nextSetBit(p + 1)) {
					this.operators_difficulty[o] += this.n_prop_level[p];
				}
			}

			// Now, we compute the new proposition level just by adding positive and negative
			// propositions that was not yet encounter in the planning graph
			p_pk = p_new_props;
			n_pk = n_new_props;
			p_pk.andNot(p_acc);
			n_pk.andNot(n_acc);

			// We increment the counter level
			this.level++;
			// For each positive new proposition we set its level to k + 1
			for (int p = p_pk.nextSetBit(0); p >= 0; p = p_pk.nextSetBit(p + 1)) {
				this.p_prop_level[p] = this.level;
				// Update the goal counter if a positive goal proposition is reached
				if (p_goal.get(p)) {
					this.goal_counter++;
				}
			}
			// For each positive new proposition we set its level to k + 1
			for (int p = n_pk.nextSetBit(0); p >= 0; p = n_pk.nextSetBit(p + 1)) {
				this.n_prop_level[p] = this.level;
				// Update the goal counter if a negative goal proposition is reached
				if (n_goal.get(p)) {
					this.goal_counter++;
				}
			}
		}
		return this.level;
	}

	/**
	 * Returns <code>true</code> if the goal is reachable after the planning graph expansion.
	 * 
	 * @return <code>true</code> if the goal is reachable after the planning graph expansion;
	 *         <code>false</code> otherwise.
	 */
	protected final boolean isGoalReachable() {
		return this.goal_cardinality == this.goal_counter;
	}

	/**
	 * Compute the sum heuristic.
	 * 
	 * @return the sum heuristic value.
	 * @see pddl4j.heuristics.Sum
	 */
	protected final int getSumValue() {
		int value = 0;
		final BitVector p_goal = super.getGoal().getPositive();
		final BitVector n_goal = super.getGoal().getNegative();
		for (int g = p_goal.nextSetBit(0); g >= 0; g = p_goal.nextSetBit(g + 1)) {
			value += this.p_prop_level[g];
		}
		for (int g = n_goal.nextSetBit(0); g >= 0; g = n_goal.nextSetBit(g + 1)) {
			value += this.n_prop_level[g];
		}
		return value;
	}

	/**
	 * Compute the max heuristic.
	 * 
	 * @return max heuristic value.
	 * @see pddl4j.heuristics.Max
	 */
	protected final int getMaxValue() {
		int max = Integer.MIN_VALUE;
		final BitVector p_goal = super.getGoal().getPositive();
		final BitVector n_goal = super.getGoal().getNegative();
		for (int g = p_goal.nextSetBit(0); g >= 0; g = p_goal.nextSetBit(g + 1)) {
			final int gl = this.p_prop_level[g];
			if (gl > max)
				max = gl;
		}
		for (int g = n_goal.nextSetBit(0); g >= 0; g = n_goal.nextSetBit(g + 1)) {
			final int gl = this.n_prop_level[g];
			if (gl > max)
				max = gl;
		}
		return max;
	}

	/**
	 * Compute the relaxed plan heuristic value.
	 * 
	 * @return the relaxed plan heuristic value.
	 * @see pddl4j.heuristics.FastForward
	 */
	protected final int getRelaxedPlanValue() {
		// The integer used to counter the number of actions of the relaxed plan
		int value = 0;

		// We initialize the for each level of the graph the goal to reach
		final BitExp[] goals = new BitExp[this.level + 1];
		for (int k = 0; k <= this.level; k++) {
			goals[k] = new BitExp();
		}
		final BitVector p_goal = super.getGoal().getPositive();
		final BitVector n_goal = super.getGoal().getNegative();
		for (int g = p_goal.nextSetBit(0); g >= 0; g = p_goal.nextSetBit(g + 1)) {
			goals[this.p_prop_level[g]].getPositive().set(g);
		}
		for (int g = n_goal.nextSetBit(0); g >= 0; g = n_goal.nextSetBit(g + 1)) {
			goals[this.n_prop_level[g]].getNegative().set(g);
		}

		// We start the extraction of the relaxed plan
		for (int k = level; k > 0; k--) {
			// goals at level k
			final BitExp gk = goals[k];
			final BitVector p_gk = gk.getPositive();
			final BitVector n_gk = gk.getNegative();
			// goals at level k - 1
			final BitExp gk_1 = goals[k - 1];
			final BitVector p_gk_1 = gk_1.getPositive();
			final BitVector n_gk_1 = gk_1.getNegative();
			// Each positive goal at level k we need to find a resolver to support it
			for (int p_g = p_gk.nextSetBit(0); p_g >= 0; p_g = p_gk.nextSetBit(p_g + 1)) {
				// Select the best resolver according to the difficulty heuristic
				final int resolver_index = this.select(this.effects_edges[p_g].getPositive(), k);
				if (resolver_index != -1) {
					final BitExp pre = this.preconditions[resolver_index];
					final BitVector p_pre = pre.getPositive();
					for (int p = p_pre.nextSetBit(0); p >= 0; p = p_pre.nextSetBit(p + 1)) {
						final int p_level = this.p_prop_level[p];
						if (p_level != 0 && !p_gk_1.get(p)) {
							goals[p_level].getPositive().set(p);
						}
					}
					final BitVector n_pre = pre.getNegative();
					for (int p = n_pre.nextSetBit(0); p >= 0; p = n_pre.nextSetBit(p + 1)) {
						final int p_level = this.n_prop_level[p];
						if (p_level != 0 && !n_gk_1.get(p)) {
							goals[p_level].getNegative().set(p);
						}
					}
					// Get the effects of the operator marked them as true
					final BitExp effect = this.effects[resolver_index];
					final BitVector p_effect = effect.getPositive();
					final BitVector n_effect = effect.getNegative();
					p_gk_1.andNot(p_effect);
					n_gk_1.andNot(n_effect);
					p_gk.andNot(p_effect);
					n_gk.andNot(n_effect);
					// We increment the number of action of the relaxed plan
					value++;
				} else { // NOOP case
					p_gk_1.clear(p_g);
					p_gk.clear(p_g);
				}
			}			
			// Each negative goal at level k we need to find a resolver to support it
			for (int n_g = n_gk.nextSetBit(0); n_g >= 0; n_g = n_gk.nextSetBit(n_g + 1)) {
				final int resolver_index = this.select(this.effects_edges[n_g].getNegative(), k);
				if (resolver_index != -1) {
					final BitExp pre = this.preconditions[resolver_index];
					final BitVector p_pre = pre.getPositive();
					for (int p = p_pre.nextSetBit(0); p >= 0; p = p_pre.nextSetBit(p + 1)) {
						final int p_level = this.p_prop_level[p];
						if (p_level != 0 && !p_gk_1.get(p)) {
							goals[p_level].getPositive().set(p);
						}
					}
					final BitVector n_pre = pre.getNegative();
					for (int p = n_pre.nextSetBit(0); p >= 0; p = n_pre.nextSetBit(p + 1)) {
						final int p_level = this.n_prop_level[p];
						if (p_level != 0 && !n_gk_1.get(p)) {
							goals[p_level].getNegative().set(p);
						}
					}
					// Get the effects of the operator marked them as true
					final BitExp effect = this.effects[resolver_index];
					final BitVector p_effect = effect.getPositive();
					final BitVector n_effect = effect.getNegative();
					p_gk_1.andNot(p_effect);
					n_gk_1.andNot(n_effect);
					p_gk.andNot(p_effect);
					n_gk.andNot(n_effect);
					// We increment the number of action of the relaxed plan
					value++;
				} else { // NOOP case
					n_gk_1.set(n_g);
					n_gk.clear(n_g);
				}
			}
		}
		return value;
	}

	/**
	 * Select an effect according to the unconditional operators difficulty heuristic. The question
	 * is, which achiever should be choose when no NOOP is available ? It is certainly a good idea
	 * to select an achiever whose preconditions seems to be "easy". From the graph building phase,
	 * we can obtain a simple measure for the operators_difficulty of an action's preconditions as
	 * follows:
	 * <ul>
	 * <li>operators_difficulty(o) := SUM_ID(min { i | p is member of the fact layer at time i }) with
	 * p in pre(o)</li>
	 * </ul>
	 * The operators_difficulty of each action can be set when it is first inserted into the graph.
	 * During plan extraction, facing a fact for which no NOOP is available, we then simply selected
	 * an achieving action with minimal operators_difficulty. This heuristic works well in situation
	 * where there are severals ways to achieve one fact. but some ways need less effort than
	 * others.
	 * 
	 * @param resolvers the list of resolver of p.
	 * @param k the level.
	 * @return the easier resolver for the proposition <code>p</code> at level <code>k</code> or
	 *         <code>null</code> if a NOOP operator is available.
	 */
	private int select(final BitVector resolvers, final int k) {
		int resolver = -1;
		int min_difficulty = Integer.MAX_VALUE;
		for (int r = resolvers.nextSetBit(0); r >= 0; r = resolvers.nextSetBit(r + 1)) {
			if (this.operators_level[r] < k) {
				final int difficulty = this.operators_difficulty[r];
				if (difficulty < min_difficulty) {
					min_difficulty = difficulty;
					resolver = r;
				}
			}
		}
		return resolver;
	}

}
