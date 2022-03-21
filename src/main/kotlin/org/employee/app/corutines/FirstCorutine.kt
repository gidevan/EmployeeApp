package org.employee.app.corutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        doWorld()
        doWorld1()
    }

    launch { doWorld2() }

    println("Hello")
}

suspend fun doWorld() {
    println("doWorld")
    delay(1000L)
    println("World!")
}

suspend fun doWorld1() {
    println("doWorld1")
    delay(500L)
    println("World_1!")
}

suspend fun doWorld2() {
    println("doWorld2")
    delay(300L)
    println("World_2!")
}


