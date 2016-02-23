#!/bin/bash

VERSION=3.0.7-SNAPSHOT
PROBLEM=""
TYPE=""

echo "### Execute 16 HSP planifications on blocks world problems"
TYPE=blocksworld
for ((i=1 ; i<27 ; i++))
    do
    if [ ${i} -lt 10 ]
        then PROBLEM=p0${i}.pddl
    else
        PROBLEM=p${i}.pddl
    fi
    java -javaagent:build/libs/pddl4j-${VERSION}.jar -server -Xms2048m -Xmx2048m fr.uga.pddl4j.planners.hsp.HSP -o pddl/${TYPE}/domain.pddl -f pddl/${TYPE}/${PROBLEM}
done

echo "### Execute 4 HSP planifications on depots problems"
TYPE=depots
for ((i=1 ; i<5 ; i++))
    do
     if [ ${i} -lt 10 ]
        then PROBLEM=p0${i}.pddl
    else
        PROBLEM=p${i}.pddl
    fi
    java -javaagent:build/libs/pddl4j-${VERSION}.jar -server -Xms2048m -Xmx2048m fr.uga.pddl4j.planners.hsp.HSP -o pddl/${TYPE}/domain.pddl -f pddl/${TYPE}/${PROBLEM}
done

echo "### Execute 5 HSP planifications on gripper problems"
TYPE=gripper
for ((i=1 ; i<6 ; i++))
    do
     if [ ${i} -lt 10 ]
        then PROBLEM=p0${i}.pddl
    else
        PROBLEM=p${i}.pddl
    fi
    java -javaagent:build/libs/pddl4j-${VERSION}.jar -server -Xms2048m -Xmx2048m fr.uga.pddl4j.planners.hsp.HSP -o pddl/${TYPE}/domain.pddl -f pddl/${TYPE}/${PROBLEM}
done

echo "### Execute 11 HSP planifications on logistics problems"
TYPE=logistics
for ((i=1 ; i<12 ; i++))
    do
     if [ ${i} -lt 10 ]
        then PROBLEM=p0${i}.pddl
    else
        PROBLEM=p${i}.pddl
    fi
    java -javaagent:build/libs/pddl4j-${VERSION}.jar -server -Xms2048m -Xmx2048m fr.uga.pddl4j.planners.hsp.HSP -o pddl/${TYPE}/domain.pddl -f pddl/${TYPE}/${PROBLEM}
done


exit 0
