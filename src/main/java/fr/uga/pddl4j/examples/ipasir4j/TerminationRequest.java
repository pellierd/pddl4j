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
 * An object using which one can request the termination of an
 * {@link IpasirSolver}.
 *
 * @author Yevgeny Kazakov
 *
 * @see IpasirSolver#setTerminate(TerminationRequest)
 */
public interface TerminationRequest {

	/**
	 * @return {@code true} if the solver must terminate as soon as possible or
	 *         {@code false} otherwise. The solver can terminate by returning a
	 *         correct result or throwing a {@link SolverTerminatedException}.
	 */
	boolean terminateASAP();

}
