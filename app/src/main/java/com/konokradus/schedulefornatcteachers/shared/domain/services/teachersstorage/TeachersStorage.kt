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
    private var _teachersStorage: SharedPreferences =
        appContext.getSharedPreferences(TEACHER_PREFERENCE, MODE_PRIVATE)

    override var teachersFio: String = ""
        get() = _teachersStorage.getString(TEACHER_FIO, "") ?: ""
        set(value) {
            field = value
            _teachersStorage.edit().putString(TEACHER_FIO, value).apply()
        }

    override val isTeacherExist: Boolean
        get() = false //TODO


    var log = teachersFio
    var allPreferences: Map<String, *> = _teachersStorage.getAll()
    var i = 1

    /*fun isTeacherInStorage (fio: String): Boolean {
        return teachersStorage.getString(TEACHER_FIO , fio) != null
    }

    fun addTeacherInStorage (fio: String) {
        teachersStorage.edit().putString(TEACHER_FIO,fio).apply()
    }

    fun removeTeacherFromStorage () {
        teachersStorage.edit().putString(TEACHER_FIO,"").apply()
    }*/
}
