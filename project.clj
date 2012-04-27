(defproject todo-webapp "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [
    [org.clojure/clojure "1.3.0"]
    [noir "1.2.1"]
    [cheshire "2.2.0"]
    [congomongo "0.1.8"]
    [clj-json "0.5.0"]
    [clj-stacktrace "0.2.4"]
                ]
  :repl-init todo-webapp.models.task
  :test-path "src/tests/"
  :main todo-webapp.core)
