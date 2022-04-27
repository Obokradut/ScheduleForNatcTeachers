package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.ScheduleDrawerViewModel
import com.konokradus.schedulefornatcteachers.navigation.schedule.ScheduleDrawerNavHost
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ScheduleDrawerContainer(
    drawerViewModel: ScheduleDrawerViewModel
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
                onOfficesClick = {},
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