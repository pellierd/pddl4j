(define (problem schedule-22-0)
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
    (shape a0 cylindrical)
    (surface-condition a0 polished)
    (painted a0 red)
    (has-hole a0 two back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 polished)
    (painted b0 black)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 polished)
    (painted c0 blue)
    (has-hole c0 three back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 polished)
    (painted d0 red)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 polished)
    (painted e0 black)
    (has-hole e0 one back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 smooth)
    (painted f0 red)
    (has-hole f0 three front)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 rough)
    (painted g0 black)
    (has-hole g0 one front)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 yellow)
    (has-hole h0 one front)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 polished)
    (painted i0 yellow)
    (has-hole i0 three front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 polished)
    (painted j0 blue)
    (has-hole j0 two back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 smooth)
    (painted k0 blue)
    (has-hole k0 one back)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 polished)
    (painted l0 blue)
    (has-hole l0 two back)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 rough)
    (painted m0 red)
    (has-hole m0 two back)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 smooth)
    (painted n0 blue)
    (has-hole n0 one front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 polished)
    (painted o0 black)
    (has-hole o0 three front)
    (temperature o0 cold)
    (shape q0 circular)
    (surface-condition q0 rough)
    (painted q0 red)
    (has-hole q0 three back)
    (temperature q0 cold)
    (shape p0 circular)
    (surface-condition p0 polished)
    (painted p0 yellow)
    (has-hole p0 two front)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 polished)
    (painted r0 black)
    (has-hole r0 one front)
    (temperature r0 cold)
    (shape s0 cylindrical)
    (surface-condition s0 rough)
    (painted s0 black)
    (has-hole s0 three front)
    (temperature s0 cold)
    (shape u0 circular)
    (surface-condition u0 smooth)
    (painted u0 yellow)
    (has-hole u0 one front)
    (temperature u0 cold)
    (shape v0 oblong)
    (surface-condition v0 smooth)
    (painted v0 yellow)
    (has-hole v0 two front)
    (temperature v0 cold)
    (shape w0 cylindrical)
    (surface-condition w0 polished)
    (painted w0 yellow)
    (has-hole w0 three back)
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
    (shape l0 cylindrical)
    (painted q0 yellow)
    (shape p0 cylindrical)
    (surface-condition f0 rough)
    (shape o0 cylindrical)
    (painted v0 black)
    (painted k0 red)
    (surface-condition o0 rough)
    (surface-condition c0 rough)
    (shape r0 cylindrical)
    (painted b0 blue)
    (painted e0 red)
    (shape q0 cylindrical)
    (shape g0 cylindrical)
    (shape b0 cylindrical)
    (painted g0 blue)
    (surface-condition m0 smooth)
    (surface-condition i0 smooth)
    (painted l0 black)
    (shape v0 cylindrical)
    (shape e0 cylindrical)
    (shape u0 cylindrical)
)))
