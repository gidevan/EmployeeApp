package org.employee.app.corutines

import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull


fun main() {
    nonCancellableJob()
    //withTimeoutExample()
    withTimeoutExample1()
}

fun nonCancellableJob() = runBlocking{
    val job = launch {
        try {
            repeat(1000) { i->
                println("nonCancellableJob: $i")
                delay(1000L)
            }
        } finally {
            withContext(NonCancellable) {
                println("job: finally bloc")
                delay(1000L)
                println("after delayed")
            }
        }
    }
    delay(1400L)
    println("main: cancel")
    job.cancelAndJoin()
    println("finish non-cancellable")
}

fun withTimeoutExample() = runBlocking {
    val result = withTimeout(1300L) {
        repeat(1000) { i->
            println("withTimeout: $i")
            delay(500L)
        }
    }
    println("resultWithTimeout: $result")
}

fun withTimeoutExample1() = runBlocking {
    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i->
            println("withTimeout: $i")
            delay(500L)
        }
    }
    println("resultWithTimeoutOrNull: $result")
}
