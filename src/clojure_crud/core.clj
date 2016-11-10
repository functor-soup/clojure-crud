(ns clojure-crud.core
  (:refer-clojure :exclude [update])
  (:require [korma.db :refer [defdb mysql]]
            [korma.core :refer [insert select where update defentity]]))

(def ^:private credentials {:user "katsura" :db "gintama" :password "elizebethe"})

(defdb gintama (mysql credentials))

(defentity polls)

(defn getAll []
 (select polls))

(defn insert_ [{:keys [name  rank]}]
  (insert polls (values {:name name :rank rank})))

(defn update_ [{:keys [name rank]}]
  (if (empty? (select polls (where {:name [= name]})))
    (insert_ {:name name :rank rank})
    (update polls
            (set-fields {:rank rank})
            (where {:name [= name]}))))

(defn delete_ [name]
  (if (empty? (select polls (where {:name [= name]})))
    {:error "Name does not exist in db"}
    (delete polls
            (where {:name [= name]}))))
