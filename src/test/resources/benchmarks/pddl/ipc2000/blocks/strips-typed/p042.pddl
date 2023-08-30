(define (problem blocks-20-1)
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
    (clear a)
    (clear g)
    (ontable n)
    (ontable m)
    (on a h)
    (on h k)
    (on k q)
    (on q t)
    (on t e)
    (on e i)
    (on i b)
    (on b p)
    (on p l)
    (on l d)
    (on d o)
    (on o j)
    (on j s)
    (on s c)
    (on c f)
    (on f r)
    (on r n)
    (on g m)
    (handempty)
)
(:goal (and
    (on h n)
    (on n a)
    (on a q)
    (on q i)
    (on i o)
    (on o s)
    (on s d)
    (on d c)
    (on c k)
    (on k p)
    (on p l)
    (on l j)
    (on j t)
    (on t g)
    (on g m)
    (on m f)
    (on f b)
    (on b r)
    (on r e)
)
)
)
