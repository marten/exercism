(ns bob
  (:require [clojure.string :refer (upper-case blank?)]))

(def responses
  {:silence "Fine. Be that way!"
   :shout "Woah, chill out!"
   :question "Sure."
   :other "Whatever."})

(defn message-type [message]
  (cond
    (blank? message)                 :silence
    (= (upper-case message) message) :shout
    (= (last message) \?)            :question
    :else                            :other))

(defn response-for [message]
  ((message-type message) responses))