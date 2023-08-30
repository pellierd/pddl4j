(define (problem schedule-9-1)
(:domain schedule)
(:objects
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
    (painted a0 black)
    (has-hole a0 two back)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 smooth)
    (painted b0 yellow)
    (has-hole b0 one front)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 polished)
    (painted c0 black)
    (has-hole c0 one back)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 polished)
    (painted d0 yellow)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 smooth)
    (painted e0 yellow)
    (has-hole e0 three back)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 polished)
    (painted f0 red)
    (has-hole f0 one back)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 smooth)
    (painted g0 red)
    (has-hole g0 three back)
    (temperature g0 cold)
    (shape h0 circular)
    (surface-condition h0 polished)
    (painted h0 red)
    (has-hole h0 two front)
    (temperature h0 cold)
    (shape i0 cylindrical)
    (surface-condition i0 polished)
    (painted i0 blue)
    (has-hole i0 three front)
    (temperature i0 cold)
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
    (painted g0 blue)
    (painted e0 red)
    (painted b0 blue)
    (shape d0 cylindrical)
    (surface-condition i0 smooth)
    (surface-condition c0 smooth)
    (painted h0 blue)
    (shape h0 cylindrical)
    (surface-condition d0 rough)
)))
