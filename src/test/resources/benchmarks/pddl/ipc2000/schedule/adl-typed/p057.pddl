(define (problem schedule-20-2)
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
    (surface-condition a0 rough)
    (painted a0 blue)
    (has-hole a0 one back)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 polished)
    (painted b0 blue)
    (has-hole b0 two front)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 smooth)
    (painted c0 yellow)
    (has-hole c0 one back)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 smooth)
    (painted d0 black)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 smooth)
    (painted e0 red)
    (has-hole e0 one back)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 rough)
    (painted f0 black)
    (has-hole f0 two front)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 rough)
    (painted g0 blue)
    (has-hole g0 three front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 polished)
    (painted h0 yellow)
    (has-hole h0 three front)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 smooth)
    (painted i0 blue)
    (has-hole i0 two front)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 smooth)
    (painted j0 red)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 rough)
    (painted k0 red)
    (has-hole k0 one back)
    (temperature k0 cold)
    (shape l0 cylindrical)
    (surface-condition l0 smooth)
    (painted l0 yellow)
    (has-hole l0 one front)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 smooth)
    (painted m0 yellow)
    (has-hole m0 three front)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 smooth)
    (painted n0 red)
    (has-hole n0 two front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 rough)
    (painted o0 blue)
    (has-hole o0 two back)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 smooth)
    (painted q0 blue)
    (has-hole q0 one back)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 polished)
    (painted p0 blue)
    (has-hole p0 three front)
    (temperature p0 cold)
    (shape r0 oblong)
    (surface-condition r0 smooth)
    (painted r0 black)
    (has-hole r0 one back)
    (temperature r0 cold)
    (shape s0 cylindrical)
    (surface-condition s0 rough)
    (painted s0 black)
    (has-hole s0 one back)
    (temperature s0 cold)
    (shape u0 circular)
    (surface-condition u0 smooth)
    (painted u0 yellow)
    (has-hole u0 three front)
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
    (surface-condition p0 smooth)
    (surface-condition j0 rough)
    (surface-condition k0 polished)
    (surface-condition q0 rough)
    (painted k0 yellow)
    (painted a0 black)
    (painted u0 black)
    (surface-condition d0 polished)
    (shape o0 cylindrical)
    (painted s0 red)
    (painted d0 red)
    (surface-condition f0 polished)
    (surface-condition u0 polished)
    (painted j0 yellow)
    (shape a0 cylindrical)
    (painted r0 yellow)
    (shape d0 cylindrical)
    (painted c0 red)
    (shape i0 cylindrical)
    (surface-condition s0 polished)
)))
