(define (problem schedule-13-2)
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
    (shape a0 cylindrical)
    (surface-condition a0 polished)
    (painted a0 red)
    (has-hole a0 three front)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 rough)
    (painted b0 black)
    (has-hole b0 two back)
    (temperature b0 cold)
    (shape c0 cylindrical)
    (surface-condition c0 rough)
    (painted c0 blue)
    (has-hole c0 two back)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 rough)
    (painted d0 blue)
    (has-hole d0 two front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 polished)
    (painted e0 blue)
    (has-hole e0 one front)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 polished)
    (painted f0 blue)
    (has-hole f0 one front)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 smooth)
    (painted g0 yellow)
    (has-hole g0 three front)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 rough)
    (painted h0 blue)
    (has-hole h0 two back)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 polished)
    (painted i0 yellow)
    (has-hole i0 two front)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 rough)
    (painted j0 black)
    (has-hole j0 two back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 rough)
    (painted k0 red)
    (has-hole k0 one back)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 smooth)
    (painted l0 blue)
    (has-hole l0 one front)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 polished)
    (painted m0 yellow)
    (has-hole m0 two front)
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
    (shape e0 cylindrical)
    (surface-condition d0 smooth)
    (surface-condition l0 rough)
    (shape k0 cylindrical)
    (painted b0 blue)
    (painted k0 black)
    (painted e0 black)
    (painted h0 red)
    (painted c0 yellow)
    (surface-condition k0 polished)
    (surface-condition a0 rough)
    (surface-condition g0 rough)
    (shape m0 cylindrical)
)))
