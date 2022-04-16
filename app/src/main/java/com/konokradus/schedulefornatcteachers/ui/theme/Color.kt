package com.konokradus.schedulefornatcteachers.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val White = Color(0xffFFFFFF)
val TopBar = Color(0xff2D73BC)
val DateBar = Color(0xff0078BF)
val GrayUltimate = Color(0xffE1E1E1)
val DarkGrayTitle = Color(0xff6C6C6C)

@Immutable
data class ScheduleColors(
    val layoutBackground: Color,
    val topBar: Color,
    val searchBox: Color,
    val photoBox: Color,
    val dateBox: Color,
    val ultimateTitle: Color
)