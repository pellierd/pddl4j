/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
 *
 * This file is part of PDDL4J library.
 *
 * PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 3 of the License.
 *
 * PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with PDDL4J.
 * If not, see <http://www.gnu.org/licenses/>
 */

package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.ParsedProblem;
import fr.uga.pddl4j.problem.operator.IntAction;
import fr.uga.pddl4j.problem.operator.IntExpression;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class implements an simple temporal problem. The instantiation process of this temporal problem is based on the
 * article from Maria Fox and Derek Long : PDDL2.1 : An Extension to pddl for Expressing Temporal Planning Domains.
 * Journal of Artificial Intelligence Research 20 (2003) 61-124
 *
 * @author D. Pellier
 * @version 4.0 - 05.02.2021
 */
public class SimpleTemporalProblem extends AbstractTemporalProblem {

    /**
     * Create a new temporal problem from a domain and problem.
     *
     * @param problem The problem.
     */
    public SimpleTemporalProblem(final ParsedProblem problem) {
        super(problem);
    }

    /**
     * Expands the temporal actions.
     */
    protected void expandDurativeActions() {
        List<IntAction> expandedActions = new ArrayList<>();

        for (IntAction a : this.getIntActions()) {
            // System.out.println("******************************************************");
            //System.out.println(Encoder.toString(a));

            this.expandQuantifiedExpression(a.getPreconditions(), false);
            a.getPreconditions().moveTimeSpecifierInward();
            a.getPreconditions().moveNegationInward();

            //System.out.println("*** Precondition ***");
            //System.out.println(Encoder.toString(a.getPreconditions()));

            final IntExpression startPrecondition = new IntExpression(a.getPreconditions());
            this.extract(startPrecondition, PDDLConnective.AT_START);
            //System.out.println("*** At start precondition ***");
            //System.out.println(Encoder.toString(startPrecondition));
            this.simplify(startPrecondition);
            //System.out.println("*** At start precondition ***");
            //System.out.println(Encoder.toString(startPrecondition));
            this.toDNF(startPrecondition);

            //System.out.println("*** At start precondition ***");
            //System.out.println(Encoder.toString(startPrecondition));

            final IntExpression endPrecondition = new IntExpression(a.getPreconditions());
            this.extract(endPrecondition, PDDLConnective.AT_END);
            this.simplify(endPrecondition);
            this.toDNF(endPrecondition);

            //System.out.println("*** At end precondition ***");
            //System.out.println(Encoder.toString(endPrecondition));

            final IntExpression overAllPrecondition = new IntExpression(a.getPreconditions());
            this.extract(overAllPrecondition, PDDLConnective.OVER_ALL);
            //System.out.println("*** Over all precondition AV Simplify ***");
            //System.out.println(Encoder.toString(overAllPrecondition));
            this.simplify(overAllPrecondition);
            this.toDNF(overAllPrecondition);

            //System.out.println("*** Over all precondition ***");
            //System.out.println(Encoder.toString(overAllPrecondition));


            // Expands the quantified expression on the effect of the action
            this.expandQuantifiedExpression(a.getEffects(), false);
            a.getEffects().moveTimeSpecifierInward();
            a.getEffects().moveNegationInward();
            this.toCNF(a.getEffects());
            //this.simplify(a.getEffects());

            //System.out.println("*** EFFECT ***");
            //System.out.println(Encoder.toString(a.getEffects()));

            //try {
            //    System.out.println("Press enter...");
            //    System.in.read();
            //} catch (IOException e) {
            //    e.printStackTrace();
            //}
            // The list of monitoring action need to deal with over all condition in conditional effect
            final List<IntAction> monitoringActions = new ArrayList<>();
            // The effect of the start action
            final IntExpression startEffect = new IntExpression(PDDLConnective.AND);
            // The effect of the end action
            final IntExpression endEffect = new IntExpression(PDDLConnective.AND);

            // Iterate over the effect of the action the action to initialize the start and end effect and the list of
            // monitoring actions needed to deal with over all condition in conditional effects.
            // We suppose that the effect is a conjunction of at_start or at_end or when.
            for (IntExpression effect : a.getEffects().getChildren()) {
                //System.out.println("EFFECT : "+ this.toString(effect));
                switch (effect.getConnective()) {
                    case AT_START:
                        startEffect.addChild(effect.getChildren().get(0));
                        break;
                    case AT_END:
                        endEffect.addChild(effect.getChildren().get(0));
                        break;
                    case WHEN:
                        // Extract the start effect condition of the conditional effect
                        final IntExpression ps = new IntExpression(effect.getChildren().get(0));
                        this.extract(ps, PDDLConnective.AT_START);
                        // Extract the end effect condition of the conditional effect
                        final IntExpression pe = new IntExpression(effect.getChildren().get(0));
                        this.extract(pe, PDDLConnective.AT_END);
                        // Extract the overall effect condition of the conditional effect
                        final IntExpression pi = new IntExpression(effect.getChildren().get(0));
                        this.extract(pi, PDDLConnective.OVER_ALL);
                        // Extract the start effect of the conditional effect
                        final IntExpression qs = new IntExpression(effect.getChildren().get(1));
                        this.extract(qs, PDDLConnective.AT_START);
                        // Extract the end effect of the conditional effect
                        final IntExpression qe = new IntExpression(effect.getChildren().get(1));
                        this.extract(qe, PDDLConnective.AT_END);

                        if (!ps.getChildren().isEmpty() && pe.getChildren().isEmpty() && pi.getChildren().isEmpty()
                                && !qs.getChildren().isEmpty() && qe.getChildren().isEmpty()) {
                            // CASE at start only in condition and at start only in effects
                            // We add the condition of the effect to the start action and the effect to the start
                            // action.
                            IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            when.addChild(ps);
                            when.addChild(ps);
                            startEffect.addChild(when);
                        } else if (ps.getChildren().isEmpty() && !pe.getChildren().isEmpty()
                            && pi.getChildren().isEmpty() && qs.getChildren().isEmpty()
                            && !qe.getChildren().isEmpty()) {
                            // CASE at end only in condition and at end only in effects
                            // We add the condition of the effect to the end action and the effect to the end action.

                            IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            when.addChild(pe);
                            when.addChild(qe);
                            endEffect.addChild(when);
                        } else if (!ps.getChildren().isEmpty() && pi.getChildren().isEmpty()
                                && !qe.getChildren().isEmpty()) {
                            // CASE at star and possibly at end but no overall in condition and at end in effects
                            // Create the conditional effect for the start action
                            final IntExpression startWhen = new IntExpression(PDDLConnective.WHEN);
                            startWhen.addChild(ps);
                            // Create the dummy predicate to memorize the effect at end
                            final IntExpression mps = this.createDummyPredicate();
                            startWhen.addChild(mps);
                            startEffect.addChild(startWhen);

                            // Create the conditional effect for the end action
                            final IntExpression endWhen = new IntExpression(PDDLConnective.WHEN);
                            if (pe.getChildren().isEmpty()) {
                                endWhen.addChild(mps);
                            } else {
                                final IntExpression and = new IntExpression(PDDLConnective.AND);
                                and.addChild(pe);
                                and.addChild(mps);
                                endWhen.addChild(and);
                            }
                            endWhen.addChild(endEffect);
                            endEffect.addChild(endWhen);
                        } else if (!pi.getChildren().isEmpty() && qe.getChildren().isEmpty()) {
                            // CASE overall in condition with possibly no at start and no at end and at end in effect
                            // (when (and (at start ps) (over all pi) (at end pe)) (at end q))

                            // Create the monitoring action with no precondition but effects of the form
                            // (when (and (Mpi) (not pi)) (not (Mpi)))
                            final IntAction monitoring = this.createMonitoringAction();
                            final IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            IntExpression and = new IntExpression(PDDLConnective.AND);
                            final IntExpression mpi = this.createDummyPredicate();
                            and.addChild(mpi);
                            final IntExpression notPi = new IntExpression(PDDLConnective.NOT);
                            notPi.addChild(pi);
                            notPi.moveNegationInward();
                            and.addChild(notPi);
                            when.addChild(and);
                            final IntExpression notMpi = new IntExpression(PDDLConnective.NOT);
                            notMpi.addChild(mpi);
                            when.addChild(notMpi);
                            monitoring.getEffects().addChild(when);
                            monitoringActions.add(monitoring);

                            // Create the start effect: (when ps (Mps))
                            IntExpression mps = this.createDummyPredicate();
                            if (!ps.getChildren().isEmpty()) {
                                IntExpression startWhen = new IntExpression(PDDLConnective.WHEN);
                                startWhen.addChild(ps);
                                startWhen.addChild(mps);
                                startEffect.addChild(startWhen);
                            } else {
                                startEffect.addChild(mps);
                            }

                            // Create the start effect: (when (and (Mps) (Mpi) pe) q).
                            and = new IntExpression(PDDLConnective.AND);
                            and.addChild(mps);
                            and.addChild(mpi);
                            if (!pe.getChildren().isEmpty()) {
                                and.addChild(pe);
                            }
                            IntExpression endWhen = new IntExpression(PDDLConnective.WHEN);
                            endWhen.addChild(and);
                            endWhen.addChild(qe);
                            endEffect.addChild(endWhen);
                        }
                        break;
                    default:
                        // Do nothing
                }
            }
            //System.out.println("START PRECOND AVANT  SIM: ");
            //System.out.println(this.toString(startPrecondition));
            //this.simplify(startPrecondition);
            //System.out.println("START PRECOND APRES  SIM: ");
            //System.out.println(this.toString(startPrecondition));
            //start.

            //this.simplify(endPrecondition);
            //this.simplify(overallPrecondition);

            //System.out.println("START EFFECT AVANT  SIM: ");
            //System.out.println(Encoder.toString(startEffect));
            this.simplify(startEffect);
            //startEffect.toConjunctiveNormalForm(this);
            //System.out.println("START EFFECT APRES SIM: ");
            //System.out.println(Encoder.toString(startEffect));

            //System.out.println("END EFFECT AVANT  SIM: ");
            //System.out.println(Encoder.toString(endEffect));
            this.simplify(endEffect);
            //endEffect.toConjunctiveNormalForm(this);
            //System.out.println("END EFFECT APRES  SIM: ");
            //System.out.println(Encoder.toString(endEffect));

            // Create a start action for each conjunction of the start precondition
            for (IntExpression precondition : startPrecondition.getChildren()) {
                IntAction startAction = new IntAction(a.getName() + "_" + "start", a.arity());
                startAction.setCost(a.getCost());
                startAction.setDuration(new IntExpression(a.getDuration()));
                for (int i = 0; i < a.arity(); i++) {
                    startAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                }
                for (int i = 0; i < a.arity(); i++) {
                    startAction.setValueOfParameter(i, a.getValueOfParameter(i));
                }
                startAction.setPreconditions(precondition);
                startAction.setEffects(new IntExpression(startEffect));
                expandedActions.add(startAction);

                //System.out.println("*"+Encoder.toString(startAction));
                //try {
                //    System.out.println("Press enter...");
                //    System.in.read();
                //} catch (IOException e) {
                //    e.printStackTrace();
                //}
            }

            for (IntExpression precondition : endPrecondition.getChildren()) {
                IntAction endAction = new IntAction(a.getName() + "_" + "end", a.arity());
                endAction.setCost(a.getCost());
                endAction.setDuration(new IntExpression(a.getDuration()));
                for (int i = 0; i < a.arity(); i++) {
                    endAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                }
                for (int i = 0; i < a.arity(); i++) {
                    endAction.setValueOfParameter(i, a.getValueOfParameter(i));
                }
                endAction.setPreconditions(precondition);
                endAction.setEffects(new IntExpression(endEffect));
                expandedActions.add(endAction);

                /*System.out.println("*"+Encoder.toString(endAction));
                try {
                    System.out.println("Press enter...");
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }
            //System.out.println(Encoder.toString(overAllPrecondition));
            for (IntExpression precondition : overAllPrecondition.getChildren()) {
                if (!precondition.getConnective().equals(PDDLConnective.FALSE)) {
                    IntAction invAction = new IntAction(a.getName() + "_" + "inv", a.arity());
                    invAction.setCost(a.getCost());
                    invAction.setDuration(new IntExpression(a.getDuration()));
                    for (int i = 0; i < a.arity(); i++) {
                        invAction.setTypeOfParameter(i, a.getTypeOfParameters(i));
                    }
                    for (int i = 0; i < a.arity(); i++) {
                        invAction.setValueOfParameter(i, a.getValueOfParameter(i));
                    }
                    invAction.setPreconditions(precondition);
                    expandedActions.add(invAction);
                    /*System.out.println("*" + Encoder.toString(invAction));
                    try {
                        System.out.println("Press enter...");
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/
                }
            }

            // Add the monitoring actions
            for (IntAction m : monitoringActions) {
                expandedActions.add(m);
                /*
                System.out.println(this.toString(m));
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }

        }
        this.getIntActions().clear();
        this.getIntActions().addAll(expandedActions);

    }


    /**
     * Extract the subexpression from an expression having the time specifier in parameter.
     * Warning the time specifier must be move inward.
     *
     * @param exp the expression.
     * @param timeSpecifier the time specifier.
     */
    private void extract(IntExpression exp, PDDLConnective timeSpecifier) {
        switch (exp.getConnective()) {
            case OR:
            case AND:
                Iterator<IntExpression> i = exp.getChildren().iterator();
                while (i.hasNext()) {
                    IntExpression e = i.next();
                    this.extract(e, timeSpecifier);
                    if (e.getConnective().equals(PDDLConnective.AND)
                        && e.getChildren().isEmpty()) {
                        i.remove();
                    }
                }
                break;
            case AT_END:
            case AT_START:
            case OVER_ALL:
                if (!exp.getConnective().equals(timeSpecifier)) {
                    exp.setConnective(PDDLConnective.AND);
                    exp.getChildren().clear();
                } else {
                    exp.affect(exp.getChildren().get(0));
                }
                break;
            default:
        }
    }

    /**
     * The counter to create a unique predicate name.
     */
    private int dummyPredicateCounter = 0;

    /**
     * Creates a dummy predicate.
     *
     * @return the dummy predicate created.
     */
    private IntExpression createDummyPredicate() {
        this.getPredicateSymbols().add("^M" + this.dummyPredicateCounter);
        this.dummyPredicateCounter++;
        final IntExpression atom = new IntExpression(PDDLConnective.ATOM);
        atom.setPredicate(this.getPredicateSymbols().size() - 1);
        return atom;

    }

    /**
     * The counter to create an unique monitoring action name.
     */
    private int monitoringActionCounter = 0;

    /**
     * Creates a new monitoring action.
     *
     * @return the new monitoring action.
     */
    private IntAction createMonitoringAction() {
        IntAction monitoring = new IntAction("monitoring_action" + this.monitoringActionCounter, 0);
        this.monitoringActionCounter++;
        return monitoring;
    }
}
