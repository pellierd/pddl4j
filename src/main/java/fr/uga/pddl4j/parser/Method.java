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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class implements a method for htn planning operator parsed.
 *
 * @author D. Pellier
 * @version 1.0 - 20.12.2019
 */
public class Method extends TaskNetwork {

    /**
     * The name of the method.
     */
    private Symbol name;

    /**
     * The task performed by the method.
     */
    private Exp task;

    /**
     * The preconditions of the method. The precondition of the method are optional.
     */
    private Exp preconditions;

    /**
     * Create a new method.
     */
    private Method() {
        super();
        this.name = null;
        this.task = null;
        this.preconditions = null;
    }

    /**
     * Create a new method from another.
     *
     * @param other the other method.
     */
    public Method(final Method other) {
        super(other);
        this.setName(new Symbol(other.getName()));
        this.task = new Exp(other.getTask());
        this.preconditions = new Exp(other.getPreconditions());

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
    public Method(final Symbol name, final List<TypedSymbol> parameters, final Exp task, final Exp preconditions,
                  final Exp tasks, final Exp ordering, final Exp logical, final boolean ordered) {
        this();
        this.setName(name);
        this.setParameters(parameters);
        this.setTask(task);
        this.setPreconditions(preconditions);
        this.setTasks(tasks);
        this.setOrderingConstraints(ordering);
        this.setLogicalConstraints(logical);
        this.setTotallyOrdered(ordered);
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
    public Method(final Symbol name, final List<TypedSymbol> parameters, final Exp task, final Exp preconditions,
                  final TaskNetwork network) {
        this(name, parameters, task, preconditions, network.getTasks(), network.getOrderingConstraints(),
            network.getLogicalConstraints(), network.isTotallyOrdered());
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
     * Return the arity of the method, i.e., its number of parameters.
     *
     * @return the arity of the method.
     */
    public final int getArity() {
        return this.getParameters().size();
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
     *  @throws NullPointerException if the specified parameters is null.
     */
    public final void setPreconditions(final Exp preconditions) {
        if (preconditions == null) {
            throw new NullPointerException();
        }
        this.preconditions = preconditions;
    }

    /**
     * Normalizes the method.
     *
     * @see Exp#renameVariables()
     * @see Exp#moveNegationInward()
     */
    public void normalize() {
        this.normalize(0);
    }

    /**
     * Normalizes the method.
     *
     * Warning for the moment the logical constraints are not process.
     *
     * @param index the index of the first variable, index, i.e., ?Xi.
     * @see Exp#renameVariables()
     * @see Exp#moveNegationInward()
     */
    public void normalize(int index) {
        int i = index;
        // Rename the parameters
        final Map<String, String> varCtx = new LinkedHashMap<>();
        final List<TypedSymbol> parameters = this.getParameters();
        for (final TypedSymbol params : parameters) {
            final String image = params.renameVariables(i);
            varCtx.put(image, params.getImage());
            i++;
        }
        // Rename the task
        this.getTask().renameVariables(varCtx);
        // A hack to remove single atom in precondition
        if (this.preconditions.isLiteral()) {
            Exp atom = this.preconditions;
            this.preconditions = new Exp(Connective.AND);
            this.preconditions.addChild(atom);
        }
        // Rename the preconditions
        this.getPreconditions().renameVariables(varCtx);
        this.getPreconditions().moveNegationInward();
        // Rename variables of the tasks contained the method.
        this.getTasks().renameVariables(varCtx);
        // Rename task id the tasks contained the method.
        final Map<String, String> taskIDCtx = new LinkedHashMap<>();
        this.getTasks().renameTaskIDs(taskIDCtx);
        // Rename the tag ID used in the ordering constraints of the method
        this.getOrderingConstraints().renameTaskIDs(taskIDCtx);
        // In this case enumerate the orderings contraints in the cas of totally ordered
        if (this.isTotallyOrdered()) {
            this.setOrderingConstraints(new Exp(Connective.AND));
            for (int j = 1; j < this.getTasks().getChildren().size(); j++) {
                Exp c = new Exp(Connective.LESS_ORDERING_CONSTRAINT);
                c.setAtom(new LinkedList<Symbol>());
                c.getAtom().add(this.getTasks().getChildren().get(j-1).getTaskID());
                c.getAtom().add(this.getTasks().getChildren().get(j).getTaskID());
                this.getOrderingConstraints().addChild(c);
            }
        }
    }

    /**
    /**
     * Returns the hash code value of the method. The hash value of the method is only based on the name of the methode.
     * The name of a method must be unique in a domain.
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
        if (object != null && object.getClass().equals(this.getClass())) {
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
        str.append(this.name.toString()).append("\n");
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
        if (!this.getTasks().getChildren().isEmpty()) {
            str.append(this.getTasks().toString("  ") + "\n");
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
