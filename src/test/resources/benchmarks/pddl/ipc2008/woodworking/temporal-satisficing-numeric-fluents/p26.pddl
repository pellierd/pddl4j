; woodworking task with 8 parts
; Machines:
;   2 grinder
;   2 glazer
;   1 immersion-varnisher
;   1 planer
;   1 highspeed-saw
;   1 spray-varnisher
;   2 saw
; random seed: 943470

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 grinder1 - grinder
    glazer0 glazer1 - glazer
    immersion-varnisher0 - immersion-varnisher
    planer0 - planer
    highspeed-saw0 - highspeed-saw
    spray-varnisher0 - spray-varnisher
    saw0 saw1 - saw
    black white red green blue mauve - acolour
    teak beech - awood
    p0 p1 p2 p3 p4 p5 p6 p7 - part
    b0 b1 b2 - board
  )
  (:init
    (grind-treatment-change varnished colourfragments)
    (grind-treatment-change glazed untreated)
    (grind-treatment-change untreated untreated)
    (grind-treatment-change colourfragments untreated)
    (is-smooth smooth)
    (is-smooth verysmooth)
    (idle grinder0)
    (idle grinder1)
    (idle glazer0)
    (has-colour glazer0 blue)
    (has-colour glazer0 green)
    (idle glazer1)
    (has-colour glazer1 blue)
    (has-colour glazer1 mauve)
    (has-colour glazer1 green)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 mauve)
    (has-colour immersion-varnisher0 white)
    (has-colour immersion-varnisher0 natural)
    (has-colour immersion-varnisher0 red)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 mauve)
    (has-colour spray-varnisher0 white)
    (has-colour spray-varnisher0 natural)
    (has-colour spray-varnisher0 red)
    (idle saw0)
    (idle saw1)
    (unused p0)
    (= (goal-size p0) 13)
    (unused p1)
    (= (goal-size p1) 10)
    (unused p2)
    (= (goal-size p2) 8)
    (unused p3)
    (= (goal-size p3) 14)
    (unused p4)
    (= (goal-size p4) 6)
    (unused p5)
    (= (goal-size p5) 9)
    (unused p6)
    (= (goal-size p6) 9)
    (unused p7)
    (= (goal-size p7) 13)
    (= (board-size b0) 45)
    (wood b0 beech)
    (surface-condition b0 smooth)
    (available b0)
    (= (board-size b1) 47)
    (wood b1 teak)
    (surface-condition b1 rough)
    (available b1)
    (= (board-size b2) 8)
    (wood b2 teak)
    (surface-condition b2 rough)
    (available b2)
  )
  (:goal
    (and
      (available p0)
      (wood p0 beech)
      (surface-condition p0 smooth)
      (available p1)
      (wood p1 beech)
      (treatment p1 glazed)
      (available p2)
      (colour p2 mauve)
      (wood p2 teak)
      (available p3)
      (colour p3 red)
      (wood p3 beech)
      (surface-condition p3 verysmooth)
      (treatment p3 varnished)
      (available p4)
      (colour p4 blue)
      (wood p4 teak)
      (surface-condition p4 verysmooth)
      (treatment p4 glazed)
      (available p5)
      (colour p5 white)
      (wood p5 teak)
      (treatment p5 varnished)
      (available p6)
      (colour p6 natural)
      (wood p6 teak)
      (surface-condition p6 verysmooth)
      (treatment p6 varnished)
      (available p7)
      (colour p7 green)
      (wood p7 teak)
      (surface-condition p7 verysmooth)
      (treatment p7 glazed)
    )
  )
  (:metric minimize (total-time))
)
