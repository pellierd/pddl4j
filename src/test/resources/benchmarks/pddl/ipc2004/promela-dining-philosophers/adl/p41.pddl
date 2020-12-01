 
;; This problem instance specifies a 
;; particular communication protocol 
;; that is compiled from Promela source 
;; (c) Stefan Edelkamp, 2004 
 
(define (problem instance)
(:domain protocol)
(:objects
           ;; available processes 
 
          philosopher-0 
          philosopher-1 
          philosopher-2 
          philosopher-3 
          philosopher-4 
          philosopher-5 
          philosopher-6 
          philosopher-7 
          philosopher-8 
          philosopher-9 
          philosopher-10 
          philosopher-11 
          philosopher-12 
          philosopher-13 
          philosopher-14 
          philosopher-15 
          philosopher-16 
          philosopher-17 
          philosopher-18 
          philosopher-19 
          philosopher-20 
          philosopher-21 
          philosopher-22 
          philosopher-23 
          philosopher-24 
          philosopher-25 
          philosopher-26 
          philosopher-27 
          philosopher-28 
          philosopher-29 
          philosopher-30 
          philosopher-31 
          philosopher-32 
          philosopher-33 
          philosopher-34 
          philosopher-35 
          philosopher-36 
          philosopher-37 
          philosopher-38 
          philosopher-39 
          philosopher-40 
          philosopher-41 
           - process 
 
           ;; available comunication channels 
 
          forks-0-
          forks-1-
          forks-2-
          forks-3-
          forks-4-
          forks-5-
          forks-6-
          forks-7-
          forks-8-
          forks-9-
          forks-10-
          forks-11-
          forks-12-
          forks-13-
          forks-14-
          forks-15-
          forks-16-
          forks-17-
          forks-18-
          forks-19-
          forks-20-
          forks-21-
          forks-22-
          forks-23-
          forks-24-
          forks-25-
          forks-26-
          forks-27-
          forks-28-
          forks-29-
          forks-30-
          forks-31-
          forks-32-
          forks-33-
          forks-34-
          forks-35-
          forks-36-
          forks-37-
          forks-38-
          forks-39-
          forks-40-
          forks-41-
           - queue
 
           ;; available comunication channels types 
 
          queue-1
           - queuetype
 
           ;; available queue cells 
 
          qs-0
           - queue-state
           ;; available message types 
 
          empty
          fork
           - message
 
           ;; available number tags 
 
          zero
          one
           - number
 

           ;; available process types 
 
          philosopher
           - proctype

           ;; possible local states 
 
          state-1
          state-6
          state-3
          state-4
          state-5
           - state

           ;; possible state transitions 
 
          forks--pid-Wfork
          forks--pid-Rfork
          forks-__-pidp1__42_-Rfork
          forks-__-pidp1__42_-Wfork
           - transition
)
(:init
  (queue-next queue-1 qs-0 qs-0)
  (is-not-max queue-1 zero)
  (is-max queue-1 one)

  ;; process declaration: activeness, start state, type 
 
  (pending philosopher-0)
  (at-process philosopher-0 state-1)
  (is-a-process philosopher-0 philosopher)
 
  (pending philosopher-1)
  (at-process philosopher-1 state-1)
  (is-a-process philosopher-1 philosopher)
 
  (pending philosopher-2)
  (at-process philosopher-2 state-1)
  (is-a-process philosopher-2 philosopher)
 
  (pending philosopher-3)
  (at-process philosopher-3 state-1)
  (is-a-process philosopher-3 philosopher)
 
  (pending philosopher-4)
  (at-process philosopher-4 state-1)
  (is-a-process philosopher-4 philosopher)
 
  (pending philosopher-5)
  (at-process philosopher-5 state-1)
  (is-a-process philosopher-5 philosopher)
 
  (pending philosopher-6)
  (at-process philosopher-6 state-1)
  (is-a-process philosopher-6 philosopher)
 
  (pending philosopher-7)
  (at-process philosopher-7 state-1)
  (is-a-process philosopher-7 philosopher)
 
  (pending philosopher-8)
  (at-process philosopher-8 state-1)
  (is-a-process philosopher-8 philosopher)
 
  (pending philosopher-9)
  (at-process philosopher-9 state-1)
  (is-a-process philosopher-9 philosopher)
 
  (pending philosopher-10)
  (at-process philosopher-10 state-1)
  (is-a-process philosopher-10 philosopher)
 
  (pending philosopher-11)
  (at-process philosopher-11 state-1)
  (is-a-process philosopher-11 philosopher)
 
  (pending philosopher-12)
  (at-process philosopher-12 state-1)
  (is-a-process philosopher-12 philosopher)
 
  (pending philosopher-13)
  (at-process philosopher-13 state-1)
  (is-a-process philosopher-13 philosopher)
 
  (pending philosopher-14)
  (at-process philosopher-14 state-1)
  (is-a-process philosopher-14 philosopher)
 
  (pending philosopher-15)
  (at-process philosopher-15 state-1)
  (is-a-process philosopher-15 philosopher)
 
  (pending philosopher-16)
  (at-process philosopher-16 state-1)
  (is-a-process philosopher-16 philosopher)
 
  (pending philosopher-17)
  (at-process philosopher-17 state-1)
  (is-a-process philosopher-17 philosopher)
 
  (pending philosopher-18)
  (at-process philosopher-18 state-1)
  (is-a-process philosopher-18 philosopher)
 
  (pending philosopher-19)
  (at-process philosopher-19 state-1)
  (is-a-process philosopher-19 philosopher)
 
  (pending philosopher-20)
  (at-process philosopher-20 state-1)
  (is-a-process philosopher-20 philosopher)
 
  (pending philosopher-21)
  (at-process philosopher-21 state-1)
  (is-a-process philosopher-21 philosopher)
 
  (pending philosopher-22)
  (at-process philosopher-22 state-1)
  (is-a-process philosopher-22 philosopher)
 
  (pending philosopher-23)
  (at-process philosopher-23 state-1)
  (is-a-process philosopher-23 philosopher)
 
  (pending philosopher-24)
  (at-process philosopher-24 state-1)
  (is-a-process philosopher-24 philosopher)
 
  (pending philosopher-25)
  (at-process philosopher-25 state-1)
  (is-a-process philosopher-25 philosopher)
 
  (pending philosopher-26)
  (at-process philosopher-26 state-1)
  (is-a-process philosopher-26 philosopher)
 
  (pending philosopher-27)
  (at-process philosopher-27 state-1)
  (is-a-process philosopher-27 philosopher)
 
  (pending philosopher-28)
  (at-process philosopher-28 state-1)
  (is-a-process philosopher-28 philosopher)
 
  (pending philosopher-29)
  (at-process philosopher-29 state-1)
  (is-a-process philosopher-29 philosopher)
 
  (pending philosopher-30)
  (at-process philosopher-30 state-1)
  (is-a-process philosopher-30 philosopher)
 
  (pending philosopher-31)
  (at-process philosopher-31 state-1)
  (is-a-process philosopher-31 philosopher)
 
  (pending philosopher-32)
  (at-process philosopher-32 state-1)
  (is-a-process philosopher-32 philosopher)
 
  (pending philosopher-33)
  (at-process philosopher-33 state-1)
  (is-a-process philosopher-33 philosopher)
 
  (pending philosopher-34)
  (at-process philosopher-34 state-1)
  (is-a-process philosopher-34 philosopher)
 
  (pending philosopher-35)
  (at-process philosopher-35 state-1)
  (is-a-process philosopher-35 philosopher)
 
  (pending philosopher-36)
  (at-process philosopher-36 state-1)
  (is-a-process philosopher-36 philosopher)
 
  (pending philosopher-37)
  (at-process philosopher-37 state-1)
  (is-a-process philosopher-37 philosopher)
 
  (pending philosopher-38)
  (at-process philosopher-38 state-1)
  (is-a-process philosopher-38 philosopher)
 
  (pending philosopher-39)
  (at-process philosopher-39 state-1)
  (is-a-process philosopher-39 philosopher)
 
  (pending philosopher-40)
  (at-process philosopher-40 state-1)
  (is-a-process philosopher-40 philosopher)
 
  (pending philosopher-41)
  (at-process philosopher-41 state-1)
  (is-a-process philosopher-41 philosopher)
 
  ;; numerics 
 
  (is-zero zero)
  (dec one zero)
  (inc zero one)
  (is-not-zero one)
  ;; queue configuration 
 
  (is-a-queue forks-0- queue-1)
  (queue-head forks-0- qs-0)
  (queue-tail forks-0- qs-0)
  (queue-head-msg forks-0- empty)
  (queue-size forks-0- zero)
  (settled forks-0-)

  (is-a-queue forks-1- queue-1)
  (queue-head forks-1- qs-0)
  (queue-tail forks-1- qs-0)
  (queue-head-msg forks-1- empty)
  (queue-size forks-1- zero)
  (settled forks-1-)

  (is-a-queue forks-2- queue-1)
  (queue-head forks-2- qs-0)
  (queue-tail forks-2- qs-0)
  (queue-head-msg forks-2- empty)
  (queue-size forks-2- zero)
  (settled forks-2-)

  (is-a-queue forks-3- queue-1)
  (queue-head forks-3- qs-0)
  (queue-tail forks-3- qs-0)
  (queue-head-msg forks-3- empty)
  (queue-size forks-3- zero)
  (settled forks-3-)

  (is-a-queue forks-4- queue-1)
  (queue-head forks-4- qs-0)
  (queue-tail forks-4- qs-0)
  (queue-head-msg forks-4- empty)
  (queue-size forks-4- zero)
  (settled forks-4-)

  (is-a-queue forks-5- queue-1)
  (queue-head forks-5- qs-0)
  (queue-tail forks-5- qs-0)
  (queue-head-msg forks-5- empty)
  (queue-size forks-5- zero)
  (settled forks-5-)

  (is-a-queue forks-6- queue-1)
  (queue-head forks-6- qs-0)
  (queue-tail forks-6- qs-0)
  (queue-head-msg forks-6- empty)
  (queue-size forks-6- zero)
  (settled forks-6-)

  (is-a-queue forks-7- queue-1)
  (queue-head forks-7- qs-0)
  (queue-tail forks-7- qs-0)
  (queue-head-msg forks-7- empty)
  (queue-size forks-7- zero)
  (settled forks-7-)

  (is-a-queue forks-8- queue-1)
  (queue-head forks-8- qs-0)
  (queue-tail forks-8- qs-0)
  (queue-head-msg forks-8- empty)
  (queue-size forks-8- zero)
  (settled forks-8-)

  (is-a-queue forks-9- queue-1)
  (queue-head forks-9- qs-0)
  (queue-tail forks-9- qs-0)
  (queue-head-msg forks-9- empty)
  (queue-size forks-9- zero)
  (settled forks-9-)

  (is-a-queue forks-10- queue-1)
  (queue-head forks-10- qs-0)
  (queue-tail forks-10- qs-0)
  (queue-head-msg forks-10- empty)
  (queue-size forks-10- zero)
  (settled forks-10-)

  (is-a-queue forks-11- queue-1)
  (queue-head forks-11- qs-0)
  (queue-tail forks-11- qs-0)
  (queue-head-msg forks-11- empty)
  (queue-size forks-11- zero)
  (settled forks-11-)

  (is-a-queue forks-12- queue-1)
  (queue-head forks-12- qs-0)
  (queue-tail forks-12- qs-0)
  (queue-head-msg forks-12- empty)
  (queue-size forks-12- zero)
  (settled forks-12-)

  (is-a-queue forks-13- queue-1)
  (queue-head forks-13- qs-0)
  (queue-tail forks-13- qs-0)
  (queue-head-msg forks-13- empty)
  (queue-size forks-13- zero)
  (settled forks-13-)

  (is-a-queue forks-14- queue-1)
  (queue-head forks-14- qs-0)
  (queue-tail forks-14- qs-0)
  (queue-head-msg forks-14- empty)
  (queue-size forks-14- zero)
  (settled forks-14-)

  (is-a-queue forks-15- queue-1)
  (queue-head forks-15- qs-0)
  (queue-tail forks-15- qs-0)
  (queue-head-msg forks-15- empty)
  (queue-size forks-15- zero)
  (settled forks-15-)

  (is-a-queue forks-16- queue-1)
  (queue-head forks-16- qs-0)
  (queue-tail forks-16- qs-0)
  (queue-head-msg forks-16- empty)
  (queue-size forks-16- zero)
  (settled forks-16-)

  (is-a-queue forks-17- queue-1)
  (queue-head forks-17- qs-0)
  (queue-tail forks-17- qs-0)
  (queue-head-msg forks-17- empty)
  (queue-size forks-17- zero)
  (settled forks-17-)

  (is-a-queue forks-18- queue-1)
  (queue-head forks-18- qs-0)
  (queue-tail forks-18- qs-0)
  (queue-head-msg forks-18- empty)
  (queue-size forks-18- zero)
  (settled forks-18-)

  (is-a-queue forks-19- queue-1)
  (queue-head forks-19- qs-0)
  (queue-tail forks-19- qs-0)
  (queue-head-msg forks-19- empty)
  (queue-size forks-19- zero)
  (settled forks-19-)

  (is-a-queue forks-20- queue-1)
  (queue-head forks-20- qs-0)
  (queue-tail forks-20- qs-0)
  (queue-head-msg forks-20- empty)
  (queue-size forks-20- zero)
  (settled forks-20-)

  (is-a-queue forks-21- queue-1)
  (queue-head forks-21- qs-0)
  (queue-tail forks-21- qs-0)
  (queue-head-msg forks-21- empty)
  (queue-size forks-21- zero)
  (settled forks-21-)

  (is-a-queue forks-22- queue-1)
  (queue-head forks-22- qs-0)
  (queue-tail forks-22- qs-0)
  (queue-head-msg forks-22- empty)
  (queue-size forks-22- zero)
  (settled forks-22-)

  (is-a-queue forks-23- queue-1)
  (queue-head forks-23- qs-0)
  (queue-tail forks-23- qs-0)
  (queue-head-msg forks-23- empty)
  (queue-size forks-23- zero)
  (settled forks-23-)

  (is-a-queue forks-24- queue-1)
  (queue-head forks-24- qs-0)
  (queue-tail forks-24- qs-0)
  (queue-head-msg forks-24- empty)
  (queue-size forks-24- zero)
  (settled forks-24-)

  (is-a-queue forks-25- queue-1)
  (queue-head forks-25- qs-0)
  (queue-tail forks-25- qs-0)
  (queue-head-msg forks-25- empty)
  (queue-size forks-25- zero)
  (settled forks-25-)

  (is-a-queue forks-26- queue-1)
  (queue-head forks-26- qs-0)
  (queue-tail forks-26- qs-0)
  (queue-head-msg forks-26- empty)
  (queue-size forks-26- zero)
  (settled forks-26-)

  (is-a-queue forks-27- queue-1)
  (queue-head forks-27- qs-0)
  (queue-tail forks-27- qs-0)
  (queue-head-msg forks-27- empty)
  (queue-size forks-27- zero)
  (settled forks-27-)

  (is-a-queue forks-28- queue-1)
  (queue-head forks-28- qs-0)
  (queue-tail forks-28- qs-0)
  (queue-head-msg forks-28- empty)
  (queue-size forks-28- zero)
  (settled forks-28-)

  (is-a-queue forks-29- queue-1)
  (queue-head forks-29- qs-0)
  (queue-tail forks-29- qs-0)
  (queue-head-msg forks-29- empty)
  (queue-size forks-29- zero)
  (settled forks-29-)

  (is-a-queue forks-30- queue-1)
  (queue-head forks-30- qs-0)
  (queue-tail forks-30- qs-0)
  (queue-head-msg forks-30- empty)
  (queue-size forks-30- zero)
  (settled forks-30-)

  (is-a-queue forks-31- queue-1)
  (queue-head forks-31- qs-0)
  (queue-tail forks-31- qs-0)
  (queue-head-msg forks-31- empty)
  (queue-size forks-31- zero)
  (settled forks-31-)

  (is-a-queue forks-32- queue-1)
  (queue-head forks-32- qs-0)
  (queue-tail forks-32- qs-0)
  (queue-head-msg forks-32- empty)
  (queue-size forks-32- zero)
  (settled forks-32-)

  (is-a-queue forks-33- queue-1)
  (queue-head forks-33- qs-0)
  (queue-tail forks-33- qs-0)
  (queue-head-msg forks-33- empty)
  (queue-size forks-33- zero)
  (settled forks-33-)

  (is-a-queue forks-34- queue-1)
  (queue-head forks-34- qs-0)
  (queue-tail forks-34- qs-0)
  (queue-head-msg forks-34- empty)
  (queue-size forks-34- zero)
  (settled forks-34-)

  (is-a-queue forks-35- queue-1)
  (queue-head forks-35- qs-0)
  (queue-tail forks-35- qs-0)
  (queue-head-msg forks-35- empty)
  (queue-size forks-35- zero)
  (settled forks-35-)

  (is-a-queue forks-36- queue-1)
  (queue-head forks-36- qs-0)
  (queue-tail forks-36- qs-0)
  (queue-head-msg forks-36- empty)
  (queue-size forks-36- zero)
  (settled forks-36-)

  (is-a-queue forks-37- queue-1)
  (queue-head forks-37- qs-0)
  (queue-tail forks-37- qs-0)
  (queue-head-msg forks-37- empty)
  (queue-size forks-37- zero)
  (settled forks-37-)

  (is-a-queue forks-38- queue-1)
  (queue-head forks-38- qs-0)
  (queue-tail forks-38- qs-0)
  (queue-head-msg forks-38- empty)
  (queue-size forks-38- zero)
  (settled forks-38-)

  (is-a-queue forks-39- queue-1)
  (queue-head forks-39- qs-0)
  (queue-tail forks-39- qs-0)
  (queue-head-msg forks-39- empty)
  (queue-size forks-39- zero)
  (settled forks-39-)

  (is-a-queue forks-40- queue-1)
  (queue-head forks-40- qs-0)
  (queue-tail forks-40- qs-0)
  (queue-head-msg forks-40- empty)
  (queue-size forks-40- zero)
  (settled forks-40-)

  (is-a-queue forks-41- queue-1)
  (queue-head forks-41- qs-0)
  (queue-tail forks-41- qs-0)
  (queue-head-msg forks-41- empty)
  (queue-size forks-41- zero)
  (settled forks-41-)

  ;; special operations 
 
  ;; queue access operations 
 
  (writes philosopher-0 forks-0- forks--pid-Wfork)
  (trans-msg forks--pid-Wfork fork)
 
  (reads philosopher-0 forks-0- forks--pid-Rfork)
  (trans-msg forks--pid-Rfork fork)
 
  (reads philosopher-0 forks-1- forks-__-pidp1__42_-Rfork)
  (trans-msg forks-__-pidp1__42_-Rfork fork)
 
 
  (writes philosopher-0 forks-1- forks-__-pidp1__42_-Wfork)
  (trans-msg forks-__-pidp1__42_-Wfork fork)
 
  (writes philosopher-1 forks-1- forks--pid-Wfork)
 
  (reads philosopher-1 forks-1- forks--pid-Rfork)
 
  (reads philosopher-1 forks-2- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-1 forks-2- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-2 forks-2- forks--pid-Wfork)
 
  (reads philosopher-2 forks-2- forks--pid-Rfork)
 
  (reads philosopher-2 forks-3- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-2 forks-3- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-3 forks-3- forks--pid-Wfork)
 
  (reads philosopher-3 forks-3- forks--pid-Rfork)
 
  (reads philosopher-3 forks-4- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-3 forks-4- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-4 forks-4- forks--pid-Wfork)
 
  (reads philosopher-4 forks-4- forks--pid-Rfork)
 
  (reads philosopher-4 forks-5- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-4 forks-5- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-5 forks-5- forks--pid-Wfork)
 
  (reads philosopher-5 forks-5- forks--pid-Rfork)
 
  (reads philosopher-5 forks-6- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-5 forks-6- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-6 forks-6- forks--pid-Wfork)
 
  (reads philosopher-6 forks-6- forks--pid-Rfork)
 
  (reads philosopher-6 forks-7- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-6 forks-7- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-7 forks-7- forks--pid-Wfork)
 
  (reads philosopher-7 forks-7- forks--pid-Rfork)
 
  (reads philosopher-7 forks-8- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-7 forks-8- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-8 forks-8- forks--pid-Wfork)
 
  (reads philosopher-8 forks-8- forks--pid-Rfork)
 
  (reads philosopher-8 forks-9- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-8 forks-9- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-9 forks-9- forks--pid-Wfork)
 
  (reads philosopher-9 forks-9- forks--pid-Rfork)
 
  (reads philosopher-9 forks-10- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-9 forks-10- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-10 forks-10- forks--pid-Wfork)
 
  (reads philosopher-10 forks-10- forks--pid-Rfork)
 
  (reads philosopher-10 forks-11- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-10 forks-11- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-11 forks-11- forks--pid-Wfork)
 
  (reads philosopher-11 forks-11- forks--pid-Rfork)
 
  (reads philosopher-11 forks-12- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-11 forks-12- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-12 forks-12- forks--pid-Wfork)
 
  (reads philosopher-12 forks-12- forks--pid-Rfork)
 
  (reads philosopher-12 forks-13- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-12 forks-13- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-13 forks-13- forks--pid-Wfork)
 
  (reads philosopher-13 forks-13- forks--pid-Rfork)
 
  (reads philosopher-13 forks-14- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-13 forks-14- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-14 forks-14- forks--pid-Wfork)
 
  (reads philosopher-14 forks-14- forks--pid-Rfork)
 
  (reads philosopher-14 forks-15- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-14 forks-15- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-15 forks-15- forks--pid-Wfork)
 
  (reads philosopher-15 forks-15- forks--pid-Rfork)
 
  (reads philosopher-15 forks-16- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-15 forks-16- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-16 forks-16- forks--pid-Wfork)
 
  (reads philosopher-16 forks-16- forks--pid-Rfork)
 
  (reads philosopher-16 forks-17- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-16 forks-17- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-17 forks-17- forks--pid-Wfork)
 
  (reads philosopher-17 forks-17- forks--pid-Rfork)
 
  (reads philosopher-17 forks-18- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-17 forks-18- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-18 forks-18- forks--pid-Wfork)
 
  (reads philosopher-18 forks-18- forks--pid-Rfork)
 
  (reads philosopher-18 forks-19- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-18 forks-19- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-19 forks-19- forks--pid-Wfork)
 
  (reads philosopher-19 forks-19- forks--pid-Rfork)
 
  (reads philosopher-19 forks-20- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-19 forks-20- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-20 forks-20- forks--pid-Wfork)
 
  (reads philosopher-20 forks-20- forks--pid-Rfork)
 
  (reads philosopher-20 forks-21- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-20 forks-21- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-21 forks-21- forks--pid-Wfork)
 
  (reads philosopher-21 forks-21- forks--pid-Rfork)
 
  (reads philosopher-21 forks-22- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-21 forks-22- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-22 forks-22- forks--pid-Wfork)
 
  (reads philosopher-22 forks-22- forks--pid-Rfork)
 
  (reads philosopher-22 forks-23- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-22 forks-23- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-23 forks-23- forks--pid-Wfork)
 
  (reads philosopher-23 forks-23- forks--pid-Rfork)
 
  (reads philosopher-23 forks-24- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-23 forks-24- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-24 forks-24- forks--pid-Wfork)
 
  (reads philosopher-24 forks-24- forks--pid-Rfork)
 
  (reads philosopher-24 forks-25- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-24 forks-25- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-25 forks-25- forks--pid-Wfork)
 
  (reads philosopher-25 forks-25- forks--pid-Rfork)
 
  (reads philosopher-25 forks-26- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-25 forks-26- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-26 forks-26- forks--pid-Wfork)
 
  (reads philosopher-26 forks-26- forks--pid-Rfork)
 
  (reads philosopher-26 forks-27- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-26 forks-27- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-27 forks-27- forks--pid-Wfork)
 
  (reads philosopher-27 forks-27- forks--pid-Rfork)
 
  (reads philosopher-27 forks-28- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-27 forks-28- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-28 forks-28- forks--pid-Wfork)
 
  (reads philosopher-28 forks-28- forks--pid-Rfork)
 
  (reads philosopher-28 forks-29- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-28 forks-29- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-29 forks-29- forks--pid-Wfork)
 
  (reads philosopher-29 forks-29- forks--pid-Rfork)
 
  (reads philosopher-29 forks-30- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-29 forks-30- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-30 forks-30- forks--pid-Wfork)
 
  (reads philosopher-30 forks-30- forks--pid-Rfork)
 
  (reads philosopher-30 forks-31- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-30 forks-31- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-31 forks-31- forks--pid-Wfork)
 
  (reads philosopher-31 forks-31- forks--pid-Rfork)
 
  (reads philosopher-31 forks-32- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-31 forks-32- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-32 forks-32- forks--pid-Wfork)
 
  (reads philosopher-32 forks-32- forks--pid-Rfork)
 
  (reads philosopher-32 forks-33- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-32 forks-33- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-33 forks-33- forks--pid-Wfork)
 
  (reads philosopher-33 forks-33- forks--pid-Rfork)
 
  (reads philosopher-33 forks-34- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-33 forks-34- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-34 forks-34- forks--pid-Wfork)
 
  (reads philosopher-34 forks-34- forks--pid-Rfork)
 
  (reads philosopher-34 forks-35- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-34 forks-35- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-35 forks-35- forks--pid-Wfork)
 
  (reads philosopher-35 forks-35- forks--pid-Rfork)
 
  (reads philosopher-35 forks-36- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-35 forks-36- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-36 forks-36- forks--pid-Wfork)
 
  (reads philosopher-36 forks-36- forks--pid-Rfork)
 
  (reads philosopher-36 forks-37- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-36 forks-37- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-37 forks-37- forks--pid-Wfork)
 
  (reads philosopher-37 forks-37- forks--pid-Rfork)
 
  (reads philosopher-37 forks-38- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-37 forks-38- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-38 forks-38- forks--pid-Wfork)
 
  (reads philosopher-38 forks-38- forks--pid-Rfork)
 
  (reads philosopher-38 forks-39- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-38 forks-39- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-39 forks-39- forks--pid-Wfork)
 
  (reads philosopher-39 forks-39- forks--pid-Rfork)
 
  (reads philosopher-39 forks-40- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-39 forks-40- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-40 forks-40- forks--pid-Wfork)
 
  (reads philosopher-40 forks-40- forks--pid-Rfork)
 
  (reads philosopher-40 forks-41- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-40 forks-41- forks-__-pidp1__42_-Wfork)
 
  (writes philosopher-41 forks-41- forks--pid-Wfork)
 
  (reads philosopher-41 forks-41- forks--pid-Rfork)
 
  (reads philosopher-41 forks-0- forks-__-pidp1__42_-Rfork)
 
 
  (writes philosopher-41 forks-0- forks-__-pidp1__42_-Wfork)
 
  ;; state transition function: state x trans -> state 
 
  (trans philosopher forks--pid-Wfork state-1 state-6)
  (trans philosopher forks--pid-Rfork state-6 state-3)
  (trans philosopher forks-__-pidp1__42_-Rfork state-3 state-4)
  (trans philosopher forks--pid-Wfork state-4 state-5)
  (trans philosopher forks-__-pidp1__42_-Wfork state-5 state-6)
)
(:goal
 (and
  ;; deadlock, all local processes are blocked 
 
  (blocked philosopher-0)
  (blocked philosopher-1)
  (blocked philosopher-2)
  (blocked philosopher-3)
  (blocked philosopher-4)
  (blocked philosopher-5)
  (blocked philosopher-6)
  (blocked philosopher-7)
  (blocked philosopher-8)
  (blocked philosopher-9)
  (blocked philosopher-10)
  (blocked philosopher-11)
  (blocked philosopher-12)
  (blocked philosopher-13)
  (blocked philosopher-14)
  (blocked philosopher-15)
  (blocked philosopher-16)
  (blocked philosopher-17)
  (blocked philosopher-18)
  (blocked philosopher-19)
  (blocked philosopher-20)
  (blocked philosopher-21)
  (blocked philosopher-22)
  (blocked philosopher-23)
  (blocked philosopher-24)
  (blocked philosopher-25)
  (blocked philosopher-26)
  (blocked philosopher-27)
  (blocked philosopher-28)
  (blocked philosopher-29)
  (blocked philosopher-30)
  (blocked philosopher-31)
  (blocked philosopher-32)
  (blocked philosopher-33)
  (blocked philosopher-34)
  (blocked philosopher-35)
  (blocked philosopher-36)
  (blocked philosopher-37)
  (blocked philosopher-38)
  (blocked philosopher-39)
  (blocked philosopher-40)
  (blocked philosopher-41)
 )
)
)
