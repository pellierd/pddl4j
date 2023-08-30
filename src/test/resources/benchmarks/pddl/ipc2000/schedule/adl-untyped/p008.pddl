(define (problem schedule-4-1)
(:domain schedule)
(:objects
    d0
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
    (shape a0 circular)
    (surface-condition a0 rough)
    (painted a0 red)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 smooth)
    (painted b0 red)
    (has-hole b0 three front)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 rough)
    (painted c0 blue)
    (has-hole c0 two back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 polished)
    (painted d0 red)
    (has-hole d0 one back)
    (temperature d0 cold)
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
    (part d0)
    (part c0)
    (part b0)
    (part a0)
)
(:goal (and
    (shape b0 cylindrical)
    (painted d0 black)
    (surface-condition b0 polished)
    (surface-condition d0 rough)
)))
