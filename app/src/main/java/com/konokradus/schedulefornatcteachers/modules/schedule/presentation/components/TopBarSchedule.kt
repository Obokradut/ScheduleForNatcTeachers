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
import androidx.navigation.compose.rememberNavController
import com.konokradus.schedulefornatcteachers.R
import com.konokradus.schedulefornatcteachers.navigation.schedule.ScheduleDrawerDestinations
import com.konokradus.schedulefornatcteachers.navigation.schedule.ScheduleMainDestinations
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

@Composable
fun TopBarSchedule(
    navController: NavController,
    onPopBackClick: () -> Unit,
    onAddFavoritesClick: () -> Unit
) {
    var curEntry = navController.currentBackStackEntryAsState()
    var title = when (curEntry.value?.destination?.route) {
        ScheduleMainDestinations.ScheduleTemplate.route -> TitlesTopBarImp.schedule
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.width(5.dp))
            IconButton(onClick = onPopBackClick) {
                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                    contentDescription = "ic_back",
                    tint = ScheduleTheme.colors.layoutBackground
                )
            }
            Text(
                text = title,
                style = ScheduleTheme.typography.topBarText,
                textAlign = TextAlign.Center,
                color = ScheduleTheme.colors.layoutBackground,
                fontSize = 20.sp,
                softWrap = true
            )
            IconButton(onClick = onAddFavoritesClick) {
                Icon(
                    modifier = Modifier.size(40.dp),
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_unfavorites),
                    contentDescription = "ic_unfavorites",
                    tint = ScheduleTheme.colors.layoutBackground
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
}