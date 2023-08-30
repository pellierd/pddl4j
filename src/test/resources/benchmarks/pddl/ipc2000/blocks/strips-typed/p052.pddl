(define (problem blocks-25-1)
(:domain blocks)
(:objects
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
    (clear k)
    (clear u)
    (clear s)
    (ontable v)
    (ontable g)
    (ontable a)
    (on k f)
    (on f b)
    (on b y)
    (on y l)
    (on l w)
    (on w d)
    (on d t)
    (on t c)
    (on c i)
    (on i r)
    (on r p)
    (on p n)
    (on n h)
    (on h o)
    (on o x)
    (on x e)
    (on e j)
    (on j m)
    (on m v)
    (on u g)
    (on s q)
    (on q a)
    (handempty)
)
(:goal (and
    (on p y)
    (on y t)
    (on t r)
    (on r n)
    (on n l)
    (on l u)
    (on u a)
    (on a o)
    (on o d)
    (on d i)
    (on i q)
    (on q c)
    (on c m)
    (on m h)
    (on h g)
    (on g b)
    (on b v)
    (on v e)
    (on e j)
    (on j s)
    (on s x)
    (on x k)
    (on k f)
    (on f w)
)
)
)
