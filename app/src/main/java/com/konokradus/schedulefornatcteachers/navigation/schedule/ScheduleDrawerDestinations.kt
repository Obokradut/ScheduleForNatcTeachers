package com.konokradus.schedulefornatcteachers.navigation.schedule

sealed class ScheduleDrawerDestinations(val route: String) {
    object TeachersList : ScheduleDrawerDestinations("teachers_list")
    object Favorites : ScheduleDrawerDestinations("favorites")
    object Info : ScheduleDrawerDestinations("info")
    object PopBack : ScheduleDrawerDestinations("")
}