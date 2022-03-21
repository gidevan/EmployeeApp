package org.employee.app.corutines

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val channel = Channel<String>()
    launch {
        channel.send("Test1")
        channel.send("Test2")
        log("Block A. Channel data is sent")
    }

    launch {
        channel.send("Test3")
        log("Block B. Channel data is sent")
    }

    launch {
        repeat(3) {
            val data = channel.receive()
            log(data)
        }
    }

    launch {
        repeat(3) { i ->
            val data = channel.receive()
            log("$i:data")
        }

    }
    cancellation()
    finallyCancellation()

}

fun cancellation() = runBlocking {
    log("cancellation")
    val job = launch {
        repeat(100) { i->

            log("job: $i")
            delay(500L)
        }
    }
    delay(2300L) // delay a bit
    log("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    job.join() // waits for job's completion
    log("main: Now I can quit.")
}

fun finallyCancellation() = runBlocking {
    val job = launch {
        repeat(100) { i ->
            try {
                log("finally job : $i")
                delay(400L)
            } finally {
                log("finally block: $i ")
            }

        }
    }
    delay(1500L)
    log("finallyCancellation.... stop")
    job.cancelAndJoin()
    log("stop finallyCancellation")
}

fun log(message: Any?) {
    println("[${Thread.currentThread().name}] $message")
}



class ChannelExample {
}
