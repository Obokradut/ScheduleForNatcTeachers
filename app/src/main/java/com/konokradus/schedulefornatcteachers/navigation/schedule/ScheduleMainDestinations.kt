package com.konokradus.schedulefornatcteachers.navigation.schedule

sealed class ScheduleMainDestinations(val route: String) {
    object Drawer : ScheduleMainDestinations("drawer")
    object PopBack : ScheduleMainDestinations("")
    data class Schedule(val fio: String) : ScheduleMainDestinations("schedule/$fio")
    object ScheduleTemplate : ScheduleMainDestinations("schedule/{fio}")
}