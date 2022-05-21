package com.konokradus.schedulefornatcteachers.modules.info.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

@Composable
fun InfoBox(
    icon: ImageVector,
    contentDescription: String,
    title: String,
    text: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = ScheduleTheme.colors.topBar
            )
            Spacer(modifier = Modifier.width(15.dp))
            Text(
                modifier = Modifier.width(100.dp),
                text = title,
                style = ScheduleTheme.typography.title,
                fontSize = 14.sp,
                softWrap = true
            )
        }
        Text(
            text = text,
            style = ScheduleTheme.typography.title,
            fontSize = 14.sp
        )
    }
}