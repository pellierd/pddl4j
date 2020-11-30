; woodworking painting task with 5 parts
; Machines:
;   1 grinder
;   2 glazer
;   1 immersion-varnisher
;   1 planer
;   1 highspeed-saw
;   2 spray-varnisher
;   1 saw
; random seed: 283971

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 - grinder
    glazer0 glazer1 - glazer
    immersion-varnisher0 - immersion-varnisher
    planer0 - planer
    highspeed-saw0 - highspeed-saw
    spray-varnisher0 spray-varnisher1 - spray-varnisher
    saw0 - saw
    black white red green - acolour
    pine cherry - awood
    p0 p1 p2 p3 p4 - part
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
    (idle glazer1)
    (has-colour glazer1 white)
    (has-colour glazer1 red)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 white)
    (has-colour immersion-varnisher0 black)
    (has-colour immersion-varnisher0 red)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 white)
    (idle spray-varnisher1)
    (has-colour spray-varnisher1 black)
    (has-colour spray-varnisher1 red)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 12)
    (unused p1)
    (= (goal-size p1) 13)
    (unused p2)
    (= (goal-size p2) 6)
    (unused p3)
    (= (goal-size p3) 5)
    (unused p4)
    (= (goal-size p4) 15)
    (= (board-size b0) 36)
    (wood b0 cherry)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 26)
    (wood b1 pine)
    (surface-condition b1 rough)
    (available b1)
  )
  (:goal
    (and
      (available p0)
      (colour p0 white)
      (available p1)
      (colour p1 black)
      (available p2)
      (colour p2 red)
      (available p3)
      (colour p3 white)
      (available p4)
      (colour p4 red)
    )
  )
  (:metric minimize (total-time))
)
