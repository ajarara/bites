maven_jar(
    name = "kotlin-stdlib",
    id = "org.jetbrains.kotlin:kotlin-stdlib:2.1.20",
    visibility = ["PUBLIC"]
)

maven_jar(
    name = "junit",
    id = "junit:junit:4.13.2",
    visibility = ["PUBLIC"],
)

maven_jar(
    name = "jakarta-api",
    id = "jakarta.annotation:jakarta.annotation-api:3.0.0",
    visibility = ["PUBLIC"],
)

maven_jar(
    name = "kotlinx-coroutines-core",
    id = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2",
    visibility = ["PUBLIC"],
)

java_binary(
    name = "MyGreatApp"
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

