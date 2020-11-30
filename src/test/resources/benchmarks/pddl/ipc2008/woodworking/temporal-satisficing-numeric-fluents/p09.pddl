; woodworking sawing task with 11 parts
; Machines:
;   3 highspeed-saw
;   1 saw
; random seed: 882284

(define (problem wood-prob)
  (:domain woodworking)
  (:objects
    highspeed-saw0 highspeed-saw1 highspeed-saw2 - highspeed-saw
    saw0 - saw
    black white red green blue mauve - acolour
    mahogany oak teak - awood
    p0 p1 p2 p3 p4 p5 p6 p7 p8 p9 p10 - part
    b0 b1 b2 - board
  )
  (:init
    (idle highspeed-saw0)
    (empty highspeed-saw0)
    (idle highspeed-saw1)
    (empty highspeed-saw1)
    (idle highspeed-saw2)
    (empty highspeed-saw2)
    (idle saw0)
    (unused p0)
    (= (goal-size p0) 8)
    (unused p1)
    (= (goal-size p1) 11)
    (unused p2)
    (= (goal-size p2) 15)
    (unused p3)
    (= (goal-size p3) 14)
    (unused p4)
    (= (goal-size p4) 11)
    (unused p5)
    (= (goal-size p5) 8)
    (unused p6)
    (= (goal-size p6) 11)
    (unused p7)
    (= (goal-size p7) 6)
    (unused p8)
    (= (goal-size p8) 8)
    (unused p9)
    (= (goal-size p9) 14)
    (unused p10)
    (= (goal-size p10) 7)
    (= (board-size b0) 27)
    (wood b0 teak)
    (surface-condition b0 rough)
    (available b0)
    (= (board-size b1) 47)
    (wood b1 mahogany)
    (surface-condition b1 rough)
    (available b1)
    (= (board-size b2) 39)
    (wood b2 oak)
    (surface-condition b2 rough)
    (available b2)
  )
  (:goal
    (and
      (available p0)
      (available p1)
      (wood p1 mahogany)
      (available p2)
      (wood p2 oak)
      (available p3)
      (wood p3 mahogany)
      (available p4)
      (wood p4 oak)
      (available p5)
      (wood p5 teak)
      (available p6)
      (wood p6 teak)
      (available p7)
      (available p8)
      (wood p8 mahogany)
      (available p9)
      (available p10)
      (wood p10 oak)
    )
  )
  (:metric minimize (total-time))
)
