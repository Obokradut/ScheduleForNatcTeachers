package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

data class TitlesTopBar(
    val teachersList: String,
    val favorites: String,
    val schedule: String,
    val offices: String,
    val menu: String,
    val options: String,
    val info: String,
)

val TitlesTopBarImp = TitlesTopBar(
    teachersList = "СПИСОК ПРЕПОДАВАТЕЛЕЙ",
    favorites = "ИЗБРАННЫЕ",
    schedule = "РАСПИСАНИЕ",
    offices = "КАБИНЕТЫ",
    menu = "МЕНЮ",
    options = "НАСТРОЙКИ",
    info = "ИНФОРМАЦИЯ",
)