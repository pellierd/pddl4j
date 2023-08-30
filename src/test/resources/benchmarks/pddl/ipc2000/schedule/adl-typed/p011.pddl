(define (problem schedule-5-1)
(:domain schedule)
(:objects
    e0
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
    (surface-condition a0 rough)
    (painted a0 blue)
    (has-hole a0 three front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 polished)
    (painted b0 red)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 polished)
    (painted c0 red)
    (has-hole c0 one back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 rough)
    (painted d0 black)
    (has-hole d0 two front)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 polished)
    (painted e0 blue)
    (has-hole e0 three front)
    (temperature e0 cold)
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
    (surface-condition e0 rough)
    (painted d0 red)
    (shape b0 cylindrical)
    (painted b0 blue)
    (surface-condition c0 rough)
)))
