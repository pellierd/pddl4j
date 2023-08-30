(define (problem logistics-18-1)
(:domain logistics)
(:objects
    apn2
    apn1
 - airplane
    apt6
    apt5
    apt4
    apt3
    apt2
    apt1
 - airport
    pos6
    pos5
    pos4
    pos3
    pos2
    pos1
 - location
    cit6
    cit5
    cit4
    cit3
    cit2
    cit1
 - city
    tru6
    tru5
    tru4
    tru3
    tru2
    tru1
 - truck
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
    (at apn1 apt2)
    (at apn2 apt3)
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
)
(:goal (and
    (at obj63 apt6)
    (at obj11 apt1)
    (at obj41 apt2)
    (at obj21 pos2)
    (at obj12 pos1)
    (at obj51 pos2)
    (at obj62 pos1)
    (at obj61 apt2)
    (at obj53 pos3)
    (at obj42 apt3)
    (at obj22 pos3)
    (at obj43 pos2)
    (at obj23 apt5)
    (at obj52 pos5)
    (at obj13 apt6)
    (at obj33 pos2)
    (at obj31 pos3)
    (at obj32 pos3)
)
)
)
