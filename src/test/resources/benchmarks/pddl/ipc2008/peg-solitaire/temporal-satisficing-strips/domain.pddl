;; Peg Solitaire domain

(define (domain pegsolitaire-temporal)
    (:requirements :typing :durative-actions)
    (:types location - object)
    (:predicates
        (IN-LINE ?x ?y ?z - location)
        (occupied ?l - location)
        (free ?l - location)
    )

    (:durative-action jump
     :parameters (?from - location ?over - location ?to - location)
     :duration (= ?duration 1)
     :condition (and 
                    (over all (IN-LINE ?from ?over ?to))
                    (at start (occupied ?from))
                    (at start (occupied ?over))
                    (at start (free ?to))
                )
     :effect (and
                 (at start (not (occupied ?from)))
                 (at start (not (occupied ?over)))
                 (at start (not (free ?to)))
                 (at end (free ?from))
                 (at end (free ?over))
                 (at end (occupied ?to))
             )
    )
)
