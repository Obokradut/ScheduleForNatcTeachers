package com.konokradus.schedulefornatcteachers.navigation.schedule.main

import kotlinx.coroutines.flow.SharedFlow

interface IScheduleMainNavProvider {
    val currentNavFlow: SharedFlow<ScheduleMainDestinations>
    fun navigateToDrawer()
    fun navigateToSchedule(fio: String)
    fun popBack()
}