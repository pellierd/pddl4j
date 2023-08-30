(define (problem blocks-30-1)
(:domain blocks)
(:objects
    d1
    c1
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
    (clear i)
    (clear g)
    (clear u)
    (ontable q)
    (ontable s)
    (ontable u)
    (on i v)
    (on v c)
    (on c f)
    (on f e)
    (on e d1)
    (on d1 h)
    (on h y)
    (on y j)
    (on j b)
    (on b k)
    (on k a)
    (on a l)
    (on l q)
    (on g x)
    (on x p)
    (on p z)
    (on z r)
    (on r d)
    (on d c1)
    (on c1 n)
    (on n w)
    (on w o)
    (on o m)
    (on m b1)
    (on b1 a1)
    (on a1 t)
    (on t s)
    (handempty)
)
(:goal (and
    (on s z)
    (on z p)
    (on p a1)
    (on a1 u)
    (on u q)
    (on q c1)
    (on c1 i)
    (on i g)
    (on g w)
    (on w d)
    (on d h)
    (on h t)
    (on t l)
    (on l r)
    (on r j)
    (on j d1)
    (on d1 n)
    (on n c)
    (on c v)
    (on v b)
    (on b e)
    (on e x)
    (on x b1)
    (on b1 f)
    (on f y)
    (on y k)
    (on k o)
    (on o m)
    (on m a)
)
)
)
