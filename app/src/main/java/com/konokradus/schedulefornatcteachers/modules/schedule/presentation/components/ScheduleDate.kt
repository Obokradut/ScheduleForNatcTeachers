package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

//Дата в расписании
@Composable
fun ScheduleDate(date: String) {
    Surface(
        modifier = Modifier
            .width(370.dp),
        color = ScheduleTheme.colors.dateBox,
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 5.dp, 0.dp, 5.dp),
            text = date,
            style = ScheduleTheme.typography.dateTitle,
            color = Color.White,
            textAlign = TextAlign.Center,
            softWrap = true
        )
    }
}