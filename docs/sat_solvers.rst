.. _sat_solvers_chapter:

Solving problems with SAT solvers
=============================

This tutorial explains how to use PDDL4J to solve a problem with a SAT solver.

In PDDL4J, there are three main class types used for SAT solving :
  * A SAT solver (obviously)
  * An encoding that can take a problem and encode it into a SAT problem
  * A SAT planner using the encoding to solve the problem

There are already encodings in the library, but you may be interested in creating your own. This tutorial explains how to implement encodings as well as solvers and SAT planners.

  #. Create a simple Java project with PDDL4J
  #. Add a SAT encoding (optional)
  #. Add a SAT solver
  #. Add a SAT planner
  #. Run our example

Pre-requisite Installations
---------------------------

For this tutorial you need:
  *  `Java JDK <https://adoptopenjdk.net/>`_ version 8 or higher is installed.
  * A text editor or an IDE.

In the following, we will give the command lines so that the tutorial can be done independently of any IDE.

Step 1. Create a simple Java project with PDDL4J
------------------------------------------------

First, open a terminal and create your development directory ``SAT``

.. code-block:: bash

    mkdir SAT

Then, create the sub-directories of your project

.. code-block:: bash

    cd SAT
    mkdir -p src/fr/uga/pddl4j/examples/sat
    mkdir classes
    mkdir lib


Finally, get the last binary of PDDL4J and save it in the ``lib`` directory

.. code-block:: bash

    wget http://pddl4j.imag.fr/repository/pddl4j/binaries/pddl4j-4.0.0.jar
    mv pddl4j-4.0.0.jar lib/pddl4j-4.0.0.jar

You are now ready to write your own SAT planner and encoding.

Step 2. Add a SAT encoding (optional)
--------------------------------------------

In PDDL4J, encoding a problem into a SAT solver is done in four steps :
  #. encoding the initial state
  #. encoding the goal
  #. encoding the available actions
  #. encoding the frame axioms (i.e. the axioms necessary to specify the particular constraints of a planning problem; e.g. only one action may be taken at each step)

To each of these steps corresponds a method (consistently called ``encodeInitialState``, ``encodeGoal``, ``encodeAction`` and ``encodeFrameAxioms``).

.. note::

    ``encodeInitialState`` and ``encodeGoal`` have a default behavior, and you don't need to override them (although it will be done here as an example). However, you always need to override ``encodeAction`` and ``encodeFrameAxioms``.

This is done incrementally, since we first search for a plan of length 0 (with exactly 0 actions), then of length 1 (with exactly 1 action), etc. Thus, encoding an action (for example) must be done for each step where the action is possible ("this action is possible at state 0; it is possible at state 1; it is possible at state 2; …").

Before diving into our encoding example, let's explain how to add a clause to a solver.

Suppose we have five fluents ``a``, ``b``, ``c``, ``d`` and ``e`` (in this order, which means they are elements of indexes 0 to 4 in the list of fluents of the problem), and we want to encode ``(a or b or (not c)) and ((not d) or e)`` (which contains two clauses) at state 7. In this case, it can be done easily like this:

.. code-block:: java

    addFluent(0, 7, true); //a at state 7
    addFluent(1, 7, true); //b at state 7
    addFluent(2, 7, false); //not c at state 7
    endClause(); //ends the clause; so, this will be interpreted as (a or b or (not c))
    addFluent(3, 7, false); //not d at state 7
    addFluent(4, 7, true); //e at state 7
    endClause(); //the clause ((not d) or e) will be added

Similarly, you may add an action (whose index in the list of actions of the problem is 0) at state 7 using ``addAction(0, 7, true)``.

.. note::

    This will be persistent. That is, if you add a clause for a given state while searching for a plan of length `n`, this clause will be kept when you will search for a plan of length `n + 1`, `n + 2`, etc.
    If you want this clause to be discarded when moving to plans of length greater than `n`, you may want to use ``assumeFluent`` or ``assumeAction``. In this case, you don't need to add an ``endClause()``. Please note, however, that this only works with clauses containing a unique literal!

.. note::

    You may recognize a syntax similar to the ipasir interface. Indeed, these methods are wrappers for ipasir ``add`` and ``assume`` functions.

Let's begin. **Create and edit a file called** ``SATEncodingExample.java`` **in the directory** ``src/fr/uga/pddl4j/examples/sat``. The skeleton of this class is given below:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/sat/SATEncodingExample.java
    :language: java
    :lines: 1-99999
    :linenos:

.. note::
    This particular encoding is based on chapter 7 of "Automated Planning: theory and practice", from Malik Ghallab, Dana Nau and Paolo Traverso, published by Morgan Kaufmann in 2004.

In this case (which is the same as the default behavior), ``encodeInitialState`` loops over all the fluents that are true or false in the initial state (state 0), and creates a clause for each of them, stating whether they are true or false.

``encodeGoal`` works similarly, taking as argument the currently considered plan length (the total number of actions taken in a plan; we are looking for a plan with 0 actions, then 1 action, then 2, etc.), using the ``assumeFluent`` method to specify everything that has to be true or false at state `planLength`.

``encodeAction`` takes as argument both the index of the action in the list of the actions of the problem (so that the action can be obtained with ``getProblem().getActions().get(actionIndex)``) and the state at which the action will be taken (between `0` and `planLength - 1`). In this case, for some action at some state, it encodes that the action implies all its effects as well as all its preconditions.

Next, ``encodeFrameAxioms``, which takes as argument the considered state (between `0` and `planLength - 1`), is here calling two other methods:

  * ``encodeExplanatoryFrameAxioms``, which essentially encodes the fact that "if a fluent changes, then one of the actions that have that fluent in its effects has been executed"
  * ``encodeCompleteExclusionAxioms``, which states that only one action may be taken at a given state (for all different actions ``a`` and ``b`` at this state, we have ``(not a) or (not b)``)

Finally, in each encoding, you need to implement the method ``actionHasBeenChosen``, which is used to extract a plan. Indeed, we have to know how to know when an action has been chosen, using the results of the solver. In this case, our encoding for an action is straightforward: to add the action number *5* in the problem, we simply call ``addAction`` on the value ``actionIndex = 5``, so, to be sure that this action has been taken, we just need to check whether the index *5* has been assigned the value ``true`` by the solver (which we can do easily using the method ``isTrue``). In other cases, more conditions must be checked (for example, in a bitwise encoding, truth values are assigned to several bits which all have to be checked).

That's it! Our SAT encoding is done! You must now create a SAT planner and may (if you want) add an additional SAT solver, before running the example.

Step 3. Add a SAT solver
--------------------------------------------

SAT solvers are not provided with the library. This step presents an easy guide for adding the MergeSat solver, and then general instructions if you want to add another solver.

**A straightforward example: adding MergeSat**

This part guides you in adding `mergesat <https://github.com/conp-solutions/mergesat>`_. In this case, here are the shell commands that will allow you to do so:

.. code-block:: bash

    git clone https://github.com/conp-solutions/mergesat.git
    cd mergesat
    make all
    mv build/dynamic/lib/libmergesat.so* ../lib/libmergesat.so

And that's it!

.. note::
    If you have difficulties compiling the solver following the instructions above, you may also find a pre-compiled version of MergeSat that you may download :download:`here <http://pddl4j.imag.fr/repository/ressources/libmergesat.so>` and put it in the ``lib`` directory in your project. Please note that it has been compiled on a **Debian GNU/Linux x86_64** system and may not work on all systems.

**General instructions for other solvers (optional)**

This part presents a general overview of how you may add another solver. If you are satisfied with the MergeSat solver, you may skip this and go to the next step.

First of all, you may only add SAT solvers that implement the ipasir interface.

.. note::

    If you're not sure whether or not the solver you want to add implements ipasir, but you have access to its source code, here is a tip: run ``grep -r "ipasir"`` at the root of the code of the solver; if the result is empty, then you can be sure that it *doesn't* implement ipasir and thus won't work with PDDL4J as is.

If your solver implements ipasir, your aim is now to get a ``.so`` file (shared object) for your solver. If you are lucky, your solver has a makefile with an option to build a ``.so`` file; otherwise, you may need to use ``gcc`` or modify your solver's makefile to get it (which is not the subject of this tutorial).

Move this .so file into the ``lib`` directory in your project (for example) ; note that the file *has to* end with ``.so``.

You now have to create a simple wrapper in Java in order to be able to use this solver from your Java code. Here, we will provide an example for MergeSat, although it is already provided in the library (which is why you don't have to write the wrapper if you add MergeSat).

**Create and edit a file** ``MergesatWrapper.java`` **in the directory** ``src/fr/uga/pddl4j/examples/sat``. The skeleton of this class is given below:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/sat/MergesatWrapper.java
    :language: java
    :lines: 1-99999
    :linenos:

.. note::

    This syntax comes from the `ipasir4j <https://github.com/liveontologies/ipasir4j>`_ project used by PDDL4J.

Adapting this to another solver is straightforward: just change the class and attribute names (or not), and, most importantly, the path given as argument to ``Native.load()``, which has to be the path to the ``.so`` file of your solver from the root of your project.

At this point, you've managed to add a solver to your project.

Step 4. Add a SAT planner
--------------------------------------------

Finally, let's create a SAT planner. **Create and edit a file** ``SATPlannerExample.java`` **in the directory** ``src/fr/uga/pddl4j/examples/sat``. The skeleton of this class is given below:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/sat/SATPlannerExample.java
    :language: java
    :lines: 1-99999
    :linenos:

This is a basic implementation of a SAT planner. Note that it has to extend ``AbstractSATPlanner``.

There are two methods that you may have to override: ``getSATEncodingFromName(String encodingName)`` (necessary only if you added an encoding) and ``getSATSolverFromName(String solverName)``.

The first one is a mapping from the argument for an encoding to the actual class of the encoding. For example, in this case, using the argument ``-e EXAMPLE`` will allow us to use our new example encoding.

.. note::

    Provided encodings don't need to be added here, they are already taken care of if you call ``super.getSATEncodingFromName(encodingName)`` at the end of the method.

The second one is a mapping from the argument for a solver to the actual class of the solver. For example, in this case, using the argument ``-s MERGESAT`` will allow us to use our new solver.

The rest of this implementation is not specific to SAT planners, so, if something seems unclear, please refer to  :ref:`writing_your_own_planner_chapter`. You may of course add more arguments and extend the configuration according to your needs.

Step 5. Run our example
--------------------------------------------

At this point, we can now try to run our SAT planner on a simple problem, like the first example of the :ref:`pddl_tutorial_chapter`.

First, compile your code:

.. code-block:: bash

    javac -d classes -cp lib/pddl4j-4.0.0.jar src/fr/uga/pddl4j/examples/sat/*.java

Then, you may use the provided classes this way (it will use MergeSat and the default encoding):

.. code-block:: bash

           java -cp classes:lib/pddl4j-4.0.0.jar \
                   fr.uga.pddl4j.examples.sat.SATPlannerExample \
                   path/to/domain.pddl \
                   path/to/problem.pddl

Or, if you want to specify the solver (``-s MERGESAT``, for example), the encoding (``-e DEFAULT``), the maximum plan length (``-mpl 1000``) and the timeout in seconds (``-t 10``), you may also specify them like this:

.. code-block:: bash

           java -cp classes:lib/pddl4j-4.0.0.jar \
                   fr.uga.pddl4j.examples.sat.SATPlannerExample \
                   path/to/domain.pddl \
                   path/to/problem.pddl \
                   -s MERGESAT \
                   -e DEFAULT \
                   -mpl 1000 \
                   -t 10

Congratulations, you have solved a problem using a SAT planner!
