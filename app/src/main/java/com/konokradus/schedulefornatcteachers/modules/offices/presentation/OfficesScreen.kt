package com.konokradus.schedulefornatcteachers.modules.offices.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleTheme

@Composable
fun OfficesScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Скоро появится.",
            style = ScheduleTheme.typography.titleBold,
            color = ScheduleTheme.colors.ultimateTitle
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    OfficesScreen()
}