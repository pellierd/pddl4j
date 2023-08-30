(define (problem freecell-3-5)
(:domain freecell)
(:objects
    s3
    h3
    d3
    c3
    s
    h
    d
    c
    n8
    n7
    n6
    n5
    n4
    n3
    n13
    n12
    n11
    n9
    n10
    sa
    s2
    s0
    ha
    h2
    h0
    da
    d2
    d0
    n1
    ca
    n2
    c2
    n0
    c0
)
(:init
    (value c0 n0)
    (value c2 n2)
    (value c3 n3)
    (value ca n1)
    (value d0 n0)
    (value d2 n2)
    (value d3 n3)
    (value da n1)
    (value h0 n0)
    (value h2 n2)
    (value h3 n3)
    (value ha n1)
    (value s0 n0)
    (value s2 n2)
    (value s3 n3)
    (value sa n1)
    (successor n1 n0)
    (successor n10 n9)
    (successor n11 n10)
    (successor n12 n11)
    (successor n13 n12)
    (successor n2 n1)
    (successor n3 n2)
    (successor n4 n3)
    (successor n5 n4)
    (successor n6 n5)
    (successor n7 n6)
    (successor n8 n7)
    (successor n9 n8)
    (suit c0 c)
    (suit c2 c)
    (suit c3 c)
    (suit ca c)
    (suit d0 d)
    (suit d2 d)
    (suit d3 d)
    (suit da d)
    (suit h0 h)
    (suit h2 h)
    (suit h3 h)
    (suit ha h)
    (suit s0 s)
    (suit s2 s)
    (suit s3 s)
    (suit sa s)
    (canstack c2 d3)
    (canstack c2 h3)
    (canstack ca d2)
    (canstack ca h2)
    (canstack d2 c3)
    (canstack d2 s3)
    (canstack da c2)
    (canstack da s2)
    (canstack h2 c3)
    (canstack h2 s3)
    (canstack ha c2)
    (canstack ha s2)
    (canstack s2 d3)
    (canstack s2 h3)
    (canstack sa d2)
    (canstack sa h2)
    (home c0)
    (home d0)
    (home h0)
    (home s0)
    (cellspace n4)
    (colspace n1)
    (on c3 s2)
    (on ca d3)
    (on da sa)
    (on h2 s3)
    (on s3 ha)
    (clear c2)
    (clear c3)
    (clear ca)
    (clear d2)
    (clear da)
    (clear h2)
    (clear h3)
    (bottomcol c2)
    (bottomcol d2)
    (bottomcol d3)
    (bottomcol h3)
    (bottomcol ha)
    (bottomcol s2)
    (bottomcol sa)
)
(:goal (and
    (home c3)
    (home d3)
    (home h3)
    (home s3)
)))
