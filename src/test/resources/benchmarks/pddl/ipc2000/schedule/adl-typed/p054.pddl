(define (problem schedule-19-2)
(:domain schedule)
(:objects
    s0
    r0
    p0
    q0
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
    (surface-condition a0 rough)
    (painted a0 blue)
    (has-hole a0 three back)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 polished)
    (painted b0 yellow)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 smooth)
    (painted c0 red)
    (has-hole c0 one front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 polished)
    (painted d0 red)
    (has-hole d0 three back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 rough)
    (painted e0 yellow)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 smooth)
    (painted f0 blue)
    (has-hole f0 three front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 smooth)
    (painted g0 blue)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 rough)
    (painted h0 blue)
    (has-hole h0 three back)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 rough)
    (painted i0 yellow)
    (has-hole i0 three back)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 polished)
    (painted j0 red)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 smooth)
    (painted k0 yellow)
    (has-hole k0 one front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 polished)
    (painted l0 black)
    (has-hole l0 one back)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 polished)
    (painted m0 blue)
    (has-hole m0 one back)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 polished)
    (painted n0 red)
    (has-hole n0 one front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 polished)
    (painted o0 blue)
    (has-hole o0 two front)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 smooth)
    (painted q0 blue)
    (has-hole q0 two back)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 rough)
    (painted p0 red)
    (has-hole p0 one back)
    (temperature p0 cold)
    (shape r0 circular)
    (surface-condition r0 rough)
    (painted r0 red)
    (has-hole r0 three front)
    (temperature r0 cold)
    (shape s0 cylindrical)
    (surface-condition s0 rough)
    (painted s0 black)
    (has-hole s0 one back)
    (temperature s0 cold)
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
    (shape i0 cylindrical)
    (surface-condition i0 polished)
    (surface-condition k0 rough)
    (painted e0 blue)
    (surface-condition a0 polished)
    (surface-condition p0 polished)
    (shape n0 cylindrical)
    (shape l0 cylindrical)
    (painted b0 black)
    (painted o0 red)
    (painted d0 blue)
    (surface-condition l0 rough)
    (shape f0 cylindrical)
    (painted a0 yellow)
    (surface-condition h0 polished)
    (painted j0 yellow)
    (painted r0 yellow)
    (painted l0 yellow)
    (surface-condition e0 smooth)
)))
