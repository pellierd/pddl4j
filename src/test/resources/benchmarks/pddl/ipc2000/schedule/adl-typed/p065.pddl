(define (problem schedule-23-1)
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
    (shape a0 circular)
    (surface-condition a0 polished)
    (painted a0 black)
    (has-hole a0 two back)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 polished)
    (painted b0 red)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 rough)
    (painted c0 black)
    (has-hole c0 one front)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 polished)
    (painted d0 red)
    (has-hole d0 one front)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 smooth)
    (painted e0 black)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 polished)
    (painted f0 yellow)
    (has-hole f0 one front)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 polished)
    (painted g0 yellow)
    (has-hole g0 one front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 rough)
    (painted h0 blue)
    (has-hole h0 three back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 rough)
    (painted i0 red)
    (has-hole i0 three front)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 rough)
    (painted j0 black)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 polished)
    (painted k0 red)
    (has-hole k0 one front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 smooth)
    (painted l0 blue)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 rough)
    (painted m0 black)
    (has-hole m0 two front)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 smooth)
    (painted n0 yellow)
    (has-hole n0 three front)
    (temperature n0 cold)
    (shape o0 cylindrical)
    (surface-condition o0 polished)
    (painted o0 black)
    (has-hole o0 one front)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 polished)
    (painted q0 red)
    (has-hole q0 two front)
    (temperature q0 cold)
    (shape p0 circular)
    (surface-condition p0 rough)
    (painted p0 yellow)
    (has-hole p0 two front)
    (temperature p0 cold)
    (shape r0 circular)
    (surface-condition r0 rough)
    (painted r0 red)
    (has-hole r0 two front)
    (temperature r0 cold)
    (shape s0 oblong)
    (surface-condition s0 rough)
    (painted s0 yellow)
    (has-hole s0 three front)
    (temperature s0 cold)
    (shape u0 oblong)
    (surface-condition u0 smooth)
    (painted u0 black)
    (has-hole u0 three back)
    (temperature u0 cold)
    (shape v0 cylindrical)
    (surface-condition v0 rough)
    (painted v0 blue)
    (has-hole v0 one front)
    (temperature v0 cold)
    (shape w0 cylindrical)
    (surface-condition w0 polished)
    (painted w0 black)
    (has-hole w0 three front)
    (temperature w0 cold)
    (shape z0 oblong)
    (surface-condition z0 polished)
    (painted z0 red)
    (has-hole z0 two back)
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
    (painted b0 black)
    (surface-condition m0 polished)
    (shape u0 cylindrical)
    (painted c0 yellow)
    (shape f0 cylindrical)
    (surface-condition e0 polished)
    (shape s0 cylindrical)
    (shape c0 cylindrical)
    (surface-condition c0 smooth)
    (surface-condition b0 smooth)
    (painted v0 black)
    (painted s0 red)
    (surface-condition r0 smooth)
    (painted n0 blue)
    (surface-condition v0 smooth)
    (painted l0 black)
    (shape m0 cylindrical)
    (painted e0 yellow)
    (shape b0 cylindrical)
    (surface-condition h0 smooth)
    (shape l0 cylindrical)
    (painted z0 blue)
    (surface-condition k0 smooth)
)))
