package me.dzikimlecz.common.util

import kotlinx.coroutines.Job
import java.time.LocalDate
import java.time.LocalTime

actual inline fun runAtFixedRate(
    startDelayMillis: Long,
    delayMillis: Long,
    crossinline action: () -> Unit
): Job {
    TODO()
}

actual inline fun runWithFixedDelay(
    startDelayMillis: Long,
    delayMillis: Long,
    crossinline action: () -> Unit
): Job {
    TODO()
}

actual inline fun runAfterDelay(delayMillis: Long, crossinline action: () -> Unit): Job {
    TODO()
}
