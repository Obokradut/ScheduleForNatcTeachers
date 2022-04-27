package com.konokradus.schedulefornatcteachers.navigation.schedule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.ScheduleDrawerViewModel
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.TeachersListScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun ScheduleDrawerNavHost(
    navHostController: NavHostController,
    drawerViewModel: ScheduleDrawerViewModel
) {
    LaunchedEffect(key1 = true){
        drawerViewModel.drawerNavProvider.currentNavFlow.collect{ destination ->
            if (destination is ScheduleDrawerDestinations.PopBack)
                navHostController.popBackStack()
            else
                navHostController.navigate(destination.route)
        }
    }

    NavHost(
        navController = navHostController,
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