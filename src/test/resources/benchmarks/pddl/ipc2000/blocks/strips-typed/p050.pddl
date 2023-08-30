(define (problem blocks-24-1)
(:domain blocks)
(:objects
    x
    w
    v
    u
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
    (clear k)
    (clear i)
    (ontable c)
    (ontable o)
    (on k f)
    (on f t)
    (on t b)
    (on b g)
    (on g r)
    (on r m)
    (on m e)
    (on e j)
    (on j v)
    (on v n)
    (on n u)
    (on u h)
    (on h c)
    (on i a)
    (on a p)
    (on p q)
    (on q d)
    (on d w)
    (on w x)
    (on x s)
    (on s l)
    (on l o)
    (handempty)
)
(:goal (and
    (on l c)
    (on c p)
    (on p q)
    (on q m)
    (on m b)
    (on b g)
    (on g f)
    (on f k)
    (on k e)
    (on e r)
    (on r a)
    (on a w)
    (on w t)
    (on t n)
    (on n j)
    (on j u)
    (on u s)
    (on s d)
    (on d h)
    (on h v)
    (on v o)
    (on o i)
    (on i x)
)
)
)
