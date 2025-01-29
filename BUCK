# A list of available rules and their signatures can be found here: https://buck2.build/docs/prelude/globals/

# genrule(
#     name = "hello_world",
#     out = "out.txt",
#     cmd = "echo BUILT BY BUCK2> $OUT",
# )

java_binary(
    name = "MyGreatApp",
    main_class = "io.ajarara.example.Example",
    deps = [
        "//java/io/ajarara/example:example",
    ])