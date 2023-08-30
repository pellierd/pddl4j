(define (problem schedule-11-0)
(:domain schedule)
(:objects
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
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 rough)
    (painted b0 black)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 rough)
    (painted c0 blue)
    (has-hole c0 two back)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 polished)
    (painted d0 blue)
    (has-hole d0 two front)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 smooth)
    (painted e0 black)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 smooth)
    (painted f0 black)
    (has-hole f0 one back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 smooth)
    (painted g0 black)
    (has-hole g0 one front)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 smooth)
    (painted h0 black)
    (has-hole h0 three back)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 smooth)
    (painted i0 yellow)
    (has-hole i0 one front)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 polished)
    (painted j0 black)
    (has-hole j0 two front)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 smooth)
    (painted k0 red)
    (has-hole k0 two front)
    (temperature k0 cold)
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
    (painted e0 red)
    (surface-condition i0 polished)
    (painted c0 black)
    (surface-condition e0 polished)
    (surface-condition h0 polished)
    (painted k0 blue)
    (surface-condition c0 smooth)
    (shape b0 cylindrical)
    (painted j0 blue)
    (surface-condition a0 polished)
    (shape h0 cylindrical)
)))
