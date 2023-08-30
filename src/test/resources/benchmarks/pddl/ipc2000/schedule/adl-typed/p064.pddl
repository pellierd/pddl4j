(define (problem schedule-23-0)
(:domain schedule)
(:objects
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
    (has-hole a0 one back)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 smooth)
    (painted b0 black)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 rough)
    (painted c0 yellow)
    (has-hole c0 one front)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 rough)
    (painted d0 blue)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 polished)
    (painted e0 black)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 rough)
    (painted f0 red)
    (has-hole f0 one front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 polished)
    (painted g0 red)
    (has-hole g0 three front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 polished)
    (painted h0 black)
    (has-hole h0 one back)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 rough)
    (painted i0 yellow)
    (has-hole i0 two front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 rough)
    (painted j0 black)
    (has-hole j0 two back)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 rough)
    (painted k0 black)
    (has-hole k0 one back)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 polished)
    (painted l0 red)
    (has-hole l0 three back)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 polished)
    (painted m0 red)
    (has-hole m0 one front)
    (temperature m0 cold)
    (shape n0 oblong)
    (surface-condition n0 rough)
    (painted n0 black)
    (has-hole n0 three back)
    (temperature n0 cold)
    (shape o0 cylindrical)
    (surface-condition o0 polished)
    (painted o0 red)
    (has-hole o0 one front)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 rough)
    (painted q0 black)
    (has-hole q0 one front)
    (temperature q0 cold)
    (shape p0 circular)
    (surface-condition p0 polished)
    (painted p0 yellow)
    (has-hole p0 one back)
    (temperature p0 cold)
    (shape r0 cylindrical)
    (surface-condition r0 polished)
    (painted r0 yellow)
    (has-hole r0 two front)
    (temperature r0 cold)
    (shape s0 cylindrical)
    (surface-condition s0 polished)
    (painted s0 yellow)
    (has-hole s0 one back)
    (temperature s0 cold)
    (shape u0 oblong)
    (surface-condition u0 polished)
    (painted u0 blue)
    (has-hole u0 two back)
    (temperature u0 cold)
    (shape v0 cylindrical)
    (surface-condition v0 smooth)
    (painted v0 yellow)
    (has-hole v0 three back)
    (temperature v0 cold)
    (shape w0 oblong)
    (surface-condition w0 smooth)
    (painted w0 red)
    (has-hole w0 three front)
    (temperature w0 cold)
    (shape z0 cylindrical)
    (surface-condition z0 smooth)
    (painted z0 black)
    (has-hole z0 one front)
    (temperature z0 cold)
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
    (surface-condition w0 polished)
    (painted d0 red)
    (painted c0 red)
    (painted q0 red)
    (painted o0 black)
    (painted f0 yellow)
    (shape k0 cylindrical)
    (shape b0 cylindrical)
    (surface-condition u0 smooth)
    (surface-condition j0 smooth)
    (painted s0 black)
    (shape w0 cylindrical)
    (surface-condition k0 smooth)
    (shape n0 cylindrical)
    (painted u0 yellow)
    (surface-condition e0 rough)
    (painted m0 yellow)
    (painted v0 blue)
    (painted r0 blue)
    (painted i0 blue)
    (surface-condition n0 smooth)
    (shape m0 cylindrical)
    (surface-condition g0 rough)
)))
