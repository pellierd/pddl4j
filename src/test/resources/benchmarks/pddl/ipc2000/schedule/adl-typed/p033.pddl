(define (problem schedule-12-2)
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
    (surface-condition a0 polished)
    (painted a0 red)
    (has-hole a0 one back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 polished)
    (painted b0 yellow)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 smooth)
    (painted c0 blue)
    (has-hole c0 one back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 rough)
    (painted d0 yellow)
    (has-hole d0 two front)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 polished)
    (painted e0 blue)
    (has-hole e0 two front)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 rough)
    (painted f0 blue)
    (has-hole f0 one front)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 smooth)
    (painted g0 yellow)
    (has-hole g0 two back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 black)
    (has-hole h0 three back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 rough)
    (painted i0 blue)
    (has-hole i0 two front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 smooth)
    (painted j0 blue)
    (has-hole j0 three front)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 rough)
    (painted k0 red)
    (has-hole k0 three back)
    (temperature k0 cold)
    (shape l0 cylindrical)
    (surface-condition l0 polished)
    (painted l0 yellow)
    (has-hole l0 two back)
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
    (surface-condition a0 rough)
    (surface-condition f0 smooth)
    (surface-condition i0 polished)
    (painted f0 black)
    (surface-condition b0 rough)
    (shape c0 cylindrical)
    (painted h0 blue)
    (surface-condition l0 rough)
    (shape e0 cylindrical)
    (painted c0 yellow)
    (shape k0 cylindrical)
    (painted e0 black)
)))
