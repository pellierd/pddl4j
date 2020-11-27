(define (problem strips-sat-x-1)
(:domain satellite)
(:objects
	satellite0 - satellite
	instrument0 - instrument
	image1 - mode
	spectrograph2 - mode
	thermograph0 - mode
	Star0 - direction
	GroundStation1 - direction
	GroundStation2 - direction
	Phenomenon3 - direction
	Phenomenon4 - direction
	Star5 - direction
	Phenomenon6 - direction
        antenna0 - antenna
)
(:init
	(supports instrument0 thermograph0)
	(calibration_target instrument0 GroundStation2)
	(= (calibration_time instrument0 GroundStation2) 5.9)
	(on_board instrument0 satellite0)
	(power_avail satellite0)
	(pointing satellite0 Phenomenon6)
	(= (slew_time GroundStation1 Star0) 18.17)
	(= (slew_time Star0 GroundStation1) 18.17)
	(= (slew_time GroundStation2 Star0) 38.61)
	(= (slew_time Star0 GroundStation2) 38.61)
	(= (slew_time GroundStation2 GroundStation1) 68.04)
	(= (slew_time GroundStation1 GroundStation2) 68.04)
	(= (slew_time Phenomenon3 Star0) 14.29)
	(= (slew_time Star0 Phenomenon3) 14.29)
	(= (slew_time Phenomenon3 GroundStation1) 89.48)
	(= (slew_time GroundStation1 Phenomenon3) 89.48)
	(= (slew_time Phenomenon3 GroundStation2) 33.94)
	(= (slew_time GroundStation2 Phenomenon3) 33.94)
	(= (slew_time Phenomenon4 Star0) 35.01)
	(= (slew_time Star0 Phenomenon4) 35.01)
	(= (slew_time Phenomenon4 GroundStation1) 31.79)
	(= (slew_time GroundStation1 Phenomenon4) 31.79)
	(= (slew_time Phenomenon4 GroundStation2) 39.73)
	(= (slew_time GroundStation2 Phenomenon4) 39.73)
	(= (slew_time Phenomenon4 Phenomenon3) 25.72)
	(= (slew_time Phenomenon3 Phenomenon4) 25.72)
	(= (slew_time Star5 Star0) 36.56)
	(= (slew_time Star0 Star5) 36.56)
	(= (slew_time Star5 GroundStation1) 8.59)
	(= (slew_time GroundStation1 Star5) 8.59)
	(= (slew_time Star5 GroundStation2) 62.86)
	(= (slew_time GroundStation2 Star5) 62.86)
	(= (slew_time Star5 Phenomenon3) 10.18)
	(= (slew_time Phenomenon3 Star5) 10.18)
	(= (slew_time Star5 Phenomenon4) 64.5)
	(= (slew_time Phenomenon4 Star5) 64.5)
	(= (slew_time Phenomenon6 Star0) 77.07)
	(= (slew_time Star0 Phenomenon6) 77.07)
	(= (slew_time Phenomenon6 GroundStation1) 17.63)
	(= (slew_time GroundStation1 Phenomenon6) 17.63)
	(= (slew_time Phenomenon6 GroundStation2) 50.73)
	(= (slew_time GroundStation2 Phenomenon6) 50.73)
	(= (slew_time Phenomenon6 Phenomenon3) 14.75)
	(= (slew_time Phenomenon3 Phenomenon6) 14.75)
	(= (slew_time Phenomenon6 Phenomenon4) 2.098)
	(= (slew_time Phenomenon4 Phenomenon6) 2.098)
	(= (slew_time Phenomenon6 Star5) 29.32)
	(= (slew_time Star5 Phenomenon6) 29.32)

        (= (send_time phenomenon4 thermograph0) 19.52)
        (= (send_time phenomenon6 thermograph0) 6.00)
        (= (send_time star5 thermograph0) 12.17)

        (at 139.00 (visible antenna0 satellite0))
        (at 219.04 (not (visible antenna0 satellite0)))

        (available antenna0)
)
(:goal (and
	(sent_image Phenomenon4 thermograph0)
	(sent_image Star5 thermograph0)
	(sent_image Phenomenon6 thermograph0)
))
(:metric minimize (total-time))

)
