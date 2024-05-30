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

import com.sun.jna.Pointer;

/**
 * An {@link IpasirSolver} backed by a native {@link JNAIpasir} library
 *
 * @author Yevgeny Kazakov
 */
public class IpasirNativeSolver implements IpasirSolver {

	private enum SolverState {
		INPUT, SAT, UNSAT
	}

	/**
	 * The library for handling native calls
	 */
	private final JNAIpasir nativeLibrary_;
	/**
	 * The pointer to the native solver
	 */
	private final Pointer solverPtr_;

	/**
	 * The state of the solver
	 */
	private SolverState state_;

	/**
	 * The exceptions of callback functions
	 */
	private Throwable callbackExcpetion_;

	/**
	 * Creates a new {@link IpasirSolver} backed by the given native
	 * {@link JNAIpasir} library
	 *
	 * @param nativeLibrary
	 *            the library for handling native calls
	 */
	public IpasirNativeSolver(JNAIpasir nativeLibrary) {
		this.nativeLibrary_ = nativeLibrary;
		this.solverPtr_ = nativeLibrary_.ipasir_init();
		this.state_ = SolverState.INPUT;
	}

	@Override
	public String getSignature() {
		return nativeLibrary_.ipasir_signature();
	}

	@Override
	public void add(int literalOrZero) {
		assert literalOrZero > Integer.MIN_VALUE;
		nativeLibrary_.ipasir_add(solverPtr_, literalOrZero);
		state_ = SolverState.INPUT;
	}

	@Override
	public void assume(int literal) {
		assert literal != 0 && literal > Integer.MIN_VALUE;
		nativeLibrary_.ipasir_assume(solverPtr_, literal);
		state_ = SolverState.INPUT;
	}

	@Override
	public boolean isSatisfiable() throws SolverTerminatedException {
		int solverResult = nativeLibrary_.ipasir_solve(solverPtr_);
		handleCallbackException();
		switch (solverResult) {
		case 10:
			state_ = SolverState.SAT;
			return true;
		case 20:
			state_ = SolverState.UNSAT;
			return false;
		case 0:
			throw new SolverTerminatedException();
		default:
			throw new RuntimeException(
					"Unknown solver result: " + solverResult);
		}
	}

	@Override
	public int val(int literal) {
		assert literal != 0 && literal > Integer.MIN_VALUE;
		if (state_ != SolverState.SAT) {
			throw illegalState();
		}
		return nativeLibrary_.ipasir_val(solverPtr_, literal);
	}

	@Override
	public boolean isFailed(int literal) {
		assert literal != 0 && literal > Integer.MIN_VALUE;
		if (state_ != SolverState.UNSAT) {
			throw illegalState();
		}
		return nativeLibrary_.ipasir_failed(solverPtr_, literal) > 0;
	}

    @Override
    public void setLearningListener(int maxLength, LearningListener listener) {

    }

    @Override
    public void setTerminate(TerminationRequest request) {

    }

    @Override
	public String toString() {
		return nativeLibrary_.ipasir_signature();
	}

    /*
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		nativeLibrary_.ipasir_release(solverPtr_);
	}
	*/

	private IllegalStateException illegalState() {
		switch (state_) {
		case INPUT:
			return new IllegalStateException(
					"Satisfiability of the formula was not checked yet!");
		case SAT:
			return new IllegalStateException("The formula is satisfiable!");
		case UNSAT:
			return new IllegalStateException("The formula is unsatisfiable!");
		default:
			return new IllegalStateException("Unknown error!");
		}
	}

	private void handleCallbackException() {
		if (callbackExcpetion_ != null) {
			throw new RuntimeException(callbackExcpetion_);
		}
	}

}
