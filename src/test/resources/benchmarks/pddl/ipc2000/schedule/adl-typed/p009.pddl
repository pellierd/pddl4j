(define (problem schedule-4-2)
(:domain schedule)
(:objects
    d0
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
    (shape a0 cylindrical)
    (surface-condition a0 polished)
    (painted a0 black)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 rough)
    (painted b0 yellow)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 polished)
    (painted c0 red)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 rough)
    (painted d0 blue)
    (has-hole d0 three front)
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
)
(:goal (and
    (painted b0 red)
    (surface-condition d0 smooth)
    (shape b0 cylindrical)
    (shape c0 cylindrical)
)))
