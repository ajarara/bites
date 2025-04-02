load("@prelude//android:android_toolchain.bzl", "AndroidToolchainInfo")
load("@prelude//java:java_toolchain.bzl", "JavaToolchainInfo", "JavaPlatformInfo")
load("@prelude//java:dex_toolchain.bzl", "DexToolchainInfo")
load("@prelude//kotlin:kotlin_toolchain.bzl", "KotlinToolchainInfo")
load("@prelude//java:java_test.bzl", "java_test_impl")
load("@prelude//decls:toolchains_common.bzl", "toolchains_common")
load("@prelude//decls:common.bzl", "buck")

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
            compile_and_package = ctx.attrs.compile_and_package,
            jar_builder = [],
            class_abi_generator = ctx.attrs.class_abi_generator,
            src_root_elements = [],
            src_root_prefixes = [],
            gen_class_to_source_map = ctx.attrs.gen_class_to_source_map,
            global_code_config = {},
            fat_jar = ctx.attrs.fat_jar,
            zip_scrubber = [],
            java = ctx.attrs.java,
            source_level = "21",
            target_level = "21"
        )
    ]
    

java_toolchain = rule(
    impl = _java_toolchain_impl,
    attrs = {
        "compile_and_package": attrs.default_only(
            attrs.exec_dep(providers = [RunInfo], default = "//internal:compile_and_package")),
        "class_abi_generator": attrs.default_only(
            attrs.exec_dep(providers = [RunInfo], default = "//internal:class_abi_generator")),
        "gen_class_to_source_map": attrs.default_only(
            attrs.exec_dep(providers = [RunInfo], default = "//internal:gen_class_to_source_map")),
        "fat_jar": attrs.default_only(
            attrs.exec_dep(providers = [RunInfo], default = "//internal:fat_jar")),
        "java": attrs.default_only(
            attrs.exec_dep(providers = [RunInfo], default = "//internal:java")),
    },
    is_toolchain_rule = True,
)

java_test_toolchain = rule(
    impl = java_test_impl,
    attrs = {
        "_build_only_native_code": attrs.bool(default = False),
        "srcs": attrs.list(attrs.source(), default = []),
        "provided_deps": attrs.list(attrs.source(), default = []),
        "exported_provided_deps": attrs.list(attrs.source(), default = []),
        "exported_deps": attrs.list(attrs.source(), default = []),
        "deps": attrs.list(attrs.source(), default = []),
        "resources": attrs.list(attrs.source(), default = []),
        "resources_root": attrs.option(attrs.source(), default = None),
        "plugins": attrs.list(attrs.dep(), default = []),
        "annotation_processors": attrs.list(attrs.string(), default = []),
        "annotation_processor_params": attrs.list(attrs.string(), default = []),
        "annotation_processor_deps": attrs.list(attrs.dep(), default = []),
        "manifest_file": attrs.option(attrs.source(), default = None),
        "_java_toolchain": toolchains_common.java(),
        "_java_test_toolchain": toolchains_common.java_test(),
        "java_version": attrs.option(attrs.string(), default = None),
        "source": attrs.option(attrs.string(), default = None),
        "target": attrs.option(attrs.string(), default = None),
        "runtime_deps": attrs.list(attrs.dep(), default = []),
        "labels": attrs.list(attrs.string(), default = []),
        "_exec_os_type": buck.exec_os_type_arg(),
    },
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

kotlin_toolchain = rule(
    impl = lambda ctx: [
        DefaultInfo(),
        KotlinToolchainInfo(
            kotlinc_protocol = "classic",
            compile_kotlin = ctx.attrs.compile_kotlin,
            kotlinc = ctx.attrs.kotlinc,
            kotlin_stdlib = ctx.attrs.kotlin_stdlib,
        ),
        
    ],
    attrs = {
        "compile_kotlin": attrs.default_only(
            attrs.exec_dep(providers = [RunInfo], default = "//internal:compile_kotlin")
        ),
        "kotlinc": attrs.default_only(
            attrs.exec_dep(providers = [RunInfo], default = "//internal:kotlinc")
        ),
        "kotlin_stdlib": attrs.default_only(
            attrs.exec_dep(providers = [RunInfo], default = "//internal:kotlin_stdlib")
        ),
    },
    is_toolchain_rule = True,
)
