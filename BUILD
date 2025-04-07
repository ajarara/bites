maven_jar(
    name = "junit",
    id = "junit:junit:4.13.2",
    visibility = ["PUBLIC"],
)

java_binary(
    name = "MyGreatApp",
    main_class = "io.ajarara.example.Example",
    deps = [
        "//java/io/ajarara/example:example",
    ],
)

java_binary(
    name = "Tarjan",
    main_class = "io.ajarara.tarjan.Tarjan",
    deps = [
        "//java/io/ajarara/tarjan:tarjan",
    ],
)

java_binary(
    name = "Heapify",
    main_class = "io.ajarara.tarjan.Heapify",
    deps = [
        "//java/io/ajarara/heapify:heapify",
    ],
)

