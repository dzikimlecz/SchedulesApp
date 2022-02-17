package me.dzikimlecz.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.dzikimlecz.common.model.Activity
import me.dzikimlecz.common.model.Priority
import me.dzikimlecz.common.model.Schedule
import me.dzikimlecz.common.model.ViewMode
import me.dzikimlecz.common.util.now
import me.dzikimlecz.common.util.toFriendlyString
import me.dzikimlecz.common.util.today
import kotlin.random.Random

@Composable
fun App() {
    var openedSchedule by remember { mutableStateOf<Schedule?>(null) }
    var viewMode by remember { mutableStateOf(ViewMode.View) }

    Scaffold(
        content = {
            if (openedSchedule == null)
                NoScheduleSelectedDisplay(viewMode, getSchedulesList(3)) { openedSchedule = it }
            else ScheduleDisplay(getSchedulesList(1)[0], viewMode)
        },
        topBar = {
            TopAppBar(
                title = {
                    if (openedSchedule == null) Text("Schedules", Modifier.fillMaxWidth())
                    else {
                        val schedule = openedSchedule!!
                        Row {
                            Text(schedule.name, Modifier.weight(2f))
                            Text(schedule.date.toFriendlyString(), Modifier.weight(1f))
                        }
                    }
                },
                navigationIcon = {
                    if (openedSchedule == null)
                        Box(Modifier.defaultMinSize(64.dp, 36.dp), Alignment.Center) {
                            Icon(Icons.Default.DateRange, "")
                        }
                    else Button(onClick = { openedSchedule = null }) {
                        Icon(Icons.Default.ArrowBack, "Back to Menu")
                    }
                },
            )
        },
        floatingActionButton = {
                FloatingActionButton(onClick = { viewMode = ViewMode.Edit }) {
                    if (openedSchedule == null) Icon(Icons.Default.Add, "Create a new schedule")
                    else Icon(Icons.Default.Edit, "Edit Schedule")
                }
        }
    )
}

internal fun getSchedulesList(size: Int): List<Schedule> {
    var c = 0
    val sequence = generateSequence { Schedule("Plan ${c++}", today(), getSomeActivities()) }.iterator()
    val list = mutableListOf<Schedule>()
    for (i in 0 until size)
        list += sequence.next()
    return list
}

internal fun getSomeActivities(): List<Activity> {
    val chars = "6l38GJgT7ifgZlg".toList()
    var c = 0
    val rand = Random(4654456)
    val sequence = generateSequence { Activity(
        "Coś ${c++}",
        now(),
        when(rand.nextInt(3)) {
            0 -> Priority.Low
            1 -> Priority.Medium
            2 -> Priority.High
            else -> throw AssertionError() },
        if (rand.nextBoolean()) chars.shuffled().joinToString(separator = "") else null
    ) }.iterator()
    val list = mutableListOf<Activity>()
    for (i in 0..15)
        list += sequence.next()
    return list
}
