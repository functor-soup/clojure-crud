(ns clojure-crud.core
  (:use [korma.db]
        [korma.core]))

(def credentials {:user "katsura" :db "gintama" :password "elizebethe"})

(defdb gintama (mysql credentials))

(defentity polls)

(select polls)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
