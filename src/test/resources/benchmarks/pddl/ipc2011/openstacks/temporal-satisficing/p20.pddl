(define (problem os-time-p44_1)
(:domain openstacks-time-nonADL-nonNegated)
(:objects 
n0 n1 n2 n3 n4 n5 n6 n7 n8 n9 n10 n11 n12 n13 n14 n15 n16 n17 n18 n19 n20 n21 n22 n23 n24 n25 n26 n27 n28 n29 n30 n31 n32 n33 n34 n35 n36 n37 n38 n39  - count
)

(:init
(next-count n0 n1) (next-count n1 n2) (next-count n2 n3) (next-count n3 n4) (next-count n4 n5) (next-count n5 n6) (next-count n6 n7) (next-count n7 n8) (next-count n8 n9) (next-count n9 n10) (next-count n10 n11) (next-count n11 n12) (next-count n12 n13) (next-count n13 n14) (next-count n14 n15) (next-count n15 n16) (next-count n16 n17) (next-count n17 n18) (next-count n18 n19) (next-count n19 n20) (next-count n20 n21) (next-count n21 n22) (next-count n22 n23) (next-count n23 n24) (next-count n24 n25) (next-count n25 n26) (next-count n26 n27) (next-count n27 n28) (next-count n28 n29) (next-count n29 n30) (next-count n30 n31) (next-count n31 n32) (next-count n32 n33) (next-count n33 n34) (next-count n34 n35) (next-count n35 n36) (next-count n36 n37) (next-count n37 n38) (next-count n38 n39) 
(stacks-avail n39)

(waiting o1)
(includes o1 p3)(includes o1 p5)(includes o1 p9)(includes o1 p10)(includes o1 p21)(includes o1 p31)(includes o1 p35)(includes o1 p38)(includes o1 p43)

(waiting o2)
(includes o2 p12)(includes o2 p26)(includes o2 p37)

(waiting o3)
(includes o3 p9)(includes o3 p25)(includes o3 p30)(includes o3 p36)

(waiting o4)
(includes o4 p1)(includes o4 p4)(includes o4 p6)(includes o4 p14)(includes o4 p23)

(waiting o5)
(includes o5 p2)(includes o5 p6)(includes o5 p17)(includes o5 p21)(includes o5 p37)

(waiting o6)
(includes o6 p5)(includes o6 p13)

(waiting o7)
(includes o7 p14)(includes o7 p17)(includes o7 p23)(includes o7 p24)(includes o7 p26)(includes o7 p32)(includes o7 p42)(includes o7 p44)

(waiting o8)
(includes o8 p7)(includes o8 p20)(includes o8 p21)(includes o8 p25)(includes o8 p29)(includes o8 p37)

(waiting o9)
(includes o9 p3)(includes o9 p7)(includes o9 p25)(includes o9 p30)(includes o9 p40)

(waiting o10)
(includes o10 p34)

(waiting o11)
(includes o11 p3)(includes o11 p4)(includes o11 p8)(includes o11 p10)(includes o11 p21)(includes o11 p27)(includes o11 p35)(includes o11 p43)

(waiting o12)
(includes o12 p1)(includes o12 p4)(includes o12 p12)(includes o12 p23)

(waiting o13)
(includes o13 p9)(includes o13 p13)(includes o13 p15)(includes o13 p27)(includes o13 p36)(includes o13 p43)

(waiting o14)
(includes o14 p31)(includes o14 p43)

(waiting o15)
(includes o15 p1)(includes o15 p13)(includes o15 p14)

(waiting o16)
(includes o16 p7)(includes o16 p14)(includes o16 p19)(includes o16 p23)(includes o16 p29)(includes o16 p32)(includes o16 p44)

(waiting o17)
(includes o17 p9)(includes o17 p20)(includes o17 p22)(includes o17 p27)(includes o17 p36)

(waiting o18)
(includes o18 p4)(includes o18 p6)(includes o18 p12)(includes o18 p20)(includes o18 p31)(includes o18 p32)

(waiting o19)
(includes o19 p14)(includes o19 p17)(includes o19 p32)(includes o19 p34)(includes o19 p39)

(waiting o20)
(includes o20 p17)(includes o20 p25)(includes o20 p29)(includes o20 p30)(includes o20 p39)(includes o20 p41)

(waiting o21)
(includes o21 p7)(includes o21 p8)(includes o21 p21)(includes o21 p25)(includes o21 p29)(includes o21 p30)(includes o21 p37)(includes o21 p40)

(waiting o22)
(includes o22 p6)(includes o22 p18)

(waiting o23)
(includes o23 p9)(includes o23 p10)(includes o23 p16)(includes o23 p20)(includes o23 p21)(includes o23 p30)(includes o23 p35)(includes o23 p38)(includes o23 p40)

(waiting o24)
(includes o24 p9)(includes o24 p10)(includes o24 p13)(includes o24 p22)(includes o24 p38)

(waiting o25)
(includes o25 p1)(includes o25 p4)(includes o25 p10)(includes o25 p19)(includes o25 p39)(includes o25 p41)

(waiting o26)
(includes o26 p6)(includes o26 p14)(includes o26 p17)(includes o26 p19)(includes o26 p33)(includes o26 p41)(includes o26 p44)

(waiting o27)
(includes o27 p17)(includes o27 p28)(includes o27 p39)(includes o27 p40)

(waiting o28)
(includes o28 p3)(includes o28 p8)(includes o28 p10)(includes o28 p16)(includes o28 p34)

(waiting o29)
(includes o29 p18)(includes o29 p26)(includes o29 p33)

(waiting o30)
(includes o30 p11)(includes o30 p28)(includes o30 p32)(includes o30 p35)

(waiting o31)
(includes o31 p11)(includes o31 p13)(includes o31 p28)(includes o31 p35)(includes o31 p40)

(waiting o32)
(includes o32 p10)(includes o32 p28)(includes o32 p35)(includes o32 p43)

(waiting o33)
(includes o33 p24)(includes o33 p43)

(waiting o34)
(includes o34 p18)(includes o34 p33)(includes o34 p39)(includes o34 p40)(includes o34 p41)

(waiting o35)
(includes o35 p10)(includes o35 p22)(includes o35 p28)

(waiting o36)
(includes o36 p3)(includes o36 p11)(includes o36 p20)(includes o36 p21)(includes o36 p31)(includes o36 p40)(includes o36 p43)

(waiting o37)
(includes o37 p3)(includes o37 p8)(includes o37 p14)(includes o37 p21)(includes o37 p27)(includes o37 p34)(includes o37 p36)

(waiting o38)
(includes o38 p7)(includes o38 p14)(includes o38 p27)(includes o38 p34)

(waiting o39)
(includes o39 p1)(includes o39 p6)(includes o39 p14)(includes o39 p18)(includes o39 p21)(includes o39 p26)

(waiting o40)
(includes o40 p6)(includes o40 p19)(includes o40 p23)(includes o40 p32)(includes o40 p37)

(waiting o41)
(includes o41 p1)(includes o41 p23)

(waiting o42)
(includes o42 p24)(includes o42 p35)(includes o42 p39)(includes o42 p41)

(waiting o43)
(includes o43 p3)(includes o43 p36)(includes o43 p43)

(waiting o44)
(includes o44 p15)(includes o44 p16)(includes o44 p36)(includes o44 p38)(includes o44 p43)

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
(not-made p43)
(not-made p44)
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
(shipped o43)
(shipped o44)
))

(:metric minimize (total-time))

)

