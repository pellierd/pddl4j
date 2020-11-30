; woodworking task with 9 parts
; Machines:
;   2 grinder
;   1 glazer
;   1 immersion-varnisher
;   3 planer
;   2 highspeed-saw
;   1 spray-varnisher
;   3 saw
; random seed: 604194

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 grinder1 - grinder
    glazer0 - glazer
    immersion-varnisher0 - immersion-varnisher
    planer0 planer1 planer2 - planer
    highspeed-saw0 highspeed-saw1 - highspeed-saw
    spray-varnisher0 - spray-varnisher
    saw0 saw1 saw2 - saw
    black white red green blue mauve - acolour
    oak mahogany - awood
    p0 p1 p2 p3 p4 p5 p6 p7 p8 - part
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
    (has-colour glazer0 natural)
    (has-colour glazer0 black)
    (has-colour glazer0 red)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 natural)
    (has-colour immersion-varnisher0 white)
    (has-colour immersion-varnisher0 black)
    (has-colour immersion-varnisher0 red)
    (idle planer0)
    (idle planer1)
    (idle planer2)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle highspeed-saw1)
    (empty highspeed-saw1)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 natural)
    (has-colour spray-varnisher0 white)
    (has-colour spray-varnisher0 black)
    (has-colour spray-varnisher0 red)
    (idle saw0)
    (idle saw1)
    (idle saw2)
    (unused p0)
    (= (goal-size p0) 13)
    (unused p1)
    (= (goal-size p1) 14)
    (unused p2)
    (= (goal-size p2) 10)
    (unused p3)
    (= (goal-size p3) 13)
    (unused p4)
    (= (goal-size p4) 15)
    (unused p5)
    (= (goal-size p5) 14)
    (unused p6)
    (= (goal-size p6) 15)
    (unused p7)
    (= (goal-size p7) 10)
    (unused p8)
    (= (goal-size p8) 12)
    (= (board-size b0) 65)
    (wood b0 mahogany)
    (surface-condition b0 smooth)
    (available b0)
    (= (board-size b1) 58)
    (wood b1 oak)
    (surface-condition b1 rough)
    (available b1)
    (= (board-size b2) 17)
    (wood b2 oak)
    (surface-condition b2 rough)
    (available b2)
  )
  (:goal
    (and
      (available p0)
      (colour p0 natural)
      (wood p0 oak)
      (available p1)
      (wood p1 oak)
      (treatment p1 varnished)
      (available p2)
      (colour p2 white)
      (wood p2 oak)
      (surface-condition p2 verysmooth)
      (treatment p2 varnished)
      (available p3)
      (wood p3 mahogany)
      (surface-condition p3 smooth)
      (treatment p3 varnished)
      (available p4)
      (colour p4 black)
      (surface-condition p4 verysmooth)
      (available p5)
      (wood p5 mahogany)
      (surface-condition p5 smooth)
      (treatment p5 varnished)
      (available p6)
      (wood p6 mahogany)
      (treatment p6 varnished)
      (available p7)
      (colour p7 red)
      (surface-condition p7 smooth)
      (available p8)
      (wood p8 mahogany)
      (treatment p8 glazed)
    )
  )
  (:metric minimize (total-time))
)
