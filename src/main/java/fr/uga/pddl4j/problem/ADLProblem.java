package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.encoding.PostInstantiatedProblem;
import fr.uga.pddl4j.parser.PDDLDomain;
import fr.uga.pddl4j.parser.PDDLProblem;

/**
 * Created by pellier on 01/12/2020.
 */
public class ADLProblem extends PostInstantiatedProblem {


    public ADLProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
    }

    public void instantiate(long timout) {
        this.preInstantiate();
        this.instantiate();
        this.postInstantiate();
    }



}
