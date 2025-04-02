(use-modules ((guix licenses) #:prefix license:)
             (gnu packages compression)
             (guix build-system copy)
             (guix download)
             (guix gexp)
             (guix packages))

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
      #:install-plan #~'(("bin/kotlin" "/bin/")
                         ("bin/kotlinc" "/bin/")
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
   (list "openjdk:jdk" "xdot"))))
