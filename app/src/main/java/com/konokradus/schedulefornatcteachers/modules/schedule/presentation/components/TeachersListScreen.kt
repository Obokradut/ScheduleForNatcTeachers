package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

@Composable
fun TeachersListScreen(){
    LazyColumn(
        contentPadding = PaddingValues(
            start = 30.dp,
            top = 0.dp,
            end = 30.dp,
            bottom = 30.dp
        )
    ) {
        item {
            Spacer(modifier = Modifier.padding(top = 80.dp))
        }
        val count = teachersList.count()
        teachersList.forEachIndexed{i ,person ->
            item{
                TeacherItem(fullName = person)
                if (i != count-1){
                    Divider(
                        thickness = 2.dp,
                        color = ScheduleTheme.colors.searchBox,
                        modifier = Modifier.padding(
                            start = 0.dp,
                            top = 20.dp,
                            end = 0.dp,
                            bottom = 20.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    Box(Modifier.background(Color.White)){
        TeachersListScreen()
    }
}

private val teachersList = listOf(
    "Деченков Максим Сергеевич",
    "Емельянов Павел Отецович",
    "Труков Владимир Алексеевич",
    "Бурцев Владислав ОлегочивТинькофф",
    "Архипов Константин АдинОтец",
    "Сиринёв Максим Латвиец",
)