(ns scheduler.core
  (:import (java.util.concurrent Executors TimeUnit)))

(comment
 (repeat-task #(println (System/currentTimeMillis)) 1)
 (shutdown)
)

(def exe (Executors/newSingleThreadScheduledExecutor))

(defn repeat-task
  ([f period] (repeat-task f 0 period))
  ([f init-delay period]
     (.scheduleAtFixedRate exe f (long init-delay) (long period) TimeUnit/MINUTES)))

(defn shutdown []
  (.shutdown exe))