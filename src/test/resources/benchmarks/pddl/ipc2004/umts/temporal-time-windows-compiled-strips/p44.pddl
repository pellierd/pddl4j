;; The execution of mobile applications requires a proper configuration
;; of mobile network components. This domain is modeled with 
;; resources of mobile network components and negotiation of MAC.
;; Applicable for 10 applications. The duration of an action is modeled
;; via the delay predicate. The delay varies for each application and
;; module according to their execution duration in the radio bearer/ network.

;; Intra-application constraint: yes
;; Inter-application constraint: no
;; Roman Englert, December 2003

(define (problem BS)
 (:domain INCOMPATIBEL-APPLICATION-CONFIGURATION)
 (:objects	
	MS1 MS2 - message
	A1 A2 A3 A4 A5 A6 A7 A8 A9 A10 - application
        M1 M2 M3 M4 M5 M6 M7 M8 M9 M10 - mobile
        L1 L2 L3 L4 L5 L6 L7 L8 L9 L10 - list
 )

 (:init
 	(= (time-trm A1) 75) 
	(= (time-ct A1) 49) 
	(= (time-am A1) 63) 
	(= (time-aeem A1) 62) 
	(= (time-rrc A1) 216) 
	(= (time-rab A1) 71) 
	(= (time-aeei A1) 47) 
	(= (time-bs A1) 35)

	(= (time-trm A2) 52) 
	(= (time-ct A2) 51) 
	(= (time-am A2) 31) 
	(= (time-aeem A2) 55) 
	(= (time-rrc A2) 177) 
	(= (time-rab A2) 80) 
	(= (time-aeei A2) 78) 
	(= (time-bs A2) 25) 

	(= (time-trm A3) 70) 
	(= (time-ct A3) 43) 
	(= (time-am A3) 36) 
	(= (time-aeem A3) 74) 
	(= (time-rrc A3) 183) 
	(= (time-rab A3) 77) 
	(= (time-aeei A3) 83) 
	(= (time-bs A3) 14) 

	(= (time-trm A4) 68) 
	(= (time-ct A4) 48) 
	(= (time-am A4) 34) 
	(= (time-aeem A4) 71) 
	(= (time-rrc A4) 178) 
	(= (time-rab A4) 77) 
	(= (time-aeei A4) 77) 
	(= (time-bs A4) 30)

	(= (time-trm A5) 59) 
	(= (time-ct A5) 52) 
	(= (time-am A5) 38) 
	(= (time-aeem A5) 77) 
	(= (time-rrc A5) 171) 
	(= (time-rab A5) 74) 
	(= (time-aeei A5) 79) 
	(= (time-bs A5) 25) 

 	(= (time-trm A6) 71) 
	(= (time-ct A6) 58) 
	(= (time-am A6) 69) 
	(= (time-aeem A6) 61) 
	(= (time-rrc A6) 205) 
	(= (time-rab A6) 75) 
	(= (time-aeei A6) 41) 
	(= (time-bs A6) 40)

	(= (time-trm A7) 56) 
	(= (time-ct A7) 59) 
	(= (time-am A7) 42) 
	(= (time-aeem A7) 62) 
	(= (time-rrc A7) 180) 
	(= (time-rab A7) 62) 
	(= (time-aeei A7) 71) 
	(= (time-bs A7) 21) 

	(= (time-trm A8) 54) 
	(= (time-ct A8) 58) 
	(= (time-am A8) 34) 
	(= (time-aeem A8) 66) 
	(= (time-rrc A8) 183) 
	(= (time-rab A8) 70) 
	(= (time-aeei A8) 72) 
	(= (time-bs A8) 11) 

	(= (time-trm A9) 61) 
	(= (time-ct A9) 44) 
	(= (time-am A9) 48) 
	(= (time-aeem A9) 64) 
	(= (time-rrc A9) 176) 
	(= (time-rab A9) 73) 
	(= (time-aeei A9) 80) 
	(= (time-bs A9) 12) 

	(= (time-trm A10) 51) 
	(= (time-ct A10) 51) 
	(= (time-am A10) 34) 
	(= (time-aeem A10) 78) 
	(= (time-rrc A10) 174) 
	(= (time-rab A10) 66) 
	(= (time-aeei A10) 83) 
	(= (time-bs A10) 20) 

        ;; types
        (location M1) 
	(authentification M1)
        (location M2) 
	(authentification M2)
        (location M3) 
	(authentification M3)
        (location M4) 
	(authentification M4)
        (location M5) 
	(authentification M5)
        (location M6) 
	(authentification M6)
        (location M7) 
	(authentification M7)
        (location M8) 
	(authentification M8)
        (location M9) 
	(authentification M9)
        (location M10) 
	(authentification M10)

	;; Game
	(initiated A1 M1) 
        (qos-params A1 L1)
	(= (list-pdu L1) 120)
 	(= (app-cpu A1 M1) 71) 
        (= (app-display A1 M1) 41) 
        (= (app-keyboard A1 M1) 1) 
        (= (app-energy A1 M1) 28) 
        (= (app-channels A1 M1) 1)
	(message-trm M1 MS1)
	(message-aeei A1 MS2)

 	;; Ticker
	(initiated A2 M1) 
        (qos-params A2 L2)
	(= (list-pdu L2) 60)
 	(= (app-cpu A2 M1) 13) 
        (= (app-display A2 M1) 10) 
        (= (app-keyboard A2 M1) 1) 
        (= (app-energy A2 M1) 11) 
        (= (app-channels A2 M1) 2)
	(message-aeei A2 MS2)

 	;; A3
	(initiated A3 M1) 
        (qos-params A3 L3)
	(= (list-pdu L3) 250)
 	(= (app-cpu A3 M1) 18) 
        (= (app-display A3 M1) 4) 
        (= (app-keyboard A3 M1) 1) 
        (= (app-energy A3 M1) 13) 
        (= (app-channels A3 M1) 1)
	(message-aeei A3 MS2)

 	;; A4
	(initiated A4 M1) 
	(qos-params A4 L4)
	(= (list-pdu L4) 248)
 	(= (app-cpu A4 M1) 1) 
	(= (app-display A4 M1) 6) 
	(= (app-keyboard A4 M1) 1) 
	(= (app-energy A4 M1) 18) 
	(= (app-channels A4 M1) 1)
	(message-aeei A4 MS2)

 	;; A5
	(initiated A5 M1) 
	(qos-params A5 L5)
	(= (list-pdu L5) 252)
 	(= (app-cpu A5 M1) 13) 
	(= (app-display A5 M1) 5) 
	(= (app-keyboard A5 M1) 1) 
	(= (app-energy A5 M1) 1) 
	(= (app-channels A5 M1) 2)
	(message-aeei A5 MS2)

 	;; A6
	(initiated A6 M1) 
	(qos-params A6 L6)
	(= (list-pdu L6) 250)
 	(= (app-cpu A6 M1) 18) 
	(= (app-display A6 M1) 1) 
	(= (app-keyboard A6 M1) 1) 
	(= (app-energy A6 M1) 13) 
	(= (app-channels A6 M1) 1)
	(message-aeei A6 MS2)

 	;; A7
	(initiated A7 M1) 
	(qos-params A7 L7)
	(= (list-pdu L7) 248)
 	(= (app-cpu A7 M1) 1) 
	(= (app-display A7 M1) 6) 
	(= (app-keyboard A7 M1) 1) 
	(= (app-energy A7 M1) 13) 
	(= (app-channels A7 M1) 1)
	(message-aeei A7 MS2)

 	;; A8
	(initiated A8 M1) 
	(qos-params A8 L8)
	(= (list-pdu L8) 252)
 	(= (app-cpu A8 M1) 13) 
	(= (app-display A8 M1) 5) 
	(= (app-keyboard A8 M1) 1) 
	(= (app-energy A8 M1) 1) 
	(= (app-channels A8 M1) 2)
	(message-aeei A8 MS2)

 	;; A9
	(initiated A9 M1) 
	(qos-params A9 L9)
	(= (list-pdu L9) 256)
 	(= (app-cpu A9 M1) 10) 
	(= (app-display A9 M1) 5) 
	(= (app-keyboard A9 M1) 1) 
	(= (app-energy A9 M1) 10) 
	(= (app-channels A9 M1) 1)
	(message-aeei A9 MS2)

 	;; A10
	(initiated A10 M1) 
	(qos-params A10 L10)
	(= (list-pdu L10) 256)
 	(= (app-cpu A10 M1) 10) 
	(= (app-display A10 M1) 5) 
	(= (app-keyboard A10 M1) 1) 
	(= (app-energy A10 M1) 5) 
	(= (app-channels A10 M1) 1)
	(message-aeei A10 MS2)
 
	;; TRM
	(= (max-mobile-cpu) 300)
	(= (max-d-available) 140)
	(= (max-k-available) 12)
	(= (max-e-load) 150)
	(= (max-mobile-channels-available) 12)
	;; CT
	(= (max-num-mobiles) 256)
	(= (max-num-calls) 10)
	(= (max-mobile-storage) 2000)
	;; RRC
	(= (max-logical-channels) 100)
	(= (max-cell-update) 10)
	(= (max-handover) 10)
	(= (max-active-set-up) 10)
	;; AEEI
	(= (max-ggsn-bitrate) 10000)
	(= (max-no-pdp) 20)
	(= (max-no-apn) 20)

  ;; current status

	(= (has-mobile-cpu) 0)
	(= (has-d-available) 0)
	(= (has-k-available) 0)
	(= (has-e-load) 0)
	(= (has-mobile-channels-available) 0)
	;; CT
	(= (has-num-mobiles) 0)
	(= (has-num-calls) 0)
	(= (has-mobile-storage) 0)
	;; RRC
	(= (has-logical-channels) 0)
	(= (has-cell-update) 0)
	(= (has-handover) 0)
	(= (has-active-set-up) 0)
	;; AEEI
	(= (has-ggsn-bitrate) 0)
	(= (has-max-no-pdp) 0)
	(= (has-max-no-apn) 0)
	(M)
 )

 (:goal 
    (and 	
	(P4)
	(bs-ok A1 M1 L1 ae) 
	(bs-ok A2 M1 L2 ae) 
	(bs-ok A3 M1 L3 ae) 
	(bs-ok A4 M1 L4 ae) 
	(bs-ok A5 M1 L5 ae)
	(bs-ok A6 M1 L6 ae) 
	(bs-ok A7 M1 L7 ae) 
	(bs-ok A8 M1 L8 ae) 
	(bs-ok A9 M1 L9 ae) 
   )
 )

 (:metric minimize (total-time))
)
