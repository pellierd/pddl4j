(define (problem elevators-time-p8_6_1)
(:domain elevators-time-numeric)

(:objects 
f0 f1 f2 f3 f4 f5 f6 f7 f8  - floor
p0 p1 p2 p3 p4 p5  - passenger
fast0 fast1  - fast-elevator
slow0-0 slow1-0 - slow-elevator
)

(:init
(above f0 f1) (above f0 f2) (above f0 f3) (above f0 f4) (above f0 f5) (above f0 f6) (above f0 f7) (above f0 f8) 
(above f1 f2) (above f1 f3) (above f1 f4) (above f1 f5) (above f1 f6) (above f1 f7) (above f1 f8) 
(above f2 f3) (above f2 f4) (above f2 f5) (above f2 f6) (above f2 f7) (above f2 f8) 
(above f3 f4) (above f3 f5) (above f3 f6) (above f3 f7) (above f3 f8) 
(above f4 f5) (above f4 f6) (above f4 f7) (above f4 f8) 
(above f5 f6) (above f5 f7) (above f5 f8) 
(above f6 f7) (above f6 f8) 
(above f7 f8) 

(lift-at fast0 f0)
(= (passengers fast0) 0)
(= (capacity fast0) 3)
(reachable-floor fast0 f0)(reachable-floor fast0 f2)(reachable-floor fast0 f4)(reachable-floor fast0 f6)(reachable-floor fast0 f8)

(lift-at fast1 f0)
(= (passengers fast1) 0)
(= (capacity fast1) 3)
(reachable-floor fast1 f0)(reachable-floor fast1 f2)(reachable-floor fast1 f4)(reachable-floor fast1 f6)(reachable-floor fast1 f8)

(lift-at slow0-0 f1)
(= (passengers slow0-0) 0)
(= (capacity slow0-0) 2)
(reachable-floor slow0-0 f0)(reachable-floor slow0-0 f1)(reachable-floor slow0-0 f2)(reachable-floor slow0-0 f3)(reachable-floor slow0-0 f4)

(lift-at slow1-0 f4)
(= (passengers slow1-0) 0)
(= (capacity slow1-0) 2)
(reachable-floor slow1-0 f4)(reachable-floor slow1-0 f5)(reachable-floor slow1-0 f6)(reachable-floor slow1-0 f7)(reachable-floor slow1-0 f8)

(passenger-at p0 f2)
(passenger-at p1 f4)
(passenger-at p2 f8)
(passenger-at p3 f4)
(passenger-at p4 f0)
(passenger-at p5 f6)

(= (travel-slow f0 f1) 12) (= (travel-slow f0 f2) 20) (= (travel-slow f0 f3) 28) (= (travel-slow f0 f4) 36) (= (travel-slow f1 f2) 12) (= (travel-slow f1 f3) 20) (= (travel-slow f1 f4) 28) (= (travel-slow f2 f3) 12) (= (travel-slow f2 f4) 20) (= (travel-slow f3 f4) 12) 

(= (travel-slow f4 f5) 12) (= (travel-slow f4 f6) 20) (= (travel-slow f4 f7) 28) (= (travel-slow f4 f8) 36) (= (travel-slow f5 f6) 12) (= (travel-slow f5 f7) 20) (= (travel-slow f5 f8) 28) (= (travel-slow f6 f7) 12) (= (travel-slow f6 f8) 20) (= (travel-slow f7 f8) 12) 


(= (travel-fast f0 f2) 11) (= (travel-fast f0 f4) 13) (= (travel-fast f0 f6) 15) (= (travel-fast f0 f8) 17) 

(= (travel-fast f2 f4) 11) (= (travel-fast f2 f6) 13) (= (travel-fast f2 f8) 15) 

(= (travel-fast f4 f6) 11) (= (travel-fast f4 f8) 13) 

(= (travel-fast f6 f8) 11) 

)

(:goal
(and
(passenger-at p0 f8)
(passenger-at p1 f6)
(passenger-at p2 f0)
(passenger-at p3 f7)
(passenger-at p4 f3)
(passenger-at p5 f2)
))

(:metric minimize (total-time))

)
