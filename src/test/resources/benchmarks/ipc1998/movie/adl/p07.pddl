(define (problem movie-x-7)
   (:domain movie-dom)
   (:objects c11 c10 c9 c8 c7 c6 c5 c4 c3 c2 c1 - chips
             d11 d10 d9 d8 d7 d6 d5 d4 d3 d2 d1 - dip
             p11 p10 p9 p8 p7 p6 p5 p4 p3 p2 p1 - pop
             z11 z10 z9 z8 z7 z6 z5 z4 z3 z2 z1 - cheese
             k11 k10 k9 k8 k7 k6 k5 k4 k3 k2 k1 - crackers)
   (:init (not (movie-rewound))
          (not (counter-at-two-hours))
          (not (counter-at-zero)))
   (:goal (and (movie-rewound)
               (counter-at-zero)
               (have-chips)
               (have-dip)
               (have-pop)
               (have-cheese)
               (have-crackers))))