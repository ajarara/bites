(define-module (manifest)
  #:use-module ((guix licenses) #:prefix license:)
  #:use-module (gnu packages)
  #:use-module (gnu packages compression)
  #:use-module (guix build-system copy)
  #:use-module (guix download)
  #:use-module (guix gexp)
  #:use-module (guix packages)
  #:use-module (guix profiles))

(define kotlin
  (package
    (name "kotlin")
    (version "2.1.10")
    (source
     (origin
       (method url-fetch)
       (uri (string-append
             "https://github.com/JetBrains/kotlin/releases/download/v"
             version
             "/kotlin-compiler-"
             version
             ".zip"))
       (sha256
        (base32
         "1cd6icm3rvnzaqci18y2kp43h9c6j2w5l7c1r0cqx0l9d1iy5sf6"))))
    (build-system copy-build-system)
    (arguments
     (list
      #:install-plan #~'(("bin/" "/bin/")
                         ("lib" "/"))))
    (native-inputs
     (list unzip))
    (synopsis "")
    (description "")
    (home-page "")
    (license license:expat)))
 
(concatenate-manifests
 (list
  (packages->manifest
   (list kotlin))
  (specifications->manifest
   (list "openjdk:jdk" "xdot" "maven" "inotify-tools"))))
