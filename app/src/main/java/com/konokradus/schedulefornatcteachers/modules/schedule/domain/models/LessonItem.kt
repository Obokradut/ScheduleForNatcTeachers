package com.konokradus.schedulefornatcteachers.modules.schedule.domain.models

data class LessonItem(
    val lesson: String,
    val timeStartEnd: String,
    val group: String,
    val auditorium: String
)
