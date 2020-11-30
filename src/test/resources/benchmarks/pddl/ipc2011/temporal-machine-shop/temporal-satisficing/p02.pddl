(define (problem pfile1)
 (:domain domain-tms-2-3-light)
 (:objects 
 kiln0 - kiln8
 kiln0 - kiln20
 pone0 pone1 pone2 pone3 pone4 pone5 pone6 pone7 pone8 pone9 pone10 pone11 - piecetype1
 ptwo0 ptwo1 ptwo2 ptwo3 ptwo4 ptwo5 ptwo6 ptwo7 ptwo8 ptwo9 ptwo10 ptwo11 ptwo12 ptwo13 ptwo14 ptwo15 ptwo16 ptwo17 - piecetype2
 pthree0 pthree1 pthree2 pthree3 pthree4 pthree5 pthree6 pthree7 pthree8 pthree9 pthree10 pthree11 pthree12 pthree13 pthree14 pthree15 pthree16 pthree17 pthree18 pthree19 pthree20 pthree21 pthree22 pthree23 pthree24 pthree25 pthree26 pthree27 pthree28 pthree29 - piecetype3
)
 (:init 
  (energy)
)
 (:goal
  (and
     (baked-structure pthree25 ptwo0)
     (baked-structure pone9 pthree27)
     (baked-structure pthree1 pthree15)
     (baked-structure ptwo15 pthree10)
     (baked-structure pone8 pthree4)
     (baked-structure pthree12 pthree20)
     (baked-structure ptwo4 pthree13)
     (baked-structure pthree7 pthree17)
     (baked-structure ptwo12 ptwo5)
     (baked-structure pthree2 ptwo7)
     (baked-structure pthree9 ptwo10)
     (baked-structure pthree6 pone0)
     (baked-structure ptwo9 pthree3)
     (baked-structure pthree11 pthree16)
     (baked-structure ptwo11 ptwo16)
     (baked-structure pthree14 pthree18)
     (baked-structure pone2 pthree0)
     (baked-structure pone11 pone5)
     (baked-structure pone6 ptwo17)
     (baked-structure pthree22 pthree26)
     (baked-structure pthree5 pthree21)
     (baked-structure pthree28 ptwo1)
     (baked-structure pthree8 ptwo8)
     (baked-structure pone7 pone3)
     (baked-structure pone1 pthree23)
     (baked-structure ptwo13 ptwo6)
     (baked-structure pone10 pthree24)
     (baked-structure pthree19 pthree29)
     (baked-structure ptwo3 ptwo2)
     (baked-structure pone4 ptwo14)
))
 (:metric minimize (total-time))
)
