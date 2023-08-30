(define (problem blocks-23-1)
(:domain blocks)
(:objects
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
    (clear m)
    (clear u)
    (clear f)
    (clear q)
    (clear n)
    (ontable b)
    (ontable o)
    (ontable j)
    (ontable q)
    (ontable n)
    (on m a)
    (on a r)
    (on r b)
    (on u g)
    (on g t)
    (on t s)
    (on s v)
    (on v h)
    (on h c)
    (on c k)
    (on k p)
    (on p l)
    (on l w)
    (on w o)
    (on f e)
    (on e d)
    (on d i)
    (on i j)
    (handempty)
)
(:goal (and
    (on a m)
    (on m t)
    (on t n)
    (on n j)
    (on j i)
    (on i g)
    (on g o)
    (on o v)
    (on v u)
    (on u h)
    (on h c)
    (on c w)
    (on w q)
    (on q e)
    (on e k)
    (on k r)
    (on r p)
    (on p b)
    (on b s)
    (on s f)
    (on f l)
    (on l d)
)
)
)
