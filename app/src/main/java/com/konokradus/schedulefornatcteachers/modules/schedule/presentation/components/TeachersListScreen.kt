package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.models.TeachersListViewState
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

@Composable
fun TeachersListScreen(
    teachersListViewState: TeachersListViewState,
    searchFio: String,
    searchChanged: (String) -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchBox(
            value = searchFio,
            onValueChange = searchChanged
        )
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(
                start = 30.dp,
                top = 0.dp,
                end = 30.dp,
                bottom = 30.dp
            )
        ) {
            item {
                Spacer(modifier = Modifier.padding(top = 40.dp))
            }
            when (teachersListViewState) {
                is TeachersListViewState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
                is TeachersListViewState.PresentInfo -> {
                    val count = teachersListViewState.listTeachers.count()
                    teachersListViewState.listTeachers.forEachIndexed { i, person ->
                        item {
                            TeacherItem(fullName = person)
                            if (i != count - 1) {
                                Divider(
                                    thickness = 2.dp,
                                    color = ScheduleTheme.colors.searchBox,
                                    modifier = Modifier.padding(
                                        start = 0.dp,
                                        top = 20.dp,
                                        end = 0.dp,
                                        bottom = 20.dp
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    Box(Modifier.background(Color.White)){
 /*       TeachersListScreen()*/
    }
}