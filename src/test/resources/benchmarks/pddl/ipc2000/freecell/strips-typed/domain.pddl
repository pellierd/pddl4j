;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; FreeCellWorld
;;; Free cell game playing domain
;;;
;;; Originally written by Nolan Andres and Robert HillHouse (CS
;;; 486/686 Final Project) 
;;;
;;; Adapted from TLPLAN to STRIPS. In particular removed all functions
;;; and arithmetic. 
;;;
;;; Description
;;; ------------
;;; Freecell is a solitaire game that comes with Windows.
;;; If you haven't seen it before:
;;;  One has 8 columns of cards, 4 freecells and 4 homecells. The
;;;  cards start in "random" (random according to MS's brain damaged RNG)
;;;  piles in the 8 columns. We can move a card in the following ways: 
;;;  1. we can move any card that is on top of a column to an empty free
;;;     cell. The free cells only take one card each.
;;;  2. we can move any card from a free cell or from top of a column to
;;;  a home cell if that home cell contains a card of the same suit
;;;  and is one lower in value (aces have value 1, Jacks 11, Queens
;;;  12, Kings 13, and to make things more symmetric we start the
;;;  homecells off containing "phone" cards with value 0.
;;;  3. we can move any card from the  top of a column or from a
;;;  freecell to the top of another column if that column currently holds
;;;  a card with an opposite colour suit that has one higher
;;;  value. 
;;;  4. we can move any card from a free cell or on top of a column to a
;;;  new column if there are less than 8 columns.
;;; The aim is to get all of the card home. The problems show quite a
;;; good variety of difficulty. 
;;; With macro-moves  (actions that generate worm-holes in the search
;;; space) and hand-tailored heurisics tlplan is able to solve about
;;; 90% of the randomly generated games. Unfortunately, the
;;; macro-moves need action descriptions that include recursive 
;;; updates...i.e., beyond adl, and the heurisics need functions and
;;; arithmetic also beyond adl.
;;;
;;; However the original version of the domain was done by two
;;; students in my AI class, and without heuristics and marco moves
;;; they were able to solve problems containing reduced number of
;;; cards in each suit. 
;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Cards are represented by the symbols 
;;;		ca, c2, ..., cj, cq, ck. - clubs
;;;		da, d2, ..., dj, dq, dk. - diamonds
;;;		ha, h2, ..., hj, hq, gk. - hearts
;;;		sa, s2, ..., sj, sq, sk. - spaces
;;;		(c0, d0, h0, s0 indicate an empty card of a certain suit).
;;; 
;;; Where:
;;;		c = clubs, d = diamonds, h = hearts, s = spades.
;;;		a = ace, j = jack, q = queen, k = king.
;;;
;;; Static Predicates (In Tlplan these were functions)
;;; 
;;; (value card val)   --- the face value of the card. (1, ..., 13)
;;; (suit card st)     --- the suit of the card. (c, d, h, s)
;;;   e.g., (value ca 1) (suit ca c)
;;; (successor n' n)   --- n' = n+1, for n=0,...,12, n'=1,...,13
;;;                        a cheap and dirty way to avoid using
;;;                        numbers. 
;;;                        Note 0 does not have a predecessor. This
;;;                        serves act as > 0 precondition
;;;
;;;
;;; Dynamic Predicates:
;;;
;;; (on card1 card2)	-- card1 is on card2
;;; (incell card)	--- card is in a freecell.
;;; (clear card)	--- card is clear (i.e., on top of a column).
;;; (cellspace n)	--- there are n free freecells.
;;;                                n = 0, 1, 2, 3, or 4
;;; (colspace n)	--- there are n free columns. n=0,..,8
;;; (home card)		--- card is a top card in a home stack.
;;;			    we use the special (home c0),
;;;			    (home d0), (home h0), (home s0).
;;;			    to indicate that home is empty for a
;;;			    particular suit.
;;; (bottomcol card)	--  card is at the bottom of a stack.
;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (domain freecell)
  (:requirements :strips :typing)  
  (:types card num suit)
  (:predicates (on ?c1 - card ?c2 - card)
	       (incell ?c - card)
	       (clear ?c - card)
	       (cellspace ?n - num)
	       (colspace ?n - num)
	       (home ?c - card)
	       (bottomcol ?c - card)
	       (canstack ?c1 - card ?c2 - card)
	       (suit ?c - card ?s - suit)
	       (value ?c - card ?v - num)
	       (successor ?n1 - num ?n0 - num)
 )

;;; Move card between columns. Two versions dependent on whether or
;;; not we generate a new stack.

  (:action move
	   :parameters (?card ?oldcard ?newcard - card)
	   :precondition (and (clear ?card) 
			      (clear ?newcard)
			      (canstack ?card ?newcard)
			      (on ?card ?oldcard))
	   :effect (and
		    (on ?card ?newcard)
		    (clear ?oldcard)
		    (not (on ?card ?oldcard))
		    (not (clear ?newcard))))

  (:action move-b
	   :parameters (?card ?newcard - card ?cols ?ncols - num)
	   :precondition (and (clear ?card) 
			      (bottomcol ?card)
			      (clear ?newcard)
			      (canstack ?card ?newcard)
			      (colspace ?cols)
			      (successor ?ncols ?cols))
	   :effect (and (on ?card ?newcard)
			(colspace ?ncols)
			(not (bottomcol ?card))
			(not (clear ?newcard))
			(not (colspace ?cols))))

;; Send a card to a freecell. Two versions dependent on whether or not
;; we generate a new stack.

  (:action sendtofree 
	   :parameters (?card ?oldcard - card ?cells ?ncells - num)
	   :precondition (and
			  (clear ?card) 
			  (on ?card ?oldcard)
			  (cellspace ?cells)
			  (successor ?cells ?ncells))
	   :effect (and
		    (incell ?card) 
		    (clear ?oldcard)
		    (cellspace ?ncells)
		    (not (on ?card ?oldcard))
		    (not (clear ?card))
		    (not (cellspace ?cells))))

  (:action sendtofree-b 
	   :parameters (?card - card ?cells ?ncells ?cols ?ncols - num)
	   :precondition (and (clear ?card) 
			      (bottomcol ?card)
			      (cellspace ?cells)
			      (successor ?cells ?ncells)
			      (colspace ?cols)
			      (successor ?ncols ?cols))
	   :effect (and
		    (incell ?card)
		    (colspace ?ncols)
		    (cellspace ?ncells)
		    (not (bottomcol ?card))
		    (not (clear ?card))
		    (not (colspace ?cols))
		    (not (cellspace ?cells))))

;; Send a card a new column

(:action sendtonewcol
	 :parameters (?card ?oldcard - card ?cols ?ncols - num)
	 :precondition (and
			(clear ?card)
			(colspace ?cols)
			(successor ?cols ?ncols)
			(on ?card ?oldcard))
	 :effect (and
		  (bottomcol ?card) 
		  (clear ?oldcard)
		  (colspace ?ncols)
		  (not (on ?card ?oldcard))
		  (not (colspace ?cols))))

;;Send a card home

(:action sendtohome
	 :parameters (?card ?oldcard - card ?suit - suit ?vcard - num
			    ?homecard - card ?vhomecard - num)
	 :precondition (and
			(clear ?card) 
			(on ?card ?oldcard)
			(home ?homecard)
			(suit ?card ?suit)
			(suit ?homecard ?suit)
			(value ?card ?vcard)
			(value ?homecard ?vhomecard)
			(successor ?vcard ?vhomecard))
	 :effect (and (home ?card)
		      (clear ?oldcard)
		      (not (on ?card ?oldcard))
                      (not (home ?homecard))
		      (not (clear ?card))))

(:action sendtohome-b
	 :parameters (?card - card ?suit - suit  ?vcard - num
			    ?homecard - card
			    ?vhomecard - num
			    ?cols ?ncols - num)
	 :precondition (and (clear ?card) 
			    (bottomcol ?card)
			    (home ?homecard)
			    (suit ?card ?suit)
			    (suit ?homecard ?suit)
			    (value ?card ?vcard)
			    (value ?homecard ?vhomecard)
			    (successor ?vcard ?vhomecard)
			    (colspace ?cols)
			    (successor ?ncols ?cols))
	 :effect (and (home ?card)
		      (colspace ?ncols)
		      (not (home ?homecard))
		      (not (clear ?card))
		      (not (bottomcol ?card))
		      (not (colspace ?cols))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Move cards in free cell
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(:action homefromfreecell
	 :parameters (?card - card ?suit - suit ?vcard - num
			    ?homecard - card ?vhomecard - num
			    ?cells ?ncells - num)
    ;;Send a card home from a free cell.
	 :precondition (and 
			(incell ?card)
			(home ?homecard) 
			(suit ?card ?suit)
			(suit ?homecard ?suit)
			(value ?card ?vcard)
			(value ?homecard ?vhomecard)
			(successor ?vcard ?vhomecard)
			(cellspace ?cells)
			(successor ?ncells ?cells))
	 :effect (and
		  (home ?card)
		  (cellspace ?ncells)
		  (not (incell ?card))
		  (not (cellspace ?cells))
		  (not (home ?homecard))))

(:action colfromfreecell
	 :parameters (?card ?newcard -  card ?cells ?ncells - num)
	 :precondition (and  (incell ?card)
			     (clear ?newcard)
			     (canstack ?card ?newcard)
			     (cellspace ?cells)
			     (successor ?ncells ?cells))
	 :effect (and (cellspace ?ncells)
		      (clear ?card)
		      (on ?card ?newcard)
		      (not (incell ?card))
		      (not (cellspace ?cells))
		      (not (clear ?newcard))))

(:action newcolfromfreecell
	 :parameters (?card - card ?cols ?ncols ?cells ?ncells - num)
	 :precondition (and (incell ?card)
			    (colspace ?cols)
			    (cellspace ?cells)
			    (successor ?cols ?ncols)
			    (successor ?ncells ?cells))
	 :effect (and (bottomcol ?card) 
		      (clear ?card)
		      (colspace ?ncols)
		      (cellspace ?ncells)
		      (not (incell ?card))
		      (not (colspace ?cols))
		      (not (cellspace ?cells)))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
