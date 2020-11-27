;; The execution of mobile applications requires a proper configuration
;; of mobile network components. This domain is modeled with
;; resources of mobile network components and negotiation of MAC.
;; Applicable for 10 applications. The duration of an action is modeled
;; via the time predicate. The duration varies for each application and
;; module.

;; Intra-application constraint: yes
;; Inter-application constraint: no
;; Roman Englert, Stefan Edelkamp, November 2003

(define (DOMAIN INCOMPATIBEL-APPLICATION-CONFIGURATION)
 (:requirements :typing :numeric-fluents :durative-actions)
 (:types application agent mobile list message network - object)
 (:constants ae - agent)
 (:predicates
		;; TRM
		;; application A-new is started in mobile M
        (initiated ?A-new - application ?M - mobile)
		;; defines quality of service classes. here two params
		;; are applied: maximum delay of next data paket ML and
		;; data paket size PDU (paket data unit)
        (qos-params ?A-new - application ?L - list)
		;; the execution of application A-new in mobile M
		;; requires eg. Acp percent cpu usage
	(trm-ok ?A-new - application ?M - mobile ?L - list)
		;; CT
	(ct-ok ?A-new - application ?M - mobile ?L - list)
		;; AM
		;; provides location of M via the HLR/ VLR
	(location ?M - mobile)
		;; user/ mobile M is known correctly, MSISDN etc.
	(authentification ?M - mobile)
	(am-ok ?A-new - application ?M - mobile ?L - list)
		;; AEEM
	(aeem-ok ?A-new - application ?M - mobile ?L - list ?a - agent)
		;; RRC
		;; required physical channels N of mobile can be
		;; mapped to logical channels of network; N is
		;; provided by the TRM in the mobile
		;; (required-channels ?A-new - application ?M - mobile ?N)
	(rrc-ok ?A-new - application ?M - mobile ?L - list ?a - agent)
		;; RAB
	(rab-ok ?A-new - application ?M - mobile ?L - list ?a - agent)
		;; AEEI
	(aeei-ok ?A-new - application ?M - mobile ?L - list ?a - agent)
		;; BS
	(message-trm ?M - mobile ?MS - message)
	(message-aeei ?A-new - application ?MS - message)
	(iu-bearer ?A-new - application ?M - mobile ?L - list)
	(bs-ok ?A-new - application ?M - mobile ?L - list ?a - agent)
	(begin-init ?a - agent)
	(begin-aeei ?a - agent)
        (M) (N) (P0) (P1) (P2) (P3) (P4) (PN)
 )
 (:functions
        (app-cpu ?A-new - application ?M - mobile)
	(app-display ?A-new - application ?M - mobile)
	(app-keyboard ?A-new - application ?M - mobile)
	(app-energy ?A-new - application ?M - mobile)
	(app-channels ?A-new - application ?M - mobile)

	(list-pdu ?L - list)
	(list-ml ?L - list)

	(time-trm ?A-new - application)
	(time-ct ?A-new - application)
	(time-am ?A-new - application)
	(time-aeem ?A-new - application)
	(time-rrc ?A-new - application)
	(time-rrc-negotiation ?A-new - application)
	(time-rab ?A-new - application)
	(time-aeei ?A-new - application)
	(time-bs ?A-new - application)

	;; TRM
	(max-mobile-cpu)	;; availability in per cent
	(max-d-available)	;; partition of the display, e.g. ticker
	(max-k-available)	;; keyboard in use, e.g. game
	(max-e-load)		;; energy
	(max-mobile-channels-available)
	;; CT
	(max-num-mobiles)	;; tractable by a node B
	(max-num-calls)		;; mobile network load for a node B
	(max-mobile-storage)	;; S(IM)AT
	;; RRC
	(max-logical-channels)	;; num logical channels available in the CN
	(max-cell-update)	;; report UE location into RNC (required only once)
	(max-handover)		;; inter-frequencies required
	(max-active-set-up)	;; update connection
	;; AEEI
	(max-ggsn-bitrate)	;; capacity (kbit/s)
	(max-no-pdp)	;; packet data protocols per subscriber/ mobile
	(max-no-apn)	;; access point names (APN) per mobile

	;; TRM
	(has-mobile-cpu)	;; availability in per cent
	(has-d-available)	;; partition of the display, e.g. ticker
	(has-k-available)	;; keyboard in use, e.g. game
	(has-e-load)		;; energy
	(has-mobile-channels-available)
	;; CT
	(has-num-mobiles)	;; num. of tractable mobiles by a node B
	(has-num-calls)		;; mobile network load for a node B
	(has-mobile-storage)	;; S(IM)AT
	;; RRC
	(has-logical-channels)	;; num logical channels available in the CN
	(has-cell-update)	;; report UE location into RNC (required only once)
	(has-handover)		;; inter-frequencies required
	(has-active-set-up)	;; update connection
	;; AEEI
	(has-ggsn-bitrate)	;; capacity (kbit/s)
	(has-max-no-pdp)	;; packet data protocols per subscriber/ mobile
	(has-max-no-apn)	;; access point names (APN) per mobile
 )

(:durative-action FLAW
 :parameters
        (?A-new - application ?M - mobile ?L - list ?a - agent)
 :duration (= ?duration 4)
 :condition
    (and
        (at start (initiated ?A-new ?M))
        (at start (qos-params ?A-new ?L))
        (at start (trm-ok ?A-new ?M ?L))
    )
 :effect
   (and
     (at end (rab-ok ?A-new ?M ?L ?a))
     (at start (not (initiated ?A-new ?M)))
  )
)

(:durative-action TRM
 :parameters
	(?A-new - application ?M - mobile ?L - list)
 :duration
        (= ?duration (time-trm ?A-new))
 :condition
    (and
        (at start (N))
	(at start (initiated ?A-new ?M))
	(at start (qos-params ?A-new ?L))
	(at start (<= (has-mobile-cpu)
                      (- (max-mobile-cpu) (app-cpu ?A-new ?M))))
	(at start (<= (has-d-available)
                      (- (max-d-available) (app-display ?A-new ?M))))
	(at start (<= (has-k-available)
                      (- (max-k-available) (app-keyboard ?A-new ?M))))
	(at start (<= (has-e-load)
                      (- (max-e-load) (app-energy ?A-new ?M))))
	(at start (<= (has-mobile-channels-available)
                      (- (max-mobile-channels-available)
                         (app-channels ?A-new ?M))))
    )
  :effect
    (and
        (at end (trm-ok ?A-new ?M ?L))
        (at start (increase (has-mobile-cpu) (app-cpu ?A-new ?M)))
        (at end (decrease (has-mobile-cpu) (app-cpu ?A-new ?M)))
	(at start (increase (has-d-available) (app-display ?A-new ?M)))
	(at end (decrease (has-d-available) (app-display ?A-new ?M)))
	(at start (increase (has-k-available) (app-keyboard ?A-new ?M)))
	(at end (decrease (has-k-available) (app-keyboard ?A-new ?M)))
	(at start (increase (has-e-load) (app-energy ?A-new ?M)))
	(at end (decrease (has-e-load) (app-energy ?A-new ?M)))
	(at start (increase (has-mobile-channels-available)
			(app-channels ?A-new ?M)))
	(at end (decrease (has-mobile-channels-available)
			(app-channels ?A-new ?M)))
   )

)



(:durative-action CT
 :parameters (?A-new - application ?M - mobile ?L - list)
 :duration (= ?duration (time-ct ?A-new))
 :condition
  (and
    (at start (N))
    (at start (trm-ok ?A-new ?M ?L))
    (at start (qos-params ?A-new ?L))
    (at start (< (has-num-mobiles) (max-num-mobiles)))
    (at start (< (has-num-calls) (max-num-calls)))
  )
 :effect
  (and
    (at start (increase (has-num-mobiles) 1))
    (at end (decrease (has-num-mobiles) 1))
    (at start (increase (has-num-calls) 1))
    (at end (decrease (has-num-calls) 1))
    (at end (ct-ok ?A-new ?M ?L))
  )
)


(:durative-action AM
 :parameters (?A-new - application ?M - mobile ?L - list)
 :duration (= ?duration 0)
 :condition
   (and	(at start (N))
        (at start (ct-ok ?A-new ?M ?L))
	(at start (location ?M))
	(at start (authentification ?M))
   )
 :effect
   (and
        (at end (am-ok ?A-new ?M ?L))
   )
)

(:durative-action AEEM
 :parameters (?A-new - application ?M - mobile ?L - list ?a - agent)
 :duration (= ?duration (time-aeem ?A-new))
 :condition
   (and
     (at start (N))
     (at start (am-ok ?A-new ?M ?L))
     (at start (<= (has-mobile-storage) (- (max-mobile-storage) 10)))
     (at start (begin-init ?a))
   )
 :effect
   (and
     (at start (increase (has-mobile-storage) 10))
     (at end (decrease (has-mobile-storage) 10))
     (at end (aeem-ok ?A-new ?M ?L ?a))
   )
)


(:durative-action RRC
 :parameters (?A-new - application ?M - mobile ?L - list ?a - agent)
 :duration (= ?duration (time-rrc ?A-new))
 :condition
   (and
        (at start (N))
	(at start (ct-ok ?A-new ?M ?L))
	(at start (aeem-ok ?A-new ?M ?L ?a))
	(at start (<= (has-logical-channels)
		      (- (max-logical-channels) (app-channels ?A-new ?m))))
	(at start (<= (has-cell-update)
		      (- (max-cell-update) 2)))
	(at start (< (has-handover)
		      (max-handover)))
	(at start (< (has-active-set-up)
		      (max-active-set-up)))

   )
 :effect
   (and
	(at start (increase (has-logical-channels)
			    (app-channels ?A-new ?M)))
	(at end (decrease (has-logical-channels)
			    (app-channels ?A-new ?M)))
	(at start (increase (has-cell-update) 2))
	(at end (decrease (has-cell-update) 2))
        (at start (increase (has-handover) 1))
        (at end (decrease (has-handover) 1))
        (at start (increase (has-active-set-up) 1))
        (at end (decrease (has-active-set-up) 1))
	(at end (rrc-ok ?A-new ?M ?L ?a))
   )
)


(:durative-action RAB
 ;; future: in case of insufficient RB negotiation with AM (UTRAN and mobile)
 :parameters (?A-new - application ?M - mobile ?L - list ?a - agent)
 :duration (= ?duration (time-rab ?A-new))
 :condition (and
        (at start (N))
        (at start (rrc-ok ?A-new ?M ?L ?a))
 )
 :effect
   (and
     (at end (rab-ok ?A-new ?M ?L ?a))
  )
)


(:durative-action AEEI
 :parameters (?A-new - application ?M - mobile ?L - list ?a - agent)
 :duration (= ?duration (time-aeei ?A-new))
 :condition
     (and
        (at start (N))
	(at start (rab-ok ?A-new ?M ?L ?a))
	(at start (<= (has-ggsn-bitrate)
                      (- (max-ggsn-bitrate) 128)))
	(at start (< (has-max-no-pdp)
		      (max-no-pdp)))
	(at start (< (has-max-no-apn)
		      (max-no-apn)))
	(at start (begin-aeei ?a))
     )
 :effect
   (and
      (at end (aeei-ok ?A-new ?M ?L ?a))
      (at start (increase (has-ggsn-bitrate) 128))
      (at end (decrease (has-ggsn-bitrate) 128))
      (at start (increase (has-max-no-pdp) 1))
      (at end (decrease (has-max-no-pdp) 1))
      (at start (increase (has-max-no-apn) 1))
      (at end (decrease (has-max-no-apn) 1))
   )
)


(:durative-action BS
 :parameters (?A-new - application ?M - mobile ?L - list ?MS1 ?MS2 - message ?a - agent)
 :duration (= ?duration (time-bs ?A-new))
 :condition
     (and
        (at start (N))
	(at start (initiated ?A-new ?M))
	(at start (aeei-ok ?A-new ?M ?L ?a))
	(at start (qos-params ?A-new ?L))
	(at start (message-trm ?M ?MS1))
	(at start (message-aeei ?A-new ?MS2))
     )
 :effect
    (and
	(at end (iu-bearer ?A-new ?M ?L))
        (at end (bs-ok ?A-new ?M ?L ?a))
    )
)

(:durative-action timedliteralwrapper
 :parameters ()
 :duration (= ?duration 2351)
 :condition
	(and (at start (M)))
 :effect
	(and (at start (not (M))) (at start (N)) (at start (P0)) (at start (PN)) (at end (not (PN)))))

(:durative-action timedliteral1
 :parameters ()
 :duration (= ?duration 70)
 :condition
	(and (over all (P0)) (over all (PN)))
 :effect
	(and (at end (P1)) (at end (not (P0))) (at end (begin-init ae))))

(:durative-action timedliteral2
 :parameters ()
 :duration (= ?duration 791)
 :condition
	(and (over all (P1)) (over all (PN)))
 :effect
	(and (at end (P2)) (at end (not (P1))) (at end (not (begin-init ae)))))

(:durative-action timedliteral3
 :parameters ()
 :duration (= ?duration 769)
 :condition
	(and (over all (P2)) (over all (PN)))
 :effect
	(and (at end (P3)) (at end (not (P2))) (at end (begin-aeei ae))))

(:durative-action timedliteral4
 :parameters ()
 :duration (= ?duration 721)
 :condition
	(and (over all (P3)))
 :effect
	(and (at end (P4)) (at end (not (P3))) (at end (not (begin-aeei ae)))))





) ;; end define domain


