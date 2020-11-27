(define (problem strips-sat-x-1)
(:domain satellite)
(:objects
	satellite0 - satellite
	instrument0 - instrument
	instrument1 - instrument
	instrument2 - instrument
	satellite1 - satellite
	instrument3 - instrument
	image1 - mode
	infrared0 - mode
	spectrograph2 - mode
	Star1 - direction
	Star2 - direction
	Star0 - direction
	Star3 - direction
	Star4 - direction
	Phenomenon5 - direction
	Phenomenon6 - direction
	Phenomenon7 - direction
        antenna0 - antenna
)
(:init
	(supports instrument0 spectrograph2)
	(supports instrument0 infrared0)
	(calibration_target instrument0 Star1)
	(= (calibration_time instrument0 Star1) 37.3)
	(supports instrument1 image1)
	(calibration_target instrument1 Star2)
	(= (calibration_time instrument1 Star2) 15.9)
	(supports instrument2 infrared0)
	(supports instrument2 image1)
	(calibration_target instrument2 Star0)
	(= (calibration_time instrument2 Star0) 38.1)
	(on_board instrument0 satellite0)
	(on_board instrument1 satellite0)
	(on_board instrument2 satellite0)
	(power_avail satellite0)
	(pointing satellite0 Star4)
	(supports instrument3 spectrograph2)
	(supports instrument3 infrared0)
	(supports instrument3 image1)
	(calibration_target instrument3 Star0)
	(= (calibration_time instrument3 Star0) 16.9)
	(on_board instrument3 satellite1)
	(power_avail satellite1)
	(pointing satellite1 Star0)
	(= (slew_time Star1 Star0) 34.35)
	(= (slew_time Star0 Star1) 34.35)
	(= (slew_time Star2 Star0) 8.768)
	(= (slew_time Star0 Star2) 8.768)
	(= (slew_time Star2 Star1) 18.57)
	(= (slew_time Star1 Star2) 18.57)
	(= (slew_time Star3 Star0) 25.66)
	(= (slew_time Star0 Star3) 25.66)
	(= (slew_time Star3 Star1) 25.96)
	(= (slew_time Star1 Star3) 25.96)
	(= (slew_time Star3 Star2) 17.99)
	(= (slew_time Star2 Star3) 17.99)
	(= (slew_time Star4 Star0) 71.99)
	(= (slew_time Star0 Star4) 71.99)
	(= (slew_time Star4 Star1) 1.526)
	(= (slew_time Star1 Star4) 1.526)
	(= (slew_time Star4 Star2) 35.34)
	(= (slew_time Star2 Star4) 35.34)
	(= (slew_time Star4 Star3) 49.61)
	(= (slew_time Star3 Star4) 49.61)
	(= (slew_time Phenomenon5 Star0) 67.92)
	(= (slew_time Star0 Phenomenon5) 67.92)
	(= (slew_time Phenomenon5 Star1) 4.095)
	(= (slew_time Star1 Phenomenon5) 4.095)
	(= (slew_time Phenomenon5 Star2) 30.24)
	(= (slew_time Star2 Phenomenon5) 30.24)
	(= (slew_time Phenomenon5 Star3) 7.589)
	(= (slew_time Star3 Phenomenon5) 7.589)
	(= (slew_time Phenomenon5 Star4) 0.5297)
	(= (slew_time Star4 Phenomenon5) 0.5297)
	(= (slew_time Phenomenon6 Star0) 77.1)
	(= (slew_time Star0 Phenomenon6) 77.1)
	(= (slew_time Phenomenon6 Star1) 47.3)
	(= (slew_time Star1 Phenomenon6) 47.3)
	(= (slew_time Phenomenon6 Star2) 64.11)
	(= (slew_time Star2 Phenomenon6) 64.11)
	(= (slew_time Phenomenon6 Star3) 51.56)
	(= (slew_time Star3 Phenomenon6) 51.56)
	(= (slew_time Phenomenon6 Star4) 56.36)
	(= (slew_time Star4 Phenomenon6) 56.36)
	(= (slew_time Phenomenon6 Phenomenon5) 67.57)
	(= (slew_time Phenomenon5 Phenomenon6) 67.57)
	(= (slew_time Phenomenon7 Star0) 9.943)
	(= (slew_time Star0 Phenomenon7) 9.943)
	(= (slew_time Phenomenon7 Star1) 13.3)
	(= (slew_time Star1 Phenomenon7) 13.3)
	(= (slew_time Phenomenon7 Star2) 60.53)
	(= (slew_time Star2 Phenomenon7) 60.53)
	(= (slew_time Phenomenon7 Star3) 53.93)
	(= (slew_time Star3 Phenomenon7) 53.93)
	(= (slew_time Phenomenon7 Star4) 67.87)
	(= (slew_time Star4 Phenomenon7) 67.87)
	(= (slew_time Phenomenon7 Phenomenon5) 43.97)
	(= (slew_time Phenomenon5 Phenomenon7) 43.97)
	(= (slew_time Phenomenon7 Phenomenon6) 32.34)
	(= (slew_time Phenomenon6 Phenomenon7) 32.34)

        (= (send_time phenomenon7 spectrograph2) 5.76)
        (= (send_time star4 spectrograph2) 10.76)
        (= (send_time phenomenon5 spectrograph2) 5.87)
        (= (send_time star3 infrared0) 18.38)


        (available antenna0)
        (TLstart)
)
(:goal (and
        (TLend)
	(pointing satellite0 Phenomenon5)
	(sent_image Star3 infrared0)
	(sent_image Star4 spectrograph2)
	(sent_image Phenomenon5 spectrograph2)
	(sent_image Phenomenon7 spectrograph2)
))
(:metric minimize (total-time))

)
