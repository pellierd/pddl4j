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

(define (problem p02)

    (:domain childsnack)

    (:objects
        child1 - child
        child2 - child
        child3 - child
        child4 - child
        child5 - child
        child6 - child
        child7 - child
        child8 - child
        child9 - child
        child10 - child
        bread1 - bread-portion
        bread2 - bread-portion
        bread3 - bread-portion
        bread4 - bread-portion
        bread5 - bread-portion
        bread6 - bread-portion
        bread7 - bread-portion
        bread8 - bread-portion
        bread9 - bread-portion
        bread10 - bread-portion
        content1 - content-portion
        content2 - content-portion
        content3 - content-portion
        content4 - content-portion
        content5 - content-portion
        content6 - content-portion
        content7 - content-portion
        content8 - content-portion
        content9 - content-portion
        content10 - content-portion
        tray1 - tray
        tray2 - tray
        tray3 - tray
        table1 - place
        table2 - place
        table3 - place
        sandw1 - sandwich
        sandw2 - sandwich
        sandw3 - sandwich
        sandw4 - sandwich
        sandw5 - sandwich
        sandw6 - sandwich
        sandw7 - sandwich
        sandw8 - sandwich
        sandw9 - sandwich
        sandw10 - sandwich
        sandw11 - sandwich
        sandw12 - sandwich
        sandw13 - sandwich
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
        (no_gluten_bread bread6)
        (no_gluten_bread bread2)
        (no_gluten_bread bread8)
        (no_gluten_bread bread7)
        (no_gluten_content content5)
        (no_gluten_content content6)
        (no_gluten_content content2)
        (no_gluten_content content8)
        (allergic_gluten child9)
        (allergic_gluten child2)
        (allergic_gluten child3)
        (allergic_gluten child7)
        (not_allergic_gluten child1)
        (not_allergic_gluten child10)
        (not_allergic_gluten child4)
        (not_allergic_gluten child5)
        (not_allergic_gluten child6)
        (not_allergic_gluten child8)
        (waiting child1 table1)
        (waiting child2 table1)
        (waiting child3 table1)
        (waiting child4 table3)
        (waiting child5 table2)
        (waiting child6 table2)
        (waiting child7 table1)
        (waiting child8 table2)
        (waiting child9 table2)
        (waiting child10 table1)
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
