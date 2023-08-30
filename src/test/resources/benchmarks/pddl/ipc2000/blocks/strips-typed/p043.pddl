(define (problem blocks-21-0)
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
    (clear k)
    (clear h)
    (ontable f)
    (ontable h)
    (on k i)
    (on i p)
    (on p m)
    (on m r)
    (on r c)
    (on c s)
    (on s e)
    (on e q)
    (on q n)
    (on n b)
    (on b g)
    (on g j)
    (on j a)
    (on a u)
    (on u d)
    (on d o)
    (on o t)
    (on t l)
    (on l f)
    (handempty)
)
(:goal (and
    (on h l)
    (on l b)
    (on b e)
    (on e c)
    (on c s)
    (on s p)
    (on p o)
    (on o r)
    (on r k)
    (on k t)
    (on t u)
    (on u q)
    (on q j)
    (on j n)
    (on n g)
    (on g i)
    (on i d)
    (on d a)
    (on a m)
    (on m f)
)
)
)
