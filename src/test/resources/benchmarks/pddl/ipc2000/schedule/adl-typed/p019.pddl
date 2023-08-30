(define (problem schedule-8-0)
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
    (shape a0 oblong)
    (surface-condition a0 smooth)
    (painted a0 black)
    (has-hole a0 three back)
    (temperature a0 cold)
    (shape b0 circular)
    (surface-condition b0 smooth)
    (painted b0 yellow)
    (has-hole b0 two back)
    (temperature b0 cold)
    (shape c0 oblong)
    (surface-condition c0 smooth)
    (painted c0 black)
    (has-hole c0 two front)
    (temperature c0 cold)
    (shape d0 circular)
    (surface-condition d0 rough)
    (painted d0 blue)
    (has-hole d0 one front)
    (temperature d0 cold)
    (shape e0 circular)
    (surface-condition e0 rough)
    (painted e0 blue)
    (has-hole e0 one front)
    (temperature e0 cold)
    (shape f0 circular)
    (surface-condition f0 polished)
    (painted f0 black)
    (has-hole f0 three front)
    (temperature f0 cold)
    (shape g0 circular)
    (surface-condition g0 polished)
    (painted g0 blue)
    (has-hole g0 one front)
    (temperature g0 cold)
    (shape h0 cylindrical)
    (surface-condition h0 smooth)
    (painted h0 black)
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
    (painted e0 yellow)
    (surface-condition d0 smooth)
    (surface-condition h0 rough)
    (surface-condition c0 polished)
    (painted c0 yellow)
    (painted b0 black)
    (shape e0 cylindrical)
    (painted a0 blue)
)))
