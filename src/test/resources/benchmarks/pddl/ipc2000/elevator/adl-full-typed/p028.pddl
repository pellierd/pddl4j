


(define (problem mixed-f12-p6-u20-v5-g5-a60-n10-A20-B80-N50-F5-r2)
   (:domain miconic)
   (:objects p5 - passenger
             p1 - going_down
             p0 - conflict_A
             p4 p3 p2 p1 - conflict_B
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



(origin p0 f3)
(destin p0 f2)

(origin p1 f11)
(destin p1 f7)

(origin p2 f2)
(destin p2 f6)

(origin p3 f6)
(destin p3 f1)

(origin p4 f0)
(destin p4 f1)

(origin p5 f8)
(destin p5 f4)



(no-access p0 f6)
(no-access p5 f0)
(no-access p5 f1)
(no-access p5 f11)



(lift-at f0)
)


(:goal (forall (?p - passenger) (served ?p)))
)


