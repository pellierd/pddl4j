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
    public void substitute(final int var, final int cons) {
        switch (this.getConnective()) {
            case ATOM:
            case TASK:
            case FN_HEAD:
                int[] args = this.getArguments();
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
                    ei.substitute(var, cons);
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
                    ei.substitute(var, cons);
                    // If a child expression is TRUE, the whole disjunction is TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        this.setConnective(PDDLConnective.TRUE);
                    }
                }
                break;
            case NOT:
                final IntExpression neg = this.getChildren().get(0);
                neg.substitute(var, cons);
                if (neg.getConnective().equals(PDDLConnective.TRUE)) {
                    this.setConnective(PDDLConnective.FALSE);
                } else if (neg.getConnective().equals(PDDLConnective.FALSE)) {
                    this.setConnective(PDDLConnective.TRUE);
                }
                break;
            default:
                for (IntExpression ei : this.getChildren()) {
                    ei.substitute(var, cons);
                }
        }
    }

    /**
     * Expands the quantified expressions contained in a specified expression.
     *
     * @param domains the domains of the quantified variables.
     */
    public void expandQuantifiedExpression(final List<Set<Integer>> domains) {
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
                    ei.expandQuantifiedExpression(domains);
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
                    // Remove quantified expression where the domain of the quantified variable is empty
                    if ((ei.getConnective().equals(PDDLConnective.FORALL)
                        || ei.getConnective().equals(PDDLConnective.EXISTS))
                        && domains.get(ei.getType()).isEmpty()) {
                        i.remove();
                        continue;
                    }
                    ei.expandQuantifiedExpression(domains);
                    // If a child expression is TRUE, the whole disjunction becomes TRUE.
                    if (ei.getConnective().equals(PDDLConnective.TRUE)) {
                        this.setConnective(PDDLConnective.TRUE);
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
                    copy.substitute(var, cons);
                    this.getChildren().add(copy);
                    // If a child expression is FALSE, the whole conjunction becomes FALSE.
                    if (copy.getConnective().equals(PDDLConnective.FALSE)) {
                        this.setConnective(PDDLConnective.FALSE);
                    }
                }
                this.expandQuantifiedExpression(domains);
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
                    copy.substitute(var, cons);
                    this.getChildren().add(copy);
                    // If a child expression is TRUE, the whole disjunction becomes TRUE.
                    if (copy.getConnective().equals(PDDLConnective.TRUE)) {
                        this.setConnective(PDDLConnective.TRUE);
                    }
                }
                this.expandQuantifiedExpression(domains);
                break;
            default:
                for (IntExpression ei : this.getChildren()) {
                    ei.expandQuantifiedExpression(domains);
                }

        }
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
                        this.setConnective(PDDLConnective.OR);
                        this.getChildren().clear();
                        for (int i = 0; i < p.getChildren().size(); i++) {
                            IntExpression q = new IntExpression(PDDLConnective.NOT);
                            q.addChild(p.getChildren().get(i));
                            q.moveNegationInward();
                            this.addChild(q);
                        }
                        break;
                    case OR:
                        this.setConnective(PDDLConnective.AND);
                        this.getChildren().clear();
                        for (int i = 0; i < p.getChildren().size(); i++) {
                            IntExpression q = new IntExpression(PDDLConnective.NOT);
                            q.addChild(this.getChildren().get(i));
                            q.moveNegationInward();
                            this.addChild(q);
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
                        p.moveTimeSpecifierInward();
                        break;
                    case EXISTS:
                        p.setConnective(this.getConnective());
                        this.setConnective(PDDLConnective.EXISTS);
                        this.setVariable(p.getVariable());
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
                            IntExpression q = new IntExpression(this.getConnective());
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
                final IntExpression antecedent = this.getChildren().get(0);
                final IntExpression consequence = this.getChildren().get(1);
                antecedent.toDNF();
                this.setConnective(PDDLConnective.AND);
                this.getChildren().clear();
                for (IntExpression ei : antecedent.getChildren()) {
                    final IntExpression newWhen = new IntExpression(PDDLConnective.WHEN);
                    newWhen.getChildren().add(ei);
                    newWhen.getChildren().add(consequence);
                    this.getChildren().add(newWhen);
                }
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
}
