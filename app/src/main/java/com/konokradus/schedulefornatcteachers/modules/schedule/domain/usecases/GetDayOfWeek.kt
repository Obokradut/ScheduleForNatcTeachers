package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases

import java.util.*

fun getDayOfWeek (date: Date): String {
    return when (date.day){
        1 -> "ПН"
        2 -> "ВТ"
        3 -> "СР"
        4 -> "ЧТ"
        5 -> "ПТ"
        6 -> "СБ"
        7 -> "ВС"
        else -> "NULL"
    }
}