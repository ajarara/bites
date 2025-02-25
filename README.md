# bites
A playground. Also serves as a working example for kotlin/java toolchains within buck2. These implementations are curiously absent from the open source repo, and have been for a couple years.

The toolchain implementations are not perfect: 
- it doesn't support annotation processing (no source generation step implemented in compile_and_package.sh)
- it doesn't support debugging (there's no class to source map implementation)
- no test toolchain implementation (yet, if I want to incorporate JMH I'll revisit)
- we rely on the jdk and the kotlin compiler being in the path (which may break remote execution)
- we use the compiled artifact instead of a stripped down jar for the ABI (so any change whatsoever causes all transitive dependencies to rebuild)

For the last point, source based ABI generation is referenced quite a lot in the prelude starlark source for java/kotlin but it's not actually hooked into the toolchain yet (as in, we only have post-compilation ABI generation). It would be nice to get something working externally, but I'd probably spend a couple months getting it in upstream-able shape to begin with, look at the requirements for buck1: https://buck.build/concept/java_abis.html . For my needs I can simply take the hit: these simple programs compile instantly.

