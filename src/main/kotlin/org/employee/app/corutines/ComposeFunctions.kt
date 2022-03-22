package org.employee.app.corutines

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    measureExample1()
    measureExample2()
    measureExample3LazyStart()
    callWithException()
}

fun measureExample1() = runBlocking {
    println("Measure time example1")
    val time = measureTimeMillis {
        val data1 = suspendFunction1()
        val data2 = suspendFunction2()
        println("result: ${data1 + data2}")
    }
    println("Completed in [$time] ms")
}

fun measureExample2() = runBlocking {
    println("Measure time example2")
    val time = measureTimeMillis {
        val data1 = async {suspendFunction1()}
        val data2 = async{suspendFunction2()}
        println("result: ${data1.await() + data2.await()}")
    }
    println("Completed in [$time] ms")
}

fun measureExample3LazyStart() = runBlocking {
    println("Measure time example3 (lazy start)")
    val time = measureTimeMillis {
        val data1 = async(start = CoroutineStart.LAZY) {suspendFunction1()}
        val data2 = async(start = CoroutineStart.LAZY){suspendFunction2()}
        data1.start()
        data2.start()
        println("result: ${data1.await() + data2.await()}")
    }
    println("Completed in [$time] ms")
}

fun callWithException() = runBlocking {
    println()
    println("Call with exception...")
    try {
        failedConcurrentSum()
    } catch (e: ArithmeticException) {
        println("Concurrent exception: ${e.message}")
    }
}

suspend fun failedConcurrentSum():Int = coroutineScope {
    val one = async<Int> {
        try {
            delay(Long.MAX_VALUE)
            43
        } finally {
            println("finallyOne")
        }
    }
    val two = async<Int> {
        println("second exception")
        throw ArithmeticException("Two test exception")
    }
    one.await() + two.await()
}


suspend fun suspendFunction1() : Int {
    delay(1000L)
    return 12
}

suspend fun suspendFunction2() : Int {
    delay(1050L)
    return 13
}

class ComposeFunctions {
}
