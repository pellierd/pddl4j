; woodworking painting task with 6 parts
; Machines:
;   1 grinder
;   2 glazer
;   2 immersion-varnisher
;   1 planer
;   1 highspeed-saw
;   1 spray-varnisher
;   1 saw
; random seed: 794191

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 - grinder
    glazer0 glazer1 - glazer
    immersion-varnisher0 immersion-varnisher1 - immersion-varnisher
    planer0 - planer
    highspeed-saw0 - highspeed-saw
    spray-varnisher0 - spray-varnisher
    saw0 - saw
    black white red green - acolour
    oak cherry - awood
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
    (has-colour glazer0 green)
    (has-colour glazer0 black)
    (idle glazer1)
    (has-colour glazer1 white)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 black)
    (idle immersion-varnisher1)
    (has-colour immersion-varnisher1 green)
    (has-colour immersion-varnisher1 white)
    (has-colour immersion-varnisher1 black)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 green)
    (has-colour spray-varnisher0 white)
    (has-colour spray-varnisher0 black)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 5)
    (unused p1)
    (= (goal-size p1) 6)
    (unused p2)
    (= (goal-size p2) 5)
    (unused p3)
    (= (goal-size p3) 10)
    (unused p4)
    (= (goal-size p4) 11)
    (available p5)
    (colour p5 red)
    (wood p5 cherry)
    (surface-condition p5 verysmooth)
    (treatment p5 colourfragments)
    (= (goal-size p5) 11)
    (= (board-size b0) 38)
    (wood b0 cherry)
    (surface-condition b0 smooth)
    (available b0)
    (= (board-size b1) 8)
    (wood b1 oak)
    (surface-condition b1 rough)
    (available b1)
  )
  (:goal
    (and
      (available p0)
      (colour p0 green)
      (available p1)
      (colour p1 white)
      (available p2)
      (colour p2 black)
      (available p3)
      (colour p3 black)
      (available p4)
      (colour p4 black)
      (available p5)
      (colour p5 green)
    )
  )
  (:metric minimize (total-time))
)
