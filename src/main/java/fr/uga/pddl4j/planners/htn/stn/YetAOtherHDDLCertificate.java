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
import fr.uga.pddl4j.problem.Task;

import java.util.*;

/**
 * La classe n'est pas belle. Elle n'est pas dans l'esprit de la hiérarchie des plans de PDDL4J. Il faudrait mieux
 * mutualiser les methods pour afficher le certificat dans la class AbstractSTNPlanner comme cela a été fait pour la
 * méthode extract plan.
 *
 * @author H. Fiorino
 * @author D. Pellier
 * @version 1.0 - 25.06.2020
 * @since 4.0
 */
public class YetAOtherHDDLCertificate extends SequentialPlan {

    /**
     * The methods used i
     */
    private LinkedList<Method> methods = new LinkedList<>();

    private AbstractSTNNode solutionNode;

    private Problem problem;


    /**
     *
     * @param node
     * @param problem
     */
    public YetAOtherHDDLCertificate(AbstractSTNNode node, Problem problem) {
        super();
        this.methods = new LinkedList<>();
        this.solutionNode = node;
        this.problem = problem;


        final int nbactions = problem.getActions().size();
        AbstractSTNNode n = node;
        while (n.getParent() != null) {
            final int operator = n.getOperator();
            final Integer task = n.getTask();
            if (operator < nbactions) {
                super.add(0, problem.getActions().get(operator));
            } else {
                this.methods.add(0, problem.getMethods().get(operator - nbactions));
            }
            n = n.getParent();
        }
        printCertificate();
    }

    /**
     *
     */
    public void printCertificate() {



        // La creation des deux dictionnaires peut être faite par un seul parcours de depuis le noeud racine jusqu'a
        // la racine. J'ai décomposé pour être plus pédagogique.

        // Create the primitive task dictionary
        LinkedHashMap<Integer, LinkedList<Integer>> primitiveTaskDictionnary = new LinkedHashMap<>();
        LinkedHashMap<Integer, LinkedList<Integer>>  compoundTaskDictionary = new LinkedHashMap<>();
        final int nbactions = this.problem.getActions().size();
        AbstractSTNNode n = this.solutionNode;
        int primitiveTaskIndex = 0;
        int compoundTaskIndex = this.actions().size();
        while (n.getParent() != null) {
            final int operator = n.getOperator();
            if (operator < nbactions) {
                final Integer task = n.getTask();
                LinkedList<Integer> value = primitiveTaskDictionnary.get(task);
                if (value == null) {
                    value = new LinkedList<Integer>();
                    primitiveTaskDictionnary.put(task, value);
                }
                value.add(0, primitiveTaskIndex);
                primitiveTaskIndex++;
            } else {
                final Integer task = n.getTask();
                LinkedList<Integer> value = compoundTaskDictionary.get(task);
                if (value == null) {
                    value = new LinkedList<Integer>();
                    compoundTaskDictionary.put(task, value);
                }
                value.add(0, compoundTaskIndex);
                compoundTaskIndex++;
            }
            n = n.getParent();
        }



        // Create the compund task dictionary
        /*LinkedHashMap<Integer, LinkedList<Integer>>  compoundTaskDictionary = new LinkedHashMap<>();
        for (Method method : this.methods) {
            LinkedList<Integer> value = compoundTaskDictionary.get(method.getTask());
            if (value == null) {
                value = new LinkedList<Integer>();
                compoundTaskDictionary.put(method.getTask(), value);
            }
            value.add(compoundTaskIndex);
            compoundTaskIndex++;
        }*/

        // Rename the primitive task and the compund task
        // Contain the renames subtasks for each method of the solution plan
        List<Integer> primitiveTasks = new LinkedList<>();
        List<List<Integer>> compoundTasks = new LinkedList<>();
        for (Method method : this.methods) {
            List<Integer> subTasks = new LinkedList<>();
            compoundTasks.add(subTasks);
            for (Integer st : method.getSubTasks()) {
                if (this.problem.getTasks().get(st).isPrimtive()) {
                    Integer index = primitiveTaskDictionnary.get(st).pop();
                    subTasks.add(index);
                    primitiveTasks.add(st);
                    // just pour éviter de cloner le dictionnaire car j'en ai encore besoin
                    primitiveTaskDictionnary.get(st).addLast(index);
                } else {
                    Integer index = compoundTaskDictionary.get(st).pop();
                    subTasks.add(index);
                    // just pour éviter de cloner le dictionnaire car j'en ai encore besoin
                    compoundTaskDictionary.get(st).addLast(index);

                }
            }
        }

        // Rename the primitive task and the compund task of the initial task network
        final List<Integer> root = new LinkedList<Integer>(this.problem.getInitialTaskNetwork().getTasks());
        for (int j =  0; j < root.size(); j++) {
            Integer task = root.get(j);
            if (this.problem.getTasks().get(task).isPrimtive()) {
                Integer index = primitiveTaskDictionnary.get(task).pop();
                root.set(j, index);
            } else {
                Integer index = compoundTaskDictionary.get(task).pop();
                root.set(j, index);
            }

        }


        // Just print.
        // Le print n'est pas tout a fait conforme.
        System.out.println("==>");
        int i = 0;
        for (int j = 0 ; j < this.actions().size(); j++) {
            String task = problem.toString(problem.getTasks().get(primitiveTasks.get(i)));
            System.out.println(i + " " + task.substring(1, task.length() - 1));
            i++;
        }
        System.out.print("root ");
        for (int j = 0; j < root.size(); j++) {
            System.out.print(root.get(j) + " ");
        }
        System.out.print("\n");
        for (int j = 0 ; j < this.methods.size(); j++) {
            Method method = this.methods.get(j);
            Task task = this.problem.getTasks().get(method.getTask());
            System.out.print(i + " " + this.problem.toString(task));
            System.out.print(" -> " + method.getName());
            for (int k = 0; k < compoundTasks.get(j).size(); k++) {
                System.out.print(" " + compoundTasks.get(j).get(k));
            }
            System.out.println();
            i++;
        }
        System.out.println("<==\n");
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
