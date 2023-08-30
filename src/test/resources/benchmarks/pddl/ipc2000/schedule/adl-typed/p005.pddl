(define (problem schedule-3-1)
(:domain schedule)
(:objects
    c0
    b0
    a0
 - part
    circular
    oblong
 - ashape
    blue
    yellow
    red
    black
 - colour
    two
    three
    one
 - width
    back
    front
 - anorient
)
(:init
    (shape a0 circular)
    (surface-condition a0 polished)
    (painted a0 black)
    (has-hole a0 three front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 rough)
    (painted b0 blue)
    (has-hole b0 three front)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 polished)
    (painted c0 red)
    (has-hole c0 two back)
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
)
(:goal (and
    (shape c0 cylindrical)
    (painted a0 yellow)
    (surface-condition c0 rough)
)))
