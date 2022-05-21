package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
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
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.konokradus.schedulefornatcteachers.R
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.models.TitlesTopBarImp
import com.konokradus.schedulefornatcteachers.navigation.schedule.drawer.ScheduleDrawerDestinations
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

@Composable
fun TopBar(
    navController: NavController,
    onMenuClick: () -> Unit
) {
    val curEntry = navController.currentBackStackEntryAsState()
    val title = when(curEntry.value?.destination?.route) {
        ScheduleDrawerDestinations.TeachersList.route -> TitlesTopBarImp.teachersList
        ScheduleDrawerDestinations.Favorites.route -> TitlesTopBarImp.favorites
        ScheduleDrawerDestinations.Offices.route -> TitlesTopBarImp.offices
        ScheduleDrawerDestinations.Info.route -> TitlesTopBarImp.info
        else -> ""
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        color = ScheduleTheme.colors.topBar,
        shape = RoundedCornerShape(
            topEnd = 0.dp, topStart = 0.dp,
            bottomStart = 6.dp, bottomEnd = 6.dp
        ),
        elevation = 40.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.width(10.dp))
            IconButton(onClick = onMenuClick) {
                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_menu),
                    contentDescription = "ic_menu",
                    tint = ScheduleTheme.colors.layoutBackground
                )
            }

            Spacer(modifier = Modifier.width(5.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                style = ScheduleTheme.typography.topBarText,
                textAlign = TextAlign.Center,
                color = ScheduleTheme.colors.layoutBackground,
                fontSize = 20.sp,
                softWrap = true
            )
        }
    }
}