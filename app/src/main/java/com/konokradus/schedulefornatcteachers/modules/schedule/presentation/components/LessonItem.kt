package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.models.LessonItem
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

interface LessonsGroupScope{
    @Composable
    fun LessonItem(
        lesson: String,
        timeStartEnd: String,
        group: String,
        auditorium: String
    ) {
        Surface(
            modifier = Modifier
                .width(370.dp)
                .shadow(elevation = 4.dp),
            shape = RoundedCornerShape(6.dp, 6.dp, 0.dp, 0.dp),
            border = BorderStroke(width = 2.dp, color = ScheduleTheme.colors.border)
        ) {
            Column() {
                Text(
                    text = lesson,
                    textAlign = TextAlign.Center,
                    style = ScheduleTheme.typography.titleBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(ScheduleTheme.colors.searchBox),
                    color = ScheduleTheme.colors.ultimateTitle
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(width = 2.dp, color = ScheduleTheme.colors.border),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Surface(
                        modifier = Modifier.width(140.dp)
                    ) {
                        ScheduleText(text = timeStartEnd)
                    }
                    Surface(
                        border = BorderStroke(
                            width = 2.dp,
                            color = ScheduleTheme.colors.border
                        ),
                        modifier = Modifier.width(135.dp)
                    ) {
                        ScheduleText(text = group)
                    }
                    Surface(
                        modifier = Modifier.width(95.dp)
                    ) {
                        ScheduleText(text = auditorium)
                    }
                }
            }
        }
    }
}

object LessonsGroupScopeImpl: LessonsGroupScope

@Composable
private fun ScheduleText(
    text:String,
    fontSize: Int = 20
) {
    Text(
        text = text, textAlign = TextAlign.Center, fontSize = fontSize.sp,
        style = ScheduleTheme.typography.titleBold,
        color = ScheduleTheme.colors.ultimateTitle,
        modifier = Modifier.padding(5.dp,10.dp,5.dp,10.dp)
    )
}