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

package fr.uga.pddl4j.planners.sat.solvers;

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

import com.github.liveontologies.ipasir4j.IpasirNativeSolver;
import com.github.liveontologies.ipasir4j.IpasirSolver;
import com.github.liveontologies.ipasir4j.JNAIpasir;
import com.sun.jna.Native;

import java.io.Serializable;

/**
 * A wrapper for the PicoSAT solver.
 * To create a new instance of the solver, simply call <code>PicosatWrapper.createSolver()</code>
 */
public class PicosatWrapper implements Serializable {
    /**
     * The native library of the solver.
     */
    private static final JNAIpasir PICOSAT_JNA = Native.load("./lib/libpicosat.so",
            JNAIpasir.class);

    /**
     * Creates a new instance of the PicoSAT solver.
     * @return  a new instance of the PicoSAT solver
     */
    public static IpasirSolver createSolver() {
        return new IpasirNativeSolver(PICOSAT_JNA);
    }
}
