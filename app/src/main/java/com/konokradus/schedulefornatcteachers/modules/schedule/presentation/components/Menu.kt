package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konokradus.schedulefornatcteachers.R
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

@ExperimentalMaterialApi
@Composable
fun Menu(
    onTeachersListClick: () -> Unit,
    onFavoritesClick: () -> Unit,
    onOfficesClick: () -> Unit,
    onOptionsClick: () -> Unit,
    onInfoClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(ScheduleTheme.colors.menuBackground)
            .fillMaxSize()
    ) {
        Column() {
            MenuTopBar()

            Spacer(modifier = Modifier.height(45.dp))

            NavButton(
                icon = ImageVector.vectorResource(id = R.drawable.ic_menu),
                title = TitlesTopBarImp.teachersList,
                onClick = onTeachersListClick
            )
            NavButton(
                icon = ImageVector.vectorResource(id = R.drawable.ic_favorites),
                title = TitlesTopBarImp.favorites,
                onClick = onFavoritesClick
            )
            NavButton(
                icon = ImageVector.vectorResource(id = R.drawable.ic_offices),
                title = TitlesTopBarImp.offices,
                onClick = onOfficesClick
            )

            Spacer(modifier = Modifier.height(45.dp))

            NavButton(
                icon = ImageVector.vectorResource(id = R.drawable.ic_options),
                title = TitlesTopBarImp.options,
                onClick = onOptionsClick
            )
            NavButton(
                icon = ImageVector.vectorResource(id = R.drawable.ic_info),
                title = TitlesTopBarImp.info,
                onClick = onInfoClick
            )
        }
    }
}


@Composable
private fun MenuTopBar() {
    Surface(
        modifier = Modifier
            .width(340.dp)
            .height(60.dp),
        color = ScheduleTheme.colors.darkTopBar,
        shape = RoundedCornerShape(
            topEnd = 0.dp, topStart = 0.dp,
            bottomStart = 6.dp, bottomEnd = 6.dp
        ),
        elevation = 10.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                modifier = Modifier.size(45.dp).padding(0.dp,5.dp,0.dp,0.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_calendar),
                contentDescription = "ic_calendar",
                tint = ScheduleTheme.colors.layoutBackground
            )
            Spacer(modifier = Modifier.width(70.dp))
            Text(
                text = "МЕНЮ",
                style = ScheduleTheme.typography.topBarText,
                textAlign = TextAlign.Center,
                color = ScheduleTheme.colors.layoutBackground,
                fontSize = 20.sp,
                softWrap = true
            )
        }
    }
}



@ExperimentalMaterialApi
@Preview
@Composable
private fun Preview() {
    Menu(
        onFavoritesClick = {},
        onInfoClick = {},
        onOfficesClick = {},
        onOptionsClick = {},
        onTeachersListClick = {},
    )
}