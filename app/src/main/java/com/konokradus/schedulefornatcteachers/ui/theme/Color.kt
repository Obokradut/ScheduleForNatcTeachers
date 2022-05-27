package com.konokradus.schedulefornatcteachers.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val LightBackground = Color(0xffFFFFFF)
val TopBar = Color(0xff2D73BC)
val MenuTopBar = Color(0xff235487)
val MenuBackground = Color(0xff424B56)
val MenuButton = Color(0xff5F7B9B)
val DateBar = Color(0xff0078BF)
val SearchIcon = Color(0xffB9B9B9)
val GrayUltimate = Color(0xFFCFCFCF)
val LightGrayUltimate = Color(0xffEDEDED)
val LightDarkGrayTitle = Color(0xff6C6C6C)

val DarkBackground = Color(0xff27282C)
val DarkTopBar = Color(0xffD3D3D3)
val DarkMenuTopBar = Color(0xff292929)
val DarkMenuBackground = Color(0xff676A6D)
val DarkMenuButton = Color(0xff494C4F)
val DarkDateBar = Color(0xff454545)
val DarkSearchIcon = Color(0xff929292)
val DarkGrayUltimate = Color(0x49494B)
val DarkLightGrayUltimate = Color(0xff929292)
val DarkDarkGrayTitle = Color(0xff6C6C6C)

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