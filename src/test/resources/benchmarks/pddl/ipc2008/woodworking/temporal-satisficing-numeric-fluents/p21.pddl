; woodworking task with 3 parts
; Machines:
;   1 grinder
;   1 glazer
;   1 immersion-varnisher
;   1 planer
;   2 highspeed-saw
;   1 spray-varnisher
;   1 saw
; random seed: 353988

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 - grinder
    glazer0 - glazer
    immersion-varnisher0 - immersion-varnisher
    planer0 - planer
    highspeed-saw0 highspeed-saw1 - highspeed-saw
    spray-varnisher0 - spray-varnisher
    saw0 - saw
    black white - acolour
    cherry beech - awood
    p0 p1 p2 - part
    b0 - board
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
    (has-colour glazer0 white)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 natural)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle highspeed-saw1)
    (empty highspeed-saw1)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 natural)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 5)
    (unused p1)
    (= (goal-size p1) 10)
    (unused p2)
    (= (goal-size p2) 6)
    (= (board-size b0) 26)
    (wood b0 cherry)
    (surface-condition b0 smooth)
    (available b0)
  )
  (:goal
    (and
      (available p0)
      (colour p0 white)
      (wood p0 cherry)
      (surface-condition p0 verysmooth)
      (treatment p0 glazed)
      (available p1)
      (colour p1 natural)
      (treatment p1 varnished)
      (available p2)
      (wood p2 cherry)
      (treatment p2 glazed)
    )
  )
  (:metric minimize (total-time))
)
