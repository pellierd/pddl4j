(define (problem os-time-p42_1)
(:domain openstacks-time-nonADL-nonNegated)
(:objects 
n0 n1 n2 n3 n4 n5 n6 n7 n8 n9 n10 n11 n12 n13 n14 n15 n16 n17 n18 n19 n20 n21 n22 n23 n24 n25 n26 n27 n28 n29 n30 n31 n32 n33 n34 n35 n36 n37  - count
)

(:init
(next-count n0 n1) (next-count n1 n2) (next-count n2 n3) (next-count n3 n4) (next-count n4 n5) (next-count n5 n6) (next-count n6 n7) (next-count n7 n8) (next-count n8 n9) (next-count n9 n10) (next-count n10 n11) (next-count n11 n12) (next-count n12 n13) (next-count n13 n14) (next-count n14 n15) (next-count n15 n16) (next-count n16 n17) (next-count n17 n18) (next-count n18 n19) (next-count n19 n20) (next-count n20 n21) (next-count n21 n22) (next-count n22 n23) (next-count n23 n24) (next-count n24 n25) (next-count n25 n26) (next-count n26 n27) (next-count n27 n28) (next-count n28 n29) (next-count n29 n30) (next-count n30 n31) (next-count n31 n32) (next-count n32 n33) (next-count n33 n34) (next-count n34 n35) (next-count n35 n36) (next-count n36 n37) 
(stacks-avail n37)

(waiting o1)
(includes o1 p9)(includes o1 p22)(includes o1 p30)

(waiting o2)
(includes o2 p5)(includes o2 p8)(includes o2 p30)(includes o2 p34)

(waiting o3)
(includes o3 p1)(includes o3 p7)(includes o3 p13)(includes o3 p25)(includes o3 p28)(includes o3 p37)

(waiting o4)
(includes o4 p18)(includes o4 p23)

(waiting o5)
(includes o5 p6)(includes o5 p15)(includes o5 p24)(includes o5 p28)(includes o5 p30)(includes o5 p33)

(waiting o6)
(includes o6 p16)(includes o6 p21)(includes o6 p26)(includes o6 p27)(includes o6 p34)

(waiting o7)
(includes o7 p7)(includes o7 p18)(includes o7 p23)(includes o7 p33)(includes o7 p37)

(waiting o8)
(includes o8 p21)(includes o8 p27)(includes o8 p31)(includes o8 p35)(includes o8 p39)

(waiting o9)
(includes o9 p8)

(waiting o10)
(includes o10 p29)(includes o10 p31)(includes o10 p39)

(waiting o11)
(includes o11 p10)(includes o11 p34)

(waiting o12)
(includes o12 p1)(includes o12 p3)(includes o12 p7)(includes o12 p18)(includes o12 p24)(includes o12 p28)(includes o12 p29)

(waiting o13)
(includes o13 p16)(includes o13 p21)(includes o13 p31)(includes o13 p40)

(waiting o14)
(includes o14 p3)(includes o14 p20)(includes o14 p23)

(waiting o15)
(includes o15 p8)(includes o15 p12)(includes o15 p25)(includes o15 p33)(includes o15 p37)

(waiting o16)
(includes o16 p2)(includes o16 p8)(includes o16 p11)

(waiting o17)
(includes o17 p6)(includes o17 p17)(includes o17 p40)(includes o17 p41)

(waiting o18)
(includes o18 p29)(includes o18 p41)

(waiting o19)
(includes o19 p6)(includes o19 p15)(includes o19 p22)(includes o19 p36)

(waiting o20)
(includes o20 p3)(includes o20 p11)(includes o20 p21)(includes o20 p38)

(waiting o21)
(includes o21 p16)(includes o21 p21)(includes o21 p27)(includes o21 p38)

(waiting o22)
(includes o22 p2)(includes o22 p7)(includes o22 p22)(includes o22 p37)

(waiting o23)
(includes o23 p2)(includes o23 p3)(includes o23 p6)(includes o23 p13)(includes o23 p15)

(waiting o24)
(includes o24 p10)(includes o24 p31)(includes o24 p34)

(waiting o25)
(includes o25 p9)(includes o25 p16)(includes o25 p26)(includes o25 p27)(includes o25 p39)

(waiting o26)
(includes o26 p1)(includes o26 p7)(includes o26 p25)

(waiting o27)
(includes o27 p10)(includes o27 p11)(includes o27 p31)

(waiting o28)
(includes o28 p4)(includes o28 p10)(includes o28 p14)(includes o28 p16)(includes o28 p22)(includes o28 p28)(includes o28 p34)(includes o28 p40)

(waiting o29)
(includes o29 p3)(includes o29 p11)(includes o29 p15)(includes o29 p38)

(waiting o30)
(includes o30 p4)(includes o30 p10)(includes o30 p12)

(waiting o31)
(includes o31 p7)(includes o31 p28)(includes o31 p33)(includes o31 p42)

(waiting o32)
(includes o32 p10)(includes o32 p22)(includes o32 p34)

(waiting o33)
(includes o33 p7)(includes o33 p23)(includes o33 p28)(includes o33 p33)(includes o33 p37)(includes o33 p42)

(waiting o34)
(includes o34 p10)(includes o34 p14)(includes o34 p21)

(waiting o35)
(includes o35 p9)(includes o35 p18)(includes o35 p22)(includes o35 p35)

(waiting o36)
(includes o36 p10)(includes o36 p26)(includes o36 p34)(includes o36 p36)(includes o36 p41)

(waiting o37)
(includes o37 p9)(includes o37 p26)(includes o37 p27)(includes o37 p31)(includes o37 p36)(includes o37 p38)(includes o37 p41)

(waiting o38)
(includes o38 p30)(includes o38 p36)

(waiting o39)
(includes o39 p3)(includes o39 p11)(includes o39 p13)(includes o39 p18)(includes o39 p19)(includes o39 p30)(includes o39 p32)

(waiting o40)
(includes o40 p36)

(waiting o41)
(includes o41 p1)(includes o41 p7)(includes o41 p24)(includes o41 p28)

(waiting o42)
(includes o42 p42)

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
(not-made p41)
(not-made p42)
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
(shipped o41)
(shipped o42)
))

(:metric minimize (total-time))

)

