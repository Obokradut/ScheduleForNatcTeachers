package com.konokradus.schedulefornatcteachers.navigation.schedule

import kotlinx.coroutines.flow.StateFlow

interface IScheduleDrawerNavProvider {
    val currentNavFlow: StateFlow<ScheduleDrawerDestinations>
    fun navigateToTeachersList()
    fun navigateToInfo()
    fun navigateToFavorites()
    fun popBack()
}