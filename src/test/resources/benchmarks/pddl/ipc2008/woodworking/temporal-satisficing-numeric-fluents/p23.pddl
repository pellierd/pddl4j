; woodworking task with 5 parts
; Machines:
;   1 grinder
;   1 glazer
;   1 immersion-varnisher
;   1 planer
;   1 highspeed-saw
;   1 spray-varnisher
;   3 saw
; random seed: 852205

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 - grinder
    glazer0 - glazer
    immersion-varnisher0 - immersion-varnisher
    planer0 - planer
    highspeed-saw0 - highspeed-saw
    spray-varnisher0 - spray-varnisher
    saw0 saw1 saw2 - saw
    black white red green - acolour
    cherry mahogany - awood
    p0 p1 p2 p3 p4 - part
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
    (has-colour glazer0 natural)
    (has-colour glazer0 red)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 green)
    (has-colour immersion-varnisher0 red)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 green)
    (has-colour spray-varnisher0 red)
    (idle saw0)
    (idle saw1)
    (idle saw2)
    (available p0)
    (colour p0 black)
    (wood p0 cherry)
    (surface-condition p0 verysmooth)
    (treatment p0 glazed)
    (= (goal-size p0) 6)
    (available p1)
    (colour p1 black)
    (wood p1 cherry)
    (surface-condition p1 verysmooth)
    (treatment p1 varnished)
    (= (goal-size p1) 7)
    (unused p2)
    (= (goal-size p2) 13)
    (unused p3)
    (= (goal-size p3) 15)
    (unused p4)
    (= (goal-size p4) 9)
    (= (board-size b0) 45)
    (wood b0 cherry)
    (surface-condition b0 rough)
    (available b0)
  )
  (:goal
    (and
      (available p0)
      (colour p0 green)
      (treatment p0 varnished)
      (available p1)
      (colour p1 natural)
      (wood p1 cherry)
      (surface-condition p1 verysmooth)
      (treatment p1 glazed)
      (available p2)
      (colour p2 red)
      (treatment p2 glazed)
      (available p3)
      (colour p3 red)
      (wood p3 cherry)
      (surface-condition p3 verysmooth)
      (available p4)
      (colour p4 red)
      (treatment p4 varnished)
    )
  )
  (:metric minimize (total-time))
)
