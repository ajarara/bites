load("@prelude//android:android_toolchain.bzl", "AndroidToolchainInfo")
load("@prelude//java:java_toolchain.bzl", "JavaToolchainInfo")
load("@prelude//java:dex_toolchain.bzl", "DexToolchainInfo")
load("@prelude//kotlin:kotlin_toolchain.bzl", "KotlinToolchainInfo")

android_toolchain = rule(
    impl = lambda ctx: [
        AndroidToolchainInfo()
    ],
    attrs = {},
    is_toolchain_rule = True,
)

java_toolchain = rule(
    impl = lambda ctx: [
        JavaToolchainInfo()
    ],
    attrs = {},
    is_toolchain_rule = True,
)

dex_toolchain = rule(
    impl = lambda ctx: [
        DexToolchainInfo()
    ],
    attrs = {},
    is_toolchain_rule = True,
)

kotlin_toolchain = rule(
    impl = lambda ctx: [
        KotlinToolchainInfo()
    ],
    attrs = {},
    is_toolchain_rule = True,
)
