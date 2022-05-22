package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases

import com.konokradus.schedulefornatcteachers.shared.domain.models.TeachersResponse
import com.konokradus.schedulefornatcteachers.shared.domain.services.teachersstorage.ITeachersStorage
import com.konokradus.schedulefornatcteachers.shared.domain.services.teachersstorage.TeachersStorage
import javax.inject.Inject

class AddTeacherInStorageUseCase
@Inject
constructor(
    private val teachersStorage: ITeachersStorage
) {
    operator fun invoke(fio: String) {
        teachersStorage.teachersFio = fio
    }
}