(define (problem schedule-22-1)
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
    (surface-condition a0 rough)
    (painted a0 red)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 smooth)
    (painted b0 red)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 smooth)
    (painted c0 yellow)
    (has-hole c0 three back)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 polished)
    (painted d0 yellow)
    (has-hole d0 one front)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 polished)
    (painted e0 black)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 smooth)
    (painted f0 red)
    (has-hole f0 one back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 rough)
    (painted g0 blue)
    (has-hole g0 one back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 rough)
    (painted h0 red)
    (has-hole h0 one front)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 polished)
    (painted i0 blue)
    (has-hole i0 three front)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 smooth)
    (painted j0 yellow)
    (has-hole j0 three front)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 rough)
    (painted k0 yellow)
    (has-hole k0 one back)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 rough)
    (painted l0 red)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 rough)
    (painted m0 black)
    (has-hole m0 three back)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 rough)
    (painted n0 red)
    (has-hole n0 one back)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 rough)
    (painted o0 red)
    (has-hole o0 three front)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 polished)
    (painted q0 black)
    (has-hole q0 one front)
    (temperature q0 cold)
    (shape p0 oblong)
    (surface-condition p0 polished)
    (painted p0 yellow)
    (has-hole p0 three front)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 polished)
    (painted r0 yellow)
    (has-hole r0 three back)
    (temperature r0 cold)
    (shape s0 circular)
    (surface-condition s0 polished)
    (painted s0 blue)
    (has-hole s0 two back)
    (temperature s0 cold)
    (shape u0 cylindrical)
    (surface-condition u0 rough)
    (painted u0 yellow)
    (has-hole u0 two front)
    (temperature u0 cold)
    (shape v0 cylindrical)
    (surface-condition v0 smooth)
    (painted v0 blue)
    (has-hole v0 three front)
    (temperature v0 cold)
    (shape w0 cylindrical)
    (surface-condition w0 smooth)
    (painted w0 black)
    (has-hole w0 three front)
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
    (shape m0 cylindrical)
    (painted f0 black)
    (surface-condition w0 polished)
    (surface-condition h0 smooth)
    (painted l0 black)
    (painted e0 yellow)
    (painted a0 black)
    (shape b0 cylindrical)
    (shape l0 cylindrical)
    (painted n0 black)
    (surface-condition g0 smooth)
    (painted p0 blue)
    (painted v0 yellow)
    (painted r0 black)
    (shape n0 cylindrical)
    (shape h0 cylindrical)
    (painted u0 black)
    (surface-condition m0 polished)
    (painted c0 red)
    (surface-condition o0 smooth)
    (shape d0 cylindrical)
    (shape k0 cylindrical)
)))
