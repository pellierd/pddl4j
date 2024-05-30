package fr.uga.pddl4j.examples.ipasir4j;

/*-
 * #%L
 * JNA interfaces for the IPASIR C header
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

import com.sun.jna.Library;
import com.sun.jna.Pointer;

/**
 * A JNA interface mapping for the Reentrant Incremental Sat solver API
 * (reverse: IPASIR). The method names and documentation is converted as close
 * as possible from the IPASIR C header file {@code ipasir.h}.
 *
 * @see <a href="https://github.com/biotomas/ipasir">biotomas/ipasir</a>
 *
 * @author Yevgeny Kazakov
 */
public interface JNAIpasir extends Library {

	/**
	 * @return the name and the version of the incremental SAT solving library.
	 */
	public String ipasir_signature();

	/**
	 * Construct a new solver and return a pointer to it. Use the returned
	 * pointer as the first parameter in each of the following methods.
	 *
	 * Required state: N/A State after: INPUT.
	 *
	 * @return the pointer to a new solver
	 */
	public Pointer ipasir_init();

	/**
	 * Release the solver, i.e., all its resources and allocated memory
	 * (destructor). The solver pointer cannot be used for any purposes after
	 * this call.
	 *
	 * Required state: {@code INPUT} or {@code SAT} or {@code UNSAT}. State
	 * after: undefined.
	 *
	 * @param solver
	 *            the solver to be released
	 */
	public void ipasir_release(Pointer solver);

	/**
	 * Add the given literal into the currently added clause or finalize the
	 * clause with a {@code 0}. Clauses added this way cannot be removed. The
	 * addition of removable clauses can be simulated using activation literals
	 * and assumptions.
	 *
	 * Required state: {@code INPUT} or {@code SAT} or {@code UNSAT}. State
	 * after: {@code INPUT}.
	 *
	 * Literals are encoded as (non-zero) integers as in the DIMACS formats.
	 * They have to be smaller or equal to {@link Integer#MAX_VALUE} and
	 * strictly larger than {@link Integer#MIN_VALUE} (to avoid negation
	 * overflow). This applies to all the literal arguments in API methods.
	 *
	 * @param solver
	 *            the solver for which to perform the operation
	 * @param lit_or_zero
	 *            if {@code 0} adds the current clause to the solver and creates
	 *            a new clause; otherwise adds the corresponding literal to the
	 *            current clause
	 */
	public void ipasir_add(Pointer solver, int lit_or_zero);

	/**
	 * Add an assumption for the next SAT search (the next call of
	 * {@link #ipasir_solve}). After calling {@link #ipasir_solve} all the
	 * previously added assumptions are cleared.
	 *
	 * Required state: {@code INPUT} or {@code SAT} or {@code UNSAT}. State
	 * after: {@code INPUT}.
	 *
	 * @param solver
	 *            the solver for which to add the assumption
	 * @param lit
	 *            the literal that should be added to the solver (as a clause
	 *            consisting of this single literal)
	 */
	public void ipasir_assume(Pointer solver, int lit);

	/**
	 * Solve the formula with specified clauses under the specified assumptions.
	 * If the formula is satisfiable the method returns {@code 10} and the state
	 * of the solver is changed to SAT. If the formula is unsatisfiable the
	 * method returns {@code 20} and the state of the solver is changed to
	 * UNSAT. If the search is interrupted (see {@link #ipasir_set_terminate})
	 * the method returns {@code 0} and the state of the solver remains
	 * {@code INPUT}. This method can be called in any defined state of the
	 * solver.
	 *
	 * Required state: {@code INPUT} or {@code SAT} or {@code UNSAT}. State
	 * after: {@code INPUT} or {@code SAT} or {@code UNSAT}.
	 *
	 * @param solver
	 *            the solver for which the formula consisting of the added
	 *            clauses must be solved under the added assumptions
	 * @return {@code 10} if the formula is satisfiable and {@code 20} if the
	 *         formula is not satisfiable.
	 *
	 * @see #ipasir_add(Pointer, int)
	 * @see #ipasir_assume(Pointer, int)
	 *
	 */
	public int ipasir_solve(Pointer solver);

	/**
	 * Get the truth value of the given literal in the found satisfying
	 * assignment. Return {@code lit} if {@code True}, {@code -lit} if
	 * {@code False}, and {@code 0} if not important. This method can only be
	 * used if {@link #ipasir_solve(Pointer)} has returned {@code 10} and no
	 * {@link #ipasir_add(Pointer, int)} nor
	 * {@link #ipasir_assume(Pointer, int)} has been called since then, i.e.,
	 * the state of the solver is SAT.
	 *
	 * Required state: SAT State after: SAT
	 *
	 * @param solver
	 *            the solver whose assignment should be used
	 * @param lit
	 *            the literal for which to retrieve the truth value
	 * @return the given value of literal if it is {@code True} under the found
	 *         assignment, its negation if it is {@code False}, and {@code 0} if
	 *         both assignments of the literal (with {@code True} or
	 *         {@code False}) satisfy the formula of the solver
	 *
	 * @see #ipasir_solve(Pointer)
	 * @see #ipasir_add(Pointer, int)
	 * @see #ipasir_assume(Pointer, int)
	 */
	public int ipasir_val(Pointer solver, int lit);

	/**
	 * Check if the given assumption literal was used to prove the
	 * unsatisfiability of the formula under the assumptions used for the last
	 * SAT search. Return {@code 1} if so, {@code 0} otherwise. This method can
	 * only be used if {@link #ipasir_solve(Pointer)} has returned {@code 20}
	 * and no {@link #ipasir_add(Pointer, int)} or
	 * {@link #ipasir_assume(Pointer, int)} has been called since then, i.e.,
	 * the state of the solver is {@code UNSAT}.
	 *
	 * Required state: {@code UNSAT} State after: {@code UNSAT}
	 *
	 * @param solver
	 *            the solver for which the assumption was made
	 * @param lit
	 *            the literal that was
	 *
	 * @return {@code 1} if the assumption of the given literal was used to
	 *         prove unsatisfiability of the formula on the solver and {@code 0}
	 *         otherwise
	 *
	 * @see #ipasir_solve(Pointer)
	 * @see #ipasir_assume(Pointer, int)
	 * @see #ipasir_add(Pointer, int)
	 */
	public int ipasir_failed(Pointer solver, int lit);

	/**
	 * Set a callback used to indicate a termination requirement to the solver.
	 * The solver will periodically call the function
	 * {@link JNATerminateCallback#invoke(Pointer)} of this callback and check
	 * its return value during the search. The {@link #ipasir_set_terminate}
	 * method can be called in any state of the solver, the state remains
	 * unchanged after the call. The callback function
	 * {@link JNATerminateCallback#invoke(Pointer)} returns a non-zero value if
	 * the solver should terminate. The solver calls the callback function with
	 * the {@link Pointer} state passed in the 2nd parameter of the
	 * {@link #ipasir_set_terminate} function.
	 *
	 * Required state: {@code INPUT} or {@code SAT} or {@code UNSAT}. State
	 * after: {@code INPUT} or {@code SAT} or {@code UNSAT}.
	 *
	 * @param solver
	 *            the solver to which the callback shall be added
	 * @param state
	 *            a pointer that shall be passed as the argument of the function
	 *            {@link JNATerminateCallback#invoke(Pointer)} of callback
	 * @param callback
	 *            a callback that shall be called by the solver to check if the
	 *            solver should terminate: if the function
	 *            {@link JNATerminateCallback#invoke(Pointer)} called on the
	 *            given state pointer returns {@code true}, the solver should
	 *            terminate as soon as possible.
	 */
	public void ipasir_set_terminate(Pointer solver, Pointer state,
			JNATerminateCallback callback);

	/**
	 * Set a callback used to extract learned clauses up to a given length from
	 * the solver. The solver will call the function
	 * {@link JNALearnCallback#invoke(Pointer, Pointer)} of this callback for
	 * each learned clause that satisfies the maximum length (literal count)
	 * condition. The {@link #ipasir_set_learn} method can be called in any
	 * state of the solver, the state remains unchanged after the call. The
	 * solver calls the callback function with the pointer {@code state} passed
	 * in 2nd parameter of the {@link #ipasir_set_learn} method (not to be
	 * confused with the state of the solver!), and a pointer {@code clause}
	 * that corresponds to a {@code 0} terminated integer array containing the
	 * learned clause. The solver can change the data at the memory location
	 * that {@code clause} points to after the function call.
	 *
	 * Required state: {@code INPUT} or {@code SAT} or {@code UNSAT} State
	 * after: {@code INPUT} or {@code SAT} or {@code UNSAT}
	 *
	 * @param solver
	 *            the solver to which to add the callback function
	 * @param state
	 *            a pointer that shall be passed by the solver as the first
	 *            argument of the callback function
	 * @param max_length
	 *            the maximal length of the learned clauses for which the
	 *            callback function shall be called
	 * @param callback
	 *            an object whose callback function shall be called on the given
	 *            state pointer (1st parameter) and each learned clause whose
	 *            length does not exceed {@code max_length} (2nd parameter)
	 */
	public void ipasir_set_learn(Pointer solver, Pointer state, int max_length,
			JNALearnCallback callback);

}
