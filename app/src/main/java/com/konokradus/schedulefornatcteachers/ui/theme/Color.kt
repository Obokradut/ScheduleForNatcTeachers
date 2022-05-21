package com.konokradus.schedulefornatcteachers.ui.theme

import android.hardware.lights.Light
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val White = Color(0xffFFFFFF)
val TopBar = Color(0xff2D73BC)
val DarkTopBar = Color(0xff235487)
val MenuBackground = Color(0xff424B56)
val MenuButton = Color(0xff5F7B9B)
val DateBar = Color(0xff0078BF)
val SearchIcon = Color(0xffB9B9B9)
val GrayUltimate = Color(0xFFCFCFCF)
val LightGrayUltimate = Color(0xffEDEDED)
val DarkGrayTitle = Color(0xff6C6C6C)

@Immutable
data class ScheduleColors(
    val layoutBackground: Color,
    val topBar: Color,
    val menuBackground: Color,
    val menuButton: Color,
    val darkTopBar: Color,
    val searchBox: Color,
    val border: Color,
    val photoBox: Color,
    val searchIcon: Color,
    val dateBox: Color,
    val ultimateTitle: Color
)