(define (problem schedule-24-0)
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
    (shape a0 circular)
    (surface-condition a0 polished)
    (painted a0 yellow)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 rough)
    (painted b0 red)
    (has-hole b0 two front)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 smooth)
    (painted c0 black)
    (has-hole c0 three back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 rough)
    (painted d0 blue)
    (has-hole d0 one front)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 rough)
    (painted e0 black)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 rough)
    (painted f0 black)
    (has-hole f0 three front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 rough)
    (painted g0 yellow)
    (has-hole g0 two front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 polished)
    (painted h0 red)
    (has-hole h0 one back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 rough)
    (painted i0 yellow)
    (has-hole i0 three front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 polished)
    (painted j0 blue)
    (has-hole j0 one back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 smooth)
    (painted k0 red)
    (has-hole k0 three back)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 smooth)
    (painted l0 red)
    (has-hole l0 three back)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 rough)
    (painted m0 black)
    (has-hole m0 one back)
    (temperature m0 cold)
    (shape n0 oblong)
    (surface-condition n0 smooth)
    (painted n0 red)
    (has-hole n0 one back)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 smooth)
    (painted o0 black)
    (has-hole o0 three back)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 smooth)
    (painted q0 yellow)
    (has-hole q0 three back)
    (temperature q0 cold)
    (shape p0 circular)
    (surface-condition p0 smooth)
    (painted p0 yellow)
    (has-hole p0 two front)
    (temperature p0 cold)
    (shape r0 cylindrical)
    (surface-condition r0 polished)
    (painted r0 yellow)
    (has-hole r0 one front)
    (temperature r0 cold)
    (shape s0 oblong)
    (surface-condition s0 polished)
    (painted s0 black)
    (has-hole s0 one front)
    (temperature s0 cold)
    (shape u0 cylindrical)
    (surface-condition u0 polished)
    (painted u0 blue)
    (has-hole u0 one front)
    (temperature u0 cold)
    (shape v0 circular)
    (surface-condition v0 rough)
    (painted v0 red)
    (has-hole v0 one front)
    (temperature v0 cold)
    (shape w0 circular)
    (surface-condition w0 smooth)
    (painted w0 black)
    (has-hole w0 two front)
    (temperature w0 cold)
    (shape z0 cylindrical)
    (surface-condition z0 polished)
    (painted z0 yellow)
    (has-hole z0 one front)
    (temperature z0 cold)
    (shape a1 circular)
    (surface-condition a1 rough)
    (painted a1 blue)
    (has-hole a1 two front)
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
    (shape a0 cylindrical)
    (shape f0 cylindrical)
    (shape j0 cylindrical)
    (surface-condition z0 smooth)
    (surface-condition r0 rough)
    (painted o0 yellow)
    (shape k0 cylindrical)
    (surface-condition m0 smooth)
    (shape w0 cylindrical)
    (surface-condition v0 polished)
    (shape d0 cylindrical)
    (painted m0 red)
    (painted p0 blue)
    (painted r0 black)
    (surface-condition o0 polished)
    (painted j0 red)
    (surface-condition a0 smooth)
    (painted g0 black)
    (surface-condition c0 rough)
    (painted d0 yellow)
    (shape v0 cylindrical)
    (painted c0 blue)
    (painted l0 black)
    (shape a1 cylindrical)
)))
