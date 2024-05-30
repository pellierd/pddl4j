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

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

/**
 * A callback to control termination of a SAT solver.
 *
 * @author Yevgeny Kazakov
 *
 * @see JNAIpasir#ipasir_set_terminate(Pointer, Pointer, JNATerminateCallback)
 */
public interface JNATerminateCallback extends Callback {

	/**
	 * @param state
	 *            a pointer passed upon the registration of this callback with
	 *            the solver
	 * @return a positive value if the solver should terminate as soon as
	 *         possible
	 */
	int invoke(Pointer state);

}
