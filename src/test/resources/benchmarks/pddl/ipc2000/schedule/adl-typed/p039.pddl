(define (problem schedule-14-2)
(:domain schedule)
(:objects
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
    (has-hole a0 one back)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 smooth)
    (painted b0 red)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 polished)
    (painted c0 red)
    (has-hole c0 one front)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 rough)
    (painted d0 red)
    (has-hole d0 one front)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 rough)
    (painted e0 black)
    (has-hole e0 three front)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 smooth)
    (painted f0 yellow)
    (has-hole f0 three back)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 polished)
    (painted g0 yellow)
    (has-hole g0 two front)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 polished)
    (painted h0 yellow)
    (has-hole h0 one back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 rough)
    (painted i0 blue)
    (has-hole i0 two front)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 smooth)
    (painted j0 black)
    (has-hole j0 two back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 polished)
    (painted k0 blue)
    (has-hole k0 three back)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 rough)
    (painted l0 red)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 polished)
    (painted m0 blue)
    (has-hole m0 three front)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 rough)
    (painted n0 blue)
    (has-hole n0 two back)
    (temperature n0 cold)
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
    (painted l0 yellow)
    (painted k0 yellow)
    (surface-condition a0 smooth)
    (surface-condition b0 polished)
    (painted c0 black)
    (painted b0 yellow)
    (surface-condition i0 smooth)
    (shape g0 cylindrical)
    (painted j0 yellow)
    (surface-condition f0 rough)
    (shape c0 cylindrical)
    (painted e0 blue)
    (shape l0 cylindrical)
    (painted n0 red)
)))
