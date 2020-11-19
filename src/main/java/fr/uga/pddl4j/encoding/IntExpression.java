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
import fr.uga.pddl4j.parser.PDDLSymbol;
import fr.uga.pddl4j.parser.UnexpectedExpressionException;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This class is used to encode expressions in compact encoding, i.e., with integer representation.
 *
 * @author D. Pellier
 * @version 1.0 - 07.04.2010
 */
public class IntExpression implements Serializable {

    /**
     * The constant used to encode the default taskID id.
     */
    public static final int DEFAULT_TASK_ID = -1;

    /**
     * The constant used to encode the default variable.
     */
    public static final int DEFAULT_VARIABLE = -1;

    /**
     * The constant used to encode the default type.
     */
    public static final int DEFAULT_TYPE = -1;

    /**
     * The constant used to encode the default variable value.
     */
    public static final int DEFAULT_VARIABLE_VALUE = -1;

    /**
     * The constant used to encode the specific predicate equal.
     */
    public static final int EQUAL_PREDICATE = -1;

    /*
     * The constant used to encode the default predicate value.
     */
    public static final int DEFAULT_PREDICATE = -2;

    /**
     * The connective of the expression.
     */
    private PDDLConnective connective;

    /**
     * The integer representation of the predicate.
     */
    private int predicate;

    /**
     * The integer representation of the task ID.
     */
    private int taskID;

    /**
     * The list of arguments of the expression. This attribute is used to store the argument of the
     * atomic expression.
     */
    private int[] arguments;

    /**
     * The children of the expression.
     */
    private List<IntExpression> children;

    /**
     * The variable is used by quantified expression.
     */
    private int variable;

    /**
     * The type of the variable used by a quantified expression.
     */
    private int type;

    /**
     * The value of the expression. This attribute is used to store value of number expression.
     */
    private double value;

    /**
     * A flag to indicate if this expression represente a primitive task.
     */
    private boolean isPrimtive;

    /**
     * Creates a new expression from an other one. This constructor make a deep copy of the specified
     * expression.
     *
     * @param other the expression.
     */
    public IntExpression(final IntExpression other) {
        this.connective = other.getConnective();
        this.predicate = other.getPredicate();
        this.taskID = other.getTaskID();
        this.arguments = other.getArguments();
        if (this.arguments != null) {
            this.arguments = Arrays.copyOf(other.getArguments(), other.getArguments().length);
        }
        final List<IntExpression> otherChildren = other.getChildren();
        this.children = new ArrayList<>(otherChildren.size());
        this.children.addAll(otherChildren.stream().map(IntExpression::new).collect(Collectors.toList()));
        this.variable = other.getVariable();
        this.type = other.getType();
        this.value = other.getValue();
        this.isPrimtive = other.isPrimtive();
    }

    /**
     * Creates a new expression with a specified connective.
     *
     * @param connective the connective of the expression.
     */
    public IntExpression(final PDDLConnective connective) {
        this.connective = connective;
        this.predicate = IntExpression.DEFAULT_PREDICATE;
        this.taskID = IntExpression.DEFAULT_TASK_ID;
        this.arguments = new int[0];
        this.children = new ArrayList<>();
        this.variable = IntExpression.DEFAULT_VARIABLE;
        this.type = IntExpression.DEFAULT_TYPE;
        this.value = IntExpression.DEFAULT_VARIABLE_VALUE;
        this.isPrimtive = false;
    }

    /**
     * Returns the connective of the expression.
     *
     * @return the connective of the expression.
     */
    public final PDDLConnective getConnective() {
        return this.connective;
    }

    /**
     * Sets a new connective to this expression.
     *
     * @param connective the new connective to set.
     */
    public final void setConnective(final PDDLConnective connective) {
        this.connective = connective;
    }

    /**
     * Adds a child to this expression.
     *
     * @param child the child expression to add.
     * @return <code>true</code> if the child was added <code>false</code> otherwise.
     */
    public final boolean addChild(final IntExpression child) {
        return this.children.add(child);
    }

    /**
     * Returns the list of children of this expression.
     *
     * @return the list of children of this expression.
     */
    public final List<IntExpression> getChildren() {
        return this.children;
    }

    /**
     * Returns the predicate of this expression.
     *
     * @return the predicate
     */
    public final int getPredicate() {
        return predicate;
    }

    /**
     * Sets a new predicate to this expression.
     *
     * @param predicate the new predicate to set
     */
    public final void setPredicate(int predicate) {
        this.predicate = predicate;
    }

    /**
     * Returns the tasks of this expression.
     *
     * @return the taskID.
     */
    public final int getTaskID() {
        return this.taskID;
    }

    /**
     * Sets a new taskID to this expression.
     *
     * @param taskID the new predicate to set.
     */
    public final void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    /**
     * Returns the list of argument of this expression.
     *
     * @return the arguments the list of arguments of this expression.
     */
    public final int[] getArguments() {
        return this.arguments;
    }

    /**
     * Sets the arguments of the expression.
     *
     * @param args the arguments to set.
     */
    public final void setArguments(final int[] args) {
        this.arguments = args;
    }

    /**
     * Returns the variable of the expression.
     *
     * @return the variable of the expression.
     */
    public final int getVariable() {
        return this.variable;
    }

    /**
     * Sets a new quantified variable to the expression.
     *
     * @param variable the new quantified variable to set
     */
    public final void setVariable(final int variable) {
        this.variable = variable;
    }

    /**
     * Returns the type of the quantified variable of the expression.
     *
     * @return the type of the quantified variable of the expression.
     */
    public final int getType() {
        return this.type;
    }

    /**
     * Set a new type to the quantified variable of the expression.
     *
     * @param type the type to the quantified variable to set.
     */
    public final void setType(final int type) {
        this.type = type;
    }

    /**
     * Returns the value of this expression.
     *
     * @return the value of this expression.
     */
    public final double getValue() {
        return this.value;
    }

    /**
     * Sets a new value to the expression.
     *
     * @param value the new value to set
     */
    public final void setValue(double value) {
        this.value = value;
    }

    /**
     * Returns <code>true</code> if the expression is a primitive task.
     *
     * @return <code>true</code> if the expression is a primitive task, <code>false</code> otherwise.
     */
    public final boolean isPrimtive() {
        return this.isPrimtive;
    }

    /**
     * Sets the boolean flag used to specified if the expression is a primitive task to a specified value.
     *
     * @param flag the flag.
     */
    public final void setPrimtive(final boolean flag) {
        this.isPrimtive = flag;
    }

    /**
     * Affects this expression to an other. After affectation this expression and the other are
     * equal. No copy of the content of the other expression is done.
     *
     * @param other expression.
     */
    public final void affect(final IntExpression other) {
        this.connective = other.getConnective();
        this.predicate = other.getPredicate();
        this.taskID = other.getTaskID();
        this.arguments = other.getArguments();
        this.children = other.getChildren();
        this.variable = other.getVariable();
        this.type = other.getType();
        this.value = other.getValue();
        this.isPrimtive = other.isPrimtive();
    }

    /**
     * Returns if the expression is equal to an other object. The primitive flag and the task id are not used for
     * comparison.
     *
     * @param object the other object.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof IntExpression) {
            final IntExpression other = (IntExpression) object;
            return this.connective.equals(other.connective)
                && this.predicate == other.predicate
                && Arrays.equals(this.arguments, other.arguments)
                && Double.compare(this.value, other.value) == 0
                && this.variable == other.variable
                && this.type == other.type
                && this.children.equals(other.children)
                && this.isPrimtive() == other.isPrimtive();
        }
        return false;
    }

    /**
     * Returns the hash code value of the expression.
     *
     * @return the hash code value of the expression.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(this.arguments);
        result = prime * result + this.children.hashCode();
        result = prime * result + this.connective.hashCode();
        result = prime * result + this.predicate;
        result = prime * result + this.type;
        long temp;
        temp = Double.doubleToLongBits(this.value);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + this.variable;
        return result;
    }


    /**
     * Substitutes all occurrence of a specified variable into an expression by a constant.
     *
     * @param var  the variable.
     * @param cons the constant.
     */
    public void substitute(final int var, final int cons, IProblem pb) {
        switch (this.getConnective()) {
            case ATOM:
                boolean updated = false;
                int[] args = this.getArguments();
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == var) {
                        args[i] = cons;
                        updated = true;
                    }
                }
                if (updated) {
                    pb.simplyAtom(this);
                }
                break;
            case TASK:
            case FN_HEAD:
                args = this.getArguments();
                for (int i = 0; i < args.length; i++) {
                    if (args[i] == var) {
                        args[i] = cons;
                    }
                }
                break;

            case EQUAL_ATOM:
                args = this.getArguments();
                // Get and substitute the first argument
                final int arg1 = args[0];
                if (arg1 == var) {
                    args[0] = cons;
                }
                // Get and substitute the second argument
                final int arg2 = args[1];
                if (arg2 == var) {
                    args[1] = cons;
                }
                // The equality is TRUE: arg1 and arg2 are the same variable or the same constant
                if (arg1 == arg2) {
                    this.setConnective(PDDLConnective.TRUE);
                } else if (arg1 >= 0 && arg2 >= 0) {
                    // The equality is ground and the equality is FALSE because arg1 != arg2
                    this.setConnective(PDDLConnective.FALSE);
                }
                break;
            case AND:
                Iterator<IntExpression> i = this.getChildren().iterator();
                while (i.hasNext() && this.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    ei.substitute(var, cons, pb);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        this.setConnective(PDDLConnective.FALSE);
                    }
                }
                break;
            case OR:
                i = this.getChildren().iterator();
                while (i.hasNext() && this.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    ei.substitute(var, cons, pb);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        this.setConnective(PDDLConnective.TRUE);
                    }
                }
                break;
            case NOT:
                final IntExpression neg = this.getChildren().get(0);
                neg.substitute(var, cons, pb);
                if (neg.getConnective().equals(PDDLConnective.TRUE)) {
                    this.setConnective(PDDLConnective.FALSE);
                } else if (neg.getConnective().equals(PDDLConnective.FALSE)) {
                    this.setConnective(PDDLConnective.TRUE);
                }
                break;
            case WHEN:

                for (IntExpression ei : this.getChildren()) {
                    ei.substitute(var, cons, pb);
                }
                break;
            default:
        }
    }

    /**
     * Expands the quantified expressions contained in a specified expression.
     *
     * @param domains the domains of the quantified variables.
     */
    public void expandQuantifiedExpression(final List<Set<Integer>> domains, IProblem pb) {
        switch (this.getConnective()) {
            case AND:
                Iterator<IntExpression> i = this.getChildren().iterator();
                while (i.hasNext() && this.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = i.next();
                    // Remove quantified expression where the domain of the quantified variable is empty
                    if ((ei.getConnective().equals(PDDLConnective.FORALL)
                        || ei.getConnective().equals(PDDLConnective.EXISTS))
                        && domains.get(ei.getType()).isEmpty()) {
                        i.remove();
                        continue;
                    }
                    ei.expandQuantifiedExpression(domains, pb);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        this.setConnective(PDDLConnective.FALSE);
                    }
                    // Remove conditional effect whose effect are alway false
                    if (ei.getConnective().equals(PDDLConnective.WHEN)
                        && ei.getChildren().get(1).getConnective().equals(PDDLConnective.FALSE)) {
                        i.remove();
                    }
                }
                break;
            case OR:
                i = this.getChildren().iterator();
                while (i.hasNext() && this.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = i.next();
                    // Remove quantified expression where the domain of the quantified variable is empty
                    if ((ei.getConnective().equals(PDDLConnective.FORALL)
                        || ei.getConnective().equals(PDDLConnective.EXISTS))
                        && domains.get(ei.getType()).isEmpty()) {
                        i.remove();
                        continue;
                    }
                    ei.expandQuantifiedExpression(domains, pb);
                    // If a child expression is TRUE, the whole disjunction becomes TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        this.setConnective(PDDLConnective.TRUE);
                    }
                    // Remove conditional effect whose effect are always false
                    if (ei.getConnective().equals(PDDLConnective.WHEN)
                        && ei.getChildren().get(1).getConnective().equals(PDDLConnective.FALSE)) {
                        i.remove();
                    }
                }
                break;
            case FORALL:
                Set<Integer> constants = domains.get(this.getType());
                IntExpression qExp = this.getChildren().get(0);
                int var = this.getVariable();
                this.setConnective(PDDLConnective.AND);
                this.getChildren().clear();
                Iterator<Integer> it = constants.iterator();
                while (it.hasNext() && this.getConnective().equals(PDDLConnective.AND)) {
                    int cons = it.next();
                    IntExpression copy = new IntExpression(qExp);
                    copy.substitute(var, cons, pb);
                    this.getChildren().add(copy);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (copy.getConnective().equals(PDDLConnective.FALSE)) {
                        this.setConnective(PDDLConnective.FALSE);
                    }
                }
                this.expandQuantifiedExpression(domains, pb);
                break;
            case EXISTS:
                constants = domains.get(this.getType());
                qExp = this.getChildren().get(0);
                var = this.getVariable();
                this.setConnective(PDDLConnective.OR);
                this.getChildren().clear();
                it = constants.iterator();
                while (it.hasNext() && this.getConnective().equals(PDDLConnective.OR)) {
                    int cons = it.next();
                    IntExpression copy = new IntExpression(qExp);
                    copy.substitute(var, cons, pb);
                    this.getChildren().add(copy);
                    // If a child expression is TRUE, the whole disjunction becomes TRUE.
                    if (copy.getConnective().equals(PDDLConnective.TRUE)) {
                        this.setConnective(PDDLConnective.TRUE);
                    }
                }
                this.expandQuantifiedExpression(domains, pb);
                break;
            case ATOM:
                pb.simplyAtom(this);
                break;
            default:
                for (IntExpression ei : this.getChildren()) {
                    ei.expandQuantifiedExpression(domains, pb);
                }

        }
        this.simplify();
    }

    /**
     * Move negation inward the expression.
     */
    public void moveNegationInward() {
        switch (this.getConnective()) {
            case NOT:
                IntExpression p = this.getChildren().get(0);
                switch (p.getConnective()) {
                    case FORALL:
                        this.setConnective(PDDLConnective.EXISTS);
                        IntExpression notP = new IntExpression(PDDLConnective.NOT);
                        notP.addChild(p);
                        this.children.set(0, notP);
                        notP.moveNegationInward();
                        break;
                    case EXISTS:
                        this.setConnective(PDDLConnective.FORALL);
                        notP = new IntExpression(PDDLConnective.NOT);
                        notP.addChild(p);
                        this.children.set(0, notP);
                        notP.moveNegationInward();
                        break;
                    case AND:
                        if (this.getChildren().size() > 1) {
                            this.setConnective(PDDLConnective.OR);
                            this.getChildren().clear();
                            for (int i = 0; i < p.getChildren().size(); i++) {
                                IntExpression q = new IntExpression(PDDLConnective.NOT);
                                q.addChild(p.getChildren().get(i));
                                q.moveNegationInward();
                                this.addChild(q);
                            }
                        } else {
                            this.affect(this.getChildren().get(0));
                            this.moveNegationInward();
                        }
                        break;
                    case OR:
                        if (this.getChildren().size() > 1) {
                            this.setConnective(PDDLConnective.AND);
                            this.getChildren().clear();
                            for (int i = 0; i < p.getChildren().size(); i++) {
                                IntExpression q = new IntExpression(PDDLConnective.NOT);
                                q.addChild(p.getChildren().get(i));
                                q.moveNegationInward();
                                this.addChild(q);
                            }
                        } else {
                            this.affect(this.getChildren().get(0));
                            this.moveNegationInward();
                        }
                        break;
                    /*case IMPLY: // ¬(p =>) q = p and ¬q
                        p.expandImply();
                        this.moveNegationInward();
                        break;*/
                    case NOT:
                        IntExpression neg = p.getChildren().get(0);
                        this.affect(neg);
                        this.moveNegationInward();
                        break;
                    case AT_START:
                    case AT_END:
                    case OVER_ALL:
                        this.setConnective(p.getConnective());
                        p.setConnective(PDDLConnective.NOT);
                        p.moveNegationInward();
                        break;
                    default:
                        // do nothing
                }
                break;
            /*case IMPLY: // p => q = (¬p) ∨ q
                this.setConnective(PDDLConnective.OR);
                final IntExpression notP = new IntExpression(PDDLConnective.NOT);
                notP.addChild(this.getChildren().get(0));
                notP.moveNegationInward();
                this.getChildren().get(1).moveNegationInward();
                this.getChildren().set(0, notP);
                break;*/
            default:
                this.children.forEach(IntExpression::moveNegationInward);
                break;
                // do nothing
        }
    }

    /**
     * Move time specifier inward the expression.
     */
    public void moveTimeSpecifierInward() {
        switch (this.getConnective()) {
            case AND:
            case OR:
                this.children.forEach(IntExpression::moveTimeSpecifierInward);
                break;
            case NOT:
            case FORALL:
            case EXISTS:
            case ALWAYS:
            case SOMETIME:
            case AT_MOST_ONCE:
                this.getChildren().get(0).moveTimeSpecifierInward();
                break;
            case WHEN:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
                this.getChildren().get(0).moveTimeSpecifierInward();
                this.getChildren().get(1).moveTimeSpecifierInward();
                break;
            case WITHIN:
            case HOLD_AFTER:
                this.getChildren().get(1).moveTimeSpecifierInward();
                break;
            case ALWAYS_WITHIN:
                this.getChildren().get(1).moveTimeSpecifierInward();
                this.getChildren().get(2).moveTimeSpecifierInward();
                break;
            case HOLD_DURING:
                this.getChildren().get(3).moveTimeSpecifierInward();
                break;
            /*case IMPLY: // p => q = (¬p) ∨ q
                this.setConnective(PDDLConnective.OR);
                final IntExpression notP = new IntExpression(PDDLConnective.NOT);
                notP.addChild(this.getChildren().get(0));
                notP.moveTimeSpecifierInward();
                this.getChildren().get(1).moveTimeSpecifierInward();
                this.getChildren().set(0, notP);
                break;*/
            case AT_START:
            case AT_END:
            case OVER_ALL:
                IntExpression p = this.getChildren().get(0);
                switch (p.getConnective()) {
                    case FORALL:
                        p.setConnective(this.getConnective());
                        this.setConnective(PDDLConnective.FORALL);
                        this.setVariable(p.getVariable());
                        this.setType(p.getType());
                        p.moveTimeSpecifierInward();
                        break;
                    case EXISTS:
                        p.setConnective(this.getConnective());
                        this.setConnective(PDDLConnective.EXISTS);
                        this.setVariable(p.getVariable());
                        this.setType(p.getType());
                        p.moveTimeSpecifierInward();
                        break;
                    case AND:
                        this.getChildren().clear();
                        for (int i = 0; i < p.getChildren().size(); i++) {
                            IntExpression q = new IntExpression(this.getConnective());
                            q.addChild(p.getChildren().get(i));
                            q.moveTimeSpecifierInward();
                            this.addChild(q);
                        }
                        this.setConnective(PDDLConnective.AND);
                        break;
                    case OR:
                        this.getChildren().clear();
                        for (int i = 0; i < p.getChildren().size(); i++) {
                            final IntExpression q = new IntExpression(this.getConnective());
                            q.addChild(p.getChildren().get(i));
                            q.moveTimeSpecifierInward();
                            this.addChild(q);
                        }
                        this.setConnective(PDDLConnective.OR);
                        break;
                    /*case IMPLY:
                        p.expandImply();
                        this.moveTimeSpecifierInward();
                        break;*/
                    case NOT:
                        p.setConnective(this.getConnective());
                        this.setConnective(PDDLConnective.NOT);
                        break;
                    case WHEN:
                        final IntExpression timeCondition = new IntExpression(this.getConnective());
                        timeCondition.addChild(p.getChildren().get(0));
                        timeCondition.moveTimeSpecifierInward();
                        final IntExpression timeEffect = new IntExpression(this.getConnective());
                        timeEffect.addChild(p.getChildren().get(1));
                        timeEffect.moveTimeSpecifierInward();
                        this.setConnective(PDDLConnective.WHEN);
                        this.children.clear();
                        this.children.add(timeCondition);
                        this.children.add(timeEffect);
                        break;
                    default:
                        // do nothing
                }
                break;
            default:
                // do nothing
        }
    }

    /**
     * Convert an expression in conjunctive normal form (CNF).
     *
     */
    public void toCNF() {
        switch (this.getConnective()) {
            case WHEN:
                final IntExpression conditions = this.getChildren().get(0);
                final IntExpression effect = this.getChildren().get(1);
                this.setConnective(PDDLConnective.AND);
                this.getChildren().clear();

                final IntExpression newWhen = new IntExpression(PDDLConnective.WHEN);
                conditions.toDNF();
                newWhen.addChild(conditions);
                effect.toCNF();
                newWhen.addChild(effect);
                this.getChildren().add(newWhen);
                break;
            case AND:
                final List<IntExpression> children = this.getChildren();
                int i = 0;
                while (i < children.size()) {
                    final IntExpression ei = children.get(i);
                    ei.toCNF();
                    this.getChildren().remove(i);
                    for (IntExpression ej : ei.getChildren()) {
                        this.getChildren().add(i, ej);
                        i++;
                    }
                }
                break;
            case ATOM:
            case NOT:
            case TRUE:
            case ASSIGN:
            case DECREASE:
            case INCREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case PLUS:
            case MINUS:
            case UMINUS:
            case MUL:
            case DIV:
            case AT_START:
            case AT_END:
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
            case OVER_ALL:
                IntExpression copy = new IntExpression(this);
                this.setConnective(PDDLConnective.AND);
                this.getChildren().clear();
                this.getChildren().add(copy);
                break;
            default:
                throw new UnexpectedExpressionException(this.getConnective().getImage());
        }
    }

    /**
     * Convert an expression in disjunctive normal form (DNF).
     *
     */
    public void toDNF() throws UnexpectedExpressionException {
        // Suppress imply
        // Move negation inward
        // Distribute the
        switch (this.getConnective()) {
            case OR:
                List<IntExpression> children = this.getChildren();
                int index = 0;
                while (index < children.size()) {
                    final IntExpression ei = children.get(index);
                    ei.toDNF();
                    if (ei.getConnective().equals(PDDLConnective.OR)) {
                        children.remove(index);
                        for (IntExpression ej : ei.getChildren()) {
                            children.add(index, ej);
                            index++;
                        }
                    }
                }
                break;
            case AND:
                children = this.getChildren();
                for (IntExpression child : children) {
                    child.toDNF();
                }
                IntExpression dnf = this.getChildren().get(0);
                for (int i = 1; i < this.getChildren().size(); i++) {
                    final IntExpression orExp = this.getChildren().get(i);
                    final IntExpression newOr = new IntExpression(PDDLConnective.OR);
                    for (IntExpression newAnd : dnf.getChildren()) {
                        for (IntExpression ek : orExp.getChildren()) {
                            ek.getChildren().stream().filter(el -> !newAnd.getChildren().contains(el)).forEach(el -> {
                                if (el.getConnective().equals(PDDLConnective.OR)
                                    || el.getConnective().equals(PDDLConnective.AND)
                                    && el.getChildren().size() == 1) {
                                    newAnd.getChildren().add(el.getChildren().get(0));
                                } else {
                                    newAnd.getChildren().add(el);
                                }
                            });
                            boolean add = true;
                            for (IntExpression el : newAnd.getChildren()) {
                                if (el.getConnective().equals(PDDLConnective.FALSE)) {
                                    add = false;
                                    break;
                                }
                            }
                            if (add) {
                                if (newAnd.getChildren().size() == 1) {
                                    newOr.getChildren().add(newAnd.getChildren().get(0));
                                } else {
                                    newOr.getChildren().add(newAnd);
                                }
                            }
                        }
                    }
                    dnf = newOr;
                }
                this.affect(dnf);
                break;
            case ATOM:
            case NOT:
            case TRUE:
            case ASSIGN:
            case DECREASE:
            case INCREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case PLUS:
            case MINUS:
            case UMINUS:
            case MUL:
            case DIV:
            case AT_START:
            case AT_END:
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
            case OVER_ALL:
                IntExpression and = new IntExpression(PDDLConnective.AND);
                and.getChildren().add(new IntExpression(this));
                this.setConnective(PDDLConnective.OR);
                this.getChildren().clear();
                this.getChildren().add(and);
                break;
            default:
                throw new UnexpectedExpressionException(this.getConnective().getImage());
        }
    }

    /**
     * Convert an expression in conjunctive normal form (CNF).
     *
     */
    public void toConjunctiveNormalForm(IProblem pb) {

        this.moveNegationInward();
        switch (this.getConnective()) {
            case AND:
                List<IntExpression> children = new ArrayList<>();
                for (IntExpression e : this.getChildren()) {
                    e.toConjunctiveNormalForm(pb);
                    if (e.getConnective().equals(PDDLConnective.WHEN)) {
                        IntExpression condition = e.getChildren().get(0);
                        IntExpression effect = e.getChildren().get(1);
                        for (IntExpression c : condition.getChildren()) {
                            IntExpression when = new IntExpression(PDDLConnective.WHEN);
                            when.addChild(c);
                            when.addChild(new IntExpression(effect));
                            children.add(when);
                        }
                    } else {
                        // Suppress not useful inner and
                        if (e.getConnective().equals(PDDLConnective.AND)) {
                            children.addAll(e.getChildren());
                        } else {
                            children.add(e);
                        }
                    }
                }
                this.children.clear();
                this.children.addAll(children);
                break;
            case OR:
                for (IntExpression e : this.children) {
                    e.toConjunctiveNormalForm(pb);
                }
                this.distribute(pb);
                break;
            case WHEN:
                this.getChildren().get(0).toDisjunctiveNormalForm(pb);
                this.getChildren().get(1).toConjunctiveNormalForm(pb);
                break;
            case ATOM:
            case NOT:
            case TRUE:
            case FALSE:
            case ASSIGN:
            case DECREASE:
            case INCREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case PLUS:
            case MINUS:
            case UMINUS:
            case MUL:
            case DIV:
            case AT_START:
            case AT_END:
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
            case OVER_ALL:
                IntExpression copy = new IntExpression(this);
                this.setConnective(PDDLConnective.AND);
                this.getChildren().clear();
                this.getChildren().add(copy);
                break;
            default:
                throw new UnexpectedExpressionException(this.getConnective().getImage());
        }
    }

    /**
     * Convert an expression in disjunctive normal form (DNF).
     *
     */
    public void toDisjunctiveNormalForm(IProblem pb) throws UnexpectedExpressionException {
        // Suppress imply
        // Move negation inward
        this.moveNegationInward();
        // Distribute the
        switch (this.getConnective()) {
            case OR:
                for (IntExpression e : this.getChildren()) {
                    e.toDisjunctiveNormalForm(pb);
                }
                break;
            case AND:
                for (IntExpression e : this.children) {
                    e.toDisjunctiveNormalForm(pb);
                }
                this.distribute(pb);
                break;
            case WHEN:
                this.getChildren().get(0).toDisjunctiveNormalForm(pb);
                this.getChildren().get(1).toConjunctiveNormalForm(pb);
                break;
            case ATOM:
            case NOT:
            case TRUE:
            case ASSIGN:
            case DECREASE:
            case INCREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case PLUS:
            case MINUS:
            case UMINUS:
            case MUL:
            case DIV:
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case LESS:
            case LESS_OR_EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case EQUAL:
            case EQUAL_ATOM:
            case FALSE:
                IntExpression exp = new IntExpression(this);
                this.setConnective(PDDLConnective.OR);
                this.getChildren().clear();
                this.getChildren().add(exp);
                break;
            default:
                throw new UnexpectedExpressionException(this.getConnective().toString());
        }
    }

    /**
     * This method distribute the logical AND or OR to the
     *
     * @param index
     * @param acc
     * @param result
     */
    private void distribute(int index, IntExpression acc, IntExpression result, IProblem pb) {
        if (this.getChildren().size() == index) {
            if ((acc.getConnective().equals(PDDLConnective.AND)
                || acc.getConnective().equals(PDDLConnective.OR))
                && acc.getChildren().size() == 1) {
                result.addChild(acc.getChildren().get(0));
            } else {
                result.addChild(acc);
            }
        } else {
            final IntExpression e = this.getChildren().get(index);
            index++;
            for (IntExpression ei: e.getChildren()) {
                IntExpression copy = new IntExpression(acc);
                copy.addChild(ei);
                this.distribute(index, copy, result, pb);
            }
        }
    }

    /**
     *
     */
    private void distribute(IProblem pb) {
        if (this.getConnective().equals(PDDLConnective.AND)) {
            IntExpression or = new IntExpression(PDDLConnective.OR);
            this.distribute(0, new IntExpression(PDDLConnective.AND), or, pb);
            this.setConnective(PDDLConnective.OR);
            this.getChildren().clear();
            this.getChildren().addAll(or.getChildren());
        }
        else if (this.getConnective().equals(PDDLConnective.OR)) {
            IntExpression and = new IntExpression(PDDLConnective.AND);
            this.distribute(0, new IntExpression(PDDLConnective.OR), and, pb);
            this.setConnective(PDDLConnective.AND);
            this.getChildren().clear();
            this.getChildren().addAll(and.getChildren());
        }

    }

    public static void main(String[] args) {

        IntExpression and = new IntExpression(PDDLConnective.AND);

        IntExpression or1 = new IntExpression(PDDLConnective.OR);
        IntExpression A = new IntExpression(PDDLConnective.ATOM);
        A.setPredicate(1);
        or1.addChild(A);
        System.out.println("OR1 :  "+ or1.toString(" ", " "));


        IntExpression or2 = new IntExpression(PDDLConnective.OR);
        IntExpression B = new IntExpression(PDDLConnective.ATOM);
        B.setPredicate(2);
        or2.addChild(B);
        IntExpression C = new IntExpression(PDDLConnective.ATOM);
        C.setPredicate(3);
        or2.addChild(C);

        System.out.println("OR2 :  "+ or2.toString(" ", " "));

        IntExpression or3 = new IntExpression(PDDLConnective.OR);
        IntExpression D = new IntExpression(PDDLConnective.ATOM);
        D.setPredicate(4);
        or3.addChild(D);
        IntExpression E = new IntExpression(PDDLConnective.ATOM);
        E.setPredicate(5);
        or3.addChild(E);

        System.out.println("OR3 :  "+ or3.toString(" ", " "));

        and.addChild(or1);
        and.addChild(or2);
        and.addChild(or3);

        System.out.println(and.toString(" ", " "));
        IntExpression or = new IntExpression(PDDLConnective.OR);
        //distribute(and, 0, new IntExpression(PDDLConnective.AND), or);
        //and.distribute();
        System.out.println(and.toString(" ", " "));


    }


    /**
     * This method simplify a specified expression. The rules of simplification are as below:
     * <ul>
     * <li> not true eqv false </li>
     * <li> true ^ phi eqv phi </li>
     * <li> false ^ phi eqv false </li>
     * <li> true v phi eqv true </li>
     * <li> false v phi eqv false </li>
     * <li> not false eqv true </li>
     * <li> phi ^ phi eqv phi </li>
     * <li> phi v phi eqv phi </li>
     * <li> phi ^ not phi eqv false </li>
     * <li> phi v not phi eqv true </li>
     * <li> x = x eqv true </li>
     * <li> x = y eqv false </li>
     * </ul>
     *
     */
    public void simplify() {
        switch (this.getConnective()) {
            case ATOM:
                break;
            case FN_HEAD:
                break;
            case EQUAL_ATOM:
                int[] args = this.getArguments();
                // Get and substitute the first argument
                final int arg1 = args[0];
                // Get and substitute the second argument
                final int arg2 = args[1];
                if (arg1 == arg2) {
                    // The equality is TRUE: arg1 and arg2 are the same variable or the same constant
                    this.setConnective(PDDLConnective.TRUE);
                } else if (arg1 >= 0 && arg2 >= 0) {
                    // The equality is ground and the equality is FALSE because arg1 != arg2
                    this.setConnective(PDDLConnective.FALSE);
                }
                break;
            case AND:
                int i = 0;
                while (i < this.getChildren().size() && this.getConnective().equals(PDDLConnective.AND)) {
                    final IntExpression ei = this.getChildren().get(i);
                    ei.simplify();
                    if (ei.getConnective().equals(PDDLConnective.FALSE)) {
                        // If a child expression is FALSE, the whole conjunction becomes FALSE.
                        this.setConnective(PDDLConnective.FALSE);
                    } else if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        // If a child expression is TRUE, we can remove the child expression.
                        this.getChildren().remove(i);
                    } else if (ei.getConnective().equals(PDDLConnective.AND)) {
                        // If the child expression to addValue is a conjunction, we can simplify the expression by
                        this.getChildren().remove(i); // removing the inner conjunction.
                        int j = 0;
                        int added = 0;
                        while (j < ei.getChildren().size() && this.getConnective().equals(PDDLConnective.AND)) {
                            final IntExpression ej = ei.getChildren().get(j);
                            if (ej.getConnective().equals(PDDLConnective.FALSE)) {
                                this.setConnective(PDDLConnective.FALSE);
                            } else if (!ej.getConnective().equals(PDDLConnective.TRUE)) {
                                this.getChildren().add(i + added, ej);
                                added++;
                            }
                            j++;
                        }
                        i += added + 1;
                    } else if (ei.getConnective().equals(PDDLConnective.WHEN)) {
                        // Simplification of the conditional expression.
                        final IntExpression antecedent = ei.getChildren().get(0);
                        final IntExpression consequent = ei.getChildren().get(1);
                        // If the antecedent of a conditional effect becomes FALSE , the conditional
                        // effect is removed from the action. In this case, the effect is never applicable
                        // because it requires FALSE to hold, i.e., the state must be inconsistent.
                        if (antecedent.getConnective().equals(PDDLConnective.FALSE)) {
                            this.getChildren().remove(i);
                        } else if (antecedent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the antecedent of a conditional effect becomes TRUE, the conditional
                            // effect becomes unconditional.
                            if (consequent.getConnective().equals(PDDLConnective.AND)) {
                                this.getChildren().remove(i);
                                int j = 0;
                                int added = 0;
                                while (j < consequent.getChildren().size()
                                    && this.getConnective().equals(PDDLConnective.AND)) {

                                    final IntExpression ej = consequent.getChildren().get(j);
                                    if (ej.getConnective().equals(PDDLConnective.FALSE)) {
                                        this.setConnective(PDDLConnective.FALSE);
                                    } else if (!ej.getConnective().equals(PDDLConnective.TRUE)) {
                                        this.getChildren().add(i + added, ej);
                                        added++;
                                    }
                                    j++;
                                }
                                i += added + 1;
                            } else {
                                this.getChildren().set(i, consequent);
                                i++;
                            }
                        } else if (consequent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the consequent of a conditional effect becomes TRUE, the conditional
                            // effect is removed because it does not lead to any state transition.
                            this.getChildren().remove(i);
                        } else {
                            i++;
                        }
                    } else {
                        i++;
                    }
                }
                // Finally, if the conjunction is empty, the expression becomes TRUE.
                if (this.getChildren().isEmpty()) {
                    this.setConnective(PDDLConnective.TRUE);
                } else if (this.getChildren().size() == 1) {
                    this.affect(this.getChildren().get(0));
                }
                break;
            case OR:
                i = 0;
                while (i < this.getChildren().size() && this.getConnective().equals(PDDLConnective.OR)) {
                    final IntExpression ei = this.getChildren().get(i);
                    ei.simplify();
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        this.setConnective(PDDLConnective.TRUE);
                    } else if (ei.getConnective().equals(PDDLConnective.OR)) {
                        // If the child expression to addValue is a disjunction, we can simplify the expression by
                        // removing the inner disjunction.
                        this.getChildren().remove(i);
                        int j = 0;
                        int added = 0;
                        while (j < ei.getChildren().size() && this.getConnective().equals(PDDLConnective.OR)) {
                            final IntExpression ej = ei.getChildren().get(j);
                            if (ej.getConnective().equals(PDDLConnective.TRUE)) {
                                this.setConnective(PDDLConnective.TRUE);
                            } else if (!ej.getConnective().equals(PDDLConnective.FALSE)) {
                                this.getChildren().add(i + added, ej);
                                added++;
                            }
                            j++;
                        }
                        i += added + 1;
                    } else if (ei.getConnective().equals(PDDLConnective.WHEN)) {
                        // Simplification of the conditional expression.
                        final IntExpression antecedent = ei.getChildren().get(0);
                        final IntExpression consequent = ei.getChildren().get(1);
                        // If the antecedent of a conditional effect becomes FALSE , the conditional effect is
                        // removed from the action. In this case, the effect is never applicable because it
                        // requires FALSE to hold, i.e., the state must be inconsistent.
                        if (antecedent.getConnective().equals(PDDLConnective.FALSE)) {
                            this.getChildren().remove(i);
                        } else if (antecedent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the antecedent of a conditional effect becomes TRUE, the conditional effect
                            // becomes unconditional.
                            if (consequent.getConnective().equals(PDDLConnective.OR)) {
                                this.getChildren().remove(i);
                                int j = 0;
                                int added = 0;
                                while (j < consequent.getChildren().size()
                                    && this.getConnective().equals(PDDLConnective.OR)) {

                                    final IntExpression ej = consequent.getChildren().get(j);
                                    if (ej.getConnective().equals(PDDLConnective.TRUE)) {
                                        this.setConnective(PDDLConnective.TRUE);
                                    } else if (!ej.getConnective().equals(PDDLConnective.FALSE)) {
                                        this.getChildren().add(i + added, ej);
                                        added++;
                                    }
                                    j++;
                                }
                                i += added + 1;
                            } else {
                                this.getChildren().set(i, consequent);
                                i++;
                            }
                        } else if (consequent.getConnective().equals(PDDLConnective.TRUE)) {
                            // If the consequent of a conditional effect becomes TRUE, the conditional
                            // effect is removed because it does not lead to any state transition.
                            this.getChildren().remove(i);
                        } else {
                            i++;
                        }
                    } else {
                        i++;
                    }
                }
                // Finally, if the disjunction is empty, the expression becomes TRUE.
                if (this.getChildren().isEmpty()) {
                    this.setConnective(PDDLConnective.TRUE);
                } else if (this.getChildren().size() == 1) {
                    this.affect(this.getChildren().get(0));
                } else {
                    final Iterator<IntExpression> it = this.getChildren().iterator();
                    while (it.hasNext()) {
                        if (it.next().getConnective().equals(PDDLConnective.FALSE)) {
                            it.remove();
                        }
                    }
                    if (this.getChildren().isEmpty()) {
                        this.setConnective(PDDLConnective.FALSE);
                    }
                }
                break;
            case AT_START:
            case AT_END:
            case OVER_ALL:
                final IntExpression fluent = this.getChildren().get(0);
                fluent.simplify();
                break;
            case FORALL:
            case EXISTS:
            case UMINUS:
            case ALWAYS:
            case SOMETIME:
            case AT_MOST_ONCE:
                this.getChildren().get(0).simplify();
                break;
            case NOT:
                final IntExpression neg = this.getChildren().get(0);
                neg.simplify();
                if (neg.getConnective().equals(PDDLConnective.TRUE)) {
                    this.setConnective(PDDLConnective.FALSE);
                } else if (neg.getConnective().equals(PDDLConnective.FALSE)) {
                    this.setConnective(PDDLConnective.TRUE);
                }
                break;
            case WHEN:
                this.getChildren().get(0).simplify();
                this.getChildren().get(1).simplify();
                break;
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MUL:
            case DIV:
            case MINUS:
            case PLUS:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
            case WITHIN:
            case HOLD_AFTER:
                this.getChildren().get(0).simplify();
                this.getChildren().get(1).simplify();
                break;
            case F_EXP_T:
            case F_EXP:
                if (!this.getChildren().isEmpty()) {
                    this.getChildren().get(0).simplify();
                }
                break;
            case ALWAYS_WITHIN:
            case HOLD_DURING:
                this.getChildren().get(0).simplify();
                this.getChildren().get(1).simplify();
                this.getChildren().get(3).simplify();
                break;
            case NUMBER:
            case DURATION_ATOM:
            case TIME_VAR:
            case IS_VIOLATED:
            case MINIMIZE:
            case MAXIMIZE:
                break;
            default:
                // do nothing
        }
    }

    /**
     * Returns a string representation of an expression.
     *
     * @param baseOffset the offset white space from the left used for indentation.
     * @param separator  the string separator between predicate symbol and arguments.
     * @return a string representation of the specified expression node.
     */
    private String toString(String baseOffset, final String separator) {
        final StringBuilder str = new StringBuilder();
        switch (this.getConnective()) {
            case ATOM:
                str.append("(P");
                str.append(this.getPredicate());
                int[] args = this.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ");
                        str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                        str.append(-index - 1);
                    } else {
                        str.append(" C");
                        str.append(index);
                    }
                }
                str.append(")");
                break;
            case FN_HEAD:
                str.append("(F");
                str.append(this.getPredicate());
                args = this.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ");
                        str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                        str.append(-index - 1);
                    } else {
                        str.append(" C");
                        str.append(index);
                    }
                }
                str.append(")");
                break;
            case TASK:
                str.append("(");
                if (this.getTaskID() != IntExpression.DEFAULT_TASK_ID) {
                    str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                    str.append(this.getTaskID());
                    str.append(" (");
                }
                str.append("T" + this.getPredicate());
                args = this.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ");
                        str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                        str.append(-index - 1);
                    } else {
                        str.append(" ").append("C" + index);
                    }
                }
                if (this.getTaskID() != IntExpression.DEFAULT_TASK_ID) {
                    str.append(")");
                }
                str.append(")");
                break;
            case EQUAL_ATOM:
                str.append("(").append("=");
                args = this.getArguments();
                for (int index : args) {
                    if (index < 0) {
                        str.append(" ");
                        str.append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                        str.append(-index - 1);
                    } else {
                        str.append(" ");
                        str.append("C"+ index);
                    }
                }
                str.append(")");
                break;
            case AND:
            case OR:
                String offsetOr = baseOffset + "  ";
                str.append("(");
                str.append(this.getConnective().getImage());
                str.append(" ");
                if (!this.getChildren().isEmpty()) {
                    for (int i = 0; i < this.getChildren().size() - 1; i++) {
                        str.append(this.getChildren().get(i).toString(offsetOr, " "));
                        str.append("\n");
                        str.append(offsetOr);
                    }
                    str.append(this.getChildren()
                        .get(this.getChildren().size() - 1).toString(offsetOr, " "));
                }
                str.append(")");
                break;
            case FORALL:
            case EXISTS:
                str.append(" (").append(this.getConnective().getImage());
                str.append(" (").append(PDDLSymbol.DEFAULT_VARIABLE_SYMBOL);
                str.append(-this.getVariable() - 1);
                str.append(" - ");
                String offsetEx = baseOffset + baseOffset + "  ";
                str.append("T" + this.getType());
                str.append(")\n");
                str.append(offsetEx);
                if (this.getChildren().size() == 1) {
                    str.append(this.getChildren().get(0).toString(offsetEx, " "));
                }
                str.append(")");
                break;
            case NUMBER:
                str.append(this.getValue());
                break;
            case F_EXP:
                str.append(this.getChildren().get(0).toString(baseOffset, " "));
                break;
            case F_EXP_T:
            case TRUE:
            case FALSE:
                str.append(this.getConnective());
                break;
            case TIME_VAR:
                str.append(this.getConnective().getImage());
                break;
            case FN_ATOM:
            case WHEN:
            case DURATION_ATOM:
            case LESS:
            case LESS_OR_EQUAL:
            case EQUAL:
            case GREATER:
            case GREATER_OR_EQUAL:
            case ASSIGN:
            case INCREASE:
            case DECREASE:
            case SCALE_UP:
            case SCALE_DOWN:
            case MUL:
            case DIV:
            case MINUS:
            case PLUS:
            case SOMETIME_AFTER:
            case SOMETIME_BEFORE:
                str.append("(");
                str.append(this.getConnective().getImage());
                str.append(" ");
                str.append(this.getChildren().get(0).toString(baseOffset, " "));
                str.append(" ");
                str.append(this.getChildren().get(1).toString(baseOffset, " "));
                str.append(")");
                break;
            case AT_START:
            case AT_END:
            case OVER_ALL:
            case MINIMIZE:
            case MAXIMIZE:
            case UMINUS:
            case NOT:
            case ALWAYS:
                str.append("(");
                str.append(this.getConnective().getImage());
                str.append(" ");
                str.append(this.getChildren().get(0).toString(baseOffset, " "));
                str.append(")");
                break;
            case IS_VIOLATED:
                str.append("(");
                str.append(this.getConnective().getImage());
                str.append(")");
                break;
            case LESS_ORDERING_CONSTRAINT:
                str.append("(");
                str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(this.getChildren().get(0).getTaskID());
                str.append(" ");
                str.append(this.getConnective().getImage());
                str.append(" ");
                str.append(PDDLSymbol.DEFAULT_TASK_ID_SYMBOL);
                str.append(this.getChildren().get(1).getTaskID());
                str.append(")");
                break;
            default:
                str.append("DEFAULT");
                break;
        }
        return str.toString();
    }
}
