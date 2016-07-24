(ns query-string.core-test
  (:require [clojure.test :refer :all]
            [query-string.core :refer :all]
            [query-string.encode :refer [rfc3986]]))

(deftest create-test
  (testing "creating a query string from a map with default encoding"
    (let [params {:name "the güntz" :id 1}
          encoded (create params)]
      (is (= "name=the+g%C3%BCntz&id=1" encoded))))
  (testing "creating a query string with custom encoding"
    (let [params {:name "the güntz"}
          encoded (create params rfc3986)]
      (is (= "name=the%20g%C3%BCntz" encoded)))))
