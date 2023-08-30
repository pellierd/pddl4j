(define (problem schedule-17-1)
(:domain schedule)
(:objects
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
    (painted a0 blue)
    (has-hole a0 one back)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 rough)
    (painted b0 black)
    (has-hole b0 three front)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 polished)
    (painted c0 red)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 smooth)
    (painted d0 yellow)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 smooth)
    (painted e0 yellow)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 rough)
    (painted f0 yellow)
    (has-hole f0 one front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 rough)
    (painted g0 black)
    (has-hole g0 one front)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 rough)
    (painted h0 yellow)
    (has-hole h0 three front)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 smooth)
    (painted i0 red)
    (has-hole i0 one back)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 polished)
    (painted j0 red)
    (has-hole j0 three front)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 smooth)
    (painted k0 yellow)
    (has-hole k0 one back)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 rough)
    (painted l0 yellow)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 rough)
    (painted m0 black)
    (has-hole m0 one back)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 smooth)
    (painted n0 blue)
    (has-hole n0 one back)
    (temperature n0 cold)
    (shape o0 oblong)
    (surface-condition o0 polished)
    (painted o0 black)
    (has-hole o0 two back)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 polished)
    (painted q0 red)
    (has-hole q0 one back)
    (temperature q0 cold)
    (shape p0 oblong)
    (surface-condition p0 rough)
    (painted p0 yellow)
    (has-hole p0 one back)
    (temperature p0 cold)
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
    (painted q0 yellow)
    (painted e0 black)
    (surface-condition i0 rough)
    (painted i0 blue)
    (shape p0 cylindrical)
    (painted m0 blue)
    (painted h0 black)
    (painted n0 yellow)
    (surface-condition k0 polished)
    (painted b0 yellow)
    (shape d0 cylindrical)
    (surface-condition c0 smooth)
    (surface-condition j0 rough)
    (surface-condition n0 polished)
    (surface-condition h0 polished)
    (shape a0 cylindrical)
    (painted l0 blue)
)))
