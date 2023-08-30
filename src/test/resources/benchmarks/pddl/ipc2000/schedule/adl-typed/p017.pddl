(define (problem schedule-7-1)
(:domain schedule)
(:objects
    g0
    f0
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
    (shape a0 circular)
    (surface-condition a0 rough)
    (painted a0 yellow)
    (has-hole a0 three back)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 polished)
    (painted b0 red)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 rough)
    (painted c0 yellow)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 polished)
    (painted d0 red)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 polished)
    (painted e0 blue)
    (has-hole e0 two front)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 polished)
    (painted f0 black)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 polished)
    (painted g0 black)
    (has-hole g0 one front)
    (temperature g0 cold)
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
    (surface-condition b0 rough)
    (painted c0 blue)
    (painted g0 yellow)
    (painted e0 black)
    (painted f0 yellow)
    (shape g0 cylindrical)
    (surface-condition e0 smooth)
)))
