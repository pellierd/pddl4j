(define (problem blocks-18-1)
(:domain blocks)
(:objects
    r
    q
    p
    o
    n
    m
    l
    k
    j
    i
    h
    g
    f
    e
    d
    c
    a
    b
 - block)
(:init
    (clear g)
    (clear j)
    (clear k)
    (ontable c)
    (ontable a)
    (ontable k)
    (on g p)
    (on p n)
    (on n e)
    (on e r)
    (on r i)
    (on i f)
    (on f o)
    (on o l)
    (on l b)
    (on b d)
    (on d q)
    (on q m)
    (on m c)
    (on j h)
    (on h a)
    (handempty)
)
(:goal (and
    (on h g)
    (on g m)
    (on m d)
    (on d b)
    (on b n)
    (on n e)
    (on e f)
    (on f r)
    (on r q)
    (on q o)
    (on o k)
    (on k j)
    (on j i)
    (on i p)
    (on p l)
    (on l c)
    (on c a)
)
)
)
