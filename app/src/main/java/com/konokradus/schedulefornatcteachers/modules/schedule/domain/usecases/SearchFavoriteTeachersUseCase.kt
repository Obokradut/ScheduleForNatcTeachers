package com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases

import androidx.compose.ui.text.toLowerCase
import java.util.*
import javax.inject.Inject

class SearchFavoriteTeachersUseCase
@Inject
constructor(
    private val getAllTeachersFromStorage: GetAllTeachersFromStorageUseCase
) {
    operator fun invoke(fio: String): List<String> {
        return getAllTeachersFromStorage().filter { it.lowercase(Locale.getDefault()).contains(fio)}
    }
}