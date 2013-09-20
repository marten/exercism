(ns bob)
(use '[clojure.string :only (upper-case trim)])

(def responses
  {:silence "Fine. Be that way!"
   :shout "Woah, chill out!"
   :question "Sure."
   :other "Whatever."})

(defn message-type [message]
  (cond
    (empty? (trim message))          :silence
    (= (upper-case message) message) :shout
    (= (last message) \?)            :question
    :else                            :other))

(defn response-for [message]
  ((message-type message) responses))