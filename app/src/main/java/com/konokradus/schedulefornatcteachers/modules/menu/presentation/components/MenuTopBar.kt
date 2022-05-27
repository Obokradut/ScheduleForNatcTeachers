package com.konokradus.schedulefornatcteachers.modules.menu.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konokradus.schedulefornatcteachers.R
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

@Composable
fun MenuTopBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        color = ScheduleTheme.colors.darkTopBar,
        shape = RoundedCornerShape(
            topEnd = 0.dp, topStart = 0.dp,
            bottomStart = 6.dp, bottomEnd = 6.dp
        ),
        elevation = 10.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                modifier = Modifier
                    .size(45.dp)
                    .padding(0.dp, 5.dp, 0.dp, 0.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_calendar),
                contentDescription = "ic_calendar",
                tint = ScheduleTheme.colors.layoutBackground
            )
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
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
}