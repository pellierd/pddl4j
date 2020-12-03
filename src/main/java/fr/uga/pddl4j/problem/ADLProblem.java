package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.encoding.PostInstantiatedProblem;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.PDDLRequireKey;

import java.util.Iterator;

/**
 * Created by pellier on 03/12/2020.
 */
public class ADLProblem extends PostInstantiatedProblem {

    public ADLProblem(final PDDLDomain domain, final PDDLProblem problem) {
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
        // Collect the function information (symbols and signatures)
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.collectFunctionInformation();
        }
        // Collect the tasks information (symbols and signatures)
        this.collectTaskInformation();

        // Encode the actions of the domain into integer representation
        this.encodeIntActions();

        // Encode the methods of the domain into integer representation
        if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.encodeIntMethods();
        }

        // Encode the initial state in integer representation
        this.encodeIntInit();
        // Encode the goal in integer representation
        this.encodeIntGoal();

        // Encode the initial task network in integer representation
        if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.encodeIntInitialTaskNetwork();
        }
    }

    protected void preinstantiation() {
        this.extractInertia();
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.extractNumericInertia();
        }

        // Infer the type from the unary inertia
        if (!this.getRequirements().contains(PDDLRequireKey.TYPING)
            &&!this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.inferTypesFromInertia();
            this.simplifyActionsWithInferredTypes();
        }
        // Create the predicates tables used to count the occurrences of the predicates in the
        // initial state
        this.createPredicatesTables();

        if (this.getRequirements().contains(PDDLRequireKey.DURATIVE_ACTIONS)) {
            this.expandTemporalActions(this.getIntActions());
        }
    }

    protected void instantiation() {
        this.instantiateActions();

        this.extractGroundInertia();
        this.extractGroundNumericInertia();
        this.simplyActionsWithGroundInertia();
        this.instantiateGoal();
        this.simplifyGoalWithGroundInertia();
        if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.instantiateInitialTaskNetwork();
            this.instantiateMethods(this.getIntMethods(), this.getIntInitialTaskNetwork(), this.getIntActions());
            this.simplyMethodsWithGroundInertia();
        }

    }


    protected void postinstantiation() {
        this.extractRelevantFacts(this.getIntActions(), this.getIntMethods(), this.getIntInitPredicates());
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.extractRelevantNumericFluents(this.getIntActions(),this.getIntMethods());
        }
        if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.extractRelevantTasks();
        }

        this.initOfMapFluentIndex();
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.initMapOfNumericFluentIndex();
        }

        if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.initRelevantOperators();
            this.initMapOfTaskIndex();
        }

        this.encodeGoal();

        if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.encodeInitialTaskNetwork();
            this.encodeMethods();
        }

        this.encodeInit();
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.encodeInitNumericFluent();
        }
        if (this.getRequirements().contains(PDDLRequireKey.DURATIVE_ACTIONS)) {
            NumericVariable duration = new NumericVariable(NumericVariable.DURATION, 0.0);
            this.getInitialState().addNumericFluent(duration);
        }
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
        if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            Iterator<Integer> i = this.getInitialTaskNetwork().getTasks().iterator();
            while (i.hasNext() && isSovable) {
                isSovable = i.next() != null;
            }
        } else {
            isSovable = this.getGoal() != null;
        }
        return isSovable;
    }
}
