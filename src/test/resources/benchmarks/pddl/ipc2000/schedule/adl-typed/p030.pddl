(define (problem schedule-11-2)
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
    (shape a0 circular)
    (surface-condition a0 rough)
    (painted a0 blue)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 rough)
    (painted b0 yellow)
    (has-hole b0 three front)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 polished)
    (painted c0 blue)
    (has-hole c0 one front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 rough)
    (painted d0 red)
    (has-hole d0 three front)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 smooth)
    (painted e0 yellow)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 smooth)
    (painted f0 yellow)
    (has-hole f0 three front)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 smooth)
    (painted g0 blue)
    (has-hole g0 two front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 smooth)
    (painted h0 red)
    (has-hole h0 one front)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 polished)
    (painted i0 black)
    (has-hole i0 two front)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 rough)
    (painted j0 yellow)
    (has-hole j0 two front)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 smooth)
    (painted k0 blue)
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
    (painted j0 blue)
    (painted i0 yellow)
    (surface-condition h0 polished)
    (shape c0 cylindrical)
    (shape f0 cylindrical)
    (shape b0 cylindrical)
    (painted a0 red)
    (shape g0 cylindrical)
    (surface-condition j0 smooth)
    (painted k0 yellow)
    (shape k0 cylindrical)
)))
