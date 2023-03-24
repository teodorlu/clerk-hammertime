(ns teodorlu.clerk-hammertime.montecarlo
  (:refer-clojure :exclude [range])
  (:require
   [tech.v3.datatype :as d]))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn range [N]
  (d/make-reader :int32 N idx))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn sample [N]
  (.toArray (.doubles (java.util.Random.) N)))
