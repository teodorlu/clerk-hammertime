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

(defn xyplot [xyvalues]
  {:data {:values (for [[x y] xyvalues]
                    {:x x :y y})}
   :encoding {:x {:field :x :type :quantitative}
              :y {:field :y :type :quantitative}}
   :mark :line
   :width 640})

(defn youtube-embed [youtube-id]
  (let [default-size {:width 560 :height 315}
        teodor-preferred-size (let [w 756]
                                {:width w :height (* (/ w (:width default-size)) (:height default-size))})]
    [:iframe (merge teodor-preferred-size
                    {:src (str "https://www.youtube.com/embed/" youtube-id)
                     :title "YouTube video player" :frameborder 0
                     :allow "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                     :allowfullscreen true})]))
