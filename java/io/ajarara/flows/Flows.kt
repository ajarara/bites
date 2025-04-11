package io.ajarara.flows

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class Resource {
    private var isOpen = false

    suspend fun open(): String {
        check(!isOpen) { "Resource already open" }
        isOpen = true
        println("Resource opened")
        delay(100) // Simulate some work
        return "Resource data"
    }


    suspend fun close() {
        check(isOpen) { "Resource already closed" }
        isOpen = false
        println("Resource closed")
        delay(100) // Simulate some work

    }
}

fun multicastResourceFlow(): Flow<String> = flow {
    val resource = Resource()
    try {
        val data = resource.open()
        emit(data) // Emit the data
    } finally {
        resource.close()
    }
}.shareIn(CoroutineScope(Dispatchers.IO), SharingStarted.Lazily, replay = 1)



suspend fun main() {
    val resourceFlow = multicastResourceFlow()

    coroutineScope {
        launch {
            println("Collector 1 starts")
            resourceFlow.collect { data ->
                println("Collector 1: $data")

            }
            println("Collector 1 ends")
        }
        launch {
            delay(200) // Introduce delay to simulate concurrent collection
            println("Collector 2 starts")
            resourceFlow.collect { data ->
                println("Collector 2: $data")
            }
            println("Collector 2 ends")
        }



    }


}
