(define (problem rsc_easy)
  (:domain rsc)
  (:objects
    unit1 stocker - unit
    conv1 - conveyor
    robot1 - robot

    tray1 - tray
    piece1 - piece

    op10 op20 op30 - operation
  )

  (:init
    ;;Operation schedule

    (start op10 tray1)
    (todo op10 op20 tray1)
    (todo op20 op30 tray1)
    (todo op30 stop tray1)

    ;;Initiate piece / tray
    (piece_on piece1 tray1)

    (tray_on_unit tray1 stocker)

    ;;Initiate robot
    (robot_at robot1 stocker)
    (robot_available robot1)

    ;;Initiate conveyor
    (conveyor_unit conv1 unit1)


    ;;Setup unit
    (unit_accepted_piece piece1 unit1)
    (unit_accepted_piece piece1 stocker)
    (unit_operation op10 unit1)
    (unit_operation op20 unit1)
    (unit_operation op30 unit1)


    (unit_available unit1)


    ;;Setup conveyor
    (conveyor_accepted_piece piece1 conv1)
    (conveyor_available conv1)


    ;;Setup robot
    (robot_available robot1)
  )

  (:goal (and (tray_completed tray1)
              )
  )
)
