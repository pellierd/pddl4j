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

import java.util.List;

/**
 * This class implements a method for htn planning operator parsed.
 *
 * @author D. Pellier
 * @version 1.0 - 20.12.2019
 */
public class ParsedMethod extends ParsedAbstractOperator {

    /**
     * The task performed by the method.
     */
    private Expression<String> task;

    /**
     * The task network of the method.
     */
    private ParsedTaskNetwork taskNetwork;

    /**
     * Create a new method from another.
     *
     * @param other the other method.
     */
    public ParsedMethod(final ParsedMethod other) {
        super(other);
        this.task = new Expression<String>(other.getTask());
        this.taskNetwork = new ParsedTaskNetwork(other.taskNetwork);
    }

    /**
     * Creates method with a specified name, parameter, task performed, precondition and task network.
     *
     * @param name The name of the method.
     * @param parameters The list of the method parameters.
     * @param task The task performed by the method.
     * @param duration The duration constraints of the method.
     * @param preconditions The preconditions of the task. This parameter can be null.
     * @param tasks The subtasks of the method.
     * @param ordering The ordering constraints between the subtasks of the method.
     * @param constraints The constraint on the subtasks of the method.
     * @param ordered The flag to indicate if the subtasks of the method is total ordered or not.
     * @param durative The flag to indicate if the method is durative or not.
     */
    public ParsedMethod(final Symbol<String> name, final List<TypedSymbol<String>> parameters,
                        final Expression<String> task, final Expression<String> duration,
                        final Expression<String> preconditions, final Expression<String> tasks,
                        final Expression<String> ordering, final Expression<String> constraints,
                        final boolean ordered, final boolean durative) {
        super(name, parameters, preconditions, duration);
        this.task = task;
        this.taskNetwork = new ParsedTaskNetwork(tasks, ordering, constraints, ordered, durative);
    }

    /**
     * Creates method with a specified name, parameter, task performed, precondition and task network.
     *
     * @param name The name of the method.
     * @param parameters The list of the method parameters.
     * @param task The task performed by the method.
     * @param preconditions The preconditions of the task. This parameter can be null.
     * @param tasks The subtasks of the method.
     * @param ordering The ordering constraints between the subtasks of the method.
     * @param constraints The constraint on the subtasks of the method.
     * @param ordered The flag to indicate if the subtasks of the method is total ordered or not.
     * @param durative The flag to indicate if the method is durative or not.
     */
    public ParsedMethod(final Symbol<String> name, final List<TypedSymbol<String>> parameters,
                        final Expression<String> task, final Expression<String> preconditions,
                        final Expression<String> tasks, final Expression<String> ordering,
                        final Expression<String> constraints, final boolean ordered, final boolean durative) {
        this(name, parameters, task, null, preconditions, tasks, ordering, constraints, ordered, durative);
    }

    /**
     * Creates method with a specified name, parameter, task performed, precondition and task network.
     *
     * @param name The name of the method.
     * @param parameters The list of the method parameters.
     * @param task The task performed by the method.
     * @param duration The duration constraints of the method.
     * @param preconditions The preconditions of the task. This parameter can be null.
     * @param network the task network of the method.
     */
    public ParsedMethod(final Symbol<String> name, final List<TypedSymbol<String>> parameters,
                        final Expression<String> task, final Expression<String> duration,
                        final Expression<String> preconditions, final ParsedTaskNetwork network) {
        this(name, parameters, task, duration, preconditions, network.getTasks(), network.getOrdering(),
            network.getConstraints(), network.isTotallyOrdered(), network.isDurative());
    }

    /**
     * Creates method with a specified name, parameter, task performed, precondition and task network.
     *
     * @param name The name of the method.
     * @param parameters The list of the method parameters.
     * @param task The task performed by the method.
     * @param preconditions The preconditions of the task. This parameter can be null.
     * @param network the task network of the method.
     */
    public ParsedMethod(final Symbol<String> name, final List<TypedSymbol<String>> parameters,
                        final Expression<String> task, final Expression<String> preconditions,
                        final ParsedTaskNetwork network) {
        this(name, parameters, task, preconditions, network.getTasks(), network.getOrdering(),
            network.getConstraints(), network.isTotallyOrdered(), network.isDurative());
    }

    /**
     * Returns the task performed by the method.
     *
     * @return the method tasks.
     */
    public final Expression<String> getTask() {
        return this.task;
    }

    /**
     *  Sets the task performed by the method.
     *
     *  @param task The task performed by the method.
     */
    public final void setTask(final Expression<String> task) {
        this.task = task;
    }

    /**
     * Returns the tasks of the task network.
     *
     * @return the tasks of the task network.
     */
    public final Expression<String> getSubTasks() {
        return this.taskNetwork.getTasks();
    }

    /**
     *  Sets the tasks of the task network.
     *
     *  @param tasks The tasks to set.
     */
    public final void setSubTasks(final Expression<String> tasks) {
        this.taskNetwork.setTasks(tasks);
    }

    /**
     * Returns the ordering constraints between the tasks of the task network.
     *
     * @return the ordering constraints of the task network.
     */
    public final Expression<String> getOrdering() {
        return this.taskNetwork.getOrdering();
    }

    /**
     *  Sets the ordering constraints between the tasks of the task network.
     *
     *  @param constraints The constraints to set.
     */
    public final void setOrdering(final Expression<String> constraints) {
        this.taskNetwork.setOrdering(constraints);
    }

    /**
     * Returns the logical constraints between the tasks of the task network.
     *
     * @return the logical constraints of the task network.
     */
    public final Expression<String> getConstraints() {
        return this.taskNetwork.getConstraints();
    }

    /**
     *  Sets the logical constraints between the tasks of the task network.
     *
     *  @param constraints The constraints to set.
     */
    public final void setLogicalConstraints(final Expression<String> constraints) {
        this.taskNetwork.setConstraints(constraints);
    }

    /**
     * Returns if the task network is total ordered or not.
     *
     * @return true the method is total ordered or not, false otherwise.
     */
    public final boolean isTotallyOrdered() {
        return this.taskNetwork.isTotallyOrdered();
    }

    /**
     * Set the boolean totally ordered flag of the task network to a specified value.
     *
     * @param flag The flag to set.
     */
    public final void setTotallyOrdered(final boolean flag) {
        this.taskNetwork.setTotallyOrdered(flag);
    }

    /**
     * Returns the task network of this method.
     *
     * @return the tasknetwork of this method.
     */
    public final ParsedTaskNetwork getTaskNetwork() {
        return this.taskNetwork;
    }

    /**
     * Sets the task network of this method.
     *
     * @param tasknetwork the tasknetwork to set.
     */
    public final void setTaskNetwork(ParsedTaskNetwork tasknetwork) {
        this.taskNetwork = tasknetwork;
    }

    /**
     * Returns a PDDL string representation of the method.
     *
     * @return a string PDDL representation of the method.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        if (!super.isDurative()) {
            str.append("(:method ");
        } else {
            str.append("(:durative-method ");
        }
        str.append(this.getName().toString()).append("\n");
        str.append("  :parameters (");
        if (!super.getParameters().isEmpty()) {
            for (int i = 0; i < super.getParameters().size() - 1; i++) {
                str.append(super.getParameters().get(i)).append(" ");
            }
            str.append(super.getParameters().get(super.getParameters().size() - 1).toString());
        }
        str.append(")\n");
        str.append("  :task ").append(this.getTask().toString("  ")).append("\n");

        if (super.isDurative()) {
            str.append("\n  :duration ");
            str.append("\n  ");
            str.append(this.getDuration().toString("  "));
            if (!this.getPreconditions().getChildren().isEmpty()) {
                str.append("  :condition\n  " + this.getPreconditions().toString("  ") + "\n");
            }
        } else {
            if (!this.getPreconditions().getChildren().isEmpty()) {
                str.append("  :precondition\n  " + this.getPreconditions().toString("  ") + "\n");
            }
        }
        if (this.isTotallyOrdered()) {
            str.append("  :ordered-subtasks\n  ");
        } else {
            str.append("  :subtasks\n  ");
        }
        if (!this.getSubTasks().getChildren().isEmpty()) {
            str.append(this.getSubTasks().toString("  ") + "\n");
        } else {
            str.append("()\n");
        }
        if (!this.getOrdering().getChildren().isEmpty()) {
            str.append("  :ordering\n  ");
            str.append(this.getOrdering().toString("  ") + "\n");
        }
        if (!this.getConstraints().getChildren().isEmpty()) {
            str.append("  :constraints\n  ");
            str.append(this.getConstraints().toString("  ") + "\n");
        }
        str.append(")");
        return str.toString();
    }

}
