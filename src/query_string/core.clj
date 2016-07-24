(ns query-string.core
  (:require [clojure.string :refer [join]]
            [query-string.encode :refer [utf8]]))

(def ^:const default-encoding "UTF-8")

(defn- join-pair
  "Join a key value pair with an '=' sign and encode the value"
  [encode [k,v]]
  (str (name k) "=" (encode (str v))))

(defn create
  "Create a query string from a map and an encode function"
  ([params encode]
  (let [join-encoded (partial join-pair encode)]
    (->> (map join-encoded params)
         (join "&"))))
  ([params] (create params utf8)))
