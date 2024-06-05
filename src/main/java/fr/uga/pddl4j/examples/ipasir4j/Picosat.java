package fr.uga.pddl4j.examples.ipasir4j;

/*-
 * #%L
 * Java Bindings for the Minisat solver
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

import com.sun.jna.Native;
import fr.uga.pddl4j.examples.ipasir4j.IpasirNativeSolver;
import fr.uga.pddl4j.examples.ipasir4j.IpasirSolver;
import fr.uga.pddl4j.examples.ipasir4j.JNAIpasir;

public class Picosat {

	private final static JNAIpasir PICOSAT_JNA = Native.load("./lib/libpicosat.so",
			JNAIpasir.class);

	public static IpasirSolver createSolver() {
		return new IpasirNativeSolver(PICOSAT_JNA);
	}

}
