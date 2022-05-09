package com.konokradus.schedulefornatcteachers.navigation.schedule

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.ScheduleDrawerViewModel
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.TeachersListViewModel
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.InfoScreen
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.OfficesScreen
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.TeachersListScreen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun ScheduleDrawerNavHost(
    navHostController: NavHostController,
    drawerViewModel: ScheduleDrawerViewModel
) {
    LaunchedEffect(key1 = true){
        drawerViewModel.drawerNavProvider.currentNavFlow.onEach{ destination ->
            if (destination is ScheduleDrawerDestinations.PopBack)
                navHostController.popBackStack()
            else
                navHostController.navigate(destination.route) {
                    launchSingleTop = true
                    popUpTo(navHostController.graph.startDestinationId)
                }
        }.launchIn(this)
    }

    NavHost(
        navController = navHostController,
        startDestination = ScheduleDrawerDestinations.TeachersList.route
    ) {
        composable(
            route = ScheduleDrawerDestinations.TeachersList.route
        ) {
            val viewModel = hiltViewModel<TeachersListViewModel>()
            TeachersListScreen(viewModel.teachersList.value)
        }
        composable(
            route = ScheduleDrawerDestinations.Favorites.route
        ) {
            //TODO
        }
        composable(
            route = ScheduleDrawerDestinations.Offices.route
        ) {
            OfficesScreen()
        }
        composable(
            route = ScheduleDrawerDestinations.Info.route
        ) {
            InfoScreen()
        }
    }
}