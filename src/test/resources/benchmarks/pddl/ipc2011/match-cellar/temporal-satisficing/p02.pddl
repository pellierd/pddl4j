(define (problem pfile1)
 (:domain matchcellar)
 (:objects 
    match0 match1 match2 match3 - match
    fuse0 fuse1 fuse2 fuse3 fuse4 fuse5 fuse6 fuse7 - fuse
)
 (:init 
  (handfree)
  (unused match0)
  (unused match1)
  (unused match2)
  (unused match3)
)
 (:goal
  (and
     (mended fuse0)
     (mended fuse1)
     (mended fuse2)
     (mended fuse3)
     (mended fuse4)
     (mended fuse5)
     (mended fuse6)
     (mended fuse7)
))
 (:metric minimize (total-time))
)
