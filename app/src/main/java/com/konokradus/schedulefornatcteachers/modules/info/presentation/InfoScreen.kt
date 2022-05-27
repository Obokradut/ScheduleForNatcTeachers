package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konokradus.schedulefornatcteachers.BuildConfig
import com.konokradus.schedulefornatcteachers.R
import com.konokradus.schedulefornatcteachers.modules.info.presentation.components.InfoBox
import com.konokradus.schedulefornatcteachers.modules.info.presentation.components.Line
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme


@Composable
fun InfoScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_logo),
                contentDescription = "logo",
                tint = ScheduleTheme.colors.topBar,
                modifier = Modifier.size(220.dp)
            )
            Column() {
                Line(up = 20, down = 10)
                InfoBox(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_version),
                    contentDescription = "version",
                    title = "Версия",
                    text = BuildConfig.VERSION_NAME
                )
                Line(up = 10, down = 10)
                InfoBox(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_site),
                    contentDescription = "site",
                    title = "Сайт колледжа",
                    text = "natk.ru"
                )
                Line(up = 10, down = 10)
                InfoBox(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_mail),
                    contentDescription = "mail",
                    title = "Почта " +
                            "разработчика",
                    text = "dechenkovms@gmail.com",
                )
                Line(up = 12, down = 0)
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Copyright © 2022, Деченков М.С.",
                style = ScheduleTheme.typography.title,
                color = ScheduleTheme.colors.photoBox,
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    InfoScreen()
}