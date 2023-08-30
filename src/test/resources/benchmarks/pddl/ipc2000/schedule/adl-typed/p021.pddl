(define (problem schedule-8-2)
(:domain schedule)
(:objects
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
    (painted a0 blue)
    (has-hole a0 one front)
    (temperature a0 cold)
    (shape b0 oblong)
    (surface-condition b0 rough)
    (painted b0 yellow)
    (has-hole b0 three back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 smooth)
    (painted c0 blue)
    (has-hole c0 two front)
    (temperature c0 cold)
    (shape d0 oblong)
    (surface-condition d0 rough)
    (painted d0 red)
    (has-hole d0 three front)
    (temperature d0 cold)
    (shape e0 oblong)
    (surface-condition e0 smooth)
    (painted e0 yellow)
    (has-hole e0 one front)
    (temperature e0 cold)
    (shape f0 cylindrical)
    (surface-condition f0 smooth)
    (painted f0 yellow)
    (has-hole f0 one back)
    (temperature f0 cold)
    (shape g0 oblong)
    (surface-condition g0 rough)
    (painted g0 red)
    (has-hole g0 one back)
    (temperature g0 cold)
    (shape h0 oblong)
    (surface-condition h0 polished)
    (painted h0 red)
    (has-hole h0 two back)
    (temperature h0 cold)
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
    (painted g0 blue)
    (painted b0 red)
    (painted c0 yellow)
    (shape h0 cylindrical)
    (shape c0 cylindrical)
    (surface-condition g0 polished)
    (surface-condition b0 smooth)
)))
