(define (problem schedule-12-1)
(:domain schedule)
(:objects
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
    (painted a0 black)
    (has-hole a0 three front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 rough)
    (painted b0 yellow)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 polished)
    (painted c0 black)
    (has-hole c0 two front)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 polished)
    (painted d0 yellow)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 polished)
    (painted e0 red)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 rough)
    (painted f0 blue)
    (has-hole f0 three back)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 polished)
    (painted g0 yellow)
    (has-hole g0 two front)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 blue)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 polished)
    (painted i0 black)
    (has-hole i0 two back)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 rough)
    (painted j0 blue)
    (has-hole j0 two front)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 smooth)
    (painted k0 yellow)
    (has-hole k0 two back)
    (temperature k0 cold)
    (shape l0 cylindrical)
    (surface-condition l0 smooth)
    (painted l0 yellow)
    (has-hole l0 two front)
    (temperature l0 cold)
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
    (painted l0 blue)
    (surface-condition g0 rough)
    (painted c0 red)
    (surface-condition d0 smooth)
    (shape h0 cylindrical)
    (painted d0 blue)
    (surface-condition i0 rough)
    (surface-condition f0 smooth)
    (surface-condition c0 rough)
    (painted h0 yellow)
    (surface-condition l0 polished)
    (surface-condition e0 rough)
)))
