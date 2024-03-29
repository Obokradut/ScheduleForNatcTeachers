package com.konokradus.schedulefornatcteachers.navigation.schedule.drawer

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.konokradus.schedulefornatcteachers.modules.favorite.presentation.FavoriteScreen
import com.konokradus.schedulefornatcteachers.modules.favorite.presentation.FavoriteViewModel
import com.konokradus.schedulefornatcteachers.modules.offices.presentation.OfficesScreen
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.InfoScreen
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.TeachersListScreen
import com.konokradus.schedulefornatcteachers.modules.settings.presentation.SettingsScreen
import com.konokradus.schedulefornatcteachers.modules.teacherslist.presentation.TeachersListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@ExperimentalMaterialApi
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
            val teacherViewModel = hiltViewModel<TeachersListViewModel>()
            TeachersListScreen(
                searchFio = teacherViewModel.searchBox.value,
                searchChanged = teacherViewModel::searchChanged,
                teachersListViewState = teacherViewModel.teacherViewState.value
            )
        }
        composable(
            route = ScheduleDrawerDestinations.Favorites.route
        ) {
            val favoriteViewModel = hiltViewModel<FavoriteViewModel>()
            FavoriteScreen(
                searchFio = favoriteViewModel.searchBox.value,
                searchChanged = favoriteViewModel::searchChanged,
                favoriteViewState = favoriteViewModel.favoriteViewState.value
            )
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
        composable(
            route = ScheduleDrawerDestinations.Settings.route
        ) {
            SettingsScreen()
        }
    }
}