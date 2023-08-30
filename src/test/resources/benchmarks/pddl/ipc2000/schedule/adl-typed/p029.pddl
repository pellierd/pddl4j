(define (problem schedule-11-1)
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
    (painted a0 black)
    (has-hole a0 two front)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 rough)
    (painted b0 red)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 smooth)
    (painted c0 blue)
    (has-hole c0 three back)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 polished)
    (painted d0 black)
    (has-hole d0 three back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 polished)
    (painted e0 black)
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
    (has-hole g0 three front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 polished)
    (painted h0 yellow)
    (has-hole h0 one front)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 rough)
    (painted i0 yellow)
    (has-hole i0 one back)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 polished)
    (painted j0 black)
    (has-hole j0 one back)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 polished)
    (painted k0 black)
    (has-hole k0 one back)
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
    (shape g0 cylindrical)
    (painted k0 blue)
    (surface-condition j0 smooth)
    (surface-condition c0 rough)
    (surface-condition i0 polished)
    (shape j0 cylindrical)
    (painted i0 red)
    (surface-condition f0 smooth)
    (surface-condition b0 polished)
    (surface-condition d0 rough)
    (painted d0 blue)
)))
