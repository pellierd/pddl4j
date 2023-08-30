(define (problem schedule-16-2)
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
    (shape a0 cylindrical)
    (surface-condition a0 smooth)
    (painted a0 blue)
    (has-hole a0 three back)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 smooth)
    (painted b0 yellow)
    (has-hole b0 two front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 smooth)
    (painted c0 black)
    (has-hole c0 two front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 rough)
    (painted d0 red)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 rough)
    (painted e0 blue)
    (has-hole e0 one back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 polished)
    (painted f0 red)
    (has-hole f0 two front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 rough)
    (painted g0 blue)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 blue)
    (has-hole h0 three back)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 smooth)
    (painted i0 yellow)
    (has-hole i0 two back)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 smooth)
    (painted j0 red)
    (has-hole j0 one front)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 polished)
    (painted k0 black)
    (has-hole k0 one back)
    (temperature k0 cold)
    (shape l0 cylindrical)
    (surface-condition l0 rough)
    (painted l0 yellow)
    (has-hole l0 one back)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 smooth)
    (painted m0 blue)
    (has-hole m0 three front)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 smooth)
    (painted n0 blue)
    (has-hole n0 two front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 smooth)
    (painted o0 red)
    (has-hole o0 one front)
    (temperature o0 cold)
    (shape q0 circular)
    (surface-condition q0 smooth)
    (painted q0 black)
    (has-hole q0 three back)
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
    (surface-condition o0 rough)
    (painted g0 black)
    (painted i0 blue)
    (painted l0 red)
    (surface-condition l0 smooth)
    (painted b0 black)
    (painted j0 yellow)
    (painted h0 yellow)
    (surface-condition i0 polished)
    (surface-condition m0 rough)
    (surface-condition h0 smooth)
    (shape d0 cylindrical)
    (surface-condition q0 rough)
    (shape m0 cylindrical)
    (painted n0 yellow)
    (surface-condition j0 rough)
)))
