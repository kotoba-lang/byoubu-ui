(ns test
  "nbb test entry: `nbb bin/test.cljs` from the repo root. Requires sibling
  checkouts of kotoba-lang/byoubu and kotoba-lang/css (see nbb.edn :paths)."
  (:require [clojure.test :as t]
            [byoubu-ui.core-test]))

(defmethod t/report [:cljs.test/default :end-run-tests] [m]
  (when-not (t/successful? m)
    (js/process.exit 1)))

(t/run-tests 'byoubu-ui.core-test)
