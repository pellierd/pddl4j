(define (problem blocks-31-1)
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
    (clear p)
    (clear r)
    (clear z)
    (clear k)
    (clear n)
    (ontable h)
    (ontable f)
    (ontable i)
    (ontable u)
    (ontable s)
    (on p c)
    (on c a)
    (on a v)
    (on v e)
    (on e a1)
    (on a1 o)
    (on o g)
    (on g d)
    (on d b)
    (on b m)
    (on m l)
    (on l y)
    (on y d1)
    (on d1 c1)
    (on c1 e1)
    (on e1 x)
    (on x q)
    (on q b1)
    (on b1 h)
    (on r f)
    (on z w)
    (on w t)
    (on t i)
    (on k u)
    (on n j)
    (on j s)
    (handempty)
)
(:goal (and
    (on j g)
    (on g c1)
    (on c1 n)
    (on n f)
    (on f r)
    (on r a1)
    (on a1 e1)
    (on e1 c)
    (on c t)
    (on t m)
    (on m q)
    (on q e)
    (on e d)
    (on d b1)
    (on b1 x)
    (on x w)
    (on w p)
    (on p k)
    (on k d1)
    (on d1 z)
    (on z b)
    (on b u)
    (on u y)
    (on y i)
    (on i o)
    (on o v)
    (on v a)
    (on a h)
    (on h s)
    (on s l)
)
)
)
