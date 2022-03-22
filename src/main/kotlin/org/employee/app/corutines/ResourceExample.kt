package org.employee.app.corutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

var acquired = 0;
class ResourceExample {
    init {
        acquired++
        println("create: $acquired")
    }
    fun close() {
        println("close: $acquired")
        acquired--
    }
}

fun main() = runBlocking {
    repeat(100_000) { i->
        launch {
            val resourceExample = withTimeout(60L) {
                delay(50L)
                ResourceExample()
            }
            resourceExample.close()

        }
    }
    println("acquired: $acquired")
}
