(define (problem schedule-20-1)
(:domain schedule)
(:objects
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
    (surface-condition a0 smooth)
    (painted a0 red)
    (has-hole a0 three back)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 smooth)
    (painted b0 red)
    (has-hole b0 two front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 rough)
    (painted c0 yellow)
    (has-hole c0 one back)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 polished)
    (painted d0 blue)
    (has-hole d0 two front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 rough)
    (painted e0 yellow)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 smooth)
    (painted f0 yellow)
    (has-hole f0 two front)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 polished)
    (painted g0 blue)
    (has-hole g0 one front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 smooth)
    (painted h0 red)
    (has-hole h0 two front)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 smooth)
    (painted i0 black)
    (has-hole i0 two back)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 rough)
    (painted j0 yellow)
    (has-hole j0 one front)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 rough)
    (painted k0 blue)
    (has-hole k0 three front)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 rough)
    (painted l0 black)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 smooth)
    (painted m0 yellow)
    (has-hole m0 two front)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 rough)
    (painted n0 blue)
    (has-hole n0 three back)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 rough)
    (painted o0 blue)
    (has-hole o0 one back)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 smooth)
    (painted q0 yellow)
    (has-hole q0 three front)
    (temperature q0 cold)
    (shape p0 circular)
    (surface-condition p0 polished)
    (painted p0 blue)
    (has-hole p0 two front)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 smooth)
    (painted r0 black)
    (has-hole r0 one back)
    (temperature r0 cold)
    (shape s0 oblong)
    (surface-condition s0 smooth)
    (painted s0 black)
    (has-hole s0 one back)
    (temperature s0 cold)
    (shape u0 oblong)
    (surface-condition u0 rough)
    (painted u0 red)
    (has-hole u0 three back)
    (temperature u0 cold)
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
    (shape i0 cylindrical)
    (surface-condition r0 polished)
    (surface-condition o0 smooth)
    (painted r0 yellow)
    (painted e0 red)
    (surface-condition m0 polished)
    (surface-condition n0 polished)
    (shape o0 cylindrical)
    (painted g0 red)
    (shape u0 cylindrical)
    (shape l0 cylindrical)
    (surface-condition e0 polished)
    (surface-condition u0 polished)
    (surface-condition h0 polished)
    (painted h0 black)
    (shape e0 cylindrical)
    (painted a0 yellow)
    (painted d0 red)
    (painted p0 black)
    (surface-condition j0 polished)
)))
