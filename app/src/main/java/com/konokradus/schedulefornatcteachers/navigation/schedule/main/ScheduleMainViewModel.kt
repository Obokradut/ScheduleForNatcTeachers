package com.konokradus.schedulefornatcteachers.navigation.schedule.main

import androidx.lifecycle.ViewModel
import com.konokradus.schedulefornatcteachers.navigation.schedule.main.IScheduleMainNavProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleMainViewModel
@Inject
constructor(
    val mainNavProvider: IScheduleMainNavProvider
) : ViewModel()