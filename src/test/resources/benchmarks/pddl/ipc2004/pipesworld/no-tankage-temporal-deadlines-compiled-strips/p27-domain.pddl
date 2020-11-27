;; PipesWorld

(define (domain pipesworld_strips)

(:requirements :strips :typing :durative-actions :numeric-fluents  )

;; Types
;;  pipe: a pipeline segment
;;  area: operational areas
;;  product: an oil derivative product, such as gasoline,
;;    kerosene, etc.
;;  batch-atom: an unitary batch

(:types pipe area product batch-atom )

;; Define the products (petroleum derivatives)
(:constants lco gasoleo rat-a oca1 oc1b - product
	 B1 B4 B11 - batch-atom)
(:predicates

  (N) (NN) (PN) (P0) (P1) (P2) (P3)

  ;; Indicates that a pipeline segment connects
  ;; two areas
  (connect ?from ?to - area ?pipe - pipe)

  ;; Special case for unitary pipes
  (unitary ?pipe - pipe)
  (not-unitary ?pipe - pipe)

  ;; These predicates represent the pipeline segment contents
  ;; We define the first (nearest to  ``from'' area) and
  ;; last (nearest to  ``to'' area) batch-atom in a pipeline
  ;; segment, and their sequence is represented by the
  ;; (follow) predicate
  (last ?batch-atom - batch-atom ?pipe - pipe)
  (first ?batch-atom - batch-atom ?pipe - pipe)
  (follow ?next ?previous - batch-atom)

  ;; An unitary batch product
  (is-product ?batch-atom - batch-atom ?product - product)

  ;; Unitary batches that are on areas
  (on ?batch-atom - batch-atom ?area - area)

  ;; Indicates that two products may interface in the
  ;; pipeline segment
  (may-interface ?product-a ?product-b - product)

  ;; to control splitting process (push/pop vs. update)
  (normal ?pipe - pipe)
  (push-updating ?pipe - pipe)
  (pop-updating ?pipe - pipe)

  ;; for deadlines: a batch can only come out at the end of a pipe
  ;; as long as this fact here is still true.
  (deliverable ?batch-atom - batch-atom)
)
(:functions
  ;; it takes 2 / (speed ?pipe) time units to push/pop a batch through a pipe
  ;; ("2" is used here for simplicity, due to the splitted model and the
  ;; difference between unitary and non-unitary pipes.)
  (speed  ?pipe - pipe)
)

;; PUSH-START action
;; Moves a batch-atom from a tankage to a pipeline segment
;; The PUSH-START action moves the pipeline segment contents towards
;; the ``to-area'' defined in the ``connect'' predicate
;; first part -- initialise the push and turn control
;; over to contents update operators

(:durative-action PUSH-START
  :parameters(
    ;; Pipeline segment that will be moved
    ?pipe - pipe
    ;; Unitary batch that will be inserted into the pipeline
    ;; segment
    ?batch-atom-in - batch-atom
    ?from-area - area
    ?to-area - area
    ?first-batch-atom - batch-atom
    ?product-batch-atom-in - product
    ?product-first-batch - product
  )
  :duration (= ?duration (/ 1 (speed ?pipe)))
  :condition
   (and
   (at start (N))

   ;; normal planning mode
   (over all (normal ?pipe))
   ;; Binds :vars section
   (at start (first ?first-batch-atom ?pipe))
   (at start (connect ?from-area ?to-area ?pipe))
   ;; Inserted batch must be in 'from-area'
   (at start (on ?batch-atom-in ?from-area))
   ;; Action is applicable only in non-unitary pipeline segments
   (at start (not-unitary ?pipe))
   ;; Bind batch-atom products
   (at start (is-product ?batch-atom-in ?product-batch-atom-in))
   (at start (is-product ?first-batch-atom ?product-first-batch))
   ;; Interface restriction
   (at start (may-interface ?product-batch-atom-in ?product-first-batch))

 )
  :effect
   (and
     ;; switch into correct update mode for this pipe
     (at end (push-updating ?pipe))
     (at end (not (normal ?pipe)))
     ;; The inserted unitary batch will be the pipeline segment
     ;; new first batch
     (at end (first ?batch-atom-in ?pipe))
     (at start (not (first ?first-batch-atom ?pipe)))

     ;; Updates the follow and last relationship to the new
     ;; pipeline segment configuration
     (at end (follow ?first-batch-atom ?batch-atom-in))
     ;; Inserted batch-atom is removed from area
     (at start (not (on ?batch-atom-in ?from-area)))
    ;; Batch-atom removed from pipeline segment is inserted
    ;; into the destination area
)
)
;; PUSH-END action
;; Moves a batch-atom from a tankage to a pipeline segment
;; The PUSH-END action moves the pipeline segment contents towards
;; the ``to-area'' defined in the ``connect'' predicate
;; second part -- when start of pipe has been done, care about the
;; end of the pipe

(:durative-action PUSH-END
  :parameters(
    ;; Pipeline segment that will be moved
    ?pipe - pipe
    ;; Unitary batch that will be inserted into the pipeline
    ;; segment
    ?from-area - area
    ?to-area - area
    ?last-batch-atom - batch-atom
    ?next-last-batch-atom - batch-atom
  )
  :duration (= ?duration (/ 1 (speed ?pipe)))
  :condition
   (and
   (at start (N))

   ;; are we in the correct mode?
   (over all (push-updating ?pipe))
   ;; Binds :vars section
   (at start (last ?last-batch-atom ?pipe))
   (at start (connect ?from-area ?to-area ?pipe))
   ;; Action is applicable only in non-unitary pipeline segments
   (at start (not-unitary ?pipe))
   (at start (follow ?last-batch-atom ?next-last-batch-atom))

   (at end (deliverable ?last-batch-atom))
 )
  :effect
   (and
     ;; back to normal mode
     (at end (not (push-updating ?pipe)))
     (at end (normal ?pipe))

     ;; Updates the follow and last relationship to the new
     ;; pipeline segment configuration
     (at start (not (follow ?last-batch-atom ?next-last-batch-atom)))
     (at end (last ?next-last-batch-atom ?pipe))
     ;; Previous last batch is not last anymore
     (at start (not (last ?last-batch-atom ?pipe)))
    ;; Batch-atom removed from pipeline segment is inserted
    ;; into the destination area
     (at end (on ?last-batch-atom ?to-area))
)
)
;; POP-START action
;; Moves a batch-atom from a tankage to a pipeline segment
;; The POP-START action moves the pipeline segment contents towards
;; the ``from-area'' defined in the ``connect'' predicate
;; first part -- initialise the pop and turn control
;; over to contents update operators

(:durative-action POP-START
  :parameters(
    ;; Pipeline segment that will be moved
    ?pipe - pipe
    ;; Unitary batch that will be inserted into the pipeline
    ;; segment
    ?batch-atom-in - batch-atom
    ?from-area - area
    ?to-area - area
    ?last-batch-atom - batch-atom
    ?product-batch-atom-in - product
    ?product-last-batch - product
  )
  :duration (= ?duration (/ 1 (speed ?pipe)))
  :condition
   (and
   (at start (N))

   ;; normal planning mode
   (over all (normal ?pipe))
   ;; Binds :vars section
   (at start (last ?last-batch-atom ?pipe))
   (at start (connect ?from-area ?to-area ?pipe))
   ;; Inserted batch must be in 'to-area'
   (at start (on ?batch-atom-in ?to-area))
   ;; Action is applicable only in non-unitary pipeline segments
   (at start (not-unitary ?pipe))
   ;; Bind batch-atom products
   (at start (is-product ?batch-atom-in ?product-batch-atom-in))
   (at start (is-product ?last-batch-atom ?product-last-batch))
   ;; Interface restriction
   (at start (may-interface ?product-batch-atom-in ?product-last-batch))

 )
  :effect
   (and
     ;; switch into correct update mode for this pipe
     (at end (pop-updating ?pipe))
     (at end (not (normal ?pipe)))
     ;; The inserted unitary batch will be the pipeline segment
     ;; new last batch
     (at end (last ?batch-atom-in ?pipe))
     (at start (not (last ?last-batch-atom ?pipe)))

     ;; Updates the follow and first relationship to the new
     ;; pipeline segment configuration
     (at end (follow ?batch-atom-in ?last-batch-atom))
     ;; Inserted batch-atom is removed from area
     (at start (not (on ?batch-atom-in ?to-area)))
    ;; Batch-atom removed from pipeline segment is inserted
    ;; into the destination area
)
)
;; POP-END action
;; Moves a batch-atom from a tankage to a pipeline segment
;; The POP-END action moves the pipeline segment contents towards
;; the ``from-area'' defined in the ``connect'' predicate
;; second part -- when start of pipe has been done, care about the
;; end of the pipe

(:durative-action POP-END
  :parameters(
    ;; Pipeline segment that will be moved
    ?pipe - pipe
    ;; Unitary batch that will be inserted into the pipeline
    ;; segment
    ?from-area - area
    ?to-area - area
    ?first-batch-atom - batch-atom
    ?next-first-batch-atom - batch-atom
  )
  :duration (= ?duration (/ 1 (speed ?pipe)))
  :condition
   (and
   (at start (N))

   ;; are we in the correct mode?
   (over all (pop-updating ?pipe))
   ;; Binds :vars section
   (at start (first ?first-batch-atom ?pipe))
   (at start (connect ?from-area ?to-area ?pipe))
   ;; Action is applicable only in non-unitary pipeline segments
   (at start (not-unitary ?pipe))
   (at start (follow ?next-first-batch-atom ?first-batch-atom))

   (at end (deliverable ?first-batch-atom))
 )
  :effect
   (and
     ;; back to normal mode
     (at end (not (pop-updating ?pipe)))
     (at end (normal ?pipe))

     ;; Updates the follow and first relationship to the new
     ;; pipeline segment configuration
     (at start (not (follow ?next-first-batch-atom ?first-batch-atom)))
     (at end (first ?next-first-batch-atom ?pipe))
     ;; Previous first batch is not first anymore
     (at start (not (first ?first-batch-atom ?pipe)))
    ;; Batch-atom removed from pipeline segment is inserted
    ;; into the destination area
     (at end (on ?first-batch-atom ?from-area))
)
)
;; PUSH-UNITARYPIPE action
;; Moves a batch-atom from a tankage to a pipeline segment
;; The PUSH-UNITARYPIPE action moves the pipeline segment contents towards
;; the ``to-area'' defined in the ``connect'' predicate
;; first part -- initialise the push and turn control
;; over to contents update operators

(:durative-action PUSH-UNITARYPIPE
  :parameters(
    ;; Pipeline segment that will be moved
    ?pipe - pipe
    ;; Unitary batch that will be inserted into the pipeline
    ;; segment
    ?batch-atom-in - batch-atom
    ?from-area - area
    ?to-area - area
    ?first-batch-atom - batch-atom
    ?product-batch-atom-in - product
    ?product-first-batch - product
  )
  :duration (= ?duration (/ 2 (speed ?pipe)))
  :condition
   (and
   (at start (N))

   ;; Binds :vars section
   (at start (first ?first-batch-atom ?pipe))
   (at start (connect ?from-area ?to-area ?pipe))
   ;; Inserted batch must be in 'from-area'
   (at start (on ?batch-atom-in ?from-area))
   ;; Action is applicable only in unitary pipeline segments
   (at start (unitary ?pipe))
   ;; Bind batch-atom products
   (at start (is-product ?batch-atom-in ?product-batch-atom-in))
   (at start (is-product ?first-batch-atom ?product-first-batch))
   ;; Interface restriction
   (at start (may-interface ?product-batch-atom-in ?product-first-batch))

   (at end (deliverable ?first-batch-atom))
 )
  :effect
   (and
     ;; The inserted unitary batch will be the pipeline segment
     ;; new first batch
     (at end (first ?batch-atom-in ?pipe))
     (at start (not (first ?first-batch-atom ?pipe)))

     ;; Updates the follow and last relationship to the new
     ;; pipeline segment configuration
     (at end (last ?batch-atom-in ?pipe))
     (at start (not (last ?first-batch-atom ?pipe)))
     ;; Inserted batch-atom is removed from area
     (at start (not (on ?batch-atom-in ?from-area)))
    ;; Batch-atom removed from pipeline segment is inserted
    ;; into the destination area
     (at end (on ?first-batch-atom ?to-area))
)
)
;; POP-UNITARYPIPE action
;; Moves a batch-atom from a tankage to a pipeline segment
;; The POP-UNITARYPIPE action moves the pipeline segment contents towards
;; the ``from-area'' defined in the ``connect'' predicate
;; first part -- initialise the pop and turn control
;; over to contents update operators

(:durative-action POP-UNITARYPIPE
  :parameters(
    ;; Pipeline segment that will be moved
    ?pipe - pipe
    ;; Unitary batch that will be inserted into the pipeline
    ;; segment
    ?batch-atom-in - batch-atom
    ?from-area - area
    ?to-area - area
    ?last-batch-atom - batch-atom
    ?product-batch-atom-in - product
    ?product-last-batch - product
  )
  :duration (= ?duration (/ 2 (speed ?pipe)))
  :condition
   (and
   (at start (N))

   ;; Binds :vars section
   (at start (last ?last-batch-atom ?pipe))
   (at start (connect ?from-area ?to-area ?pipe))
   ;; Inserted batch must be in 'to-area'
   (at start (on ?batch-atom-in ?to-area))
   ;; Action is applicable only in unitary pipeline segments
   (at start (unitary ?pipe))
   ;; Bind batch-atom products
   (at start (is-product ?batch-atom-in ?product-batch-atom-in))
   (at start (is-product ?last-batch-atom ?product-last-batch))
   ;; Interface restriction
   (at start (may-interface ?product-batch-atom-in ?product-last-batch))

   (at end (deliverable ?last-batch-atom))
 )
  :effect
   (and
     ;; The inserted unitary batch will be the pipeline segment
     ;; new last batch
     (at end (last ?batch-atom-in ?pipe))
     (at start (not (last ?last-batch-atom ?pipe)))

     ;; Updates the follow and first relationship to the new
     ;; pipeline segment configuration
     (at end (first ?batch-atom-in ?pipe))
     (at start (not (first ?last-batch-atom ?pipe)))
     ;; Inserted batch-atom is removed from area
     (at start (not (on ?batch-atom-in ?to-area)))
    ;; Batch-atom removed from pipeline segment is inserted
    ;; into the destination area
     (at end (on ?last-batch-atom ?from-area))
)
)
(:durative-action timedliteralwrapper
 :parameters ()
 :duration (= ?duration 11.14)
 :condition
    (and (at start (NN)))
 :effect
    (and (at start (not (NN))) (at start (N)) (at start (P0)) (at start (PN)
) (at end (not (PN)))))

(:durative-action timedliteral1
 :parameters ()
 :duration (= ?duration 8.13)
 :condition
   (and (over all (P0)) (over all (PN)))
 :effect
   (and (at end (P1)) (at end (not (P0))) (at end (not (deliverable B11)))))

(:durative-action timedliteral2
 :parameters ()
 :duration (= ?duration 2.01)
 :condition
   (and (over all (P1)) (over all (PN)))
 :effect
   (and (at end (P2)) (at end (not (P1))) (at end (not (deliverable B1)))))

(:durative-action timedliteral3
 :parameters ()
 :duration (= ?duration 1.00)
 :condition
   (and (over all (P2)) (over all (PN)))
 :effect
   (and (at end (P3)) (at end (not (P2))) (at end (not (deliverable B4)))))

)
