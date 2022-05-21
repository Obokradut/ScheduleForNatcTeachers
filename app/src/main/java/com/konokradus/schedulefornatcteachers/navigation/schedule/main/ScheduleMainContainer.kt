package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.konokradus.schedulefornatcteachers.navigation.schedule.main.ScheduleMainNavHost

@SuppressLint("FlowOperatorInvokedInComposition")
@ExperimentalMaterialApi
@Composable
fun ScheduleMainContainer(sharedPreferences: SharedPreferences) {
    val navController = rememberNavController()
    ScheduleMainNavHost(
        navHostController = navController,
        sharedPreferences = sharedPreferences
    )
}