(define (problem blocks-22-1)
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
    (clear p)
    (clear o)
    (clear g)
    (clear a)
    (clear n)
    (ontable q)
    (ontable i)
    (ontable k)
    (ontable a)
    (ontable n)
    (on p u)
    (on u q)
    (on o f)
    (on f i)
    (on g r)
    (on r l)
    (on l m)
    (on m v)
    (on v b)
    (on b s)
    (on s j)
    (on j t)
    (on t d)
    (on d h)
    (on h c)
    (on c e)
    (on e k)
    (handempty)
)
(:goal (and
    (on c t)
    (on t l)
    (on l i)
    (on i e)
    (on e g)
    (on g b)
    (on b j)
    (on j v)
    (on v k)
    (on k h)
    (on h a)
    (on a s)
    (on s d)
    (on d m)
    (on m r)
    (on r q)
    (on q o)
    (on o p)
    (on p f)
    (on f n)
    (on n u)
)
)
)
