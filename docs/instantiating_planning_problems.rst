.. _instantiating_planning_problems_chapter:

Instantiating Planning Problems
===============================

The instantiation of a planning problem consists in transforming the operators of the planning domain into ground
actions. Some planners use the instantiation in order to encode planning problems into different formalisms such as SAT
or CSP for instance. However most planners use the instantiation to efficiently compute heuristics, speedup the search
algorithm by using a compact encoding. In this tutorial, we present how to used PDDL4J to instantiate planning problems.

Pre-requisite Installations
---------------------------

For this tutorial you need:
  *  `Java JDK <https://adoptopenjdk.net/>`_ version 8 or higher is installed.
  * A text editor such as `Sublime <https://www.sublimetext.com>`_ or `Atom <https://atom.io>`_ or IDE such as `Eclipse <https://www.eclipse.org>`_ `NetBean <https://netbeans.org>`_ or `IntelliJ <https://www.jetbrains.com/idea/>`_.

In the following, we will give the commands line so that the tutorial can be done independently of any IDE.

Step 1. Create a simple Java project with PDDL4J
------------------------------------------------

First, open a terminal and create your development directory

.. code-block:: bash

    mkdir ProblemInstantiationExample

Then, create the sub-directories of your project

.. code-block:: bash

    cd ProblemInstantiationExample
    mkdir -p src/fr/uga/pddl4j/examples
    mkdir classes
    mkdir lib

Finally, get the last binary of PDDL4J and save it in the ``lib`` directory

.. code-block:: bash

    wget http://pddl4j.imag.fr/repository/pddl4j/binaries/pddl4j-4.0.0.jar
    mv pddl4j-4.0.0.jar lib/pddl4j-4.0.0.jar

Step 2. Create the main class of our example
--------------------------------------------

Create and edit a file called ``ProblemInstantiationExample.java`` in the directory ``src/fr/uga/pddl4j/examples/``.
The skeleton of this class is given bellow:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/ProblemInstantiationExample.java
    :language: java
    :lines: 16-
    :linenos:

The first part of the main method parses the domain and the problem from the PDDL files (see for more details). If the
parser succeeds, then a new `ADLProblem <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/ADLProblem.html>`_
is created from the parsed problem. Then, the method ``instantiate()``is called to instantiate the problem.

.. warning::
    The call to the instantiate method can be long for complex problems.

The rest of the code print the list of actions of the instantiated problem.

Step 3. Compile and Run the example
-----------------------------------

To test the above code use the following command line to compile the example:

.. code-block:: bash

    javac -d classes -cp classes:lib/pddl4j-4.0.0.jar src/fr/uga/pddl4j/examples/ProblemInstantiationExample.java

and then the following command line to run the example:

.. code-block:: bash

    java -cp classes:lib/pddl4j-4.0.0.jar fr.uga.pddl4j.examples.ProblemInstantiationExample \\
        src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/domain.pddl \\
        src/test/resources/benchmarks/pddl/ipc2000/logistics/strips-typed/p01.pddl


