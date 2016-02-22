#!/bin/bash


for ((i=1 ; i<17 ; i++))
    do
    if [ $i -lt 10 ]
        then ./gradlew run -PArgs="-o","pddl/blocksworld/domain.pddl","-f","pddl/blocksworld/p0$i.pddl" -x test -PnoCheckstyle
    else
       ./gradlew run -PArgs="-o","pddl/blocksworld/domain.pddl","-f","pddl/blocksworld/p$i.pddl" -x test -PnoCheckstyle
    fi
done

exit 0
