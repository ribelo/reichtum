(defproject reichtum "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :main ^:skip-aot reichtum.core
  :jvm-opts ["-server"]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :dependencies [[org.clojure/clojure "1.9.0-alpha17"]
                 [org.clojure/spec.alpha "0.1.123"]
                 [org.clojure/core.async "0.3.443"]
                 [org.clojure/math.combinatorics "0.1.4"]
                 [com.stuartsierra/component "0.3.2"]
                 [com.cognitect/transit-clj "0.8.300"]
                 [com.taoensso/encore "2.92.0"]
                 [cheshire "5.8.0"]
                 [camel-snake-kebab "0.4.0"]
                 [com.taoensso/timbre "4.10.0"]
                 [com.fzakaria/slf4j-timbre "0.3.5"]
                 [org.slf4j/slf4j-api "1.7.25"]
                 [funcool/cuerdas "2.0.3"]
                 [http-kit "2.3.0-alpha2"]
                 [clj-time "0.14.0"]
                 [aero "1.1.2"]
                 [criterium "0.4.4"]])
