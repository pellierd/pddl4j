;;
;; Copyright (c) 2020 by Damien Pellier <Damien.Pellier@imag.fr>.
;;
;; This file is part of PDDL4J library.
;;
;; PDDL4J is free software: you can redistribute it and/or modify
;; it under the terms of the GNU General Public License as published by
;; the Free Software Foundation, either version 3 of the License, or
;; (at your option) any later version.
;;
;; PDDL4J is distributed in the hope that it will be useful,
;; but WITHOUT ANY WARRANTY; without even the implied warranty of
;; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
;; GNU General Public License for more details.
;;
;; You should have received a copy of the GNU General Public License
;; along with PDDL4J.  If not, see <http://www.gnu.org/licenses/>
;;

(define (problem p10)
(:domain childsnack)
(:objects
  child1 child2 child3 child4 child5 child6 child7 child8 child9 child10 child11 child12 child13 child14 child15 - child
  bread1 bread2 bread3 bread4 bread5 bread6 bread7 bread8 bread9 bread10 bread11 bread12 bread13 bread14 bread15 - bread-portion
  content1 content2 content3 content4 content5 content6 content7 content8 content9 content10 content11 content12 content13 content14 content15 - content-portion
  tray1 tray2 tray3 - tray
  table1 table2 table3 - place
  sandw1 sandw2 sandw3 sandw4 sandw5 sandw6 sandw7 sandw8 sandw9 sandw10 sandw11 sandw12 sandw13 sandw14 sandw15 sandw16 sandw17 sandw18 sandw19 sandw20 - sandwich
)
(:htn
  :ordered-subtasks (and
      (serve child1)
      (serve child2)
      (serve child3)
      (serve child4)
      (serve child5)
      (serve child6)
      (serve child7)
      (serve child8)
      (serve child9)
      (serve child10)
      (serve child11)
      (serve child12)
      (serve child13)
      (serve child14)
      (serve child15)
  )
)
(:init
   (at tray1 kitchen)
   (at tray2 kitchen)
   (at tray3 kitchen)
   (at_kitchen_bread bread1)
   (at_kitchen_bread bread2)
   (at_kitchen_bread bread3)
   (at_kitchen_bread bread4)
   (at_kitchen_bread bread5)
   (at_kitchen_bread bread6)
   (at_kitchen_bread bread7)
   (at_kitchen_bread bread8)
   (at_kitchen_bread bread9)
   (at_kitchen_bread bread10)
   (at_kitchen_bread bread11)
   (at_kitchen_bread bread12)
   (at_kitchen_bread bread13)
   (at_kitchen_bread bread14)
   (at_kitchen_bread bread15)
   (at_kitchen_content content1)
   (at_kitchen_content content2)
   (at_kitchen_content content3)
   (at_kitchen_content content4)
   (at_kitchen_content content5)
   (at_kitchen_content content6)
   (at_kitchen_content content7)
   (at_kitchen_content content8)
   (at_kitchen_content content9)
   (at_kitchen_content content10)
   (at_kitchen_content content11)
   (at_kitchen_content content12)
   (at_kitchen_content content13)
   (at_kitchen_content content14)
   (at_kitchen_content content15)
   (no_gluten_bread bread9)
   (no_gluten_bread bread3)
   (no_gluten_bread bread13)
   (no_gluten_bread bread12)
   (no_gluten_bread bread6)
   (no_gluten_bread bread7)
   (no_gluten_content content4)
   (no_gluten_content content15)
   (no_gluten_content content14)
   (no_gluten_content content9)
   (no_gluten_content content3)
   (no_gluten_content content10)
   (allergic_gluten child2)
   (allergic_gluten child11)
   (allergic_gluten child5)
   (allergic_gluten child15)
   (allergic_gluten child10)
   (allergic_gluten child3)
   (not_allergic_gluten child12)
   (not_allergic_gluten child1)
   (not_allergic_gluten child4)
   (not_allergic_gluten child14)
   (not_allergic_gluten child6)
   (not_allergic_gluten child7)
   (not_allergic_gluten child8)
   (not_allergic_gluten child9)
   (not_allergic_gluten child13)
   (waiting child1 table1)
   (waiting child2 table2)
   (waiting child3 table2)
   (waiting child4 table1)
   (waiting child5 table2)
   (waiting child6 table1)
   (waiting child7 table1)
   (waiting child8 table3)
   (waiting child9 table3)
   (waiting child10 table2)
   (waiting child11 table3)
   (waiting child12 table2)
   (waiting child13 table2)
   (waiting child14 table2)
   (waiting child15 table2)
   (not_exist sandw1)
   (not_exist sandw2)
   (not_exist sandw3)
   (not_exist sandw4)
   (not_exist sandw5)
   (not_exist sandw6)
   (not_exist sandw7)
   (not_exist sandw8)
   (not_exist sandw9)
   (not_exist sandw10)
   (not_exist sandw11)
   (not_exist sandw12)
   (not_exist sandw13)
   (not_exist sandw14)
   (not_exist sandw15)
   (not_exist sandw16)
   (not_exist sandw17)
   (not_exist sandw18)
   (not_exist sandw19)
   (not_exist sandw20)
)
)
