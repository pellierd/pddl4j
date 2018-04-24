(define (problem freecell-3-5)
(:domain freecell)
(:objects
    S3
    H3
    D3
    C3
    SA
    S2
    S0
    HA
    H2
    H0
    DA
    D2
    D0
    CA
    C2
    C0
 - card
    N8
    N7
    N6
    N5
    N4
    N3
    N13
    N12
    N11
    N9
    N10
    N1
    N2
    N0
 - num
    S
    H
    D
    C
 - suit
)
(:init
    (VALUE C0 N0)
    (VALUE C2 N2)
    (VALUE C3 N3)
    (VALUE CA N1)
    (VALUE D0 N0)
    (VALUE D2 N2)
    (VALUE D3 N3)
    (VALUE DA N1)
    (VALUE H0 N0)
    (VALUE H2 N2)
    (VALUE H3 N3)
    (VALUE HA N1)
    (VALUE S0 N0)
    (VALUE S2 N2)
    (VALUE S3 N3)
    (VALUE SA N1)
    (SUCCESSOR N1 N0)
    (SUCCESSOR N10 N9)
    (SUCCESSOR N11 N10)
    (SUCCESSOR N12 N11)
    (SUCCESSOR N13 N12)
    (SUCCESSOR N2 N1)
    (SUCCESSOR N3 N2)
    (SUCCESSOR N4 N3)
    (SUCCESSOR N5 N4)
    (SUCCESSOR N6 N5)
    (SUCCESSOR N7 N6)
    (SUCCESSOR N8 N7)
    (SUCCESSOR N9 N8)
    (SUIT C0 C)
    (SUIT C2 C)
    (SUIT C3 C)
    (SUIT CA C)
    (SUIT D0 D)
    (SUIT D2 D)
    (SUIT D3 D)
    (SUIT DA D)
    (SUIT H0 H)
    (SUIT H2 H)
    (SUIT H3 H)
    (SUIT HA H)
    (SUIT S0 S)
    (SUIT S2 S)
    (SUIT S3 S)
    (SUIT SA S)
    (CANSTACK C2 D3)
    (CANSTACK C2 H3)
    (CANSTACK CA D2)
    (CANSTACK CA H2)
    (CANSTACK D2 C3)
    (CANSTACK D2 S3)
    (CANSTACK DA C2)
    (CANSTACK DA S2)
    (CANSTACK H2 C3)
    (CANSTACK H2 S3)
    (CANSTACK HA C2)
    (CANSTACK HA S2)
    (CANSTACK S2 D3)
    (CANSTACK S2 H3)
    (CANSTACK SA D2)
    (CANSTACK SA H2)
    (HOME C0)
    (HOME D0)
    (HOME H0)
    (HOME S0)
    (CELLSPACE N4)
    (COLSPACE N1)
    (ON C3 S2)
    (ON CA D3)
    (ON DA SA)
    (ON H2 S3)
    (ON S3 HA)
    (CLEAR C2)
    (CLEAR C3)
    (CLEAR CA)
    (CLEAR D2)
    (CLEAR DA)
    (CLEAR H2)
    (CLEAR H3)
    (BOTTOMCOL C2)
    (BOTTOMCOL D2)
    (BOTTOMCOL D3)
    (BOTTOMCOL H3)
    (BOTTOMCOL HA)
    (BOTTOMCOL S2)
    (BOTTOMCOL SA)
)
(:goal (and
    (HOME C3)
    (HOME D3)
    (HOME H3)
    (HOME S3)
)))
