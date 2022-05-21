package com.konokradus.schedulefornatcteachers.navigation.schedule.drawer

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

class ScheduleDrawerNavProvider : IScheduleDrawerNavProvider {

    private val _currentNavFlow: MutableSharedFlow<ScheduleDrawerDestinations> = MutableSharedFlow(replay = 1, extraBufferCapacity = 1)

    override val currentNavFlow: SharedFlow<ScheduleDrawerDestinations>
        get() = _currentNavFlow

    override fun navigateToTeachersList() {
        _currentNavFlow.tryEmit(ScheduleDrawerDestinations.TeachersList)
    }

    override fun navigateToFavorites() {
        _currentNavFlow.tryEmit(ScheduleDrawerDestinations.Favorites)
    }

    override fun navigateToOffices() {
        _currentNavFlow.tryEmit(ScheduleDrawerDestinations.Offices)
    }

    override fun navigateToInfo() {
        _currentNavFlow.tryEmit(ScheduleDrawerDestinations.Info)
    }

    override fun popBack() {
        _currentNavFlow.tryEmit(ScheduleDrawerDestinations.PopBack)
    }
}