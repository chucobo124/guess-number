(ns guess-number.core-test
  (:require [clojure.test :refer :all]
            [guess-number.core :refer :all]))

;; (deftest main-test
;;   (testing "Should not occur any error when running main"
;;     (-main)))

(deftest is-number-test
  (testing "Should parse the integer if input"
    (is(= true (is-number? "123123")))
    (is(= true (is-number? "123"))))
  (testing "Should return false when parse error"
    (is(= false (is-number? "asdfasdf")))))
