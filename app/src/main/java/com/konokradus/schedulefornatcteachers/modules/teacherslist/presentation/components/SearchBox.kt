package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konokradus.schedulefornatcteachers.R
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTypographyImpl

@Composable
fun SearchBox(
    value: String,
    onValueChange: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        shape = RoundedCornerShape(
            topEnd = 0.dp, topStart = 0.dp,
            bottomStart = 6.dp, bottomEnd = 6.dp
        )
    ) {
        TextField(
            textStyle = ScheduleTypographyImpl.search,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = ScheduleTheme.colors.searchBox,
                focusedIndicatorColor = ScheduleTheme.colors.ultimateTitle,
                cursorColor = ScheduleTheme.colors.ultimateTitle
            ),
            value = value,
            onValueChange = onValueChange,
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
                    contentDescription = "search",
                    tint = ScheduleTheme.colors.searchIcon
                )
            },
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
    SearchBox("ПипиПупа",{})
}