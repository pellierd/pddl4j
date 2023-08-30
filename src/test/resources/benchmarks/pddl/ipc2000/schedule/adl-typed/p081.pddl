(define (problem schedule-28-2)
(:domain schedule)
(:objects
    e1
    d1
    c1
    b1
    a1
    z0
    w0
    v0
    u0
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
    (shape a0 circular)
    (surface-condition a0 rough)
    (painted a0 blue)
    (has-hole a0 three front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 smooth)
    (painted b0 blue)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 polished)
    (painted c0 yellow)
    (has-hole c0 three back)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 polished)
    (painted d0 red)
    (has-hole d0 three back)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 polished)
    (painted e0 red)
    (has-hole e0 three front)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 polished)
    (painted f0 red)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 smooth)
    (painted g0 blue)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 yellow)
    (has-hole h0 two front)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 rough)
    (painted i0 black)
    (has-hole i0 three back)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 polished)
    (painted j0 black)
    (has-hole j0 two back)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 polished)
    (painted k0 yellow)
    (has-hole k0 one front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 polished)
    (painted l0 blue)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 polished)
    (painted m0 yellow)
    (has-hole m0 two front)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 smooth)
    (painted n0 blue)
    (has-hole n0 three front)
    (temperature n0 cold)
    (shape o0 cylindrical)
    (surface-condition o0 rough)
    (painted o0 blue)
    (has-hole o0 two front)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 polished)
    (painted q0 blue)
    (has-hole q0 one back)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 smooth)
    (painted p0 yellow)
    (has-hole p0 three front)
    (temperature p0 cold)
    (shape r0 circular)
    (surface-condition r0 polished)
    (painted r0 red)
    (has-hole r0 one back)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 polished)
    (painted s0 yellow)
    (has-hole s0 one back)
    (temperature s0 cold)
    (shape u0 cylindrical)
    (surface-condition u0 smooth)
    (painted u0 blue)
    (has-hole u0 three back)
    (temperature u0 cold)
    (shape v0 oblong)
    (surface-condition v0 rough)
    (painted v0 blue)
    (has-hole v0 one back)
    (temperature v0 cold)
    (shape w0 cylindrical)
    (surface-condition w0 polished)
    (painted w0 yellow)
    (has-hole w0 one front)
    (temperature w0 cold)
    (shape z0 circular)
    (surface-condition z0 polished)
    (painted z0 blue)
    (has-hole z0 two back)
    (temperature z0 cold)
    (shape a1 oblong)
    (surface-condition a1 smooth)
    (painted a1 yellow)
    (has-hole a1 three front)
    (temperature a1 cold)
    (shape b1 circular)
    (surface-condition b1 rough)
    (painted b1 blue)
    (has-hole b1 one back)
    (temperature b1 cold)
    (shape c1 circular)
    (surface-condition c1 rough)
    (painted c1 red)
    (has-hole c1 one front)
    (temperature c1 cold)
    (shape d1 oblong)
    (surface-condition d1 smooth)
    (painted d1 yellow)
    (has-hole d1 two back)
    (temperature d1 cold)
    (shape e1 circular)
    (surface-condition e1 polished)
    (painted e1 blue)
    (has-hole e1 two back)
    (temperature e1 cold)
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
    (surface-condition r0 smooth)
    (surface-condition s0 smooth)
    (painted b0 black)
    (shape e0 cylindrical)
    (surface-condition z0 rough)
    (surface-condition c1 polished)
    (surface-condition v0 polished)
    (painted s0 red)
    (painted e0 black)
    (surface-condition d0 smooth)
    (shape b1 cylindrical)
    (painted o0 red)
    (shape f0 cylindrical)
    (shape s0 cylindrical)
    (shape r0 cylindrical)
    (shape k0 cylindrical)
    (painted d0 blue)
    (shape a0 cylindrical)
    (painted m0 black)
    (shape i0 cylindrical)
    (painted e1 black)
    (shape h0 cylindrical)
    (surface-condition u0 rough)
    (painted n0 yellow)
    (shape c0 cylindrical)
    (painted i0 red)
    (surface-condition j0 rough)
    (shape d0 cylindrical)
)))
