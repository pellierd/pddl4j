(define (problem schedule-10-0)
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
    (painted a0 yellow)
    (has-hole a0 three back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 rough)
    (painted b0 blue)
    (has-hole b0 one back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 polished)
    (painted c0 blue)
    (has-hole c0 three front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 rough)
    (painted d0 blue)
    (has-hole d0 two back)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 smooth)
    (painted e0 red)
    (has-hole e0 one front)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 smooth)
    (painted f0 black)
    (has-hole f0 two back)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 rough)
    (painted g0 red)
    (has-hole g0 one back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 black)
    (has-hole h0 one front)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 rough)
    (painted i0 yellow)
    (has-hole i0 two back)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 polished)
    (painted j0 black)
    (has-hole j0 one front)
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
)
(:goal (and
    (surface-condition h0 smooth)
    (shape e0 cylindrical)
    (shape d0 cylindrical)
    (painted i0 blue)
    (shape g0 cylindrical)
    (shape i0 cylindrical)
    (surface-condition i0 polished)
    (shape c0 cylindrical)
    (painted c0 black)
    (painted h0 blue)
)))
