package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases

fun editDate(date: String): String {
    val day = date.subSequence(8, 10)
    val month = date.subSequence(5, 7)
    val year = date.subSequence(0, 4)
    return "$day.$month.$year"
}