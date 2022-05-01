package com.konokradus.schedulefornatcteachers.modules.schedule.domain.models

data class ScheduleDayItemEntity(
    val scheduleDate: String,
    val lesson: String,
    val timeStartEnd: String,
    val group: String,
    val auditorium: String
)