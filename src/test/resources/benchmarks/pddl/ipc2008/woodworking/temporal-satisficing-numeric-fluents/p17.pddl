; woodworking painting task with 9 parts
; Machines:
;   1 grinder
;   2 glazer
;   1 immersion-varnisher
;   1 planer
;   1 highspeed-saw
;   2 spray-varnisher
;   1 saw
; random seed: 661293

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
    black white red green blue mauve - acolour
    mahogany teak - awood
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
    (idle glazer0)
    (has-colour glazer0 blue)
    (idle glazer1)
    (has-colour glazer1 mauve)
    (has-colour glazer1 white)
    (has-colour glazer1 black)
    (has-colour glazer1 green)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 blue)
    (has-colour immersion-varnisher0 mauve)
    (has-colour immersion-varnisher0 white)
    (has-colour immersion-varnisher0 black)
    (has-colour immersion-varnisher0 green)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 blue)
    (has-colour spray-varnisher0 mauve)
    (has-colour spray-varnisher0 green)
    (idle spray-varnisher1)
    (has-colour spray-varnisher1 white)
    (has-colour spray-varnisher1 black)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 14)
    (unused p1)
    (= (goal-size p1) 10)
    (available p2)
    (colour p2 green)
    (wood p2 mahogany)
    (surface-condition p2 verysmooth)
    (treatment p2 varnished)
    (= (goal-size p2) 8)
    (unused p3)
    (= (goal-size p3) 5)
    (unused p4)
    (= (goal-size p4) 13)
    (unused p5)
    (= (goal-size p5) 10)
    (unused p6)
    (= (goal-size p6) 15)
    (unused p7)
    (= (goal-size p7) 6)
    (unused p8)
    (= (goal-size p8) 5)
    (= (board-size b0) 12)
    (wood b0 teak)
    (surface-condition b0 smooth)
    (available b0)
    (= (board-size b1) 52)
    (wood b1 mahogany)
    (surface-condition b1 rough)
    (available b1)
    (= (board-size b2) 30)
    (wood b2 mahogany)
    (surface-condition b2 rough)
    (available b2)
  )
  (:goal
    (and
      (available p0)
      (colour p0 mauve)
      (available p1)
      (colour p1 white)
      (available p2)
      (colour p2 black)
      (available p3)
      (colour p3 white)
      (available p4)
      (colour p4 blue)
      (available p5)
      (colour p5 black)
      (available p6)
      (colour p6 green)
      (available p7)
      (colour p7 white)
      (available p8)
      (colour p8 white)
    )
  )
  (:metric minimize (total-time))
)
