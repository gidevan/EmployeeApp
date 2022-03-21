package org.employee.app.corutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    doWork()
    doWork1()
    println("Main end")
}

suspend fun doWork() = coroutineScope {
    println("doWork...")
    launch {
        delay(2000L)
        println("first launch")
    }

    launch {
        delay(1000L)
        println("second launch")
    }

    println("DoWork end")
}

suspend fun doWork1() = coroutineScope {
    println("doWork1...")
    launch {
        delay(500L)
        println("first launchdo work1")
    }

    println("DoWork1 end")
}

class CorutineScope {
}
