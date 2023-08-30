(define (problem schedule-13-0)
(:domain schedule)
(:objects
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
    (surface-condition a0 smooth)
    (painted a0 yellow)
    (has-hole a0 two front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 rough)
    (painted b0 red)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 rough)
    (painted c0 red)
    (has-hole c0 two back)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 polished)
    (painted d0 black)
    (has-hole d0 three front)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 polished)
    (painted e0 yellow)
    (has-hole e0 one back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 rough)
    (painted f0 red)
    (has-hole f0 two front)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 polished)
    (painted g0 blue)
    (has-hole g0 two front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 polished)
    (painted h0 black)
    (has-hole h0 three back)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 polished)
    (painted i0 blue)
    (has-hole i0 one back)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 smooth)
    (painted j0 black)
    (has-hole j0 two back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 polished)
    (painted k0 blue)
    (has-hole k0 two back)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 smooth)
    (painted l0 blue)
    (has-hole l0 one front)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 rough)
    (painted m0 yellow)
    (has-hole m0 one back)
    (temperature m0 cold)
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
    (surface-condition i0 smooth)
    (painted i0 black)
    (shape e0 cylindrical)
    (surface-condition g0 rough)
    (shape j0 cylindrical)
    (painted a0 black)
    (surface-condition b0 smooth)
    (surface-condition f0 polished)
    (painted m0 red)
    (surface-condition k0 rough)
    (surface-condition d0 rough)
    (painted h0 yellow)
)))
