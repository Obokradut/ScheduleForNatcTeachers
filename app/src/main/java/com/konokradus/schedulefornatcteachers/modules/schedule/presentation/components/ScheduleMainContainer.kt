package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.konokradus.schedulefornatcteachers.navigation.schedule.ScheduleMainNavHost

@ExperimentalMaterialApi
@Composable
fun ScheduleMainContainer() {
    val navController = rememberNavController()
    ScheduleMainNavHost(navHostController = navController)
}