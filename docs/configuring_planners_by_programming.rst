.. _configuring_planners_by_programming_chapter:

Configuring Planners by Programming
===================================

There are two ways to run a existing planner by programming: by direct manipulating or using the class  `PlannerConfiguration <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/PlannerConfiguration.html>`_.

Pre-requisite Installations
---------------------------

For this tutorial you need:
  *  `Java JDK <https://adoptopenjdk.net/>`_ version 8 or higher is installed.
  * A text editor such as `Sublime <https://www.sublimetext.com>`_ or `Atom <https://atom.io>`_ or IDE such as `Eclipse <https://www.eclipse.org>`_ `NetBean <https://netbeans.org>`_ or `IntelliJ <https://www.jetbrains.com/idea/>`_.

In the following, we will give the commands line so that the tutorial can be done independently of any IDE.

Step 1. Create a simple Java project with PDDL4J
------------------------------------------------

First, open a terminal and create your development directory ``PlannerConfigurationExamples``

.. code-block:: bash

    mkdir PlannerConfigurationExamples

Then, create the sub-directories of your project

.. code-block:: bash

    cd PlannerConfigurationExamples
    mkdir -p src/fr/uga/pddl4j/examples/
    mkdir classes
    mkdir lib


Finally, get the last binary of PDDL4J and save it in the ``lib`` directory

.. code-block:: bash

    wget http://pddl4j.imag.fr/repository/pddl4j/binaries/pddl4j-4.0.0.jar
    mv pddl4j-4.0.0.jar lib/pddl4j-4.0.0.jar

You are now ready to configure an existing planner of the library by programming.

Step 2. By directly manipulating
--------------------------------

Create and edit a file called ``DirectPlannerConfigurationExample.java`` in the directory ``src/fr/uga/pddl4j/examples/``.
The skeleton of this class is given bellow:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/DirectPlannerConfigurationExample.java
    :language: java
    :lines: 16-

The code above configures and run the planner called `HSP <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/statespace/HSP.html>`_
on the first problem of the depot domain from IPC 2002.

To test the above code use the following command line to compile the example:

.. code-block:: bash

    javac -d classes -cp classes:lib/pddl4j-4.0.0.jar src/fr/uga/pddl4j/examples/DirectPlannerConfigurationExample.java

and then the following command line to run the example:

.. code-block:: bash

    java -cp classes:lib/pddl4j-4.0.0.jar fr.uga.pddl4j.examples.DirectPlannerConfigurationExample


Step 3. Using the class planner configuration
---------------------------------------------

Create and edit a file called ``PlannerConfigurationExample.java`` in the directory ``src/fr/uga/pddl4j/examples/``.
The skeleton of this class is given bellow:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/PlannerConfigurationExample.java
    :language: java
    :lines: 16-

The above code configures and runs same `HSP <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/statespace/HSP.html>`_
planner with the same configuration as by direct manipulating.

.. note::
    The advantage of using the `PlannerConfiguration <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/PlannerConfiguration.html>`_
    object is that you can save or load specific configurations using the ``store()`` and ``load()`` methods of the
    class in XML format

To test the above code use the following command line to compile the example:

.. code-block:: bash

    javac -d classes -cp classes:lib/pddl4j-4.0.0.jar src/fr/uga/pddl4j/examples/PlannerConfigurationExample.java

and then the following command line to run the example:

.. code-block:: bash

    java -cp classes:lib/pddl4j-4.0.0.jar fr.uga.pddl4j.examples.PlannerConfigurationExample
