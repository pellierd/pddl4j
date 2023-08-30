(define (problem schedule-25-1)
(:domain schedule)
(:objects
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
    (shape a0 oblong)
    (surface-condition a0 rough)
    (painted a0 blue)
    (has-hole a0 two front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 polished)
    (painted b0 red)
    (has-hole b0 three front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 smooth)
    (painted c0 blue)
    (has-hole c0 three back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 polished)
    (painted d0 blue)
    (has-hole d0 three back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 polished)
    (painted e0 yellow)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 smooth)
    (painted f0 blue)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 rough)
    (painted g0 black)
    (has-hole g0 one back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 black)
    (has-hole h0 one back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 smooth)
    (painted i0 yellow)
    (has-hole i0 one back)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 rough)
    (painted j0 blue)
    (has-hole j0 three front)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 polished)
    (painted k0 black)
    (has-hole k0 one back)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 smooth)
    (painted l0 blue)
    (has-hole l0 one front)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 smooth)
    (painted m0 red)
    (has-hole m0 two back)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 smooth)
    (painted n0 red)
    (has-hole n0 three front)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 polished)
    (painted o0 red)
    (has-hole o0 one front)
    (temperature o0 cold)
    (shape q0 circular)
    (surface-condition q0 smooth)
    (painted q0 blue)
    (has-hole q0 one back)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 smooth)
    (painted p0 blue)
    (has-hole p0 three front)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 polished)
    (painted r0 red)
    (has-hole r0 two back)
    (temperature r0 cold)
    (shape s0 cylindrical)
    (surface-condition s0 rough)
    (painted s0 black)
    (has-hole s0 two back)
    (temperature s0 cold)
    (shape u0 oblong)
    (surface-condition u0 rough)
    (painted u0 black)
    (has-hole u0 two back)
    (temperature u0 cold)
    (shape v0 circular)
    (surface-condition v0 polished)
    (painted v0 blue)
    (has-hole v0 three front)
    (temperature v0 cold)
    (shape w0 circular)
    (surface-condition w0 rough)
    (painted w0 yellow)
    (has-hole w0 three back)
    (temperature w0 cold)
    (shape z0 oblong)
    (surface-condition z0 polished)
    (painted z0 blue)
    (has-hole z0 three front)
    (temperature z0 cold)
    (shape a1 oblong)
    (surface-condition a1 smooth)
    (painted a1 red)
    (has-hole a1 three back)
    (temperature a1 cold)
    (shape b1 cylindrical)
    (surface-condition b1 polished)
    (painted b1 yellow)
    (has-hole b1 three back)
    (temperature b1 cold)
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
    (painted e0 red)
    (painted a1 black)
    (shape c0 cylindrical)
    (painted d0 yellow)
    (painted g0 blue)
    (painted m0 yellow)
    (shape j0 cylindrical)
    (shape g0 cylindrical)
    (shape z0 cylindrical)
    (painted h0 yellow)
    (shape f0 cylindrical)
    (painted v0 red)
    (surface-condition s0 polished)
    (painted q0 red)
    (surface-condition e0 smooth)
    (surface-condition w0 polished)
    (surface-condition f0 polished)
    (shape w0 cylindrical)
    (surface-condition i0 rough)
    (surface-condition n0 rough)
    (surface-condition r0 smooth)
    (painted c0 black)
    (shape o0 cylindrical)
    (shape d0 cylindrical)
    (painted n0 yellow)
)))
