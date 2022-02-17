package me.dzikimlecz.common

import androidx.compose.runtime.Composable
import me.dzikimlecz.common.model.Schedule
import me.dzikimlecz.common.model.ViewMode
import me.dzikimlecz.common.model.ViewMode.*


@Composable
fun ScheduleDisplay(schedule: Schedule, viewMode: ViewMode) {
    when (viewMode) {
        View -> ScheduleView(schedule)
        Edit -> TODO()
    }
}

@Composable
fun NoScheduleSelectedDisplay(
    viewMode: ViewMode,
    allSchedules: List<Schedule> = listOf(),
    onScheduleSelected: (Schedule) -> Unit
) {
    when (viewMode) {
        View -> SchedulesList(allSchedules, onScheduleSelected)
        Edit -> TODO()
    }
}
