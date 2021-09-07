(define (problem rsc_hard)
  (:domain rsc)
  (:objects
    unit1 unit2 unit3 unit4 - unit
    conv1 conv2 conv3 conv4 conv5 conv6 conv7 conv8 stocker_conveyor - conveyor
    robot1 - robot

    tray26 tray27 tray28 tray29 tray30 tray31 tray32 tray33 tray34 tray35 tray36 - tray
    piece1 piece2 piece3 piece4 piece5 - piece

    op10 op20 op30 - operation
  )

  (:init
    ;;Operation schedule

    (start op10 tray26)
    (todo op10 op20 tray26)
    (todo op20 op30 tray26)
    (todo op30 stop tray26)

    (start op10 tray27)
    (todo op10 op20 tray27)
    (todo op20 op30 tray27)
    (todo op30 stop tray27)

    (start op20 tray28)
    (todo op20 op30 tray28)
    (todo op30 stop tray28)

    (start op20 tray29)
    (todo op20 op30 tray29)
    (todo op30 stop tray29)

    (start op10 tray30)
    (todo op10 op20 tray30)
    (todo op20 op30 tray30)
    (todo op30 stop tray30)

    (start op10 tray31)
    (todo op10 op20 tray31)
    (todo op20 op30 tray31)
    (todo op30 stop tray31)

    (start op10 tray32)
    (todo op10 op20 tray32)
    (todo op20 op30 tray32)
    (todo op30 stop tray32)

    (start op30 tray33)
    (todo op30 stop tray33)

    (start op30 tray34)
    (todo op30 stop tray34)

    (start op30 tray35)
    (todo op30 stop tray35)

    (start op30 tray36)
    (todo op30 stop tray36)

    ;;Initiate piece / tray
    (piece_on piece1 tray26)
    (piece_on piece1 tray27)
    (piece_on piece2 tray28)
    (piece_on piece2 tray29)
    (piece_on piece3 tray30)
    (piece_on piece1 tray31)
    (piece_on piece1 tray32)
    (piece_on piece4 tray33)
    (piece_on piece4 tray34)
    (piece_on piece5 tray35)
    (piece_on piece5 tray36)

    (tray_on_unit tray26 unit4)
    (tray_on_unit tray27 unit4)
    (tray_on_unit tray28 unit4)
    (tray_on_unit tray29 unit4)
    (tray_on_unit tray30 unit4)
    (tray_on_unit tray31 unit4)
    (tray_on_unit tray32 unit4)
    (tray_on_unit tray33 unit4)
    (tray_on_unit tray34 unit4)
    (tray_on_unit tray35 unit4)
    (tray_on_unit tray36 unit4)

    ;;Initiate robot
    (robot_at robot1 unit4)

    ;;Initiate conveyor
    (conveyor_unit conv1 unit1)
    (conveyor_unit conv2 unit1)
    (conveyor_unit conv3 unit2)
    (conveyor_unit conv4 unit2)
    (conveyor_unit conv5 unit2)
    (conveyor_unit conv6 unit3)
    (conveyor_unit conv7 unit3)
    (conveyor_unit conv8 unit4)

    ;;Initiate unit
    (unit_operation op10 unit1)
    (unit_operation op20 unit2)
    (unit_operation op30 unit3)

    ;;Setup unit
    (unit_accepted_piece piece1 unit1)
    (unit_accepted_piece piece2 unit1)
    (unit_accepted_piece piece3 unit1)
    (unit_accepted_piece piece4 unit1)
    (unit_accepted_piece piece5 unit1)

    (unit_accepted_piece piece1 unit2)
    (unit_accepted_piece piece2 unit2)
    (unit_accepted_piece piece3 unit2)
    (unit_accepted_piece piece4 unit2)
    (unit_accepted_piece piece5 unit2)

    (unit_accepted_piece piece1 unit3)
    (unit_accepted_piece piece2 unit3)
    (unit_accepted_piece piece3 unit3)
    (unit_accepted_piece piece4 unit3)
    (unit_accepted_piece piece5 unit3)

    (unit_accepted_piece piece1 unit4)
    (unit_accepted_piece piece2 unit4)
    (unit_accepted_piece piece3 unit4)
    (unit_accepted_piece piece4 unit4)
    (unit_accepted_piece piece5 unit4)

    (unit_available unit1)
    (unit_available unit2)
    (unit_available unit3)
    (unit_available unit4)

    ;;Setup conveyor
    (conveyor_accepted_piece piece1 conv1)
    (conveyor_accepted_piece piece2 conv1)
    (conveyor_accepted_piece piece3 conv1)
    (conveyor_accepted_piece piece4 conv1)

    (conveyor_accepted_piece piece2 conv2)
    (conveyor_accepted_piece piece3 conv2)
    (conveyor_accepted_piece piece4 conv2)
    (conveyor_accepted_piece piece5 conv2)

    (conveyor_accepted_piece piece2 conv3)
    (conveyor_accepted_piece piece3 conv3)
    (conveyor_accepted_piece piece4 conv3)
    (conveyor_accepted_piece piece5 conv3)

    (conveyor_accepted_piece piece2 conv4)
    (conveyor_accepted_piece piece3 conv4)
    (conveyor_accepted_piece piece4 conv4)
    (conveyor_accepted_piece piece5 conv4)

    (conveyor_accepted_piece piece1 conv5)

    (conveyor_accepted_piece piece1 conv6)
    (conveyor_accepted_piece piece2 conv6)
    (conveyor_accepted_piece piece3 conv6)

    (conveyor_accepted_piece piece4 conv7)
    (conveyor_accepted_piece piece5 conv7)

    (conveyor_accepted_piece piece1 conv8)
    (conveyor_accepted_piece piece2 conv8)
    (conveyor_accepted_piece piece3 conv8)
    (conveyor_accepted_piece piece4 conv8)
    (conveyor_accepted_piece piece5 conv8)

    (conveyor_available conv1)
    (conveyor_available conv2)
    (conveyor_available conv3)
    (conveyor_available conv4)
    (conveyor_available conv5)
    (conveyor_available conv6)
    (conveyor_available conv7)
    (conveyor_available conv8)


    ;;Setup robot
    (robot_available robot1)
  )

  (:goal (and (tray_completed tray26)
              (tray_completed tray27)
              (tray_completed tray28)
              (tray_completed tray29)
              (tray_completed tray30)
              (tray_completed tray31)
              ;;(tray_completed tray32)
              ;;(tray_completed tray33)
              ;;(tray_completed tray34)
              ;;(tray_completed tray35)
              ;;(tray_completed tray36)
              )
  )
)
