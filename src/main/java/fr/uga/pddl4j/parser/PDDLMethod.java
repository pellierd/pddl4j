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

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class implements a method for htn planning operator parsed.
 *
 * @author D. Pellier
 * @version 1.0 - 20.12.2019
 */
public class PDDLMethod extends PDDLAbstractOperator {

    /**
     * The task performed by the method.
     */
    private PDDLExpression task;

    /**
     * The task network of the method.
     */
    private PDDLTaskNetwork taskNetwork;

    /**
     * Create a new method from another.
     *
     * @param other the other method.
     */
    public PDDLMethod(final PDDLMethod other) {
        super(other);
        this.task = new PDDLExpression(other.getTask());
        this.taskNetwork = new PDDLTaskNetwork(other.taskNetwork);
    }

    /**
     * Creates method with a specified name, parameter, task performed, precondition and tasknetwork.
     *
     * @param name The name of the method.
     * @param parameters The list of the method parameters.
     * @param task The task performed by the method.
     * @param preconditions The preconditions of the task. This parameter can be null.
     * @param tasks The subtasks of the method.
     * @param ordering The ordering constraints between the subtasks of the method.
     * @param logical The constraint on the subtasks of the method.
     * @param ordered The flag to indicate if the subtasks of the method is total ordered or not.
     * @throws NullPointerException if one of the specified parameter except the precondition is null.
     */
    public PDDLMethod(final PDDLSymbol name, final List<PDDLTypedSymbol> parameters, final PDDLExpression task,
                      final PDDLExpression preconditions, final PDDLExpression tasks, final PDDLExpression ordering,
                      final PDDLExpression logical, final boolean ordered) {
        super(name, parameters, preconditions);
        this.task = task;
        this.taskNetwork = new PDDLTaskNetwork(tasks, ordering, logical, ordered);
    }

    /**
     * Creates method with a specified name, parameter, task performed, precondition and tasknetwork.
     *
     * @param name The name of the method.
     * @param parameters The list of the method parameters.
     * @param task The task performed by the method.
     * @param preconditions The preconditions of the task. This parameter can be null.
     * @param network the task network of the method.
     * @throws NullPointerException if one of the specified parameter except the precondition is null.
     */
    public PDDLMethod(final PDDLSymbol name, final List<PDDLTypedSymbol> parameters, final PDDLExpression task,
                      final PDDLExpression preconditions, final PDDLTaskNetwork network) {
        this(name, parameters, task, preconditions, network.getTasks(), network.getOrderingConstraints(),
            network.getLogicalConstraints(), network.isTotallyOrdered());
    }

    /**
     * Returns the task performed by the method.
     *
     * @return the method tasks.
     */
    public final PDDLExpression getTask() {
        return this.task;
    }

    /**
     *  Sets the task performed by the method.
     *
     *  @param task The task performed by the method.
     */
    public final void setTask(final PDDLExpression task) {
        this.task = task;
    }

    /**
     * Returns the tasks of the task network.
     *
     * @return the tasks of the task network.
     */
    public final PDDLExpression getSubTasks() {
        return this.taskNetwork.getTasks();
    }

    /**
     *  Sets the tasks of the task network.
     *
     *  @param tasks The tasks to set.
     */
    public final void setSubTasks(final PDDLExpression tasks) {
        this.taskNetwork.setTasks(tasks);
    }

    /**
     * Returns the ordering constraints between the tasks of the task network.
     *
     * @return the ordering constraints of the task network.
     */
    public final PDDLExpression getOrderingConstraints() {
        return this.taskNetwork.getOrderingConstraints();
    }

    /**
     *  Sets the ordering constraints between the tasks of the task network.
     *
     *  @param constraints The constraints to set.
     */
    public final void setOrderingConstraints(final PDDLExpression constraints) {
        this.taskNetwork.setOrderingConstraints(constraints);
    }

    /**
     * Returns the logicial constraints between the tasks of the task network.
     *
     * @return the logical constraints of the task network.
     */
    public final PDDLExpression getLogicalConstraints() {
        return this.taskNetwork.getLogicalConstraints();
    }

    /**
     *  Sets the logical constraints between the tasks of the task network.
     *
     *  @param constraints The constraints to set.
     */
    public final void setLogicalConstraints(final PDDLExpression constraints) {
        this.taskNetwork.setLogicalConstraints(constraints);
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
     * Normalizes the method.
     *
     * @param index the index of the first variable, index, i.e., ?Xi.
     * @see PDDLExpression#renameVariables()
     * @see PDDLExpression#moveNegationInward()
     */
    protected Map<String, String> normalize(int index) {
        // Rename the parameters
        final Map<String, String> varCtx = super.normalize(index);
        // Rename the variable to carried out task of the method.
        this.getTask().renameVariables(varCtx);
        // Rename variables of the tasks contained the method.
        this.getSubTasks().renameVariables(varCtx);
        if (this.getSubTasks().getChildren().size() == 1) {
            this.setTotallyOrdered(true);
        }
        // Rename task id the tasks contained the method.
        final Map<String, String> taskIDCtx = new LinkedHashMap<>();
        this.getSubTasks().renameTaskIDs(taskIDCtx);
        // Rename the tag ID used in the ordering constraints of the method
        this.getOrderingConstraints().renameTaskIDs(taskIDCtx);
        // In this case enumerate the orderings contraints in the cas of totally ordered
        if (this.isTotallyOrdered()) {
            this.setOrderingConstraints(new PDDLExpression(PDDLConnective.AND));
            for (int j = 1; j < this.getSubTasks().getChildren().size(); j++) {
                PDDLExpression c = new PDDLExpression(PDDLConnective.LESS_ORDERING_CONSTRAINT);
                c.setAtom(new LinkedList<PDDLSymbol>());
                c.getAtom().add(this.getSubTasks().getChildren().get(j - 1).getTaskID());
                c.getAtom().add(this.getSubTasks().getChildren().get(j).getTaskID());
                this.getOrderingConstraints().addChild(c);
            }
        }
        // Rename the logical constraits
        this.getLogicalConstraints().renameVariables(varCtx);
        PDDLExpression preconditions = null;
        if (!this.getPreconditions().getConnective().equals(PDDLConnective.AND)) {
            preconditions = this.getPreconditions();
        } else {
            preconditions = new PDDLExpression(PDDLConnective.AND);
            preconditions.addChild(this.getPreconditions());
        }
        Iterator<PDDLExpression> i = this.getLogicalConstraints().getChildren().iterator();
        while (i.hasNext()) {
            final PDDLExpression constraint = i.next();
            switch (constraint.getConnective()) {
                case EQUAL:
                    preconditions.addChild(constraint);
                    i.remove();
                    break;
                case NOT:
                    if (constraint.getChildren().get(0).equals(PDDLConnective.EQUAL)) {
                        preconditions.addChild(constraint);
                        i.remove();
                    }
                    break;
                default:
            }
        }
        this.setPreconditions(preconditions);
        this.getPreconditions().moveNegationInward();
        return varCtx;
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
        if (!this.getPreconditions().getChildren().isEmpty()) {
            str.append("  :precondition\n  " + this.getPreconditions().toString("  ") + "\n");
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
        if (!this.getOrderingConstraints().getChildren().isEmpty()) {
            str.append("  :ordering\n  ");
            str.append(this.getOrderingConstraints().toString("  ") + "\n");
        }
        if (!this.getLogicalConstraints().getChildren().isEmpty()) {
            str.append("  :constraints\n  ");
            str.append(this.getLogicalConstraints().toString("  ") + "\n");
        }
        str.append(")");
        return str.toString();
    }

}
