(define (problem schedule-9-2)
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
    (surface-condition a0 rough)
    (painted a0 blue)
    (has-hole a0 two front)
    (temperature a0 cold)
    (shape b0 cylindrical)
    (surface-condition b0 smooth)
    (painted b0 blue)
    (has-hole b0 two back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 smooth)
    (painted c0 blue)
    (has-hole c0 three back)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 smooth)
    (painted d0 red)
    (has-hole d0 one back)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 rough)
    (painted e0 blue)
    (has-hole e0 one front)
    (temperature e0 cold)
    (shape f0 oblong)
    (surface-condition f0 polished)
    (painted f0 red)
    (has-hole f0 two front)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 polished)
    (painted g0 black)
    (has-hole g0 two back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 black)
    (has-hole h0 two front)
    (temperature h0 cold)
    (shape i0 oblong)
    (surface-condition i0 rough)
    (painted i0 red)
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
    (surface-condition i0 polished)
    (shape c0 cylindrical)
    (painted b0 black)
    (painted f0 yellow)
    (surface-condition g0 smooth)
    (surface-condition b0 polished)
    (shape h0 cylindrical)
    (shape d0 cylindrical)
    (surface-condition d0 polished)
)))
