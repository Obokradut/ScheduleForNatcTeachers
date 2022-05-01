package com.konokradus.schedulefornatcteachers.modules.schedule.domain.models

data class LessonItemGroup(
    val date: String,
    val lessons: List<LessonItem>
)
