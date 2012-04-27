  (ns todo-webapp.core
    (:use noir.core)
    (:require [noir.server :as server])
    (:require [noir.response :as response])
    (:use [cheshire.core])
)

(defpage "/" {}
  (response/json {:title "JSON response!"}))


(defpage [:post "/tasks"] {:keys [text]} 
  (response/json
    {:text text :url "http://example.com"}))

(defpage "/tasks" {} (response/json {:id 12 :title "Hello word"}))

(defn hello []
  "Hello world")

(defn -main [& m]
      (server/start 8080 {:ns 'todo-webapp}))


(defn reload []
  (use 'todo-webapp.core :reload-all)
  (use 'todo-webapp.models.task :reload-all)
  )
