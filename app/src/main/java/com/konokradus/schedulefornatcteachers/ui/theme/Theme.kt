package com.konokradus.schedulefornatcteachers.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
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
    layoutBackground = LightBackground,
    searchBox = LightGrayUltimate,
    border = GrayUltimate,
    photoBox = GrayUltimate,
    dateBox = DateBar,
    ultimateTitle = LightDarkGrayTitle,
    darkTopBar = MenuTopBar,
    menuBackground = MenuBackground,
    menuButton = MenuButton,
    searchIcon = SearchIcon
)
private val DarkColorPalette = ScheduleColors(
    topBar = DarkTopBar,
    layoutBackground = DarkBackground,
    searchBox = DarkLightGrayUltimate,
    border = DarkGrayUltimate,
    photoBox = DarkGrayUltimate,
    dateBox = DarkDateBar,
    ultimateTitle = DarkDarkGrayTitle,
    darkTopBar = DarkMenuTopBar,
    menuBackground = DarkMenuBackground,
    menuButton = DarkMenuButton,
    searchIcon = DarkSearchIcon
)

@Composable
fun ScheduleForNatkTeachersTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val typography = ScheduleTypographyImpl
    val colors = LightColorPalette
    /*val colors = if (darkTheme) {
        LightColorPalette
    } else {
        DarkColorPalette
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