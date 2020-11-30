; woodworking painting task with 7 parts
; Machines:
;   1 grinder
;   2 glazer
;   1 immersion-varnisher
;   1 planer
;   1 highspeed-saw
;   2 spray-varnisher
;   1 saw
; random seed: 723426

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
    black white red green blue - acolour
    walnut mahogany - awood
    p0 p1 p2 p3 p4 p5 p6 - part
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
    (idle glazer0)
    (has-colour glazer0 blue)
    (has-colour glazer0 green)
    (idle glazer1)
    (has-colour glazer1 white)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 blue)
    (has-colour immersion-varnisher0 white)
    (has-colour immersion-varnisher0 green)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 blue)
    (has-colour spray-varnisher0 white)
    (has-colour spray-varnisher0 green)
    (idle spray-varnisher1)
    (has-colour spray-varnisher1 white)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 9)
    (unused p1)
    (= (goal-size p1) 11)
    (unused p2)
    (= (goal-size p2) 9)
    (unused p3)
    (= (goal-size p3) 9)
    (unused p4)
    (= (goal-size p4) 14)
    (unused p5)
    (= (goal-size p5) 14)
    (unused p6)
    (= (goal-size p6) 7)
    (= (board-size b0) 52)
    (wood b0 mahogany)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 28)
    (wood b1 mahogany)
    (surface-condition b1 smooth)
    (available b1)
    (= (board-size b2) 9)
    (wood b2 walnut)
    (surface-condition b2 rough)
    (available b2)
  )
  (:goal
    (and
      (available p0)
      (colour p0 green)
      (available p1)
      (colour p1 blue)
      (available p2)
      (colour p2 white)
      (available p3)
      (colour p3 green)
      (available p4)
      (colour p4 green)
      (available p5)
      (colour p5 blue)
      (available p6)
      (colour p6 green)
    )
  )
  (:metric minimize (total-time))
)
