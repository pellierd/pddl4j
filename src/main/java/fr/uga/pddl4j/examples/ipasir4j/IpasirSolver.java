package fr.uga.pddl4j.examples.ipasir4j;

/*-
 * #%L
 * Java binidngs for the IPASIR C interface
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2020 Live Ontologies Project
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/**
 * An incremental SAT solver. This interface follows closely the Reentrant
 * Incremental Sat solver API (reverse: IPASIR).
 *
 * @author Yevgeny Kazakov
 *
 * @see <a href="https://github.com/biotomas/ipasir">biotomas/ipasir</a>
 *
 */
public interface IpasirSolver {

	/**
	 * @return a string consisting of the name and the version of this solver
	 */
	public String getSignature();

	/**
	 * If the argument is non-zero then it is interpreted as a propositional
	 * literal (in DIMACS notation) and added to the currently constructed
	 * clause; otherwise, if it is zero, then the currently constructed clause
	 * is added to this solver and emptied.
	 *
	 * @param literalOrZero
	 *
	 * @see <a href=
	 *      "http://www.satcompetition.org/2009/format-benchmarks2009.html">DIMACS</a>
	 */
	public void add(int literalOrZero);

	/**
	 * The argument is interpreted as a propositional literal and added (as a
	 * unit clause) to this solver; unlike the clauses added using
	 * {@link #add(int)}, the literals added using this method are only taken
	 * into account until the next satisfiability test, after which they are
	 * removed from the solver.
	 *
	 * @param literal
	 *            a non-zero value that is interpreted as a literal to be added
	 *            to this solver as an assumption
	 */
	public void assume(int literal);

	/**
	 * Checks satisfiability of the Boolean formula consisting of all clauses
	 * added to this solver by {@link #add(int)} under the assumptions set for
	 * this solver by {@link #assume(int)}.
	 *
	 * @return {@code true} if a satisfying assumption for the formula is found
	 *         and {@code false} if the formula is not satisfiable
	 * @throws SolverTerminatedException
	 *             if the satisfiability checking process was terminated
	 *
	 * @see #setTerminate(TerminationRequest)
	 */
	public boolean isSatisfiable() throws SolverTerminatedException;

	/**
	 * Evaluates {@code literal} under the last satisfying assignment found by
	 * the solver. This method can be only called when the last call of
	 * {@link #isSatisfiable()} returned {@code true} and no methods
	 * {@link #add(int)} or {@link #assume(int)} was called afterwards.
	 *
	 * @param literal
	 *            a non-zero value that is interpreted as a literal to be
	 *            evaluated
	 * @return the value of the given literal multiplied by {@code 1} if it is
	 *         {@code true} under the satisfying assignment, multiplied by
	 *         {@code -1} if it is {@code false}, or {@code 0} if its value is
	 *         irrelevant for the satisfying assignment (i.e., the current
	 *         formula in the solver is true regardless of which of these
	 *         assignment is chosen)
	 */
	public int val(int literal);

	/**
	 * Determines if the assumption {@code assume(literal)} was used for proving
	 * unsatisfiability of the formula of this solver in the last call of
	 * {@link #isSatisfiable()}. This method can be only called when the last
	 * call of {@link #isSatisfiable()} returned {@code false} and no methods
	 * {@link #add(int)} or {@link #assume(int)} was called afterwards.
	 *
	 * @param literal
	 *            a non-zero value that is interpreted as a literal to be
	 *            evaluated
	 * @return {@code true} if the the assumption {@code assume(literal)} was
	 *         used for proving unsatisfiability of the formula, and
	 *         {@code false} otherwise, i.e., removing this assumption still
	 *         results in unsatisfiable formula. If the assumption
	 *         {@code assume(literal)} was not made before the last call of
	 *         {@link #isSatisfiable()} and after the previous call of
	 *         {@link #isSatisfiable()}, the output of this method is not
	 *         specified.
	 */
	public boolean isFailed(int literal);

	/**
	 * Registers the given termination request with this solver. During each
	 * subsequent call of {@link #isSatisfiable()}, the method
	 * {@code TerminationRequest#terminateASAP()} of {@code request} will be
	 * periodically called by the solver and if it returns {@code true}, the
	 * method {@link #isSatisfiable()} should terminate as soon as possible
	 * (either with the result or by throwing a
	 * {@link SolverTerminatedException}).
	 *
	 * @param request
	 *            an object using which the solver can determine if it should be
	 *            terminated
	 */
	public void setTerminate(final TerminationRequest request);

	/**
	 * Registers the given listener with this solver to be notified about the
	 * learned clauses up to the given maximal length. During each subsequent
	 * call of {@link #isSatisfiable()}, the method
	 * {@link LearningListener#clauseLearned(fr.uga.pddl4j.examples.ipasir4j.ClauseReader)} of the listener will
	 * be called each time the solver finds a learned clause having at most
	 * {@code maxLength} literals. The object {@link ClauseReader} supplied in
	 * the argument of this method can be used to read this clause.
	 *
	 * @param maxLength
	 *            the maximal number of literals of the learned clauses reported
	 *            to {@code listener}
	 * @param listener
	 *            an object used for notifying about the learned clauses
	 */
	public void setLearningListener(int maxLength,
			final LearningListener listener);

}
