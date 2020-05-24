package fr.uga.pddl4j.encoding;

import fr.uga.pddl4j.problem.Action;
import fr.uga.pddl4j.problem.Method;
import fr.uga.pddl4j.problem.TaskNetwork;

import java.io.Serializable;
import java.util.*;

/**
 * This class contains the methods used after the bit encoding of a planning problem. In particular, the class contains
 * methods to compute the revolvers for each tasks of a planning domain.
 *
 * @author D. Pellier
 * @version 1.0 - 16.04.2020
 */
public final class PostEncoding implements Serializable {

    /**
     * Creates the table of relevant operators for each task.
     */
    static void createTableOfRelevantOperators() {
        Encoder.tableOfRelevantOperators = new ArrayList<>(Encoder.tableOfRelevantTasks.size());
        final int numberOfrelevantTasks = Encoder.tableOfRelevantTasks.size();

        for (int ti = 0; ti < numberOfrelevantTasks; ti++) {
            final IntExpression task = Encoder.tableOfRelevantTasks.get(ti);
            final List<Integer> operators = new ArrayList<>();
            if (task.isPrimtive()) {
                for (int ai = 0; ai < Encoder.actions.size(); ai++) {
                    final Action action = Encoder.actions.get(ai);
                    if (action.getName().equals(Encoder.tableOfTasks.get(task.getPredicate()))
                            && Arrays.equals(action.getInstantiations(), task.getArguments())) {
                        operators.add(ai);
                    }
                }
            } else {
                for (int mi = 0; mi < Encoder.methods.size(); mi++) {
                    final Method method = Encoder.methods.get(mi);
                    if (method.getTask() == ti) {
                        operators.add(mi);
                    }
                }
            }
            Encoder.tableOfRelevantOperators.add(operators);
        }

    }

    static void createTableOfRelevantOperatorsbis() {

        LinkedList<Integer> tasks = new LinkedList<Integer>();
        tasks.addAll(Encoder.initialTaskNetwork.getTasks());

        HashSet<Integer> closed = new HashSet<>();
        closed.addAll(Encoder.initialTaskNetwork.getTasks());

        Map<Integer, List<Integer>> operators = new HashMap<Integer, List<Integer>>();
        int nb = 0;
        while (!tasks.isEmpty()) {
            Integer t = tasks.pop();
            List<Integer> relevant = operators.get(t);
            if (relevant == null) {
                final IntExpression taskExp = Encoder.tableOfRelevantTasks.get(t);
                relevant = new ArrayList<>();
                if (taskExp.isPrimtive()) {
                    for (int ai = 0; ai < Encoder.actions.size(); ai++) {
                        final Action action = Encoder.actions.get(ai);
                        if (action.getName().equals(Encoder.tableOfTasks.get(taskExp.getPredicate()))
                            && Arrays.equals(action.getInstantiations(), taskExp.getArguments())) {
                            relevant.add(ai);
                        }
                    }
                } else {
                    for (int m = 0; m < Encoder.methods.size(); m++) {
                        final Method method = Encoder.methods.get(m);
                        if (method.getTask() == t) {
                            relevant.add(m);
                            for (Integer st : Encoder.methods.get(m).getSubTasks()) {
                                if (!closed.contains(st)) {
                                    tasks.add(st);
                                    closed.add(st);
                                }
                            }
                        }
                    }
                }
                operators.put(t, relevant);
            }
        }

        final int numberOfrelevantTasks = Encoder.tableOfRelevantTasks.size();
        Encoder.tableOfRelevantOperators = new ArrayList<>(numberOfrelevantTasks);
        int norelevant = 0;
        for (int ti = 0; ti < numberOfrelevantTasks; ti++) {
            List<Integer> relevant = operators.get(ti);

            if (relevant == null) {
                relevant = new LinkedList<>();
                norelevant++;
            }
            Encoder.tableOfRelevantOperators.add(relevant);
        }

        System.out.println(norelevant + "/"+ numberOfrelevantTasks + "/" + nb);

    }

    static List<Integer> getRelevantOperatorOfPrimitiveTask(final int task) {
        final List<Integer> operators = new ArrayList<>();
        final IntExpression t = Encoder.tableOfRelevantTasks.get(task);
        for (int ai = 0; ai < Encoder.actions.size(); ai++) {
            final Action action = Encoder.actions.get(ai);
            if (action.getName().equals(Encoder.tableOfTasks.get(t.getPredicate()))
                && Arrays.equals(action.getInstantiations(), t.getArguments())) {
                operators.add(ai);
            }
        }
        return operators;
    }

    static List<Integer> getRelevantOperatorOfCompundTask(final int task) {
        final List<Integer> operators = new ArrayList<>();
        for (int m = 0; m < Encoder.methods.size(); m++) {
            final Method method = Encoder.methods.get(m);
            if (method.getTask() == task) {
                operators.add(m);
            }
        }
        return operators;
    }
}
