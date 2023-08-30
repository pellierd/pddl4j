(define (problem blocks-32-1)
(:domain blocks)
(:objects
    f1
    e1
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
    (clear t)
    (clear i)
    (ontable a)
    (ontable j)
    (on t h)
    (on h b)
    (on b a)
    (on i e)
    (on e n)
    (on n s)
    (on s d1)
    (on d1 b1)
    (on b1 k)
    (on k e1)
    (on e1 z)
    (on z c1)
    (on c1 a1)
    (on a1 w)
    (on w x)
    (on x f1)
    (on f1 r)
    (on r f)
    (on f o)
    (on o d)
    (on d c)
    (on c l)
    (on l m)
    (on m v)
    (on v p)
    (on p g)
    (on g q)
    (on q u)
    (on u y)
    (on y j)
    (handempty)
)
(:goal (and
    (on p d1)
    (on d1 n)
    (on n u)
    (on u z)
    (on z s)
    (on s a1)
    (on a1 t)
    (on t e)
    (on e g)
    (on g r)
    (on r q)
    (on q i)
    (on i e1)
    (on e1 w)
    (on w j)
    (on j x)
    (on x b1)
    (on b1 a)
    (on a v)
    (on v f1)
    (on f1 l)
    (on l c1)
    (on c1 m)
    (on m b)
    (on b d)
    (on d o)
    (on o f)
    (on f h)
    (on h y)
    (on y k)
    (on k c)
)
)
)
