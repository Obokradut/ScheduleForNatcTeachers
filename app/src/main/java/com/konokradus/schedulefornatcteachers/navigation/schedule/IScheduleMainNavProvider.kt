package com.konokradus.schedulefornatcteachers.navigation.schedule

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface IScheduleMainNavProvider {
    val currentNavFlow: SharedFlow<ScheduleMainDestinations>
    fun navigateToDrawer()
    fun navigateToSchedule(fio: String)
    fun popBack()
}