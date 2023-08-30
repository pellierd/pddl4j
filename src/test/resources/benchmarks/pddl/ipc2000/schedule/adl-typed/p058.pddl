(define (problem schedule-21-0)
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
    (shape a0 circular)
    (surface-condition a0 polished)
    (painted a0 black)
    (has-hole a0 two back)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 smooth)
    (painted b0 red)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 rough)
    (painted c0 yellow)
    (has-hole c0 one front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 rough)
    (painted d0 blue)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 smooth)
    (painted e0 yellow)
    (has-hole e0 one front)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 polished)
    (painted f0 black)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 smooth)
    (painted g0 black)
    (has-hole g0 three front)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 smooth)
    (painted h0 red)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 rough)
    (painted i0 blue)
    (has-hole i0 three front)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 polished)
    (painted j0 black)
    (has-hole j0 one back)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 rough)
    (painted k0 blue)
    (has-hole k0 three back)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 smooth)
    (painted l0 black)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 polished)
    (painted m0 yellow)
    (has-hole m0 one back)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 smooth)
    (painted n0 black)
    (has-hole n0 three front)
    (temperature n0 cold)
    (shape o0 cylindrical)
    (surface-condition o0 smooth)
    (painted o0 red)
    (has-hole o0 one back)
    (temperature o0 cold)
    (shape q0 circular)
    (surface-condition q0 polished)
    (painted q0 red)
    (has-hole q0 two back)
    (temperature q0 cold)
    (shape p0 oblong)
    (surface-condition p0 polished)
    (painted p0 black)
    (has-hole p0 two back)
    (temperature p0 cold)
    (shape r0 circular)
    (surface-condition r0 rough)
    (painted r0 yellow)
    (has-hole r0 three back)
    (temperature r0 cold)
    (shape s0 cylindrical)
    (surface-condition s0 rough)
    (painted s0 black)
    (has-hole s0 two front)
    (temperature s0 cold)
    (shape u0 circular)
    (surface-condition u0 smooth)
    (painted u0 blue)
    (has-hole u0 two back)
    (temperature u0 cold)
    (shape v0 cylindrical)
    (surface-condition v0 rough)
    (painted v0 red)
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
    (painted q0 black)
    (surface-condition j0 smooth)
    (painted e0 blue)
    (painted k0 red)
    (painted p0 yellow)
    (painted v0 blue)
    (painted b0 blue)
    (painted d0 red)
    (surface-condition b0 rough)
    (surface-condition r0 polished)
    (shape r0 cylindrical)
    (shape i0 cylindrical)
    (painted n0 red)
    (shape f0 cylindrical)
    (surface-condition e0 rough)
    (shape e0 cylindrical)
    (painted c0 blue)
    (painted a0 red)
    (shape a0 cylindrical)
    (surface-condition u0 rough)
    (shape u0 cylindrical)
)))
