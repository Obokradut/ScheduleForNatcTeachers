package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases

import com.konokradus.schedulefornatcteachers.shared.domain.services.teachersstorage.ITeachersStorage
import com.konokradus.schedulefornatcteachers.shared.domain.services.teachersstorage.TeachersStorage
import javax.inject.Inject

class IsTeacherExistUseCase
@Inject
constructor(
    private val teachersStorage: ITeachersStorage
) {
    operator fun invoke(fio: String): Boolean {
        val teacherStorageList = teachersStorage.teachersFio
        return teacherStorageList.toMutableList().firstOrNull { it == fio } != null
    }
}