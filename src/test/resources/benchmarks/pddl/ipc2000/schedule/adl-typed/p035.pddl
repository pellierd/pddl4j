(define (problem schedule-13-1)
(:domain schedule)
(:objects
    m0
    l0
    k0
    j0
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
    (shape a0 cylindrical)
    (surface-condition a0 polished)
    (painted a0 red)
    (has-hole a0 three front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 smooth)
    (painted b0 blue)
    (has-hole b0 two back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 rough)
    (painted c0 yellow)
    (has-hole c0 two back)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 rough)
    (painted d0 black)
    (has-hole d0 one front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 smooth)
    (painted e0 black)
    (has-hole e0 one back)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 smooth)
    (painted f0 yellow)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 smooth)
    (painted g0 black)
    (has-hole g0 one back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 yellow)
    (has-hole h0 two front)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 polished)
    (painted i0 yellow)
    (has-hole i0 three back)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 rough)
    (painted j0 red)
    (has-hole j0 one back)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 rough)
    (painted k0 yellow)
    (has-hole k0 three front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 polished)
    (painted l0 blue)
    (has-hole l0 one back)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 smooth)
    (painted m0 yellow)
    (has-hole m0 one front)
    (temperature m0 cold)
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
    (painted i0 red)
    (painted h0 red)
    (surface-condition c0 smooth)
    (surface-condition f0 polished)
    (surface-condition e0 rough)
    (surface-condition j0 polished)
    (shape g0 cylindrical)
    (shape j0 cylindrical)
    (shape l0 cylindrical)
    (surface-condition m0 polished)
    (surface-condition h0 rough)
    (surface-condition g0 polished)
    (surface-condition a0 rough)
)))
