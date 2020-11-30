;; Woodworking
;;

(define (domain woodworking)
  (:requirements :typing :durative-actions :numeric-fluents)
  (:types
      acolour awood woodobj machine 
      surface treatmentstatus - object
      highspeed-saw glazer grinder immersion-varnisher
      planer saw spray-varnisher - machine
      board part - woodobj)

  (:constants
              verysmooth smooth rough - surface
              varnished glazed untreated colourfragments - treatmentstatus
              natural - acolour)

  (:predicates 
            (idle ?machine - machine)
            (unused ?obj - part)
            (available ?obj - woodobj)

            (surface-condition ?obj - woodobj ?surface - surface)
            (treatment ?obj - part ?treatment - treatmentstatus)
            (colour ?obj - part ?colour - acolour)
            (wood ?obj - woodobj ?wood - awood)

            (in-highspeed-saw ?b - board ?m - highspeed-saw)
            (empty ?m - highspeed-saw)
            (has-colour ?machine - machine ?colour - acolour)
            (grind-treatment-change ?old ?new - treatmentstatus)
            (is-smooth ?surface - surface))
      
  (:functions
            (board-size ?board - board) 
            (goal-size ?obj - part))

  (:durative-action do-immersion-varnish
    :parameters (?x - part ?m - immersion-varnisher 
                 ?newcolour - acolour ?surface - surface)
    :duration (= ?duration 10)
    :condition (and
            (at start (idle ?m))
            (at start (available ?x))
            (at start (surface-condition ?x ?surface))
            (at start (is-smooth ?surface))
            (at start (has-colour ?m ?newcolour))
            (at start (treatment ?x untreated)))
    :effect (and 
            (at start (not (idle ?m)))
            (at start (not (available ?x)))
            (at start (not (treatment ?x untreated)))
            (at start (not (colour ?x natural)))
            (at end (idle ?m))
            (at end (available ?x))
            (at end (treatment ?x varnished))
            (at end (colour ?x ?newcolour))))

  (:durative-action do-spray-varnish
    :parameters (?x - part ?m - spray-varnisher 
                 ?newcolour - acolour ?surface - surface)
    :duration (= ?duration (goal-size ?x))
    :condition (and
            (at start (idle ?m))
            (at start (available ?x))
            (at start (surface-condition ?x ?surface))
            (at start (is-smooth ?surface))
            (at start (has-colour ?m ?newcolour))
            (at start (treatment ?x untreated)))
    :effect (and 
            (at start (not (idle ?m)))
            (at start (not (available ?x)))
            (at start (not (treatment ?x untreated)))
            (at start (not (colour ?x natural)))
            (at end (idle ?m))
            (at end (available ?x))
            (at end (treatment ?x varnished))
            (at end (colour ?x ?newcolour))))

  (:durative-action do-glaze
    :parameters (?x - part ?m - glazer 
                 ?newcolour - acolour)
    :duration (= ?duration (+ (goal-size ?x) 5))
    :condition (and
            (at start (idle ?m))
            (at start (available ?x))
            (at start (has-colour ?m ?newcolour))
            (at start (treatment ?x untreated)))
    :effect (and 
            (at start (not (idle ?m)))
            (at start (not (available ?x)))
            (at start (not (treatment ?x untreated)))
            (at start (not (colour ?x natural)))
            (at end (idle ?m))
            (at end (available ?x))
            (at end (treatment ?x glazed))
            (at end (colour ?x ?newcolour))))

  (:durative-action do-grind
    :parameters (?x - part ?m - grinder ?oldsurface - surface
                 ?oldcolour - acolour 
                 ?oldtreatment ?newtreatment - treatmentstatus) 
    :duration (= ?duration (* 3 (goal-size ?x)))
    :condition (and 
            (at start (idle ?m))
            (at start (available ?x))
            (at start (surface-condition ?x ?oldsurface))
            (at start (is-smooth ?oldsurface)) 
            (at start (colour ?x ?oldcolour))
            (at start (treatment ?x ?oldtreatment))
            (at start (grind-treatment-change ?oldtreatment ?newtreatment)))
    :effect (and
            (at start (not (idle ?m)))
            (at start (not (available ?x)))
            (at start (not (surface-condition ?x ?oldsurface)))
            (at start (not (treatment ?x ?oldtreatment)))
            (at start (not (colour ?x ?oldcolour)))
            (at end (idle ?m))
            (at end (available ?x))
            (at end (surface-condition ?x verysmooth))
            (at end (treatment ?x ?newtreatment))
            (at end (colour ?x natural))))

  (:durative-action do-plane
    :parameters (?x - part ?m - planer ?oldsurface - surface
                 ?oldcolour - acolour ?oldtreatment - treatmentstatus) 
    :duration (= ?duration (* 2 (goal-size ?x)))
    :condition (and 
            (at start (idle ?m))
            (at start (available ?x))
            (at start (surface-condition ?x ?oldsurface))
            (at start (treatment ?x ?oldtreatment))
            (at start (colour ?x ?oldcolour)))
    :effect (and
            (at start (not (idle ?m)))
            (at start (not (available ?x)))
            (at start (not (surface-condition ?x ?oldsurface)))
            (at start (not (treatment ?x ?oldtreatment)))
            (at start (not (colour ?x ?oldcolour)))
            (at end (idle ?m))
            (at end (available ?x))
            (at end (surface-condition ?x smooth))
            (at end (treatment ?x untreated))
            (at end (colour ?x natural))))

  (:durative-action load-highspeed-saw
    :parameters (?b - board ?m - highspeed-saw)
    :duration (= ?duration 30)
    :condition (and
            (at start (idle ?m))
            (at start (empty ?m))
            (at start (available ?b)))
    :effect (and
            (at start (not (idle ?m)))
            (at start (not (available ?b)))
            (at start (not (empty ?m)))
            (at end (idle ?m))
            (at end (in-highspeed-saw ?b ?m))))
            
  (:durative-action unload-highspeed-saw
    :parameters (?b - board ?m - highspeed-saw)
    :duration (= ?duration 10)
    :condition (and
            (at start (idle ?m))
            (at start (in-highspeed-saw ?b ?m)))
    :effect (and
            (at start (not (idle ?m)))
            (at end (available ?b))
            (at end (not (in-highspeed-saw ?b ?m)))
            (at end (empty ?m))
            (at end (idle ?m))))
            
  (:durative-action cut-board
    :parameters (?b - board ?p - part ?m - highspeed-saw ?w - awood
                 ?surface - surface)
    :duration (= ?duration 10)
    :condition (and
            (at start (idle ?m))
            (at start (unused ?p))
            (at start (in-highspeed-saw ?b ?m))
            (at start (wood ?b ?w))
            (at start (surface-condition ?b ?surface))
            (at start (>= (board-size ?b) (goal-size ?p))))
    :effect (and
            (at start (not (idle ?m)))
            (at start (not (unused ?p)))
            (at start (decrease (board-size ?b) (goal-size ?p)))
            (at end (idle ?m))
            (at end (available ?p))
            (at end (wood ?p ?w))
            (at end (surface-condition ?p ?surface))
            (at end (colour ?p natural)) 
            (at end (treatment ?p untreated)))) 

  (:durative-action do-saw
    :parameters (?b - board ?p - part ?m - saw ?w - awood
                 ?surface - surface)
    :duration (= ?duration 30)
    :condition (and 
            (at start (idle ?m))
            (at start (unused ?p))
            (at start (available ?b))
            (at start (wood ?b ?w))
            (at start (surface-condition ?b ?surface))
            (at start (>= (board-size ?b) (goal-size ?p))))
    :effect (and
            (at start (not (idle ?m)))
            (at start (not (unused ?p)))
            (at start (not (available ?b)))
            (at end (decrease (board-size ?b) (goal-size ?p)))
            (at end (idle ?m))
            (at end (available ?p))
            (at end (available ?b))
            (at end (wood ?p ?w))
            (at end (surface-condition ?p ?surface))
            (at end (colour ?p natural)) 
            (at end (treatment ?p untreated)))) 
)
