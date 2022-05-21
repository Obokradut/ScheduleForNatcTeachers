package com.konokradus.schedulefornatcteachers.navigation.schedule.drawer

sealed class ScheduleDrawerDestinations(val route: String) {
    object TeachersList : ScheduleDrawerDestinations("teachers_list")
    object Favorites : ScheduleDrawerDestinations("favorites")
    object Offices : ScheduleDrawerDestinations("offices")
    object Info : ScheduleDrawerDestinations("info")
    object PopBack : ScheduleDrawerDestinations("")
}