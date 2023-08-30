(define (problem schedule-16-1)
(:domain schedule)
(:objects
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
    (painted a0 yellow)
    (has-hole a0 one back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 smooth)
    (painted b0 yellow)
    (has-hole b0 two back)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 rough)
    (painted c0 blue)
    (has-hole c0 one front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 rough)
    (painted d0 black)
    (has-hole d0 three front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 rough)
    (painted e0 yellow)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 polished)
    (painted f0 black)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 rough)
    (painted g0 red)
    (has-hole g0 three front)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 smooth)
    (painted h0 yellow)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 rough)
    (painted i0 red)
    (has-hole i0 three front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 smooth)
    (painted j0 black)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 polished)
    (painted k0 blue)
    (has-hole k0 three front)
    (temperature k0 cold)
    (shape l0 cylindrical)
    (surface-condition l0 smooth)
    (painted l0 black)
    (has-hole l0 one front)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 rough)
    (painted m0 black)
    (has-hole m0 one back)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 rough)
    (painted n0 yellow)
    (has-hole n0 two back)
    (temperature n0 cold)
    (shape o0 cylindrical)
    (surface-condition o0 smooth)
    (painted o0 blue)
    (has-hole o0 two front)
    (temperature o0 cold)
    (shape q0 oblong)
    (surface-condition q0 polished)
    (painted q0 yellow)
    (has-hole q0 one front)
    (temperature q0 cold)
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
    (surface-condition e0 polished)
    (surface-condition q0 smooth)
    (painted e0 black)
    (painted o0 red)
    (surface-condition f0 rough)
    (shape k0 cylindrical)
    (surface-condition l0 polished)
    (surface-condition i0 polished)
    (painted g0 black)
    (painted f0 red)
    (surface-condition j0 rough)
    (surface-condition b0 polished)
    (shape q0 cylindrical)
    (shape a0 cylindrical)
    (painted l0 yellow)
    (shape f0 cylindrical)
)))
