(ns auto-care.maintenance-test
  (:require [clojure.test :refer :all]
            [auto-care.maintenance :as maintenance]))

(deftest task-due-test
  (testing "A maintenance task is due when the interval is reached"
    (is (true? (maintenance/task-due?
                 {:km-since-service 10000
                  :interval 10000}))))

  (testing "A maintenance task is not due before the interval"
    (is (false? (maintenance/task-due?
                  {:km-since-service 2000
                   :interval 10000})))))
