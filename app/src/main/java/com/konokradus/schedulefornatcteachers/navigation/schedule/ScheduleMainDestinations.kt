package com.konokradus.schedulefornatcteachers.navigation.schedule

sealed class ScheduleMainDestinations(val route: String) {
    object Drawer : ScheduleMainDestinations("drawer")
    object PopBack : ScheduleMainDestinations("")
    data class Schedule(val id: Int) : ScheduleMainDestinations("schedule/$id")
    object ScheduleTemplate : ScheduleMainDestinations("schedule/{id}")
}