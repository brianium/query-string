# query-string

[![Clojars Project](https://img.shields.io/clojars/v/query-string.svg)](https://clojars.org/query-string)

Functions for working with query-strings in Clojure

## Installation

Add the following dependency to your `project.clj` file:

```
[query-string "0.1.0"]
```

## Usage

```clojure
(ns my.app
  (:require [query-string.core :refer [create]]
            [query-string.encode :refer [rfc3986]]))

(def default-encoded (create {:name "the günter"}))
;; > "name=the+g%C3%BCnter"

(def percent-encoded (create {:name "the günter"} rfc3986))
;; > "name=the%20g%C3%BCnter"
```

## License

Copyright © 2016 Brian Scaturro

Distributed under the Eclipse Public License, the same as Clojure
