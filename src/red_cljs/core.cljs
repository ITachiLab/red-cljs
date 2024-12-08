(ns red-cljs.core)

(defn onInput [^js msg node]
  (set! (.-payload msg) (.. msg -payload toLowerCase))
  (.send node msg))

(defn main [^js red]
  (defn CljsTemplate [config]
    (this-as ^js node
      (.. red -nodes (createNode node config))
      (.on node "input" #(onInput % node))))

  (.. red -nodes (registerType "red-cljs" CljsTemplate)))
