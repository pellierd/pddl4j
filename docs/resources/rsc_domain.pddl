;;
;;  Domain ________________
;;  |                      |
;;  | Robotic supply chain |
;;  |______________________|
;;

(define (domain RSC)

;; Defining options for the planning system
(:requirements :adl :typing)

;; Defining types
(:types
  robot - agent
  conveyor unit - location
  piece operation tray - object
)

(:constants
      stop - operation
)

(:predicates
    ;robot
    (robot_available ?robot - robot)
    ;; is the robot available? capacity is one
    (robot_at ?robot - robot ?l - location)
    ;; location of a robot. Either a conveyor or a unit

    ;conveyor
    (conveyor_accepted_piece ?piece - piece ?conv - conveyor)
    ;; constraint on admissible pieces
    (conveyor_available ?conv - conveyor)
    ;; is the conveyor available? capacity is one
    (conveyor_unit ?conv - conveyor ?unit - unit)
    ;; "one-to-many" relation between units and conveyors

    ;unit
    (unit_accepted_piece ?piece - piece ?unit - unit)
    ;; constraint on admissible pieces
    (unit_available ?unit - unit)
    ;; is the unit available? unit capacity is one
    (unit_operation ?op - operation ?unit - unit)
    ;; operation provided by the unit

    ;tray
    (tray_on_unit ?tray - tray ?unit - unit)
    ;; the tray is in the unit ***
    (tray_on_conv ?tray - tray ?conv - conveyor)
    ;; the tray is input into the conveyor
    (tray_on_robot ?tray - tray ?robot - robot)
    ;; the robot is at the tray
    (tray_completed ?tray - tray)
    ;; all the scheduled operations are completed

    ;piece
    (piece_on ?piece - piece ?tray - tray)
    ;; "one-to-one" relation: trays contain only one type of pieces

    ;stack of operations
    (start ?op - operation ?tray - tray)
    ;; ?op is on top of the stack.
    ;; The stack has a one-to-one relation with the tray (same id)
    (todo ?opontop - operation ?nextop - operation ?tray - tray)
    ;; linked list of operations: ?nextop follows ?opontop. Last operation is stop
  )


(:action pickup_tray_on_unit
    :parameters (?robot - robot ?unit - unit ?tray - tray)
    :precondition (and (robot_available ?robot)
                       (robot_at ?robot ?unit)
                       (tray_on_unit ?tray ?unit)
                  )
    :effect (and (not (tray_on_unit ?tray ?unit))
                 (not (robot_available ?robot))
                 (tray_on_robot ?tray ?robot)
                 (unit_available ?unit)
            )
  )

(:action drop_tray_on_conveyor
    :parameters (?robot - robot ?conv - conveyor ?tray - tray ?piece - piece)
    :precondition (and (conveyor_available ?conv)
                       (robot_at ?robot ?conv)
                       (tray_on_robot ?tray ?robot)
                       (conveyor_accepted_piece ?piece ?conv)
                       (piece_on ?piece ?tray)
                  )
    :effect (and (not (conveyor_available ?conv))
                 (not (tray_on_robot ?tray ?robot))
                 (tray_on_conv ?tray ?conv)
                 (robot_available ?robot))
  )

(:action robot_move
    :parameters (?robot - robot ?from - location ?to - location)
    :precondition (and (robot_at ?robot ?from))
    :effect (and (robot_at ?robot ?to) (not (robot_at ?robot ?from)))
)

(:action conveyor_load_tray_in_unit
    :parameters (?conv - conveyor ?unit - unit ?tray - tray ?piece - piece)
    :precondition (and (unit_available ?unit)
                       (conveyor_unit ?conv ?unit)
                       (unit_accepted_piece ?piece ?unit)
                       (piece_on ?piece ?tray)
                       (tray_on_conv ?tray ?conv)
                  )
    :effect (and (not (tray_on_conv ?tray ?conv))
                 (not (unit_available ?unit))
                 (tray_on_unit ?tray ?unit)
                 (conveyor_available ?conv))
)

(:action unit_execute_operation
    :parameters (?unit - unit ?top - operation ?next - operation ?tray - tray)
    :precondition (and (unit_operation ?top ?unit)
                       (tray_on_unit ?tray ?unit)
                       (start ?top ?tray)
                       (todo ?top ?next ?tray)
                  )
    :effect (and
                 (start ?next ?tray)
                 (not (todo ?top ?next ?tray))
                 (not (start ?top ?tray))
            )
)

(:action tray_completed
    :parameters (?op - operation ?tray - tray ?unit - unit)
    :precondition (and (start stop ?tray)
                       (tray_on_unit ?tray ?unit)
                  )
    :effect (and (tray_completed ?tray)
                 (unit_available ?unit)
                 (not (tray_on_unit ?tray ?unit)))
)
)
