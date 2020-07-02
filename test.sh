

seq -w 7 | parallel -k -j 1 java -server -Xms16192m -Xmx16192m -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.pfd.PFDPlanner -d src/test/resources/benchmarks/ipc2020/miconic/domains/miconic.hddl -p src/test/resources/benchmarks/ipc2020/miconic/problems/p0{}.hddl -t 600 -l 9

seq -w 20 | parallel -k -j 1 java -server -Xms16192m -Xmx16192m -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.pfd.PFDPlanner -d src/test/resources/benchmarks/ipc2020/rover/domains/rover.hddl -p src/test/resources/benchmarks/ipc2020/rover/problems/p{}.hddl -t 600 -l 9
`
seq -w 23 | parallel -k -j 1 java -server -Xms16192m -Xmx16192m -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.pfd.PFDPlanner -d src/test/resources/benchmarks/ipc2020/satellite/domains/satellite.hddl -p src/test/resources/benchmarks/ipc2020/satellite/problems/p{}.hddl -t 600 -l 9

seq -w 7 | parallel -k -j 1 java -server -Xms16192m -Xmx16192m -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.pfd.PFDPlanner -d src/test/resources/benchmarks/ipc2020/smartphone/domains/smartphone.hddl -p src/test/resources/benchmarks/ipc2020/smartphone/problems/p0{}.hddl -t 600 -l 9

seq -w 30 | parallel -k -j 1 java -server -Xms16192m -Xmx16192m -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.pfd.PFDPlanner -d src/test/resources/benchmarks/ipc2020/transport/domains/transport.hddl -p src/test/resources/benchmarks/ipc2020/transport/problems/p{}.hddl -t 600 -l 9

seq -w 5 | parallel -k -j 1 java -server -Xms16192m -Xmx16192m -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.pfd.PFDPlanner -d src/test/resources/benchmarks/ipc2020/zenotravel/domains/zenotravel.hddl -p src/test/resources/benchmarks/ipc2020/zenotravel/problems/p0{}.hddl -t 600 -l 9

java -server -Xms16192m -Xmx16192m -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.pfd.PFDPlanner -d src/test/resources/benchmarks/ipc2020/feature-tests/test1/domains/empty-methods-empty-plan.hddl -p src/test/resources/benchmarks/ipc2020/feature-tests/test1/problems/empty-methods-empty-plan.hddl -t 600 -l 9

java -server -Xms16192m -Xmx16192m -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.pfd.PFDPlanner -d src/test/resources/benchmarks/ipc2020/feature-tests/test2/domains/forall.hddl -p src/test/resources/benchmarks/ipc2020/feature-tests/test2/problems/forall.hddl -t 600 -l 9

java -server -Xms16192m -Xmx16192m -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.pfd.PFDPlanner -d src/test/resources/benchmarks/ipc2020/feature-tests/test3/domains/only-primitive.hddl -p src/test/resources/benchmarks/ipc2020/feature-tests/test3/problems/only-primitive.hddl -t 600 -l 9

java -server -Xms16192m -Xmx16192m -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.pfd.PFDPlanner -d src/test/resources/benchmarks/ipc2020/feature-tests/test4/domains/sortof.hddl -p src/test/resources/benchmarks/ipc2020/feature-tests/test4/problems/sortof.hddl -t 600 -l 9

java -server -Xms16192m -Xmx16192m -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.pfd.PFDPlanner -d src/test/resources/benchmarks/ipc2020/feature-tests/test5/domains/constants.hddl -p src/test/resources/benchmarks/ipc2020/feature-tests/test5/problems/constants.hddl -t 600 -l 9

java -server -Xms16192m -Xmx16192m -cp build/libs/pddl4j-3.8.3.jar fr.uga.pddl4j.planners.htn.stn.pfd.PFDPlanner -d src/test/resources/benchmarks/ipc2020/feature-tests/test6/domains/synonymes.hddl -p src/test/resources/benchmarks/ipc2020/feature-tests/test6/problems/synonymes.hddl -t 600 -l 9

