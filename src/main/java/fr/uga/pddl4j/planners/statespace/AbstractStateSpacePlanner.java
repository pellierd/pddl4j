/*
 * Copyright (c) 2016 by Damien Pellier <Damien.Pellier@imag.fr>.
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

package fr.uga.pddl4j.planners.statespace;

import fr.uga.pddl4j.heuristics.state.StateHeuristic;
import fr.uga.pddl4j.parser.RequireKey;
import fr.uga.pddl4j.plan.Plan;
import fr.uga.pddl4j.plan.SequentialPlan;
import fr.uga.pddl4j.planners.AbstractPlanner;
import fr.uga.pddl4j.planners.InvalidConfigurationException;
import fr.uga.pddl4j.planners.Planner;
import fr.uga.pddl4j.planners.PlannerConfiguration;
import fr.uga.pddl4j.planners.ProblemNotSupportedException;
import fr.uga.pddl4j.planners.SearchStrategy;
import fr.uga.pddl4j.planners.statespace.search.Node;
import fr.uga.pddl4j.planners.statespace.search.StateSpaceSearch;
import fr.uga.pddl4j.problem.Problem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This abstract class defines the main methods to access a state based planner.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 * @since 3.0
 */
public abstract class AbstractStateSpacePlanner extends AbstractPlanner implements StateSpacePlanner {

    /**
     * The class logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(AbstractStateSpacePlanner.class.getName());

    /**
     * The list of search strategies used by the planner.
     */
    private List<SearchStrategy.Name> searchStrategies;

    /**
     * The weight of the heuristic.
     */
    private double heuristicWeight;

    /**
     * The name of the heuristic used by the planner.
     */
    private StateHeuristic.Name heuristic;

    /**
     * Creates a new planner.
     */
    public AbstractStateSpacePlanner() {
        this(AbstractStateSpacePlanner.getDefaultConfiguration());
    }

    /**
     * Creates a new planner with a specific configuration.
     *
     * @param configuration the configuration of the planner.
     */
    public AbstractStateSpacePlanner(final PlannerConfiguration configuration) {
        super();
        this.searchStrategies = new ArrayList<>();
        this.setConfiguration(configuration);
    }

    /**
     * Sets the list of search strategies to used to solve a planning problem. The search strategies are tried in the
     * specified order. The search stops when a search strategy succeed.
     *
     * @param strategies the list of search strategies to used.
     */
    public void setSearchStrategies(List<SearchStrategy.Name> strategies) {
        this.searchStrategies = strategies;
    }

    /**
     * Adds a search strategy to the planner.
     *
     * @param strategy the strategy to add.
     */
    public void addSearchStrategy(SearchStrategy.Name strategy) {
        this.searchStrategies.add(strategy);
    }

    /**
     * Returns the list of search strategies to used to solve a planning problem.
     *
     * @return the list of search strategies to used to solve a planning problem.
     */
    public final List<SearchStrategy.Name> getSearchStrategies() {
        return this.searchStrategies;
    }

    /**
     * Sets the weight of the heuristic.
     *
     * @param weight the weight of the heuristic. The weight must be greater than 0.
     * @throws IllegalArgumentException if the weight is strictly less than 0.
     */
    public void setHeuristicWeight(final double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("weight must be greater than 0.0");
        }
        this.heuristicWeight = weight;
    }

    /**
     * Set the name of heuristic used by the planner to the solve a planning problem.
     *
     * @param heuristic the name of the heuristic.
     */
    public void setHeuristic(StateHeuristic.Name heuristic)  {
        this.heuristic = heuristic;
    }

    /**
     * Returns the name of the heuristic used by the planner to solve a planning problem.
     *
     * @return the name of the heuristic used by the planner to solve a planning problem.
     */
    public final StateHeuristic.Name getHeuristic() {
        return this.heuristic;
    }

    /**
     * Returns the weight of the heuristic.
     *
     * @return the weight of the heuristic.
     */
    public final double getHeuristicWeight() {
        return this.heuristicWeight;
    }

    /**
     * Checks the planner configuration and returns if the configuration is valid. A configuration is valid if (1) the
     * domain and the problem files exist and can be read, (2) the timeout is greater than 0, (3) the weight of the
     * heuristic is greater than 0, (4) the heuristic is a not null and (5) the list of search strategies to use to
     * solve a planning problem is not empty.
     *
     * @return <code>true</code> if the configuration is valid <code>false</code> otherwise.
     */
    public boolean hasValidConfiguration() {
        return super.hasValidConfiguration()
            && this.getHeuristicWeight() > 0.0
            && this.getHeuristic() != null
            && !this.getSearchStrategies().isEmpty();
    }

    /**
     * Throws a {@code InvalidPlannerConfigurationException} with the appropriated message or do nothing if the planner
     * has a valid configuration.
     */
    protected void throwInvalidConfigurationException() throws InvalidConfigurationException {
        super.throwInvalidConfigurationException();
        if (this.getHeuristicWeight()  < 0.0) {
            throw new InvalidConfigurationException("Invalid heuristic weight");
        } else if (this.getHeuristic() == null) {
            throw new InvalidConfigurationException("Undefined heuristic");
        } else if (this.getSearchStrategies().isEmpty()) {
            throw new InvalidConfigurationException("Undefined search strategies");
        }
    }

    /**
     * This method return the default arguments of the planner.
     *
     * @return the default arguments of the planner.
     * @see PlannerConfiguration
     */
    public static PlannerConfiguration getDefaultConfiguration() {
        PlannerConfiguration config = Planner.getDefaultConfiguration();
        config.setProperty(StateSpacePlanner.SEARCH_STRATEGIES_SETTING,
            StateSpacePlanner.DEFAULT_SEARCH_STRATEGIES.toString());
        config.setProperty(StateSpacePlanner.HEURISTIC_SETTING, StateSpacePlanner.DEFAULT_HEURISTIC.toString());
        config.setProperty(StateSpacePlanner.WEIGHT_HEURISTIC_SETTING,
            Double.toString(StateSpacePlanner.DEFAULT_WEIGHT_HEURISTIC));
        return config;
    }

    /**
     * Returns the configuration of the planner.
     *
     * @return the configuration of the planner.
     */
    @Override
    public PlannerConfiguration getConfiguration() {
        final PlannerConfiguration config =  super.getConfiguration();
        config.setProperty(StateSpacePlanner.SEARCH_STRATEGIES_SETTING, this.getSearchStrategies().toString());
        config.setProperty(StateSpacePlanner.HEURISTIC_SETTING, this.getHeuristic().toString());
        config.setProperty(StateSpacePlanner.WEIGHT_HEURISTIC_SETTING, Double.toString(this.getHeuristicWeight()));
        return config;
    }

    /**
     * Sets the configuration of the planner. If a planner setting is not defined in the specified configuration, the
     * setting is initialized with its default value.
     *
     * @param configuration the configuration to set.
     */
    @Override
    public void setConfiguration(final PlannerConfiguration configuration) {
        super.setConfiguration(configuration);
        if (configuration.getProperty(StateSpacePlanner.SEARCH_STRATEGIES_SETTING) == null) {
            this.setSearchStrategies(StateSpacePlanner.DEFAULT_SEARCH_STRATEGIES);
        } else {
            this.setSearchStrategies(SearchStrategy.toSearchStrategies(configuration.getProperty(
                StateSpacePlanner.SEARCH_STRATEGIES_SETTING)));
        }
        if (configuration.getProperty(StateSpacePlanner.WEIGHT_HEURISTIC_SETTING) == null) {
            this.setHeuristicWeight(StateSpacePlanner.DEFAULT_WEIGHT_HEURISTIC);
        } else {
            this.setHeuristicWeight(Double.parseDouble(configuration.getProperty(
                StateSpacePlanner.WEIGHT_HEURISTIC_SETTING)));
        }
        if (configuration.getProperty(StateSpacePlanner.HEURISTIC_SETTING) == null) {
            this.setHeuristic(StateSpacePlanner.DEFAULT_HEURISTIC);
        } else {
            this.setHeuristic(StateHeuristic.Name.valueOf(configuration.getProperty(
                StateSpacePlanner.HEURISTIC_SETTING)));
        }
    }

    /**
     * Search a solution plan to a specified domain and problem. The method search a solution plan by trying iteratively
     * all the search strategies defined.
     *
     * @param problem the problem to solve.
     * @return the plan found or null if no plan was found.
     * @throws ProblemNotSupportedException if the problem to solve is not supported by the planner.
     */
    public Plan solve(final Problem problem) throws ProblemNotSupportedException {
        if (!this.isSupported(problem)) {
            throw new ProblemNotSupportedException(("Problem not supported"));
        }

        Plan plan = null;
        final Iterator<SearchStrategy.Name> i = this.getSearchStrategies().iterator();
        int timeout = this.getTimeout();
        while (plan == null && i.hasNext()) {
            final long begin = System.currentTimeMillis();
            final SearchStrategy.Name strategy = i.next();
            LOGGER.info("* Starting " + strategy.name() + " search with "
                + this.getConfiguration().getProperty(AbstractStateSpacePlanner.HEURISTIC_SETTING) + " heuristic \n");
            StateSpaceSearch search = StateSpaceSearch.getInstance(strategy, this.getHeuristic(),
                this.getHeuristicWeight(), timeout);
            final Node solution = search.searchSolutionNode(problem);
            plan = (SequentialPlan) search.extractPlan(solution, problem);
            if (solution != null) {
                LOGGER.info("* " + strategy.name() + " search succeeded\n");
                this.getStatistics().setTimeToSearch(search.getSearchingTime());
                this.getStatistics().setMemoryUsedToSearch(search.getMemoryUsed());
            } else {
                LOGGER.info("* " + strategy.name() + " search failed\n");
            }
            final long end = System.currentTimeMillis();
            this.getStatistics().setMemoryUsedToSearch(search.getMemoryUsed());
            timeout -= ((end - begin) / 1000);
        }
        return plan;
    }

    /**
     * Returns if a specified problem is supported by the planner.
     *
     * @param problem the problem to test.
     * @return <code>true</code> if the problem is supported <code>false</code> otherwise.
     */
    @Override
    public boolean isSupported(Problem problem) {
        return (problem.getRequirements().contains(RequireKey.ACTION_COSTS)
            || problem.getRequirements().contains(RequireKey.CONSTRAINTS)
            || problem.getRequirements().contains(RequireKey.CONTINOUS_EFFECTS)
            || problem.getRequirements().contains(RequireKey.DERIVED_PREDICATES)
            || problem.getRequirements().contains(RequireKey.DURATIVE_ACTIONS)
            || problem.getRequirements().contains(RequireKey.DURATION_INEQUALITIES)
            || problem.getRequirements().contains(RequireKey.FLUENTS)
            || problem.getRequirements().contains(RequireKey.GOAL_UTILITIES)
            || problem.getRequirements().contains(RequireKey.METHOD_CONSTRAINTS)
            || problem.getRequirements().contains(RequireKey.NUMERIC_FLUENTS)
            || problem.getRequirements().contains(RequireKey.OBJECT_FLUENTS)
            || problem.getRequirements().contains(RequireKey.PREFERENCES)
            || problem.getRequirements().contains(RequireKey.TIMED_INITIAL_LITERALS)
            || problem.getRequirements().contains(RequireKey.HIERARCHY))
            ? false : true;
    }
}
