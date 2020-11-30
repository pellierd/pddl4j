; woodworking painting task with 8 parts
; Machines:
;   1 grinder
;   3 glazer
;   1 immersion-varnisher
;   1 planer
;   1 highspeed-saw
;   2 spray-varnisher
;   1 saw
; random seed: 735694

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 - grinder
    glazer0 glazer1 glazer2 - glazer
    immersion-varnisher0 - immersion-varnisher
    planer0 - planer
    highspeed-saw0 - highspeed-saw
    spray-varnisher0 spray-varnisher1 - spray-varnisher
    saw0 - saw
    black white red green blue mauve - acolour
    walnut pine - awood
    p0 p1 p2 p3 p4 p5 p6 p7 - part
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
    (has-colour glazer1 blue)
    (has-colour glazer1 white)
    (idle glazer2)
    (has-colour glazer2 red)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 blue)
    (has-colour immersion-varnisher0 green)
    (has-colour immersion-varnisher0 white)
    (has-colour immersion-varnisher0 black)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 green)
    (has-colour spray-varnisher0 black)
    (idle spray-varnisher1)
    (has-colour spray-varnisher1 blue)
    (has-colour spray-varnisher1 white)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 8)
    (unused p1)
    (= (goal-size p1) 7)
    (available p2)
    (colour p2 black)
    (wood p2 walnut)
    (surface-condition p2 rough)
    (treatment p2 glazed)
    (= (goal-size p2) 14)
    (unused p3)
    (= (goal-size p3) 6)
    (unused p4)
    (= (goal-size p4) 6)
    (unused p5)
    (= (goal-size p5) 12)
    (unused p6)
    (= (goal-size p6) 8)
    (unused p7)
    (= (goal-size p7) 8)
    (= (board-size b0) 36)
    (wood b0 pine)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 30)
    (wood b1 walnut)
    (surface-condition b1 rough)
    (available b1)
  )
  (:goal
    (and
      (available p0)
      (colour p0 blue)
      (available p1)
      (colour p1 green)
      (available p2)
      (colour p2 blue)
      (available p3)
      (colour p3 black)
      (available p4)
      (colour p4 white)
      (available p5)
      (colour p5 black)
      (available p6)
      (colour p6 white)
      (available p7)
      (colour p7 black)
    )
  )
  (:metric minimize (total-time))
)
