 
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
           - process 
 
           ;; available comunication channels 
 
          forks-0-
          forks-1-
          forks-2-
          forks-3-
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
          forks-__-pidp1__4_-Rfork
          forks-__-pidp1__4_-Wfork
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

  ;; special operations 
 
  ;; queue access operations 
 
;;  (writes philosopher-0 forks-0- forks--pid-Wfork)
;;  (trans-msg forks--pid-Wfork fork)
 
  (reads philosopher-0 forks-0- forks--pid-Rfork)
  (trans-msg forks--pid-Rfork fork)
 
  (reads philosopher-0 forks-1- forks-__-pidp1__4_-Rfork)
  (trans-msg forks-__-pidp1__4_-Rfork fork)
 
  (writes philosopher-0 forks-0- forks--pid-Wfork)
  (trans-msg forks--pid-Wfork fork)
 
  (writes philosopher-0 forks-1- forks-__-pidp1__4_-Wfork)
  (trans-msg forks-__-pidp1__4_-Wfork fork)
 
;;  (writes philosopher-1 forks-1- forks--pid-Wfork)
 
  (reads philosopher-1 forks-1- forks--pid-Rfork)
;;  (trans-msg forks--pid-Rfork fork)
 
  (reads philosopher-1 forks-2- forks-__-pidp1__4_-Rfork)
;;  (trans-msg forks-__-pidp1__4_-Rfork fork)
 
  (writes philosopher-1 forks-1- forks--pid-Wfork)
 
  (writes philosopher-1 forks-2- forks-__-pidp1__4_-Wfork)
;;  (trans-msg forks-__-pidp1__4_-Wfork fork)
 
;;  (writes philosopher-2 forks-2- forks--pid-Wfork)
 
  (reads philosopher-2 forks-2- forks--pid-Rfork)
 
  (reads philosopher-2 forks-3- forks-__-pidp1__4_-Rfork)
 
  (writes philosopher-2 forks-2- forks--pid-Wfork)
 
  (writes philosopher-2 forks-3- forks-__-pidp1__4_-Wfork)
 
;;  (writes philosopher-3 forks-3- forks--pid-Wfork)
 
  (reads philosopher-3 forks-3- forks--pid-Rfork)
 
  (reads philosopher-3 forks-0- forks-__-pidp1__4_-Rfork)
 
  (writes philosopher-3 forks-3- forks--pid-Wfork)
 
  (writes philosopher-3 forks-0- forks-__-pidp1__4_-Wfork)
 
  ;; state transition function: state x trans -> state 
 
  (trans philosopher forks--pid-Wfork state-1 state-6)
  (trans philosopher forks--pid-Rfork state-6 state-3)
  (trans philosopher forks-__-pidp1__4_-Rfork state-3 state-4)
  (trans philosopher forks--pid-Wfork state-4 state-5)
  (trans philosopher forks-__-pidp1__4_-Wfork state-5 state-6)
)
(:goal
 (and
  ;; deadlock, all local processes are blocked 
 
  (blocked philosopher-0)
  (blocked philosopher-1)
  (blocked philosopher-2)
  (blocked philosopher-3)
 )
)
)
