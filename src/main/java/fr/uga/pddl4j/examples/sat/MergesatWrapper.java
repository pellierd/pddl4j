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

package fr.uga.pddl4j.examples.sat;

import com.github.liveontologies.ipasir4j.IpasirNativeSolver;
import com.github.liveontologies.ipasir4j.IpasirSolver;
import com.github.liveontologies.ipasir4j.JNAIpasir;
import com.sun.jna.Native;

/**
 * A wrapper for the MergeSat solver.
 * To create a new instance of the solver, simply call <code>MergesatWrapper.createSolver()</code>.
 */
public class MergesatWrapper {
    /**
     * The native library of the solver.
     */
    private static final JNAIpasir MERGESAT_JNA = Native.load("./lib/libmergesat.so",
        JNAIpasir.class);

    /**
     * Creates a new instance of the MergeSat solver.
     * @return  a new instance of the MergeSat solver
     */
    public static IpasirSolver createSolver() {
        return new IpasirNativeSolver(MERGESAT_JNA);
    }
}
