


(define (problem mixed-f2-p1-u20-v5-g5-a60-n10-A20-B80-N50-F5-r1)
   (:domain miconic)
   (:objects p0 - passenger
             f0 f1 - floor)


(:init
(above f0 f1)



(origin p0 f0)
(destin p0 f1)






(lift-at f0)
)


(:goal (forall (?p - passenger) (served ?p)))
)


