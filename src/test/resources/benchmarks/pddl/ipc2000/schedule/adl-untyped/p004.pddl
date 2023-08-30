(define (problem schedule-3-0)
(:domain schedule)
(:objects
    c0
    circular
    two
    three
    blue
    yellow
    back
    red
    b0
    front
    one
    black
    oblong
    a0
)
(:init
    (shape a0 cylindrical)
    (surface-condition a0 smooth)
    (painted a0 blue)
    (has-hole a0 two front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 rough)
    (painted b0 black)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 rough)
    (painted c0 yellow)
    (has-hole c0 two front)
    (temperature c0 cold)
    (can-orient drill-press back)
    (can-orient punch back)
    (can-orient drill-press front)
    (can-orient punch front)
    (has-paint immersion-painter yellow)
    (has-paint spray-painter yellow)
    (has-paint immersion-painter blue)
    (has-paint spray-painter blue)
    (has-paint immersion-painter black)
    (has-paint spray-painter black)
    (has-paint immersion-painter red)
    (has-paint spray-painter red)
    (has-bit drill-press three)
    (has-bit punch three)
    (has-bit drill-press two)
    (has-bit punch two)
    (has-bit drill-press one)
    (has-bit punch one)
    (part c0)
    (part b0)
    (part a0)
)
(:goal (and
    (surface-condition c0 smooth)
    (surface-condition a0 rough)
    (painted a0 yellow)
)))
