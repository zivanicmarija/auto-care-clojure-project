(ns auto-care.core)

;; MAINTENANCE DATA:

;; Stores maintenance tasks and their recommended service intervals
(def maintenance-tasks
  [{:name "Oil change"
    :kilometers-since-service 2000
    :interval 10000}

   {:name "Tire inspection"
    :kilometers-since-service 6000
    :interval 5000}

   {:name "Brake inspection"
    :kilometers-since-service 3000
    :interval 10000}])


;; MAINTENANCE FUNCTIONS:

;; Checks whether a maintenance task is due
(defn maintenance-due? [task]
  (>= (:kilometers-since-service task)
      (:interval task)))

;; Calculates the remaining kilometers until maintenance is due
(defn kilometers-until-maintenance [task]
  (- (:interval task)
     (:kilometers-since-service task)))

;; Returns a message describing the maintenance status of a task
(defn maintenance-message [task]
  (if (maintenance-due? task)
    "This maintenance task is due."
    (str "Kilometers until maintenance: "
         (kilometers-until-maintenance task))))

;; Returns only maintenance tasks that are due
(defn tasks-due-for-maintenance [tasks]
  (filter maintenance-due? tasks))

;; Sorts maintenance tasks by urgency, from most urgent to least urgent
(defn sort-maintenance-tasks [tasks]
  (sort-by kilometers-until-maintenance tasks))