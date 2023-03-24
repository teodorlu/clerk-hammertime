(ns teodorlu.clerk-hammertime.montecarlo
  (:refer-clojure :exclude [range])
  (:require
   [nextjournal.clerk :as clerk]
   [tech.v3.datatype :as d]))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn range [N]
  (d/make-reader :int32 N idx))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn sample [N]
  (.toArray (.doubles (java.util.Random.) N)))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn histogram
  "histogram with automatic buckets, all data is passed to frontend"
  [values]
  (clerk/vl {:data {:values (for [v values] {:x v})}
             :mark :bar
             :encoding {:x {:bin true
                            :field :x}
                        :y {:aggregate :count}}
             :embed/opts {:actions false}}))
