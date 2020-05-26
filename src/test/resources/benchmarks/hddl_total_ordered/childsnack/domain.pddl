(define (domain childsnack)

  (:requirements :typing :total-ordered-htn :htn-method-preconditions :negative-preconditions)

  (:types child - object
          bread-portion - object
          content-portion - object
          sandwich - object
          tray - object
          place - object
  )

  (:constants kitchen - place)

  (:predicates
          (at_kitchen_bread ?b - bread-portion)
          (at_kitchen_content ?c - content-portion)
          (at_kitchen_sandwich ?s - sandwich)
          (no_gluten_bread ?b - bread-portion)
          (no_gluten_content ?c - content-portion)
          (on_tray ?s - sandwich ?t - tray)
          (no_gluten_sandwich ?s - sandwich)
          (allergic_gluten ?c - child)
          (not_allergic_gluten ?c - child)
          (served ?c - child)
          (waiting ?c - child ?p - place)
          (at ?t - tray ?p - place)
          (not_exist ?s - sandwich)
    )

    (:tasks
          (serve ?c - child)
          (bring ?s  - sandwich ?c - child)
    )

    (:method serve_allergic_child
  		:parameters (?c - child ?s - sandwich ?b - bread-portion ?ct - content-portion)
  		:task (serve ?c)
  		:precondition (and
  			(allergic_gluten ?c)
            (not (served ?c))
  		)
  		:ordered-subtasks (and
            (make_no_gluten_sandwich ?s ?b ?ct)
            (bring ?s ?c)
        )
  	)

    (:method serve_not_allergic_child
  		:parameters (?c - child ?s - sandwich ?b - bread-portion ?ct - content-portion)
  		:task (serve ?c)
  		:precondition (and
  			(not_allergic_gluten ?c)
            (not (served ?c))
  		)
  		:ordered-subtasks (and
            (make_sandwich ?s ?b ?ct)
            (bring ?s ?c)
        )
  	)

    (:method bring_on_tray
  		:parameters (?s - sandwich ?c - child ?p - place ?t - tray)
  		:task (bring ?s ?c)
  		:precondition ()
  		:ordered-subtasks (and
            (put_on_tray ?s ?t)
            (move_tray ?t kitchen ?p)
            (serve_sandwich ?s ?c ?t ?p)
            (move_tray ?t ?p kitchen)
        )
     )

    (:action put_on_tray
    	 :parameters (?s - sandwich ?t - tray)
    	 :precondition (and
            (at_kitchen_sandwich ?s)
            (at ?t kitchen)
         )
    	 :effect (and
    		   (not (at_kitchen_sandwich ?s))
    		   (on_tray ?s ?t)
        )
    )

   (:action move_tray
   	 :parameters (?t - tray ?from ?to - place)
   	 :precondition (and (at ?t ?from))
   	 :effect (and
        (not (at ?t ?from))
   		  (at ?t ?to)
   		)
    )

   (:action serve_sandwich
   	:parameters (?s - sandwich ?c - child ?t - tray ?p - place)
   	:precondition (and
        (not_allergic_gluten ?c)
   	    (waiting ?c ?p)
   			(on_tray ?s ?t)
   			(at ?t ?p))
   	:effect (and
        (not (on_tray ?s ?t))
   		  (served ?c))
   )

   (:action make_no_gluten_sandwich
   	 :parameters (?s - sandwich ?b - bread-portion ?c - content-portion)
   	 :precondition (and
            (at_kitchen_bread ?b)
   			    (at_kitchen_content ?c)
   			    (no_gluten_bread ?b)
   			    (no_gluten_content ?c)
   			    (not_exist ?s))
   	 :effect (and
   		   (not (at_kitchen_bread ?b))
   		   (not (at_kitchen_content ?c))
   		   (at_kitchen_sandwich ?s)
   		   (no_gluten_sandwich ?s)
         (not (not_exist ?s)))
   )

   (:action make_sandwich
   	 :parameters (?s - sandwich ?b - bread-portion ?c - content-portion)
   	 :precondition (and
            (at_kitchen_bread ?b)
   			    (at_kitchen_content ?c)
            (not_exist ?s))
   	 :effect (and
   		   (not (at_kitchen_bread ?b))
   		   (not (at_kitchen_content ?c))
   		   (at_kitchen_sandwich ?s)
         (not (not_exist ?s)))
   )
)
