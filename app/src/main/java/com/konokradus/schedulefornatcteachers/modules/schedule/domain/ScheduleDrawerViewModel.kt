package com.konokradus.schedulefornatcteachers.modules.schedule.domain

import androidx.lifecycle.ViewModel
import com.konokradus.schedulefornatcteachers.navigation.schedule.IScheduleDrawerNavProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleDrawerViewModel
@Inject
constructor(
    val drawerNavProvider: IScheduleDrawerNavProvider
) : ViewModel()