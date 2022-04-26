package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konokradus.schedulefornatcteachers.R
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTypography
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTypographyImpl

@Composable
fun SearchBox() {
    val searchFIO = remember{ mutableStateOf("")}
    Surface(
        modifier = Modifier
            .width(390.dp)
            .height(60.dp),
        color = ScheduleTheme.colors.searchBox,
        shape = RoundedCornerShape(
            topEnd = 0.dp, topStart = 0.dp,
            bottomStart = 6.dp, bottomEnd = 6.dp
        )
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = searchFIO.value,
            onValueChange = {searchFIO.value = it},
            placeholder = {
                Text(
                    text = "Поиск",
                    style = ScheduleTheme.typography.title,
                    color = Color(0xff929292),
                )
            }
        )
    }
}

@Preview
@Composable
private fun Preview() {
    SearchBox()
}