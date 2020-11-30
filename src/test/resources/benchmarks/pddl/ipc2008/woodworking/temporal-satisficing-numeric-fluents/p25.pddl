; woodworking task with 7 parts
; Machines:
;   1 grinder
;   2 glazer
;   2 immersion-varnisher
;   1 planer
;   2 highspeed-saw
;   1 spray-varnisher
;   1 saw
; random seed: 399161

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 - grinder
    glazer0 glazer1 - glazer
    immersion-varnisher0 immersion-varnisher1 - immersion-varnisher
    planer0 - planer
    highspeed-saw0 highspeed-saw1 - highspeed-saw
    spray-varnisher0 - spray-varnisher
    saw0 - saw
    black white red green blue - acolour
    walnut beech - awood
    p0 p1 p2 p3 p4 p5 p6 - part
    b0 b1 - board
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
    (has-colour glazer0 white)
    (has-colour glazer0 natural)
    (idle glazer1)
    (has-colour glazer1 white)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 white)
    (idle immersion-varnisher1)
    (has-colour immersion-varnisher1 green)
    (has-colour immersion-varnisher1 natural)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle highspeed-saw1)
    (empty highspeed-saw1)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 green)
    (has-colour spray-varnisher0 white)
    (has-colour spray-varnisher0 natural)
    (idle saw0)
    (available p0)
    (colour p0 green)
    (wood p0 walnut)
    (surface-condition p0 rough)
    (treatment p0 glazed)
    (= (goal-size p0) 5)
    (unused p1)
    (= (goal-size p1) 6)
    (unused p2)
    (= (goal-size p2) 13)
    (unused p3)
    (= (goal-size p3) 5)
    (unused p4)
    (= (goal-size p4) 10)
    (unused p5)
    (= (goal-size p5) 11)
    (unused p6)
    (= (goal-size p6) 13)
    (= (board-size b0) 22)
    (wood b0 beech)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 48)
    (wood b1 walnut)
    (surface-condition b1 smooth)
    (available b1)
  )
  (:goal
    (and
      (available p0)
      (colour p0 white)
      (wood p0 walnut)
      (surface-condition p0 verysmooth)
      (treatment p0 glazed)
      (available p1)
      (wood p1 walnut)
      (surface-condition p1 smooth)
      (treatment p1 glazed)
      (available p2)
      (wood p2 beech)
      (surface-condition p2 smooth)
      (available p3)
      (colour p3 white)
      (treatment p3 glazed)
      (available p4)
      (colour p4 green)
      (wood p4 walnut)
      (available p5)
      (colour p5 natural)
      (surface-condition p5 smooth)
      (available p6)
      (colour p6 white)
      (surface-condition p6 verysmooth)
    )
  )
  (:metric minimize (total-time))
)
