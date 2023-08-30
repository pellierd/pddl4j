(define (problem blocks-21-1)
(:domain blocks)
(:objects
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
    (clear f)
    (clear b)
    (clear t)
    (ontable m)
    (ontable b)
    (ontable t)
    (on f l)
    (on l d)
    (on d i)
    (on i r)
    (on r a)
    (on a j)
    (on j h)
    (on h s)
    (on s q)
    (on q g)
    (on g u)
    (on u o)
    (on o p)
    (on p k)
    (on k c)
    (on c e)
    (on e n)
    (on n m)
    (handempty)
)
(:goal (and
    (on q l)
    (on l j)
    (on j c)
    (on c m)
    (on m n)
    (on n f)
    (on f u)
    (on u e)
    (on e d)
    (on d t)
    (on t s)
    (on s k)
    (on k h)
    (on h b)
    (on b i)
    (on i r)
    (on r o)
    (on o p)
    (on p a)
    (on a g)
)
)
)
