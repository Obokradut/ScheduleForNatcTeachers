package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun Preview() {
    ScheduleDayItem("ПТ — 20.02.22") {
        LessonItem(
            lesson = "asdf",
            timeStartEnd = "asdf",
            group = "asdf",
            auditorium = "asdf"
        )
        LessonItem(
            lesson = "asdf",
            timeStartEnd = "asdf",
            group = "asdf",
            auditorium = "asdf"
        )
        LessonItem(
            lesson = "asdf",
            timeStartEnd = "asdf",
            group = "asdf",
            auditorium = "asdf"
        )
        LessonItem(
            lesson = "asdf",
            timeStartEnd = "asdf",
            group = "asdf",
            auditorium = "asdf"
        )

    }
}

@Composable
fun ScheduleDayItem(
    date: String,
    content: @Composable LessonsGroupScope.() -> Unit
) {
    Column(
        modifier = Modifier.shadow(elevation = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScheduleDate(date)
        Spacer(modifier = Modifier.height(15.dp))
        Column(verticalArrangement = Arrangement.spacedBy(15.dp)) {
            LessonsGroupScopeImpl.content()
        }
    }
}
