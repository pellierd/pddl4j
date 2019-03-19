#!/bin/bash

pause(){
    read -p "Press [Enter] key to continue..." fackEnterKey
}

build(){
	./gradlew jar
    pause
}

solveHSP(){
	read -p "Enter domain file [path to the file]: " domainFile
	read -p "Enter problem file [path to the file]: " problemFile
	read -p "Timeout [int]: " timeOut

	show_heuristic

	read -p "Choose heuristic [0 - 8]: " heuristic

	java -javaagent:build/libs/pddl4j-3.8.3.jar -server -Xms2048m -Xmx2048m fr.uga.pddl4j.planners.statespace.StateSpacePlannerFactory -p 0 -o $domainFile -f $problemFile -t $timeOut -u $heuristic

    pause
}

solveFF(){
	read -p "Enter domain file [path to the file]: " domainFile
	read -p "Enter problem file [path to the file]: " problemFile
	read -p "Timeout [int]: " timeOut

	show_heuristic

	read -p "Choose heuristic [0 - 8]: " heuristic

	java -javaagent:build/libs/pddl4j-3.8.3.jar -server -Xms2048m -Xmx2048m fr.uga.pddl4j.planners.statespace.StateSpacePlannerFactory -p 1 -o $domainFile -f $problemFile -t $timeOut -u $heuristic

    pause
}

about() {
	show_title
	echo ""
	echo "PDDL4J is an open source library under LGPL license."
	echo ""
	echo "The purpose of PDDL4J is to facilitate the development of JAVA tools for Automated Planning based on PDDL language (Planning Domain Description Language). Automated planning and scheduling, in the relevant literature often denoted as simply planning, is a branch of artificial intelligence that concerns  the realization of strategies or action sequences, typically for execution by intelligent agents, autonomous robots and unmanned vehicles."
	echo ""
	echo "PDDL was originally developed by Drew McDermott and the 1998 planning competition committee. It was inspired by the need to encourage the empirical comparison of planning systems and the exchange of planning benchmarks within the community. Its development improved the communication of research results and triggered an explosion in performance, expressivity and robustness of planning systems."
	echo ""
	echo "PDDL has become a de facto standard language for describing planning domains, not only for the competition but more widely, as it offers an opportunity to carry out empirical evaluation of planning systems on a growing collection of generally adopted standard benchmark domains. The emergence of a language standard will have an impact on the entire field, influencing what is seen as central and what peripheral in the development of planning systems."
    pause
}

clean() {
	./gradlew clean
	pause
}

show_title() {
	clear
	echo " _____ ____  ____  __    ___    __ "
	echo "|  _  |    \|    \|  |  | | |__|  |"
	echo "|   __|  |  |  |  |  |__|_  |  |  |"
	echo "|__|  |____/|____/|_____| |_|_____|"
}

show_status() {
	echo "|"
    echo "| PDDL4J `awk '/^version/' build.gradle`"
    if [ -d build/libs ]; then
		echo -e "| PDDL4J status [\e[92mBuilt\e[39m]"
		echo "|"
		echo " ----------"
	else
		echo -e "| PDDL4J status [\e[91mNot built\e[39m]"
		echo "|"
		echo " ----------"
	fi
}

show_menus_l() {
    echo "| 0. Build jar"
    echo "| ..."
    echo "| 4. About"
    echo "| 5. Exit"
    echo " ----------"
}

read_options_l(){
    local choice
    read -p "Enter choice [0 - 5] : " choice
    case $choice in
        0) build ;;
		4) about ;;
        5) exit 0;;
        *) echo "Error..." && sleep 1
    esac
}

show_menus() {
    echo "| 0. Build jar"
    echo "| 1. Solve with HSP"
    echo "| 2. Solve with FF"
    echo "| 3. Clean"
    echo "| 4. About"
    echo "| 5. Exit"
    echo " ----------"
}

show_heuristic() {
	echo "0. ff heuristic"
	echo "1. sum heuristic"
	echo "2. sum mutex heuristic"
	echo "3. djusted sum heuristic"
	echo "4. adjusted sum 2 heuristic"
	echo "5. adjusted sum 2M heuristic"
	echo "6. combo heuristic"
	echo "7. max heuristic"
	echo "8. set-level heuristic"
}

read_options(){
    local choice
    read -p "Enter choice [0 - 5] : " choice
    case $choice in
        0) build ;;
        1) solveHSP ;;
        2) solveFF ;;
		3) clean ;;
		4) about ;;
        5) exit 0;;
        *) echo "Error..." && sleep 1
    esac
}

# ----------------------------------------------
# Trap CTRL+C, CTRL+Z and quit singles
# ----------------------------------------------
trap '' SIGINT SIGQUIT SIGTSTP

# -----------------------------------
# Main logic - infinite loop
# ------------------------------------
while true
do
	show_title
	show_status
	if [ -d build/libs ]; then
		show_menus
		read_options
	else
		show_menus_l
		read_options_l
	fi
done
