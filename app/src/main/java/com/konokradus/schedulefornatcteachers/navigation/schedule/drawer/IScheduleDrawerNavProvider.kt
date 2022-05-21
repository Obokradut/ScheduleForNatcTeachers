package com.konokradus.schedulefornatcteachers.navigation.schedule.drawer

import kotlinx.coroutines.flow.SharedFlow

interface IScheduleDrawerNavProvider {
    val currentNavFlow: SharedFlow<ScheduleDrawerDestinations>
    fun navigateToTeachersList()
    fun navigateToFavorites()
    fun navigateToOffices()
    fun navigateToInfo()
    fun popBack()
}