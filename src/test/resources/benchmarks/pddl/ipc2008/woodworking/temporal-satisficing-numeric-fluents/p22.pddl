; woodworking task with 4 parts
; Machines:
;   1 grinder
;   1 glazer
;   1 immersion-varnisher
;   1 planer
;   1 highspeed-saw
;   1 spray-varnisher
;   2 saw
; random seed: 657518

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 - grinder
    glazer0 - glazer
    immersion-varnisher0 - immersion-varnisher
    planer0 - planer
    highspeed-saw0 - highspeed-saw
    spray-varnisher0 - spray-varnisher
    saw0 saw1 - saw
    black white red - acolour
    oak mahogany - awood
    p0 p1 p2 p3 - part
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
    (has-colour glazer0 black)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 white)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 white)
    (idle saw0)
    (idle saw1)
    (unused p0)
    (= (goal-size p0) 7)
    (unused p1)
    (= (goal-size p1) 7)
    (unused p2)
    (= (goal-size p2) 12)
    (available p3)
    (colour p3 red)
    (wood p3 oak)
    (surface-condition p3 rough)
    (treatment p3 colourfragments)
    (= (goal-size p3) 9)
    (= (board-size b0) 17)
    (wood b0 mahogany)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 15)
    (wood b1 oak)
    (surface-condition b1 rough)
    (available b1)
  )
  (:goal
    (and
      (available p0)
      (wood p0 mahogany)
      (treatment p0 varnished)
      (available p1)
      (colour p1 white)
      (wood p1 mahogany)
      (surface-condition p1 verysmooth)
      (treatment p1 varnished)
      (available p2)
      (colour p2 black)
      (treatment p2 glazed)
      (available p3)
      (wood p3 oak)
      (treatment p3 glazed)
    )
  )
  (:metric minimize (total-time))
)
