package fr.uga.pddl4j.planners;

import fr.uga.pddl4j.planners.ff.FF;
import fr.uga.pddl4j.planners.hc.EHC;
import fr.uga.pddl4j.planners.hsp.HSP;

/**
 * This class defines the main methods to create planner.
 *
 * @author D. Pellier
 * @version 1.0 - 20.06.2017
 *
 * @since 3.0
 * @see Planner
 */
public class PlannerFactory {

    ///**
    // * An instance of the class.
    // */
    //private static PlannerFactory instance;

    /**
     * Creates a new PlannerFactory.
     * The constructor is override to
     */
    private PlannerFactory() {
        super();
    }

    /**
     * Returns an instance of the specified planner.
     *
     * @param name the name of the planner.
     * @return an instance of the specified planner.
     * @see fr.uga.pddl4j.planners.Planner.Name
     */
    public Planner getPlanner(final Planner.Name name) {
        Planner planner = null;
        switch (name) {
            case HSP: planner = new HSP();
            break;

            case FF: planner = new FF();
            break;

            case EHC: planner = new EHC();
            break;
        }
        return planner;
    }

    ///**
    // * Returns an instance of this class.
    // *
    // * @return an instance of this class.
    // */
    //public static PlannerFactory getInstance() {
    //    return PlannerFactory.instance;
    //}
}
