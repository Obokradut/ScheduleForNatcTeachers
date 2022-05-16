package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import android.annotation.SuppressLint
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.ScheduleMainViewModel
import com.konokradus.schedulefornatcteachers.navigation.schedule.ScheduleMainDestinations
import com.konokradus.schedulefornatcteachers.navigation.schedule.ScheduleMainNavHost
import kotlinx.coroutines.flow.onEach

@SuppressLint("FlowOperatorInvokedInComposition")
@ExperimentalMaterialApi
@Composable
fun ScheduleMainContainer() {
    val navController = rememberNavController()
    ScheduleMainNavHost(navHostController = navController)
}