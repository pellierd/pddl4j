.. _configuring_planners_by_programming_chapter:

Configuring Planners by Programming
===================================

There are two ways to run a existing planner by programming.

By directly manipulating
************************

By directly manipulating the planner class that you want to configure and launch. The code below configures the `HSP <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/statespace/HSP.html>`_
planner and launches it.

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/PlannerConfigurationExample1.java
    :language: java
    :lines: 16-

Using the class planner configuration
*************************************

The configuration of the planner can be also done using the class ``PlannerConfiguration`` as follow:

.. literalinclude:: ../src/main/java/fr/uga/pddl4j/examples/PlannerConfigurationExample2.java
    :language: java
    :lines: 16-

the above code configures and launches the `HSP <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/statespace/HSP.html>`_
 with the same configuration.

.. note::
    The advantage of using the `PlannerConfiguration <http://pddl4j.imag.fr/repository/pddl4j/api/current/index.html?fr/uga/pddl4j/planners/PlannerConfiguration.html>`_
    object is that you can save or load specific configurations using the ``store()`` and ``load()`` methods of the c
    lass in XML format
