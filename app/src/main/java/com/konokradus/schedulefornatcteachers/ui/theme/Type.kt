package com.konokradus.schedulefornatcteachers.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.konokradus.schedulefornatcteachers.R
import org.w3c.dom.Text
import javax.annotation.concurrent.Immutable

val Roboto = FontFamily(
    Font(resId = R.font.roboto_bold, weight = FontWeight.Bold),
    Font(resId = R.font.roboto_regular, weight = FontWeight.Normal),
    Font(resId = R.font.roboto_black, weight = FontWeight.Black)
)

@Immutable
data class ScheduleTypography(
    val topBarText: TextStyle,
    val menuButtonText: TextStyle,
    val title: TextStyle,
    val search: TextStyle,
    val titleBold: TextStyle,
    val dateTitle: TextStyle
)

val defaultTextFontSize = 24.dp
//TODO Сделать общий размер текста. Уменьшить размер текста

val ScheduleTypographyImpl = ScheduleTypography(
    topBarText = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 10.sp
    ),
    menuButtonText = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Black,
        fontSize = 24.sp,
        letterSpacing = 2.sp,
        lineHeight = 0.9.em
    ),
    title = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        letterSpacing = 0.sp
    ),
    titleBold = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    dateTitle = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 5.sp
    ),
    search = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        letterSpacing = 0.sp
    )
)