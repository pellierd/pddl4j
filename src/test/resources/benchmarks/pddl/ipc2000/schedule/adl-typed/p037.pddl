(define (problem schedule-14-0)
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
    (painted a0 black)
    (has-hole a0 three front)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 polished)
    (painted b0 blue)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 smooth)
    (painted c0 blue)
    (has-hole c0 one back)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 smooth)
    (painted d0 yellow)
    (has-hole d0 three front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 rough)
    (painted e0 black)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 rough)
    (painted f0 red)
    (has-hole f0 three back)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 rough)
    (painted g0 red)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 rough)
    (painted h0 black)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 smooth)
    (painted i0 yellow)
    (has-hole i0 three back)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 smooth)
    (painted j0 yellow)
    (has-hole j0 two front)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 rough)
    (painted k0 blue)
    (has-hole k0 one back)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 rough)
    (painted l0 yellow)
    (has-hole l0 two front)
    (temperature l0 cold)
    (shape m0 cylindrical)
    (surface-condition m0 smooth)
    (painted m0 red)
    (has-hole m0 two back)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 rough)
    (painted n0 red)
    (has-hole n0 three front)
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
    (shape i0 cylindrical)
    (surface-condition d0 rough)
    (painted f0 yellow)
    (shape h0 cylindrical)
    (painted k0 yellow)
    (shape l0 cylindrical)
    (shape c0 cylindrical)
    (shape g0 cylindrical)
    (painted m0 yellow)
    (painted i0 blue)
    (shape f0 cylindrical)
    (surface-condition c0 polished)
    (painted d0 black)
    (painted c0 red)
)))
