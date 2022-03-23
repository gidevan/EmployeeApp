package org.employee.app.corutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    contextExample()
    suspendCoroutine()
}

suspend fun contextExample() = coroutineScope {
    launch { // context of the parent, main runBlocking coroutine
        println("main runBlocking       : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
        println("Unconfined1            : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
        println("Default1               : I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
        println("Default2               : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
        println("newSingleThreadContext:  I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
        println("Unconfined2            : I'm working in thread ${Thread.currentThread().name}")
    }
}

suspend fun suspendCoroutine() = coroutineScope {
    launch {
        println("Before thread: ${Thread.currentThread().name}")
        delay(500L)
        println("After thread: ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {
        println("Before unconfined thread: ${Thread.currentThread().name}")
        delay(1500L)
        println("After unconfined thread: ${Thread.currentThread().name}")
        delay(500L)
        println("After unconfined1 thread: ${Thread.currentThread().name}")
    }
}

class CoroutineContext {
}
