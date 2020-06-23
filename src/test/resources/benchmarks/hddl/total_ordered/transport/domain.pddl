(define (domain transport)
  (:requirements :typing :total-ordered-htn)
  (:types
        location target locatable - object
        vehicle package - locatable
        capacity_number - object
  )

  (:predicates
     (road ?l1 ?l2 - location)
     (at ?x - locatable ?v - location)
     (in ?x - package ?v - vehicle)
     (capacity ?v - vehicle ?s1 - capacity_number)
     (capacity_predecessor ?s1 ?s2 - capacity_number)
  )

  (:tasks
    (deliver ?p - package ?l - location)
    (get-to ?v - vehicle ?l - location)
    (load ?v - vehicle ?l - location ?p - package)
    (unload ?v - vehicle ?l - location ?p - package)
  )

  (:method m-deliver
    :parameters (?p - package ?l1 ?l2 - location ?v - vehicle)
    :task (deliver ?p ?l2)
    :ordered-subtasks (and
      (get-to ?v ?l1)
      (load ?v ?l1 ?p)
      (get-to ?v ?l2)
      (unload ?v ?l2 ?p))
  )

  (:method m-unload
    :parameters (?v - vehicle ?l - location ?p - package ?s1 ?s2 - capacity_number)
    :task (unload ?v ?l ?p)
    :ordered-subtasks (drop ?v ?l ?p ?s1 ?s2)
  )

  (:method m-load
    :parameters (?v - vehicle ?l - location ?p - package ?s1 ?s2 - capacity_number)
    :task (load  ?v ?l ?p)
    :ordered-subtasks (pick-up ?v ?l ?p ?s1 ?s2)
  )

  (:method m-drive-to
    :parameters (?v - vehicle ?l1 ?l2 - location)
    :task (get-to ?v ?l2)
    :ordered-subtasks (and
        (drive ?v ?l1 ?l2))
  )

  (:method m-drive-to-via
    :parameters (?v - vehicle ?l2 ?l3 - location)
    :task (get-to  ?v ?l3)
    :ordered-subtasks (and
        (get-to ?v ?l2)
        (drive ?v ?l2 ?l3))
  )

  (:method m-i-am-there
    :parameters (?v - vehicle ?l - location)
    :task (get-to  ?v ?l)
    :ordered-subtasks (and
        (noop ?v ?l))
  )

  (:action drive
    :parameters (?v - vehicle ?l1 ?l2 - location)
    :precondition (and
        (at ?v ?l1)
        (road ?l1 ?l2))
    :effect (and
        (not (at ?v ?l1))
        (at ?v ?l2))
  )

  (:action noop
    :parameters (?v - vehicle ?l2 - location)
    :precondition (at ?v ?l2)
    :effect ()
  )

 (:action pick-up
    :parameters (?v - vehicle ?l - location ?p - package ?s1 ?s2 - capacity_number)
    :precondition (and
        (at ?v ?l)
        (at ?p ?l)
        (capacity_predecessor ?s1 ?s2)
        (capacity ?v ?s2)
      )
    :effect (and
        (not (at ?p ?l))
        (in ?p ?v)
        (capacity ?v ?s1)
        (not (capacity ?v ?s2))
      )
  )

  (:action drop
    :parameters (?v - vehicle ?l - location ?p - package ?s1 ?s2 - capacity_number)
    :precondition (and
        (at ?v ?l)
        (in ?p ?v)
        (capacity_predecessor ?s1 ?s2)
        (capacity ?v ?s1)
      )
    :effect (and
        (not (in ?p ?v))
        (at ?p ?l)
        (capacity ?v ?s2)
        (not (capacity ?v ?s1))
      )
  )

)
