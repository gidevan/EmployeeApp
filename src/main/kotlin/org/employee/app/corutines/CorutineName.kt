package org.employee.app.corutines

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking



fun main() = runBlocking(CoroutineName("MainThread")) {
    nameCoroutine()
}

fun log(msg: String) = println("[${Thread.currentThread().name}]: $msg")

suspend fun nameCoroutine() = coroutineScope {
    log("Started main coroutine...")
    val v1 = async(CoroutineName("coroutine1")) {
        delay(500)
        log("computing v1...")
        252
    }

    val v2 = async(CoroutineName("coroutine2")) {
        delay(1000)
        log("computing v2...")
        2
    }
    log("v1/v2 = ${v1.await() / v2.await()}")

}
