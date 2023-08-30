(define (problem schedule-26-1)
(:domain schedule)
(:objects
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
    (shape a0 cylindrical)
    (surface-condition a0 rough)
    (painted a0 blue)
    (has-hole a0 three back)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 polished)
    (painted b0 blue)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 polished)
    (painted c0 red)
    (has-hole c0 two back)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 polished)
    (painted d0 black)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 smooth)
    (painted e0 red)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 polished)
    (painted f0 red)
    (has-hole f0 three back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 polished)
    (painted g0 yellow)
    (has-hole g0 two back)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 polished)
    (painted h0 blue)
    (has-hole h0 one back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 rough)
    (painted i0 yellow)
    (has-hole i0 three back)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 polished)
    (painted j0 blue)
    (has-hole j0 one back)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 smooth)
    (painted k0 yellow)
    (has-hole k0 three front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 polished)
    (painted l0 black)
    (has-hole l0 two back)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 smooth)
    (painted m0 red)
    (has-hole m0 three front)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 polished)
    (painted n0 blue)
    (has-hole n0 two back)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 rough)
    (painted o0 blue)
    (has-hole o0 one front)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 polished)
    (painted q0 yellow)
    (has-hole q0 three back)
    (temperature q0 cold)
    (shape p0 oblong)
    (surface-condition p0 polished)
    (painted p0 blue)
    (has-hole p0 two front)
    (temperature p0 cold)
    (shape r0 circular)
    (surface-condition r0 smooth)
    (painted r0 red)
    (has-hole r0 one front)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 polished)
    (painted s0 black)
    (has-hole s0 one back)
    (temperature s0 cold)
    (shape u0 cylindrical)
    (surface-condition u0 smooth)
    (painted u0 blue)
    (has-hole u0 three back)
    (temperature u0 cold)
    (shape v0 oblong)
    (surface-condition v0 smooth)
    (painted v0 blue)
    (has-hole v0 one back)
    (temperature v0 cold)
    (shape w0 cylindrical)
    (surface-condition w0 smooth)
    (painted w0 yellow)
    (has-hole w0 three back)
    (temperature w0 cold)
    (shape z0 circular)
    (surface-condition z0 smooth)
    (painted z0 yellow)
    (has-hole z0 three back)
    (temperature z0 cold)
    (shape a1 circular)
    (surface-condition a1 polished)
    (painted a1 blue)
    (has-hole a1 one front)
    (temperature a1 cold)
    (shape b1 circular)
    (surface-condition b1 smooth)
    (painted b1 black)
    (has-hole b1 one front)
    (temperature b1 cold)
    (shape c1 cylindrical)
    (surface-condition c1 rough)
    (painted c1 red)
    (has-hole c1 three front)
    (temperature c1 cold)
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
    (painted z0 red)
    (painted u0 red)
    (painted a1 black)
    (surface-condition s0 rough)
    (surface-condition c1 polished)
    (painted b1 blue)
    (painted n0 black)
    (surface-condition k0 polished)
    (shape c0 cylindrical)
    (painted r0 yellow)
    (painted s0 blue)
    (shape z0 cylindrical)
    (painted l0 red)
    (painted c0 yellow)
    (shape r0 cylindrical)
    (surface-condition l0 smooth)
    (surface-condition j0 rough)
    (surface-condition v0 polished)
    (shape v0 cylindrical)
    (shape q0 cylindrical)
    (surface-condition e0 rough)
    (painted m0 blue)
    (shape d0 cylindrical)
    (painted w0 blue)
    (surface-condition q0 smooth)
    (surface-condition i0 smooth)
)))
