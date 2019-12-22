(ns guess-number.core
  (:gen-class))

(def maximun 0)
(def minimun 0)

(defn is-number?
  "Checking the input is number"
  [number]
  (def isNumber false)
  (try (Integer. number)
       (def isNumber true)
       (catch Exception e
         (println "Can't parse to integer")))
  isNumber
  )

(defn suggestion
  "display suggestion"
  [guess-number random-number]
  (if (> (Integer. guess-number) (Integer. random-number))
    (def maximun guess-number)
    (def minimun guess-number)
    )
  (println (str "You guess number: " guess-number))
  (println (str "The range is between:" minimun " And " maximun))
  )

(defn get-random
"customize the maximum"
[]
(def number (read-line))
(if (is-number? number)
  (do (def nu (Integer. number)))
  (do (println "Not valid number, use default maximum")
      (def nu 100))
  )
(def maximun nu)
(rand-int nu)
)


(defn -main
"Guess the correct number"
[& args]
(println "Please define your maximum:")
(def is-winning false)
(def random-number (get-random))
(while (not is-winning)
  (println "Please guess number:")
  (def guess-number (read-line))
  (if (is-number? guess-number)
    (let [number (Integer. guess-number)]
      (if (= number random-number)
        (do (def is-winning true)
            (println "You Win!!!!"))
        (do (suggestion guess-number random-number))
        )
      )
    (println "Please input the valid number")
    )
  )
)
