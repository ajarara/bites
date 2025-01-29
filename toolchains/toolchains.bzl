load("@prelude//android:android_toolchain.bzl", "AndroidToolchainInfo")
load("@prelude//java:java_toolchain.bzl", "JavaToolchainInfo", "JavaPlatformInfo")
load("@prelude//java:dex_toolchain.bzl", "DexToolchainInfo")
load("@prelude//kotlin:kotlin_toolchain.bzl", "KotlinToolchainInfo")
# load("@prelude//java/tools:BUCK.v2", "compile_and_package")

android_toolchain = rule(
    impl = lambda ctx: [
        DefaultInfo(),
        AndroidToolchainInfo()
    ],
    attrs = {},
    is_toolchain_rule = True,
)



def _java_toolchain_impl(ctx: AnalysisContext) -> list[Provider]:
    return [
        DefaultInfo(),
        JavaPlatformInfo(),
        JavaToolchainInfo(
            javac = "javac",
            javac_protocol = "classic",
            # provider callable???? the fuck??
            compile_and_package = attrs.dep(providers = [RunInfo], default = "@prelude//java/tools:compile_and_package"),
            source_level = "21",
            target_level = "21"
        )
    ]
    

java_toolchain = rule(
    impl = _java_toolchain_impl,
    attrs = {},
    is_toolchain_rule = True,
)

dex_toolchain = rule(
    impl = lambda ctx: [
        DefaultInfo(),
        DexToolchainInfo()
    ],
    attrs = {},
    is_toolchain_rule = True,
)

# kotlin_toolchain = rule(
#     impl = lambda ctx: [
#         KotlinToolchainInfo()
#     ],
#     attrs = {},
#     is_toolchain_rule = True,
# )
