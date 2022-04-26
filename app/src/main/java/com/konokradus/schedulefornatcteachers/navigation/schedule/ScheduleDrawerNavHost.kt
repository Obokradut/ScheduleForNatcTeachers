package com.konokradus.schedulefornatcteachers.navigation.schedule

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.TeachersListScreen

@Composable
fun ScheduleDrawerNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ScheduleDrawerDestinations.TeachersList.route
    ) {
        composable(
            route = ScheduleDrawerDestinations.TeachersList.route
        ) {
            TeachersListScreen()
        }
        composable(
            route = ScheduleDrawerDestinations.Favorites.route
        ) {
            //TODO
        }
        composable(
            route = ScheduleDrawerDestinations.Info.route
        ) {
            //TODO
        }
    }
}