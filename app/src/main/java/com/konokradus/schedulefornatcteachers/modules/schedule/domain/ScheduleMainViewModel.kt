package com.konokradus.schedulefornatcteachers.modules.schedule.domain

import androidx.lifecycle.ViewModel
import com.konokradus.schedulefornatcteachers.navigation.schedule.IScheduleMainNavProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleMainViewModel
@Inject
constructor(
    val mainNavProvider: IScheduleMainNavProvider
) : ViewModel()