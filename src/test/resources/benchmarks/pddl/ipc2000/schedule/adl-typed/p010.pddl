(define (problem schedule-5-0)
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
    (surface-condition a0 polished)
    (painted a0 yellow)
    (has-hole a0 two back)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 smooth)
    (painted b0 blue)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 rough)
    (painted c0 red)
    (has-hole c0 three back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 polished)
    (painted d0 black)
    (has-hole d0 one front)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 polished)
    (painted e0 red)
    (has-hole e0 two front)
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
    (surface-condition d0 rough)
    (shape d0 cylindrical)
    (painted d0 yellow)
    (painted a0 blue)
    (surface-condition b0 polished)
)))
