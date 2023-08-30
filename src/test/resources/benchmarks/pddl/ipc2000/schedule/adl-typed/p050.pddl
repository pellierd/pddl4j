(define (problem schedule-18-1)
(:domain schedule)
(:objects
    r0
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
    (shape a0 circular)
    (surface-condition a0 rough)
    (painted a0 blue)
    (has-hole a0 one back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 rough)
    (painted b0 yellow)
    (has-hole b0 two front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 rough)
    (painted c0 black)
    (has-hole c0 three back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 smooth)
    (painted d0 yellow)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 smooth)
    (painted e0 black)
    (has-hole e0 two back)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 smooth)
    (painted f0 red)
    (has-hole f0 three front)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 smooth)
    (painted g0 red)
    (has-hole g0 one front)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 rough)
    (painted h0 yellow)
    (has-hole h0 one front)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 polished)
    (painted i0 blue)
    (has-hole i0 three front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 polished)
    (painted j0 yellow)
    (has-hole j0 two back)
    (temperature j0 cold)
    (shape k0 oblong)
    (surface-condition k0 smooth)
    (painted k0 red)
    (has-hole k0 one front)
    (temperature k0 cold)
    (shape l0 oblong)
    (surface-condition l0 smooth)
    (painted l0 blue)
    (has-hole l0 one back)
    (temperature l0 cold)
    (shape m0 circular)
    (surface-condition m0 smooth)
    (painted m0 yellow)
    (has-hole m0 two front)
    (temperature m0 cold)
    (shape n0 oblong)
    (surface-condition n0 polished)
    (painted n0 blue)
    (has-hole n0 three front)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 rough)
    (painted o0 black)
    (has-hole o0 two back)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 polished)
    (painted q0 yellow)
    (has-hole q0 one front)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 rough)
    (painted p0 red)
    (has-hole p0 two front)
    (temperature p0 cold)
    (shape r0 circular)
    (surface-condition r0 smooth)
    (painted r0 black)
    (has-hole r0 one front)
    (temperature r0 cold)
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
    (surface-condition o0 polished)
    (painted a0 black)
    (painted b0 black)
    (painted m0 red)
    (surface-condition a0 smooth)
    (shape n0 cylindrical)
    (shape c0 cylindrical)
    (shape j0 cylindrical)
    (shape h0 cylindrical)
    (painted d0 black)
    (painted g0 blue)
    (surface-condition k0 polished)
    (surface-condition b0 smooth)
    (painted r0 blue)
    (painted o0 blue)
    (painted j0 black)
    (surface-condition g0 polished)
    (shape o0 cylindrical)
)))
