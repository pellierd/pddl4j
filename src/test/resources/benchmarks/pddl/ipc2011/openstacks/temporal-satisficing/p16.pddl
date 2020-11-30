(define (problem os-time-p40_1)
(:domain openstacks-time-nonADL-nonNegated)
(:objects 
n0 n1 n2 n3 n4 n5 n6 n7 n8 n9 n10 n11 n12 n13 n14 n15 n16 n17 n18 n19 n20 n21 n22 n23 n24 n25 n26 n27 n28 n29 n30 n31 n32 n33 n34 n35 n36  - count
)

(:init
(next-count n0 n1) (next-count n1 n2) (next-count n2 n3) (next-count n3 n4) (next-count n4 n5) (next-count n5 n6) (next-count n6 n7) (next-count n7 n8) (next-count n8 n9) (next-count n9 n10) (next-count n10 n11) (next-count n11 n12) (next-count n12 n13) (next-count n13 n14) (next-count n14 n15) (next-count n15 n16) (next-count n16 n17) (next-count n17 n18) (next-count n18 n19) (next-count n19 n20) (next-count n20 n21) (next-count n21 n22) (next-count n22 n23) (next-count n23 n24) (next-count n24 n25) (next-count n25 n26) (next-count n26 n27) (next-count n27 n28) (next-count n28 n29) (next-count n29 n30) (next-count n30 n31) (next-count n31 n32) (next-count n32 n33) (next-count n33 n34) (next-count n34 n35) (next-count n35 n36) 
(stacks-avail n36)

(waiting o1)
(includes o1 p6)(includes o1 p17)(includes o1 p19)(includes o1 p25)(includes o1 p34)(includes o1 p39)

(waiting o2)
(includes o2 p2)(includes o2 p11)(includes o2 p35)

(waiting o3)
(includes o3 p9)(includes o3 p19)

(waiting o4)
(includes o4 p1)(includes o4 p4)(includes o4 p10)(includes o4 p16)(includes o4 p22)(includes o4 p36)

(waiting o5)
(includes o5 p3)(includes o5 p5)(includes o5 p30)(includes o5 p31)(includes o5 p40)

(waiting o6)
(includes o6 p7)(includes o6 p16)(includes o6 p22)(includes o6 p39)

(waiting o7)
(includes o7 p10)(includes o7 p21)(includes o7 p36)

(waiting o8)
(includes o8 p11)(includes o8 p20)(includes o8 p22)(includes o8 p26)(includes o8 p32)(includes o8 p33)

(waiting o9)
(includes o9 p4)(includes o9 p6)(includes o9 p7)(includes o9 p14)(includes o9 p24)(includes o9 p30)

(waiting o10)
(includes o10 p3)(includes o10 p7)(includes o10 p12)(includes o10 p22)(includes o10 p39)

(waiting o11)
(includes o11 p12)(includes o11 p34)

(waiting o12)
(includes o12 p3)(includes o12 p14)(includes o12 p18)(includes o12 p24)(includes o12 p25)(includes o12 p30)(includes o12 p38)

(waiting o13)
(includes o13 p2)(includes o13 p8)(includes o13 p27)(includes o13 p40)

(waiting o14)
(includes o14 p1)(includes o14 p27)(includes o14 p28)(includes o14 p32)(includes o14 p36)

(waiting o15)
(includes o15 p27)

(waiting o16)
(includes o16 p2)(includes o16 p7)(includes o16 p15)(includes o16 p20)(includes o16 p24)

(waiting o17)
(includes o17 p3)(includes o17 p25)(includes o17 p37)(includes o17 p39)

(waiting o18)
(includes o18 p11)(includes o18 p20)(includes o18 p22)(includes o18 p31)(includes o18 p32)

(waiting o19)
(includes o19 p11)(includes o19 p13)(includes o19 p23)(includes o19 p26)

(waiting o20)
(includes o20 p1)(includes o20 p2)(includes o20 p22)(includes o20 p27)(includes o20 p40)

(waiting o21)
(includes o21 p5)(includes o21 p9)(includes o21 p25)(includes o21 p30)

(waiting o22)
(includes o22 p4)(includes o22 p14)(includes o22 p16)(includes o22 p22)(includes o22 p38)

(waiting o23)
(includes o23 p9)(includes o23 p32)(includes o23 p34)(includes o23 p38)

(waiting o24)
(includes o24 p6)(includes o24 p9)(includes o24 p12)(includes o24 p17)

(waiting o25)
(includes o25 p4)(includes o25 p29)(includes o25 p31)(includes o25 p33)

(waiting o26)
(includes o26 p10)(includes o26 p17)(includes o26 p21)(includes o26 p23)(includes o26 p27)(includes o26 p31)

(waiting o27)
(includes o27 p34)

(waiting o28)
(includes o28 p10)(includes o28 p16)(includes o28 p22)

(waiting o29)
(includes o29 p23)(includes o29 p24)(includes o29 p30)(includes o29 p33)(includes o29 p40)

(waiting o30)
(includes o30 p31)(includes o30 p40)

(waiting o31)
(includes o31 p18)(includes o31 p29)(includes o31 p34)(includes o31 p39)

(waiting o32)
(includes o32 p13)(includes o32 p31)(includes o32 p39)

(waiting o33)
(includes o33 p17)(includes o33 p38)(includes o33 p39)(includes o33 p40)

(waiting o34)
(includes o34 p14)(includes o34 p24)

(waiting o35)
(includes o35 p1)(includes o35 p7)(includes o35 p14)(includes o35 p33)

(waiting o36)
(includes o36 p8)(includes o36 p10)(includes o36 p20)(includes o36 p21)(includes o36 p22)

(waiting o37)
(includes o37 p11)(includes o37 p22)(includes o37 p28)

(waiting o38)
(includes o38 p6)(includes o38 p22)

(waiting o39)
(includes o39 p8)(includes o39 p21)

(waiting o40)
(includes o40 p1)(includes o40 p8)(includes o40 p9)(includes o40 p39)

(not-made p1)
(not-made p2)
(not-made p3)
(not-made p4)
(not-made p5)
(not-made p6)
(not-made p7)
(not-made p8)
(not-made p9)
(not-made p10)
(not-made p11)
(not-made p12)
(not-made p13)
(not-made p14)
(not-made p15)
(not-made p16)
(not-made p17)
(not-made p18)
(not-made p19)
(not-made p20)
(not-made p21)
(not-made p22)
(not-made p23)
(not-made p24)
(not-made p25)
(not-made p26)
(not-made p27)
(not-made p28)
(not-made p29)
(not-made p30)
(not-made p31)
(not-made p32)
(not-made p33)
(not-made p34)
(not-made p35)
(not-made p36)
(not-made p37)
(not-made p38)
(not-made p39)
(not-made p40)
)

(:goal
(and
(shipped o1)
(shipped o2)
(shipped o3)
(shipped o4)
(shipped o5)
(shipped o6)
(shipped o7)
(shipped o8)
(shipped o9)
(shipped o10)
(shipped o11)
(shipped o12)
(shipped o13)
(shipped o14)
(shipped o15)
(shipped o16)
(shipped o17)
(shipped o18)
(shipped o19)
(shipped o20)
(shipped o21)
(shipped o22)
(shipped o23)
(shipped o24)
(shipped o25)
(shipped o26)
(shipped o27)
(shipped o28)
(shipped o29)
(shipped o30)
(shipped o31)
(shipped o32)
(shipped o33)
(shipped o34)
(shipped o35)
(shipped o36)
(shipped o37)
(shipped o38)
(shipped o39)
(shipped o40)
))

(:metric minimize (total-time))

)

