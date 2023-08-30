(define (problem blocks-18-0)
(:domain blocks)
(:objects
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
    (clear b)
    (clear q)
    (ontable g)
    (ontable r)
    (ontable h)
    (on k o)
    (on o g)
    (on b l)
    (on l m)
    (on m f)
    (on f j)
    (on j n)
    (on n i)
    (on i a)
    (on a e)
    (on e d)
    (on d r)
    (on q p)
    (on p c)
    (on c h)
    (handempty)
)
(:goal (and
    (on h j)
    (on j n)
    (on n r)
    (on r f)
    (on f k)
    (on k l)
    (on l i)
    (on i b)
    (on b m)
    (on m c)
    (on c d)
    (on d a)
    (on a o)
    (on o q)
    (on q p)
    (on p g)
    (on g e)
)
)
)
