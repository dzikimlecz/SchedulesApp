package me.dzikimlecz.common.util

import kotlinx.datetime.*

private val timeZone = TimeZone.currentSystemDefault()

fun today() = Clock.System.todayAt(timeZone)

fun now() = Clock.System.now().toLocalDateTime(timeZone)

fun LocalDate.toFriendlyString() =
    buildString {
        append(if (dayOfMonth > 9) dayOfMonth else "0$dayOfMonth")
        append(".")
        append(if (monthNumber > 9) monthNumber else "0$monthNumber")
        append(".")
        append(year)
    }

fun LocalDateTime.toHourMinuteString() = buildString {
    append(hour)
    append(':')
    append(if (minute > 9) minute else "0$minute")
}
