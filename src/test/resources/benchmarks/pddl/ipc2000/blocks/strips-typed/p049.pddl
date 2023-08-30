(define (problem blocks-24-0)
(:domain blocks)
(:objects
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
    (clear b)
    (clear g)
    (clear v)
    (clear m)
    (clear r)
    (ontable t)
    (ontable q)
    (ontable f)
    (ontable h)
    (ontable r)
    (on b o)
    (on o c)
    (on c l)
    (on l k)
    (on k i)
    (on i s)
    (on s d)
    (on d t)
    (on g p)
    (on p a)
    (on a j)
    (on j n)
    (on n x)
    (on x q)
    (on v w)
    (on w e)
    (on e u)
    (on u f)
    (on m h)
    (handempty)
)
(:goal (and
    (on i e)
    (on e f)
    (on f o)
    (on o x)
    (on x j)
    (on j n)
    (on n v)
    (on v p)
    (on p m)
    (on m h)
    (on h k)
    (on k l)
    (on l d)
    (on d u)
    (on u a)
    (on a t)
    (on t r)
    (on r c)
    (on c g)
    (on g q)
    (on q s)
    (on s b)
    (on b w)
)
)
)
