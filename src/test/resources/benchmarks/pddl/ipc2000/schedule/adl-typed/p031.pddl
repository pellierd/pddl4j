(define (problem schedule-12-0)
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
    (shape a0 cylindrical)
    (surface-condition a0 rough)
    (painted a0 black)
    (has-hole a0 three front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 smooth)
    (painted b0 blue)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 rough)
    (painted c0 blue)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 rough)
    (painted d0 yellow)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 polished)
    (painted e0 red)
    (has-hole e0 two front)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 polished)
    (painted f0 yellow)
    (has-hole f0 one back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 smooth)
    (painted g0 yellow)
    (has-hole g0 two front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 rough)
    (painted h0 red)
    (has-hole h0 one front)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 polished)
    (painted i0 black)
    (has-hole i0 one back)
    (temperature i0 cold)
    (shape j0 oblong)
    (surface-condition j0 smooth)
    (painted j0 yellow)
    (has-hole j0 one front)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 rough)
    (painted k0 black)
    (has-hole k0 three front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 polished)
    (painted l0 black)
    (has-hole l0 three back)
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
    (shape b0 cylindrical)
    (painted j0 blue)
    (shape d0 cylindrical)
    (painted l0 yellow)
    (painted h0 yellow)
    (painted k0 blue)
    (surface-condition j0 polished)
    (painted b0 yellow)
    (surface-condition a0 smooth)
    (surface-condition f0 rough)
    (surface-condition d0 smooth)
    (painted d0 blue)
)))
