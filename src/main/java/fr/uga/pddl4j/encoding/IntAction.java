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

package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.parser.PDDLConnective;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class implements an action. This class is used to store compact representation of an action
 * during the instantiation process.
 *
 * <p>Revisions:
 * <ul>
 * <li>20.10.2020: change the duration attribute to encode temporal problem.</li>
 * </ul>
 *
 * @author D. Pellier
 * @version 1.1 - 07.04.2010
 */
public final class IntAction extends AbstractIntOperator {

    /**
     * The default cost of an action.
     */
    public static double DEFAULT_COST = 1.0;

    /**
     * The expression that represents the effect of the action.
     */
    private IntExpression effects;

    /**
     * The cost of the action.
     */
    private double cost;

    /**
     * The duration of the action.
     */
    private IntExpression duration;

    /**
     * Create a new action from a specified action. This constructor create a deep copy of the
     * specified action.
     *
     * @param other the other action.
     */
    public IntAction(final IntAction other) {
        super(other);
        this.effects = new IntExpression(other.getEffects());
        this.cost = other.getCost();
        if (other.getDuration() != null) {
            this.duration = new IntExpression(other.getDuration());
        }
    }

    /**
     * Create a new action with a specified name.
     *
     * @param name  the name of the action.
     * @param arity the arity of the action. Arity must be > 0.
     */
    public IntAction(final String name, final int arity) {
        super(name, arity);
        this.effects = new IntExpression(PDDLConnective.AND);
        this.cost = IntAction.DEFAULT_COST;
        this.duration = null;
    }

    /**
     * Returns if this action is a durative action.
     *
     * @return <code>true</code> if this action is durative; <code>false</code> otherwise.
     */
    public final boolean isDurative() {
        return this.duration != null;
    }

    /**
     * Returns the duration of the action.
     *
     * @return the duration of the action.
     */
    public final IntExpression getDuration() {
        return this.duration;
    }

    /**
     * Sets the duration of the action.
     *
     * @param duration the duration to set.
     */
    public final void setDuration(final IntExpression duration) {
        this.duration = duration;
    }

    /**
     * Returns the cost of the action.
     *
     * @return the cost of the action.
     */
    public final double getCost() {
        return this.cost;
    }

    /**
     * Sets the cost of the action.
     *
     * @param cost the cost to set.
     */
    public final void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Return the effects of the action.
     *
     * @return the effects of the action.
     */
    public final IntExpression getEffects() {
        return this.effects;
    }

    /**
     * Set the new effects of the action.
     *
     * @param effects the effects to set
     */
    public final void setEffects(final IntExpression effects) {
        this.effects = effects;
    }

    /**
     * Expands the conditional effect of this action. The quantified expression of the effect must be removed before
     * calling this method or at least push into the when expression. The action is not affected by this method.
     *
     *  @return the list of action corresponding without conditional effects.
     */
    public List<IntAction> expandConditionalEffect(IProblem p) {


        final List<IntAction> expanded = new ArrayList<>();
        final LinkedList<IntAction> toExpand = new LinkedList<>();
        toExpand.add(new IntAction(this));
        while (!toExpand.isEmpty()) {
            final IntAction action = toExpand.pop();
            final IntExpression when = this.popWhenExpression(action.getEffects());
            if (when == null) {

                //System.out.println("+++++++" + p.toString(action));


                action.getPreconditions().moveNegationInward();
                action.getPreconditions().toDNF();

                action.getEffects().moveNegationInward();
                action.getEffects().toCNF();
                //System.out.println("---------"  + p.toString(action));
                /*try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                expanded.add(action);
            } else {
                final IntAction a1 = new IntAction(action);
                IntExpression precondition = new IntExpression(PDDLConnective.AND);
                precondition.addChild(when.getChildren().get(0));
                precondition.addChild(a1.getPreconditions());
                a1.setPreconditions(precondition);
                final IntExpression effect = new IntExpression(PDDLConnective.AND);
                effect.addChild(when.getChildren().get(1));
                effect.addChild(a1.getEffects());
                a1.setEffects(effect);
                toExpand.add(a1);


                final IntAction a2 = new IntAction(action);
                precondition = new IntExpression(PDDLConnective.AND);
                IntExpression not = new IntExpression(PDDLConnective.NOT);
                not.addChild(when.getChildren().get(0));

                precondition.addChild(not);
                precondition.addChild(a2.getPreconditions());

                a2.setPreconditions(precondition);
                toExpand.add(a2);
            }
        }
        return expanded;
    }

    /**
     * Pops and removes the first occurrence of the when expression contained in a specified expression.
     *
     * @param exp the expression. The expression is modified.
     * @return the when expression pop.
     */
    private IntExpression popWhenExpression(IntExpression exp) {
        final Iterator<IntExpression> i = exp.getChildren().iterator();
        IntExpression when = null;
        while (i.hasNext() && when == null) {
            IntExpression e = i.next();
            if (e.getConnective().equals(PDDLConnective.WHEN)) {
                when = e;
                i.remove();
            } else {
                when = this.popWhenExpression(e);
            }
        }
        return when;
    }

    /**
     * Expands the disjunctive precondition of this action. The action is not affected by this method.
     *
     * @return the list of actions corresponding with this action with only conjunctive precondition.
     */
    public List<IntAction> expandDisjunctivePrecondition(IProblem pb) {

        this.normalize(pb);

        final List<IntAction> expanded = new ArrayList<>();
        final IntExpression precondition = new IntExpression(this.getPreconditions());
        for (IntExpression and : precondition.getChildren()) {
            final IntAction action = new IntAction(this.getName(), this.arity());
            action.setCost(this.getCost());
            if (this.isDurative()) {
                action.setDuration(new IntExpression(this.getDuration()));
            }
            for (int i = 0; i < this.arity(); i++) {
                action.setTypeOfParameter(i, this.getTypeOfParameters(i));
            }
            for (int i = 0; i < this.arity(); i++) {
                action.setValueOfParameter(i, this.getValueOfParameter(i));
            }
            action.setPreconditions(and);
            action.setEffects(new IntExpression(this.getEffects()));
            expanded.add(action);
        }
        return expanded;
    }

    /**
     * Normalize the action, i.e put the precondition into disjunctive normal form and effect in disjunctive normal
     * form. If a conditional effect occurs with a disjunctive condition, the conditional effect is rewrite with several
     * when expression.
     */
    private void normalize(IProblem pb) {
        this.getPreconditions().moveTimeSpecifierInward();
        this.getPreconditions().toDisjunctiveNormalForm(pb);
        this.effects.moveTimeSpecifierInward();
        this.effects.toConjunctiveNormalForm(pb);
    }

    /**
     * Transforms this action in to simple non temporal actions. The action is not affected by this method.
     *
     * @return the list of actions corresponding with this action with non temporal time specifier.
     */
    public List<IntAction> toSimpleNonTemporalActions(IProblem pb) {
        System.out.println(pb.toString(this));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (this.isDurative()) {
            final List<IntAction> expanded = new ArrayList<>();
            this.getPreconditions().moveNegationInward();
            final IntExpression precondition = new IntExpression(this.getPreconditions());
            final IntExpression atStartPrecondition = new IntExpression(PDDLConnective.AND);
            final IntExpression atEndPrecondition = new IntExpression(PDDLConnective.AND);
            final IntExpression overAllPrecondition = new IntExpression(PDDLConnective.AND);
            for (IntExpression timeLiteral : precondition.getChildren()) {
                final IntExpression literal = timeLiteral.getChildren().get(0);
                switch (timeLiteral.getConnective()) {
                    case AT_START:
                        atStartPrecondition.addChild(literal);
                        break;
                    case AT_END:
                        atEndPrecondition.addChild(literal);
                        break;
                    case OVER_ALL:
                        overAllPrecondition.addChild(literal);
                        break;
                    default:
                        throw new UnexpectedExpressionException(timeLiteral.getConnective().getImage());
                }
            }
            this.getEffects().moveNegationInward();
            final IntExpression effect = new IntExpression(this.getEffects());
            final IntExpression atStartEffect = new IntExpression(PDDLConnective.AND);
            final IntExpression atEndEffect = new IntExpression(PDDLConnective.AND);
            for (IntExpression timeLiteral : effect.getChildren()) {
                final IntExpression literal = timeLiteral.getChildren().get(0);
                switch (timeLiteral.getConnective()) {
                    case AT_START:
                        atStartEffect.addChild(literal);
                        break;
                    case AT_END:
                        atEndEffect.addChild(literal);
                        break;
                    default:
                        throw new UnexpectedExpressionException(timeLiteral.getConnective().getImage());
                }
            }

            IntAction atStartAction = new IntAction(this.getName() + "_" + "start", this.arity());
            atStartAction.setCost(this.getCost());
            atStartAction.setDuration(new IntExpression(this.getDuration()));
            for (int i = 0; i < this.arity(); i++) {
                atStartAction.setTypeOfParameter(i, this.getTypeOfParameters(i));
            }
            for (int i = 0; i < this.arity(); i++) {
                atStartAction.setValueOfParameter(i, this.getValueOfParameter(i));
            }
            atStartAction.setPreconditions(atStartPrecondition);
            atStartAction.setEffects(atStartEffect);
            expanded.add(atStartAction);


            IntAction atEndAction = new IntAction(this.getName() + "_" + "end", this.arity());
            atEndAction.setCost(this.getCost());
            atEndAction.setDuration(new IntExpression(this.getDuration()));
            for (int i = 0; i < this.arity(); i++) {
                atEndAction.setTypeOfParameter(i, this.getTypeOfParameters(i));
            }
            for (int i = 0; i < this.arity(); i++) {
                atEndAction.setValueOfParameter(i, this.getValueOfParameter(i));
            }
            atEndAction.setPreconditions(atEndPrecondition);
            atEndAction.setEffects(atEndEffect);
            expanded.add(atEndAction);

            IntAction overAllAction = new IntAction(this.getName() + "_" + "overall", this.arity());
            overAllAction.setCost(this.getCost());
            overAllAction.setDuration(new IntExpression(this.getDuration()));
            for (int i = 0; i < this.arity(); i++) {
                overAllAction.setTypeOfParameter(i, this.getTypeOfParameters(i));
            }
            for (int i = 0; i < this.arity(); i++) {
                overAllAction.setValueOfParameter(i, this.getValueOfParameter(i));
            }
            overAllAction.setPreconditions(overAllPrecondition);
            overAllAction.setEffects(new IntExpression(PDDLConnective.AND));
            expanded.add(overAllAction);
            return expanded;
        }
        return null;
    }
}
