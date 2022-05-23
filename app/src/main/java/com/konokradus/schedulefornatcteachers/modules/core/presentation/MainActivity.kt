package com.konokradus.schedulefornatcteachers.modules.core.presentation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.konokradus.schedulefornatcteachers.modules.schedule.presentation.components.ScheduleMainContainer
import com.konokradus.schedulefornatcteachers.ui.theme.ScheduleForNatkTeachersTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScheduleForNatkTeachersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val sharedPreferences = getSharedPreferences("FAVORITE_TEACHERS",Context.MODE_PRIVATE)
                    ScheduleMainContainer(sharedPreferences)
                }
            }
        }
    }
}

