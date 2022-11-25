(ns user
  (:require [nextjournal.clerk :as clerk]
            [eu.teod.clerk-utils.config :as config]))

(comment
  ;; start without file watcher, open browser when started
  (clerk/serve! {:browse? true :port config/port})

  (clerk/serve! {:watch-paths ["notebooks" "src"]})

  (clerk/clear-cache!)

  (clerk/halt!)

  )
