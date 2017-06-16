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

import fr.uga.pddl4j.encoding.CodedProblem;
import fr.uga.pddl4j.encoding.Encoder;
import fr.uga.pddl4j.parser.Domain;
import fr.uga.pddl4j.parser.ErrorManager;
import fr.uga.pddl4j.parser.Parser;
import fr.uga.pddl4j.parser.Problem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class defines the main methods of to create planning problem.
 *
 * @author D. Pellier
 * @version 1.0 - 12.04.2016
 *
 * @since 3.0
 * @see CodedProblem
 */
public class ProblemFactory {

    /**
     * The parser used to parser domain and problem description in PDDL.
     */
    private Parser parser;

    /**
     * The trace level.
     */
    private int traceLevel;

    /**
     * The default trace level.
     */
    public static final int DEFAULT_TRACE_LEVEL = 0;

    /**
     * Creates a new problem factory.
     */
    public ProblemFactory() {
        super();
        this.parser = new Parser();
        this.traceLevel = ProblemFactory.DEFAULT_TRACE_LEVEL;
    }

    /**
     * Parses the domain and the problem description.
     *
     * @param domain the domain file.
     * @param problem the problem file
     * @return the error manager of the parser used to parse.
     * @throws FileNotFoundException if the domain or the problem file was not found.
     * @throws IOException if an error occur during parsing.
     */
    public ErrorManager parse(final File domain, final File problem) throws IOException {
        this.parser.parse(domain, problem);
        return parser.getErrorManager();
    }

    /**
     * Parses the domain and the problem description.
     *
     * @param domain the domain string description
     * @param problem the problem string description
     * @return the error manager of the parser used to parse
     * @throws IOException if an error occur during parsing
     */
    public ErrorManager parse(final String domain, final String problem) throws IOException {
        this.parser.parseString(domain, problem);
        return parser.getErrorManager();
    }

    /**
     * Encodes and instantiates the planning problem.
     *
     * @return the encoded planning problem or null if the problem cannot be encoded.
     */
    public CodedProblem encode() {
        if (!this.parser.getErrorManager().isEmpty()) {
            return null;
        }
        final Domain domain = this.parser.getDomain();
        final Problem problem = this.parser.getProblem();
        Encoder.setLogLevel(this.getTraceLevel());
        return Encoder.encode(domain, problem);
    }

    /**
     * Sets the trace level. The levels are defined as follows:
     * <ul>
     * <ol>nothing</ol>
     * <ol>info on problem constants, types and predicates</ol>
     * <ol>1 + loaded operators, initial and goal state</ol>
     * <ol>1 + predicates and their inertia status</ol>
     * <ol>1 + 3 + goal state and operators with unary inertia encoded</ol>
     * <ol>1 + actions, initial and goal state after expansion of variables</ol>
     * <ol>1 + final domain representation</ol>
     *</ul>
     *
     * @param level the trace level.
     */
    public final void setTraceLevel(final int level) {
        this.traceLevel = level;
    }

    /**
     * Returns the trace level.
     *
     * @return level the trace level.
     */
    public final int getTraceLevel() {
        return this.traceLevel;
    }

}
