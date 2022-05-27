package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases

import com.konokradus.schedulefornatcteachers.shared.domain.services.teachersstorage.ITeachersStorage
import javax.inject.Inject

class GetAllTeachersFromStorageUseCase
@Inject
constructor(
    private val teachersStorage: ITeachersStorage
) {
    operator fun invoke(): List<String> {
        return teachersStorage.teachersFio.toList()
    }
}