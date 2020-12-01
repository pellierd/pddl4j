;; PipesWorld

(define (domain pipesworld_strips)

(:requirements :strips :typing )

;; Types
;;  pipe: a pipeline segment
;;  area: operational areas
;;  product: an oil derivative product, such as gasoline,
;;    kerosene, etc.
;;  batch-atom: an unitary batch

(:types pipe area product batch-atom tank-slot)

;; Define the products (petroleum derivatives)
(:constants lco gasoleo rat-a oca1 oc1b - product)

(:predicates

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
  ;;
  (normal ?pipe - pipe)
  (push-updating ?pipe - pipe)  
  (pop-updating ?pipe - pipe)  

  ;; tank-slot product and location
  (tank-slot-product-location ?tank-slot - tank-slot ?product - product ?area - area)

  ;; tank-slot status
  (occupied ?tank-slot - tank-slot)
  (not-occupied ?tank-slot - tank-slot)

)

;; PUSH action
;; Moves a batch-atom from a tankage to a pipeline segment
;; The PUSH action moves the pipeline segment contents towards
;; the ``to-area'' defined in the ``connect'' predicate

;; first part -- initialise the push and turn control
;; over to contents update operators
;;
(:action PUSH-START
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
    ?tank-slot - tank-slot
  )
  :precondition
   (and
   ;; normal planning mode
   ;;
   (normal ?pipe)

   ;; we want to do this with non-unitary pipes only
   ;;
   (not-unitary ?pipe)

   ;; right area!
   ;; (?to-area we need here only to identify from-area from connect relation..
   ;;  maybe introduce a split, i.e. pipe-start and pipe-end; note: we still
   ;;  need connect for the unitary pipe operators below)
   (connect ?from-area ?to-area ?pipe)

   ;; current batches locs...
   ;;
   (first ?first-batch-atom ?pipe)
   (on ?batch-atom-in ?from-area)

   ;; Bind batch-atom products
   (is-product ?batch-atom-in ?product-batch-atom-in)
   (is-product ?first-batch-atom ?product-first-batch)

   ;; Interface restriction
   (may-interface ?product-batch-atom-in ?product-first-batch)

   ;; Binds tank-slot, must be occupied
   (tank-slot-product-location ?tank-slot ?product-batch-atom-in ?from-area)
   (occupied ?tank-slot)

 )
  :effect
   (and 
     ;; switch into correct update mode for this pipe
     ;;
     (push-updating ?pipe)
     (not (normal ?pipe))

     ;; The inserted unitary batch will be the pipeline segment
     ;; new first batch; do the pipeline-start updates.
     (first ?batch-atom-in ?pipe)
     (not (first ?first-batch-atom ?pipe))
     (follow ?first-batch-atom ?batch-atom-in)

     ;; Inserted batch-atom is removed from area
     (not (on ?batch-atom-in ?from-area))

     ;; Origin tank-slot is freed
     (not (occupied ?tank-slot))
     (not-occupied ?tank-slot)
)
)

;; PUSH action
;; second part -- when start of pipe has been done, care about the
;; end of the pipe
;;
(:action PUSH-END	
  :parameters(
    ;; Pipeline segment that will be moved
    ?pipe - pipe
    ?from-area - area
    ?to-area - area
    ?last-batch-atom - batch-atom
    ?next-last-batch-atom - batch-atom
    ?product-last-batch - product
    ?tank-slot - tank-slot
  )
  :precondition
   (and
   ;; are we in the correct mode?
   (push-updating ?pipe)

   ;; we want to do this with non-unitary pipes only
   ;; (superfluous here because mode will be only invoked from
   ;;  non-unitary pipes; make that explicit, anyway.)
   ;;
   (not-unitary ?pipe)

   ;; right area!
   ;; (?to-area we need here only to identify from-area from connect relation..
   ;;  maybe introduce a split, i.e. pipe-start and pipe-end; note: we still
   ;;  need connect for the unitary pipe operators below)
   (connect ?from-area ?to-area ?pipe)

   ;; current batches locs...
   ;;
   (last ?last-batch-atom ?pipe)
   (follow ?last-batch-atom ?next-last-batch-atom)

   ;; binds last batch product
   (is-product ?last-batch-atom ?product-last-batch)

   ;; binds tank-slot, must be freed
   (tank-slot-product-location ?tank-slot ?product-last-batch ?to-area)
   (not-occupied ?tank-slot)

 )
  :effect
   (and 
     ;; back to normal mode.
     (not (push-updating ?pipe))
     (normal ?pipe)

     ;; the pipeline-end updates.
     ;;
     (not (follow ?last-batch-atom ?next-last-batch-atom))
     (last ?next-last-batch-atom ?pipe)
     (not (last ?last-batch-atom ?pipe))

     ;; Batch-atom removed from pipeline segment is inserted 
     ;; into the destination area
     (on ?last-batch-atom ?to-area)

     ;; tank-slot that receives the batch is occupied
     (occupied ?tank-slot)
     (not (not-occupied ?tank-slot))

)
)

;; POP action
;; Moves a batch-atom from a tankage to a pipeline segment
;; The POP action moves the pipeline segment contents towards
;; the ``from-area'' defined in the ``connect'' predicate

;; first part -- initialise the pop and turn control
;; over to contents update operators
;;
(:action POP-START
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
    ?tank-slot - tank-slot

  )
  :precondition
   (and
   ;; normal planning mode
   ;;
   (normal ?pipe)

   ;; we want to do this with non-unitary pipes only
   ;;
   (not-unitary ?pipe)

   ;; right area!
   ;; (?to-area we need here only to identify from-area from connect relation..
   ;;  maybe introduce a split, i.e. pipe-start and pipe-end; note: we still
   ;;  need connect for the unitary pipe operators below)
   (connect ?from-area ?to-area ?pipe)

   ;; current batches locs...
   ;;
   (last ?last-batch-atom ?pipe)
   (on ?batch-atom-in ?to-area)

   ;; Bind batch-atom products
   (is-product ?batch-atom-in ?product-batch-atom-in)
   (is-product ?last-batch-atom ?product-last-batch)

   ;; Interface restriction
   (may-interface ?product-batch-atom-in ?product-last-batch)

   ;; Binds tank-slot, must be occupied
  (tank-slot-product-location ?tank-slot ?product-batch-atom-in ?to-area)
  (occupied ?tank-slot)


 )
  :effect
   (and 
     ;; switch into correct update mode for this pipe
     ;;
     (pop-updating ?pipe)
     (not (normal ?pipe))

     ;; The inserted unitary batch will be the pipeline segment
     ;; new first batch; do the pipeline-end updates.
     (last ?batch-atom-in ?pipe)
     (not (last ?last-batch-atom ?pipe))
     (follow ?batch-atom-in ?last-batch-atom)

     ;; Inserted batch-atom is removed from area
     (not (on ?batch-atom-in ?to-area))

     ;; Origin tank-slot is freed
     (not (occupied ?tank-slot))
     (not-occupied ?tank-slot)

)
)
;; POP action
;; second part -- when end of pipe has been done, care about the
;; start of the pipe
;;
(:action POP-END
  :parameters(
    ;; Pipeline segment that will be moved
    ?pipe - pipe
    ?from-area - area
    ?to-area - area
    ?first-batch-atom - batch-atom
    ?next-first-batch-atom - batch-atom
    ?product-first-batch - product
    ?tank-slot - tank-slot
  )
  :precondition
   (and
   ;; are we in the correct mode?
   (pop-updating ?pipe)

   ;; we want to do this with non-unitary pipes only
   ;; (superfluous here because mode will be only invoked from
   ;;  non-unitary pipes; make that explicit, anyway.)
   ;;
   (not-unitary ?pipe)

   ;; right area!
   ;; (?to-area we need here only to identify from-area from connect relation..
   ;;  maybe introduce a split, i.e. pipe-start and pipe-end; note: we still
   ;;  need connect for the unitary pipe operators below)
   (connect ?from-area ?to-area ?pipe)

   ;; current batches locs...
   ;;
   (first ?first-batch-atom ?pipe)
   (follow ?next-first-batch-atom ?first-batch-atom)

   ;; binds tank-slot, must be freed
   (tank-slot-product-location ?tank-slot ?product-first-batch ?from-area)
   (not-occupied ?tank-slot)

 )
  :effect
   (and 
     ;; back to normal mode.
     (not (pop-updating ?pipe))
     (normal ?pipe)

     ;; the pipeline-start updates.
     ;;
     (not (follow ?next-first-batch-atom ?first-batch-atom))
     (first ?next-first-batch-atom ?pipe)
     (not (first ?first-batch-atom ?pipe))

     ;; Batch-atom removed from pipeline segment is inserted 
     ;; into the destination area
     (on ?first-batch-atom ?from-area)

     ;; tank-slot that receives the batch is occupied
     (occupied ?tank-slot)
     (not (not-occupied ?tank-slot))

)
)

;; PUSH-UNITARYPIPE action
;; Moves a batch-atom from a tankage to a pipeline segment
;; The PUSH-UNITARYPIPE action moves the pipeline segment contents towards
;; the ``to-area'' defined in the ``connect'' predicate
(:action PUSH-UNITARYPIPE
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
    ?from-tank-slot - tank-slot
    ?to-tank-slot - tank-slot
  )
  :precondition
   (and

   ;; Binds :vars section
   (first ?first-batch-atom ?pipe)
   (connect ?from-area ?to-area ?pipe)

   ;; Inserted batch must be in 'from-area'
   (on ?batch-atom-in ?from-area)

   ;; Action is applicable only in unitary pipeline segments
   (unitary ?pipe)

   ;; Bind batch-atom products
   (is-product ?batch-atom-in ?product-batch-atom-in)
   (is-product ?first-batch-atom ?product-first-batch)

   ;; Interface restriction
   (may-interface ?product-batch-atom-in ?product-first-batch)

   ;; Binds tank-slot, must be occupied
   (tank-slot-product-location ?from-tank-slot ?product-batch-atom-in ?from-area)
   (occupied ?from-tank-slot)

   ;; Binds tank-slot, must be freed
   (tank-slot-product-location ?to-tank-slot ?product-first-batch ?to-area)
   (not-occupied ?to-tank-slot)

 )
  :effect
   (and 
     ;; The inserted unitary batch will be the pipeline segment
     ;; new first and last batch
     (first ?batch-atom-in ?pipe)
     (not (first ?first-batch-atom ?pipe))
     (last ?batch-atom-in ?pipe)
     (not (last ?first-batch-atom ?pipe))

     ;; Inserted batch-atom is removed from area
     (not (on ?batch-atom-in ?from-area))

     ;; Origin tank-slot is freed
     (not (occupied ?from-tank-slot))
     (not-occupied ?from-tank-slot)

     ;; Batch-atom removed from pipeline segment is inserted 
     ;; into the destination area
     (on ?first-batch-atom ?to-area)

     ;; tank-slot that receives the batch is occupied
     (occupied ?to-tank-slot)
     (not (not-occupied ?to-tank-slot))

)
)

;; POP-UNITARYPIPE action
;; Moves a batch-atom from a tankage to a pipeline segment
;; The POP-UNITARYPIPE action moves the pipeline segment contents towards
;; the ``from-area'' defined in the ``connect'' predicate
(:action POP-UNITARYPIPE
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
    ?from-tank-slot - tank-slot
    ?to-tank-slot - tank-slot
  )
  :precondition
   (and

   ;; Binds :vars section
   (first ?first-batch-atom ?pipe)
   (connect ?from-area ?to-area ?pipe)

   ;; Inserted batch must be in 'to-area'
   (on ?batch-atom-in ?to-area)

   ;; Action is applicable only in unitary pipeline segments
   (unitary ?pipe)

   ;; Bind batch-atom products
   (is-product ?batch-atom-in ?product-batch-atom-in)
   (is-product ?first-batch-atom ?product-first-batch)

   ;; Interface restriction
   (may-interface ?product-batch-atom-in ?product-first-batch)

   ;; Binds tank-slot, must be occupied
   (tank-slot-product-location ?to-tank-slot ?product-batch-atom-in ?to-area)
   (occupied ?to-tank-slot)

   ;; Binds tank-slot, must be freed
   (tank-slot-product-location ?from-tank-slot ?product-first-batch ?from-area)
   (not-occupied ?from-tank-slot)

 )
  :effect
   (and 
     ;; The inserted unitary batch will be the pipeline segment
     ;; new last batch
     (last ?batch-atom-in ?pipe)
     (not (last ?first-batch-atom ?pipe))
     (first ?batch-atom-in ?pipe)
     (not (first ?first-batch-atom ?pipe))

     ;; Inserted batch-atom is removed from area
     (not (on ?batch-atom-in ?to-area))

     ;; Origin tank-slot is freed
     (not (occupied ?to-tank-slot))
     (not-occupied ?to-tank-slot)

     ;; Batch-atom removed from pipeline segment is inserted 
     ;; into the destination area
     (on ?first-batch-atom ?from-area)

     ;; Tank-slot that receives the batch is occupied
     (occupied ?from-tank-slot)
     (not (not-occupied ?from-tank-slot))


)
)
)
