(ns auto-care.core)

(def car-mileage 2000)

(def oil-change-interval 10000)

(defn oil-change-needed? [mileage]
  (>= mileage oil-change-interval))

(defn kilometers-until-oil-change [mileage]
  (- oil-change-interval mileage))

(println "Auto-Care maintenance check:")

(if (oil-change-needed? car-mileage)
  (println "Check whether the engine oil needs changing.")
  (println "Kilometers until the next oil change:"
           (kilometers-until-oil-change car-mileage)))
