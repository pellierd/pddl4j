(define (problem schedule-15-1)
(:domain schedule)
(:objects
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
    (surface-condition a0 rough)
    (painted a0 yellow)
    (has-hole a0 three back)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 rough)
    (painted b0 black)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 smooth)
    (painted c0 black)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 polished)
    (painted d0 black)
    (has-hole d0 three front)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 rough)
    (painted e0 yellow)
    (has-hole e0 one front)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 polished)
    (painted f0 yellow)
    (has-hole f0 three front)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 smooth)
    (painted g0 black)
    (has-hole g0 two back)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 polished)
    (painted h0 black)
    (has-hole h0 three back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 polished)
    (painted i0 black)
    (has-hole i0 one front)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 rough)
    (painted j0 yellow)
    (has-hole j0 three back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 rough)
    (painted k0 yellow)
    (has-hole k0 one front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 polished)
    (painted l0 yellow)
    (has-hole l0 one front)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 smooth)
    (painted m0 red)
    (has-hole m0 three front)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 polished)
    (painted n0 yellow)
    (has-hole n0 one back)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 rough)
    (painted o0 black)
    (has-hole o0 three back)
    (temperature o0 cold)
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
    (surface-condition d0 rough)
    (surface-condition a0 polished)
    (shape h0 cylindrical)
    (painted h0 red)
    (painted l0 blue)
    (shape k0 cylindrical)
    (shape b0 cylindrical)
    (shape f0 cylindrical)
    (painted j0 black)
    (painted e0 red)
    (shape d0 cylindrical)
    (surface-condition k0 polished)
    (painted d0 red)
    (surface-condition f0 smooth)
    (surface-condition c0 rough)
)))
