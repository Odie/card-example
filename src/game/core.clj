(ns game.core
  (:gen-class)
  (:require [clojure.string :as str]
            [clojure.java.io :as io]
            [clojure.pprint :refer [pprint]]))

(defn is-scored?
  "Checks if the specified card is in the scored area of the specified player."
  [state side card]
  )

(defn has-subtype?
  "Checks if the specified subtype is present in the card."
  [card subtype]
  )

(defn rezzed? [card]
  (:rezzed card))

(defmacro req [& expr]
  )

(defmacro msg [& expr]
  )


(defn load-all-cards []
  ;; Load all clj files under game/cards directory
  (doseq [file (->> (io/file (io/file "src/game/cards"))
                    (file-seq)
                    (filter #(.isFile %)))]
    (load-file (str file))))

(defn unload-all-cards []
  (->> (all-ns)
       (filter #(str/starts-with? % "game.card"))
       (map #(symbol (str %)))
       (map remove-ns)))

(defn reload-all-cards []
  (unload-all-cards)
  (load-all-cards))

(defn get-card-defs []
  (->> (all-ns)
       (filter #(str/starts-with? % "game.cards"))
       (map #(ns-resolve % 'cards))
       (map var-get)
       (apply merge)))

(def card-defs
  (do
    (reload-all-cards)
    (get-card-defs)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (pprint card-defs))

(comment

  (->> (all-ns)
       (filter #(str/starts-with? % "game.card"))
       )

  (->> (all-ns)
       (filter #(str/starts-with? % "game.card"))
       (map #(symbol (str %)))
       (map remove-ns)
       )

  (load-all-cards)

  ;; Load all clj files under game/cards directory
  (doseq [file (->> (io/file (io/file "src/game/cards"))
                    (file-seq)
                    (filter #(.isFile %)))]
    (load-file (str file)))




  (get-card-defs)

  (unload-all-cards)

  (reload-all-cards)

  )
