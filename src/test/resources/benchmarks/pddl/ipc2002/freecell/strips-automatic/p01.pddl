(define (problem FreeCell2-4)
(:domain freecell)
(:objects
	diamond club heart spade - suitsort
	N0 N1 N2 N3 N4 - denomination
	spadeA - card
	diamondA - card
	club2 - card
	heart2 - card
	spade2 - card
	heartA - card
	diamond2 - card
	clubA - card
	diamond0 - card
	club0 - card
	heart0 - card
	spade0 - card
	
)
(:init
	(successor N1 N0)
	(successor N2 N1)
	(successor N3 N2)
	(successor N4 N3)
	(cellspace N2)
	(clear spadeA)
	(on spadeA spade2)
	(bottomcol spade2)
	(clear diamondA)
	(on diamondA heartA)
	(bottomcol heartA)
	(clear club2)
	(on club2 diamond2)
	(bottomcol diamond2)
	(clear heart2)
	(on heart2 clubA)
	(bottomcol clubA)
	(colspace N0)
	(value spadeA N1)
	(suit spadeA spade)
	(canstack spadeA diamond2)
	(canstack spadeA heart2)
	(value diamondA N1)
	(suit diamondA diamond)
	(canstack diamondA club2)
	(canstack diamondA spade2)
	(value club2 N2)
	(suit club2 club)
	(value heart2 N2)
	(suit heart2 heart)
	(value spade2 N2)
	(suit spade2 spade)
	(value heartA N1)
	(suit heartA heart)
	(canstack heartA club2)
	(canstack heartA spade2)
	(value diamond2 N2)
	(suit diamond2 diamond)
	(value clubA N1)
	(suit clubA club)
	(canstack clubA diamond2)
	(canstack clubA heart2)
	(home diamond0)
	(value diamond0 N0)
	(suit diamond0 diamond)
	(home club0)
	(value club0 N0)
	(suit club0 club)
	(home heart0)
	(value heart0 N0)
	(suit heart0 heart)
	(home spade0)
	(value spade0 N0)
	(suit spade0 spade)
)
(:goal (and
	(home diamond2)
	(home club2)
	(home heart2)
	(home spade2)
)))
