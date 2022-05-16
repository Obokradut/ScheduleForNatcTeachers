package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases

import java.util.*

fun formatNavArgumentToNavigate(fio: String): String{
    return android.util.Base64.encodeToString(fio.toByteArray(Charsets.UTF_8), android.util.Base64.DEFAULT)
}

fun formatNavArgumentFromNavigate(fio: String): String{
    return android.util.Base64.decode(fio, android.util.Base64.DEFAULT).toString(Charsets.UTF_8)
}