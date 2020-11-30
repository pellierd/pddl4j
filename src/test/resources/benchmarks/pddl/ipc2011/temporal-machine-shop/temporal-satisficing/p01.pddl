(define (problem pfile0)
 (:domain domain-tms-2-3-light)
 (:objects 
 kiln0 - kiln8
 kiln0 - kiln20
 pone0 pone1 pone2 pone3 pone4 pone5 pone6 pone7 pone8 pone9 - piecetype1
 ptwo0 ptwo1 ptwo2 ptwo3 ptwo4 ptwo5 ptwo6 ptwo7 ptwo8 ptwo9 ptwo10 ptwo11 ptwo12 ptwo13 ptwo14 - piecetype2
 pthree0 pthree1 pthree2 pthree3 pthree4 pthree5 pthree6 pthree7 pthree8 pthree9 pthree10 pthree11 pthree12 pthree13 pthree14 pthree15 pthree16 pthree17 pthree18 pthree19 pthree20 pthree21 pthree22 pthree23 pthree24 - piecetype3
)
 (:init 
  (energy)
)
 (:goal
  (and
     (baked-structure pthree8 ptwo13)
     (baked-structure pthree10 ptwo10)
     (baked-structure pone6 pthree2)
     (baked-structure pone8 ptwo7)
     (baked-structure ptwo9 pthree24)
     (baked-structure pone0 ptwo2)
     (baked-structure pthree15 pthree23)
     (baked-structure pthree0 ptwo8)
     (baked-structure pthree21 pone4)
     (baked-structure pthree22 pthree17)
     (baked-structure pone9 ptwo14)
     (baked-structure pthree1 ptwo4)
     (baked-structure pthree7 pthree16)
     (baked-structure pthree4 pthree19)
     (baked-structure pthree20 pone3)
     (baked-structure pthree6 ptwo6)
     (baked-structure ptwo11 pthree13)
     (baked-structure ptwo1 pone5)
     (baked-structure pthree11 pone7)
     (baked-structure pthree18 ptwo12)
     (baked-structure pthree3 ptwo3)
     (baked-structure ptwo5 ptwo0)
     (baked-structure pthree12 pthree14)
     (baked-structure pthree9 pone2)
     (baked-structure pthree5 pone1)
))
 (:metric minimize (total-time))
)
