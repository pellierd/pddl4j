(define (problem schedule-17-2)
(:domain schedule)
(:objects
    p0
    q0
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
    (shape a0 oblong)
    (surface-condition a0 smooth)
    (painted a0 yellow)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 polished)
    (painted b0 black)
    (has-hole b0 three front)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 rough)
    (painted c0 blue)
    (has-hole c0 one back)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 polished)
    (painted d0 black)
    (has-hole d0 three front)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 smooth)
    (painted e0 yellow)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 polished)
    (painted f0 red)
    (has-hole f0 one back)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 polished)
    (painted g0 blue)
    (has-hole g0 one front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 rough)
    (painted h0 black)
    (has-hole h0 one back)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 smooth)
    (painted i0 blue)
    (has-hole i0 one front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 rough)
    (painted j0 yellow)
    (has-hole j0 three front)
    (temperature j0 cold)
    (shape k0 cylindrical)
    (surface-condition k0 smooth)
    (painted k0 yellow)
    (has-hole k0 one front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 rough)
    (painted l0 yellow)
    (has-hole l0 two front)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 smooth)
    (painted m0 blue)
    (has-hole m0 three front)
    (temperature m0 cold)
    (shape n0 cylindrical)
    (surface-condition n0 rough)
    (painted n0 yellow)
    (has-hole n0 two front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 rough)
    (painted o0 red)
    (has-hole o0 two front)
    (temperature o0 cold)
    (shape q0 circular)
    (surface-condition q0 rough)
    (painted q0 red)
    (has-hole q0 three front)
    (temperature q0 cold)
    (shape p0 circular)
    (surface-condition p0 polished)
    (painted p0 yellow)
    (has-hole p0 three front)
    (temperature p0 cold)
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
    (shape q0 cylindrical)
    (shape j0 cylindrical)
    (shape g0 cylindrical)
    (painted i0 red)
    (surface-condition n0 polished)
    (shape m0 cylindrical)
    (painted q0 black)
    (surface-condition d0 smooth)
    (surface-condition m0 polished)
    (surface-condition q0 polished)
    (painted p0 red)
    (painted k0 black)
    (painted c0 yellow)
    (surface-condition f0 smooth)
    (painted m0 black)
    (surface-condition c0 polished)
    (painted h0 red)
)))
