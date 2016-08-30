(ns clojure-crud.core
  (:use [korma.db]
        [korma.core]))

(def credentials {:user "katsura" :db "gintama" :password "elizebethe"})

(defdb gintama (mysql credentials))

(defentity polls)

(defn getAll []
 (select polls))

(defn insert_ [{:keys [name  rank]}]
  (insert polls (values {:name name :rank rank})))

(defn update_ [{:keys [name rank]}]
  ;; if rank or id is already present, don't bother
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




