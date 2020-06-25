/*
* Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
*
* This file is part of PDDL4J library.
*
* PDDL4J is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
*
* PDDL4J is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty
* of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License along with PDDL4J.  If not, see
* <http://www.gnu.org/licenses/>
*/

package fr.uga.pddl4j.planners.htn.stn;

import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.Method;
import fr.uga.pddl4j.problem.Problem;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 *
 * @author H. Fiorino
 * @author D. Pellier
 * @version 1.0 - 25.06.2020
 * @since 4.0
 */
public class HDDLCertificate extends SequentialPlan {

    private LinkedList<Method> methods = new LinkedList<>();

    private String certificate;

    public HDDLCertificate(AbstractSTNNode node, Problem problem) {
        super();
        // Plan + decomposition tree in pandaPIparser's format
        final String certificate = null;
        final int nbactions = problem.getActions().size();
        // Dictionary of task renames
        final Map<Integer, LinkedList<Integer>> renames = new TreeMap<Integer, LinkedList<Integer>>();

        final StringBuilder plan = new StringBuilder();
        final StringBuilder init = new StringBuilder();
        final StringBuilder deco = new StringBuilder();

        AbstractSTNNode n = node;
        int step = 0;

        // This extracts the solution plan + method decomposition bottom-up
        while (n.getParent() != null) {
            final int operator = n.getOperator();
            // This is the task addressed by n

            //final Integer task = n.getAtask();
            final Integer task = n.getTask();

            if (operator < nbactions) {
                final Action a = problem.getActions().get(operator);
                this.add(0, a);
                // Computes the alias of the primitive tasks
                if (renames.containsKey(task)) {
                    renames.get(task).add(step);
                } else {
                    final LinkedList<Integer> alias = new LinkedList<Integer>();
                    alias.add(step);
                    renames.put(task, alias);
                }
                plan.append(String.format("%d %s%n", step++, problem.toShortString(a)));
            } else {
                final Method method = problem.getMethods().get(operator - nbactions);
                this.methods.add(0, method);
            }
            n = n.getParent();
        }
        // Computes the alias of the complex tasks
        for (Method method : methods) {
            final Integer task = method.getTask();
            if (renames.containsKey(task)) {
                renames.get(task).add(step);
            } else {
                final LinkedList<Integer> alias = new LinkedList<Integer>();
                alias.add(step);
                renames.put(task, alias);
            }
            step++;
        }
        // Deep copy of renames
        final Map<Integer, LinkedList<Integer>> renames_copy = new TreeMap<Integer, LinkedList<Integer>>();
        for(Integer newKey : renames.keySet()){
            renames_copy.put(newKey, new LinkedList<Integer>(renames.get(newKey)));
        }
        LinkedList<Integer> todo = new LinkedList<Integer>(problem.getInitialTaskNetwork().getTasks());
        while (!todo.isEmpty()) {
            Integer task = todo.removeFirst();
            // Renames initial task
            Integer aka = renames.get(task).getFirst();
            init.append(" " + aka);
            LinkedList<Integer> open = new LinkedList<Integer>();
            open.add(task);
            while (!open.isEmpty()) {
                final Integer currentTask = open.removeFirst();
                if (!problem.getTasks().get(currentTask).isPrimtive()) {
                    final Method method = methods.removeFirst();
                    task = method.getTask();
                    // Renaming current complex task
                    aka = renames.get(task).removeFirst();
                    // Prepares subtask rename
                    // Task alias is consumed in renames and renames_copy
                    renames_copy.get(task).removeFirst();
                    open.addAll(0, method.getSubTasks());
                    deco.append(String.format("%d %s -> %s",
                        aka,
                        problem.toString(problem.getTasks().get(task)),
                        method.getName()));
                    for (Integer s : method.getSubTasks()) {
                        if (problem.getTasks().get(s).isPrimtive()) {
                            // Primitive subtask rename: alias is consumed
                            aka = renames_copy.get(s).removeFirst();
                            deco.append(" " + aka);
                        } else {
                            // Complex subtask rename: current alias is the first available
                            // alias consumption is provided by corresponding task rename
                            aka = renames_copy.get(s).getFirst();
                            deco.append(" " + aka);
                        }
                    }
                    deco.append("\n");
                }
            }
        }
        // Computes the certificate
        this.certificate = "==>\n" +
            plan.toString() +
            "root" + init.toString() +
            "\n" +
            deco.toString() +
            "<==";
    }

    @Override
    public String toString() {
        return this.certificate;
    }
}
