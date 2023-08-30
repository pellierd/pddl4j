(define (problem blocks-20-0)
(:domain blocks)
(:objects
    t
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
    (clear s)
    (clear n)
    (clear p)
    (ontable h)
    (ontable n)
    (ontable k)
    (on s c)
    (on c m)
    (on m q)
    (on q b)
    (on b t)
    (on t j)
    (on j l)
    (on l e)
    (on e i)
    (on i o)
    (on o g)
    (on g f)
    (on f a)
    (on a d)
    (on d h)
    (on p r)
    (on r k)
    (handempty)
)
(:goal (and
    (on k e)
    (on e n)
    (on n r)
    (on r d)
    (on d g)
    (on g h)
    (on h o)
    (on o a)
    (on a l)
    (on l j)
    (on j f)
    (on f m)
    (on m i)
    (on i q)
    (on q b)
    (on b p)
    (on p t)
    (on t s)
    (on s c)
)
)
)
