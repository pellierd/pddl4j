; Domain : Temporal Machine Shop (Light), 2 kilns, 3 types of ceramics, Time (Temporally Expressive)
; Authors : Frederic Maris and Pierre Regnier

(define (domain domain-tms-2-3-light)
  (:requirements :strips :typing :durative-actions)
  (:types piecetype1 piecetype2 piecetype3 - piece
          kiln8 kiln20 - kiln)
  (:predicates 
               (energy )
               (ready ?k - kiln)
               (baking ?p - piece)
               (treated ?p - piece)
               (baked ?p - piece)
               (structured ?p1 - piece ?p2 - piece)
               (baked-structure ?p1 - piece ?p2 - piece))

  (:durative-action fire-kiln1
      :parameters (?k - kiln8)
      :duration (= ?duration 8)
      :condition (over all (energy ))
      :effect (and (at start (ready ?k))
                   (at end (not (ready ?k))))
  )

  (:durative-action fire-kiln2
      :parameters (?k - kiln20)
      :duration (= ?duration 20)
      :condition (over all (energy ))
      :effect (and (at start (ready ?k))
                   (at end (not (ready ?k))))
  )

  (:durative-action bake-ceramic1
      :parameters (?p - piecetype1 ?k - kiln)
      :duration (= ?duration 15)
      :condition (over all (ready ?k))
      :effect (and (at start (not (baked ?p)))
                   (at start (baking ?p))
                   (at end (not (baking ?p)))
                   (at end (baked ?p)))
  )

  (:durative-action bake-ceramic2
      :parameters (?p - piecetype2 ?k - kiln)
      :duration (= ?duration 10)
      :condition (over all (ready ?k))
      :effect (and (at start (not (baked ?p)))
                   (at start (baking ?p))
                   (at end (not (baking ?p)))
                   (at end (baked ?p)))
  )

  (:durative-action bake-ceramic3
      :parameters (?p - piecetype3 ?k - kiln)
      :duration (= ?duration 5)
      :condition (over all (ready ?k))
      :effect (and (at start (not (baked ?p)))
                   (at start (baking ?p))
                   (at end (not (baking ?p)))
                   (at end (baked ?p)))
  )

  (:durative-action treat-ceramic1
      :parameters (?p - piece)
      :duration (= ?duration 3)
      :condition (over all (baking ?p))
      :effect (at end (treated ?p))
  )

  (:durative-action treat-ceramic2
      :parameters (?p - piecetype2)
      :duration (= ?duration 2)
      :condition (over all (baking ?p))
      :effect (at end (treated ?p))
  )

  (:durative-action treat-ceramic3
      :parameters (?p - piecetype3)
      :duration (= ?duration 1)
      :condition (over all (baking ?p))
      :effect (at end (treated ?p))
  )

  (:durative-action make-structure
      :parameters (?p1 - piece ?p2 - piece)
      :duration (= ?duration 1)
      :condition (and (over all (baked ?p1))
                      (over all (treated ?p1))
                      (over all (baked ?p2))
                      (over all (treated ?p2)))
      :effect (at end (structured ?p1 ?p2))
  )

  (:durative-action bake-structure
      :parameters (?p1 - piece ?p2 - piece ?k - kiln)
      :duration (= ?duration 3)
      :condition (and (over all (ready ?k))
                      (over all (structured ?p1 ?p2)))
      :effect (and (at start (not (baked-structure ?p1 ?p2)))
                   (at end (baked-structure ?p1 ?p2)))
  )

)
