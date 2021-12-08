.. _writing_your_own_planner_chapter:

Writing your own Planner
========================

The objective of this tutorial is to design a simple planner based on A* search.

  #. Create a simple Java project with PDDL4J
  #. Create the main class of your planner
  #. Get the planner arguments from the command line
  #. Searching for a solution plan
  #. Write your own A* search strategy
  #. Make your planner configurable by programming

Pre-requisite Installations
---------------------------

For this tutorial you need:
  *  `Java JDK <https://adoptopenjdk.net/>`_ version 8 or higher is installed.
  * A text editor such as `Sublime <https://www.sublimetext.com>`_ or `Atom <https://atom.io>`_ or IDE such as `Eclipse <https://www.eclipse.org>`_ `NetBean <https://netbeans.org>`_ or `IntelliJ <https://www.jetbrains.com/idea/>`_.

In the following, we will give the commands line so that the tutorial can be done independently of any IDE.

Step 1. Create a simple Java project with PDDL4J
------------------------------------------------

First, open a terminal and create your development directory ASP (A* Planner)

.. code-block:: bash

    mkdir ASP

Then, create the sub-directories of your project

.. code-block:: bash

    cd ASP
    mkdir -p src/fr/uga/pddl4j/examples/asp
    mkdir classes
    mkdir lib


Finally, get the last binary of PDDL4J and save it in the ``lib`` directory

.. code-block:: bash

    wget http://pddl4j.imag.fr/repository/pddl4j/binaries/pddl4j-4.0.0.jar
    mv pddl4j-4.0.0.jar lib/pddl4j-4.0.0.jar

You are now ready to write your own A* planner.

Step 2. Create the main class of our planner
--------------------------------------------

Create and edit a file called ``ASP.java`` in the directory ``src/fr/uga/pddl4j/examples/asp``. The skeleton of this
class is given bellow:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 16-47,58-64,157-177,194,260-267,270-273,375
    :linenos:

The class ASP extends the abstract class `AbstractPlanner <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/AbstractPlanner.html>`_
that contains the basic methods of any planners. The class is generic. You have to specify the type of problem that your
planner is able to solve. In our case, our planner will be only able to solve simple problem called `ADLProblem <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/problem/ADLProblem.html>`_.
ADL is a subset of the PDDL language.

Two methods must be overridden at least:
  - The method ``instantiate(ParsedProblem problem)`` is an abstract method of the class ``AbstractPlanner``. This
    method takes as parameter an instance of parsed problem and return the corresponding instantiated or grounding
    problem. The problem returned contains all the information related to the problem, i.e., the actions, the initial
    state, the goal of the problem, etc.
  - The method ``solve(Problem problem)`` is the main method of the planner. The method takes as parameter the
    instantiated problem returned by the previous method overridden and returns a plan solution of null if no plan was
    found.

.. note::

    The given skeleton contains also a ``main()`` method to launch the planner from the command line. We will
    return to this method in the next section.

.. note::

    Every planner  can have a logger instance. This logger is based on `Log4j <https://logging.apache.org/log4j/>`_
    library developed by Apache and specialized in logging. A great benefit of `Log4j <https://logging.apache.org/log4j/>`_
    is that different levels of logging can be set for your planner. The levels are hierarchical and are as follows:
    *TRACE*, *DEBUG*, *INFO*, *WARN*, *ERROR*, and *FATAL*. Have a look to the web site of
    `Log4j <https://logging.apache.org/log4j/>`_ for more details. The declaration of the logger is done line 38. To see
    an example use of the logger see line 71 of the ``main()`` method.

Step 3. Get the planner arguments from the command line
-------------------------------------------------------

Before writing the search algorithm let's first look at how to get the arguments from the command line. Your planner
takes as inputs at least a domain file that contains the description of the planning operators and a problem file that
define the initial state and the goal to reach. Both files domain and problem rely on PDDL
(Planning Domain Description Language). For those who are not familiar with PDDL, first have a look to the tutorial
:ref:`pddl_tutorial_chapter`. To deal with complex command line arguments, PDDL4J used `picocli <https://picocli.info/>`_
library. Picocli allow to create rich command line applications just by adding annotation on the main class of our
planner.

Step 3.1. Activate the default command line arguments
*****************************************************

By default, the class `AbstractPlanner <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/AbstractPlanner.html>`_
already handles the common arguments of all planners: the domain and the problem description, the time allocated
to the search and the log level. The domain and the problem descriptions are mandatory parameters. The log level and
the time allocated to search are optional.

To activate the default command line for your planner you have just to add the following annotation before the class
declaration:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 41-58
    :linenos:

and complete the ``main()`` method with the code below:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 260-273
    :linenos:
    :emphasize-lines: 268-269

To test, first compile your planner:

.. code-block:: bash

    javac -d classes -cp lib/pddl4j-4.0.0.jar src/fr/uga/pddl4j/examples/asp/ASP.java

and run it with the command line:

.. code-block:: bash

    java -cp classes:lib/pddl4j-4.0.0.jar fr.uga.pddl4j.examples.asp.ASP --help

You will obtain the following message:

.. code-block:: bash

    ASP [-hiV] [-l=<logLevel>] [-t=<timeout>] <domain> <problem>

    Description:

    Solves a specified planning problem using a A* search strategy.

    Parameters:
        <domain>              The domain file.
        <problem>             The problem file.

    Options:
        -t, --timeout=<timeout>   Set the time out of the planner in seconds (preset 600s).
        -l, --log=<logLevel>      Set the level of trace of the planner: ALL, DEBUG,
                                    INFO, ERROR, FATAL, OFF, TRACE (preset INFO).
        -h, --help                Show this help message and exit.
        -V, --version             Print version information and exit.

Step 3.2 Adding new command line arguments
******************************************

Now, we have to add the specific arguments of our planner to allow to choose the heuristic function to used and set
the weight of the heuristic. This step is relatively simple and straightforward. We just need to declare two new
attributes: one for the heuristic and one for its weight. The heuristic is of type GoalCostHeuristic.Name and the weight
of type double. Note that the weight must be greater than 0.

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 85-93
    :linenos:

To complete, we also add the corresponding getters and setters:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 112-155
    :linenos:

To test, your complete command line compile once again your planner:

.. code-block:: bash

    javac -d classes -cp lib/pddl4j-4.0.0.jar src/fr/uga/pddl4j/examples/asp/ASP.java

and run it with for instance the command line:

.. code-block:: bash

    java -cp classes:lib/pddl4j-4.0.0.jar fr.uga.pddl4j.examples.ASP
         src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/domain.pddl
         src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/p01.pddl
         -e FAST_FORWARD
         -w 1.2
         -t 1000

Now the command line is set. The final command line of your planner is as follows:

.. code-block:: bash

    ASP [-hV] [-e=<heuristic>] [-l=<logLevel>] [-t=<timeout>] [-w=<weight>]
        <domain> <problem>

    Description:

    Solves a specified planning problem using A* search strategy.

    Parameters:
        <domain>              The domain file.
        <problem>             The problem file.

    Options:
        -t, --timeout=<timeout>   Set the time out of the planner in seconds (preset
                                    600s).
        -l, --log=<logLevel>      Set the level of trace of the planner: ALL, DEBUG,
                                    INFO, ERROR, FATAL, OFF, TRACE (preset INFO).
        -w, --weight=<weight>     Set the weight of the heuristic (preset 1.0).
        -e, --heuristic=<heuristic>
                                  Set the heuristic : AJUSTED_SUM, AJUSTED_SUM2,
                                    AJUSTED_SUM2M, COMBO, MAX, FAST_FORWARD,
                                    SET_LEVEL, SUM, SUM_MUTEX (preset: FAST_FORWARD)
        -h, --help                Show this help message and exit.
        -V, --version             Print version information and exit.

Step 4. Searching for a solution plan
-------------------------------------

You finally think we're here. How write my search procedure ? Two possibilities or the search procedure you want to use
already exists in PDDL4J. In this case, it's extremely simple just call the right procedure in the ``solve()`` method.
Otherwise, you have to write your own procedure. Let us first consider the first case. The second will consider in last
part of this tutorial.

All the search strategies for state space planning already implemented in PDDL4J are available in the package
`fr.uga.pddl4j.planners.statespace.search.strategy <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/parser/ErrorManager.html). In our case, we would like to use the [AStar](http://pddl4j.imag.fr/repository/pddl4j/api/current/fr/uga/pddl4j/planners/statespace/search/strategy/AStar.html>`_
search strategies. Thus, your ``solve()`` must look like as follows:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 170-194
    :linenos:

First, we create an instance of the search strategy for the problem to solve and then, we try to find a plan for this
problem.

.. note::
    If you need to get the goal node for printing for instance returned by the search strategy you can replace the call
    to ``searchPlan()`` line 14 by:

    .. code-block:: java

        final Node goal = search.searchSolutionNode(problem);
        Planner.getLogger().trace(problem.toString(goal));
        Plan plan = search.extractPlan(goal, problem);

Now, your planner is ready to solve problems. After compiling the project run your planner with the command line to make
a test:

.. code-block:: bash

    java -cp classes:lib/pddl4j-4.0.0.jar fr.uga.pddl4j.examples.ASP
         src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/domain.pddl
         src/test/resources/benchmarks/pddl/ipc2002/depots/strips-automatic/p01.pddl
         -e FAST_FORWARD
         -w 1.2
         -t 1000

The output should be:

.. code-block:: bash

    parsing domain file "domain.pddl" done successfully
    parsing problem file "p01.pddl" done successfully

    problem instantiation done successfully (90 actions, 46 fluents)

    * Starting A* search
    * A* search succeeded

    found plan as follows:

    00: (       lift hoist0 crate1 pallet0 depot0) [0]
    01: ( lift hoist1 crate0 pallet1 distributor0) [0]
    02: (        load hoist0 crate1 truck1 depot0) [0]
    03: (        drive truck1 depot0 distributor0) [0]
    04: (  load hoist1 crate0 truck1 distributor0) [0]
    05: (unload hoist1 crate1 truck1 distributor0) [0]
    06: (  drive truck1 distributor0 distributor1) [0]
    07: ( drop hoist1 crate1 pallet1 distributor0) [0]
    08: (unload hoist2 crate0 truck1 distributor1) [0]
    09: ( drop hoist2 crate0 pallet2 distributor1) [0]

    time spent:       0,02 seconds parsing
                      0,03 seconds encoding
                      0,01 seconds searching
                      0,07 seconds total time

    memory used:      0,00 MBytes for problem representation
                      0,00 MBytes for searching
                      0,00 MBytes total

Step 5. Write your own A* search strategy
-----------------------------------------

Before writing your own A* search strategy, you need to create a class ``Node``. This class represents a node of search
tree  developed by A*.

Step 5.1 Writing your own class Node
************************************

For state space planning a Node is a data structure with 5 components:
  #. A state, i.e., the state in the state space to which the node corresponds;
  #. A parent node, i.e., the node in the search tree that generated this node;
  #. An action, i.e., the action that was applied to the parent node to produce this node;
  #. A cost, i.e., the cost of the path from the initial state to the node, as indicated by the parent pointer; and
  #. A heuristics value, i.e., a estimation of the cost from this node to a solution one.

The easiest way to write your own node class is to inherit the `State <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/problem/State.html>`_
class that models a state in a compact way. To do so, start creating a file ``Node.java`` in the repertory
``src/fr/uga/pddl4j/examples/asp/`` and copy and paste the the skeleton of the class ``Node`` is given below:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/Node.java
    :language: java
    :lines: 20-
    :linenos:

Step 5.2 Writing your own A* search
************************************

`A* <https://en.wikipedia.org/wiki/A*_search_algorithm>`_ is an informed search algorithm, or a best-first search,
meaning that it solves problems by searching among all possible paths to the solution (goal) for the one that incurs the
smallest cost (least distance traveled, shortest time, etc.), and among these paths it first considers the ones that
appear to lead most quickly to the solution. It is formulated in terms of weighted graphs: starting from a specific node
of a graph, it constructs a tree of paths starting from that node, expanding paths one step at a time, until one of its
paths ends at the predetermined goal node (see the `pseudocode A* <https://en.wikipedia.org/wiki/A*_search_algorithm#Pseudocode>`_
for more details).

At each iteration of its main loop, A* needs to determine which of its partial paths to expand into one or more longer
paths. It does so based on an estimate of the cost (total weight) still to go to the goal node. Specifically, A* selects
the path that minimizes *f(n) = g(n) + h(n)* where :
  * *n* is the last node on the path,
  * *g(n)* is the cost of the path from the start node to *n*, and
  * *h(n)* is a heuristic that estimates the cost of the cheapest path from *n* to the goal.

For the algorithm to find the actual shortest path, the heuristic function must be admissible, meaning that it never
overestimates the actual cost to get to the nearest goal node.

Typical implementations of A* use a priority queue to perform the repeated selection of minimum (estimated) cost nodes
to expand. This priority queue is known as the open set or fringe. At each step of the algorithm, the node with the
lowest *f(x)* value is removed from the queue, the *f* and *g* values of its neighbors are updated accordingly, and
these neighbors are added to the queue. The algorithm continues until a goal node has a lower *f* value than any node in
the queue (or until the queue is empty). The *f* value of the goal is then the length of the shortest path, since *h* at
the goal is zero in an admissible heuristic. After this algorithm is run, the ending node will point to its predecessor,
and so on, until some node's predecessor is the start node (see the ``extract`` procedure below).

Consider the implementation of A* now with PDDL4J and the new ``solve()`` procedure:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 275-356
    :linenos:

The method ``extractPlan()`` extracts a solution plan from the search space by backward chaining the path from the goal
node to the root node. The code is given below:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 358-374
    :linenos:

Finally, you have to change the call to the method ``searchPlan()`` in the method ``solve()`` by the explicit call to
your ``astar()`` procedure. Your new ``solve()`` method is:

.. code-block:: java
    :linenos:

    /**
     * Search a solution plan to a specified domain and problem using A*.
     *
     * @param problem the problem to solve.
     * @return the plan found or null if no plan was found.
     */
    @Override
    public Plan solve(final ADLProblem problem) {
        LOGGER.info("* Starting A* search \n");
        // Search a solution
        final long begin = System.currentTimeMillis();
        final Plan plan = this.astar(problem);
        final long end = System.currentTimeMillis();
        // If a plan is found update the statistics of the planner
        // and log search information
        if (plan != null) {
            LOGGER.info("* A* search succeeded\n");
            this.getStatistics().setTimeToSearch(end - begin);
        } else {
            LOGGER.info("* A* search failed\n");
        }
        // Return the plan found or null if the search fails.
        return plan;
    }

Step 6. Make your planner configurable by programming
-----------------------------------------------------

By default, your planner is configurable by programming (see MISSING REF for more details) because it inherits the class
`AbstractPlanner <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/AbstractPlanner.html>`_.
But only for the common configurable properties of all planners, i.e., the domain, the problem, the timeout and the log
level.

  .. note::
    The common configurable properties and their values are defined in the interface `Planner <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/Planner.html>`_.

In order to allow the new properties of your planner to be configurable by programming, you have to :
  #. declare for each new property a name and a default value
  #. redefined the setter and the getter method to set and get the configuration of your planner
  #. redefined a method ``getDefaultConfiguration()``
  #. redefined the method ``hasValidConfiguration()``
  #. redefined the constructors of your planner and deal with the class `PlannerConfiguration <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/_PlannerConfiguration.html>`_


Step 6.1 Declaration of new properties
**************************************

In the case of your planner, you have two new properties that you want configure: the heuristic and the weight the weight
associated with it. The following code:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 65-83
    :linenos:

Step 6.2 Setting and getting the configuration of your planner
**************************************************************

To deal with the two properties and make your planner configurable by programming, it is necessary to redefined the
setter and the getter of the class `AbstractPlanner <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/AbstractPlanner.html>`_.
This can be done in your case using the code below:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 224-258
    :linenos:

The code is quite simple. It call the method ``getConfigration()`` and ``setConfiguration()`` from the parent class `AbstractPlanner <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/AbstractPlanner.html>`_.
and set of get the new properties to an instance of the class `PlannerConfiguration <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/_PlannerConfiguration.html>`_.

Step 6.3 Defining the default configuration of your planner
***********************************************************

By convention all planner have a static method which returns the default configuration of a planner. In your case, the
method ``getDefaultConfiguration()`` calls the eponymous method from the parent class `AbstractPlanner <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/AbstractPlanner.html>`_.
Then, in the same way as the previous method ``getConfiguration()`` it creates an instance of the class `PlannerConfiguration <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/_PlannerConfiguration.html>`_
with the default values.

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 210-222
    :linenos:

Step 6.4 Defining the method that checks if a configuration is valid or not
*************************************************************************

The ``hasValideConfiguration()`` method calls the eponymous method of the parent class `AbstractPlanner <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/AbstractPlanner.html>`_
and adds the checks on the added properties. For your planner, it checks that the weight associated to the heuristic is
strictly greater than 0 and that a heuristic has been chosen among the `GoalCostHeuristics <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/heuristic/GoalCostHeuristics.html>`_
already defined in the library

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 196-208
    :linenos:

Step 6.5 Redefining the constructors of your planner
****************************************************

Redefining the constructors of your planner to create your planner from a `PlannerConfiguration <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/_PlannerConfiguration.html>`_
can be done with the code below:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/asp/ASP.java
    :language: java
    :lines: 95-110
    :linenos:

.. note::
    The final code of the planner code is available `here <https://github.com/pellierd/pddl4j/tree/temporal/src/main/java/fr/uga/pddl4j/examples/asp/ASP.java>`_.
