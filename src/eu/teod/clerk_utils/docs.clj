^{:nextjournal.clerk/visibility #{:hide-ns}}
(ns eu.teod.clerk-utils.docs
  (:require [nextjournal.clerk :as clerk]
            [eu.teod.clerk-utils :refer [doc xyplot]]))

;; # Documentation

;; ## `eu.teod.clerk-utils/doc`
;;
;; `doc` is like `clojure.repl/doc`, just for Clerk.
;; For example:

(doc map)

(doc juxt)

;; ## `eu.teod.clerk-utils/xyplot`
;;
;; `xyplot` is a single line plot mechanism.
;; Input: list of [x y] tuples.
;; Output: `clerk/vl`-compatible data.

(clerk/vl (xyplot (for [x (range -10 10.01 0.1)]
                    [x (* x x)])))

(clerk/vl (xyplot (for [x (range -10 10.01 0.1)]
                    [x (* x x x)])))
