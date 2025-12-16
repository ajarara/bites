(define-module (manifest)
  #:use-module ((guix licenses) #:prefix license:)
  #:use-module (gnu packages)
  #:use-module (gnu packages compression)
  #:use-module (guix build-system copy)
  #:use-module (nonguix build-system binary)
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

;; this needs us to package graalvm, so we're going to use the binary for now
(define mvnd
  (package
    (name "mvnd")
    (version "1.0.2")
    (source
     (origin
       (method url-fetch)
       (uri (string-append
             "https://downloads.apache.org/maven/mvnd/"
             version
             "/maven-mvnd-"
             version
             "-linux-amd64.zip"))
       (sha256
        (base32
         "0krc49jfz2yqawzinncplxgrcd75905xp2yy72pya27mcm2yqd35"))))
    (build-system binary-build-system)
    (arguments
     ;; set interpreter, everything else is static
     `(#:patchelf-plan '(("bin/mvnd"))))
    (native-inputs
     (list unzip))
    (synopsis "")
    (description "")
    (home-page "")
    ;; gpl but for now who cares
    (license license:expat)))
     
 
(concatenate-manifests
 (list
  (packages->manifest
   (list kotlin mvnd))
  (specifications->manifest
   (list "openjdk@21:jdk" "xdot" "maven" "inotify-tools"))))
