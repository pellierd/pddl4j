


(define (problem mixed-f12-p6-u20-v5-g5-a60-n10-A20-B80-N50-F5-r4)
   (:domain miconic)
   (:objects p1 - passenger
             p3 - going_up
             p3 - conflict_A
             p0 p2 p4 p5 - conflict_B
             f0 f1 f2 f3 f4 f5 f6 f7 f8 f9 
             f10 f11 - floor)


(:init
(above f0 f1)
(above f0 f2)
(above f0 f3)
(above f0 f4)
(above f0 f5)
(above f0 f6)
(above f0 f7)
(above f0 f8)
(above f0 f9)
(above f0 f10)
(above f0 f11)

(above f1 f2)
(above f1 f3)
(above f1 f4)
(above f1 f5)
(above f1 f6)
(above f1 f7)
(above f1 f8)
(above f1 f9)
(above f1 f10)
(above f1 f11)

(above f2 f3)
(above f2 f4)
(above f2 f5)
(above f2 f6)
(above f2 f7)
(above f2 f8)
(above f2 f9)
(above f2 f10)
(above f2 f11)

(above f3 f4)
(above f3 f5)
(above f3 f6)
(above f3 f7)
(above f3 f8)
(above f3 f9)
(above f3 f10)
(above f3 f11)

(above f4 f5)
(above f4 f6)
(above f4 f7)
(above f4 f8)
(above f4 f9)
(above f4 f10)
(above f4 f11)

(above f5 f6)
(above f5 f7)
(above f5 f8)
(above f5 f9)
(above f5 f10)
(above f5 f11)

(above f6 f7)
(above f6 f8)
(above f6 f9)
(above f6 f10)
(above f6 f11)

(above f7 f8)
(above f7 f9)
(above f7 f10)
(above f7 f11)

(above f8 f9)
(above f8 f10)
(above f8 f11)

(above f9 f10)
(above f9 f11)

(above f10 f11)



(origin p0 f9)
(destin p0 f8)

(origin p1 f2)
(destin p1 f1)

(origin p2 f2)
(destin p2 f3)

(origin p3 f6)
(destin p3 f9)

(origin p4 f8)
(destin p4 f1)

(origin p5 f7)
(destin p5 f1)



(no-access p1 f4)



(lift-at f0)
)


(:goal (forall (?p - passenger) (served ?p)))
)


