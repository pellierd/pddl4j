.. _pddl_tutorial_chapter:

A tutorial to start with PDDL
=============================

What is PDDL?
-------------

PDDL (Planning Domain Description Language) is a standard encoding language for “classical” planning.

The components of PDDL files are:
  * *Requirements:* defining levels of abstraction in the language, e.g., "STRIPS", temporal, probabilistic effects etc.
  * *Types:* sets of the things of interest in the world,
  * *Objects:* instances of types,
  * *Predicates:* Facts about objects that can be true or false,
  * *Initial state* of the world: before starting the planning process,
  * *Goal:* properties of the world true in goal states and achieved after the planning process,
  * *Actions/Operators:* ways of changing states of the world and going from the initial state to goal states.

A planning task in PDDL is specified in two text files:
  #. A *domain file* for requirements, types, predicates and actions,
  #. A *problem file* for objects, initial state and goal specification.

Domain files are as follows:

.. code-block:: text

    (define (domain <domain name>)
        <PDDL code for requirements>
        <PDDL code for types>
        <PDDL code for predicates>
        <PDDL code for first action>
        [...]
        <PDDL code for last action>
    )

where ``<domain name>`` is a string that identifies the planning domain.

.. note::

    Many examples are available in ``src/test/resources/benchmarks/pddl``. Domains and problems are classified by
    competition year and by track

Problem files are as follows:

.. code-block:: text

    (define (problem <problem name>)
        (:domain <domain name>)
        <PDDL code for objects>
        <PDDL code for initial state>
        <PDDL code for goal specification>
    )

where:
    * ``<problem name>`` is the string that identifies the planning task, e.g. gripper with 4 balls to move.
    * ``<domain name>`` is the planning domain name corresponding to problem file.

.. note::

   Novices in PDDL should start by doing the :ref:`simple_running_example_section`. Advanced readers can go directly to
   the :ref:`industrial_use_case_section`.

.. _simple_running_example_section:

A Simple Running Example: Logistics
-----------------------------------

We will use the Logistics domain to illustrate how to represent a planning task in PDDL.

In logistics, there are trucks and airplanes that can move packages between different airports and cities. We assume
that in the initial state there is a truck in Paris airport. An airplane and two packages are in London airport. Paris
has two places : south and north. The goal is to have one package in the north location and the other one in the south
location.

First, create two text files respectively called ``logistics.pddl`` and ``problem.pddl``. You can choose whatever text
editor you want.

.. note::

Remember that PDDL requires two files:
  1. A *domain file* for requirements, types, predicates and actions,
  2. A *problem file* for objects, initial state and goal specification.

Defining the Domain
~~~~~~~~~~~~~~~~~~~

Let start by defining in the file ``logistics.pddl`` the domain and its components :
    * the requirements,
    * the types,
    * the predicates,
    * the actions or the operators.

First, we have to define the name of the domain:

In PDDL, we write :

.. code-block:: text

    (define (domain logistics)


Requirements
****************

The requirements for this logistics example are:
  * **strips** : the actions will only use positive preconditions (predicates that must be true in the current state to trigger actions) and deterministic effects (effects that necessarily follow action triggering). Nothing else is allowed.
  * **typing** : we will use "types" like in OO programming to represent sets of objects in the world.

In PDDL, we write :

.. code-block:: text

    (:requirements :strips :typing)

Types
*********

We will use the following types:
  * Places, cities and physical objects are considered as objects,
  * Packages and vehicles are physical objects,
  * Trucks and airplanes are vehicles,
  * Airports and locations are places.

In PDDL, we write:

.. code-block:: text

    (:types city place physobj - object
          package vehicle - physobj
          truck airplane - vehicle
          airport location - place
    )

Predicates
**************

We will use the following predicates:
  * *in-city(loc, city)* - true iff a place *loc* is in the city *city*
  * *at(obj, loc)* - true iff a physical object *obj* is at place *loc*
  * *in(pkg, veh)* - true iff the a package *pkg* is in a vehicle *veh*

In PDDL, question marks are used for variables:

.. code-block:: text

    (:predicates (in-city ?loc - place ?city - city)
        (at ?obj - physobj ?loc - place)
    	(in ?pkg - package ?veh - vehicle)
    )

Operators
*********

We are going to define the operators of the actions of the logistics domain, i.e., the means to change the states of
the world. The domains has 5 operators: *load-truck*, *load-airplaine*, *unload-truck*, *unload-airplane*, *drive-truck*
and *fly-aiplane*.

.. note::

    In this tutorial, we will use indifferently the words "action" and "operator" (though in planning community, actions
    are ground operators, i.e., operator where variables are replaced by constants).

**Load Truck Operator**

For instance, in the logistics domain, a truck can be loaded... And to load a truck, we need a package *pkg* and a truck
*truck* at a place *loc*. To load *pkg* in *truck*, these two objects must be at the same place *loc*. The effects of
loading *pkg* in *truck* are that *in(pkg, truck)* becomes true and *at(pkg, loc)* becomes false. Any other fact in the
current state does not change:

.. code-block:: text

    (:action load-truck
        :parameters (?pkg - package ?truck - truck ?loc - place)
        :precondition (and (at ?truck ?loc) (at ?pkg ?loc))
        :effect (and (not (at ?pkg ?loc)) (in ?pkg ?truck))
    )

**Load Airplane Operator**

Action/Operator :
  * **Description** : Load a package *pkg* in an airplane *airplane* at a place *loc*,
  * **Precondition** : *at(pkg, loc)* and *at(airplane, loc)* must be true,
  * **Effect** : *in(pkg, airplane)* becomes true and *at(airplane, loc)* becomes false.

In PDDL:

.. code-block:: text

    (:action load-airplane
        :parameters (?pkg - package ?airplane - airplane ?loc - place)
        :precondition (and (at ?pkg ?loc) (at ?airplane ?loc))
        :effect (and (not (at ?pkg ?loc)) (in ?pkg ?airplane))
    )

**Unload Truck Operator**

Action/Operator :
  * **Description** : Unload a package *pkg* in a truck *truck* at a place *loc*,
  * **Precondition** : *in(pkg, truck)* and *at(truc, loc)* must be true,
  * **Effect** : *at(pkg, loc)* becomes true and *in(pkg, truck)* becomes false.

In PDDL:

.. code-block:: text

    (:action unload-truck
        :parameters (?pkg - package ?truck - truck ?loc - place)
        :precondition (and (at ?truck ?loc) (in ?pkg ?truck))
        :effect (and (not (in ?pkg ?truck)) (at ?pkg ?loc))
    )

**Unload Airplane Operator**

Action/Operator :
  * **Description** : Unload a package *pkg* in an airplane *airplane* at a place *loc*,
  * **Precondition** : *in(pkg, airplane)* and *at(airplane, loc)* must be true,
  * **Effect** : *at(pkg, loc)* becomes true and *in(pkg, airplane)* becomes false.

In PDDL:

.. code-block:: text
    (:action unload-airplane
        :parameters (?pkg - package ?airplane - airplane ?loc - place)
        :precondition (and (in ?pkg ?airplane) (at ?airplane ?loc))
        :effect (and (not (in ?pkg ?airplane)) (at ?pkg ?loc))
    )

**Fly-airplane Operator**

Action/Operator :
    * **Description** : Fly airplane *pkg* from a location *loc-from* to a location *loc-to*,
    * **Precondition** : *at(pkg, loc-from)* must be true,
    * **Effect** : *at(pkg, loc-to)* becomes true and *at(p, loc-from)* becomes false.

In PDDL:

.. code-block:: text

    (:action fly-airplane
        :parameters (?airplane - airplane ?loc-from - airport ?loc-to - airport)
        :precondition (at ?airplane ?loc-from)
        :effect (and (not (at ?airplane ?loc-from)) (at ?airplane ?loc-to))
    )

**Drive-truck Operator**

Action/Operator :
    * **Description** : Drive truck *truck* from a location *loc-from* to a location *loc-to*,
    * **Precondition** : *at(truck, loc-from)* must be true,
    * **Effect** : *at(truck, loc-to)* becomes true and *at(truck, loc-from)* becomes false.

In PDDL:

.. code-block:: text

    (:action drive-truck
        :parameters (?truck - truck ?loc-from - place ?loc-to - place ?city - city)
        :precondition (and (at ?truck ?loc-from) (in-city ?loc-from ?city) (in-city ?loc-to ?city))
        :effect (and (not (at ?truck ?loc-from)) (at ?truck ?loc-to))
    )

.. note::

    * Action preconditions and effects can be more complicated than seen so far. They can be universally or existentially quantified using PDDL statement of the form ``(forall (?v1 ... ?vn) <effect >)``. In that case, specific requirements must be used, for instance ``:adl``.
    * They can be conditional : ``(when <condition > <effect >)``
    * Action They can have costs, duration, time constraints etc.


Defining the Problem
~~~~~~~~~~~~~~~~~~~~

Now, let define in the file ``problem.pddl`` a simple problem and its components :
    * the objects,
    * the initial state,
    * the goal to reach.

First, we have to define the name of the problem and indicate the domain associated with this problem:

In PDDL, we write :

.. code-block:: text

    (define (problem p01)
            (:domain logistics)

Objects
*******

In this example, we use the following objects:
  * A Truck : *truck*
  * An airplane: *airplane*
  * Two airports : *cdg*, *lhr*
  * Two places : *north*, *south*
  * Two cities : *london*, *paris*
  * Two packages : *p1*, *p2*

In PDDL, we write:

.. code-block:: text

    (:objects plane - airplane
        truck - truck
        cdg lhr - airport
        south north - location
        paris london - city
        p1 p2 - package
    )

.. note::

    The types of the object can be only the types defined in the domain or the type ``object``.

Initial State
*****************

The initial state is a set of ground predicates. A predicate is ground iff all the variables are bound to objects.
The ground predicates in the initial state represent true facts in this state. Any fact that is not represented in a
state is false: In our case:

.. code-block:: text

    (:init (in-city cdg paris)
        (in-city lhr london)
        (in-city north paris)
        (in-city south paris)
        (at plane lhr)
        (at truck cdg)
        (at p1 lhr)
        (at p2 lhr)
    )

Goal to achieve
***************

The goal is to have *at(p1, north)* and *at(p2, south)* in the final state (no matter the truth value of the other
predicates). In PDDL, we write:

.. code-block:: text

    (:goal (and (at p1 north)
        (at p2 south))
    )

..  note::

The domain and problem files of this logistics running example are available here:
    * `logistics.pddl <resources/logistics.pddl>`_
    * `problem.pddl <resources/problem.pddl>`_



#### TODO: Run the example using the binary distribution of PDD4J:

   1. Open a terminal
   2. Check that java 8 is installed:
   ```
   > java -version
   ```
   If java 8 is not installed, follow this [link](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

   3. Create a directory called PDDL4J:
   ```
   > mkdir pddl4j
   ```
   4. Go to the directory:
   ```
   > cd pddl4j
   ```
   5. Download the binary:
   ```
   > wget http://pddl4j.imag.fr/repository/pddl4j/binaries/pddl4j-VERSION.jar
   ```
   6. Download the domain file:
   ```
   > wget http://pddl4j.imag.fr/repository/wiki/logistics.pddl
   ```
   7. Download the problem file:
   ```
   > wget http://pddl4j.imag.fr/repository/wiki/problem.pddl
   ```
   8. Test the example:
   ```
   > java -javaagent:build/libs/pddl4j-3.7.1.jar -server -Xms2048m -Xmx2048m \\
          fr.uga.pddl4j.planners.statespace.StateSpacePlannerFactory \\
          -o logistics.pddl -f problem.pddl
   ```

  * The JVM (Java Virtual Machine) arguments:
       * ```-javaagent``` allows to get information on the memory usage of the planner
       * ```-XMS``` and  ```-XMX``` allow to set the maximum heap size and the maximum memory size that can be used by the JVM

The result will be:
  ```
parsing domain file "logistics.pddl" done successfully
parsing problem file "problem.pddl" done successfully

encoding problem done successfully (28 ops, 17 facts)

found plan as follows:

00: (        loadd-airplane p1 plane lhr) [1]
01: (        loadd-airplane p2 plane lhr) [1]
02: (         fly-airplane plane lhr cdg) [1]
03: (       unload-airplane p1 plane cdg) [1]
04: (       unload-airplane p2 plane cdg) [1]
05: (            load-truck p1 truck cdg) [1]
06: (            load-truck p2 truck cdg) [1]
07: (  drive-truck truck cdg south paris) [1]
08: (        unload-truck p2 truck south) [1]
09: (drive-truck truck south north paris) [1]
10: (        unload-truck p1 truck north) [1]

plan total cost: 11,00

time spent:   0,09 seconds parsing
                0,03 seconds encoding
                0,01 seconds searching
                0,13 seconds total time

memory used:  0,02 MBytes for problem representation
                0,01 MBytes for searching
                0,03 MBytes total

```
***

.. _industrial_use_case_section:

Industrial Use Case
-------------------




.. note::
    To go further, we recommand the reader to refer to this `good resource on PDDL <https://planning.wiki/>`_

