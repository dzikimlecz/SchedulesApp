package me.dzikimlecz.common

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Light
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import me.dzikimlecz.common.model.Activity
import me.dzikimlecz.common.model.Priority.*
import me.dzikimlecz.common.model.Schedule
import me.dzikimlecz.common.util.toHourMinuteString

@Composable
fun ScheduleView(schedule: Schedule) {
    Column(modifier = Modifier.verticalScroll(ScrollState(0))) {
        Divider()
        for (activity in schedule.activities.sortedBy { it.time }) {
            ActivityCard(activity) {}
            Divider()
        }
    }
}

@Composable
fun ActivityCard(activity: Activity, onClick: () -> Unit) {
    with (activity) {
        Row(
            Modifier
                .clickable() { onClick() }
                .fillMaxWidth()
                .padding(
                    start = 10.dp,
                    top = 15.dp,
                    bottom = 15.dp
                )
        ) {
            Column(Modifier.defaultMinSize(minWidth = 250.dp)) {
                Text(
                    name,
                    color = when (priority) {
                        Low -> Gray
                        Medium -> Black
                        High -> Red
                    },
                    fontWeight = when (priority) {
                        Low -> Light
                        Medium -> Normal
                        High -> Bold
                    },
                    fontSize = 5.em,
                    modifier = Modifier.width(100.dp)
                )
                if (description !== null)
                    Text(description,
                        color = if (priority == Low) Gray else Black,
                        fontSize = 4.em,
                    )
            }
            Text(time.toHourMinuteString(),
                color = if (priority == Low) Gray else Black,
                fontSize = 4.5.em,
            )
        }
    }
}
