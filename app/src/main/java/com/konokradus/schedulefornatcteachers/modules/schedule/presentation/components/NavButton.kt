package com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

@ExperimentalMaterialApi
@Composable
fun NavButton(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Column() {
        Surface(
            modifier = Modifier
                .width(340.dp)
                .height(60.dp),
            color = ScheduleTheme.colors.menuButton,
            shape = RoundedCornerShape(6.dp),
            elevation = 10.dp,
            onClick = onClick,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(10.dp))
                Icon(
                    modifier = Modifier.size(35.dp),
                    imageVector = icon,
                    contentDescription = "icon",
                    tint = ScheduleTheme.colors.layoutBackground
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = title,
                    style = ScheduleTheme.typography.menuButtonText,
                    textAlign = TextAlign.Left,
                    color = ScheduleTheme.colors.layoutBackground,
                    fontSize = 20.sp,
                    softWrap = true
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}