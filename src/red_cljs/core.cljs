(ns red-cljs.core)

(defn onInput [msg node]
  (set! (.-payload msg) (.. msg -payload toLowerCase))
  (.send node msg))

(defn node [red]
  (defn CljsTemplate [config]
    (this-as node
      (.. red -nodes (createNode node config))
      (.on node "input" #(onInput % node))))

  (.. red -nodes (registerType "red-cljs" CljsTemplate)))
