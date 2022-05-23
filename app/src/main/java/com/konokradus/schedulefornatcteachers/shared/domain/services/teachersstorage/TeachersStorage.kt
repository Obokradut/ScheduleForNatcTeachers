package com.konokradus.schedulefornatcteachers.shared.domain.services.teachersstorage

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log

private const val TEACHER_PREFERENCE = "teacher_preference"
private const val TEACHER_FIO = "teacher_fio"

class TeachersStorage
constructor(
    appContext: Context,
) : ITeachersStorage {
    private val _teachersStorage: SharedPreferences =
        appContext.getSharedPreferences(TEACHER_PREFERENCE, MODE_PRIVATE)

    override var teachersFio: MutableSet<String>
        get() = _teachersStorage.getStringSet(TEACHER_FIO, mutableSetOf()) ?: mutableSetOf()
        set(value) {
            _teachersStorage.edit().putStringSet(TEACHER_FIO, value).apply()
        }

    var f = teachersFio.toList()
    var fq = teachersFio.toList()
}
