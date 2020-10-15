(define (problem freecell-11-4)
(:domain freecell)
(:objects
    SJ
    HJ
    DJ
    CJ
    S10
    H10
    D10
    C10
    S9
    H9
    D9
    C9
    S8
    H8
    D8
    C8
    S7
    H7
    D7
    C7
    S6
    H6
    D6
    C6
    S5
    H5
    D5
    C5
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
    (VALUE C10 N10)
    (VALUE C2 N2)
    (VALUE C3 N3)
    (VALUE C4 N4)
    (VALUE C5 N5)
    (VALUE C6 N6)
    (VALUE C7 N7)
    (VALUE C8 N8)
    (VALUE C9 N9)
    (VALUE CA N1)
    (VALUE CJ N11)
    (VALUE D0 N0)
    (VALUE D10 N10)
    (VALUE D2 N2)
    (VALUE D3 N3)
    (VALUE D4 N4)
    (VALUE D5 N5)
    (VALUE D6 N6)
    (VALUE D7 N7)
    (VALUE D8 N8)
    (VALUE D9 N9)
    (VALUE DA N1)
    (VALUE DJ N11)
    (VALUE H0 N0)
    (VALUE H10 N10)
    (VALUE H2 N2)
    (VALUE H3 N3)
    (VALUE H4 N4)
    (VALUE H5 N5)
    (VALUE H6 N6)
    (VALUE H7 N7)
    (VALUE H8 N8)
    (VALUE H9 N9)
    (VALUE HA N1)
    (VALUE HJ N11)
    (VALUE S0 N0)
    (VALUE S10 N10)
    (VALUE S2 N2)
    (VALUE S3 N3)
    (VALUE S4 N4)
    (VALUE S5 N5)
    (VALUE S6 N6)
    (VALUE S7 N7)
    (VALUE S8 N8)
    (VALUE S9 N9)
    (VALUE SA N1)
    (VALUE SJ N11)
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
    (SUIT C10 C)
    (SUIT C2 C)
    (SUIT C3 C)
    (SUIT C4 C)
    (SUIT C5 C)
    (SUIT C6 C)
    (SUIT C7 C)
    (SUIT C8 C)
    (SUIT C9 C)
    (SUIT CA C)
    (SUIT CJ C)
    (SUIT D0 D)
    (SUIT D10 D)
    (SUIT D2 D)
    (SUIT D3 D)
    (SUIT D4 D)
    (SUIT D5 D)
    (SUIT D6 D)
    (SUIT D7 D)
    (SUIT D8 D)
    (SUIT D9 D)
    (SUIT DA D)
    (SUIT DJ D)
    (SUIT H0 H)
    (SUIT H10 H)
    (SUIT H2 H)
    (SUIT H3 H)
    (SUIT H4 H)
    (SUIT H5 H)
    (SUIT H6 H)
    (SUIT H7 H)
    (SUIT H8 H)
    (SUIT H9 H)
    (SUIT HA H)
    (SUIT HJ H)
    (SUIT S0 S)
    (SUIT S10 S)
    (SUIT S2 S)
    (SUIT S3 S)
    (SUIT S4 S)
    (SUIT S5 S)
    (SUIT S6 S)
    (SUIT S7 S)
    (SUIT S8 S)
    (SUIT S9 S)
    (SUIT SA S)
    (SUIT SJ S)
    (CANSTACK C10 DJ)
    (CANSTACK C10 HJ)
    (CANSTACK C2 D3)
    (CANSTACK C2 H3)
    (CANSTACK C3 D4)
    (CANSTACK C3 H4)
    (CANSTACK C4 D5)
    (CANSTACK C4 H5)
    (CANSTACK C5 D6)
    (CANSTACK C5 H6)
    (CANSTACK C6 D7)
    (CANSTACK C6 H7)
    (CANSTACK C7 D8)
    (CANSTACK C7 H8)
    (CANSTACK C8 D9)
    (CANSTACK C8 H9)
    (CANSTACK C9 D10)
    (CANSTACK C9 H10)
    (CANSTACK CA D2)
    (CANSTACK CA H2)
    (CANSTACK D10 CJ)
    (CANSTACK D10 SJ)
    (CANSTACK D2 C3)
    (CANSTACK D2 S3)
    (CANSTACK D3 C4)
    (CANSTACK D3 S4)
    (CANSTACK D4 C5)
    (CANSTACK D4 S5)
    (CANSTACK D5 C6)
    (CANSTACK D5 S6)
    (CANSTACK D6 C7)
    (CANSTACK D6 S7)
    (CANSTACK D7 C8)
    (CANSTACK D7 S8)
    (CANSTACK D8 C9)
    (CANSTACK D8 S9)
    (CANSTACK D9 C10)
    (CANSTACK D9 S10)
    (CANSTACK DA C2)
    (CANSTACK DA S2)
    (CANSTACK H10 CJ)
    (CANSTACK H10 SJ)
    (CANSTACK H2 C3)
    (CANSTACK H2 S3)
    (CANSTACK H3 C4)
    (CANSTACK H3 S4)
    (CANSTACK H4 C5)
    (CANSTACK H4 S5)
    (CANSTACK H5 C6)
    (CANSTACK H5 S6)
    (CANSTACK H6 C7)
    (CANSTACK H6 S7)
    (CANSTACK H7 C8)
    (CANSTACK H7 S8)
    (CANSTACK H8 C9)
    (CANSTACK H8 S9)
    (CANSTACK H9 C10)
    (CANSTACK H9 S10)
    (CANSTACK HA C2)
    (CANSTACK HA S2)
    (CANSTACK S10 DJ)
    (CANSTACK S10 HJ)
    (CANSTACK S2 D3)
    (CANSTACK S2 H3)
    (CANSTACK S3 D4)
    (CANSTACK S3 H4)
    (CANSTACK S4 D5)
    (CANSTACK S4 H5)
    (CANSTACK S5 D6)
    (CANSTACK S5 H6)
    (CANSTACK S6 D7)
    (CANSTACK S6 H7)
    (CANSTACK S7 D8)
    (CANSTACK S7 H8)
    (CANSTACK S8 D9)
    (CANSTACK S8 H9)
    (CANSTACK S9 D10)
    (CANSTACK S9 H10)
    (CANSTACK SA D2)
    (CANSTACK SA H2)
    (HOME C0)
    (HOME D0)
    (HOME H0)
    (HOME S0)
    (CELLSPACE N4)
    (COLSPACE N0)
    (ON C10 S9)
    (ON C3 S7)
    (ON C4 S2)
    (ON C5 S3)
    (ON C6 S6)
    (ON C7 SA)
    (ON C8 SJ)
    (ON C9 CJ)
    (ON CJ C10)
    (ON D10 C3)
    (ON D2 H3)
    (ON D4 C8)
    (ON D6 C2)
    (ON D7 H10)
    (ON D8 H4)
    (ON DA D2)
    (ON DJ D10)
    (ON H10 S5)
    (ON H2 C4)
    (ON H3 H8)
    (ON H4 HA)
    (ON H5 C6)
    (ON H6 H2)
    (ON H7 D8)
    (ON H8 D4)
    (ON H9 HJ)
    (ON HA D5)
    (ON HJ H5)
    (ON S10 CA)
    (ON S2 D9)
    (ON S4 C7)
    (ON S5 S10)
    (ON S7 C5)
    (ON S8 H7)
    (ON S9 D6)
    (ON SA D3)
    (CLEAR C9)
    (CLEAR D7)
    (CLEAR DA)
    (CLEAR DJ)
    (CLEAR H6)
    (CLEAR H9)
    (CLEAR S4)
    (CLEAR S8)
    (BOTTOMCOL C2)
    (BOTTOMCOL CA)
    (BOTTOMCOL D3)
    (BOTTOMCOL D5)
    (BOTTOMCOL D9)
    (BOTTOMCOL S3)
    (BOTTOMCOL S6)
    (BOTTOMCOL SJ)
)
(:goal (and
    (HOME CJ)
    (HOME DJ)
    (HOME HJ)
    (HOME SJ)
)))
