package com.konokradus.schedulefornatcteachers.modules.schedule.presentation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases.*
import com.konokradus.schedulefornatcteachers.shared.domain.services.NatkDB
import com.konokradus.schedulefornatcteachers.shared.domain.services.teachersstorage.TeachersStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import java.sql.DriverManager
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TeacherScheduleViewModel
@Inject
constructor(
    private val natkDB: NatkDB,
    private val getLessonItemGroup: GetLessonItemGroup,
    private val addTeacherInStorage: AddTeacherInStorageUseCase,
    private val isTeacherExist: IsTeacherExistUseCase,
    private val removeTeacherFromStorage: RemoveTeacherFromStorageUseCase
) : ViewModel() {
    private val _scheduleViewState: MutableState<TeacherScheduleViewState>
        = mutableStateOf(TeacherScheduleViewState.Loading)
    val scheduleViewState: State<TeacherScheduleViewState>
        get() = _scheduleViewState

    private var properties = Properties().apply {
        setProperty("user", natkDB.user)
        setProperty("password", natkDB.password)
        setProperty("useUnicode", "true")
        setProperty("characterEncoding", "utf-8")
    }

    private fun addFavorite(fio: String){
        addTeacherInStorage(fio)
    }
    private fun removeFavorite(fio: String){
        removeTeacherFromStorage(fio)
    }

    fun loadInfo(fio: String) {
        viewModelScope.launch(Dispatchers.IO){
            try {
                Class.forName("com.mysql.jdbc.Driver")
                val connection = DriverManager.getConnection(
                    natkDB.url,
                    properties
                )
                val schedule = getLessonItemGroup.sortGroup(
                    fio = formatNavArgumentFromNavigate(fio),
                    connection = connection
                )
                Log.d("1",formatNavArgumentFromNavigate(fio))
                _scheduleViewState.value = TeacherScheduleViewState.Loading
                if (schedule[1].date != ""){
                    _scheduleViewState.value = TeacherScheduleViewState.PresentInfo(
                        fio = formatNavArgumentFromNavigate(fio),
                        schedule = schedule,
                        isFavorite = isTeacherExist(formatNavArgumentFromNavigate(fio)),
                        onAddFavoriteClick = {
                            addFavorite(formatNavArgumentFromNavigate(fio))
                            loadInfo(fio)
                        },
                        onRemoveFavoriteClick = {
                            removeFavorite(formatNavArgumentFromNavigate(fio))
                            loadInfo(fio)
                        }
                    )
                } else {
                    _scheduleViewState.value = TeacherScheduleViewState.Error(
                        fio = formatNavArgumentFromNavigate(fio),
                        message = "Расписание отсуствует")
                }
            }catch (ex: Exception){
                _scheduleViewState.value =
                    TeacherScheduleViewState.Error(
                        fio = formatNavArgumentFromNavigate(fio),
                        message = "Расписание отсуствует"
                    )
            }
        }
    }
}