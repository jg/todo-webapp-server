(ns todo-webapp.models.task
  (:require clojure.stacktrace))
;; This is a MODEL class. All db-related stuff should go into the persistence
;; class. Persistence class should operate on basic language structures - let's
;; say hashes
;;
;; Mappings:
;;   * model name -> table name
;;   * hash keys  -> db attribute names
;;   * hash values -> db attribute values


;; (defmacro validate-presence-of
;;   [model & attributes]
;;     `(when (not (and ~@(map #(list `contains? `~model %) attributes)))
;;       (throw (Exception 
;;               (str ~model " validates presence of " 
;;                   (clojure.string/join ", " ~attributes))))))


(defmacro validate-presence-of
  [& attributes]
  (let [model (symbol (last (clojure.string/split (str (ns-name *ns*)) #"\.")))]
    `(if (not (and ~@(map #(list `contains? model %) attributes)))
        (throw (Exception. (str '~model " validates presence of " ~attributes))))))


(macroexpand '(validate-presence-of :title :body))

(defn fnew [{:keys [title body] :as task}] 
  (validate-presence-of task :title :body))

;; (fnew {:title "title" :body "body"})

;; (fnew {:title "title"})


