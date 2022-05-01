package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konokradus.schedulefornatcteachers.R
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleColors
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme


@Composable
fun TeacherItem(fullName: String){
    Row(
    ) {
        Surface(
            modifier = Modifier.size(60.dp),
            color = ScheduleTheme.colors.searchBox,
            shape = RoundedCornerShape(6.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_person),
                contentDescription = "A",
                modifier = Modifier.fillMaxSize().padding(10.dp),
                tint = ScheduleTheme.colors.layoutBackground
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = fullName,
            modifier = Modifier.align(Alignment.CenterVertically),
            style = ScheduleTheme.typography.title.copy(textAlign = TextAlign.Left)
        )
    }
}

@Preview
@Composable
private fun Preview(){
    TeacherItem("Фамилиddddddя Имя Отчество")
}