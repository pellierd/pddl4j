(define (problem schedule-21-2)
(:domain schedule)
(:objects
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
    (painted a0 blue)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 rough)
    (painted b0 yellow)
    (has-hole b0 three front)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 polished)
    (painted c0 red)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 polished)
    (painted d0 yellow)
    (has-hole d0 three front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 smooth)
    (painted e0 blue)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 rough)
    (painted f0 blue)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 polished)
    (painted g0 yellow)
    (has-hole g0 two back)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 smooth)
    (painted h0 red)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 smooth)
    (painted i0 red)
    (has-hole i0 three front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 polished)
    (painted j0 red)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 rough)
    (painted k0 blue)
    (has-hole k0 one front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 rough)
    (painted l0 yellow)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 rough)
    (painted m0 red)
    (has-hole m0 three back)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 polished)
    (painted n0 yellow)
    (has-hole n0 two front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 smooth)
    (painted o0 blue)
    (has-hole o0 one front)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 polished)
    (painted q0 blue)
    (has-hole q0 three back)
    (temperature q0 cold)
    (shape p0 circular)
    (surface-condition p0 polished)
    (painted p0 yellow)
    (has-hole p0 one back)
    (temperature p0 cold)
    (shape r0 cylindrical)
    (surface-condition r0 smooth)
    (painted r0 red)
    (has-hole r0 two front)
    (temperature r0 cold)
    (shape s0 oblong)
    (surface-condition s0 rough)
    (painted s0 black)
    (has-hole s0 one back)
    (temperature s0 cold)
    (shape u0 circular)
    (surface-condition u0 rough)
    (painted u0 red)
    (has-hole u0 two back)
    (temperature u0 cold)
    (shape v0 cylindrical)
    (surface-condition v0 rough)
    (painted v0 blue)
    (has-hole v0 one back)
    (temperature v0 cold)
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
    (surface-condition l0 smooth)
    (painted s0 blue)
    (painted l0 red)
    (surface-condition n0 smooth)
    (painted g0 blue)
    (shape q0 cylindrical)
    (painted k0 black)
    (shape u0 cylindrical)
    (shape g0 cylindrical)
    (surface-condition o0 rough)
    (surface-condition v0 polished)
    (painted b0 black)
    (shape j0 cylindrical)
    (surface-condition k0 smooth)
    (surface-condition e0 rough)
    (surface-condition g0 rough)
    (surface-condition u0 polished)
    (painted c0 yellow)
    (shape i0 cylindrical)
    (shape l0 cylindrical)
    (painted j0 black)
)))
