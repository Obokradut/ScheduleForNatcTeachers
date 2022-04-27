package com.konokradus.schedulefornatcteachers.navigation.schedule

import kotlinx.coroutines.flow.StateFlow

interface IScheduleMainNavProvider {
    val currentNavFlow: StateFlow<ScheduleMainDestinations>
    fun navigateToDrawer()
    fun navigateToSchedule(id: Int)
    fun popBack()
}