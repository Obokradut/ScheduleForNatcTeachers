package com.konokradus.schedulefornatcteachers.modules.schedule.domain.models

data class LessonItem(
    var lesson: String,
    var timeStartEnd: String,
    var group: String,
    var auditorium: String
)
