; woodworking painting task with 11 parts
; Machines:
;   1 grinder
;   3 glazer
;   1 immersion-varnisher
;   1 planer
;   1 highspeed-saw
;   2 spray-varnisher
;   1 saw
; random seed: 323946

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 - grinder
    glazer0 glazer1 glazer2 - glazer
    immersion-varnisher0 - immersion-varnisher
    planer0 - planer
    highspeed-saw0 - highspeed-saw
    spray-varnisher0 spray-varnisher1 - spray-varnisher
    saw0 - saw
    black white red green blue mauve - acolour
    beech oak teak - awood
    p0 p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 - part
    b0 b1 b2 b3 - board
  )
  (:init
    (grind-treatment-change varnished colourfragments)
    (grind-treatment-change glazed untreated)
    (grind-treatment-change untreated untreated)
    (grind-treatment-change colourfragments untreated)
    (is-smooth smooth)
    (is-smooth verysmooth)
    (idle grinder0)
    (idle glazer0)
    (has-colour glazer0 green)
    (has-colour glazer0 red)
    (idle glazer1)
    (has-colour glazer1 blue)
    (has-colour glazer1 mauve)
    (has-colour glazer1 white)
    (has-colour glazer1 black)
    (idle glazer2)
    (has-colour glazer2 red)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 blue)
    (has-colour immersion-varnisher0 mauve)
    (has-colour immersion-varnisher0 black)
    (has-colour immersion-varnisher0 green)
    (has-colour immersion-varnisher0 white)
    (has-colour immersion-varnisher0 red)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 blue)
    (has-colour spray-varnisher0 black)
    (has-colour spray-varnisher0 red)
    (idle spray-varnisher1)
    (has-colour spray-varnisher1 mauve)
    (has-colour spray-varnisher1 white)
    (has-colour spray-varnisher1 green)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 8)
    (unused p1)
    (= (goal-size p1) 15)
    (unused p2)
    (= (goal-size p2) 11)
    (unused p3)
    (= (goal-size p3) 14)
    (unused p4)
    (= (goal-size p4) 14)
    (unused p5)
    (= (goal-size p5) 12)
    (available p6)
    (colour p6 natural)
    (wood p6 beech)
    (surface-condition p6 rough)
    (treatment p6 glazed)
    (= (goal-size p6) 9)
    (unused p7)
    (= (goal-size p7) 12)
    (unused p8)
    (= (goal-size p8) 13)
    (unused p9)
    (= (goal-size p9) 11)
    (unused p10)
    (= (goal-size p10) 11)
    (= (board-size b0) 62)
    (wood b0 beech)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 10)
    (wood b1 beech)
    (surface-condition b1 smooth)
    (available b1)
    (= (board-size b2) 59)
    (wood b2 teak)
    (surface-condition b2 rough)
    (available b2)
    (= (board-size b3) 16)
    (wood b3 oak)
    (surface-condition b3 rough)
    (available b3)
  )
  (:goal
    (and
      (available p0)
      (colour p0 mauve)
      (available p1)
      (colour p1 red)
      (available p2)
      (colour p2 black)
      (available p3)
      (colour p3 white)
      (available p4)
      (colour p4 white)
      (available p5)
      (colour p5 red)
      (available p6)
      (colour p6 white)
      (available p7)
      (colour p7 green)
      (available p8)
      (colour p8 blue)
      (available p9)
      (colour p9 green)
      (available p10)
      (colour p10 green)
    )
  )
  (:metric minimize (total-time))
)
