package me.dzikimlecz.common.util

import kotlinx.coroutines.*
import java.time.LocalDate
import java.time.LocalTime

@DelicateCoroutinesApi
actual inline fun runAtFixedRate(
    startDelayMillis: Long,
    delayMillis: Long,
    crossinline action: () -> Unit
): Job = GlobalScope.launch(Dispatchers.Main) {
        delay(startDelayMillis)
        while (isActive) {
            launch { action() }
            delay(delayMillis)
        }
    }

@DelicateCoroutinesApi
actual inline fun runWithFixedDelay(
    startDelayMillis: Long,
    delayMillis: Long,
    crossinline action: () -> Unit
): Job = GlobalScope.launch(Dispatchers.Main) {
    delay(startDelayMillis)
    while (isActive) {
        action()
        delay(delayMillis)
    }
}

@DelicateCoroutinesApi
actual inline fun runAfterDelay(delayMillis: Long, crossinline action: () -> Unit): Job =
    GlobalScope.launch(Dispatchers.Main) {
        delay(delayMillis)
        if (isActive)
            action()
    }
