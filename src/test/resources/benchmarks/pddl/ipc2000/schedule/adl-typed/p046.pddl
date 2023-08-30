(define (problem schedule-17-0)
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
    (shape a0 cylindrical)
    (surface-condition a0 rough)
    (painted a0 black)
    (has-hole a0 three front)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 rough)
    (painted b0 red)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 polished)
    (painted c0 red)
    (has-hole c0 one front)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 smooth)
    (painted d0 black)
    (has-hole d0 two front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 smooth)
    (painted e0 black)
    (has-hole e0 one back)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 rough)
    (painted f0 blue)
    (has-hole f0 one back)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 polished)
    (painted g0 red)
    (has-hole g0 two front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 smooth)
    (painted h0 red)
    (has-hole h0 three front)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 smooth)
    (painted i0 red)
    (has-hole i0 two back)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 smooth)
    (painted j0 black)
    (has-hole j0 one back)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 polished)
    (painted k0 yellow)
    (has-hole k0 one back)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 smooth)
    (painted l0 black)
    (has-hole l0 three front)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 smooth)
    (painted m0 red)
    (has-hole m0 three front)
    (temperature m0 cold)
    (shape n0 oblong)
    (surface-condition n0 rough)
    (painted n0 red)
    (has-hole n0 three front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 smooth)
    (painted o0 yellow)
    (has-hole o0 three front)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 polished)
    (painted q0 red)
    (has-hole q0 three front)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 polished)
    (painted p0 red)
    (has-hole p0 two front)
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
    (surface-condition l0 rough)
    (surface-condition k0 rough)
    (surface-condition p0 rough)
    (painted e0 yellow)
    (surface-condition g0 rough)
    (surface-condition n0 polished)
    (surface-condition m0 rough)
    (shape b0 cylindrical)
    (painted d0 red)
    (surface-condition h0 polished)
    (painted i0 yellow)
    (surface-condition i0 polished)
    (shape i0 cylindrical)
    (shape m0 cylindrical)
    (painted q0 blue)
    (shape j0 cylindrical)
    (shape g0 cylindrical)
)))
