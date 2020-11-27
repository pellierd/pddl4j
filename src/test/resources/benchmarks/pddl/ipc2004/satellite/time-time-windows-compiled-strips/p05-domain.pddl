
(define (domain satellite)
  (:requirements :strips :equality :typing :numeric-fluents :durative-actions)
(:types satellite antenna direction instrument mode)


(:constants
	satellite0 - satellite
	satellite1 - satellite
	satellite2 - satellite
        antenna0 - antenna
        antenna1 - antenna

)

(:predicates
               (on_board ?i - instrument ?s - satellite)
	       (supports ?i - instrument ?m - mode)
	       (pointing ?s - satellite ?d - direction)
	       (power_avail ?s - satellite)
	       (power_on ?i - instrument)
	       (calibrated ?i - instrument)
	       (have_image ?d - direction ?m - mode)
	       (calibration_target ?i - instrument ?d - direction)
               (available ?a - antenna)
               (visible ?a - antenna ?s - satellite)
               (sent_image ?d - direction ?m - mode)
               (TLstart)
               (TLstarted)
               (TLend)
               (TLrunning)
               (TL0)
               (TL1)
               (TL2)
               (TL3)
)



  (:functions (slew_time ?a ?b - direction)
            (calibration_time ?a - instrument ?d - direction)
            (send_time ?d - direction ?m - mode)
	)



  (:durative-action turn_to
   :parameters (?s - satellite ?d_new - direction ?d_prev - direction)
   :duration (= ?duration (slew_time ?d_prev ?d_new))
   :condition (and (at start (TLstarted)) (at start (pointing ?s ?d_prev))
              )
   :effect (and  (at end (pointing ?s ?d_new))
                 (at start (not (pointing ?s ?d_prev)))
           )
  )


  (:durative-action switch_on
   :parameters (?i - instrument ?s - satellite)
   :duration (= ?duration 2)
   :condition (and (at start (TLstarted)) (over all (on_board ?i ?s))
                      (at start (power_avail ?s)))
   :effect (and (at end (power_on ?i))
                (at start (not (calibrated ?i)))
                (at start (not (power_avail ?s)))
           )

  )


  (:durative-action switch_off
   :parameters (?i - instrument ?s - satellite)
   :duration (= ?duration 1)
   :condition (and (at start (TLstarted)) (over all (on_board ?i ?s))
                      (at start (power_on ?i))
                  )
   :effect (and (at start (not (power_on ?i)))
                (at end (power_avail ?s))
           )
  )

  (:durative-action calibrate
   :parameters (?s - satellite ?i - instrument ?d - direction)
   :duration (= ?duration (calibration_time ?i ?d))
   :condition (and (at start (TLstarted)) (over all (on_board ?i ?s))
		      (over all (calibration_target ?i ?d))
                      (at start (pointing ?s ?d))
                      (over all (power_on ?i))
                      (at end (power_on ?i))
                  )
   :effect (at end (calibrated ?i))
  )


  (:durative-action take_image
   :parameters (?s - satellite ?d - direction ?i - instrument ?m - mode)
   :duration (= ?duration 7)
   :condition (and (at start (TLstarted)) (over all (calibrated ?i))
                      (over all (on_board ?i ?s))
                      (over all (supports ?i ?m) )
                      (over all (power_on ?i))
                      (over all (pointing ?s ?d))
                      (at end (power_on ?i))
               )
   :effect (at end (have_image ?d ?m))
  )


  (:durative-action send_image
   :parameters (?s - satellite ?a - antenna ?d - direction ?m - mode)
   :duration (= ?duration (send_time ?d ?m))
   :condition (and (at start (TLstarted)) (at start (have_image ?d ?m))
                   (at start (available ?a))
                   (over all (visible ?a ?s))
               )
   :effect (and (at end (sent_image ?d ?m))
                (at start (not (available ?a)))
                (at end (available ?a)))
  )

(:durative-action timedliteralwrapper
 :parameters ()
 :duration (= ?duration 236.04)
 :condition
        (and (at start (TLstart)))
 :effect
        (and (at start (not (TLstart))) (at start (TLstarted)) (at start (TL0))
             (at start (TLrunning)) (at end (not (TLrunning)))))

(:durative-action timedliteral1
 :parameters ()
 :duration (= ?duration 117.00)
 :condition
        (and (over all (TLrunning)) (over all (TL0)))
 :effect
        (and (at end (TL1)) (at end (not (TL0)))
        (at end (visible antenna0 satellite2))
        (at end (visible antenna0 satellite1))
        (at end (visible antenna0 satellite0))
))

(:durative-action timedliteral2
 :parameters ()
 :duration (= ?duration 39.00)
 :condition
        (and (over all (TLrunning)) (over all (TL1)))
 :effect
        (and (at end (TL2)) (at end (not (TL1)))
        (at end (visible antenna1 satellite2))
        (at end (visible antenna1 satellite1))
))

(:durative-action timedliteral3
 :parameters ()
 :duration (= ?duration 41.04)
 :condition
        (and (over all (TLrunning)) (over all (TL2)))
 :effect
        (and (at end (TL3)) (at end (not (TL2)))
        (at end (not (visible antenna0 satellite2)))
        (at end (not (visible antenna0 satellite1)))
        (at end (not (visible antenna0 satellite0)))
))

(:durative-action timedliteral4
 :parameters ()
 :duration (= ?duration 39.00)
 :condition
        (and (over all (TLrunning)) (over all (TL3)))
 :effect
        (and (at end (TLend)) (at end (not (TL3)))
        (at end (not (visible antenna1 satellite2)))
        (at end (not (visible antenna1 satellite1)))
))


)

