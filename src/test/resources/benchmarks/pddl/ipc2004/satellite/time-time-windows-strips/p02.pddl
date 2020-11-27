(define (problem strips-sat-x-1)
(:domain satellite)
(:objects
	satellite0 - satellite
	instrument0 - instrument
	instrument1 - instrument
	infrared0 - mode
	infrared1 - mode
	image2 - mode
	GroundStation1 - direction
	Star0 - direction
	GroundStation2 - direction
	Planet3 - direction
	Planet4 - direction
	Phenomenon5 - direction
	Phenomenon6 - direction
	Star7 - direction
        antenna0 - antenna
        antenna1 - antenna
)
(:init
	(supports instrument0 infrared1)
	(supports instrument0 infrared0)
	(calibration_target instrument0 Star0)
	(= (calibration_time instrument0 Star0) 22.2)
	(supports instrument1 image2)
	(supports instrument1 infrared1)
	(supports instrument1 infrared0)
	(calibration_target instrument1 GroundStation2)
	(= (calibration_time instrument1 GroundStation2) 5.54)
	(on_board instrument0 satellite0)
	(on_board instrument1 satellite0)
	(power_avail satellite0)
	(pointing satellite0 Planet4)
	(= (slew_time GroundStation1 Star0) 45.75)
	(= (slew_time Star0 GroundStation1) 45.75)
	(= (slew_time GroundStation2 Star0) 82.61)
	(= (slew_time Star0 GroundStation2) 82.61)
	(= (slew_time GroundStation2 GroundStation1) 42.92)
	(= (slew_time GroundStation1 GroundStation2) 42.92)
	(= (slew_time Planet3 Star0) 13.67)
	(= (slew_time Star0 Planet3) 13.67)
	(= (slew_time Planet3 GroundStation1) 17.46)
	(= (slew_time GroundStation1 Planet3) 17.46)
	(= (slew_time Planet3 GroundStation2) 17.26)
	(= (slew_time GroundStation2 Planet3) 17.26)
	(= (slew_time Planet4 Star0) 1.204)
	(= (slew_time Star0 Planet4) 1.204)
	(= (slew_time Planet4 GroundStation1) 14.4)
	(= (slew_time GroundStation1 Planet4) 14.4)
	(= (slew_time Planet4 GroundStation2) 58.98)
	(= (slew_time GroundStation2 Planet4) 58.98)
	(= (slew_time Planet4 Planet3) 30.65)
	(= (slew_time Planet3 Planet4) 30.65)
	(= (slew_time Phenomenon5 Star0) 78.77)
	(= (slew_time Star0 Phenomenon5) 78.77)
	(= (slew_time Phenomenon5 GroundStation1) 5.136)
	(= (slew_time GroundStation1 Phenomenon5) 5.136)
	(= (slew_time Phenomenon5 GroundStation2) 39.44)
	(= (slew_time GroundStation2 Phenomenon5) 39.44)
	(= (slew_time Phenomenon5 Planet3) 21.54)
	(= (slew_time Planet3 Phenomenon5) 21.54)
	(= (slew_time Phenomenon5 Planet4) 15.48)
	(= (slew_time Planet4 Phenomenon5) 15.48)
	(= (slew_time Phenomenon6 Star0) 87.81)
	(= (slew_time Star0 Phenomenon6) 87.81)
	(= (slew_time Phenomenon6 GroundStation1) 75.13)
	(= (slew_time GroundStation1 Phenomenon6) 75.13)
	(= (slew_time Phenomenon6 GroundStation2) 25.11)
	(= (slew_time GroundStation2 Phenomenon6) 25.11)
	(= (slew_time Phenomenon6 Planet3) 26.25)
	(= (slew_time Planet3 Phenomenon6) 26.25)
	(= (slew_time Phenomenon6 Planet4) 82.99)
	(= (slew_time Planet4 Phenomenon6) 82.99)
	(= (slew_time Phenomenon6 Phenomenon5) 36.47)
	(= (slew_time Phenomenon5 Phenomenon6) 36.47)
	(= (slew_time Star7 Star0) 30.66)
	(= (slew_time Star0 Star7) 30.66)
	(= (slew_time Star7 GroundStation1) 1.386)
	(= (slew_time GroundStation1 Star7) 1.386)
	(= (slew_time Star7 GroundStation2) 50)
	(= (slew_time GroundStation2 Star7) 50)
	(= (slew_time Star7 Planet3) 80.6)
	(= (slew_time Planet3 Star7) 80.6)
	(= (slew_time Star7 Planet4) 67.21)
	(= (slew_time Planet4 Star7) 67.21)
	(= (slew_time Star7 Phenomenon5) 20.97)
	(= (slew_time Phenomenon5 Star7) 20.97)
	(= (slew_time Star7 Phenomenon6) 29.32)
	(= (slew_time Phenomenon6 Star7) 29.32)

        (= (send_time planet3 infrared0) 5.14)
        (= (send_time planet4 infrared0) 8.38)
        (= (send_time phenomenon5 image2) 16.52)
        (= (send_time star7 infrared0) 18.51)
        (= (send_time phenomenon6 infrared0) 16.25)

        (at 123.00 (visible antenna0 satellite0))
        (at 203.04 (not (visible antenna0 satellite0)))
        (at 160.00 (visible antenna1 satellite0))
        (at 240.04 (not (visible antenna1 satellite0)))

        (available antenna0)
        (available antenna1)
)
(:goal (and
	(sent_image Planet3 infrared0)
	(sent_image Planet4 infrared0)
	(sent_image Phenomenon5 image2)
	(sent_image Phenomenon6 infrared0)
	(sent_image Star7 infrared0)
))
(:metric minimize (total-time))

)
