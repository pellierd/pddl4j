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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class implements an operator. This class is used to store compact representation of operator
 * during the instantiation process.
 *
 * @author D. Pellier
 * @version 1.0 - 07.04.2010
 */
final class IntAction extends AbstractIntOperator {

    /**
     * The default duration of an operator.
     */
    public static final double DEFAULT_DURATION = 1.0;

    /**
     * The default cost of an operator.
     */
    public static double DEFAULT_COST = 1.0;

    /**
     * The expression that represents the effect of the operator.
     */
    private IntExpression effects;

    /**
     * The cost of the operator.
     */
    private double cost;

    /**
     * The duration of the operator.
     */
    private double duration;

    /**
     * Create a new operator from a specified operator. This constructor create a deep copy of the
     * specified operator.
     *
     * @param other the other operator.
     */
    public IntAction(final IntAction other) {
        super(other);
        this.effects = new IntExpression(other.getEffects());
        this.cost = other.getCost();
        this.duration = other.getDuration();
    }

    /**
     * Create a new operator with a specified name.
     *
     * @param name  the name of the operator.
     * @param arity the arity of the operator. Arity must be > 0.
     */
    public IntAction(final String name, final int arity) {
        super(name, arity);
        this.effects = new IntExpression(PDDLConnective.OR);
        this.cost = IntAction.DEFAULT_COST;
        this.duration = IntAction.DEFAULT_DURATION;
    }

    /**
     * Returns the duration of the operator.
     *
     * @return the duration of the operator.
     */
    public final double getDuration() {
        return this.duration;
    }

    /**
     * Sets the duration of the operator.
     *
     * @param duration the duration to set.
     */
    public final void setDuration(final double duration) {
        this.duration = duration;
    }

    /**
     * Returns the cost of the operator.
     *
     * @return the cost of the operator.
     */
    public final double getCost() {
        return this.cost;
    }

    /**
     * Sets the cost of the operator.
     *
     * @param cost the cost to set.
     */
    public final void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Return the effects of the operator.
     *
     * @return the effects of the operator.
     */
    public final IntExpression getEffects() {
        return this.effects;
    }

    /**
     * Set the new effects of the operator.
     *
     * @param effects the effects to set
     */
    public final void setEffects(final IntExpression effects) {
        this.effects = effects;
    }


    /**
     * Expands the conditional effect of this action. The quantified expression of the effect must be removed before
     * calling this method.
     *
     *  @return the list of action corresponding without conditional effects.
     */
    public List<IntAction> expandConditionalEffect() {
        List<IntAction> expanded = new ArrayList<>();
        LinkedList<IntAction> toExpand = new LinkedList<>();
        toExpand.add(new IntAction(this));
        while (!toExpand.isEmpty()) {
            IntAction action = toExpand.pop();
            IntExpression when = this.popWhenExpression(action.getEffects());
            if (when == null) {
                expanded.add(action);
            } else {
                IntAction a1 = new IntAction(action);
                IntExpression precondition = new IntExpression(PDDLConnective.AND);
                precondition.addChild(when.getChildren().get(0));
                precondition.addChild(a1.getPreconditions());
                a1.setPreconditions(precondition);
                IntExpression effect = new IntExpression(PDDLConnective.AND);
                effect.addChild(when.getChildren().get(1));
                effect.addChild(a1.getEffects());
                a1.setEffects(effect);
                toExpand.add(a1);


                IntAction a2 = new IntAction(action);
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
     * @param exp the expression.
     * @return
     */
    private static IntExpression popWhenExpression(IntExpression exp) {
        Iterator<IntExpression> i = exp.getChildren().iterator();
        IntExpression when = null;
        while (i.hasNext() && when == null) {
            IntExpression e = i.next();
            if (e.getConnective().equals(PDDLConnective.WHEN)) {
                when = e;
                i.remove();
            } else {
                when = popWhenExpression(e);
            }
        }
        return when;
    }




}
