(define (problem schedule-26-2)
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
    (shape a0 oblong)
    (surface-condition a0 smooth)
    (painted a0 yellow)
    (has-hole a0 one back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 rough)
    (painted b0 red)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 rough)
    (painted c0 black)
    (has-hole c0 two front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 smooth)
    (painted d0 black)
    (has-hole d0 one front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 rough)
    (painted e0 red)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 rough)
    (painted f0 red)
    (has-hole f0 one back)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 rough)
    (painted g0 blue)
    (has-hole g0 one front)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 polished)
    (painted h0 blue)
    (has-hole h0 three front)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 polished)
    (painted i0 yellow)
    (has-hole i0 one front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 smooth)
    (painted j0 yellow)
    (has-hole j0 three front)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 polished)
    (painted k0 blue)
    (has-hole k0 two back)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 polished)
    (painted l0 red)
    (has-hole l0 three back)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 polished)
    (painted m0 red)
    (has-hole m0 two back)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 polished)
    (painted n0 yellow)
    (has-hole n0 one front)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 smooth)
    (painted o0 blue)
    (has-hole o0 two back)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 smooth)
    (painted q0 red)
    (has-hole q0 three front)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 polished)
    (painted p0 yellow)
    (has-hole p0 one back)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 rough)
    (painted r0 blue)
    (has-hole r0 two front)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 smooth)
    (painted s0 black)
    (has-hole s0 three front)
    (temperature s0 cold)
    (shape u0 circular)
    (surface-condition u0 smooth)
    (painted u0 yellow)
    (has-hole u0 three back)
    (temperature u0 cold)
    (shape v0 circular)
    (surface-condition v0 smooth)
    (painted v0 yellow)
    (has-hole v0 two front)
    (temperature v0 cold)
    (shape w0 cylindrical)
    (surface-condition w0 polished)
    (painted w0 red)
    (has-hole w0 two back)
    (temperature w0 cold)
    (shape z0 oblong)
    (surface-condition z0 rough)
    (painted z0 black)
    (has-hole z0 one front)
    (temperature z0 cold)
    (shape a1 oblong)
    (surface-condition a1 smooth)
    (painted a1 yellow)
    (has-hole a1 two back)
    (temperature a1 cold)
    (shape b1 oblong)
    (surface-condition b1 rough)
    (painted b1 yellow)
    (has-hole b1 one back)
    (temperature b1 cold)
    (shape c1 oblong)
    (surface-condition c1 rough)
    (painted c1 black)
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
    (surface-condition h0 rough)
    (surface-condition d0 rough)
    (painted d0 blue)
    (shape k0 cylindrical)
    (painted r0 yellow)
    (shape s0 cylindrical)
    (surface-condition l0 rough)
    (surface-condition c1 polished)
    (surface-condition j0 polished)
    (painted p0 black)
    (surface-condition w0 smooth)
    (surface-condition e0 polished)
    (painted e0 black)
    (shape j0 cylindrical)
    (shape m0 cylindrical)
    (surface-condition u0 polished)
    (painted o0 black)
    (painted b1 red)
    (painted i0 black)
    (shape a0 cylindrical)
    (surface-condition i0 rough)
    (painted l0 blue)
    (painted c0 yellow)
    (surface-condition q0 polished)
    (shape u0 cylindrical)
    (shape e0 cylindrical)
)))
