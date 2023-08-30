(define (problem schedule-24-2)
(:domain schedule)
(:objects
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
    (has-hole a0 two back)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 rough)
    (painted b0 yellow)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 polished)
    (painted c0 blue)
    (has-hole c0 two front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 rough)
    (painted d0 yellow)
    (has-hole d0 two front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 rough)
    (painted e0 black)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 polished)
    (painted f0 yellow)
    (has-hole f0 one back)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 rough)
    (painted g0 red)
    (has-hole g0 one front)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 smooth)
    (painted h0 blue)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 smooth)
    (painted i0 blue)
    (has-hole i0 three back)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 rough)
    (painted j0 yellow)
    (has-hole j0 two front)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 rough)
    (painted k0 black)
    (has-hole k0 one back)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 rough)
    (painted l0 yellow)
    (has-hole l0 two front)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 smooth)
    (painted m0 yellow)
    (has-hole m0 three back)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 polished)
    (painted n0 yellow)
    (has-hole n0 two front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 smooth)
    (painted o0 blue)
    (has-hole o0 two front)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 smooth)
    (painted q0 blue)
    (has-hole q0 two front)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 rough)
    (painted p0 black)
    (has-hole p0 two front)
    (temperature p0 cold)
    (shape r0 circular)
    (surface-condition r0 polished)
    (painted r0 black)
    (has-hole r0 three back)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 smooth)
    (painted s0 yellow)
    (has-hole s0 two front)
    (temperature s0 cold)
    (shape u0 cylindrical)
    (surface-condition u0 rough)
    (painted u0 black)
    (has-hole u0 two front)
    (temperature u0 cold)
    (shape v0 oblong)
    (surface-condition v0 smooth)
    (painted v0 black)
    (has-hole v0 one front)
    (temperature v0 cold)
    (shape w0 circular)
    (surface-condition w0 rough)
    (painted w0 red)
    (has-hole w0 one back)
    (temperature w0 cold)
    (shape z0 oblong)
    (surface-condition z0 smooth)
    (painted z0 red)
    (has-hole z0 two back)
    (temperature z0 cold)
    (shape a1 circular)
    (surface-condition a1 polished)
    (painted a1 red)
    (has-hole a1 one front)
    (temperature a1 cold)
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
    (painted m0 red)
    (painted o0 black)
    (shape w0 cylindrical)
    (shape d0 cylindrical)
    (surface-condition p0 polished)
    (surface-condition j0 smooth)
    (painted i0 black)
    (surface-condition e0 smooth)
    (surface-condition z0 polished)
    (shape s0 cylindrical)
    (painted s0 red)
    (surface-condition u0 smooth)
    (surface-condition a1 rough)
    (painted z0 black)
    (surface-condition m0 rough)
    (surface-condition k0 smooth)
    (painted n0 blue)
    (painted f0 black)
    (painted p0 blue)
    (shape f0 cylindrical)
    (shape j0 cylindrical)
    (surface-condition g0 smooth)
    (surface-condition d0 smooth)
    (surface-condition s0 rough)
)))
