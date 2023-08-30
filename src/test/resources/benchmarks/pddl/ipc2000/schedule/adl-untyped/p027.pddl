(define (problem schedule-10-2)
(:domain schedule)
(:objects
    j0
    i0
    h0
    g0
    f0
    e0
    d0
    c0
    circular
    two
    three
    blue
    yellow
    back
    red
    b0
    front
    one
    black
    oblong
    a0
)
(:init
    (shape a0 oblong)
    (surface-condition a0 polished)
    (painted a0 yellow)
    (has-hole a0 three front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 smooth)
    (painted b0 black)
    (has-hole b0 two front)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 smooth)
    (painted c0 red)
    (has-hole c0 one front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 smooth)
    (painted d0 yellow)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 smooth)
    (painted e0 black)
    (has-hole e0 one front)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 smooth)
    (painted f0 yellow)
    (has-hole f0 one back)
    (temperature f0 cold)
    (shape g0 cylindrical)
    (surface-condition g0 rough)
    (painted g0 yellow)
    (has-hole g0 two back)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 rough)
    (painted h0 red)
    (has-hole h0 one back)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 rough)
    (painted i0 red)
    (has-hole i0 one front)
    (temperature i0 cold)
    (shape j0 circular)
    (surface-condition j0 rough)
    (painted j0 yellow)
    (has-hole j0 two back)
    (temperature j0 cold)
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
    (part j0)
    (part i0)
    (part h0)
    (part g0)
    (part f0)
    (part e0)
    (part d0)
    (part c0)
    (part b0)
    (part a0)
)
(:goal (and
    (painted b0 red)
    (shape c0 cylindrical)
    (shape b0 cylindrical)
    (surface-condition i0 polished)
    (shape i0 cylindrical)
    (painted i0 blue)
    (surface-condition j0 polished)
    (painted g0 black)
    (surface-condition h0 smooth)
    (painted c0 blue)
)))
