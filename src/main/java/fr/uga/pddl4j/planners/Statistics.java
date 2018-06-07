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

package fr.uga.pddl4j.planners;

import java.io.Serializable;

/**
 * The class implements the statistics of the planner, search time, memory used, etc.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 * @since 3.0
 */
public class Statistics implements Serializable {

    /**
     * The serial id of the class.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The encoding time in ms.
     */
    private long timeToEncode;

    /**
     * The search time in ms.
     */
    private long timeToSearch;

    /**
     * The parsing time in ms.
     */
    private long timeToParse;

    /**
     * The memory used to store the problem in bytes.
     */
    private long memoryForProblem;

    /**
     * The memory used to during search in bytes.
     */
    private long memoryUsedToSearch;

    /**
     * The number of actions of the problem solved.
     */
    private int numberOfActions;

    /**
     * The number of relevant fluents.
     */
    private int numberOfRelevantFacts;

    /**
     * The  to the problem solved.
     */
    private String problem;

    /**
     * Creates a new statistics object to store statistical information about  planner performances.
     * The default statistic values are set to 0.
     */
    public Statistics() {
        this.timeToEncode = 0;
        this.timeToSearch = 0;
        this.timeToParse = 0;
        this.memoryForProblem = 0;
        this.memoryUsedToSearch = 0;
        this.numberOfActions = 0;
        this.numberOfRelevantFacts = 0;
        this.problem = null;
    }

    /**
     * Returns the path to the file containing the description of the solved problem.
     *
     * @return the path to the file containing the description of the solved problem.
     */
    public final String getProblem() {
        return this.problem;
    }

    /**
     * Sets the path to the file containing the description of the solved problem.
     *
     * @param problem the path to the file containing the description of the solved problem.
     */
    public final void setProblem(final String problem) {
        this.problem = problem;
    }

    /**
     * Sets the name of the solved problem.
     *
     */
    /**
     * Returns the memory used to encode the planning problem in bytes.
     *
     * @return the memory used to encode the planning problem.
     */
    public final long getMemoryUsedForProblemRepresentation() {
        return this.memoryForProblem;
    }

    /**
     * Sets the memory used to encode the planning problem in bytes.
     *
     * @param memory the memory used to encode the planning problem in bytes.
     */
    public void setMemoryUsedForProblemRepresentation(final long memory) {
        this.memoryForProblem = memory;
    }

    /**
     * Returns the memory used to search a planning problem in bytes.
     *
     * @return the memory used to search a planning problem.
     */
    public final long getMemoryUsedToSearch() {
        return this.memoryUsedToSearch;
    }

    /**
     * Sets the memory used to search the planning problem in bytes.
     *
     * @param memory the memory used to search the planning problem in bytes.
     */
    public final void setMemoryUsedToSearch(final long memory) {
        this.memoryUsedToSearch = memory;
    }

    /**
     * Returns the number of actions contained in the solved problem .
     *
     * @return the number of actions contained in the solved problem .
     */
    public final int getNumberOfActions() {
        return this.numberOfActions;
    }

    /**
     * Sets the number of actions of the solved problem .
     *
     * @param actions the number of actions of the solved problem .
     */
    public final void setNumberOfActions(final int actions) {
        this.numberOfActions = actions;
    }

    /**
     * Returns the number of relevant facts of the solved problem.
     *
     * @return the number of relevant facts of the solved problem.
     */
    public final int getNumberOfRelevantFluents() {
        return this.numberOfRelevantFacts;
    }

    /**
     * Sets the number of relevant facts of the solved problem.
     *
     * @param facts the number of relevant facts of the solved problem.
     */
    public final void setNumberOfRelevantFluents(int facts) {
        this.numberOfRelevantFacts = facts;
    }

    /**
     * Returns the encoding time, i.e., the time to encode the planning problem in a compact representation.
     *
     * @return the encoding time in ms.
     */
    public final long getTimeToEncode() {
        return this.timeToEncode;
    }

    /**
     * Returns the search time, i.e., the time needed to find a solution.
     *
     * @return the search time in ms.
     */
    public final long getTimeToSearch() {
        return this.timeToSearch;
    }

    /**
     * Return the parsing time, i.e., the time needed to parser the domain and the problem description.
     *
     * @return the parsing time in ms.
     */
    public final long getTimeToParse() {
        return this.timeToParse;
    }

    /**
     * Sets the encoding time, i.e., the time to encode the planning problem in a compact representation.
     *
     * @param time the encoding time in ms.
     */
    public final void setTimeToEncode(final long time) {
        this.timeToEncode = time;
    }

    /**
     * Sets the search time, i.e., the time needed to find a solution.
     *
     * @param time the search time in ms.
     */
    public final void setTimeToSearch(final long time) {
        this.timeToSearch = time;
    }

    /**
     * Sets the parsing time, i.e., the time needed to parser the domain and the problem description.
     *
     * @param time the parsing time in ms.
     */
    public final void setTimeToParse(final long time) {
        this.timeToParse = time;
    }

    /**
     * Returns a string representation of this statistics.
     *
     * @return a string representation of this statistics.
     */
    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();

        final double timeToParseInSeconds = Statistics.millisecondToSecond(this.timeToParse);
        final double timeToEncodeInSeconds = Statistics.millisecondToSecond(this.timeToEncode);
        final double timeToSearchInSeconds = Statistics.millisecondToSecond(this.timeToSearch);
        final double totalTimeInSeconds = timeToParseInSeconds + timeToEncodeInSeconds + timeToSearchInSeconds;
        final double memoryForProblemInMBytes = Statistics.byteToMByte(this.memoryForProblem);
        final double memoryUsedToSearchInMBytes = Statistics.byteToMByte(this.memoryUsedToSearch);
        final double totalMemoryInMBytes = memoryForProblemInMBytes + memoryUsedToSearchInMBytes;

        strb.append(String.format("* Problem features:%n"));
        strb.append(String.format("%8d number of actions %n", this.numberOfActions));
        strb.append(String.format("%8d number of relevant facts %n", this.numberOfRelevantFacts));
        strb.append(String.format("%n* Time spent:%n"));
        strb.append(String.format("%8.2f seconds parsing %n", timeToParseInSeconds));
        strb.append(String.format("%8.2f seconds encoding %n", timeToEncodeInSeconds));
        strb.append(String.format("%8.2f seconds searching%n", timeToSearchInSeconds));
        strb.append(String.format("%8.2f seconds total time%n", totalTimeInSeconds));
        strb.append(String.format("%n* Memory used:%n"));
        strb.append(String.format("%8.2f MBytes for problem representation%n", memoryForProblemInMBytes));
        strb.append(String.format("%8.2f MBytes for searching%n", memoryUsedToSearchInMBytes));
        strb.append(String.format("%8.2f MBytes total%n%n%n", totalMemoryInMBytes));

        return strb.toString();
    }

    /**
     * Converts a time in milliseconds in seconds.
     *
     * @param time the time in milliseconds
     * @return the time in seconds.
     */
    public static final double millisecondToSecond(final long time) {
        return time / 1000.0;
    }

    /**
     * Converts a size in bytes in mega bytes.
     *
     * @param size the size in bytes
     * @return the siez in mega bytes.
     */
    public static final double byteToMByte(final long size) {
        return size / (1024.0 * 1024.0);
    }
}

