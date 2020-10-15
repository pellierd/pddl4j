


(define (problem mixed-f6-p3-u20-v5-g5-a60-n10-A20-B80-N50-F5-r3)
   (:domain miconic)
   (:objects p0 p1 p2 - passenger
             f0 f1 f2 f3 f4 f5 - floor)


(:init
(above f0 f1)
(above f0 f2)
(above f0 f3)
(above f0 f4)
(above f0 f5)

(above f1 f2)
(above f1 f3)
(above f1 f4)
(above f1 f5)

(above f2 f3)
(above f2 f4)
(above f2 f5)

(above f3 f4)
(above f3 f5)

(above f4 f5)



(origin p0 f5)
(destin p0 f0)

(origin p1 f1)
(destin p1 f3)

(origin p2 f0)
(destin p2 f5)






(lift-at f0)
)


(:goal (forall (?p - passenger) (served ?p)))
)


