(define (problem blocks-22-0)
(:domain blocks)
(:objects
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
    (clear n)
    (clear p)
    (clear v)
    (clear u)
    (ontable h)
    (ontable p)
    (ontable r)
    (ontable e)
    (on n h)
    (on v m)
    (on m s)
    (on s d)
    (on d b)
    (on b j)
    (on j l)
    (on l g)
    (on g c)
    (on c q)
    (on q r)
    (on u i)
    (on i a)
    (on a t)
    (on t k)
    (on k o)
    (on o f)
    (on f e)
    (handempty)
)
(:goal (and
    (on h o)
    (on o m)
    (on m q)
    (on q g)
    (on g s)
    (on s i)
    (on i n)
    (on n p)
    (on p u)
    (on u b)
    (on b d)
    (on d f)
    (on f e)
    (on e c)
    (on c k)
    (on k a)
    (on a l)
    (on l r)
    (on r t)
    (on t v)
    (on v j)
)
)
)
