package com.konokradus.schedulefornatcteachers.modules.info.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

@Composable
fun Line(
    up: Int,
    down: Int
) {
    Spacer(modifier = Modifier.height(up.dp))
    Divider(
        thickness = 2.dp,
        color = ScheduleTheme.colors.searchBox,
        modifier = Modifier.fillMaxWidth(1f)
    )
    Spacer(modifier = Modifier.height(down.dp))
}