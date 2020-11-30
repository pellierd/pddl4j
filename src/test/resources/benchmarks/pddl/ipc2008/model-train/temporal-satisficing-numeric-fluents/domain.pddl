(define (domain model-train-time-metric)
  
  (:requirements :typing :durative-actions :numeric-fluents)
  
  (:types train switch segment - object)
  
  (:predicates
   (idle ?t - train)
   ;; The train ?t is currently not moving.
   
   (head-segment ?t - train ?s - segment)
   ;; The head of the train ?t is in segment ?s.
   
   (tail-segment ?t - train ?s - segment)
   ;; The tail of the train ?t is in segment ?s.
   
   (visited-segment ?t - train ?s - segment)
   ;; Train ?t has ever "fully entered" segment ?s,
   ;; i.e, (tail-segment ?t ?s) was ever set.
   
   (switch-available ?sw - switch)
   ;; This switch can currently be used, i.e., there is no train
   ;; currently passing through it.
   
   (switch-entrance ?sw - switch ?s - segment)
   ;; Switch ?sw can currently be entered from segment ?s,
   ;; provided that it is available.
   
   (switch-exit ?sw - switch ?s - segment)
   ;; Switch ?sw can currently be left into segment ?s,
   ;; provided that it is available.
   
   (first-train-in-head-segment ?t - train)
   ;; Train ?t is the first train in its head segment, i.e, there
   ;; is no train (not even part of a train) in front of it in this
   ;; segment: the path to the next switch is clear.
   
   ;; Note: We can easily test if a train is the first train in its tail
   ;; segment by testing that either the head and tail segments are
   ;; different (in which case it extends over the switch its tail
   ;; is moving towards), or they are the same and it is the first train
   ;; in its head segment.
   
   (next-train ?pred - train ?succ - train)
   ;; Means that the tail segment of ?pred equals the head segment of ?succ
   ;; and there are no trains in between. In other words, this is set
   ;; when ?succ enters a segment that is not completely empty, and it is
   ;; cleared when ?pred leaves a segment that does not become completely
   ;; empty.
   
   (last-train-in-tail-segment ?t - train)
   ;; Train ?t is the last train in its tail segment, i.e., there is
   ;; nothing between the tail of train ?t and the switch that
   ;; is reached first when going from the tail of the train in the
   ;; opposite direction of the movement direction.
   
   ;; Note: We can easily test if a train is the last train in its head
   ;; segment by testing that either the head and tail segments are
   ;; different (in which case it extends over the switch its tail
   ;; is moving towards), or they are the same and it is the last train
   ;; in its tail segment.
   
   (segment-empty ?s - segment)
   ;; There is no train in segment ?s, not even part of a train.
   
   (SWITCH-HAS-ENTRANCE ?sw - switch ?s - segment)
   (SWITCH-HAS-EXIT ?sw - switch ?s - segment)
   )
  
  (:functions
   (head-segment-position ?t - train)
   (tail-segment-position ?t - train)
   ;; Note: These are both updated with (at start) effects for maximal
   ;; concurrency. This cannot lead to crashes (we hope) because
   ;; once we update the value, we can promise that we can move until
   ;; this distance, and noone can catch up with us because everyone
   ;; moves at the same speed.
   
   (SEGMENT-LENGTH ?s - segment)
   (TRAIN-LENGTH ?t - train)
   )
  

  ;; Advance a train which is the first train in its segment to the
  ;; front of its segment. This is only allowed if the train's tail
  ;; does not cross a segment boundary, otherwise we must advance its
  ;; tail to the next switch first.
  (:durative-action advance-head-to-switch
    :parameters (?t - train ?s1 ?s2 - segment)
    :duration (= ?duration (- (SEGMENT-LENGTH ?s1)
                              (head-segment-position ?t)))
    :condition (and (at start (idle ?t))
                    (at start (head-segment ?t ?s1))
                    (at start (tail-segment ?t ?s2))
		    
		    ;; First train in head segment
                    (at start (first-train-in-head-segment ?t))
		    
		    ;; Do not pull tail beyond segment boundary
		    ;; (special case s1 == s2 is covered unless (TRAIN-LENGTH ?t) == 0)
		    (at start
			(<= (- (SEGMENT-LENGTH ?s1)
			       (head-segment-position ?t))
			    (- (SEGMENT-LENGTH ?s2)
			       (tail-segment-position ?t)))
			)
		    )
    :effect (and (at start (not (idle ?t)))
                 (at end (idle ?t))
                 (at start (increase (head-segment-position ?t) ?duration))
                 (at start (increase (tail-segment-position ?t) ?duration))
                 )
    )
  
  ;; Advance a train which is not the first train in its head segment
  ;; as far as possible, i.e., to the tail of the preceding train in 
  ;; the same segment. This is only allowed if the train's tail
  ;; does not cross a segment boundary, otherwise we must advance its
  ;; tail to the next switch first.
  (:durative-action advance-head-to-next-train
    :parameters (?t ?pred - train ?s1 ?s2 - segment)
    :duration (= ?duration (- (tail-segment-position ?pred)
			      (head-segment-position ?t)))    
    :condition (and (at start (idle ?t))
		    (at start (head-segment ?t ?s1))
		    (at start (tail-segment ?t ?s2))
		    
		    ;; Affected train is behind train ?pred
		    (at start (next-train ?pred ?t))
		    (at start (tail-segment ?pred ?s1)) ;; should be implied
		    
		    ;; Do not pull tail beyond segment boundary
		    ;; (special case s1 == s2 is covered unless (TRAIN-LENGTH ?t) == 0)
                    (at start
			(<= (- (tail-segment-position ?pred)
			       (head-segment-position ?t))
			    (- (SEGMENT-LENGTH ?s2)
			       (tail-segment-position ?t)))
			)
		    )
    :effect (and (at start (not (idle ?t)))
		 (at end (idle ?t))
		 (at start (increase (head-segment-position ?t) ?duration))
		 (at start (increase (tail-segment-position ?t) ?duration))
		 )
    )
  
  
  ;; Advance a train which is the first train in its head segment so that its
  ;; tail advances to the next switch. Dually to advance-head-to-switch,
  ;; this is only allowed if the head does not cross a segment
  ;; boundary, otherwise we must advance the head of the train first.
  (:durative-action advance-tail-to-switch-for-leading-train
    :parameters (?t - train ?s1 ?s2 - segment)
    :duration (= ?duration (- (SEGMENT-LENGTH ?s2)
                              (tail-segment-position ?t)))
    :condition (and (at start (idle ?t))
                    (at start (head-segment ?t ?s1))
                    (at start (tail-segment ?t ?s2))
		    
		    ;; Assumption: Train is first train in its head segment
		    (at start (first-train-in-head-segment ?t))

		    ;; Do not push head beyond segment boundary
                    (at start (<= (- (SEGMENT-LENGTH ?s2)
                                     (tail-segment-position ?t))
                                  (- (SEGMENT-LENGTH ?s1)
                                     (head-segment-position ?t))))
		    )
    :effect (and (at start (not (idle ?t)))
                 (at end (idle ?t))
                 (at start (increase (head-segment-position ?t) ?duration))
                 (at start (increase (tail-segment-position ?t) ?duration))
                 )
    )
  
  ;; Advance a train which is NOT the first train in its head segment so that its
  ;; tail advances to the next switch. This is only allowed if the head does
  ;; not cross a segment boundary AND it does not crash into the tail of a
  ;; preceding train on the same segment.
  (:durative-action advance-tail-to-switch-for-trailing-train
    :parameters (?t ?pred - train ?s1 ?s2 - segment)
    :duration (= ?duration (- (SEGMENT-LENGTH ?s2)
                              (tail-segment-position ?t)))
    :condition (and (at start (idle ?t))
                    (at start (head-segment ?t ?s1))
                    (at start (tail-segment ?t ?s2))

		    ;; Assumption: Train is NOT first train in its head segment
		    (at start (next-train ?pred ?t))
		    (at start (tail-segment ?pred ?s1)) ;; should be implied.
		    
		    ;; Do not push head into tail of preceding train
		    (at start (<= (- (SEGMENT-LENGTH ?s2)
				     (tail-segment-position ?t))
				  (- (tail-segment-position ?pred)
				     (head-segment-position ?t))))
		    )
    :effect (and (at start (not (idle ?t)))
                 (at end (idle ?t))
                 (at start (increase (head-segment-position ?t) ?duration))
                 (at start (increase (tail-segment-position ?t) ?duration))
                 )
    )


  ;; Advance head to the next segment (Case 1: New head segment is empty).
  (:durative-action update-head-segment-to-empty-segment
    :parameters (?t - train ?s-old ?s-new - segment ?sw - switch)
    :duration (= ?duration 1)
    :condition (and (at start (idle ?t))
		    (at start (head-segment ?t ?s-old))
		    (at start (= (head-segment-position ?t)
				 (SEGMENT-LENGTH ?s-old)))
		    (at start (first-train-in-head-segment ?t)) ;; should be implied
		    (at start (segment-empty ?s-new))
		    (over all (switch-entrance ?sw ?s-old))
		    (over all (switch-exit ?sw ?s-new))
		    )
    :effect (and (at start (not (idle ?t)))
		 (at end (idle ?t))
		 (at start (not (head-segment ?t ?s-old)))
		 (at start (head-segment ?t ?s-new))
		 (at start (assign (head-segment-position ?t) 0))
		 (at start (not (segment-empty ?s-new)))
		 (at start (not (switch-available ?sw)))
		 )	     
    )
  
  ;; Advance head to the next segment (Case 2: New head segment is NOT empty).
  (:durative-action update-head-segment-to-occupied-segment
    :parameters (?t ?pred - train ?s-old ?s-new - segment ?sw - switch)
    :duration (= ?duration 1)
    :condition (and (at start (idle ?t))
		    (at start (head-segment ?t ?s-old))
		    (at start (= (head-segment-position ?t)
				 (SEGMENT-LENGTH ?s-old)))
		    (at start (first-train-in-head-segment ?t)) ;; should be implied
		    (at start (tail-segment ?pred ?s-new))
		    (at start (last-train-in-tail-segment ?pred))
		    (over all (switch-entrance ?sw ?s-old))
		    (over all (switch-exit ?sw ?s-new))
		    )
    :effect (and (at start (not (idle ?t)))
		 (at end (idle ?t))
		 (at start (not (head-segment ?t ?s-old)))
		 (at start (head-segment ?t ?s-new))
		 (at start (assign (head-segment-position ?t) 0))
		 (at start (not (first-train-in-head-segment ?t)))
		 (at start (not (last-train-in-tail-segment ?pred)))
		 (at start (next-train ?pred ?t))
		 (at start (not (switch-available ?sw)))
		 )	     
    )


  ;; Advance tail to the next segment (Case 1: Old tail segment becomes empty).
  (:durative-action update-tail-segment-leaving-empty-segment
    :parameters (?t - train ?s-old ?s-new - segment ?sw - switch)
    :duration (= ?duration 1)
    :condition (and (at start (idle ?t))
		    (at start (tail-segment ?t ?s-old))
		    (at start (= (tail-segment-position ?t)
				 (SEGMENT-LENGTH ?s-old)))
		    (at start (last-train-in-tail-segment ?t))
		    (over all (switch-entrance ?sw ?s-old))
		    (over all (switch-exit ?sw ?s-new))
		    )
    :effect (and (at start (not (idle ?t)))
		 (at end (idle ?t))
		 (at start (not (tail-segment ?t ?s-old)))
		 (at start (tail-segment ?t ?s-new))
		 (at start (assign (tail-segment-position ?t) 0))
		 (at start (last-train-in-tail-segment ?t)) ;; redundant
		 (at start (segment-empty ?s-old))
		 (at end (switch-available ?sw))
		 (at end (visited-segment ?t ?s-new))
		 )
    )
  
  ;; Advance tail to the next segment (Case 2: Old tail segment DOES NOT become empty)
  (:durative-action update-tail-segment-leaving-occupied-segment
    :parameters (?t ?succ - train ?s-old ?s-new - segment ?sw - switch)
    :duration (= ?duration 1)
    :condition (and (at start (idle ?t))
		    (at start (tail-segment ?t ?s-old))
		    (at start (= (tail-segment-position ?t)
				 (SEGMENT-LENGTH ?s-old)))
		    (at start (head-segment ?succ ?s-old)) ;; should be implied
		    (at start (next-train ?t ?succ))
		    (over all (switch-entrance ?sw ?s-old))
		    (over all (switch-exit ?sw ?s-new))
		    )
    :effect (and (at start (not (idle ?t)))
		 (at end (idle ?t))
		 (at start (not (tail-segment ?t ?s-old)))
		 (at start (tail-segment ?t ?s-new))
		 (at start (assign (tail-segment-position ?t) 0))
		 (at start (last-train-in-tail-segment ?t))
		 (at start (not (next-train ?t ?succ)))
		 (at start (first-train-in-head-segment ?succ))
		 (at end (switch-available ?sw))
		 (at end (visited-segment ?t ?s-new))
		 )
    )

  ;; Change switch entrance from one segment to another
  (:durative-action change-switch-entrance
    :parameters (?sw - switch ?s-old ?s-new - segment)
    :duration (= ?duration 10)
    :condition (and (at start (switch-entrance ?sw ?s-old))
		    (at start (SWITCH-HAS-ENTRANCE ?sw ?s-new))
		    (at start (switch-available ?sw))
		    )
    :effect (and (at start (not (switch-entrance ?sw ?s-old)))
		 (at end (switch-entrance ?sw ?s-new))
		 )
    )

  ;; Change switch exit from one segment to another
  (:durative-action change-switch-exit
    :parameters (?sw - switch ?s-old ?s-new - segment)
    :duration (= ?duration 10)
    :condition (and (at start (switch-exit ?sw ?s-old))
		    (at start (SWITCH-HAS-EXIT ?sw ?s-new))
		    (at start (switch-available ?sw))
		    )
    :effect (and (at start (not (switch-exit ?sw ?s-old)))
		 (at end (switch-exit ?sw ?s-new))
		 )
    )
  )


