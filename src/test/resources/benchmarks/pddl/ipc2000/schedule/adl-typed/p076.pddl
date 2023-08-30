(define (problem schedule-27-0)
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
    (shape a0 cylindrical)
    (surface-condition a0 rough)
    (painted a0 red)
    (has-hole a0 two front)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 rough)
    (painted b0 red)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 smooth)
    (painted c0 black)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 polished)
    (painted d0 yellow)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 polished)
    (painted e0 yellow)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 rough)
    (painted f0 yellow)
    (has-hole f0 three back)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 polished)
    (painted g0 black)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 smooth)
    (painted h0 red)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 rough)
    (painted i0 yellow)
    (has-hole i0 two back)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 smooth)
    (painted j0 yellow)
    (has-hole j0 three front)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 polished)
    (painted k0 blue)
    (has-hole k0 two front)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 rough)
    (painted l0 black)
    (has-hole l0 one back)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 smooth)
    (painted m0 blue)
    (has-hole m0 one front)
    (temperature m0 cold)
    (shape n0 oblong)
    (surface-condition n0 polished)
    (painted n0 red)
    (has-hole n0 one front)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 rough)
    (painted o0 black)
    (has-hole o0 three front)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 rough)
    (painted q0 blue)
    (has-hole q0 two front)
    (temperature q0 cold)
    (shape p0 oblong)
    (surface-condition p0 smooth)
    (painted p0 yellow)
    (has-hole p0 two back)
    (temperature p0 cold)
    (shape r0 circular)
    (surface-condition r0 smooth)
    (painted r0 yellow)
    (has-hole r0 two front)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 smooth)
    (painted s0 blue)
    (has-hole s0 three back)
    (temperature s0 cold)
    (shape u0 circular)
    (surface-condition u0 rough)
    (painted u0 yellow)
    (has-hole u0 one back)
    (temperature u0 cold)
    (shape v0 circular)
    (surface-condition v0 rough)
    (painted v0 black)
    (has-hole v0 two back)
    (temperature v0 cold)
    (shape w0 cylindrical)
    (surface-condition w0 polished)
    (painted w0 red)
    (has-hole w0 two front)
    (temperature w0 cold)
    (shape z0 cylindrical)
    (surface-condition z0 polished)
    (painted z0 red)
    (has-hole z0 three front)
    (temperature z0 cold)
    (shape a1 circular)
    (surface-condition a1 polished)
    (painted a1 red)
    (has-hole a1 two back)
    (temperature a1 cold)
    (shape b1 circular)
    (surface-condition b1 smooth)
    (painted b1 yellow)
    (has-hole b1 two front)
    (temperature b1 cold)
    (shape c1 oblong)
    (surface-condition c1 polished)
    (painted c1 red)
    (has-hole c1 two back)
    (temperature c1 cold)
    (shape d1 oblong)
    (surface-condition d1 polished)
    (painted d1 yellow)
    (has-hole d1 one back)
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
    (surface-condition c1 smooth)
    (painted s0 yellow)
    (surface-condition a0 polished)
    (surface-condition l0 polished)
    (painted z0 blue)
    (painted v0 yellow)
    (shape p0 cylindrical)
    (surface-condition b0 smooth)
    (shape a1 cylindrical)
    (painted a1 black)
    (painted f0 blue)
    (painted u0 black)
    (surface-condition n0 rough)
    (surface-condition k0 rough)
    (surface-condition p0 polished)
    (painted i0 blue)
    (surface-condition d0 smooth)
    (surface-condition e0 smooth)
    (surface-condition u0 smooth)
    (painted w0 black)
    (painted d1 red)
    (surface-condition j0 polished)
    (shape r0 cylindrical)
    (shape b1 cylindrical)
    (shape h0 cylindrical)
    (shape u0 cylindrical)
    (surface-condition o0 smooth)
)))
