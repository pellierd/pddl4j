(define (problem schedule-28-0)
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
    (shape a0 oblong)
    (surface-condition a0 polished)
    (painted a0 red)
    (has-hole a0 three back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 polished)
    (painted b0 blue)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 smooth)
    (painted c0 black)
    (has-hole c0 two back)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 rough)
    (painted d0 blue)
    (has-hole d0 two front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 polished)
    (painted e0 blue)
    (has-hole e0 two front)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 polished)
    (painted f0 red)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 rough)
    (painted g0 yellow)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 smooth)
    (painted h0 blue)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 rough)
    (painted i0 red)
    (has-hole i0 one front)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 rough)
    (painted j0 black)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 rough)
    (painted k0 red)
    (has-hole k0 two front)
    (temperature k0 cold)
    (shape l0 cylindrical)
    (surface-condition l0 polished)
    (painted l0 blue)
    (has-hole l0 two back)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 polished)
    (painted m0 yellow)
    (has-hole m0 one back)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 polished)
    (painted n0 red)
    (has-hole n0 three back)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 polished)
    (painted o0 yellow)
    (has-hole o0 one front)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 rough)
    (painted q0 black)
    (has-hole q0 three back)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 rough)
    (painted p0 black)
    (has-hole p0 one back)
    (temperature p0 cold)
    (shape r0 circular)
    (surface-condition r0 smooth)
    (painted r0 red)
    (has-hole r0 two back)
    (temperature r0 cold)
    (shape s0 oblong)
    (surface-condition s0 rough)
    (painted s0 black)
    (has-hole s0 three front)
    (temperature s0 cold)
    (shape u0 circular)
    (surface-condition u0 rough)
    (painted u0 black)
    (has-hole u0 one front)
    (temperature u0 cold)
    (shape v0 cylindrical)
    (surface-condition v0 smooth)
    (painted v0 yellow)
    (has-hole v0 three front)
    (temperature v0 cold)
    (shape w0 circular)
    (surface-condition w0 rough)
    (painted w0 blue)
    (has-hole w0 one back)
    (temperature w0 cold)
    (shape z0 cylindrical)
    (surface-condition z0 rough)
    (painted z0 red)
    (has-hole z0 two front)
    (temperature z0 cold)
    (shape a1 oblong)
    (surface-condition a1 smooth)
    (painted a1 yellow)
    (has-hole a1 one back)
    (temperature a1 cold)
    (shape b1 circular)
    (surface-condition b1 polished)
    (painted b1 blue)
    (has-hole b1 one front)
    (temperature b1 cold)
    (shape c1 cylindrical)
    (surface-condition c1 rough)
    (painted c1 red)
    (has-hole c1 two back)
    (temperature c1 cold)
    (shape d1 cylindrical)
    (surface-condition d1 rough)
    (painted d1 red)
    (has-hole d1 three front)
    (temperature d1 cold)
    (shape e1 oblong)
    (surface-condition e1 polished)
    (painted e1 red)
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
    (shape b1 cylindrical)
    (surface-condition z0 smooth)
    (shape d0 cylindrical)
    (surface-condition m0 rough)
    (painted e0 black)
    (surface-condition k0 smooth)
    (surface-condition q0 polished)
    (shape b0 cylindrical)
    (painted e1 yellow)
    (shape a0 cylindrical)
    (surface-condition l0 smooth)
    (painted n0 black)
    (painted s0 yellow)
    (painted g0 red)
    (painted d0 red)
    (surface-condition d1 polished)
    (painted i0 black)
    (painted c1 yellow)
    (painted b0 yellow)
    (surface-condition b0 smooth)
    (painted r0 blue)
    (shape m0 cylindrical)
    (surface-condition p0 smooth)
    (surface-condition a0 rough)
    (shape r0 cylindrical)
    (painted d1 blue)
    (surface-condition a1 rough)
    (surface-condition w0 polished)
)))
