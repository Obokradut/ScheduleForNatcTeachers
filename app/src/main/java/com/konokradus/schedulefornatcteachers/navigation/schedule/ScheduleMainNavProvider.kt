package com.konokradus.schedulefornatcteachers.navigation.schedule

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

class ScheduleMainNavProvider : IScheduleMainNavProvider {

    private val _currentNavFlow: MutableSharedFlow<ScheduleMainDestinations> = MutableSharedFlow(replay = 1, extraBufferCapacity = 1)


    override val currentNavFlow: SharedFlow<ScheduleMainDestinations>
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