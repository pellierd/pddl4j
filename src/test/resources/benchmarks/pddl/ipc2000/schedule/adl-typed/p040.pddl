(define (problem schedule-15-0)
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
    (surface-condition a0 smooth)
    (painted a0 yellow)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 smooth)
    (painted b0 yellow)
    (has-hole b0 three front)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 smooth)
    (painted c0 red)
    (has-hole c0 two back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 smooth)
    (painted d0 yellow)
    (has-hole d0 two front)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 smooth)
    (painted e0 blue)
    (has-hole e0 three front)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 rough)
    (painted f0 red)
    (has-hole f0 three back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 rough)
    (painted g0 black)
    (has-hole g0 two back)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 smooth)
    (painted h0 black)
    (has-hole h0 three front)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 smooth)
    (painted i0 blue)
    (has-hole i0 three front)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 rough)
    (painted j0 yellow)
    (has-hole j0 two back)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 smooth)
    (painted k0 blue)
    (has-hole k0 three back)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 polished)
    (painted l0 yellow)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 smooth)
    (painted m0 red)
    (has-hole m0 one back)
    (temperature m0 cold)
    (shape n0 oblong)
    (surface-condition n0 smooth)
    (painted n0 red)
    (has-hole n0 two front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 rough)
    (painted o0 yellow)
    (has-hole o0 one front)
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
    (painted o0 red)
    (surface-condition i0 rough)
    (painted f0 yellow)
    (surface-condition o0 polished)
    (painted g0 yellow)
    (painted n0 black)
    (painted b0 black)
    (surface-condition m0 polished)
    (painted k0 red)
    (surface-condition l0 smooth)
    (shape k0 cylindrical)
    (painted c0 black)
    (painted a0 black)
    (surface-condition d0 polished)
    (painted d0 black)
)))
