(ns reichtum.bitstamp.core
  (:require [com.stuartsierra.component :as component]
            [clojure.core.async :refer [go go-loop timeout <! close!]]
            [org.httpkit.client :as http]
            [taoensso.timbre :as timbre]
            [cheshire.core :as json]
            [cuerdas.core :as str]
            [taoensso.encore :as enc]))


(defrecord BitstampAccount [config]
  component/Lifecycle
  (start [component]
    (let [{:keys [account-id account-key account-secret http-url]
           :as   account} (get config :bitstamp/account)
          request-count (atom 0)
          watchdog (go-loop []
                     (reset! request-count 0)
                     (<! (timeout (* 10 60 1000)))
                     (recur))]
      (timbre/info (str/format ""))
      (-> component
          (merge account)
          (assoc :request-count request-count
                 :watchdog watchdog))))
  (stop [{:keys [request-count watchdog] :as component}]
    (close! watchdog)
    (reset! request-count nil)))


(defn create-bitstamp-account []
  (component/using
    (map->BitstampAccount {})
    [:config]))

(create-bitstamp-account {:config "sex"})


(defn ticker [{:keys [http-url] :as account} currency]
  @(http/get (enc/path http-url "ticker" currency)))
