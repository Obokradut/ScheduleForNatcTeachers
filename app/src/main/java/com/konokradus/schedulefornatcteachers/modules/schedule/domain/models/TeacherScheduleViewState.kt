package com.konokradus.schedulefornatcteachers.modules.schedule.domain.models

import com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases.GetLessonItemGroup
import java.sql.Connection
import kotlin.reflect.KFunction3

sealed interface TeacherScheduleViewState {
    object Loading: TeacherScheduleViewState
    data class PresentInfo(
        val fio: String,
        val schedule: List<LessonItemGroup>
    ) : TeacherScheduleViewState
    data class Error(
        val message: String
    ) : TeacherScheduleViewState
}