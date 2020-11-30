; woodworking sawing task with 7 parts
; Machines:
;   2 highspeed-saw
;   1 saw
; random seed: 104507

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    highspeed-saw0 highspeed-saw1 - highspeed-saw
    saw0 - saw
    black white red green blue - acolour
    teak pine - awood
    p0 p1 p2 p3 p4 p5 p6 - part
    b0 b1 - board
  )
  (:init
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle highspeed-saw1)
    (empty highspeed-saw1)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 10)
    (unused p1)
    (= (goal-size p1) 11)
    (unused p2)
    (= (goal-size p2) 8)
    (unused p3)
    (= (goal-size p3) 5)
    (unused p4)
    (= (goal-size p4) 7)
    (unused p5)
    (= (goal-size p5) 11)
    (unused p6)
    (= (goal-size p6) 5)
    (= (board-size b0) 39)
    (wood b0 teak)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 18)
    (wood b1 pine)
    (surface-condition b1 smooth)
    (available b1)
  )
  (:goal
    (and
      (available p0)
      (available p1)
      (wood p1 teak)
      (available p2)
      (available p3)
      (available p4)
      (available p5)
      (wood p5 teak)
      (available p6)
    )
  )
  (:metric minimize (total-time))
)
