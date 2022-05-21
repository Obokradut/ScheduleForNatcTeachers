package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.konokradus.schedulefornatcteachers.R
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.TeacherScheduleViewState
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

@Composable
fun TeacherSchedule(
    teacherScheduleViewState: TeacherScheduleViewState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Surface(
                modifier = Modifier.size(130.dp),
                color = ScheduleTheme.colors.photoBox,
                shape = RoundedCornerShape(6.dp),
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_person),
                    contentDescription = "person",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                    tint = ScheduleTheme.colors.layoutBackground
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            when(teacherScheduleViewState){
                is TeacherScheduleViewState.PresentInfo -> {
                    Text(
                        text = teacherScheduleViewState.fio,
                        style = ScheduleTheme.typography.title,
                        textAlign = TextAlign.Center,
                        softWrap = true
                    )
                }
                is TeacherScheduleViewState.Error -> {
                    Text(
                        text = teacherScheduleViewState.fio,
                        style = ScheduleTheme.typography.title,
                        textAlign = TextAlign.Center,

                    )
                }
                else -> {}
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Divider(
            thickness = 2.dp,
            color = ScheduleTheme.colors.searchBox,
            modifier = Modifier.fillMaxWidth(0.9f)
        )

        LazyColumn(){
            item {
                Spacer(modifier = Modifier.height(40.dp))
            }
            when(teacherScheduleViewState){
                is TeacherScheduleViewState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
                is TeacherScheduleViewState.PresentInfo -> {
                    teacherScheduleViewState.schedule.forEach { lesson ->
                        item{
                            ScheduleDayItem(date = lesson.date) {
                                lesson.lessons.forEach{ lessonItem ->
                                    LessonItem(
                                        lesson = lessonItem.lesson,
                                        timeStartEnd = lessonItem.timeStartEnd,
                                        group = lessonItem.group,
                                        auditorium = lessonItem.auditorium
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(50.dp))
                        }
                    }
                }
                is TeacherScheduleViewState.Error -> {
                    item {
                        Text(
                            text = teacherScheduleViewState.message,
                            style = ScheduleTheme.typography.titleBold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}