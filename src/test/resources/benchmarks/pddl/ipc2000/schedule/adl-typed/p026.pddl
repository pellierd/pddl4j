(define (problem schedule-10-1)
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
    (shape a0 circular)
    (surface-condition a0 polished)
    (painted a0 yellow)
    (has-hole a0 one back)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 smooth)
    (painted b0 red)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 rough)
    (painted c0 blue)
    (has-hole c0 one front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 polished)
    (painted d0 blue)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 cylindrical)
    (surface-condition e0 polished)
    (painted e0 black)
    (has-hole e0 three front)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 rough)
    (painted f0 black)
    (has-hole f0 three back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 smooth)
    (painted g0 black)
    (has-hole g0 one back)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 rough)
    (painted h0 red)
    (has-hole h0 one back)
    (temperature h0 cold)
    (shape i0 circular)
    (surface-condition i0 smooth)
    (painted i0 black)
    (has-hole i0 two back)
    (temperature i0 cold)
    (shape j0 cylindrical)
    (surface-condition j0 smooth)
    (painted j0 yellow)
    (has-hole j0 three front)
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
    (painted i0 yellow)
    (shape d0 cylindrical)
    (painted d0 red)
    (shape i0 cylindrical)
    (surface-condition j0 rough)
    (surface-condition i0 rough)
    (painted j0 blue)
    (surface-condition d0 rough)
    (surface-condition c0 polished)
    (surface-condition a0 rough)
)))
