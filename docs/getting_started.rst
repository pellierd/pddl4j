.. _getting_started_chapter:

Getting Started
===============

This section explains how to download PDDL4J from GitHub, create an executable of the library and run the Fast Forward
planner implemented in the library.

Prerequisites
-------------

We assume that :
  * `Gradle <https://gradle.org/>`_ is installed on your computer. For more information see the dedicated page `How to install Gradle <https://gradle.org/install/>`_.
  * `Java JDK <https://adoptopenjdk.net/>`_ version 8 or higher is installed. To check, run :

  .. code-block:: bash

    java -version


Getting PDDL4J
------------------

To get PDDL4J just checkout the source from git repository:

.. code-block:: bash

    git clone https://github.com/pellierd/pddl4j.git
    cd pddl4j


Creating the executable jar
---------------------------

To build PDDL4J and creating the executable jar use the following command line:

.. code-block:: bash

  ./gradlew jar

This command build a single jar of the PDDL4J library containing all the dependency libraries used by PDDL4J. The jar
generated is located in the directory ``build/libs/pddl4j-X.X.jar`` where X.X is the version of PDDL4J.


Example: Running Fast Forward planner
------------------------------------

Several planners are implemented in PDDL4J (see section :ref:`running_planners_from_command_line_chapter`.) to have the full list of planners implemented in the library and have the command lines to run them.
As sample, find below the command line to launch Fast Forward planner implemented in the library.

.. code-block:: bash

  $ java -cp build/libs/pddl4j-4.0.jar fr.uga.pddl4j.planners.statespace.FF \
     src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/domain.pddl \
     src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/p01.pddl

This command run the planner FF on the domain logics and the problem 1.

The output produces by the planner is as follow:

.. code-block:: text

  parsing domain file "domain.pddl" done successfully
  parsing problem file "p01.pddl" done successfully

  problem instantiation done successfully (140 actions, 56 fluents)
  * starting enforced hill climbing
  * enforced hill climbing succeeded

  found plan as follows:

  00: (     load-truck obj23 tru2 pos2) [0]
  01: (     load-truck obj21 tru2 pos2) [0]
  02: (     load-truck obj13 tru1 pos1) [0]
  03: (     load-truck obj11 tru1 pos1) [0]
  04: (drive-truck tru2 pos2 apt2 cit2) [0]
  05: (   unload-truck obj23 tru2 apt2) [0]
  06: (  load-airplane obj23 apn1 apt2) [0]
  07: (   unload-truck obj21 tru2 apt2) [0]
  08: (  load-airplane obj21 apn1 apt2) [0]
  09: (    fly-airplane apn1 apt2 apt1) [0]
  10: (unload-airplane obj23 apn1 apt1) [0]
  11: (unload-airplane obj21 apn1 apt1) [0]
  12: (drive-truck tru1 pos1 apt1 cit1) [0]
  13: (     load-truck obj23 tru1 apt1) [0]
  14: (     load-truck obj21 tru1 apt1) [0]
  15: (   unload-truck obj13 tru1 apt1) [0]
  16: (   unload-truck obj11 tru1 apt1) [0]
  17: (drive-truck tru1 apt1 pos1 cit1) [0]
  18: (   unload-truck obj23 tru1 pos1) [0]
  19: (   unload-truck obj21 tru1 pos1) [0]

  time spent:       0,02 seconds parsing
                    0,04 seconds encoding
                    0,02 seconds searching
                    0,07 seconds total time

  memory used:      0,00 MBytes for problem representation
                    0,00 MBytes for searching
                    0,00 MBytes total

Most of the domains and the problems from IPC (International Planning Competition) are available for testing in the
directory ``src/test/resources/benchmarks/``. They are classified by year and by competition track.
