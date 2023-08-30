(define (problem schedule-22-2)
(:domain schedule)
(:objects
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
    (surface-condition a0 smooth)
    (painted a0 blue)
    (has-hole a0 two front)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 smooth)
    (painted b0 black)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 smooth)
    (painted c0 black)
    (has-hole c0 one back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 rough)
    (painted d0 black)
    (has-hole d0 one front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 polished)
    (painted e0 yellow)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 rough)
    (painted f0 yellow)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 polished)
    (painted g0 red)
    (has-hole g0 one front)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 rough)
    (painted h0 black)
    (has-hole h0 three back)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 smooth)
    (painted i0 yellow)
    (has-hole i0 three front)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 polished)
    (painted j0 black)
    (has-hole j0 one front)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 polished)
    (painted k0 red)
    (has-hole k0 three front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 rough)
    (painted l0 red)
    (has-hole l0 one back)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 smooth)
    (painted m0 blue)
    (has-hole m0 one back)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 polished)
    (painted n0 blue)
    (has-hole n0 one front)
    (temperature n0 cold)
    (shape o0 cylindrical)
    (surface-condition o0 polished)
    (painted o0 yellow)
    (has-hole o0 two back)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 rough)
    (painted q0 yellow)
    (has-hole q0 two front)
    (temperature q0 cold)
    (shape p0 oblong)
    (surface-condition p0 smooth)
    (painted p0 yellow)
    (has-hole p0 three back)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 rough)
    (painted r0 yellow)
    (has-hole r0 two front)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 polished)
    (painted s0 yellow)
    (has-hole s0 three back)
    (temperature s0 cold)
    (shape u0 circular)
    (surface-condition u0 smooth)
    (painted u0 red)
    (has-hole u0 one front)
    (temperature u0 cold)
    (shape v0 circular)
    (surface-condition v0 polished)
    (painted v0 blue)
    (has-hole v0 three back)
    (temperature v0 cold)
    (shape w0 circular)
    (surface-condition w0 polished)
    (painted w0 yellow)
    (has-hole w0 two back)
    (temperature w0 cold)
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
    (surface-condition r0 polished)
    (painted r0 red)
    (shape h0 cylindrical)
    (shape a0 cylindrical)
    (surface-condition j0 smooth)
    (surface-condition c0 rough)
    (surface-condition k0 smooth)
    (shape q0 cylindrical)
    (surface-condition n0 smooth)
    (painted d0 yellow)
    (surface-condition f0 smooth)
    (shape s0 cylindrical)
    (surface-condition i0 polished)
    (surface-condition p0 polished)
    (shape e0 cylindrical)
    (painted p0 blue)
    (shape f0 cylindrical)
    (surface-condition a0 polished)
    (shape u0 cylindrical)
    (shape m0 cylindrical)
    (painted a0 red)
    (surface-condition u0 rough)
)))
