(define (problem movie-x-28)
   (:domain movie-dom)
   (:objects c32 c31 c30 c29 c28 c27 c26 c25 c24 c23 c22 c21 c20 c19 c18 c17
             c16 c15 c14 c13 c12 c11 c10 c9 c8 c7 c6 c5 c4 c3 c2 c1 - chips
             d32 d31 d30 d29 d28 d27 d26 d25 d24 d23 d22 d21 d20 d19 d18 d17 d16
             d15 d14 d13 d12 d11 d10 d9 d8 d7 d6 d5 d4 d3 d2 d1 - dip
             p32 p31 p30 p29 p28 p27 p26 p25 p24 p23 p22 p21 p20 p19 p18 p17 p16
             p15 p14 p13 p12 p11 p10 p9 p8 p7 p6 p5 p4 p3 p2 p1 - pop
             z32 z31 z30 z29 z28 z27 z26 z25 z24 z23 z22 z21 z20 z19 z18 z17 z16
             z15 z14 z13 z12 z11 z10 z9 z8 z7 z6 z5 z4 z3 z2 z1 - cheese
             k32 k31 k30 k29 k28 k27 k26 k25 k24 k23 k22 k21 k20 k19 k18 k17 k16
             k15 k14 k13 k12 k11 k10 k9 k8 k7 k6 k5 k4 k3 k2 k1 - crackers)
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