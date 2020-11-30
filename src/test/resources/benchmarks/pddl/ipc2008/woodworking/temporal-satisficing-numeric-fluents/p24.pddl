; woodworking task with 6 parts
; Machines:
;   1 grinder
;   2 glazer
;   1 immersion-varnisher
;   1 planer
;   1 highspeed-saw
;   1 spray-varnisher
;   1 saw
; random seed: 743195

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 - grinder
    glazer0 glazer1 - glazer
    immersion-varnisher0 - immersion-varnisher
    planer0 - planer
    highspeed-saw0 - highspeed-saw
    spray-varnisher0 - spray-varnisher
    saw0 - saw
    black white red green - acolour
    teak mahogany - awood
    p0 p1 p2 p3 p4 p5 - part
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
    (has-colour glazer0 natural)
    (has-colour glazer0 black)
    (has-colour glazer0 red)
    (idle glazer1)
    (has-colour glazer1 red)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 natural)
    (has-colour immersion-varnisher0 black)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 natural)
    (has-colour spray-varnisher0 black)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 7)
    (unused p1)
    (= (goal-size p1) 8)
    (unused p2)
    (= (goal-size p2) 12)
    (unused p3)
    (= (goal-size p3) 5)
    (unused p4)
    (= (goal-size p4) 13)
    (unused p5)
    (= (goal-size p5) 6)
    (= (board-size b0) 17)
    (wood b0 teak)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 45)
    (wood b1 mahogany)
    (surface-condition b1 rough)
    (available b1)
  )
  (:goal
    (and
      (available p0)
      (wood p0 mahogany)
      (treatment p0 varnished)
      (available p1)
      (colour p1 black)
      (wood p1 teak)
      (surface-condition p1 smooth)
      (treatment p1 varnished)
      (available p2)
      (colour p2 natural)
      (surface-condition p2 verysmooth)
      (available p3)
      (colour p3 red)
      (wood p3 mahogany)
      (surface-condition p3 smooth)
      (treatment p3 glazed)
      (available p4)
      (colour p4 black)
      (surface-condition p4 verysmooth)
      (treatment p4 varnished)
      (available p5)
      (colour p5 black)
      (wood p5 teak)
    )
  )
  (:metric minimize (total-time))
)
