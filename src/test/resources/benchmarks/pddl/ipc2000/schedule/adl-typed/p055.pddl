(define (problem schedule-20-0)
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
    (painted a0 yellow)
    (has-hole a0 three back)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 polished)
    (painted b0 red)
    (has-hole b0 three front)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 polished)
    (painted c0 red)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 polished)
    (painted d0 black)
    (has-hole d0 three front)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 rough)
    (painted e0 yellow)
    (has-hole e0 three front)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 polished)
    (painted f0 yellow)
    (has-hole f0 three front)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 polished)
    (painted g0 black)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 smooth)
    (painted h0 blue)
    (has-hole h0 three back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 smooth)
    (painted i0 black)
    (has-hole i0 two front)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 rough)
    (painted j0 red)
    (has-hole j0 two front)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 smooth)
    (painted k0 black)
    (has-hole k0 two back)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 smooth)
    (painted l0 blue)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 smooth)
    (painted m0 red)
    (has-hole m0 one back)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 polished)
    (painted n0 red)
    (has-hole n0 three front)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 polished)
    (painted o0 blue)
    (has-hole o0 two back)
    (temperature o0 cold)
    (shape q0 circular)
    (surface-condition q0 rough)
    (painted q0 yellow)
    (has-hole q0 three front)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 polished)
    (painted p0 red)
    (has-hole p0 three back)
    (temperature p0 cold)
    (shape r0 cylindrical)
    (surface-condition r0 rough)
    (painted r0 red)
    (has-hole r0 two back)
    (temperature r0 cold)
    (shape s0 oblong)
    (surface-condition s0 rough)
    (painted s0 red)
    (has-hole s0 two back)
    (temperature s0 cold)
    (shape u0 cylindrical)
    (surface-condition u0 polished)
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
    (shape m0 cylindrical)
    (painted q0 black)
    (surface-condition p0 rough)
    (shape n0 cylindrical)
    (surface-condition r0 smooth)
    (shape l0 cylindrical)
    (shape o0 cylindrical)
    (painted e0 blue)
    (painted d0 red)
    (painted m0 blue)
    (painted k0 red)
    (surface-condition f0 smooth)
    (painted j0 blue)
    (surface-condition u0 rough)
    (painted h0 yellow)
    (shape q0 cylindrical)
    (painted o0 red)
    (surface-condition o0 smooth)
    (painted n0 black)
    (painted f0 red)
)))
