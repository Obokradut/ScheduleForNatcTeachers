package com.konokradus.schedulefornatcteachers.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalScheduleColors = staticCompositionLocalOf {
    LightColorPalette
}

private val LocalScheduleTypography = staticCompositionLocalOf {
    ScheduleTypographyImpl
}

private val LightColorPalette = ScheduleColors(
    topBar = TopBar,
    layoutBackground = White,
    searchBox = LightGrayUltimate,
    border = GrayUltimate,
    photoBox = GrayUltimate,
    dateBox = DateBar,
    ultimateTitle = DarkGrayTitle,
    darkTopBar = DarkTopBar,
    menuBackground = MenuBackground,
    menuButton = MenuButton
)

@Composable
fun ScheduleForNatcTeachersTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = LightColorPalette
    val typography = ScheduleTypographyImpl
    /*val colors = if (darkTheme) {
        LightColorPalette
    } else {

    }*/
    CompositionLocalProvider(
        LocalScheduleColors provides colors,
        LocalScheduleTypography provides typography,
        content = content
    )
}

object ScheduleTheme{
    val colors: ScheduleColors
        @Composable
        get() = LocalScheduleColors.current

    val typography: ScheduleTypography
        @Composable
        get() = LocalScheduleTypography.current
}