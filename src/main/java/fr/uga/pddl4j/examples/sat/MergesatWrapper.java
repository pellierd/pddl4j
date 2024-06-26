package fr.uga.pddl4j.examples.sat;

import com.github.liveontologies.ipasir4j.IpasirNativeSolver;
import com.github.liveontologies.ipasir4j.IpasirSolver;
import com.github.liveontologies.ipasir4j.JNAIpasir;
import com.sun.jna.Native;

public class MergesatWrapper {
    private final static JNAIpasir MERGESAT_JNA = Native.load("./lib/libmergesat.so",
        JNAIpasir.class);

    public static IpasirSolver createSolver() {
        return new IpasirNativeSolver(MERGESAT_JNA);
    }
}
