(define (problem blocks-17-1)
(:domain blocks)
(:objects
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
    (clear l)
    (clear n)
    (ontable o)
    (ontable a)
    (ontable f)
    (on k c)
    (on c m)
    (on m i)
    (on i e)
    (on e g)
    (on g q)
    (on q b)
    (on b p)
    (on p h)
    (on h j)
    (on j o)
    (on l d)
    (on d a)
    (on n f)
    (handempty)
)
(:goal (and
    (on p q)
    (on q l)
    (on l n)
    (on n c)
    (on c i)
    (on i k)
    (on k f)
    (on f j)
    (on j b)
    (on b g)
    (on g a)
    (on a h)
    (on h e)
    (on e o)
    (on o m)
    (on m d)
)
)
)
