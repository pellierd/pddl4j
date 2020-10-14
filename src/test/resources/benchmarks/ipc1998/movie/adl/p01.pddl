(define (problem movie-x-1)
   (:domain movie-dom)
   (:objects c5 c4 c3 c2 c1 - chips
             d5 d4 d3 d2 d1 - dip
             p5 p4 p3 p2 p1 - pop
             z5 z4 z3 z2 z1 - cheese
             k5 k4 k3 k2 k1 - crackers)
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