(define (problem schedule-21-1)
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
    (surface-condition a0 rough)
    (painted a0 red)
    (has-hole a0 three front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 polished)
    (painted b0 black)
    (has-hole b0 three front)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 polished)
    (painted c0 blue)
    (has-hole c0 two front)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 rough)
    (painted d0 black)
    (has-hole d0 two front)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 smooth)
    (painted e0 blue)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 polished)
    (painted f0 black)
    (has-hole f0 three front)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 rough)
    (painted g0 black)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 rough)
    (painted h0 black)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 rough)
    (painted i0 blue)
    (has-hole i0 two front)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 polished)
    (painted j0 yellow)
    (has-hole j0 one front)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 polished)
    (painted k0 black)
    (has-hole k0 three back)
    (temperature k0 cold)
    (shape l0 cylindrical)
    (surface-condition l0 polished)
    (painted l0 red)
    (has-hole l0 one back)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 polished)
    (painted m0 red)
    (has-hole m0 three back)
    (temperature m0 cold)
    (shape n0 oblong)
    (surface-condition n0 smooth)
    (painted n0 yellow)
    (has-hole n0 one back)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 rough)
    (painted o0 red)
    (has-hole o0 three front)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 smooth)
    (painted q0 blue)
    (has-hole q0 one front)
    (temperature q0 cold)
    (shape p0 oblong)
    (surface-condition p0 polished)
    (painted p0 yellow)
    (has-hole p0 one back)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 rough)
    (painted r0 red)
    (has-hole r0 one back)
    (temperature r0 cold)
    (shape s0 oblong)
    (surface-condition s0 smooth)
    (painted s0 yellow)
    (has-hole s0 one back)
    (temperature s0 cold)
    (shape u0 oblong)
    (surface-condition u0 polished)
    (painted u0 blue)
    (has-hole u0 two back)
    (temperature u0 cold)
    (shape v0 cylindrical)
    (surface-condition v0 smooth)
    (painted v0 blue)
    (has-hole v0 one front)
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
    (surface-condition d0 smooth)
    (shape j0 cylindrical)
    (shape h0 cylindrical)
    (painted g0 blue)
    (surface-condition j0 smooth)
    (surface-condition e0 polished)
    (shape b0 cylindrical)
    (surface-condition k0 rough)
    (surface-condition f0 smooth)
    (surface-condition m0 smooth)
    (shape q0 cylindrical)
    (painted v0 black)
    (painted u0 red)
    (painted c0 yellow)
    (painted o0 black)
    (surface-condition b0 rough)
    (surface-condition h0 smooth)
    (shape c0 cylindrical)
    (surface-condition r0 smooth)
    (painted i0 yellow)
)))
