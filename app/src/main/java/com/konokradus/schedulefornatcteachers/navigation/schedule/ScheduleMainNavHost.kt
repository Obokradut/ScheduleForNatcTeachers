package com.konokradus.schedulefornatcteachers.navigation.schedule

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.ScheduleDrawerViewModel
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.ScheduleMainViewModel
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.ScheduleDrawerContainer
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@ExperimentalMaterialApi
@Composable
fun ScheduleMainNavHost(
    navHostController: NavHostController
) {
    val scheduleMainViewModel = hiltViewModel<ScheduleMainViewModel>()
    LaunchedEffect(key1 = true){
        scheduleMainViewModel.mainNavProvider.currentNavFlow.onEach { destination ->
            if(destination is ScheduleMainDestinations.PopBack){
                navHostController.popBackStack()
            }
            else{
                navHostController.navigate(destination.route)
            }
        }.launchIn(this)
    }
    NavHost(
        navController = navHostController,
        startDestination = ScheduleMainDestinations.Drawer.route
    ) {
        composable(route = ScheduleMainDestinations.Drawer.route) {
            val drawerViewModel = hiltViewModel<ScheduleDrawerViewModel>()
            ScheduleDrawerContainer(drawerViewModel = drawerViewModel)
        }
        composable(route = ScheduleMainDestinations.ScheduleTemplate.route) {
            //TODO
        }
    }
}