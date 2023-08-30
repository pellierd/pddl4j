(define (problem schedule-19-0)
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
    (shape a0 oblong)
    (surface-condition a0 smooth)
    (painted a0 blue)
    (has-hole a0 two front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 smooth)
    (painted b0 black)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 polished)
    (painted c0 blue)
    (has-hole c0 two front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 rough)
    (painted d0 black)
    (has-hole d0 one front)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 polished)
    (painted e0 yellow)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 polished)
    (painted f0 yellow)
    (has-hole f0 three front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 smooth)
    (painted g0 yellow)
    (has-hole g0 two back)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 smooth)
    (painted h0 blue)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 rough)
    (painted i0 blue)
    (has-hole i0 three back)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 polished)
    (painted j0 black)
    (has-hole j0 one front)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 smooth)
    (painted k0 blue)
    (has-hole k0 two front)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 smooth)
    (painted l0 red)
    (has-hole l0 one back)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 smooth)
    (painted m0 yellow)
    (has-hole m0 one front)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 rough)
    (painted n0 black)
    (has-hole n0 one front)
    (temperature n0 cold)
    (shape o0 cylindrical)
    (surface-condition o0 polished)
    (painted o0 black)
    (has-hole o0 two front)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 smooth)
    (painted q0 red)
    (has-hole q0 two front)
    (temperature q0 cold)
    (shape p0 circular)
    (surface-condition p0 rough)
    (painted p0 blue)
    (has-hole p0 two front)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 rough)
    (painted r0 red)
    (has-hole r0 three back)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 polished)
    (painted s0 blue)
    (has-hole s0 three front)
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
    (shape k0 cylindrical)
    (shape a0 cylindrical)
    (surface-condition f0 rough)
    (painted d0 red)
    (surface-condition k0 polished)
    (painted l0 black)
    (shape s0 cylindrical)
    (painted a0 yellow)
    (painted g0 blue)
    (surface-condition o0 smooth)
    (surface-condition n0 smooth)
    (painted q0 black)
    (painted n0 blue)
    (shape p0 cylindrical)
    (shape n0 cylindrical)
    (surface-condition r0 polished)
    (painted p0 yellow)
    (shape c0 cylindrical)
    (shape h0 cylindrical)
)))
