package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

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
