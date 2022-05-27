package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases

fun formatNavArgumentToNavigate(fio: String): String{
    return android.util.Base64.encodeToString(
        fio.toByteArray(Charsets.UTF_8),
        android.util.Base64.URL_SAFE
    )
}

fun formatNavArgumentFromNavigate(fio: String): String{
    return android.util.Base64.decode(
        fio,
        android.util.Base64.URL_SAFE
    ).toString(Charsets.UTF_8)
}