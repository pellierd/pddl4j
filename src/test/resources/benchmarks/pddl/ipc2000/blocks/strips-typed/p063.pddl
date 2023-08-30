(define (problem blocks-31-0)
(:domain blocks)
(:objects
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
    (clear y)
    (clear c1)
    (clear j)
    (ontable m)
    (ontable a)
    (ontable p)
    (on y a1)
    (on a1 h)
    (on h d)
    (on d f)
    (on f r)
    (on r w)
    (on w t)
    (on t q)
    (on q g)
    (on g l)
    (on l v)
    (on v o)
    (on o n)
    (on n d1)
    (on d1 e1)
    (on e1 b)
    (on b b1)
    (on b1 m)
    (on c1 x)
    (on x s)
    (on s k)
    (on k z)
    (on z c)
    (on c a)
    (on j e)
    (on e i)
    (on i u)
    (on u p)
    (handempty)
)
(:goal (and
    (on r g)
    (on g d)
    (on d w)
    (on w t)
    (on t c)
    (on c i)
    (on i f)
    (on f a1)
    (on a1 y)
    (on y n)
    (on n d1)
    (on d1 e)
    (on e l)
    (on l c1)
    (on c1 p)
    (on p a)
    (on a b1)
    (on b1 s)
    (on s m)
    (on m v)
    (on v o)
    (on o q)
    (on q z)
    (on z h)
    (on h b)
    (on b j)
    (on j x)
    (on x u)
    (on u k)
    (on k e1)
)
)
)
