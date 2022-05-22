package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases

fun getAuditorium(auditorium: String):String {
    val regex = "№\\d{3}".toRegex()
    return if (auditorium.contains("Спортивный зал",true))
        "—"
    else
        regex.findAll(auditorium).map{it.value}.toList()[0]
}