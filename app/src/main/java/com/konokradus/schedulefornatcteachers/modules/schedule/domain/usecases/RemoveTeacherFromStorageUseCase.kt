package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases

import com.konokradus.schedulefornatcteachers.shared.domain.services.teachersstorage.ITeachersStorage
import javax.inject.Inject

class RemoveTeacherFromStorageUseCase
@Inject
constructor(
    private val teachersStorage: ITeachersStorage
) {
    operator fun invoke(fio:String) {
        val teacherStorageList = teachersStorage.teachersFio.toMutableList()
        teacherStorageList.remove(fio)
        teachersStorage.teachersFio = teacherStorageList.toMutableSet()
    }
}