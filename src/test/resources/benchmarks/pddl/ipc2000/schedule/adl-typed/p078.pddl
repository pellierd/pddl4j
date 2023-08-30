(define (problem schedule-27-2)
(:domain schedule)
(:objects
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
    (surface-condition a0 smooth)
    (painted a0 black)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 polished)
    (painted b0 yellow)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 rough)
    (painted c0 blue)
    (has-hole c0 three back)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 smooth)
    (painted d0 black)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 smooth)
    (painted e0 yellow)
    (has-hole e0 one front)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 polished)
    (painted f0 red)
    (has-hole f0 one back)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 rough)
    (painted g0 yellow)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 rough)
    (painted h0 yellow)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 rough)
    (painted i0 black)
    (has-hole i0 two back)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 rough)
    (painted j0 red)
    (has-hole j0 two front)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 smooth)
    (painted k0 blue)
    (has-hole k0 three front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 rough)
    (painted l0 blue)
    (has-hole l0 one front)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 polished)
    (painted m0 black)
    (has-hole m0 two back)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 rough)
    (painted n0 blue)
    (has-hole n0 two front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 rough)
    (painted o0 blue)
    (has-hole o0 one front)
    (temperature o0 cold)
    (shape q0 circular)
    (surface-condition q0 smooth)
    (painted q0 yellow)
    (has-hole q0 three front)
    (temperature q0 cold)
    (shape p0 oblong)
    (surface-condition p0 smooth)
    (painted p0 black)
    (has-hole p0 one back)
    (temperature p0 cold)
    (shape r0 cylindrical)
    (surface-condition r0 smooth)
    (painted r0 yellow)
    (has-hole r0 one back)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 smooth)
    (painted s0 red)
    (has-hole s0 one front)
    (temperature s0 cold)
    (shape u0 cylindrical)
    (surface-condition u0 smooth)
    (painted u0 black)
    (has-hole u0 three back)
    (temperature u0 cold)
    (shape v0 circular)
    (surface-condition v0 polished)
    (painted v0 yellow)
    (has-hole v0 one front)
    (temperature v0 cold)
    (shape w0 oblong)
    (surface-condition w0 rough)
    (painted w0 black)
    (has-hole w0 two back)
    (temperature w0 cold)
    (shape z0 circular)
    (surface-condition z0 rough)
    (painted z0 black)
    (has-hole z0 one back)
    (temperature z0 cold)
    (shape a1 circular)
    (surface-condition a1 polished)
    (painted a1 black)
    (has-hole a1 two front)
    (temperature a1 cold)
    (shape b1 circular)
    (surface-condition b1 polished)
    (painted b1 blue)
    (has-hole b1 two front)
    (temperature b1 cold)
    (shape c1 oblong)
    (surface-condition c1 rough)
    (painted c1 black)
    (has-hole c1 three back)
    (temperature c1 cold)
    (shape d1 circular)
    (surface-condition d1 rough)
    (painted d1 red)
    (has-hole d1 three back)
    (temperature d1 cold)
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
    (shape b0 cylindrical)
    (surface-condition u0 polished)
    (surface-condition f0 rough)
    (painted j0 black)
    (surface-condition b0 smooth)
    (surface-condition r0 polished)
    (painted n0 black)
    (surface-condition h0 polished)
    (shape q0 cylindrical)
    (painted a1 blue)
    (painted e0 red)
    (shape z0 cylindrical)
    (shape a0 cylindrical)
    (surface-condition o0 polished)
    (surface-condition c0 smooth)
    (painted q0 black)
    (painted k0 black)
    (surface-condition z0 polished)
    (surface-condition a0 rough)
    (surface-condition d1 smooth)
    (surface-condition j0 smooth)
    (painted s0 yellow)
    (painted r0 black)
    (shape c1 cylindrical)
    (shape o0 cylindrical)
    (surface-condition n0 polished)
    (shape c0 cylindrical)
)))
