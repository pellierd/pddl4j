(define (problem blocks-19-1)
(:domain blocks)
(:objects
    s
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
    (clear a)
    (clear q)
    (clear o)
    (ontable e)
    (ontable d)
    (ontable k)
    (on a h)
    (on h l)
    (on l c)
    (on c s)
    (on s f)
    (on f p)
    (on p m)
    (on m g)
    (on g j)
    (on j n)
    (on n i)
    (on i r)
    (on r e)
    (on q d)
    (on o b)
    (on b k)
    (handempty)
)
(:goal (and
    (on l c)
    (on c s)
    (on s i)
    (on i j)
    (on j k)
    (on k e)
    (on e b)
    (on b h)
    (on h a)
    (on a d)
    (on d p)
    (on p n)
    (on n o)
    (on o r)
    (on r q)
    (on q f)
    (on f g)
    (on g m)
)
)
)
