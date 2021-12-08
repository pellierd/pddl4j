.. _running_planners_from_command_line_chapter:

Running Planners from Command line
==================================

The planners currently implemented in the library are:
  #. **FF** (*FastForward*). It is based on Enforced Hill Climbing algorithm and A* search and the relaxed planning graph heuristic devised by J. Hoffmann.
  #. **HSP** (*Heuristic Search Planner*). It is based on A* search that can be combined with any goal cost heuristics functions developed in the library.
  #. **GSP** (*Generic Search Planner*). This planner is a generic state space planner. It is possible to choose the search strategy and the goal cost heuristic function.
  #. **TFD** (*Total-order Forward Decomposition*). It is based on dept first search search strategy and can only deal with total-order task decomposition.
  #. **PFD** (*Partial-order Forward Decomposition*). It is based on dept first search search strategy and can deal with partial-order task decomposition.

FF (FastForward)
----------------

The command line syntax to launch the planner is as follow:

.. code-block:: bash

   FF [-hV] [-l=<logLevel>] [-t=<timeout>] [-w=<weight>] <domain> <problem>

   Description:

   Solves a specified planning problem combining enforced hill climbing and A*
   search strategies using the the delete relaxation heuristic.

   Parameters:
      <domain>              The domain file.
      <problem>             The problem file.

  Options:
    -l, --log=<logLevel>      Set the level of trace of the planner: ALL, DEBUG,
                              INFO, ERROR, FATAL, OFF, TRACE (preset INFO).
    -t, --timeout=<timeout>   Set the time out of the planner in seconds (preset
                              600s).
    -w, --weight=<weight>     Set the weight of the heuristic (preset 1.0).
    -h, --help                Show this help message and exit.
    -V, --version             Print version information and exit.

Command line example:

.. code-block:: bash

    java -cp build/libs/pddl4j-4.0.0.jar fr.uga.pddl4j.planners.statespace.FF
           src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/domain.pdd
           src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/p01.pddl
           -t 1000

This command launches FF and allocates 1000 seconds to the search.

HSP (Heuristic Search Planner)
------------------------------

The command line syntax to launch the planner is as follow:

.. code-block:: bash

    HSP [-hV] [-e=<heuristic>] [-l=<logLevel>]
                              [-t=<timeout>] [-w=<weight>] <domain> <problem>
    Description:

    Solves a specified planning problem using A* search strategy.

    Parameters:
        <domain>              The domain file.
        <problem>             The problem file.

    Options:
        -l, --log=<logLevel>      Set the level of trace: ALL, DEBUG, INFO, ERROR,
                                    FATAL, OFF, TRACE (preset INFO).
        -t, --timeout=<timeout>   Set the time out of the planner in seconds (
                                    preset 600s).
        -w, --weight=<weight>     the weight of the heuristic (preset 1.0).
        -e, --heuristic=<heuristic>
                                  Set the heuristic : AJUSTED_SUM, AJUSTED_SUM2,
                                    AJUSTED_SUM2M, COMBO, MAX, FAST_FORWARD,
                                    SET_LEVEL, SUM, SUM_MUTEX (preset: FAST_FORWARD)
        -h, --help                Show this help message and exit.
        -V, --version             Print version information and exit.

Command line example:

.. code-block:: bash

   java -cp build/libs/pddl4j-4.0.0.jar fr.uga.pddl4j.planners.statespace.HSP
        src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/domain.pdd
           src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/p01.pddl
        -e MAX
        -w 1.2
        -t 600

This command launches HSP using MAX heuristic with a weight of 1.2 and allocates 600 seconds to the search.

GSP (Heuristic Search Planner)
------------------------------

The command line syntax to launch the planner is as follow:

.. code-block:: bash

    GSP [-hV] [-e=<heuristic>] [-l=<logLevel>]
                                 [-t=<timeout>] [-w=<weight>] [-s
                                 [=<strategies>...]]... <domain> <problem>

    Description:

    Solves a specified planning problem using a specified search strategy and heuristic.

     Parameters:
        <domain>              The domain file.
        <problem>             The problem file.

    Options:
        -l, --log=<logLevel>      Set the level of trace: ALL, DEBUG, INFO, ERROR,
                                    FATAL, OFF, TRACE (preset INFO).
        -t, --timeout=<timeout>   Set the time out of the planner in seconds (
                                    preset 600s).
        -w, --weight=<weight>     Set the weight of the heuristic (preset 1.0).
        -e, --heuristic=<heuristic>
                                  Set the heuristics: AJUSTED_SUM, AJUSTED_SUM2,
                                    AJUSTED_SUM2M, COMBO, MAX, FAST_FORWARD,
                                    SET_LEVEL, SUM, SUM_MUTEX (preset: FAST_FORWARD)
        -s, --search-strategies[=<strategies>...]
                                  Set the search strategies: ASTAR,
                                    ENFORCED_HILL_CLIMBING, BREADTH_FIRST,
                                    GREEDY_BEST_FIRST, DEPTH_FIRST, HILL_CLIMBING
                                    (preset: ASTAR)
        -h, --help                Show this help message and exit.
        -V, --version             Print version information and exit.

Command line example:

.. code-block:: bash

  java -cp build/libs/pddl4j-4.0.0.jar fr.uga.pddl4j.planners.statespace.GSP
        src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/domain.pddl
        src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/p01.pddl
        -s ENFORCED_HILL_CLIMBING ASTAR
        -e FAST_FORWARD
        -t 1000


This command launches GSP using first ENFORCED_HILL_CLIMBING search strategy and if the search fails then ASTAR
with the heuristic FAST_FORWARD and allocates 1000 seconds to the search.

TFD (Total-order Forward Decomposition)
---------------------------------------

The command line syntax to launch the planner is as follow:

.. code-block:: bash

    TFD [-hiV] [-l=<logLevel>] [-t=<timeout>] <domain> <problem>

    Description:

    Solves a specified planning problem using a Total-order Forward Decomposition strategy.

    Parameters:
        <domain>              The domain file.
        <problem>             The problem file.

    Options:
        -t, --timeout=<timeout>   Set the time out of the planner in seconds (preset 600s).
        -l, --log=<logLevel>      Set the level of trace of the planner: ALL, DEBUG,
                                    INFO, ERROR, FATAL, OFF, TRACE (preset INFO).
        -i, --interactive         Set the planner in interactive mode for debug
        -h, --help                Show this help message and exit.
        -V, --version             Print version information and exit.

Command line example:

.. code-block:: bash

  java -cp build/libs/pddl4j-4.0.0.jar fr.uga.pddl4j.planners.htn.stn.TFD
           src/test/resources/benchmarks/hddl/ipc2020/barman/domain.hddl
           src/test/resources/benchmarks/hddl/ipc2020/barman/p01.hddl
           -t 600


This command launches TFD and allocates 600 seconds to the search.

.. note::
    It is possible to use the iterative (-i) mode to debug and print step by step the task decomposition.

PFD (Partial-order Forward Decomposition)
-----------------------------------------

The command line syntax to launch the planner is as follow:

.. code-block:: bash

    TFD [-hiV] [-l=<logLevel>] [-t=<timeout>] <domain> <problem>

    Description:

    Solves a specified planning problem using a Partial-order Forward Decomposition strategy.

    Parameters:
        <domain>              The domain file.
        <problem>             The problem file.

    Options:
        -t, --timeout=<timeout>   Set the time out of the planner in seconds (preset 600s).
        -l, --log=<logLevel>      Set the level of trace of the planner: ALL, DEBUG,
                                    INFO, ERROR, FATAL, OFF, TRACE (preset INFO).
        -i, --interactive         Set the planner in interactive mode for debug
        -h, --help                Show this help message and exit.
        -V, --version             Print version information and exit.

Command line example:

.. code-block:: bash

  java -cp build/libs/pddl4j-4.0.0.jar fr.uga.pddl4j.planners.htn.stn.PFD
           src/test/resources/benchmarks/hddl/ipc2020/barman/domain.hddl
           src/test/resources/benchmarks/hddl/ipc2020/barman/p01.hddl
           -t 600


This command launches PFD and allocates 600 seconds to the search.

