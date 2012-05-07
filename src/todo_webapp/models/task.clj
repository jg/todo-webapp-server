(ns todo-webapp.models.task)
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
    `(if (not (and ~@(map #(list `contains? `~model %) attributes)))
        (throw (Exception. (str "Model " '~model 
                                " validates presence of attributes: " '~attributes))))))

;; constructor
(defn new [{:keys [title body] :as task}] 
  (validate-presence-of :title :body)
  task
)

;; (fnew {:title "title" :body "body"})

;; (fnew {:title "title"})


