(define (problem blocks-19-0)
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
    (clear n)
    (clear l)
    (clear s)
    (ontable b)
    (ontable l)
    (ontable s)
    (on n j)
    (on j k)
    (on k g)
    (on g a)
    (on a r)
    (on r i)
    (on i p)
    (on p m)
    (on m q)
    (on q c)
    (on c d)
    (on d h)
    (on h o)
    (on o e)
    (on e f)
    (on f b)
    (handempty)
)
(:goal (and
    (on h q)
    (on q p)
    (on p a)
    (on a l)
    (on l r)
    (on r i)
    (on i d)
    (on d j)
    (on j b)
    (on b n)
    (on n f)
    (on f s)
    (on s m)
    (on m o)
    (on o e)
    (on e c)
    (on c k)
    (on k g)
)
)
)
