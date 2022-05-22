package com.konokradus.schedulefornatcteachers.shared.domain.services.teachersstorage

interface ITeachersStorage {
    var teachersFio: String
    val isTeacherExist: Boolean
}