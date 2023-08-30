(define (problem schedule-27-1)
(:domain schedule)
(:objects
    d1
    c1
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
    (shape a0 oblong)
    (surface-condition a0 polished)
    (painted a0 yellow)
    (has-hole a0 two back)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 polished)
    (painted b0 yellow)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 polished)
    (painted c0 blue)
    (has-hole c0 two front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 polished)
    (painted d0 yellow)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 rough)
    (painted e0 red)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 rough)
    (painted f0 black)
    (has-hole f0 three front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 polished)
    (painted g0 blue)
    (has-hole g0 two back)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 rough)
    (painted h0 yellow)
    (has-hole h0 three back)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 rough)
    (painted i0 red)
    (has-hole i0 two back)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 rough)
    (painted j0 red)
    (has-hole j0 two back)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 rough)
    (painted k0 black)
    (has-hole k0 two front)
    (temperature k0 cold)
    (shape l0 cylindrical)
    (surface-condition l0 rough)
    (painted l0 black)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 rough)
    (painted m0 red)
    (has-hole m0 two front)
    (temperature m0 cold)
    (shape n0 oblong)
    (surface-condition n0 rough)
    (painted n0 blue)
    (has-hole n0 two back)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 smooth)
    (painted o0 red)
    (has-hole o0 one back)
    (temperature o0 cold)
    (shape q0 circular)
    (surface-condition q0 smooth)
    (painted q0 red)
    (has-hole q0 three back)
    (temperature q0 cold)
    (shape p0 oblong)
    (surface-condition p0 polished)
    (painted p0 blue)
    (has-hole p0 two back)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 rough)
    (painted r0 yellow)
    (has-hole r0 three front)
    (temperature r0 cold)
    (shape s0 cylindrical)
    (surface-condition s0 polished)
    (painted s0 red)
    (has-hole s0 three back)
    (temperature s0 cold)
    (shape u0 cylindrical)
    (surface-condition u0 polished)
    (painted u0 yellow)
    (has-hole u0 two back)
    (temperature u0 cold)
    (shape v0 oblong)
    (surface-condition v0 polished)
    (painted v0 yellow)
    (has-hole v0 two back)
    (temperature v0 cold)
    (shape w0 cylindrical)
    (surface-condition w0 smooth)
    (painted w0 black)
    (has-hole w0 three front)
    (temperature w0 cold)
    (shape z0 cylindrical)
    (surface-condition z0 polished)
    (painted z0 yellow)
    (has-hole z0 two front)
    (temperature z0 cold)
    (shape a1 cylindrical)
    (surface-condition a1 polished)
    (painted a1 red)
    (has-hole a1 one back)
    (temperature a1 cold)
    (shape b1 circular)
    (surface-condition b1 smooth)
    (painted b1 yellow)
    (has-hole b1 one back)
    (temperature b1 cold)
    (shape c1 cylindrical)
    (surface-condition c1 smooth)
    (painted c1 black)
    (has-hole c1 one front)
    (temperature c1 cold)
    (shape d1 oblong)
    (surface-condition d1 rough)
    (painted d1 yellow)
    (has-hole d1 one front)
    (temperature d1 cold)
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
    (surface-condition c0 rough)
    (shape i0 cylindrical)
    (painted b0 black)
    (surface-condition u0 smooth)
    (surface-condition j0 polished)
    (surface-condition d1 smooth)
    (painted i0 blue)
    (shape a0 cylindrical)
    (surface-condition o0 polished)
    (shape o0 cylindrical)
    (painted a0 black)
    (surface-condition f0 smooth)
    (painted o0 blue)
    (surface-condition n0 polished)
    (painted l0 blue)
    (painted a1 yellow)
    (painted n0 black)
    (painted d0 red)
    (shape d1 cylindrical)
    (surface-condition c1 rough)
    (painted d1 black)
    (shape n0 cylindrical)
    (shape p0 cylindrical)
    (painted s0 yellow)
    (surface-condition g0 smooth)
    (shape r0 cylindrical)
    (surface-condition q0 polished)
)))
