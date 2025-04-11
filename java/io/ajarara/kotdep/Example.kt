package io.ajarara.kotdep

import io.ajarara.javakotdep.JavaKotDep

import kotlin.sequences.sequence

class Example
    
fun main() {
    
    print(sequence<String> {
              yield("Hi")
          }.toList()
    )
}

