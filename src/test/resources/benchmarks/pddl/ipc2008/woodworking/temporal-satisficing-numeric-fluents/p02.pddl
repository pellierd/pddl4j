; woodworking sawing task with 4 parts
; Machines:
;   1 highspeed-saw
;   1 saw
; random seed: 833250

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    highspeed-saw0 - highspeed-saw
    saw0 - saw
    black white red - acolour
    walnut teak - awood
    p0 p1 p2 p3 - part
    b0 b1 - board
  )
  (:init
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 15)
    (unused p1)
    (= (goal-size p1) 9)
    (unused p2)
    (= (goal-size p2) 7)
    (unused p3)
    (= (goal-size p3) 8)
    (= (board-size b0) 16)
    (wood b0 teak)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 23)
    (wood b1 walnut)
    (surface-condition b1 rough)
    (available b1)
  )
  (:goal
    (and
      (available p0)
      (available p1)
      (wood p1 teak)
      (available p2)
      (available p3)
      (wood p3 walnut)
    )
  )
  (:metric minimize (total-time))
)
