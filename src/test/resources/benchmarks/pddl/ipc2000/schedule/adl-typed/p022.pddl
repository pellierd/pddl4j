(define (problem schedule-9-0)
(:domain schedule)
(:objects
    i0
    h0
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
    (surface-condition a0 smooth)
    (painted a0 black)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 rough)
    (painted b0 yellow)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 smooth)
    (painted c0 blue)
    (has-hole c0 one back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 smooth)
    (painted d0 blue)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 polished)
    (painted e0 blue)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 polished)
    (painted f0 yellow)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 rough)
    (painted g0 yellow)
    (has-hole g0 two back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 yellow)
    (has-hole h0 two front)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 polished)
    (painted i0 blue)
    (has-hole i0 one front)
    (temperature i0 cold)
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
    (painted i0 yellow)
    (surface-condition f0 smooth)
    (painted e0 yellow)
    (painted f0 red)
    (painted d0 yellow)
    (painted g0 red)
    (painted b0 red)
    (painted a0 red)
    (shape b0 cylindrical)
)))
