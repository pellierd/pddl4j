(define (problem blocks-28-1)
(:domain blocks)
(:objects
    b1
    a1
    z
    y
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
    (clear u)
    (clear t)
    (clear w)
    (ontable b1)
    (ontable o)
    (ontable l)
    (on u a)
    (on a f)
    (on f y)
    (on y s)
    (on s d)
    (on d i)
    (on i g)
    (on g j)
    (on j a1)
    (on a1 k)
    (on k v)
    (on v r)
    (on r b1)
    (on t o)
    (on w n)
    (on n z)
    (on z b)
    (on b e)
    (on e q)
    (on q x)
    (on x c)
    (on c m)
    (on m h)
    (on h p)
    (on p l)
    (handempty)
)
(:goal (and
    (on a x)
    (on x f)
    (on f e)
    (on e m)
    (on m p)
    (on p h)
    (on h g)
    (on g b1)
    (on b1 u)
    (on u a1)
    (on a1 o)
    (on o b)
    (on b r)
    (on r l)
    (on l t)
    (on t w)
    (on w z)
    (on z i)
    (on i d)
    (on d n)
    (on n s)
    (on s v)
    (on v y)
    (on y q)
    (on q c)
    (on c j)
    (on j k)
)
)
)
