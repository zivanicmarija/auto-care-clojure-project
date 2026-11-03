(ns auto-care.maintenance)

;; MAINTENANCE DATA:

(def maintenance-tasks
  [{:name "Oil change"
    :km-since-service 2000
    :interval 10000
    :action "Replace engine oil and oil filter."
    :responsibility "User or mechanic"}

   {:name "Tire inspection"
    :km-since-service 6000
    :interval 5000
    :action "Check tire pressure and tire condition."
    :responsibility "User"}

   {:name "Brake inspection"
    :km-since-service 3000
    :interval 10000
    :action "Have the braking system inspected by a mechanic."
    :responsibility "Mechanic"}])


;; MAINTENANCE FUNCTIONS:

(defn task-due? [task]
  (>= (:km-since-service task)
      (:interval task)))

(defn km-remaining [task]
  (- (:interval task)
     (:km-since-service task)))

(defn task-message [task]
  (let [remaining (km-remaining task)]
    (if (task-due? task)
      (if (zero? remaining)
        "Maintenance is due now."
        (str "Maintenance is overdue by " (- remaining) "km."))
      (str "Maintenance is due in: " remaining "km."))))

;; Returns only maintenance tasks that are due
(defn due-tasks [tasks]
  (filter task-due? tasks))

;; Checks whether at least one maintenance task is due
(defn any-due? [tasks]
  (some task-due? tasks))

(defn sort-tasks [tasks]
  (sort-by km-remaining tasks))

(defn task-summary [tasks]
  (map (fn [task]
         {:name (:name task)
          :message (task-message task)
          :action (:action task)
          :responsibility (:responsibility task)})
       tasks))

(def sorted-task-summary
  (comp task-summary sort-tasks))

(defn maintenance-overview [tasks]
  {:total-tasks (count tasks)
   :due-count (count (due-tasks tasks))
   :tasks (sorted-task-summary tasks)})