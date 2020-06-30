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
import fr.uga.pddl4j.problem.*;

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
    private LinkedList<Action> actions = new LinkedList<>();

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
                this.actions.add(problem.getActions().get(operator));
            } else {
                this.methods.add(problem.getMethods().get(operator - nbactions));
            }
            n = n.getParent();
        }
        printCertificate();
    }


    public void printCertificate() {
        List<Integer> tasks = new LinkedList<>();
        List<Integer> operators = new LinkedList<>();
        final int nbactions = problem.getActions().size();
        AbstractSTNNode n = this.solutionNode;
        while (n.getParent() != null) {
            final int operator = n.getOperator();
            tasks.add(0, n.getTask());
            //System.out.println(problem.toString(problem.getTasks().get(tasks.get(0))));
            if (operator < nbactions) {
                operators.add(0, operator);
                //System.out.println("-> " + problem.getActions().get(operators.get(0)).getName());
            } else {
                operators.add(0, operator - nbactions);
                //System.out.println("-> " + problem.getMethods().get(operators.get(0)).getName());
            }
            n = n.getParent();
        }


        LinkedHashMap<Integer, LinkedList<Integer>>  taskDictionary = new LinkedHashMap<>();
        int index = 0;
        for (Integer t : tasks) {
            LinkedList<Integer> value = taskDictionary.get(t);
            if (value == null) {
                value = new LinkedList<>();
                taskDictionary.put(t, value);
            }
            value.add(index);
            index++;
        }

        for (Integer t : tasks) {
            System.out.println(t + " -> " + taskDictionary.get(t));
        }

        index = 0;
        StringBuffer plan = new StringBuffer();
        for (Integer t : tasks) {
            if (this.problem.getTasks().get(t).isPrimtive()) {
                plan.append(index + " " + problem.toString(problem.getTasks().get(t)) + "\n");
                //Action a = this.problem.getActions().get(operators.get(index));
                //plan.append("-> " + a.getName() + "\n");
            }
            index++;
        }
        StringBuffer decomposition = new StringBuffer();
        index = 0;
        for (Integer t : tasks) {
            if (!this.problem.getTasks().get(t).isPrimtive()) {
                decomposition.append(index + " " + problem.toString(problem.getTasks().get(t)));
                Method m = this.problem.getMethods().get(operators.get(index));
                decomposition.append(" -> " + m.getName());
                for (Integer st : m.getSubTasks()) {
                    //System.out.print(" " + st +  "(" + taskDictionary.get(st).pop() + ")");
                    int task  = taskDictionary.get(st).pop();
                    taskDictionary.get(st).addLast(task);
                    decomposition.append(" " + task);
                }
                decomposition.append("\n");
            }
            index++;
        }
        StringBuffer root = new StringBuffer();
        root.append("root");
        for (Integer t : this.problem.getInitialTaskNetwork().getTasks()) {
            //root.append(t + " ->" + problem.toString(this.problem.getTasks().get(t)) +  " " + taskDictionary.get(t).pop() + "\n");
            root.append(" " + taskDictionary.get(t).pop());
        }


        System.out.println("==>");
        System.out.print(plan);
        System.out.println(root);
        System.out.println(decomposition);
        System.out.println("<==\n");

    }
        /**
         *
         */
    /*public void printCertificate() {



        // La creation des deux dictionnaires peut être faite par un seul parcours de depuis le noeud racine jusqu'a
        // la racine. J'ai décomposé pour être plus pédagogique.

        // Create the primitive task dictionary
        LinkedHashMap<Integer, LinkedList<Integer>> primitiveTaskDictionnary = new LinkedHashMap<>();
        LinkedHashMap<Integer, LinkedList<Integer>>  compoundTaskDictionary = new LinkedHashMap<>();
        List<Integer> primitiveTasks = new LinkedList<>();
        List<Integer> compoundTasks = new LinkedList<>();
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
                value.add(primitiveTaskIndex);
                primitiveTaskIndex++;
                primitiveTasks.add(task);
            } else {
                final Integer task = n.getTask();
                LinkedList<Integer> value = compoundTaskDictionary.get(task);
                if (value == null) {
                    value = new LinkedList<Integer>();
                    compoundTaskDictionary.put(task, value);
                }
                value.add(compoundTaskIndex);
                compoundTaskIndex++;
                compoundTasks.add(task);
            }
            n = n.getParent();
        }



        // Create the compund task dictionary
        /*System.out.println(this.problem.getInitialTaskNetwork().getTasks());
        for (Map.Entry<Integer, LinkedList<Integer>> e : compoundTaskDictionary.entrySet()) {
            System.out.println(e.getKey() + " " + problem.toString(problem.getTasks().get(e.getKey())) + " -> " + e.getValue());
        }
        System.out.println("-------------------");
        for (Map.Entry<Integer, LinkedList<Integer>> e : primitiveTaskDictionnary.entrySet()) {
            System.out.println(e.getKey() + " " + problem.toString(problem.getTasks().get(e.getKey())) + " -> " + e.getValue());
        }

        System.out.println("-------------------");

        // Create the compund task dictionary
        for (Integer t : compoundTasks) {
            System.out.println(t + " " + problem.toString(problem.getTasks().get(t)));
        }
        System.out.println("+++++++++++++++");
        // Create the compund task dictionary
        for (Method m : this.methods) {
            System.out.println(m.getTask() + " " + problem.toString(problem.getTasks().get(m.getTask())));
        }

        System.out.println("-------------------");
        for (Integer t : primitiveTasks) {
            System.out.println(t + " " + problem.toString(problem.getTasks().get(t)));
        }*/


        // Rename the primitive task and the compund task
        // Contain the renames subtasks for each method of the solution plan
        /*List<List<Integer>> decompositions = new LinkedList<>();
        for (Method method : this.methods) {
            List<Integer> subTasks = new LinkedList<>();
            decompositions.add(subTasks);
            for (Integer st : method.getSubTasks()) {
                if (this.problem.getTasks().get(st).isPrimtive()) {
                    Integer index = primitiveTaskDictionnary.get(st).pop();
                    subTasks.add(primitiveTasks.size() - 1 - index);
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
                root.set(j, primitiveTasks.size() - 1 - index);
            } else {
                Integer index = compoundTaskDictionary.get(task).pop();
                root.set(j, index);
            }

        }


        // Just print.
        // Le print n'est pas tout a fait conforme.
        System.out.println("==>");
        int id = 0;
        for (int i = primitiveTasks.size() - 1; i >= 0; i--) {
            Integer t = primitiveTasks.get(i);
            System.out.println(id + " " + problem.toString(problem.getTasks().get(t)));
            //System.out.println(" " + primitiveTaskDictionnary.get(t));
            id++;
        }

        System.out.print("root ");
        for (int j = 0; j < root.size() -1 ; j++) {
            System.out.print(root.get(j) + " ");
        }
        System.out.print(root.get(root.size()-1) + "\n");
        for (int i = 0 ; i < decompositions.size(); i++) {
            Task task = this.problem.getTasks().get(compoundTasks.get(i));
            System.out.print(id + " " + this.problem.toString(task));
            System.out.print(" -> " + this.methods.get(i).getName());
            for (int j = 0; j < decompositions.get(i).size(); j++) {
                System.out.print(" " + decompositions.get(i).get(j));
            }
            System.out.println();
            id++;
        }
        System.out.println("<==\n");
    }*/


    @Override
    public String toString() {
        return super.toString();
    }
}
