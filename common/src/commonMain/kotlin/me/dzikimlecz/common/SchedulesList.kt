package me.dzikimlecz.common

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import me.dzikimlecz.common.model.Schedule
import me.dzikimlecz.common.util.toFriendlyString

@Composable
fun ScheduleCard(schedule: Schedule, onClick: () -> Unit) {
    Column(Modifier
        .clickable { onClick() }
        .padding(
            start = 15.dp,
            top = 25.dp,
            end = 15.dp,
            bottom = 25.dp
        )
    ) {
        Text(schedule.name,
            fontSize = 6.0.em,
        )
        Divider(modifier = Modifier.padding(top = 5.dp, bottom = 2.dp))
        Text(
            schedule.date.toFriendlyString(),
            fontSize = 4.5.em,
            color = Gray
        )
    }
}

@Composable
fun SchedulesList(schedules: List<Schedule>, onScheduleSelected: (Schedule) -> Unit) {
    Column(Modifier
        .verticalScroll(ScrollState(0))
    ) {
        Divider()
        for (schedule in schedules) {
            ScheduleCard(schedule) { onScheduleSelected(schedule) }
            Divider(modifier = Modifier.shadow(elevation = .8.dp))
        }
    }
}
