(define (problem FreeCell4-4)
(:domain freecell)
(:objects
	diamond club heart spade - suitsort
	N0 N1 N2 N3 N4 N5 - denomination
	club3 - card
	diamond2 - card
	heart3 - card
	diamond4 - card
	diamondA - card
	spade3 - card
	clubA - card
	spadeA - card
	diamond3 - card
	spade2 - card
	heart2 - card
	heart4 - card
	heartA - card
	club2 - card
	club4 - card
	spade4 - card
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
	(clear club3)
	(on club3 spade3)
	(on spade3 heart2)
	(on heart2 spade4)
	(bottomcol spade4)
	(clear diamond2)
	(on diamond2 clubA)
	(on clubA heart4)
	(bottomcol heart4)
	(clear heart3)
	(on heart3 spadeA)
	(on spadeA heartA)
	(bottomcol heartA)
	(clear diamond4)
	(on diamond4 diamond3)
	(on diamond3 club2)
	(bottomcol club2)
	(clear diamondA)
	(on diamondA spade2)
	(on spade2 club4)
	(bottomcol club4)
	(colspace N0)
	(value club3 N3)
	(suit club3 club)
	(canstack club3 diamond4)
	(canstack club3 heart4)
	(value diamond2 N2)
	(suit diamond2 diamond)
	(canstack diamond2 club3)
	(canstack diamond2 spade3)
	(value heart3 N3)
	(suit heart3 heart)
	(canstack heart3 club4)
	(canstack heart3 spade4)
	(value diamond4 N4)
	(suit diamond4 diamond)
	(value diamondA N1)
	(suit diamondA diamond)
	(canstack diamondA club2)
	(canstack diamondA spade2)
	(value spade3 N3)
	(suit spade3 spade)
	(canstack spade3 diamond4)
	(canstack spade3 heart4)
	(value clubA N1)
	(suit clubA club)
	(canstack clubA diamond2)
	(canstack clubA heart2)
	(value spadeA N1)
	(suit spadeA spade)
	(canstack spadeA diamond2)
	(canstack spadeA heart2)
	(value diamond3 N3)
	(suit diamond3 diamond)
	(canstack diamond3 club4)
	(canstack diamond3 spade4)
	(value spade2 N2)
	(suit spade2 spade)
	(canstack spade2 diamond3)
	(canstack spade2 heart3)
	(value heart2 N2)
	(suit heart2 heart)
	(canstack heart2 club3)
	(canstack heart2 spade3)
	(value heart4 N4)
	(suit heart4 heart)
	(value heartA N1)
	(suit heartA heart)
	(canstack heartA club2)
	(canstack heartA spade2)
	(value club2 N2)
	(suit club2 club)
	(canstack club2 diamond3)
	(canstack club2 heart3)
	(value club4 N4)
	(suit club4 club)
	(value spade4 N4)
	(suit spade4 spade)
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
	(home diamond4)
	(home club4)
	(home heart4)
	(home spade4)
)))
