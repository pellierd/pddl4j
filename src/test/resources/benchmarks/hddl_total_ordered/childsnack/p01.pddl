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

;; child-snack task with 10 children and 0.4 gluten factor
;; constant factor of 1.3
;; random seed: 234324

(define (problem p01)

    (:domain childsnack)

    (:objects
        child1 child2 child3 child4 child5 child6 child7 child8 child9 child10 - child
        bread1 bread2 bread3 bread4 bread5 bread6 bread7 bread8 bread9 bread10 - bread-portion
        content1 content2 content3 content4 content5 content6 content7 content8 content9 content10 - content-portion
        tray1 tray2 tray3 - tray
        table1 table2 table3 - place
        sandw1 sandw2 sandw3 sandw4 sandw5 sandw6 sandw7 sandw8 sandw9 sandw10 sandw11 sandw12 sandw13 - sandwich
    )

  (:htn
        :ordered-subtasks (and
            (t1  (serve child1 ))
            (t2  (serve child2 ))
            (t3  (serve child3 ))
            (t4  (serve child4 ))
            (t5  (serve child5 ))
            (t6  (serve child6 ))
            (t7  (serve child7 ))
            (t8  (serve child8 ))
            (t9  (serve child9 ))
            (t10 (serve child10))
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
        (no_gluten_bread bread2)
        (no_gluten_bread bread9)
        (no_gluten_bread bread4)
        (no_gluten_bread bread8)
        (no_gluten_content content2)
        (no_gluten_content content8)
        (no_gluten_content content4)
        (no_gluten_content content1)
        (allergic_gluten child1)
        (allergic_gluten child10)
        (allergic_gluten child3)
        (allergic_gluten child4)
        (not_allergic_gluten child2)
        (not_allergic_gluten child5)
        (not_allergic_gluten child6)
        (not_allergic_gluten child7)
        (not_allergic_gluten child8)
        (not_allergic_gluten child9)
        (waiting child1 table2)
        (waiting child2 table1)
        (waiting child3 table1)
        (waiting child4 table2)
        (waiting child5 table3)
        (waiting child6 table3)
        (waiting child7 table3)
        (waiting child8 table2)
        (waiting child9 table1)
        (waiting child10 table3)
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
  )
)
