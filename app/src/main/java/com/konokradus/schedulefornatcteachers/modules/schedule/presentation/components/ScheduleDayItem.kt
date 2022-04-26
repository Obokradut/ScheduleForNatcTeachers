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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

@Preview
@Composable
private fun Preview() {
    ScheduleDayItem("ПТ — 20.02.22")
}

@Composable
private fun ScheduleDayItem(
    date: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ScheduleDate(date)
        Spacer(modifier = Modifier.height(15.dp))
        //TODO Сделать спавнер занятий
        LessonItem(
            lesson = "Мат. моделирование",
            timeStartEnd = "08:30-10:10",
            group = "ПР-315",
            auditorium = "№368",
        )
        Spacer(modifier = Modifier.height(15.dp))
        LessonItem(
            lesson = "Правовое право",
            timeStartEnd = "10:10-12:30",
            group = "ПР-316",
            auditorium = "№451",
        )
    }
}