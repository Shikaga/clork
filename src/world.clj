(ns world
  (:use clork))

(defstruct player :location :inventory)

(defstruct item :description)

(defstruct container :description :inventory)

(defstruct room :exits :description :items)


(def *player* :player1)

(def *world* {:rooms {:hall (struct room
                                   {:w :kitchen
                                    :n :study}
                                   "hall"
                                   [:sword])
                     :kitchen (struct room
                                      {:e :hall}
                                      "kitchen")
                     :study (struct room
                                    {:s :hall}
                                    "study")}
             :players {:player1 (struct player :hall [])
                       :player2 (struct player :kitchen [])}
             :items {:sword (struct item "A very pointy sword.")}})


(defn play [command & args]
  (println (apply command *world* *player* args)))
