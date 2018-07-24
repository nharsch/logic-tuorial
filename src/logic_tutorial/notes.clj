;; (load "logic_tutorial/tut1")
;; (in-ns 'logic-tutorial.tut1)

;; run works like this
(run* [q] ;; find all vars q
      (membero q [1 2 3]) ;; such that q is a member of [1 2 3]
      (membero q [2 3 4]) ;; and a member of [2 3 4]
      ;; the above expressions are constraints
      ;; and are conjunctive (AND))
      )
;; (2 3)

;; make a db
(db-rel man x)

;; define some men
(def men
 (db
   [man 'Bob]
   [man 'John]))

;; ask who are men
(with-db men
 (run 1 [q] (man q)))
;; (John)

(with-db men
 (run 2 [q] (man q)))
;; (John Bob)

(with-db men
 (run 3 [q] (man q)))
;; (John Bob)

(db-rel fun x)
(def fun-people
 (db
   [fun 'Bob]))
;; nil

;; run*
(with-dbs [men fun-people]
         (run* [q]
           (man q)
           (fun q)))
;; (Bob)

(db-rel woman x)
(def facts
  (db
    [woman 'Lucy]
    [woman 'Mary]))

(db-rel likes x y)

(def facts
  (-> facts
      (db-fact likes 'Bob 'Mary)
      (db-fact likes 'John 'Lucy)))

(with-dbs [men facts (run * [q] (likes 'Bob q))])

;; fresh is like let
