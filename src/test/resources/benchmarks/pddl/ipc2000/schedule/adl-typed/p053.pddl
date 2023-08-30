(define (problem schedule-19-1)
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
    (surface-condition a0 smooth)
    (painted a0 blue)
    (has-hole a0 one back)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 polished)
    (painted b0 yellow)
    (has-hole b0 two back)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 rough)
    (painted c0 red)
    (has-hole c0 two back)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 rough)
    (painted d0 blue)
    (has-hole d0 three front)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 rough)
    (painted e0 black)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 smooth)
    (painted f0 blue)
    (has-hole f0 one front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 rough)
    (painted g0 black)
    (has-hole g0 one front)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 polished)
    (painted h0 red)
    (has-hole h0 one front)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 polished)
    (painted i0 yellow)
    (has-hole i0 one front)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 smooth)
    (painted j0 blue)
    (has-hole j0 two back)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 polished)
    (painted k0 yellow)
    (has-hole k0 two back)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 smooth)
    (painted l0 yellow)
    (has-hole l0 three back)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 polished)
    (painted m0 red)
    (has-hole m0 three front)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 smooth)
    (painted n0 yellow)
    (has-hole n0 three back)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 polished)
    (painted o0 red)
    (has-hole o0 two back)
    (temperature o0 cold)
    (shape q0 circular)
    (surface-condition q0 smooth)
    (painted q0 yellow)
    (has-hole q0 two back)
    (temperature q0 cold)
    (shape p0 circular)
    (surface-condition p0 polished)
    (painted p0 yellow)
    (has-hole p0 two back)
    (temperature p0 cold)
    (shape r0 circular)
    (surface-condition r0 rough)
    (painted r0 red)
    (has-hole r0 three back)
    (temperature r0 cold)
    (shape s0 cylindrical)
    (surface-condition s0 polished)
    (painted s0 blue)
    (has-hole s0 one front)
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
    (shape e0 cylindrical)
    (painted d0 yellow)
    (surface-condition j0 rough)
    (surface-condition i0 smooth)
    (surface-condition l0 rough)
    (shape d0 cylindrical)
    (shape h0 cylindrical)
    (painted b0 blue)
    (shape q0 cylindrical)
    (surface-condition k0 rough)
    (painted r0 blue)
    (shape o0 cylindrical)
    (surface-condition c0 smooth)
    (shape l0 cylindrical)
    (shape r0 cylindrical)
    (surface-condition r0 smooth)
    (painted f0 yellow)
    (surface-condition e0 polished)
    (shape b0 cylindrical)
)))
