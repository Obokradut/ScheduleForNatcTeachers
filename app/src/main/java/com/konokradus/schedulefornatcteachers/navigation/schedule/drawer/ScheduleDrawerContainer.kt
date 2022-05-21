package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import android.content.SharedPreferences
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import com.konokradus.schedulefornatcteachers.navigation.schedule.drawer.ScheduleDrawerViewModel
import com.konokradus.schedulefornatcteachers.navigation.schedule.drawer.ScheduleDrawerNavHost
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ScheduleDrawerContainer(
    drawerViewModel: ScheduleDrawerViewModel,
    sharedPreferences: SharedPreferences
) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                navController = navController,
                onMenuClick = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerContent = {
            Menu(
                onFavoritesClick = {
                    drawerViewModel.drawerNavProvider.navigateToFavorites()
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                },
                onInfoClick = {
                    drawerViewModel.drawerNavProvider.navigateToInfo()
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                },
                onOfficesClick = {
                    drawerViewModel.drawerNavProvider.navigateToOffices()
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                },
                onOptionsClick = {},
                onTeachersListClick = {
                    drawerViewModel.drawerNavProvider.navigateToTeachersList()
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
        }
    ) {
        ScheduleDrawerNavHost(navHostController = navController, drawerViewModel = drawerViewModel)
    }
}