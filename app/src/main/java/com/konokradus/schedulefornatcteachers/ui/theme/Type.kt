package com.konokradus.schedulefornatcteachers.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.konokradus.schedulefornatcteachers.R
import org.w3c.dom.Text
import javax.annotation.concurrent.Immutable

val Roboto = FontFamily(
    Font(resId = R.font.roboto_bold, weight = FontWeight.Bold),
    Font(resId = R.font.roboto_regular, weight = FontWeight.Normal),

)

@Immutable
data class ScheduleTypography(
    val topBarText: TextStyle,
    val title: TextStyle,
    val dateTitle: TextStyle
)

val ScheduleTypographyImpl = ScheduleTypography(
    topBarText = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 30.sp
    ),
    title = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        letterSpacing = 0.sp
    ),
    dateTitle = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 5.sp
    )
)