#!/bin/bash

XM=256m
VERSION=4.0.0

# Planner Data
statespace=fr.uga.pddl4j.planners.statespace.HSP
heuristic="MAX"
logLevel="INFO"
timeout="600"
weight="1.0"
domain_name="domain"
problem_name=""
complete_path=""

# path
#  The base path of benchmarks.
path="src/test/resources/benchmarks/pddl"

# ipc_folders
#  The array of ipc’s folders where the benchmark at the same index are.
#  The size of this array must be the same as "benchmarks" and "benchmarks_types".
ipc_folders=("ipc2000" "ipc2002" "ipc1998" "ipc1998")

# benchmarks
#  The array of benchmark’s folders we want to use.
#  The size of this array must be the same as "ipc_folders" and "benchmarks_types".
benchmarks=("blocks" "depots" "gripper" "logistics")

# benchmark_types
#  The array of types of problem (of the benchmark at the same index) we want to plan.
#  The size of this array must be the same as "ipc_folders" and "benchmarks".
benchmark_types=("strips-typed" "strips-automatic" "strips" "strip-round1")

# nb_pddl_to_do
#  Variable that represents the number of pddl problem to run in each beachmark
#  The default value: 20 represents the min max number of problem’s files
#  between the 4 default benchmarks folder.
nb_pddl_to_do=20

# index_folder
#  Variable used to navigate between folders
#  MUST NOT be changed
index_folder=0

# index_file
#  SHOULD NOT be changed unless the first problem file start at 0
#  Example :p000.pddl
index_file=1

# Configurate the output folders
function configuration() {
    echo "### Remove and create output folders"
    echo
    for (($((index_folder = 0)); $index_folder < ${#benchmarks[@]}; $((index_folder++)))); do
        echo "# ${benchmarks[index_folder]} output folder"
        rm -rf "${benchmarks[index_folder]}"
        mkdir "${benchmarks[index_folder]}"
    done
    echo
}

# Run all benchmarks and solve each problem using HSP planner
function run_benchmarks() {
    for (($((index_folder = 0)); $index_folder < ${#benchmarks[@]}; $((index_folder++)))); do
        # Create the right path to use for this loop
        complete_path="$path/${ipc_folders[index_folder]}/${benchmarks[index_folder]}/${benchmark_types[index_folder]}"

        # Execute 20 HSP Planifications
        echo "### Execute 20 HSP planifications on ${benchmarks[index_folder]}"
        echo
        for (($((index_file = 1)); $index_file <= $nb_pddl_to_do; $((index_file++)))); do
            # Find the correct name of the pddl problem (example sp001.pddl or p011.pddl or p111.pddl)
            if [ ${index_file} -lt 10 ]; then
                problem_name=p00${index_file}.pddl
            else
                if [ ${index_file} -lt 100 ]; then
                    problem_name=p0${index_file}.pddl
                else
                    problem_name=p${index_file}.pddl
                fi
            fi
            # Solve using HSP Planner
            solveHSP
        done
        echo
    done
}

# Run HSP Planner
function solveHSP() {
    echo "# Plan ${problem_name}"

    java \
        -Xms${XM} \
        -Xmx${XM} \
        -javaagent:build/libs/pddl4j-${VERSION}.jar \
        fr.uga.pddl4j.planners.statespace.HSP \
        ${complete_path}/${domain_name}.pddl \
        ${complete_path}/${problem_name} \
        --heuristic=${heuristic} \
        --log=${logLevel} \
        --timeout=${timeout} \
        --weight=${weight} \
        >${benchmarks[index_folder]}/${benchmarks[index_folder]}_${index_file}.txt
}
# MUST BE RUN FROM PDDL4J/
# bash ./src/test/resources/validators/testPlan.sh
configuration
run_benchmarks
exit 0
