(define (problem schedule-15-2)
(:domain schedule)
(:objects
    o0
    n0
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
    (painted a0 yellow)
    (has-hole a0 three front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 rough)
    (painted b0 yellow)
    (has-hole b0 two back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 polished)
    (painted c0 blue)
    (has-hole c0 two front)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 polished)
    (painted d0 yellow)
    (has-hole d0 one front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 polished)
    (painted e0 red)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 smooth)
    (painted f0 black)
    (has-hole f0 one front)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 rough)
    (painted g0 red)
    (has-hole g0 two front)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 rough)
    (painted h0 blue)
    (has-hole h0 three back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 rough)
    (painted i0 yellow)
    (has-hole i0 one back)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 smooth)
    (painted j0 blue)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 polished)
    (painted k0 red)
    (has-hole k0 three front)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 smooth)
    (painted l0 blue)
    (has-hole l0 one back)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 polished)
    (painted m0 red)
    (has-hole m0 two back)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 polished)
    (painted n0 red)
    (has-hole n0 one front)
    (temperature n0 cold)
    (shape o0 cylindrical)
    (surface-condition o0 polished)
    (painted o0 blue)
    (has-hole o0 two back)
    (temperature o0 cold)
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
    (surface-condition n0 smooth)
    (painted a0 blue)
    (painted b0 red)
    (painted o0 red)
    (surface-condition m0 smooth)
    (shape f0 cylindrical)
    (surface-condition i0 polished)
    (painted j0 yellow)
    (surface-condition k0 rough)
    (surface-condition c0 smooth)
    (painted i0 black)
    (shape l0 cylindrical)
    (surface-condition f0 rough)
    (painted l0 black)
    (painted k0 black)
)))
