package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.encoding.IntExpression;
import fr.uga.pddl4j.encoding.PostInstantiatedProblem;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;
import fr.uga.pddl4j.parser.PDDLRequireKey;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pellier on 01/12/2020.
 */
public class ADLProblem extends PostInstantiatedProblem {

    /**
     * The list of instantiated actions encoded into bit sets.
     */
    private List<Action> actions;

    /**
     * The list of instantiated methods encoded into bit sets.
     */
    private List<Method> methods;

    private Map<IntExpression, Integer> mapOfFluentIndex;

    private Map<IntExpression, Integer> mapOfNumericFluentIndex;

    /**
     * The table containing for each relevant task its set of resolvers, i.e., action or methods
     */
    private List<List<Integer>> tableOfRelevantOperators;

    public ADLProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
    }

    public void instantiate(long timout) {
        this.preInstantiate();
        this.instantiate();
        this.postInstantiate();
        this.completeInstantiation();
    }

    public List<Action> getActions() {
        return actions;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public Map<IntExpression, Integer> getMapOfFluentIndex() {
        return mapOfFluentIndex;
    }

    public Map<IntExpression, Integer> getMapOfNumericFluentIndex() {
        return mapOfNumericFluentIndex;
    }

    public List<List<Integer>> getTableOfRelevantOperators() {
        return tableOfRelevantOperators;
    }

    public void completeInstantiation() {
        // Creates the final list of actions and methods that will be used in the problem
        this.actions = new ArrayList<>(this.getIntActions().size());
        if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.methods = new ArrayList<>(this.getIntMethods().size());
        }

        this.initOfMapFluentIndex();
        if (this.getRequirements().contains(PDDLRequireKey.NUMERIC_FLUENTS)) {
            this.initMapOfNumericFluentIndex();
        }

        if (this.getRequirements().contains(PDDLRequireKey.HIERARCHY)) {
            this.initRelevantOperators();
        }


    }

    protected void initOfMapFluentIndex() {
        // Create a map of the relevant fluents with their index to speedup the bit set encoding of the actions
        this.mapOfFluentIndex = new LinkedHashMap<>(this.getTableOfRelevantFluents().size());
        int index = 0;
        for (IntExpression fluent : this.getTableOfRelevantFluents()) {
            this.mapOfFluentIndex.put(fluent, index);
            index++;
        }
    }

    /**
     * Create a map of the relevant numeric fluents with their index to speedup the bit set encoding of the actions
     */
    protected void initMapOfNumericFluentIndex() {
        this.mapOfNumericFluentIndex = new LinkedHashMap<>(this.getTableOfRelevantNumericFluents().size());
        int index = 0;
        for (IntExpression fluent : this.getTableOfRelevantNumericFluents()) {
            this.mapOfNumericFluentIndex.put(fluent, index);
        }
    }

    protected void initRelevantOperators() {
        this.tableOfRelevantOperators = new ArrayList<>();
        for (Integer a : this.getRelevantActions()) {
            List<Integer> l = new ArrayList<>(1);
            l.add(a);
            this.tableOfRelevantOperators.add(l);
        }
        this.tableOfRelevantOperators.addAll(this.getRelevantMethods());
    }

}
