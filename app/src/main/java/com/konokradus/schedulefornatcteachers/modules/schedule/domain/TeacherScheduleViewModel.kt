package com.konokradus.schedulefornatcteachers.modules.schedule.domain

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.models.TeacherScheduleViewState
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases.GetLessonItemGroup
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases.formatNavArgumentFromNavigate
import com.konokradus.schedulefornatcteachers.shared.domain.services.NatkDB
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
    private val getLessonItemGroup: GetLessonItemGroup
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

    fun loadInfo(fio: String) {
        viewModelScope.launch(Dispatchers.IO){
            try {
                Class.forName("com.mysql.jdbc.Driver")
                var connection = DriverManager.getConnection(
                    natkDB.url,
                    properties
                )
                Log.d("1",formatNavArgumentFromNavigate(fio))
                _scheduleViewState.value = TeacherScheduleViewState.Loading
                _scheduleViewState.value = TeacherScheduleViewState.PresentInfo(
                    fio = formatNavArgumentFromNavigate(fio),
                    schedule = getLessonItemGroup.sortGroup(
                        fio = formatNavArgumentFromNavigate(fio),
                        connection = connection
                    )
                )
            }catch (ex: Exception){
                _scheduleViewState.value =
                    TeacherScheduleViewState.Error(ex.message ?: "Неизвестная ошибка")
            }
        }
    }
}