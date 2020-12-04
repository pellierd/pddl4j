package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.encoding.PostInstantiatedProblem;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;

import java.util.Iterator;

/**
 * Created by pellier on 03/12/2020.
 */
public class HTNProblem extends PostInstantiatedProblem {

    public HTNProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
    }


    /**
     * This method is called by the constructor.
     */
    protected void init () {

        // Standardize the variables symbol contained in the domain
        this.getDomain().standardize();
        // Standardize the variables symbol contained in the domain
        this.getProblem().standardize();

        // Collect the information on the type declared in the domain
        this.collectTypeInformation();
        // Collect the constants (symbols and types) declared in the domain
        this.collectConstantInformation();
        // Collect the either types of the domain
        this.collectEitherTypeInformation();
        // Collect the predicate information (symbols and signatures)
        this.collectPredicateInformation();

        // Collect the tasks information (symbols and signatures)
        this.collectTaskInformation();

        // Encode the actions of the domain into integer representation
        this.encodeIntActions();

        // Encode the methods of the domain into integer representation
        this.encodeIntMethods();

        // Encode the initial state in integer representation
        this.encodeIntInit();
        // Encode the goal in integer representation
        this.encodeIntGoal();

        this.encodeIntInitialTaskNetwork();
    }

    protected void preinstantiation() {
        this.extractInertia();
        // Create the predicates tables used to count the occurrences of the predicates in the
        // initial state
        this.createPredicatesTables();
    }

    protected void instantiation() {
        this.instantiateActions();

        this.extractGroundInertia();
        this.extractGroundNumericInertia();
        this.simplyActionsWithGroundInertia();
        this.instantiateGoal();
        this.simplifyGoalWithGroundInertia();

        this.instantiateInitialTaskNetwork();
        this.instantiateMethods(this.getIntMethods(), this.getIntInitialTaskNetwork(), this.getIntActions());
        this.simplyMethodsWithGroundInertia();

    }


    protected void postinstantiation() {
        this.extractRelevantFacts(this.getIntActions(), this.getIntMethods(), this.getIntInitPredicates());
        this.extractRelevantTasks();

        this.initOfMapFluentIndex();

        this.initRelevantOperators();
        this.initMapOfTaskIndex();

        this.encodeGoal();

        this.encodeInitialTaskNetwork();
        this.encodeMethods();
        this.encodeInit();

        this.encodeActions(this.getIntActions());

    }



    /**
     * Returns <code>true</code> if this problem is solvable. In the case of STRIPS planning, the method returns
     * <code>false</code> if the goal is simplified to <code>false</code> during the encoding process, otherwise the
     * method returns <code>true</code>. In the case of HTN planning, the method returns <code>false</code> if at least
     * one of the task of the initial task network is not reachable after the encoding process, i.e., as a task is set
     * to null in the tasks list of the initial task network, otherwise the method returns <code>true</code>.
     * <p>
     * Warning, it is not because the method returns <code>true</code> that the problem is solvable. It just means that
     * the encoding process can not exclude the fact that the problem is solvable.
     * </p>
     *
     * @return <code>true</code> if this problem is solvable; <code>false</code>.
     */
    public final boolean isSolvable() {
        boolean isSovable = true;
        Iterator<Integer> i = this.getInitialTaskNetwork().getTasks().iterator();
        while (i.hasNext() && isSovable) {
            isSovable = i.next() != null;
        }
        return isSovable;
    }

    /**
     * Returns true if the problem is totally ordered. The method returns true if the problem is not hierarchic.
     * A hierarchical problem is totally ordered if and only the subtasks of each method of the problem are totally
     * ordered and the initial task network is totally ordered.
     *
     * @return true if the problem is totally ordered, false otherwise.
     */
    public final boolean isTotallyOrederd() {
        boolean totallyOrdered = true;
        Iterator<Method> i = this.getMethods().iterator();
        while (i.hasNext() && totallyOrdered) {
            Method m = i.next();
            totallyOrdered = m.getTaskNetwork().isTotallyOrdered();
        }
        return totallyOrdered ? this.getInitialTaskNetwork().isTotallyOrdered() : totallyOrdered;
    }

}
