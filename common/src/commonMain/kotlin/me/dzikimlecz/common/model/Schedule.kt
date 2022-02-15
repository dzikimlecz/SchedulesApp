package me.dzikimlecz.common.model

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

data class Schedule(
    val name: String,
    val date: LocalDate,
    val activities: List<Activity>,
) {
    init {
        require(activities.all { it.time.date == date }) {
            "Tried to add activity with date other, then the schedule's one"
        }
    }
}

data class Activity(
    val name: String,
    val time: LocalDateTime,
    val priority: Priority = Priority.Medium,
    val description: String? = null,
)

enum class Priority {
    Low,
    Medium,
    High,
}
