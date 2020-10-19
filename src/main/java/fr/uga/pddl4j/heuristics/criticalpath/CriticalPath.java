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

package fr.uga.pddl4j.heuristics.criticalpath;

import fr.uga.pddl4j.heuristics.graph.RelaxedGraphHeuristic;
import fr.uga.pddl4j.planners.statespace.search.Node;
import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.ClosedWorldState;
import fr.uga.pddl4j.problem.Problem;
import fr.uga.pddl4j.problem.State;

import fr.uga.pddl4j.util.BitVector;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will display the critical path based on the Delta Algorithm from the Automated Planning book.
 * Automated Planning: Theory &#38; Practice Book by Dana S. Nau, Malik Ghallab, and Paolo Traverso (Chapter 9).
 * At the minute it has a variation of the sum heuristic and max heuristic and the final method will have
 * the critical path.
 *
 * @author Aaron Boyd
 * @version 1.0 20.08.2010
 */
public final class CriticalPath extends RelaxedGraphHeuristic {

    private State[] precond;
    private State[] effect;
    private State[] neffect;
    private int[] pGoal;
    private int[] nGoal;
    private static final int COEF = 2;
    private int goalCard;
    private int critical;

    public CriticalPath(Problem problem) {
        super(problem);
        super.setAdmissible(true);
    }

    @Override
    public int estimate(ClosedWorldState state, State goal) {
        super.setGoal(goal);
        //this.goalCard = super.getGoal().cardinality(); // Useless cause by next line affectation
        goalCard = goal.cardinality();
        final List<Action> actions = this.getActions();
        int startPoint = 0;
        for (Action op : actions) {
            startPoint += op.getCondEffects().size();
        }
        int nbRelevantFacts = super.getRevelantFacts().size();
        this.pGoal = new int[nbRelevantFacts];
        this.nGoal = new int[nbRelevantFacts];
        this.precond = new State[startPoint];
        this.effect = new State[startPoint];
        this.neffect = new State[startPoint];
        BitVector pGoalBitVector = super.getGoal().getPositive();
        BitVector nGoalBitVector = super.getGoal().getNegative();


        if (this.goalCard <= COEF) {

            BitVector ppk = new BitVector(state);
            for (int p = ppk.nextSetBit(0); p >= 0; p = ppk.nextSetBit(p + 1)) {
                this.pGoal[p] = 0;
                pGoalBitVector.set(p);
            }

            BitVector nnk = new BitVector();
            for (int p = nnk.nextSetBit(0); p >= 0; p = nnk.nextSetBit(p + 1)) {
                this.nGoal[p] = 0;
                nGoalBitVector.set(p);
            }
            //Compute the positive preconditions
            for (Action op : this.getActions()) {
                final State pre = new State(op.getPreconditions());
                final State npre = new State(op.getPreconditions());
                BitVector nprecon = npre.getNegative();
                BitVector precon = pre.getPositive();
                for (int p = precon.nextSetBit(0); p >= 0; p = precon.nextSetBit(p + 1)) {
                    precon = this.precond[p].getPositive();
                    precon.set(p);
                }

                for (int p = nprecon.nextSetBit(0); p >= 0; p = nprecon.nextSetBit(p + 1)) {
                    nprecon = this.precond[p].getNegative();
                    nprecon.set(p);
                }

                //Get the positive and negative effects
                State effects = op.getCondEffects().get(0).getEffects();
                BitVector positiveEffect = effects.getPositive();
                BitVector negativeEffect = effects.getNegative();
                BitVector newProp = new BitVector();
                for (int p = newProp.nextSetBit(0); p >= 0; p = newProp.nextSetBit(p + 1)) {
                    positiveEffect.or(this.effect[p].getPositive());
                    negativeEffect.or(this.effect[p].getNegative());
                }
                final BitVector nPos = negativeEffect;
                for (int p = nPos.nextSetBit(0); p >= 0; p = nPos.nextSetBit(p + 1)) {
                    this.neffect[p].getNegative().set(p);
                    nPos.or(this.neffect[p].getNegative());
                }
                //A is relevant for G only if positive effect does not equal zero and negative effect equals zero
                if (this.effect.length != 0 && this.neffect.length == 0) {
                    //Remove the precondition and positive effect from the goal
                    pGoalBitVector.andNot(positiveEffect);
                    pGoalBitVector.andNot(precon);
                }
                critical++;
            }

        } else {
            //place the cardinality of the goal in to an array
            int[] combinations = new int[goalCard];
            int m = combinations.length;
            //Generate all subsets from the array
            int list = (1 << m);
            for (int i = 0; i < list; i++) {
                List<Integer> sub = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    if ((i & (1 << j)) > 0) {
                        sub.add(j);
                    }
                }
                //if the subset size equals COEF, print subset
                if (sub.size() == COEF) {
                    //System.out.println(sub);
                    //Maximum distance to the goal
                    critical = this.getMaxValue();
                }
            }
        }

        return super.isGoalReachable() ? critical : Integer.MAX_VALUE;
    }

    /**
     * Return the estimated distance to the goal to reach the specified state. If the return value is
     * <code>DOUBLE.MAX_VALUE</code>, it means that the goal is unreachable from the specified
     * state.
     *
     * @param node the state from which the distance to the goal must be estimated.
     * @param goal the goal expression.
     * @return the distance to the goal state from the specified state.
     */
    @Override
    public double estimate(final Node node, final State goal) {
        return estimate((ClosedWorldState) node, goal);
    }
}
