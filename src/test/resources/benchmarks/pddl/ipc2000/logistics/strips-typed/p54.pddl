(define (problem logistics-26-1)
(:domain logistics)
(:objects
    apn3
    apn2
    apn1
 - airplane
    apt9
    apt8
    apt7
    apt6
    apt5
    apt4
    apt3
    apt2
    apt1
 - airport
    pos9
    pos8
    pos7
    pos6
    pos5
    pos4
    pos3
    pos2
    pos1
 - location
    cit9
    cit8
    cit7
    cit6
    cit5
    cit4
    cit3
    cit2
    cit1
 - city
    tru9
    tru8
    tru7
    tru6
    tru5
    tru4
    tru3
    tru2
    tru1
 - truck
    obj93
    obj92
    obj91
    obj83
    obj82
    obj81
    obj73
    obj72
    obj71
    obj63
    obj62
    obj61
    obj53
    obj52
    obj51
    obj43
    obj42
    obj41
    obj33
    obj32
    obj31
    obj23
    obj22
    obj21
    obj13
    obj12
    obj11
 - package
)
(:init
    (at apn1 apt1)
    (at apn2 apt6)
    (at apn3 apt5)
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
)
(:goal (and
    (at obj51 apt1)
    (at obj43 pos2)
    (at obj32 pos6)
    (at obj71 apt8)
    (at obj13 apt7)
    (at obj52 pos7)
    (at obj73 apt4)
    (at obj61 pos9)
    (at obj93 apt7)
    (at obj12 pos9)
    (at obj42 pos9)
    (at obj91 apt2)
    (at obj53 pos1)
    (at obj82 pos3)
    (at obj23 apt7)
    (at obj63 apt5)
    (at obj83 pos8)
    (at obj11 apt8)
    (at obj62 pos1)
    (at obj22 pos1)
    (at obj31 pos4)
    (at obj92 pos5)
    (at obj21 apt7)
    (at obj72 apt3)
    (at obj81 apt8)
    (at obj41 pos1)
)
)
)
