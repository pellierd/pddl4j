(define (problem freecell-4-1)
(:domain freecell)
(:objects
    S4
    H4
    D4
    C4
    S3
    H3
    D3
    C3
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
    (VALUE C3 N3)
    (VALUE C4 N4)
    (VALUE CA N1)
    (VALUE D0 N0)
    (VALUE D2 N2)
    (VALUE D3 N3)
    (VALUE D4 N4)
    (VALUE DA N1)
    (VALUE H0 N0)
    (VALUE H2 N2)
    (VALUE H3 N3)
    (VALUE H4 N4)
    (VALUE HA N1)
    (VALUE S0 N0)
    (VALUE S2 N2)
    (VALUE S3 N3)
    (VALUE S4 N4)
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
    (SUIT C4 C)
    (SUIT CA C)
    (SUIT D0 D)
    (SUIT D2 D)
    (SUIT D3 D)
    (SUIT D4 D)
    (SUIT DA D)
    (SUIT H0 H)
    (SUIT H2 H)
    (SUIT H3 H)
    (SUIT H4 H)
    (SUIT HA H)
    (SUIT S0 S)
    (SUIT S2 S)
    (SUIT S3 S)
    (SUIT S4 S)
    (SUIT SA S)
    (CANSTACK C2 D3)
    (CANSTACK C2 H3)
    (CANSTACK C3 D4)
    (CANSTACK C3 H4)
    (CANSTACK CA D2)
    (CANSTACK CA H2)
    (CANSTACK D2 C3)
    (CANSTACK D2 S3)
    (CANSTACK D3 C4)
    (CANSTACK D3 S4)
    (CANSTACK DA C2)
    (CANSTACK DA S2)
    (CANSTACK H2 C3)
    (CANSTACK H2 S3)
    (CANSTACK H3 C4)
    (CANSTACK H3 S4)
    (CANSTACK HA C2)
    (CANSTACK HA S2)
    (CANSTACK S2 D3)
    (CANSTACK S2 H3)
    (CANSTACK S3 D4)
    (CANSTACK S3 H4)
    (CANSTACK SA D2)
    (CANSTACK SA H2)
    (HOME C0)
    (HOME D0)
    (HOME H0)
    (HOME S0)
    (CELLSPACE N4)
    (COLSPACE N1)
    (ON C2 CA)
    (ON C3 H3)
    (ON C4 S2)
    (ON CA SA)
    (ON D3 C2)
    (ON D4 HA)
    (ON H2 S4)
    (ON H4 DA)
    (ON S3 C4)
    (CLEAR C3)
    (CLEAR D2)
    (CLEAR D3)
    (CLEAR D4)
    (CLEAR H2)
    (CLEAR H4)
    (CLEAR S3)
    (BOTTOMCOL D2)
    (BOTTOMCOL DA)
    (BOTTOMCOL H3)
    (BOTTOMCOL HA)
    (BOTTOMCOL S2)
    (BOTTOMCOL S4)
    (BOTTOMCOL SA)
)
(:goal (and
    (HOME C4)
    (HOME D4)
    (HOME H4)
    (HOME S4)
)))
