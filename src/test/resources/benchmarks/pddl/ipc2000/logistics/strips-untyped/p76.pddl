(define (problem logistics-37-1)
(:domain logistics)
(:objects
    apn4
    apt13
    pos13
    cit13
    tru13
    obj133
    obj132
    obj131
    apt12
    pos12
    cit12
    tru12
    obj123
    obj122
    obj121
    apt11
    pos11
    cit11
    tru11
    obj113
    obj112
    obj111
    apt10
    pos10
    cit10
    tru10
    obj103
    obj102
    obj101
    apn3
    apt9
    pos9
    cit9
    tru9
    obj93
    obj92
    obj91
    apt8
    pos8
    cit8
    tru8
    obj83
    obj82
    obj81
    apt7
    pos7
    cit7
    tru7
    obj73
    obj72
    obj71
    apt6
    pos6
    cit6
    tru6
    obj63
    obj62
    obj61
    apn2
    apt5
    pos5
    cit5
    tru5
    obj53
    obj52
    obj51
    apt4
    pos4
    cit4
    tru4
    obj43
    obj42
    obj41
    apt3
    pos3
    cit3
    tru3
    obj33
    obj32
    obj31
    apt2
    pos2
    cit2
    tru2
    obj23
    obj22
    obj21
    apn1
    apt1
    pos1
    cit1
    tru1
    obj13
    obj12
    obj11
)
(:init
    (package obj11)
    (package obj12)
    (package obj13)
    (package obj21)
    (package obj22)
    (package obj23)
    (package obj31)
    (package obj32)
    (package obj33)
    (package obj41)
    (package obj42)
    (package obj43)
    (package obj51)
    (package obj52)
    (package obj53)
    (package obj61)
    (package obj62)
    (package obj63)
    (package obj71)
    (package obj72)
    (package obj73)
    (package obj81)
    (package obj82)
    (package obj83)
    (package obj91)
    (package obj92)
    (package obj93)
    (package obj101)
    (package obj102)
    (package obj103)
    (package obj111)
    (package obj112)
    (package obj113)
    (package obj121)
    (package obj122)
    (package obj123)
    (package obj131)
    (package obj132)
    (package obj133)
    (truck tru1)
    (truck tru2)
    (truck tru3)
    (truck tru4)
    (truck tru5)
    (truck tru6)
    (truck tru7)
    (truck tru8)
    (truck tru9)
    (truck tru10)
    (truck tru11)
    (truck tru12)
    (truck tru13)
    (city cit1)
    (city cit2)
    (city cit3)
    (city cit4)
    (city cit5)
    (city cit6)
    (city cit7)
    (city cit8)
    (city cit9)
    (city cit10)
    (city cit11)
    (city cit12)
    (city cit13)
    (location pos1)
    (location apt1)
    (location pos2)
    (location apt2)
    (location pos3)
    (location apt3)
    (location pos4)
    (location apt4)
    (location pos5)
    (location apt5)
    (location pos6)
    (location apt6)
    (location pos7)
    (location apt7)
    (location pos8)
    (location apt8)
    (location pos9)
    (location apt9)
    (location pos10)
    (location apt10)
    (location pos11)
    (location apt11)
    (location pos12)
    (location apt12)
    (location pos13)
    (location apt13)
    (airport apt1)
    (airport apt2)
    (airport apt3)
    (airport apt4)
    (airport apt5)
    (airport apt6)
    (airport apt7)
    (airport apt8)
    (airport apt9)
    (airport apt10)
    (airport apt11)
    (airport apt12)
    (airport apt13)
    (airplane apn1)
    (airplane apn2)
    (airplane apn3)
    (airplane apn4)
    (at apn1 apt8)
    (at apn2 apt3)
    (at apn3 apt1)
    (at apn4 apt8)
    (at tru1 pos1)
    (at obj11 pos1)
    (at obj12 pos1)
    (at obj13 pos1)
    (at tru2 pos2)
    (at obj21 pos2)
    (at obj22 pos2)
    (at obj23 pos2)
    (at tru3 pos3)
    (at obj31 pos3)
    (at obj32 pos3)
    (at obj33 pos3)
    (at tru4 pos4)
    (at obj41 pos4)
    (at obj42 pos4)
    (at obj43 pos4)
    (at tru5 pos5)
    (at obj51 pos5)
    (at obj52 pos5)
    (at obj53 pos5)
    (at tru6 pos6)
    (at obj61 pos6)
    (at obj62 pos6)
    (at obj63 pos6)
    (at tru7 pos7)
    (at obj71 pos7)
    (at obj72 pos7)
    (at obj73 pos7)
    (at tru8 pos8)
    (at obj81 pos8)
    (at obj82 pos8)
    (at obj83 pos8)
    (at tru9 pos9)
    (at obj91 pos9)
    (at obj92 pos9)
    (at obj93 pos9)
    (at tru10 pos10)
    (at obj101 pos10)
    (at obj102 pos10)
    (at obj103 pos10)
    (at tru11 pos11)
    (at obj111 pos11)
    (at obj112 pos11)
    (at obj113 pos11)
    (at tru12 pos12)
    (at obj121 pos12)
    (at obj122 pos12)
    (at obj123 pos12)
    (at tru13 pos13)
    (at obj131 pos13)
    (at obj132 pos13)
    (at obj133 pos13)
    (in-city pos1 cit1)
    (in-city apt1 cit1)
    (in-city pos2 cit2)
    (in-city apt2 cit2)
    (in-city pos3 cit3)
    (in-city apt3 cit3)
    (in-city pos4 cit4)
    (in-city apt4 cit4)
    (in-city pos5 cit5)
    (in-city apt5 cit5)
    (in-city pos6 cit6)
    (in-city apt6 cit6)
    (in-city pos7 cit7)
    (in-city apt7 cit7)
    (in-city pos8 cit8)
    (in-city apt8 cit8)
    (in-city pos9 cit9)
    (in-city apt9 cit9)
    (in-city pos10 cit10)
    (in-city apt10 cit10)
    (in-city pos11 cit11)
    (in-city apt11 cit11)
    (in-city pos12 cit12)
    (in-city apt12 cit12)
    (in-city pos13 cit13)
    (in-city apt13 cit13)
)
(:goal (and
    (at obj83 pos13)
    (at obj52 pos6)
    (at obj33 pos5)
    (at obj13 apt12)
    (at obj131 apt7)
    (at obj31 pos4)
    (at obj92 apt1)
    (at obj91 pos2)
    (at obj82 pos4)
    (at obj132 pos4)
    (at obj63 apt10)
    (at obj61 apt13)
    (at obj41 pos12)
    (at obj71 apt2)
    (at obj53 pos13)
    (at obj121 pos5)
    (at obj123 apt10)
    (at obj112 apt12)
    (at obj42 apt3)
    (at obj102 pos9)
    (at obj11 apt7)
    (at obj22 pos4)
    (at obj111 pos10)
    (at obj122 apt9)
    (at obj23 apt2)
    (at obj81 apt4)
    (at obj43 pos3)
    (at obj133 pos7)
    (at obj101 apt5)
    (at obj103 pos12)
    (at obj62 pos13)
    (at obj113 apt3)
    (at obj73 pos10)
    (at obj93 apt13)
    (at obj32 apt8)
    (at obj72 pos4)
    (at obj51 apt13)
)
)
)
