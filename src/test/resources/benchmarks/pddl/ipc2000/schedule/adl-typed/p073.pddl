(define (problem schedule-26-0)
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
    (has-hole a0 two back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 rough)
    (painted b0 black)
    (has-hole b0 two front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 smooth)
    (painted c0 blue)
    (has-hole c0 two back)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 polished)
    (painted d0 black)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 smooth)
    (painted e0 blue)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 polished)
    (painted f0 yellow)
    (has-hole f0 two front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 polished)
    (painted g0 blue)
    (has-hole g0 two back)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 rough)
    (painted h0 black)
    (has-hole h0 two front)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 polished)
    (painted i0 black)
    (has-hole i0 one back)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 smooth)
    (painted j0 red)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 smooth)
    (painted k0 red)
    (has-hole k0 two front)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 smooth)
    (painted l0 red)
    (has-hole l0 two front)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 rough)
    (painted m0 blue)
    (has-hole m0 two front)
    (temperature m0 cold)
    (shape n0 oblong)
    (surface-condition n0 rough)
    (painted n0 blue)
    (has-hole n0 two front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 polished)
    (painted o0 red)
    (has-hole o0 two front)
    (temperature o0 cold)
    (shape q0 circular)
    (surface-condition q0 smooth)
    (painted q0 yellow)
    (has-hole q0 one back)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 smooth)
    (painted p0 blue)
    (has-hole p0 three front)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 smooth)
    (painted r0 black)
    (has-hole r0 three back)
    (temperature r0 cold)
    (shape s0 cylindrical)
    (surface-condition s0 rough)
    (painted s0 black)
    (has-hole s0 one front)
    (temperature s0 cold)
    (shape u0 circular)
    (surface-condition u0 smooth)
    (painted u0 blue)
    (has-hole u0 three back)
    (temperature u0 cold)
    (shape v0 circular)
    (surface-condition v0 polished)
    (painted v0 blue)
    (has-hole v0 two back)
    (temperature v0 cold)
    (shape w0 cylindrical)
    (surface-condition w0 polished)
    (painted w0 yellow)
    (has-hole w0 one back)
    (temperature w0 cold)
    (shape z0 oblong)
    (surface-condition z0 smooth)
    (painted z0 red)
    (has-hole z0 two front)
    (temperature z0 cold)
    (shape a1 oblong)
    (surface-condition a1 rough)
    (painted a1 red)
    (has-hole a1 one back)
    (temperature a1 cold)
    (shape b1 oblong)
    (surface-condition b1 rough)
    (painted b1 black)
    (has-hole b1 two back)
    (temperature b1 cold)
    (shape c1 circular)
    (surface-condition c1 rough)
    (painted c1 blue)
    (has-hole c1 one front)
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
    (shape c1 cylindrical)
    (surface-condition u0 polished)
    (surface-condition d0 rough)
    (surface-condition g0 smooth)
    (shape h0 cylindrical)
    (painted d0 blue)
    (surface-condition a0 polished)
    (shape n0 cylindrical)
    (painted g0 yellow)
    (painted v0 black)
    (painted c1 red)
    (surface-condition v0 smooth)
    (surface-condition f0 rough)
    (surface-condition k0 rough)
    (surface-condition a1 smooth)
    (shape z0 cylindrical)
    (surface-condition c0 rough)
    (painted f0 red)
    (surface-condition l0 rough)
    (painted o0 yellow)
    (painted r0 blue)
    (shape l0 cylindrical)
    (painted j0 yellow)
    (painted p0 black)
    (painted c0 yellow)
    (shape r0 cylindrical)
)))
