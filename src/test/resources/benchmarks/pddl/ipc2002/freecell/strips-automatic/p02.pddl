(define (problem FreeCell3-4)
(:domain freecell)
(:objects
	diamond club heart spade - suitsort
	N0 N1 N2 N3 N4 N5 - denomination
	spade3 - card
	club2 - card
	spade2 - card
	clubA - card
	heart3 - card
	heart2 - card
	diamond3 - card
	club3 - card
	diamondA - card
	diamond2 - card
	heartA - card
	spadeA - card
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
	(successor N5 N4)
	(cellspace N2)
	(clear spade3)
	(on spade3 heart2)
	(on heart2 heartA)
	(bottomcol heartA)
	(clear club2)
	(on club2 diamond3)
	(on diamond3 spadeA)
	(bottomcol spadeA)
	(clear spade2)
	(on spade2 club3)
	(bottomcol club3)
	(clear clubA)
	(on clubA diamondA)
	(bottomcol diamondA)
	(clear heart3)
	(on heart3 diamond2)
	(bottomcol diamond2)
	(colspace N0)
	(value spade3 N3)
	(suit spade3 spade)
	(value club2 N2)
	(suit club2 club)
	(canstack club2 diamond3)
	(canstack club2 heart3)
	(value spade2 N2)
	(suit spade2 spade)
	(canstack spade2 diamond3)
	(canstack spade2 heart3)
	(value clubA N1)
	(suit clubA club)
	(canstack clubA diamond2)
	(canstack clubA heart2)
	(value heart3 N3)
	(suit heart3 heart)
	(value heart2 N2)
	(suit heart2 heart)
	(canstack heart2 club3)
	(canstack heart2 spade3)
	(value diamond3 N3)
	(suit diamond3 diamond)
	(value club3 N3)
	(suit club3 club)
	(value diamondA N1)
	(suit diamondA diamond)
	(canstack diamondA club2)
	(canstack diamondA spade2)
	(value diamond2 N2)
	(suit diamond2 diamond)
	(canstack diamond2 club3)
	(canstack diamond2 spade3)
	(value heartA N1)
	(suit heartA heart)
	(canstack heartA club2)
	(canstack heartA spade2)
	(value spadeA N1)
	(suit spadeA spade)
	(canstack spadeA diamond2)
	(canstack spadeA heart2)
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
	(home diamond3)
	(home club3)
	(home heart3)
	(home spade3)
)))
