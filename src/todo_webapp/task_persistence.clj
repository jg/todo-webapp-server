(ns todo-webapp.task_persistence
  (:use somnium.congomongo)
)

(def mongo-connection
     (make-connection "todo-webapp"
                      :host "127.0.0.1"
                      :port 27017))

(defn db-connect! []
      (set-connection! mongo-connection))


(defn save-task [task]
      (insert! :tasks task))

(defn get-tasks []
      (fetch :tasks :only [:text :date]))
