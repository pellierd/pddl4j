;; Schedule World
;;

(define (domain schedule)
  (:requirements :adl)

  (:constants cold hot cylindrical polisher roller lathe grinder punch drill-press
	      spray-painter immersion-painter polished rough smooth)

  (:predicates (part ?obj)
	       (temperature ?obj ?temp)
	       (busy ?machine)
	       (scheduled ?obj)
	       (objscheduled)
	       (surface-condition ?obj ?surface-cond)
	       (shape ?obj ?shape)
	       (painted ?obj ?colour)
	       (has-hole ?obj ?width ?orientation)
	       (has-bit ?machine ?width)
	       (can-orient ?machine ?orientation)
	       (has-paint ?machine ?colour))

  (:action do-polish
	   :parameters (?x)
	   :precondition (and (part ?x)
			      (not (busy polisher))
			      (not (scheduled ?x))
			      (temperature ?x cold))
	   :effect (and (busy polisher)
			(scheduled ?x)
			(surface-condition ?x polished)
			(when (not (objscheduled))
			  (objscheduled))
			(forall (?oldsurface)
				(when (surface-condition ?x ?oldsurface)
				  (not (surface-condition ?x ?oldsurface))))))

  (:action do-roll
	   :parameters (?x)
	   :precondition (and (part ?x)
			      (not (busy roller))
			      (not (scheduled ?x)))
	   :effect (and
		    (busy roller)
		    (scheduled ?x)
		    (temperature ?x hot)
		    (shape ?x cylindrical)
		    (when (not (objscheduled))
		      (objscheduled))
		    (forall (?oldsurface)
			    (when (surface-condition ?x ?oldsurface)
			      (not (surface-condition ?x ?oldsurface))))
		    (forall (?oldpaint)
			    (when (painted ?x ?oldpaint)
			      (not (painted ?x ?oldpaint))))
		    (forall (?oldwidth ?oldorient)
			    (when (has-hole ?x ?oldwidth ?oldorient)
			      (not (has-hole ?x ?oldwidth ?oldorient))))
		    (forall (?oldshape)
			    (when (shape ?x ?oldshape)
			      (not (shape ?x ?oldshape))))
		    (forall (?oldtemp)
			    (when (temperature ?x ?oldtemp)
			      (not (temperature ?x ?oldtemp))))))

  (:action do-lathe
	   :parameters (?x) 
	   :precondition (and (part ?x)
			      (not (busy lathe))
			      (not (scheduled ?x)))
	   :effect (and 
		    (busy lathe)
		    (scheduled ?x)
		    (surface-condition ?x rough)
		    (shape ?x cylindrical)
		    (when (not (objscheduled))
		      (objscheduled))
		    (forall (?oldshape)
			    (when (shape ?x ?oldshape)
			      (not (shape ?x ?oldshape))))
		    (forall (?oldsurface)
			    (when (surface-condition ?x ?oldsurface)
			      (not (surface-condition ?x ?oldsurface))))
		    (forall (?oldpaint)
			    (when (painted ?x ?oldpaint)
			    (not (painted ?x ?oldpaint))))))

  (:action do-grind
	   :parameters (?x) 
	   :precondition (and (part ?x)
			      (not (busy grinder))
			      (not (scheduled ?x)))
	   :effect (and
		    (busy GRINDER)
		    (scheduled ?x)
		    (surface-condition ?x smooth)
		    (when (not (objscheduled))
		      (objscheduled))
		    (forall (?oldsurface)
			    (when (surface-condition ?x ?oldsurface)
			      (not (surface-condition ?x ?oldsurface))))
		    (forall (?oldpaint)
			    (when (painted ?x ?oldpaint)
			      (not (painted ?x ?oldpaint))))))

  (:action do-punch
	   :parameters (?x ?width ?orient) 
	   :precondition (and
			  (part ?x)
			  (has-bit punch ?width)
			  (can-orient punch ?orient)
			  (temperature ?x cold)
			  (not (busy punch))
			  (not (scheduled ?x))
			  (not (has-hole ?x ?width ?orient)))
	   :effect (and
		    (busy punch)
		    (scheduled ?x)
		    (has-hole ?x ?width ?orient)
		    (surface-condition ?x rough)
		    (when (not (objscheduled))
		      (objscheduled))
		    (forall (?oldsurface) 
			    (when (surface-condition ?x ?oldsurface)
			      (not (surface-condition ?x ?oldsurface))))))

  (:action do-drill-press
	   :parameters (?x ?width ?orient)
	   :precondition (and
			  (part  ?x)
			  (has-bit drill-press ?width)
			  (can-orient drill-press ?orient)
			  (temperature ?x cold)
			  (not (busy drill-press))
			  (not (scheduled ?x))
			  (not (has-hole ?x ?width ?orient)))
	   :effect (and
		    (busy drill-press)
		    (scheduled ?x)
		    (has-hole ?x ?width ?orient)
		    (when (not (objscheduled))
		      (objscheduled))))

  (:action do-spray-paint
	   :parameters (?x ?newpaint) 
	   :precondition (and
			  (part ?x)
			  (has-paint spray-painter ?newpaint)
			  (not (busy spray-painter))
			  (not (scheduled ?x))
			  (temperature ?x cold))
	   :effect (and
		    (busy spray-painter)
		    (scheduled ?x)
		    (painted ?x ?newpaint)
		    (when (not (objscheduled))
		      (objscheduled))
		    (forall (?oldsurface)
			    (when (surface-condition ?x ?oldsurface)
			      (not (surface-condition ?x ?oldsurface))))
		    (forall (?oldpaint)
			    (when (painted ?x ?oldpaint)
			      (not (painted ?x ?oldpaint))))))

  (:action do-immersion-paint
           :parameters (?x ?newpaint) 
           :precondition (and
                          (part ?x)
                          (has-paint immersion-painter ?newpaint)
                          (not (busy immersion-painter))
                          (not (scheduled ?x)))
           :effect (and
                    (busy immersion-painter)
                    (scheduled ?x)
                    (painted ?x ?newpaint)
                    (when (not (objscheduled))
                      (objscheduled))
                    (forall (?oldpaint)
                            (when (painted ?x ?oldpaint)
                              (not (painted ?x ?oldpaint))))))
  
  (:action do-time-step
           :parameters ()
           :precondition (objscheduled)
	 :effect (and
		  (forall (?x)
			  (when (scheduled ?x)
			    (not (scheduled ?x))))
		  (forall (?m)
			  (when (busy ?m)
			    (not (busy ?m)))))))








