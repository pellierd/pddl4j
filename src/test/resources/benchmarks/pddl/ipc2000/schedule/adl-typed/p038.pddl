(define (problem schedule-14-1)
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
    (shape a0 circular)
    (surface-condition a0 polished)
    (painted a0 red)
    (has-hole a0 two back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 smooth)
    (painted b0 black)
    (has-hole b0 three front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 polished)
    (painted c0 black)
    (has-hole c0 one front)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 rough)
    (painted d0 blue)
    (has-hole d0 two front)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 rough)
    (painted e0 black)
    (has-hole e0 one back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 smooth)
    (painted f0 black)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 smooth)
    (painted g0 black)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 rough)
    (painted h0 black)
    (has-hole h0 one back)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 smooth)
    (painted i0 yellow)
    (has-hole i0 two front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 smooth)
    (painted j0 black)
    (has-hole j0 two back)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 polished)
    (painted k0 black)
    (has-hole k0 one back)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 smooth)
    (painted l0 blue)
    (has-hole l0 two front)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 smooth)
    (painted m0 blue)
    (has-hole m0 one back)
    (temperature m0 cold)
    (shape n0 circular)
    (surface-condition n0 smooth)
    (painted n0 red)
    (has-hole n0 three back)
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
    (painted b0 yellow)
    (surface-condition d0 smooth)
    (surface-condition n0 rough)
    (shape a0 cylindrical)
    (surface-condition e0 smooth)
    (surface-condition h0 polished)
    (shape h0 cylindrical)
    (painted c0 red)
    (surface-condition g0 rough)
    (shape i0 cylindrical)
    (painted g0 blue)
    (shape c0 cylindrical)
    (shape f0 cylindrical)
    (painted a0 yellow)
)))
