package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases

fun getLesson(lesson: String): String {
    return when (lesson) {
        "отмена" -> "Отмена"
        else -> lesson
    }
}