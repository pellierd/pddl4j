(define (problem blocks-23-0)
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
    (clear v)
    (clear q)
    (clear b)
    (clear u)
    (clear f)
    (ontable g)
    (ontable q)
    (ontable b)
    (ontable w)
    (ontable s)
    (on v a)
    (on a k)
    (on k n)
    (on n d)
    (on d i)
    (on i m)
    (on m j)
    (on j o)
    (on o t)
    (on t l)
    (on l c)
    (on c p)
    (on p e)
    (on e g)
    (on u r)
    (on r w)
    (on f h)
    (on h s)
    (handempty)
)
(:goal (and
    (on e k)
    (on k i)
    (on i j)
    (on j a)
    (on a q)
    (on q f)
    (on f n)
    (on n d)
    (on d w)
    (on w c)
    (on c h)
    (on h p)
    (on p r)
    (on r t)
    (on t s)
    (on s v)
    (on v b)
    (on b u)
    (on u l)
    (on l o)
    (on o g)
    (on g m)
)
)
)
