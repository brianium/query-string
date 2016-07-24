(ns query-string.encode-test
  (:require [clojure.test :refer :all]
            [query-string.encode :refer :all]))

(deftest utf8-encoding
  (testing "Testing with utf8 encoding"
    (let [value "hello günter"
          encoded (utf8 value)]
      (is (= "hello+g%C3%BCnter" encoded)))))

(deftest rfc3986-encoding
  (testing "Percent encoding via rfc3986"
    (let [value "hello günter"
          encoded (rfc3986 value)]
      (is (= "hello%20g%C3%BCnter" encoded)))))
