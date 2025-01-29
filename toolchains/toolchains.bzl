load("@prelude//android:android_toolchain.bzl", "AndroidToolchainInfo")
load("@prelude//java:java_toolchain.bzl", "JavaToolchainInfo", "JavaPlatformInfo")
load("@prelude//java:dex_toolchain.bzl", "DexToolchainInfo")
load("@prelude//kotlin:kotlin_toolchain.bzl", "KotlinToolchainInfo")

def _java_toolchain_impl(ctx: AnalysisContext):
    """ beepis """
    return [
        DefaultInfo(),
        JavaPlatformInfo(),
        JavaToolchainInfo()
    ]

android_toolchain = rule(
    impl = lambda ctx: [
        DefaultInfo(),
        AndroidToolchainInfo()
    ],
    attrs = {},
    is_toolchain_rule = True,
)

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
