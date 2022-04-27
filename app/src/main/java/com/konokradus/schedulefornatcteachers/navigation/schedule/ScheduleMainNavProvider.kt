package com.konokradus.schedulefornatcteachers.navigation.schedule

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ScheduleMainNavProvider : IScheduleMainNavProvider {

    private val _currentNavFlow: MutableStateFlow<ScheduleMainDestinations> = MutableStateFlow(ScheduleMainDestinations.Drawer)


    override val currentNavFlow: StateFlow<ScheduleMainDestinations>
        get() = _currentNavFlow

    override fun navigateToDrawer() {
        _currentNavFlow.tryEmit(ScheduleMainDestinations.Drawer)
    }

    override fun navigateToSchedule(id: Int) {
        _currentNavFlow.tryEmit(ScheduleMainDestinations.Schedule(id))
    }

    override fun popBack() {
        _currentNavFlow.tryEmit(ScheduleMainDestinations.PopBack)
    }
}