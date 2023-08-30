(define (problem schedule-16-0)
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
    (has-hole a0 two back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 polished)
    (painted b0 blue)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 smooth)
    (painted c0 blue)
    (has-hole c0 two front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 smooth)
    (painted d0 black)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 rough)
    (painted e0 yellow)
    (has-hole e0 one front)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 rough)
    (painted f0 yellow)
    (has-hole f0 three front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 rough)
    (painted g0 black)
    (has-hole g0 one back)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 polished)
    (painted h0 yellow)
    (has-hole h0 one back)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 polished)
    (painted i0 blue)
    (has-hole i0 three back)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 smooth)
    (painted j0 yellow)
    (has-hole j0 one back)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 smooth)
    (painted k0 red)
    (has-hole k0 three front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 rough)
    (painted l0 black)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 polished)
    (painted m0 red)
    (has-hole m0 one front)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 smooth)
    (painted n0 red)
    (has-hole n0 one back)
    (temperature n0 cold)
    (shape o0 cylindrical)
    (surface-condition o0 rough)
    (painted o0 blue)
    (has-hole o0 two back)
    (temperature o0 cold)
    (shape q0 circular)
    (surface-condition q0 polished)
    (painted q0 red)
    (has-hole q0 one back)
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
    (painted j0 red)
    (shape m0 cylindrical)
    (painted l0 yellow)
    (painted a0 blue)
    (surface-condition n0 rough)
    (shape i0 cylindrical)
    (painted e0 red)
    (surface-condition j0 polished)
    (surface-condition d0 polished)
    (shape a0 cylindrical)
    (surface-condition i0 smooth)
    (shape f0 cylindrical)
    (surface-condition h0 rough)
    (surface-condition o0 smooth)
    (shape l0 cylindrical)
    (surface-condition f0 polished)
)))
