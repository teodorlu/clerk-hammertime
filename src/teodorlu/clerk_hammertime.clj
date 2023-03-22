(ns teodorlu.clerk-hammertime)

(defn youtube-embed [youtube-id]
  (let [default-size {:width 560 :height 315}
        teodor-preferred-size (let [w 756]
                                {:width w :height (* (/ w (:width default-size)) (:height default-size))})]
    [:iframe (merge teodor-preferred-size
                    {:src (str "https://www.youtube.com/embed/" youtube-id)
                     :title "YouTube video player" :frameborder 0
                     :allow "accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                     :allowfullscreen true})]))
