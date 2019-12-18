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

package fr.uga.pddl4j.parser;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class implements a method for htn planning operator parsed.
 *
 * @author H. Fiorino
 * @version 1.0 - 13.02.2019
 */
public class Method implements Serializable {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The name of the method.
     */
    private Symbol name;

    /**
     * The list of parameters of the method.
     */
    private List<TypedSymbol> parameters;

    /**
     * The task performed by the method.
     */
    private Exp task;

    /**
     * The preconditions of the method. The precondition of the method are optional.
     */
    private Exp preconditions;

    /**
     * The task network of the method.
     */
    private Exp taskNetwork;

    /**
     * Create a new method.
     */
    private Method() {
        super();
        this.name = null;
        this.parameters = null;
        this.task = null;
        this.preconditions = null;
        this.taskNetwork = null;
    }

    /**
     * Create a new method from another.
     *
     * @param other the other method.
     */
    public Method(final Method other) {
        if (other == null) {
            throw new NullPointerException();
        }
        this.name = new Symbol(other.getName());
        this.parameters = new LinkedList<>();
        this.parameters.addAll(other.getParameters().stream().map(TypedSymbol::new).collect(Collectors.toList()));
        this.task = new Exp(other.getTask());
        this.preconditions = new Exp(other.getPreconditions());
        this.taskNetwork = new Exp(other.getTaskNetwork());
    }

    /**
     * Creates method with a specified name, parameter, task performed, precondition and tasknetwork.
     *
     * @param name The name of the method.
     * @param parameters The list of the method parameters.
     * @param task The task performed by the method.
     * @param preconditions The preconditions of the task. This parameter can be null.
     * @param subtasks The subtasks of the method.
     * @param ordering The ordering constraints between the subtasks of the method.
     * @param constraints The constraint on the subtasks of the method.
     * @param ordered The flag to indicate if the subtasks of the method is total ordered or not.
     * @throws NullPointerException if one of the specified parameter except the precondition is null.
     */
    public Method(final Symbol name, final List<TypedSymbol> parameters, final Exp task, final Exp preconditions,
                  final Exp subtasks, final Exp ordering, final Exp constraints, final boolean ordered) {
        this();
        this.setName(name);
        this.setParameters(parameters);
        this.setTask(task);
        this.setPreconditions(preconditions);
        this.setSubtasks(subtasks);
        this.setOrderingConstraints(ordering);
        this.setConstraints(constraints);
        this.setTotalOrdered(ordered);
    }

    /**
     * Creates method with a specified name, parameter, task performed, precondition and tasknetwork.
     *
     * @param name The name of the method.
     * @param parameters The list of the method parameters.
     * @param task The task performed by the method.
     * @param preconditions The preconditions of the task. This parameter can be null.
     * @param taskNetwork The tasknetwork the method.
     * @throws NullPointerException if one of the specified parameter except the precondition is null.
     */
    public Method(final Symbol name, final List<TypedSymbol> parameters, final Exp task, final Exp preconditions,
                  final Exp taskNetwork) {
        this();
        this.setName(name);
        this.setParameters(parameters);
        this.setTask(task);
        this.setPreconditions(preconditions);
        this.setTaskNetwork(taskNetwork);
    }

    /**
     * Returns the name of the method.
     *
     * @return the name of the method.
     */
    public final Symbol getName() {
        return this.name;
    }

    /**
     * Sets a new name to the method.
     *
     * @param name the name to set.
     */
    public final void setName(final Symbol name) {
        if (name == null) {
            throw new NullPointerException();
        }
        this.name = name;
    }

    /**
     * Returns the list of parameters of the method.
     *
     * @return the list of parameters of the method.
     */
    public final List<TypedSymbol> getParameters() {
        return this.parameters;
    }

    /**
     * Returns the parameter of the method that has a specified symbol.
     *
     * @param symbol The symbol.
     * @return the parameter of the method that has a specified symbol or <code>null</code> if the
     *          method has no such parameter.
     */
    public final TypedSymbol getParameter(final Symbol symbol) {
        final int index = this.parameters.indexOf(symbol);
        return (index == -1) ? null : this.parameters.get(index);
    }

    /**
     * Sets a new list of parameters to this method.
     *
     * @param parameters The list of parameters to set.
     * @throws NullPointerException if the specified parameters is null.
     */
    public final void setParameters(final List<TypedSymbol> parameters) {
        if (parameters == null) {
            throw new NullPointerException();
        }
        this.parameters = parameters;
    }

    /**
     * Returns the task performed by the method.
     *
     * @return the method tasks.
     */
    public final Exp getTask() {
        return this.task;
    }

    /**
     *  Sets the task performed by the method.
     *
     *  @param task The task performed by the method.
     *  @throws NullPointerException if the specified parameters is null.
     */
    public final void setTask(final Exp task) {
        if (task == null) {
            throw new NullPointerException();
        }
        this.task = task;
    }

    /**
     * Returns the preconditions of the method. The preconditions are optional.
     *
     * @return the preconditions of the method or null if no preconditions are specified.
     */
    public Exp getPreconditions() {
        return this.preconditions;
    }

    /**
     *  Sets the preconditions of the method.
     *
     *  @param preconditions The precondition to set.
     */
    public final void setPreconditions(final Exp preconditions) {
        this.preconditions = preconditions;
    }

    /**
     * Sets the task network of the method. The first child of the task network expression defines the tasks of the
     * task network. The second child the ordering constraints of the network and finaly the third child the constraints
     * of the task network.
     *
     * @param taskNetworl the task network to set.
     * @throws NullPointerException if the specified parameters is null.
     */
    public final void setTaskNetwork(final Exp taskNetwork) {
        if (taskNetwork == null) {
            throw new NullPointerException();
        }
        this.taskNetwork = taskNetwork;
    }
    /**
     * Returns the task network of the method. The first child of the task network expression defines the tasks of the
     * task network. The second child the ordering constraints of the network and finaly the third child the constraints
     * of the task network.
     */
    public final Exp getTaskNetwork() { return this.taskNetwork; }

    /**
     * Returns the subtasks of the method.
     *
     * @return the subtasks of the method.
     */
    public final Exp getSubTasks() {
        return this.taskNetwork.getChildren().get(0);
    }

    /**
     *  Sets the subtasks of the method.
     *
     *  @param subtasks The subtasks to set.
     *  @throws NullPointerException if the specified parameters is null.
     */
    public final void setSubtasks(final Exp subtasks) {
        if (subtasks == null) {
            throw new NullPointerException();
        }
        this.taskNetwork.getChildren().set(0, subtasks);
    }

    /**
     * Returns the ordering constraints between the subtasks of the method.
     * The method returns an empty conjunction of ordering constraints if the method is totally ordered.
     *
     * @return the ordering constraints of the method.
     */
    public final Exp getOrderingConstraints() {
        return this.taskNetwork.getChildren().get(1);
    }

    /**
     *  Sets the ordering constraints between the subtasks of the method.
     *
     *  @param constraints The constraints to set.
     *  @throws NullPointerException if the specified parameters is null.
     */
    public final void setOrderingConstraints(final Exp constraints) {
        if (constraints == null) {
            throw new NullPointerException();
        }
        this.taskNetwork.getChildren().set(1, constraints);
    }

    /**
     * Returns the constraints on the subtasks of the method.
     *
     * @return the constraints of the method.
     */
    public final Exp getConstraints() {
        return this.taskNetwork.getChildren().get(2);
    }

    /**
     *  Sets the  constraints one the subtasks of the method.
     *
     *  @param constraints The constraints to set.
     *  @throws NullPointerException if the specified parameters is null.
     */
    public final void setConstraints(final Exp constraints) {
        if (constraints == null) {
            throw new NullPointerException();
        }
        this.taskNetwork.getChildren().set(2, constraints);
    }

    /**
     * Returns if the method is total ordered or not.
     *
     * @return true the method is total ordered or not, false otherwise.
     */
    public final boolean isTotalOrdered() {
        return this.taskNetwork.getConnective() == Connective.TOTAL_ORDERED_TASK_NETWORK;
    }

    /**
     * Set the boolean total ordered flag to a specified value.
     *
     * @param flag The flag to set.
     */
    public final void setTotalOrdered(final boolean flag) {
        if (flag) {
            this.taskNetwork.setConnective(Connective.TOTAL_ORDERED_TASK_NETWORK);
        } else {
            this.taskNetwork.setConnective(Connective.PARTIAL_ORDERED_TASK_NETWORK);
        }
    }

    /**
     * Returns the hash code value of the method.
     *
     * @return the hash code value of the method.
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * Return if this method is equals to another object.
     *
     * @param object the other object.
     * @return <code>true</code> if <code>object</code> is not <code>null</code>, is an instance of
     *          the class <code>Op</code>, and has the same name; otherwise it returns <code>false</code>.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object object) {
        if (object != null && object instanceof Method) {
            final Method other = (Method) object;
            return this.name.equals(other.name);
        }
        return false;
    }

    /**
     * Returns a PDDL string representation of the method.
     *
     * @return a string PDDL representation of the method.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append("(:method ");
        str.append(this.name.toString()).append("\n").append("\t:parameters (");
        for (int i = 0; i < this.parameters.size() - 1; i++) {
            str.append(this.parameters.get(i)).append(" ");
        }
        if (!this.parameters.isEmpty()) {
            str.append(this.parameters.get(this.parameters.size() - 1).toString());
        }
        str.append(")\n");
        str.append("\t:task (" + this.getTask().toString() + ")\n");
        if (!this.getPreconditions().getChildren().isEmpty()) {
            str.append("\t:precondition" + this.getPreconditions().toString() + "\n");
        }
        if (!this.getSubTasks().getChildren().isEmpty()) {
            if (this.isTotalOrdered()) {
                str.append("\t:ordered-subtasks ");
            } else {
                str.append("\t:subtasks ");
            }
        }
        str.append(this.getSubTasks().toString() + "\n");
        if (!this.getOrderingConstraints().getChildren().isEmpty()) {
            str.append("\t:ordering ");
            str.append(this.getOrderingConstraints().toString() + "\n");
        }
        if (!this.getConstraints().getChildren().isEmpty()) {
            str.append("\t:constraints ");
            str.append(this.getConstraints().toString() + "\n");
        }
        str.append(")\n");
        str.append(")");
        return str.toString();
    }

}
