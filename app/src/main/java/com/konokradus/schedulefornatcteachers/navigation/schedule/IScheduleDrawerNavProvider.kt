package com.konokradus.schedulefornatcteachers.navigation.schedule

import kotlinx.coroutines.flow.SharedFlow

interface IScheduleDrawerNavProvider {
    val currentNavFlow: SharedFlow<ScheduleDrawerDestinations>
    fun navigateToTeachersList()
    fun navigateToInfo()
    fun navigateToFavorites()
    fun popBack()
}