(ns auto-care.core
  (:require [auto-care.maintenance :as maintenance]))

(println "Maintenance overview:")
(println (maintenance/maintenance-overview maintenance/maintenance-tasks))