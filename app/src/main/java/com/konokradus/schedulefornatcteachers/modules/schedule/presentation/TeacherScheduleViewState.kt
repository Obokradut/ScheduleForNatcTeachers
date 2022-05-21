package com.konokradus.schedulefornatcteachers.modules.schedule.presentation

import com.konokradus.schedulefornatcteachers.modules.schedule.domain.models.LessonItemGroup

sealed interface TeacherScheduleViewState {
    object Loading: TeacherScheduleViewState
    data class PresentInfo(
        val fio: String,
        val schedule: List<LessonItemGroup>
    ) : TeacherScheduleViewState
    data class Error(
        val fio: String,
        val message: String
    ) : TeacherScheduleViewState
}