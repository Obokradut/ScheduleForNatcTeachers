package com.konokradus.schedulefornatcteachers.modules.schedule.domain.models

data class TitlesTopBar(
    val teachersList: String,
    val favorites: String,
    val schedule: String,
    val offices: String,
    val menu: String,
    val settings: String,
    val info: String,
)

val TitlesTopBarImp = TitlesTopBar(
    teachersList = "ПРЕПОДАВАТЕЛИ",
    favorites = "ИЗБРАННОЕ",
    schedule = "РАСПИСАНИЕ",
    offices = "КАБИНЕТЫ",
    menu = "МЕНЮ",
    settings = "НАСТРОЙКИ",
    info = "ИНФОРМАЦИЯ",
)