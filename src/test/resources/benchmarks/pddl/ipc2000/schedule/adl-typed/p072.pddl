(define (problem schedule-25-2)
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
    (surface-condition a0 smooth)
    (painted a0 red)
    (has-hole a0 one back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 polished)
    (painted b0 black)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 rough)
    (painted c0 black)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 polished)
    (painted d0 yellow)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 rough)
    (painted e0 black)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 rough)
    (painted f0 blue)
    (has-hole f0 two front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 smooth)
    (painted g0 yellow)
    (has-hole g0 one back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 red)
    (has-hole h0 one back)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 polished)
    (painted i0 blue)
    (has-hole i0 two back)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 polished)
    (painted j0 yellow)
    (has-hole j0 three front)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 smooth)
    (painted k0 blue)
    (has-hole k0 two front)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 rough)
    (painted l0 blue)
    (has-hole l0 two back)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 polished)
    (painted m0 blue)
    (has-hole m0 one front)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 polished)
    (painted n0 yellow)
    (has-hole n0 one front)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 polished)
    (painted o0 red)
    (has-hole o0 two back)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 rough)
    (painted q0 blue)
    (has-hole q0 three front)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 smooth)
    (painted p0 red)
    (has-hole p0 one front)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 smooth)
    (painted r0 red)
    (has-hole r0 two back)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 polished)
    (painted s0 red)
    (has-hole s0 three back)
    (temperature s0 cold)
    (shape u0 cylindrical)
    (surface-condition u0 rough)
    (painted u0 red)
    (has-hole u0 three front)
    (temperature u0 cold)
    (shape v0 cylindrical)
    (surface-condition v0 polished)
    (painted v0 yellow)
    (has-hole v0 one front)
    (temperature v0 cold)
    (shape w0 oblong)
    (surface-condition w0 rough)
    (painted w0 red)
    (has-hole w0 two front)
    (temperature w0 cold)
    (shape z0 circular)
    (surface-condition z0 rough)
    (painted z0 yellow)
    (has-hole z0 one back)
    (temperature z0 cold)
    (shape a1 cylindrical)
    (surface-condition a1 smooth)
    (painted a1 red)
    (has-hole a1 three front)
    (temperature a1 cold)
    (shape b1 cylindrical)
    (surface-condition b1 rough)
    (painted b1 yellow)
    (has-hole b1 one front)
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
    (painted e0 yellow)
    (shape o0 cylindrical)
    (shape b0 cylindrical)
    (surface-condition g0 rough)
    (painted j0 black)
    (painted l0 yellow)
    (painted r0 black)
    (shape l0 cylindrical)
    (surface-condition a0 polished)
    (surface-condition d0 smooth)
    (painted b1 black)
    (shape i0 cylindrical)
    (surface-condition s0 rough)
    (shape m0 cylindrical)
    (painted w0 yellow)
    (surface-condition n0 rough)
    (painted k0 yellow)
    (painted o0 black)
    (surface-condition v0 smooth)
    (surface-condition b1 polished)
    (surface-condition j0 rough)
    (shape s0 cylindrical)
    (surface-condition o0 rough)
    (surface-condition a1 polished)
    (painted s0 black)
)))
