(define (problem schedule-25-0)
(:domain schedule)
(:objects
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
    (painted a0 black)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 polished)
    (painted b0 black)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 smooth)
    (painted c0 yellow)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 rough)
    (painted d0 red)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 smooth)
    (painted e0 yellow)
    (has-hole e0 three front)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 smooth)
    (painted f0 blue)
    (has-hole f0 one back)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 polished)
    (painted g0 blue)
    (has-hole g0 one back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 yellow)
    (has-hole h0 three front)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 polished)
    (painted i0 blue)
    (has-hole i0 three front)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 polished)
    (painted j0 red)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 rough)
    (painted k0 black)
    (has-hole k0 one front)
    (temperature k0 cold)
    (shape l0 cylindrical)
    (surface-condition l0 rough)
    (painted l0 red)
    (has-hole l0 one front)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 rough)
    (painted m0 blue)
    (has-hole m0 two front)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 rough)
    (painted n0 red)
    (has-hole n0 one back)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 smooth)
    (painted o0 red)
    (has-hole o0 three back)
    (temperature o0 cold)
    (shape q0 circular)
    (surface-condition q0 rough)
    (painted q0 red)
    (has-hole q0 three front)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 rough)
    (painted p0 yellow)
    (has-hole p0 one front)
    (temperature p0 cold)
    (shape r0 cylindrical)
    (surface-condition r0 polished)
    (painted r0 blue)
    (has-hole r0 one back)
    (temperature r0 cold)
    (shape s0 oblong)
    (surface-condition s0 rough)
    (painted s0 yellow)
    (has-hole s0 one front)
    (temperature s0 cold)
    (shape u0 oblong)
    (surface-condition u0 smooth)
    (painted u0 red)
    (has-hole u0 three front)
    (temperature u0 cold)
    (shape v0 cylindrical)
    (surface-condition v0 polished)
    (painted v0 black)
    (has-hole v0 three back)
    (temperature v0 cold)
    (shape w0 cylindrical)
    (surface-condition w0 polished)
    (painted w0 red)
    (has-hole w0 two front)
    (temperature w0 cold)
    (shape z0 cylindrical)
    (surface-condition z0 rough)
    (painted z0 black)
    (has-hole z0 one back)
    (temperature z0 cold)
    (shape a1 cylindrical)
    (surface-condition a1 smooth)
    (painted a1 black)
    (has-hole a1 two front)
    (temperature a1 cold)
    (shape b1 oblong)
    (surface-condition b1 rough)
    (painted b1 red)
    (has-hole b1 two front)
    (temperature b1 cold)
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
    (shape d0 cylindrical)
    (surface-condition a0 smooth)
    (surface-condition w0 rough)
    (surface-condition g0 rough)
    (surface-condition b0 rough)
    (surface-condition m0 polished)
    (painted a1 blue)
    (surface-condition o0 rough)
    (surface-condition v0 rough)
    (painted a0 blue)
    (painted r0 black)
    (shape b1 cylindrical)
    (painted h0 black)
    (painted q0 yellow)
    (shape c0 cylindrical)
    (painted e0 red)
    (surface-condition s0 smooth)
    (painted v0 yellow)
    (surface-condition z0 smooth)
    (shape o0 cylindrical)
    (surface-condition e0 polished)
    (surface-condition n0 smooth)
    (painted i0 red)
    (painted f0 red)
    (shape i0 cylindrical)
)))
