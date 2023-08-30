(define (problem schedule-18-2)
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
    (surface-condition a0 smooth)
    (painted a0 red)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 rough)
    (painted b0 red)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 circular)
    (surface-condition c0 polished)
    (painted c0 black)
    (has-hole c0 two front)
    (temperature c0 cold)
    (shape d0 cylindrical)
    (surface-condition d0 smooth)
    (painted d0 black)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 rough)
    (painted e0 blue)
    (has-hole e0 three front)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 rough)
    (painted f0 blue)
    (has-hole f0 three back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 rough)
    (painted g0 red)
    (has-hole g0 one back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 rough)
    (painted h0 yellow)
    (has-hole h0 one back)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 polished)
    (painted i0 black)
    (has-hole i0 two front)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 rough)
    (painted j0 red)
    (has-hole j0 three front)
    (temperature j0 cold)
    (shape k0 circular)
    (surface-condition k0 smooth)
    (painted k0 red)
    (has-hole k0 three front)
    (temperature k0 cold)
    (shape l0 circular)
    (surface-condition l0 rough)
    (painted l0 black)
    (has-hole l0 one front)
    (temperature l0 cold)
    (shape m0 oblong)
    (surface-condition m0 polished)
    (painted m0 black)
    (has-hole m0 one front)
    (temperature m0 cold)
    (shape n0 oblong)
    (surface-condition n0 smooth)
    (painted n0 red)
    (has-hole n0 one back)
    (temperature n0 cold)
    (shape o0 circular)
    (surface-condition o0 polished)
    (painted o0 black)
    (has-hole o0 two front)
    (temperature o0 cold)
    (shape q0 cylindrical)
    (surface-condition q0 rough)
    (painted q0 black)
    (has-hole q0 two front)
    (temperature q0 cold)
    (shape p0 cylindrical)
    (surface-condition p0 smooth)
    (painted p0 red)
    (has-hole p0 one back)
    (temperature p0 cold)
    (shape r0 circular)
    (surface-condition r0 smooth)
    (painted r0 yellow)
    (has-hole r0 three front)
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
    (shape k0 cylindrical)
    (shape f0 cylindrical)
    (surface-condition p0 rough)
    (surface-condition h0 smooth)
    (surface-condition k0 rough)
    (shape m0 cylindrical)
    (surface-condition j0 smooth)
    (surface-condition r0 polished)
    (painted e0 black)
    (painted h0 blue)
    (painted o0 red)
    (surface-condition c0 rough)
    (painted b0 blue)
    (painted j0 blue)
    (surface-condition m0 smooth)
    (surface-condition d0 rough)
    (painted a0 blue)
    (surface-condition o0 smooth)
)))
