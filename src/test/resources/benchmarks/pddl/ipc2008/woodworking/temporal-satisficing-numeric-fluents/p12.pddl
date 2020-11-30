; woodworking painting task with 4 parts
; Machines:
;   1 grinder
;   2 glazer
;   1 immersion-varnisher
;   1 planer
;   1 highspeed-saw
;   3 spray-varnisher
;   1 saw
; random seed: 832285

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    grinder0 - grinder
    glazer0 glazer1 - glazer
    immersion-varnisher0 - immersion-varnisher
    planer0 - planer
    highspeed-saw0 - highspeed-saw
    spray-varnisher0 spray-varnisher1 spray-varnisher2 - spray-varnisher
    saw0 - saw
    black white red - acolour
    beech walnut - awood
    p0 p1 p2 p3 - part
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
    (idle glazer1)
    (has-colour glazer1 black)
    (has-colour glazer1 red)
    (idle immersion-varnisher0)
    (has-colour immersion-varnisher0 white)
    (has-colour immersion-varnisher0 black)
    (has-colour immersion-varnisher0 red)
    (idle planer0)
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle spray-varnisher0)
    (has-colour spray-varnisher0 red)
    (idle spray-varnisher1)
    (has-colour spray-varnisher1 black)
    (idle spray-varnisher2)
    (has-colour spray-varnisher2 white)
    (has-colour spray-varnisher2 black)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 12)
    (available p1)
    (colour p1 red)
    (wood p1 walnut)
    (surface-condition p1 rough)
    (treatment p1 colourfragments)
    (= (goal-size p1) 9)
    (unused p2)
    (= (goal-size p2) 15)
    (available p3)
    (colour p3 red)
    (wood p3 beech)
    (surface-condition p3 rough)
    (treatment p3 varnished)
    (= (goal-size p3) 5)
    (= (board-size b0) 33)
    (wood b0 beech)
    (surface-condition b0 rough)
    (available b0)
  )
  (:goal
    (and
      (available p0)
      (colour p0 red)
      (available p1)
      (colour p1 black)
      (available p2)
      (colour p2 white)
      (available p3)
      (colour p3 white)
    )
  )
  (:metric minimize (total-time))
)
