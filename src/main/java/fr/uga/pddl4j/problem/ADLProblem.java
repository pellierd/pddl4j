package fr.uga.pddl4j.problem;

import fr.uga.pddl4j.encoding.IntProblem;
import fr.uga.pddl4j.encoding.PreInstantiatedProblem;
import fr.uga.pddl4j.parser.*;

/**
 * Created by pellier on 01/12/2020.
 */
public class ADLProblem extends PreInstantiatedProblem {


    public ADLProblem(final PDDLDomain domain, final PDDLProblem problem) {
        super(domain, problem);
    }



    @Override
    protected void postInstantiate() {

    }

}
