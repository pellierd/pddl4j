(define (problem schedule-24-1)
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
    (painted a0 yellow)
    (has-hole a0 three back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 polished)
    (painted b0 yellow)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 smooth)
    (painted c0 black)
    (has-hole c0 three back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 rough)
    (painted d0 red)
    (has-hole d0 three back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 rough)
    (painted e0 black)
    (has-hole e0 one back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 polished)
    (painted f0 black)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 rough)
    (painted g0 red)
    (has-hole g0 two front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 rough)
    (painted h0 blue)
    (has-hole h0 two front)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 smooth)
    (painted i0 yellow)
    (has-hole i0 three back)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 rough)
    (painted j0 blue)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 polished)
    (painted k0 yellow)
    (has-hole k0 two front)
    (temperature k0 cold)
    (shape l0 cylindrical)
    (surface-condition l0 smooth)
    (painted l0 black)
    (has-hole l0 one front)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 smooth)
    (painted m0 yellow)
    (has-hole m0 three back)
    (temperature m0 cold)
    (shape n0 oblong)
    (surface-condition n0 smooth)
    (painted n0 black)
    (has-hole n0 three back)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 rough)
    (painted o0 red)
    (has-hole o0 one front)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 polished)
    (painted q0 red)
    (has-hole q0 one back)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 smooth)
    (painted p0 yellow)
    (has-hole p0 two front)
    (temperature p0 cold)
    (shape r0 cylindrical)
    (surface-condition r0 rough)
    (painted r0 blue)
    (has-hole r0 one back)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 rough)
    (painted s0 black)
    (has-hole s0 three back)
    (temperature s0 cold)
    (shape u0 oblong)
    (surface-condition u0 smooth)
    (painted u0 blue)
    (has-hole u0 two front)
    (temperature u0 cold)
    (shape v0 oblong)
    (surface-condition v0 polished)
    (painted v0 red)
    (has-hole v0 three back)
    (temperature v0 cold)
    (shape w0 oblong)
    (surface-condition w0 polished)
    (painted w0 black)
    (has-hole w0 two front)
    (temperature w0 cold)
    (shape z0 cylindrical)
    (surface-condition z0 polished)
    (painted z0 red)
    (has-hole z0 one back)
    (temperature z0 cold)
    (shape a1 oblong)
    (surface-condition a1 smooth)
    (painted a1 red)
    (has-hole a1 two back)
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
    (painted g0 blue)
    (surface-condition n0 polished)
    (shape g0 cylindrical)
    (surface-condition g0 polished)
    (painted d0 black)
    (painted s0 red)
    (surface-condition b0 smooth)
    (surface-condition d0 smooth)
    (surface-condition l0 polished)
    (surface-condition o0 smooth)
    (painted n0 red)
    (surface-condition u0 polished)
    (painted u0 black)
    (surface-condition q0 rough)
    (surface-condition i0 rough)
    (surface-condition a0 polished)
    (shape a1 cylindrical)
    (painted z0 yellow)
    (painted j0 yellow)
    (painted b0 blue)
    (shape k0 cylindrical)
    (surface-condition h0 smooth)
    (surface-condition e0 polished)
    (painted o0 black)
)))
