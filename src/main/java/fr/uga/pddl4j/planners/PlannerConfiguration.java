/*
 * Copyright (c) 2021 by Damien Pellier <Damien.Pellier@imag.fr>.
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


package fr.uga.pddl4j.planners;

import fr.uga.pddl4j.planners.htn.stn.PFDPlanner;
import fr.uga.pddl4j.planners.htn.stn.TFDPlanner;
import fr.uga.pddl4j.planners.statespace.FF;
import fr.uga.pddl4j.planners.statespace.GenericPlanner;
import fr.uga.pddl4j.planners.statespace.HSP;
import org.apache.logging.log4j.Level;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * This class implements a planner configuration. A planner configuration is used to create a planner.
 *
 * <p>To create a planner with a specific configuration use the following example code:</p>
 * <pre>
 *      PlannerConfiguration config = new PlannerConfiguration();
 *      config.setPlanner(Setting.Planner.HSP);
 *      config.setHeuristic(Setting.Heuristic.FAST_FORWARD);
 *      config.setWeightHeuristic(1.0);
 *      config.setTraceLevel(Level.INFO);
 *      Planner planner = config.buildPlanner();
 *      planner.solve();
 * </pre>
 *
 * <p>Find below a command line example to launch the generic planner with ASTAR search strategy and MAX heuristic:</p>
 * <pre>
 *     java -server -Xms2048m -Xmx2048m -jar build/libs/pddl4j-4.0-all.jar
 *          -p GENERIC
 *          -o src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/domain.pddl
 *          -f src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/p01.pddl
 *          -h MAX
 *          -s ASTAR
 * </pre>
 *
 * @author D. Pellier
 * @version 1.0 - 18.06.2020
 * @since 4.0
 */
public class PlannerConfiguration implements Serializable {

    /**
     * The properties object used to store the configuration.
     */
    private Properties settings;

    /**
     * Returns the default configuration.
     *
     * @return a default configuration.
     */
    public static PlannerConfiguration getDefaultConfiguration() {
        return new PlannerConfiguration();
    }

    /**
     * Creates a configuration from an other.
     *
     * @param other the other configuration.
     */
    public PlannerConfiguration(PlannerConfiguration other) {
        this.settings = new Properties();
        this.setPlanner(other.getPlanner());
        this.setDomain(other.getDomain());
        this.setProblem(other.getProblem());
        this.setTimeout(other.getTimeout());
        this.setTraceLevel(other.getTraceLevel());
        this.setSearchStrategy(other.getSearchStrategy());
        this.setHeuristic(other.getHeuristic());
        this.setHeuristicWeight(other.getHeuristicWeight());
    }

    /**
     * Creates new default configuration. The default configuration values are defined the class setting.
     *
     * @see Setting
     */
    public PlannerConfiguration() {
        this.settings = new Properties();
        this.setPlanner(Setting.DEFAULT_PLANNER);
        this.setDomain(Setting.DEFAULT_DOMAIN);
        this.setProblem(Setting.DEFAULT_PROBLEM);
        this.setTimeout(Setting.DEFAULT_TIMEOUT);
        this.setTraceLevel(Setting.DEFAULT_TRACE_LEVEL);
        this.setSearchStrategy(Setting.DEFAULT_SEARCH_STRATEGY);
        this.setHeuristic(Setting.DEFAULT_HEURISTIC);
        this.setHeuristicWeight(Setting.DEFAULT_HEURISTIC_WEIGHT);
    }

    /**
     * Creates a new planner configuration from a command line.
     *
     * @param args the arguments from the command line.
     */
    public PlannerConfiguration(final String[] args) {
        this(args, PlannerConfiguration.getDefaultConfiguration());
    }

    /**
     * Creates a new planner configuration from a command line and a default configuration.
     *
     * @param args the arguments from the command line.
     * @param configuration the default configuration to use.
     */
    public PlannerConfiguration(final String[] args, PlannerConfiguration configuration) {
        this(configuration);
        this.initFromCommandLine(args);
    }

    /**
     * Initialize the configuration from a command line arguments.
     *
     * @param args the command line arguments.
     */
    private void initFromCommandLine(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            if ("-p".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                this.setPlanner(Setting.Planner.valueOf(args[i + 1]));
            } else if ("-o".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                this.setDomain(args[i + 1]);
            } else if ("-f".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                this.setProblem(args[i + 1]);
            } else if ("-t".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                final int timeout = Integer.parseInt(args[i + 1]) * 1000;
                if (timeout < 0) {
                    throw new IllegalArgumentException("Time out must be greater that 0.");
                }
                this.setTimeout(timeout);
            } else if ("-h".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                try {
                    this.setHeuristic(Setting.Heuristic.valueOf(args[i + 1]));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Invalid heuristic: " + args[i + 1]);
                }
            } else if ("-w".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                final double weight = Double.parseDouble(args[i + 1]);
                if (weight < 0) {
                    throw new IllegalArgumentException("Heuristic weight must be greater that 0.");
                }
                this.setHeuristicWeight(weight);
            } else if ("-v".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                try {
                    this.setTraceLevel(Level.valueOf(args[i + 1]));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Invalid trace level: " + args[i + 1]);
                }
            } else if ("-s".equalsIgnoreCase(args[i]) && ((i + 1) < args.length)) {
                try {
                    this.setSearchStrategy(Setting.SearchStrategy.valueOf(args[i + 1]));
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Invalid search strategy: " + args[i + 1]);
                }
            } else {
                throw new IllegalArgumentException("Unexpected argument or option: " + args[i]);
            }
        }
        if (this.getDomain().equals(Setting.DEFAULT_DOMAIN)) {
            throw new IllegalArgumentException("Domain not defined.");
        }
        if (this.getProblem().equals(Setting.DEFAULT_PROBLEM)) {
            throw new IllegalArgumentException("Problem not defined.");
        }
    }

    /**
     * Sets the planner of to used.
     *
     * @param planner the planner to set.
     */
    public void setPlanner(final Setting.Planner planner) {
        this.settings.setProperty(Setting.PLANNER.name(), planner.name());
    }

    /**
     * Returns the planner of the configuration.
     *
     * @return the planner of the configuration.
     */
    public Setting.Planner getPlanner() {
        final String property = this.settings.getProperty(Setting.PLANNER.name());
        return property == null ? null :  Setting.Planner.valueOf(property);

    }

    /**
     * Sets the domain of the configuration.
     *
     * @param domain the path to the PDDL domain file.
     */
    public void setDomain(final String domain) {
        this.settings.setProperty(Setting.DOMAIN.name(), domain);
    }

    /**
     * Sets the path to the PDDL domain file of the configuration.
     *
     * @return the path to the PDDL domain file of the configuration.
     */
    public String getDomain() {
        return this.settings.getProperty(Setting.DOMAIN.name());
    }

    /**
     * Returns the domain file containing the PDDL domain description.
     *
     * @return the domain file containing the PDDL domain description.
     */
    public File getDomainFile() {
        return new File(this.getDomain());
    }

    /**
     * Sets the path to the PDDL problem description.
     *
     * @param problem the path to the PDDL problem description.
     */
    public void setProblem(final String problem) {
        this.settings.setProperty(Setting.PROBLEM.name(), problem);
    }

    /**
     * Returns the path to the PDDL problem description.
     *
     * @return the path to the PDDL problem description.
     */
    public String getProblem() {
        return this.settings.getProperty(Setting.PROBLEM.name());
    }

    /**
     * Returns the problem file containing the PDDL problem description.
     *
     * @return the problem file containing the PDDL problem description.
     */
    public File getProblemFile() {
        return new File(this.getProblem());
    }

    /**
     * Sets the trace level of the configuration.
     *
     * @param level the trace level declared in the configuration.
     */
    public void setTraceLevel(final Level level) {
        this.settings.setProperty(Setting.TRACE_LEVEL.name(), level.name());
    }

    /**
     * Returns the trace level of the configuration.
     *
     * @return the trace level declared of the configuration.
     */
    public Level getTraceLevel() {
        final String property = this.settings.getProperty(Setting.TRACE_LEVEL.name());
        return property == null ? null :  Level.valueOf(property);
    }

    /**
     * Sets the timeout of the configuration.
     *
     * @param timeout to use of the configuration.
     */
    public void setTimeout(int timeout) {
        this.settings.setProperty(Setting.TIMEOUT.name(), Integer.toString(timeout));
    }

    /**
     * Returns the timeout of the configuration.
     *
     * @return the timeout declared in the configuration.
     */
    public int getTimeout() {
        final String property = this.settings.getProperty(Setting.TIMEOUT.name());
        return property == null ? null : Integer.valueOf(property);
    }

    /**
     * Sets the heuristic of the configuration.
     *
     * @param heuristic the heuristic of the configuration.
     */
    public void setHeuristic(final Setting.Heuristic heuristic) {
        this.settings.setProperty(Setting.HEURISTIC.name(), heuristic.name());
    }

    /**
     * Returns the heuristic of the configuration.
     *
     * @return the heuristic of the configuration.
     */
    public Setting.Heuristic getHeuristic() {
        final String property = this.settings.getProperty(Setting.HEURISTIC.name());
        return property == null ? null :  Setting.Heuristic.valueOf(property);
    }

    /**
     * Sets the heuristic weight of the configuration.
     *
     * @param weight the heuristic weight of the configuration.
     */
    public void setHeuristicWeight(double weight) {
        this.settings.setProperty(Setting.HEURISTIC_WEIGHT.name(), Double.toString(weight));
    }

    /**
     * Returns the heuristic weight of the configuration.
     *
     * @return weight the heuristic weight of the configuration.
     */
    public double getHeuristicWeight() {
        final String property = this.settings.getProperty(Setting.HEURISTIC_WEIGHT.name());
        return property == null ? null : Double.valueOf(property);
    }

    /**
     * Sets the search strategy of the configuration.
     *
     * @param strategy the search strategy of the configuration.
     */
    public void setSearchStrategy(final Setting.SearchStrategy strategy) {
        this.settings.setProperty(Setting.SEARCH_STRATEGY.name(), strategy.name());
    }

    /**
     * Returns the search strategy of the configuration.
     *
     * @return the search strategy of the configuration.
     */
    public Setting.SearchStrategy getSearchStrategy() {
        final String property = this.settings.getProperty(Setting.SEARCH_STRATEGY.name());
        return property == null ? null :  Setting.SearchStrategy.valueOf(property);
    }

    /**
     * Builds a planner with the specific configuration.
     *
     * @return the planner built.
     */
    public Planner buildPlanner() {
        switch (this.getPlanner()) {
            case HSP:
                return new HSP(this);
            case FF:
                return new FF(this);
            case GENERIC:
                return new GenericPlanner(this);
            case TFD:
                return new TFDPlanner(this);
            case PFD:
                return new PFDPlanner(this);
            default:
                throw new InvalidConfigurationException();
        }
    }


    /**
     * Returns the hash code value of this configuration.
     *
     * @return the hash code value of this configuration.
     */
    public int hashcode() {
        return Objects.hash(this.settings);
    }

    /**
     * Returns if this configuration is equal to an other object. A configuration is equal to an other object if the
     * object is an instance of the class <code>Configuration</code> and if both configurations have the same settings.
     *
     * @param object the object to be compared.
     * @return <code>true</code> the object in paremeter is equal to this configuration.
     */
    public boolean equal(final Object object) {
        if (object instanceof PlannerConfiguration) {
            PlannerConfiguration other = (PlannerConfiguration) object;
            return other.settings.equals(this.settings);
        }
        return false;
    }

    /**
     * Returns a string representation of this configuration.
     *
     * @return a string representation of this configuration.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<Object, Object> e : this.settings.entrySet()) {
            str.append(e.getKey());
            str.append("=");
            str.append(e.getValue());
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * The main method of the PDDL4J library. The command line syntax is as follow:
     *
     * <pre>
     * usage of PlannerConfiguration:
     *
     * OPTIONS   DESCRIPTIONS
     *
     * -p <i>planner</i>    the planner to use: FF, HSP, GENERIC, TFD, PFD
     * -o <i>str</i>        the path to the domain
     * -f <i>str</i>        the path to the problem
     * -t <i>num</i>        specifies the maximum CPU-time in seconds (preset: 600)
     * -s <i>strategy</i>   the search strategies: ASTAR, ENFORCE_HILL_CLIMBING, HILL_CLIMBING, GREEDY_BEST_FIRST,
     *                          DEPTH_FIRST, BREADTH_FIRST (preset: ASTAR);
     * -h <i>heuristic</i>  the heuristics: FAST_FORWARD, MAX, SUM, SUM_MUTEX, SET_LEVEL, COMBO, ADJUSTED_SUM,
     *                          ADJUSTED_SUM2, ADJUSTED_SUM2M (preset: FAST_FORWARD)
     * -v <i>level</i>      the trace level: ALL, DEBUG, INFO, WARN, ERROR, FATAL, OFF (preset: INFO)
     *
     * </pre>
     *
     * <p>Commande line example:</p>
     * <pre>
     * java -cp build/libs/pddl4j-x.x.x.jar fr.uga.pddl4j.planners.PlannerConfiguration
     *      -p HSP
     *      -o src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/domain.pddl
     *      -f src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/pb01.pddl
     *      -s ASTAR
     *      -h FAST_FORWARD
     * </pre>
     *
     * @param args the arguments of the command line.
     */
    public static void main(final String[] args) {
        try {
            final PlannerConfiguration config = new PlannerConfiguration(args);
            final Planner planner = config.buildPlanner();
            planner.solve();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }  catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
