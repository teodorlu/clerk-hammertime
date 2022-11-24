(ns eu.teod.clerk-utils.docs
  (:require [nextjournal.clerk :as clerk]
            [eu.teod.clerk-utils :refer [doc]]))

;; # Documentation

;; ## `eu.teod.clerk-utils/doc`
;;
;; `doc` is like `clojure.repl/doc`, just for Clerk.
;; For example:

(doc map)

(doc juxt)
