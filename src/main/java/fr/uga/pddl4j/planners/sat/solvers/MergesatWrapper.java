package fr.uga.pddl4j.planners.sat.solvers;

import com.github.liveontologies.ipasir4j.IpasirNativeSolver;
import com.github.liveontologies.ipasir4j.IpasirSolver;
import com.github.liveontologies.ipasir4j.JNAIpasir;
import com.sun.jna.Native;

import java.io.Serializable;

public class MergesatWrapper implements Serializable {
	private final static JNAIpasir MERGESAT_JNA = Native.load("./lib/libmergesat.so",
			JNAIpasir.class);

	public static IpasirSolver createSolver() {
		return new IpasirNativeSolver(MERGESAT_JNA);
	}
}
