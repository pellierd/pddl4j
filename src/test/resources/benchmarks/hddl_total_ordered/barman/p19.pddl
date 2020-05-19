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

(define (problem p19)

    (:domain barman)

    (:objects
        shaker1 - shaker
        left right - hand
        shot1 shot2 shot3 shot4 shot5 shot6 shot7 shot8 shot9 shot10 shot11 shot12 shot13 shot14 shot15 - shot
        ingredient1 ingredient2 ingredient3 ingredient4 ingredient5 - ingredient
        cocktail1 cocktail2 cocktail3 cocktail4 cocktail5 cocktail6 cocktail7 cocktail8 cocktail9 cocktail10 cocktail11 - cocktail
        dispenser1 dispenser2 dispenser3 dispenser4 dispenser5 - dispenser
        l0 l1 l2 - level
    )

    (:htn
        :ordered-subtasks (and
            (serve_cocktail shot1 cocktail5)
            (serve_cocktail shot2 cocktail3)
            (serve_cocktail shot3 cocktail8)
            (serve_cocktail shot4 cocktail6)
            (serve_cocktail shot5 cocktail4)
            (serve_cocktail shot6 cocktail10)
            (serve_cocktail shot7 cocktail2)
            (serve_cocktail shot8 cocktail9)
            (serve_cocktail shot9 cocktail11)
            (serve_cocktail shot10 cocktail1)
            (serve_cocktail shot11 cocktail7)
            (serve_shot shot12 ingredient4)
            (serve_cocktail shot13 cocktail11)
            (serve_shot shot14 ingredient4)
        )
    )

    (:init
        (ontable shaker1)
        (ontable shot1)
        (ontable shot2)
        (ontable shot3)
        (ontable shot4)
        (ontable shot5)
        (ontable shot6)
        (ontable shot7)
        (ontable shot8)
        (ontable shot9)
        (ontable shot10)
        (ontable shot11)
        (ontable shot12)
        (ontable shot13)
        (ontable shot14)
        (ontable shot15)
        (dispenses dispenser1 ingredient1)
        (dispenses dispenser2 ingredient2)
        (dispenses dispenser3 ingredient3)
        (dispenses dispenser4 ingredient4)
        (dispenses dispenser5 ingredient5)
        (clean shaker1)
        (clean shot1)
        (clean shot2)
        (clean shot3)
        (clean shot4)
        (clean shot5)
        (clean shot6)
        (clean shot7)
        (clean shot8)
        (clean shot9)
        (clean shot10)
        (clean shot11)
        (clean shot12)
        (clean shot13)
        (clean shot14)
        (clean shot15)
        (empty shaker1)
        (empty shot1)
        (empty shot2)
        (empty shot3)
        (empty shot4)
        (empty shot5)
        (empty shot6)
        (empty shot7)
        (empty shot8)
        (empty shot9)
        (empty shot10)
        (empty shot11)
        (empty shot12)
        (empty shot13)
        (empty shot14)
        (empty shot15)
        (handempty left)
        (handempty right)
        (shaker-empty-level shaker1 l0)
        (shaker-level shaker1 l0)
        (next l0 l1)
        (next l1 l2)
        (cocktail-part1 cocktail1 ingredient2)
        (cocktail-part2 cocktail1 ingredient3)
        (cocktail-part1 cocktail2 ingredient4)
        (cocktail-part2 cocktail2 ingredient3)
        (cocktail-part1 cocktail3 ingredient3)
        (cocktail-part2 cocktail3 ingredient4)
        (cocktail-part1 cocktail4 ingredient1)
        (cocktail-part2 cocktail4 ingredient2)
        (cocktail-part1 cocktail5 ingredient3)
        (cocktail-part2 cocktail5 ingredient2)
        (cocktail-part1 cocktail6 ingredient2)
        (cocktail-part2 cocktail6 ingredient5)
        (cocktail-part1 cocktail7 ingredient2)
        (cocktail-part2 cocktail7 ingredient1)
        (cocktail-part1 cocktail8 ingredient5)
        (cocktail-part2 cocktail8 ingredient4)
        (cocktail-part1 cocktail9 ingredient2)
        (cocktail-part2 cocktail9 ingredient5)
        (cocktail-part1 cocktail10 ingredient5)
        (cocktail-part2 cocktail10 ingredient3)
        (cocktail-part1 cocktail11 ingredient3)
        (cocktail-part2 cocktail11 ingredient4)
    )
 )



