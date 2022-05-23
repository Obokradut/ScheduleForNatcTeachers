package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases

fun getAuditorium(auditorium: String):String {
    val regex = "№\\d{3}".toRegex()
    return when {
        auditorium.contains("Спортивный зал",true) -> "—"
        auditorium.contains("Дистанционные технологии",true) -> "—"
        else -> regex.findAll(auditorium).map{it.value}.toList()[0]
    }
}