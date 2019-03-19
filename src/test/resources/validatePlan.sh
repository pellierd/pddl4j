#!/bin/bash
VERSION=3.8.3
FILES=""
TOTAL_FILES=0
TOTAL_VALIDATED_PLANS=0
VALIDATE_BIN=validate

#Tests path definitions for IPC1
TEST[0]="../../../benchmarks/ipc1/gripper/"
TEST[1]="../../../benchmarks/ipc1/logistics/"
TEST[2]="../../../benchmarks/ipc1/movie/"
TEST[3]="../../../benchmarks/ipc1/mprime/"
TEST[4]="../../../benchmarks/ipc1/mystery/"

#Tests path definitions for IPC2
TEST[5]="../../../benchmarks/ipc2/blocksworld/"
TEST[6]="../../../benchmarks/ipc2/elevator/"
TEST[7]="../../../benchmarks/ipc2/freecell/"
TEST[8]="../../../benchmarks/ipc2/schedule/"

#Tests path definitions for IPC3
TEST[9]="../../../benchmarks/ipc3/depots/"
TEST[10]="../../../benchmarks/ipc3/driverlog/"
TEST[11]="../../../benchmarks/ipc3/rover/"
TEST[12]="../../../benchmarks/ipc3/satellite/"
TEST[13]="../../../benchmarks/ipc3/zenotravel/"

#Tests path definitions for IPC4
TEST[14]="../../../benchmarks/ipc4/airport/"
TEST[15]="../../../benchmarks/ipc4/optical-telegraph/"
TEST[16]="../../../benchmarks/ipc4/philosophers/"
TEST[17]="../../../benchmarks/ipc4/pipesworld/"
TEST[18]="../../../benchmarks/ipc4/psr/"

#Tests path definitions for IPC5
TEST[19]="../../../benchmarks/ipc5/openstacks/"
TEST[20]="../../../benchmarks/ipc5/pathways/"
TEST[21]="../../../benchmarks/ipc5/storage/"
TEST[22]="../../../benchmarks/ipc5/tpp/"
TEST[23]="../../../benchmarks/ipc5/truck/"

#Tests path definitions for IPC6
TEST[24]="../../../benchmarks/ipc6/pegsol/"
TEST[25]="../../../benchmarks/ipc6/sokoban/"
TEST[26]="../../../benchmarks/ipc6/trasnport/"

#Tests path definitions for IPC7
TEST[27]="../../../benchmarks/ipc7/barman/"
TEST[28]="../../../benchmarks/ipc7/nomystery/"
TEST[29]="../../../benchmarks/ipc7/parking/"

#Tests path definitions for IPC8
TEST[30]="../../../benchmarks/ipc8/childsnack/"
TEST[31]="../../../benchmarks/ipc8/hiking/"
TEST[32]="../../../benchmarks/ipc8/thoughtful/"

# test path definitions for newTests
TEST[33]="../../../benchmarks/newTests/Depots/"
TEST[34]="../../../benchmarks/newTests/DriverLog/"
TEST[35]="../../../benchmarks/newTests/Freecell/"
TEST[36]="../../../benchmarks/newTests/Rover/"
TEST[37]="../../../benchmarks/newTests/Satellite/"
TEST[38]="../../../benchmarks/newTests/Zenotravel/"


#Loop over all test paths
for test in ${TEST[@]} ;do
    echo "################################################################"
    echo "${test}"
    echo "################################################################"
    echo ""
    FILES=$(find ${test} -name "*.val" -type f)
    NB_FILES=0
    NB_VALIDATED_FILE=0
    ONE_DOMAIN_FILE=0
    if [ -f "${test}/domain.pddl" ] ;then
        ONE_DOMAIN_FILE=1
    fi
    #Loop over all VAL files in path
    for f in $(echo ${FILES} | tr " " "\n"); do
        name=$(echo ${f} | cut -d \/ -f 7)
        name=$(echo ${name} | cut -d . -f 1)
        if [ ${ONE_DOMAIN_FILE} -eq 1 ] ;then
            ./${VALIDATE_BIN} -s ${test}/domain.pddl ${test}/${name}.pddl ${f}
        else
            ./${VALIDATE_BIN} -s ${test}/${name}-domain.pddl ${test}/${name}.pddl ${f}
        fi
        if [ $? -eq 0 ] ;then
            ((NB_VALIDATED_FILE+=1))
        fi
        ((NB_FILES+=1))
    done
    ((TOTAL_FILES+=NB_FILES))
    ((TOTAL_VALIDATED_PLANS+=NB_VALIDATED_FILE))
    echo ${NB_FILES} "val output plan(s) found."
    echo ${NB_VALIDATED_FILE} "plan(s) validated."
    echo ""
done

echo ${TOTAL_FILES} "Total val output plan(s) found."
echo ${TOTAL_VALIDATED_PLANS} "validated plan(s)."

NB_ERROR=$((TOTAL_FILES - TOTAL_VALIDATED_PLANS))

if [ ${NB_ERROR} -gt 0 ] ;then
    echo ${NB_ERROR} "plan errors found"
else
    echo "Congratulation! All your plan are valid."
fi

exit ${NB_ERROR}
