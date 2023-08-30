(define (problem schedule-23-2)
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
    (surface-condition a0 polished)
    (painted a0 red)
    (has-hole a0 three back)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 polished)
    (painted b0 black)
    (has-hole b0 two front)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 rough)
    (painted c0 yellow)
    (has-hole c0 two back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 rough)
    (painted d0 blue)
    (has-hole d0 three back)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 rough)
    (painted e0 black)
    (has-hole e0 one back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 rough)
    (painted f0 red)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 rough)
    (painted g0 red)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 rough)
    (painted h0 yellow)
    (has-hole h0 three front)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 polished)
    (painted i0 yellow)
    (has-hole i0 two front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 rough)
    (painted j0 red)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 smooth)
    (painted k0 red)
    (has-hole k0 three back)
    (temperature k0 cold)
    (shape l0 cylindrical)
    (surface-condition l0 polished)
    (painted l0 yellow)
    (has-hole l0 three back)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 polished)
    (painted m0 blue)
    (has-hole m0 three front)
    (temperature m0 cold)
    (shape n0 oblong)
    (surface-condition n0 polished)
    (painted n0 red)
    (has-hole n0 three front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 smooth)
    (painted o0 yellow)
    (has-hole o0 two front)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 smooth)
    (painted q0 black)
    (has-hole q0 two back)
    (temperature q0 cold)
    (shape p0 circular)
    (surface-condition p0 rough)
    (painted p0 blue)
    (has-hole p0 one back)
    (temperature p0 cold)
    (shape r0 cylindrical)
    (surface-condition r0 smooth)
    (painted r0 black)
    (has-hole r0 one front)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 polished)
    (painted s0 yellow)
    (has-hole s0 three front)
    (temperature s0 cold)
    (shape u0 cylindrical)
    (surface-condition u0 smooth)
    (painted u0 yellow)
    (has-hole u0 two front)
    (temperature u0 cold)
    (shape v0 circular)
    (surface-condition v0 smooth)
    (painted v0 blue)
    (has-hole v0 two front)
    (temperature v0 cold)
    (shape w0 circular)
    (surface-condition w0 polished)
    (painted w0 blue)
    (has-hole w0 one front)
    (temperature w0 cold)
    (shape z0 circular)
    (surface-condition z0 rough)
    (painted z0 red)
    (has-hole z0 one back)
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
    (surface-condition l0 rough)
    (surface-condition v0 polished)
    (surface-condition b0 smooth)
    (painted v0 red)
    (surface-condition z0 polished)
    (painted d0 black)
    (painted g0 blue)
    (shape v0 cylindrical)
    (shape w0 cylindrical)
    (painted u0 blue)
    (surface-condition w0 smooth)
    (shape o0 cylindrical)
    (painted s0 blue)
    (shape s0 cylindrical)
    (shape e0 cylindrical)
    (surface-condition d0 smooth)
    (surface-condition s0 smooth)
    (surface-condition k0 rough)
    (shape m0 cylindrical)
    (shape n0 cylindrical)
    (painted w0 black)
    (shape h0 cylindrical)
    (surface-condition p0 smooth)
)))
