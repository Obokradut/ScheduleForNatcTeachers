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
import com.konokradus.schedulefornatcteachers.modules.menu.presentation.components.MenuTopBar
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.models.TitlesTopBarImp
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
        Column {
            MenuTopBar()
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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