package com.konokradus.schedulefornatcteachers.navigation.schedule

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun ScheduleMainNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = ScheduleMainDestinations.Drawer.route
    ) {
        composable(route = ScheduleMainDestinations.Drawer.route) {
            //TODO
        }
        composable(route = ScheduleMainDestinations.ScheduleTemplate.route) {
            //TODO
        }
    }
}