; woodworking painting task with 3 parts
; Machines:
;   1 grinder
;   1 glazer
;   2 immersion-varnisher
;   1 planer
;   1 highspeed-saw
;   1 spray-varnisher
;   1 saw
; random seed: 633454

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 - grinder
    glazer0 - glazer
    immersion-varnisher0 immersion-varnisher1 - immersion-varnisher
    planer0 - planer
    highspeed-saw0 - highspeed-saw
    spray-varnisher0 - spray-varnisher
    saw0 - saw
    black white - acolour
    pine mahogany - awood
    p0 p1 p2 - part
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
    (has-colour glazer0 white)
    (has-colour glazer0 black)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 white)
    (idle immersion-varnisher1)
    (has-colour immersion-varnisher1 white)
    (has-colour immersion-varnisher1 black)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 white)
    (has-colour spray-varnisher0 black)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 5)
    (available p1)
    (colour p1 natural)
    (wood p1 mahogany)
    (surface-condition p1 rough)
    (treatment p1 colourfragments)
    (= (goal-size p1) 11)
    (unused p2)
    (= (goal-size p2) 6)
    (= (board-size b0) 6)
    (wood b0 mahogany)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 8)
    (wood b1 pine)
    (surface-condition b1 rough)
    (available b1)
  )
  (:goal
    (and
      (available p0)
      (colour p0 white)
      (available p1)
      (colour p1 white)
      (available p2)
      (colour p2 black)
    )
  )
  (:metric minimize (total-time))
)
