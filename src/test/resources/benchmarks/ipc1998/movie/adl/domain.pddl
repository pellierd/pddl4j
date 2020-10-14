(define (domain movie-dom) (:requirements :adl :typing)
  (:types chips dip pop cheese crackers - object)
  (:predicates (movie-rewound)
               (counter-at-two-hours)
               (counter-at-zero)
               (have-chips)
               (have-dip)
               (have-pop)
               (have-cheese)
               (have-crackers))




  (:action rewind-movie
           :parameters ()
           :precondition ()
           :effect (and (movie-rewound)
                        ;; Let's assume that the movie is 2 hours long
                        (when (not (counter-at-two-hours))
                          (not (counter-at-zero)))))

  (:action reset-counter
           :parameters ()
           :precondition ()
           :effect (counter-at-zero))


  ;;; Get the food and snacks for the movie
  (:action get-chips
           :parameters (?x - chips)
           :precondition ()
           :effect (have-chips))

  (:action get-dip
           :parameters (?x - dip)
           :precondition ()
           :effect (have-dip))

  (:action get-pop
           :parameters (?x - pop)
           :precondition ()
           :effect (have-pop))

  (:action get-cheese
           :parameters (?x - cheese)
           :precondition ()
           :effect (have-cheese))

  (:action get-crackers
           :parameters (?x - crackers)
           :precondition ()
           :effect (have-crackers)))
