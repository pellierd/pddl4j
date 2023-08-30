(define (problem schedule-18-0)
(:domain schedule)
(:objects
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
    (painted a0 black)
    (has-hole a0 two back)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 smooth)
    (painted b0 red)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 rough)
    (painted c0 blue)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 polished)
    (painted d0 blue)
    (has-hole d0 one front)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 polished)
    (painted e0 blue)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 rough)
    (painted f0 red)
    (has-hole f0 three back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 rough)
    (painted g0 blue)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 smooth)
    (painted h0 black)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 polished)
    (painted i0 red)
    (has-hole i0 one back)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 polished)
    (painted j0 blue)
    (has-hole j0 two back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 rough)
    (painted k0 yellow)
    (has-hole k0 one front)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 polished)
    (painted l0 blue)
    (has-hole l0 two back)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 smooth)
    (painted m0 red)
    (has-hole m0 one back)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 polished)
    (painted n0 blue)
    (has-hole n0 two back)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 polished)
    (painted o0 black)
    (has-hole o0 three front)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 smooth)
    (painted q0 blue)
    (has-hole q0 one back)
    (temperature q0 cold)
    (shape p0 oblong)
    (surface-condition p0 smooth)
    (painted p0 blue)
    (has-hole p0 two front)
    (temperature p0 cold)
    (shape r0 cylindrical)
    (surface-condition r0 polished)
    (painted r0 black)
    (has-hole r0 one back)
    (temperature r0 cold)
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
    (painted a0 red)
    (painted m0 yellow)
    (surface-condition m0 rough)
    (painted j0 yellow)
    (shape i0 cylindrical)
    (surface-condition q0 rough)
    (painted k0 red)
    (painted n0 yellow)
    (surface-condition b0 polished)
    (surface-condition d0 smooth)
    (shape m0 cylindrical)
    (shape h0 cylindrical)
    (painted i0 blue)
    (surface-condition e0 smooth)
    (surface-condition c0 polished)
    (painted l0 red)
    (surface-condition a0 polished)
    (surface-condition l0 rough)
)))
