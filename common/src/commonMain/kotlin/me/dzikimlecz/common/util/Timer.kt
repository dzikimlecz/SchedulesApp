package me.dzikimlecz.common.util

import kotlinx.coroutines.Job

expect inline fun runAtFixedRate(
    startDelayMillis: Long,
    delayMillis: Long,
    crossinline action: () -> Unit,
): Job

expect inline fun runWithFixedDelay(
    startDelayMillis: Long,
    delayMillis: Long,
    crossinline action: () -> Unit,
): Job

expect inline fun runAfterDelay(
    delayMillis: Long,
    crossinline action: () -> Unit,
): Job
