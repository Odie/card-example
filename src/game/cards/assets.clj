(ns game.cards.assets
  [:require [game.core :refer :all]])

(defn campaign
  "Creates a Campaign with X counters draining Y per-turn.
  Trashes itself when out of counters"
  [counters per-turn])

(def cards
  {"Adonis Campaign"
   (campaign 12 3)})
