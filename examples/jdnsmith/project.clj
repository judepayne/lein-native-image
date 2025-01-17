(defproject jdnsmith "0.1.0-SNAPSHOT"
  :plugins [[io.taylorwood/lein-native-image "0.3.0"]]
  :jvm-opts ["-Dclojure.compiler.direct-linking=true"]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/data.json "0.2.6"]]
  :main jdnsmith.core
  :target-path "target/%s"
  :native-image {:graal-bin :env/GRAALVM_HOME
                 :opts ["--verbose"
                        "--report-unsupported-elements-at-runtime"
                        "--initialize-at-build-time"]
                 :name "jdn"}
  :profiles {:dev {:global-vars {*warn-on-reflection* true
                                 *assert* true}}
             :uberjar {:aot :all
                       :native-image {:jvm-opts ["-Dclojure.compiler.direct-linking=true"]
                                      :graal-bin :env/GRAALVM_HOME}}})
