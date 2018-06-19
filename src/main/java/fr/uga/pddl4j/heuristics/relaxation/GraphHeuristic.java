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

package fr.uga.pddl4j.heuristics.relaxation;

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.util.BitExp;
import fr.uga.pddl4j.util.BitMatrix;
import fr.uga.pddl4j.util.BitOp;
import fr.uga.pddl4j.util.BitState;
import fr.uga.pddl4j.util.BitVector;
import fr.uga.pddl4j.util.CondBitExp;
import fr.uga.pddl4j.util.IntExp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * This abstract class implements the basic methods used by all heuristics based on the computation
 * of a planning graph with mutual exclusions.
 * <p>
 * This implementation is based on the implementation of
 * the STAN planner proposed D. Long and M. Fox. To have more information about this implementation
 * see D. Long, M. Fox (1999). Efficient Implementation of the Plan Graph in STAN. Journal of
 * Artificial Intelligence Research, 10(1):87-115.
 * </p>
 *
 * @author Damien Pellier
 * @version 1.0 20.08.2010
 */
public abstract class GraphHeuristic extends AbstractHeuristic {

    /**
     * The serial version id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The array used to store the apparition level of the propositions.
     */
    private int[] propositionsLevel;

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
    private BitMatrix operatorsDependences;

    /**
     * The list of operators mutual exclusions of the planning graph stored by level.
     */
    private List<BitMatrix> operatorsMutex;

    /**
     * The list of propositions mutual exclusions of the planning graph stored by level.
     */
    private List<BitMatrix> propositionsMutex;

    /**
     * The bit vector that contains the goal of the planning problem.
     */
    private BitVector bvgoal;

    /**
     * The bit vector that represents the propositions layer of the planning graph.
     */
    private BitVector propsLayer;

    /**
     * The bit vector that represents the operators layer of the planning graph.
     */
    private BitVector opsLayer;

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
    private boolean goalReached;

    /**
     * The flag used to indicate if the planning graph has reached its level off.
     */
    private boolean levelOff;

    /**
     * The list that contains for each level and for each proposition which operators produce it.
     */
    private List<BitMatrix> achievers;

    /**
     * The number of propositions of the problem.
     */
    private int nbPropositions;

    /**
     * The number of operators of the problem.
     */
    private int nbOperators;

    /**
     * The index of first negative propositions.
     */
    private int negOffset;

    /**
     * The bit vector used to store the new operators during the planning graph expansion.
     */
    private BitVector newOperators;

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
        this.negOffset = super.getRevelantFacts().size();

        // The number of propositions of the problem
        this.nbPropositions = this.negOffset * 2;

        // If debug flag is true we compute the string representation of the problem propositions
        if (this.debug) {
            // The array that contains string representation of the problem propositions
            this.propositions = new String[this.nbPropositions];
            for (int i = 0; i < this.negOffset; i++) {
                IntExp prop = super.getRevelantFacts().get(i);
                this.propositions[i] = problem.toString(prop);
                this.propositions[i + this.negOffset] = "(not " + this.propositions[i] + ")";
            }
        }

        // Compute the number of unconditional operators of the problem
        this.nbOperators = this.nbPropositions;
        final List<BitOp> pbOperators = problem.getOperators();
        for (BitOp op : pbOperators) {
            this.nbOperators += op.getCondEffects().size();
        }

        // If debug flag is true we create the array that contains the string representation of the
        // unconditional operators of the planning problem
        if (debug) {
            this.operators = new String[this.nbOperators];
        }

        // Initialize the two arrays that wil contain the preconditions and the effects of the
        // unconditional operators of the planning problem
        this.preconditions = new BitVector[this.nbOperators];
        this.effects = new BitVector[this.nbOperators];

        // Create the NOOP operators
        for (int i = 0; i < this.negOffset; i++) {

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
            int negI = i + this.negOffset;
            if (debug) {
                this.operators[negI] = "noop(not (" + problem.toString(proposition) + "))";
            }
            final BitVector negPrecond = new BitVector();
            negPrecond.set(negI);
            this.preconditions[negI] = negPrecond;
            final BitVector negEffect = new BitVector();
            negEffect.set(negI);
            this.effects[negI] = negEffect;
        }

        // Start enumerating the unconditional opsLayer
        int uncondOpIndex = this.nbPropositions;
        for (final BitOp op : pbOperators) {
            final List<CondBitExp> condEffects = op.getCondEffects();
            // For each conditional effect we create a new operator
            for (int ceIndex = 0; ceIndex < condEffects.size(); ceIndex++) {
                final CondBitExp cEffect = condEffects.get(ceIndex);
                if (debug) {
                    this.operators[uncondOpIndex] = "(" + problem.toShortString(op) + ")_" + ceIndex;
                }
                final BitVector precond = new BitVector();
                precond.or(op.getPreconditions().getPositive());
                precond.or(cEffect.getCondition().getPositive());
                BitVector neg = op.getPreconditions().getNegative();
                for (int p = neg.nextSetBit(0); p >= 0; p = neg.nextSetBit(p + 1)) {
                    precond.set(p + this.negOffset);
                }
                neg = cEffect.getCondition().getNegative();
                for (int p = neg.nextSetBit(0); p >= 0; p = neg.nextSetBit(p + 1)) {
                    precond.set(p + this.negOffset);
                }
                this.preconditions[uncondOpIndex] = precond;
                final BitVector effect = new BitVector();
                effect.or(cEffect.getEffects().getPositive());
                neg = cEffect.getEffects().getNegative();
                for (int p = neg.nextSetBit(0); p >= 0; p = neg.nextSetBit(p + 1)) {
                    effect.set(p + this.negOffset);
                }
                this.effects[uncondOpIndex] = effect;
                uncondOpIndex++;
            }
        }

        // Set the goal to the state representation
        this.bvgoal = new BitVector();
        this.bvgoal.or(super.getGoal().getPositive());
        final BitVector neg = super.getGoal().getNegative();
        for (int p = neg.nextSetBit(0); p >= 0; p = neg.nextSetBit(p + 1)) {
            this.bvgoal.set(p + this.negOffset);
        }

        // Compute static dependence between operators
        this.operatorsDependences = new BitMatrix(this.nbOperators);
        for (int i = 0; i < this.nbOperators; i++) {
            for (int j = 0; j < this.nbOperators; j++) {
                if (i > j && this.areDependent(i, j)) {
                    this.operatorsDependences.set(i, j);
                    this.operatorsDependences.set(j, i);
                }
            }
        }

        // Initialize the array that must contain the level of the positive propsLayer
        this.propositionsLevel = new int[this.nbPropositions];
        // Initialize the array that must contain propositions mutex
        this.propositionsMutex = new ArrayList<>();
        // Initialize the array that must contain operators mutex
        this.operatorsMutex = new ArrayList<>();
        // Initialize the array that must contain achievers
        this.achievers = new ArrayList<>();
        // The bit vector that is used to store the new operators during expansion
        this.newOperators = new BitVector();
    }

    /**
     * Set the goal of the problem to solve in order to compute the heuristic.
     *
     * @param goal the goal.
     */
    @Override
    protected final void setGoal(final BitExp goal) {
        super.setGoal(goal);
        // Set the goal to the state representation
        this.bvgoal = new BitVector();
        this.bvgoal.or(super.getGoal().getPositive());
        final BitVector neg = goal.getNegative();
        for (int p = neg.nextSetBit(0); p >= 0; p = neg.nextSetBit(p + 1)) {
            this.bvgoal.set(p + this.negOffset);
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
        Arrays.fill(this.propositionsLevel, Integer.MAX_VALUE);

        // Initialize the initial propsLayer level of the planning graph
        this.propsLayer = new BitVector();
        this.propsLayer.or(state);

        // Initialize the first proposition level with the specified state
        this.propsLayer.flip(this.negOffset, this.nbPropositions);
        for (int p = state.nextSetBit(0); p >= 0; p = state.nextSetBit(p + 1)) {
            this.propsLayer.clear(p + this.negOffset);
        }
        for (int p = this.propsLayer.nextSetBit(0); p >= 0; p = this.propsLayer.nextSetBit(p + 1)) {
            this.propositionsLevel[p] = 0;
        }

        // Initialize the initial actions level of the planning graph
        this.opsLayer = new BitVector();

        // The current level of the planning graph (the first level is 0)
        int k = 0;
        // Initialize the propositions mutex at level with an empty bit matrix
        this.propositionsMutex.add(new BitMatrix(this.nbPropositions));

        // Initialize the boolean flag used to indicate if the goal is reached to false
        this.goalReached = false;
        // Initialize the boolean flag used to indicate if level of the graph is off to false
        this.levelOff = false;

        // Start the expansion of the planning graph
        while (!this.goalReached && !this.levelOff) {
            this.levelOff = true;
            // Update the achiever of the level by adding achiever at previous level
            final BitMatrix lAchievers = new BitMatrix(this.nbPropositions, this.nbOperators);
            this.achievers.add(lAchievers);
            if (k > 0) {
                final BitMatrix ak1 = this.achievers.get(k - 1);
                for (int p = 0; p < this.nbPropositions; p++) {
                    lAchievers.getRow(p).or(ak1.getRow(p));
                }
            }
            // Clear the bit vector that will contain the operator to add at the next level
            this.newOperators.clear();
            // Initialize the bit vector that will contain the propositions to add at the next level
            final BitVector newPropositions = new BitVector();
            // Add the NOOP operators
            this.opsLayer.or(this.propsLayer);
            // try only the operator not already in the planning graph
            for (int op = this.opsLayer.nextClearBit(this.nbPropositions); op > 0
                && op < this.nbOperators; op = this.opsLayer.nextClearBit(op + 1)) {
                if (this.propsLayer.include(this.preconditions[op])
                    && this.isMutexFree(this.preconditions[op], k)) {
                    this.opsLayer.set(op);
                    newOperators.set(op);
                    final BitVector effs = this.effects[op];
                    newPropositions.or(effs);
                    // Update the achiever to speed up the mutex computation
                    for (int p = effs.nextSetBit(0); p >= 0; p = effs.nextSetBit(p + 1)) {
                        lAchievers.set(p, op);
                    }
                    // If an operator is added so the graph is not level off
                    this.levelOff = false;
                }
            }

            // Add the new effects of the applicable operator to the propositions layer
            this.propsLayer.or(newPropositions);
            // Update the level of the new propositions
            for (int p = newPropositions.nextSetBit(0); p >= 0; p = newPropositions
                .nextSetBit(p + 1)) {
                if (this.propositionsLevel[p] == Integer.MAX_VALUE) {
                    this.propositionsLevel[p] = k;
                }
            }
            // Update the operators mutexes at level k
            this.updateOperatorsMutex(k);
            // Update the propositions mutexes at level k + 1
            this.updatePropositionsMutex(k + 1);
            // Increment the level of the planning graph
            k++;
            // Check if the goal is reached
            this.goalReached = this.propsLayer.include(this.bvgoal) && this.isMutexFree(this.bvgoal, k);
        }
        return k;
    }

    /**
     * Updates the propositions mutex at a specified level of the planning graph.
     *
     * @param lev the level.
     */
    private void updatePropositionsMutex(final int lev) {
        this.propositionsMutex.add(new BitMatrix(this.nbPropositions));
        final BitMatrix pmK = new BitMatrix(nbPropositions);
        final BitMatrix pmk1 = this.propositionsMutex.get(lev - 1);
        this.propositionsMutex.add(pmK);
        for (int pi = this.propsLayer.nextSetBit(0); pi >= 0; pi = this.propsLayer
            .nextSetBit(pi + 1)) {
            for (int pj = this.propsLayer.nextSetBit(0); pj >= 0; pj = this.propsLayer
                .nextSetBit(pj + 1)) {
                if (pi > pj && this.arePropositionsMutex(pi, pj, lev)) {
                    pmK.set(pi, pj);
                    pmK.set(pj, pi);
                }
            }
        }
        this.levelOff = pmK.equals(pmk1);
    }

    /**
     * Updates the operators mutex at a specified level of the planning graph.
     *
     * @param lev the level.
     */
    private void updateOperatorsMutex(final int lev) {
        if (lev > 1) {
            // Update the old mutex first
            final BitMatrix omk = new BitMatrix(this.nbOperators);
            this.operatorsMutex.add(omk);
            final BitMatrix omk1 = this.operatorsMutex.get(lev - 1);
            for (int oi = this.opsLayer.nextSetBit(0); oi >= 0; oi = this.opsLayer
                .nextSetBit(oi + 1)) {
                for (int oj = this.opsLayer.nextSetBit(0); oj >= 0; oj = this.opsLayer
                    .nextSetBit(oj + 1)) {
                    if (oi > oj && omk1.get(oi, oj) && this.areOperatorsMutex(oi, oj, lev)) {
                        omk.set(oi, oj);
                        omk.set(oj, oi);
                    } else {
                        this.levelOff = false;
                    }
                }
            }
            // then update the mutex of the new operators
            for (int oi = this.newOperators.nextSetBit(0); oi >= 0; oi = this.newOperators
                .nextSetBit(oi + 1)) {
                for (int oj = this.opsLayer.nextSetBit(0); oj >= 0; oj = this.opsLayer
                    .nextSetBit(oj + 1)) {
                    if (oi > oj && this.areOperatorsMutex(oi, oj, lev)) {
                        omk.set(oi, oj);
                        omk.set(oj, oi);
                        this.levelOff = false;
                    }
                }
            }
        } else { // Special case of the level lev
            final BitMatrix omk = new BitMatrix(this.nbOperators);
            this.operatorsMutex.add(omk);
            for (int oi = this.opsLayer.nextSetBit(0); oi >= 0; oi = this.opsLayer
                .nextSetBit(oi + 1)) {
                for (int oj = this.opsLayer.nextSetBit(0); oj >= 0; oj = this.opsLayer
                    .nextSetBit(oj + 1)) {
                    if (oi > oj && this.areOperatorsMutex(oi, oj, lev)) {
                        omk.set(oi, oj);
                        omk.set(oj, oi);
                        this.levelOff = false;
                    }
                }
            }
        }
    }

    /**
     * Computes the sum heuristic.
     *
     * @return the sum heuristic value.
     * @see Sum
     */
    protected final int getSumValue() {
        int value = 0;
        for (int p = this.bvgoal.nextSetBit(0); p >= 0; p = this.bvgoal.nextSetBit(p + 1)) {
            value += this.propositionsLevel[p];
        }
        return value;
    }

    /**
     * Returns <code>true</code> if two operator are mutex at a specified level. Two opsLayer are
     * mutex if the opsLayer are dependent or an operator has a mutex precondition at level lev;
     *
     * @param oi  the first fact.
     * @param oj  the second fact.
     * @param lev the level where the test must be done.
     * @return <code>true</code> if two operator are mutex at a specified level;
     * <code>false</code> otherwise.
     */
    private boolean areOperatorsMutex(final int oi, final int oj, final int lev) {
        if (lev == 0) {
            return this.operatorsDependences.get(oi, oj);
        }
        if (!this.operatorsDependences.get(oi, oj)) {
            boolean mutex = false;
            final BitVector ppi = this.preconditions[oi];
            final BitVector ppj = this.preconditions[oj];
            final BitMatrix mk = this.propositionsMutex.get(lev);
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
     * if at least one operator that produce the facts are mutex in the previous level lev - 1.
     *
     * @param pi  the first fact.
     * @param pj  the second fact.
     * @param lev the level where the test must be done.
     * @return <code>true</code> if two facts are mutex at a specified level; <code>false</code>
     *          otherwise.
     */
    private boolean arePropositionsMutex(final int pi, final int pj, final int lev) {
        boolean mutex = pj == (pi + super.getRevelantFacts().size());
        if (!mutex && lev > 0) {
            final BitMatrix ak = this.achievers.get(lev - 1);
            final BitSet rak = ak.getRow(pi);
            final BitSet rbk = ak.getRow(pj);
            // Test if there is one operator that produce pi and pj
            if (rak.intersects(rbk)) {
                return false;
            }
            final BitMatrix mak = this.operatorsMutex.get(lev - 1);
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
     * @param level the level of the graph at which the test is done.
     * @return <code>true</code> if a set of facts is mutex free in a specified proposition level
     *          of the planning graph, <code>false</code> otherwise.
     */
    private boolean isMutexFree(final BitVector state, final int level) {
        boolean free = true;
        final BitMatrix mk = this.propositionsMutex.get(level);
        int i = state.nextSetBit(0);
        while (i >= 0 && free) {
            free = !mk.getRow(i).intersects(state);
            i = state.nextSetBit(i + 1);
        }
        return free;
    }

    /**
     * Returns <code>true</code> if two opsLayer are dependent, i.e, if an operator delete an
     * precondition or an add effect of the other.
     *
     * @param oi The first operator.
     * @param oj The second operator
     * @return <code>true</code> if two opsLayer are dependent, <code>false</code> otherwise.
     */
    private boolean areDependent(final int oi, final int oj) {
        final BitVector effOi = this.effects[oi];
        final BitVector effOj = this.effects[oj];
        final BitVector preOi = this.preconditions[oi];
        final BitVector preOj = this.preconditions[oj];
        return !this.areConsistantStates(effOi, effOj)
            || !this.areConsistantStates(effOi, preOj)
            || !this.areConsistantStates(effOj, preOi)
            || !this.areConsistantStates(preOi, preOj);
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
            if (state.get(p + offset)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return <code>true</code> if the goal is reached in the last proposition level of the
     * expanded planning graph.
     *
     * @return <code>true</code> if the goal is reached in the last proposition level of the
     *          expanded planning graph; <code>false</code> otherwise.
     */
    protected final boolean isGoalReachable() {
        return this.goalReached;
    }
}
