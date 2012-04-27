(ns todo-webapp.test.core
  (:use [todo-webapp.core])
  (:use [noir.response :as resp])
  (:use [noir.util.test])
  (:use [clj-json.core :as json])
  (:use [clojure.test]))

(deftest main-test
  (testing "POST /tasks"
    (->
      (send-request [:post "/tasks"] {"text" "wash dishes"})
      (has-status 200)
      (has-content-type (content-types :json))
      (has-body
        (json/generate-string
          {:text "wash dishes" 
           :url "http://example.com"
          }))))

  (testing "GET /tasks"
    (send-request [:post "/tasks"] {"text" "task-description"})
    (->
      (send-request [:get "/tasks"] {})
      (has-status 200)
      (has-content-type (content-types :json))
      (has-body
        (json/generate-string
          "stuff")))
)
