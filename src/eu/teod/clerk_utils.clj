(ns eu.teod.clerk-utils
  (:require [nextjournal.clerk :as clerk]
            [clojure.string :as str]))

;; ## A pretty doc viewer

(defn doc*
  "Adapted from https://github.com/nextjournal/clerk/blob/e617f081792c32dccd51d1cebb294d08fefa2132/notebooks/doc.clj#L41-L53"
  [v]
  (let [{:keys [ns doc name arglists]} (meta v)]
    (clerk/html
     [:div
      [:br]
      [:strong (str ns "/" name)]
      (when (seq arglists)
        [:div.pt-4
         (clerk/code (str/join "\n" (map (fn [args] (pr-str (concat [name] args)))
                                         arglists)))])
      (when doc
        [:div.mt-4.viewer-markdown.prose
         (clerk/md doc)])])))

(defmacro doc [form]
  `(doc* (var ~form)))

;; Just use it like `clojure.repl/doc`!

(doc map)

(doc juxt)
