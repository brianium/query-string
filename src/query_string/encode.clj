(ns query-string.encode
  "Url encoding functions

  Functions in this namespace deal with UTF-8 x-www-form-urlencoded strings"
  (:require [clojure.string :refer [replace]])
  (:refer-clojure :exclude [replace])
  (:import  [java.net URLEncoder]))

(def ^:const default-encoding "UTF-8")

(defn utf8
  "Encodes to x-www-form-urlencoded with a UTF-8 charset"
  [value]
  (URLEncoder/encode value default-encoding))

(defn rfc3986
  "Apply percent encoding via rfc3986 to the given string"
  [value]
  (-> (utf8 value)
      (replace "+" "%20")
      (replace "*" "%2A")
      (replace "%7E" "~")))
