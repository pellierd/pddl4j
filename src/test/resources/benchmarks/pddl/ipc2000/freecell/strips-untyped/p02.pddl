(define (problem freecell-2-2)
(:domain freecell)
(:objects
    S
    H
    D
    C
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
    SA
    S2
    S0
    HA
    H2
    H0
    DA
    D2
    D0
    N1
    CA
    N2
    C2
    N0
    C0
)
(:init
    (VALUE C0 N0)
    (VALUE C2 N2)
    (VALUE CA N1)
    (VALUE D0 N0)
    (VALUE D2 N2)
    (VALUE DA N1)
    (VALUE H0 N0)
    (VALUE H2 N2)
    (VALUE HA N1)
    (VALUE S0 N0)
    (VALUE S2 N2)
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
    (SUIT CA C)
    (SUIT D0 D)
    (SUIT D2 D)
    (SUIT DA D)
    (SUIT H0 H)
    (SUIT H2 H)
    (SUIT HA H)
    (SUIT S0 S)
    (SUIT S2 S)
    (SUIT SA S)
    (CANSTACK CA D2)
    (CANSTACK CA H2)
    (CANSTACK DA C2)
    (CANSTACK DA S2)
    (CANSTACK HA C2)
    (CANSTACK HA S2)
    (CANSTACK SA D2)
    (CANSTACK SA H2)
    (HOME C0)
    (HOME D0)
    (HOME H0)
    (HOME S0)
    (CELLSPACE N4)
    (COLSPACE N2)
    (ON CA D2)
    (ON SA HA)
    (CLEAR C2)
    (CLEAR CA)
    (CLEAR DA)
    (CLEAR H2)
    (CLEAR S2)
    (CLEAR SA)
    (BOTTOMCOL C2)
    (BOTTOMCOL D2)
    (BOTTOMCOL DA)
    (BOTTOMCOL H2)
    (BOTTOMCOL HA)
    (BOTTOMCOL S2)
)
(:goal (and
    (HOME C2)
    (HOME D2)
    (HOME H2)
    (HOME S2)
)))
