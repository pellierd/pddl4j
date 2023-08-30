(define (problem schedule-28-1)
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
    (shape a0 cylindrical)
    (surface-condition a0 polished)
    (painted a0 red)
    (has-hole a0 two front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 rough)
    (painted b0 black)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 smooth)
    (painted c0 red)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 polished)
    (painted d0 blue)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 smooth)
    (painted e0 red)
    (has-hole e0 two front)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 polished)
    (painted f0 yellow)
    (has-hole f0 one front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 rough)
    (painted g0 yellow)
    (has-hole g0 three front)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 polished)
    (painted h0 black)
    (has-hole h0 three back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 smooth)
    (painted i0 yellow)
    (has-hole i0 one front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 rough)
    (painted j0 yellow)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 rough)
    (painted k0 black)
    (has-hole k0 three front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 smooth)
    (painted l0 black)
    (has-hole l0 one back)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 rough)
    (painted m0 yellow)
    (has-hole m0 one back)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 polished)
    (painted n0 red)
    (has-hole n0 three back)
    (temperature n0 cold)
    (shape o0 cylindrical)
    (surface-condition o0 polished)
    (painted o0 blue)
    (has-hole o0 one front)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 polished)
    (painted q0 red)
    (has-hole q0 three back)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 polished)
    (painted p0 blue)
    (has-hole p0 two back)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 polished)
    (painted r0 red)
    (has-hole r0 one back)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 smooth)
    (painted s0 blue)
    (has-hole s0 two front)
    (temperature s0 cold)
    (shape u0 cylindrical)
    (surface-condition u0 polished)
    (painted u0 blue)
    (has-hole u0 one front)
    (temperature u0 cold)
    (shape v0 cylindrical)
    (surface-condition v0 rough)
    (painted v0 black)
    (has-hole v0 two back)
    (temperature v0 cold)
    (shape w0 oblong)
    (surface-condition w0 smooth)
    (painted w0 red)
    (has-hole w0 three front)
    (temperature w0 cold)
    (shape z0 cylindrical)
    (surface-condition z0 smooth)
    (painted z0 yellow)
    (has-hole z0 one back)
    (temperature z0 cold)
    (shape a1 cylindrical)
    (surface-condition a1 polished)
    (painted a1 red)
    (has-hole a1 one back)
    (temperature a1 cold)
    (shape b1 cylindrical)
    (surface-condition b1 rough)
    (painted b1 black)
    (has-hole b1 three back)
    (temperature b1 cold)
    (shape c1 circular)
    (surface-condition c1 polished)
    (painted c1 red)
    (has-hole c1 one front)
    (temperature c1 cold)
    (shape d1 circular)
    (surface-condition d1 polished)
    (painted d1 red)
    (has-hole d1 one front)
    (temperature d1 cold)
    (shape e1 oblong)
    (surface-condition e1 smooth)
    (painted e1 yellow)
    (has-hole e1 one back)
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
    (painted f0 red)
    (surface-condition u0 rough)
    (shape b0 cylindrical)
    (painted a0 blue)
    (surface-condition e0 polished)
    (shape k0 cylindrical)
    (painted z0 blue)
    (painted a1 blue)
    (painted i0 black)
    (painted v0 red)
    (surface-condition d1 rough)
    (surface-condition c1 smooth)
    (painted c1 black)
    (surface-condition d0 smooth)
    (shape h0 cylindrical)
    (surface-condition q0 smooth)
    (surface-condition r0 rough)
    (surface-condition i0 polished)
    (surface-condition f0 rough)
    (surface-condition s0 polished)
    (painted n0 yellow)
    (painted u0 yellow)
    (surface-condition a1 rough)
    (surface-condition m0 smooth)
    (surface-condition h0 rough)
    (surface-condition a0 smooth)
    (painted j0 red)
    (surface-condition j0 polished)
)))
