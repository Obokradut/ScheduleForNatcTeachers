package com.konokradus.schedulefornatcteachers.navigation.schedule

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.ScheduleDrawerViewModel
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.ScheduleMainViewModel
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.TeacherScheduleViewModel

import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.ScheduleDrawerContainer
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.TeacherSchedule
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.TopBarSchedule
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
        composable(
            route = ScheduleMainDestinations.ScheduleTemplate.route,
            arguments = listOf(
                navArgument("fio") {
                    type = NavType.StringType
                }
            )
        ) {
            val fio = it.arguments?.getString("fio") ?: "Неизвестный"
            val scheduleViewModel = hiltViewModel<TeacherScheduleViewModel>()
            LaunchedEffect(key1 = true){
                scheduleViewModel.loadInfo(fio)
            }
            Scaffold(
                topBar = {
                    TopBarSchedule(
                        navController = navHostController,
                        onPopBackClick = { navHostController.popBackStack() },
                        onAddFavoritesClick = {}
                    )
                }
            ) {
                TeacherSchedule(teacherScheduleViewState = scheduleViewModel.scheduleViewState.value)
            }
        }
    }
}