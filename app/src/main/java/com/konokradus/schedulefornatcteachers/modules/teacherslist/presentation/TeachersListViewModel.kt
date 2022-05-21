package com.konokradus.schedulefornatcteachers.modules.teacherslist.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases.formatNavArgumentToNavigate
import com.konokradus.schedulefornatcteachers.navigation.schedule.main.IScheduleMainNavProvider
import com.konokradus.schedulefornatcteachers.shared.domain.services.NatkDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import java.sql.DriverManager
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TeachersListViewModel
@Inject
constructor(
    private val natkDB: NatkDB,
    private val mainNavProvider: IScheduleMainNavProvider
) : ViewModel() {

    private val _teacherViewState: MutableState<TeachersListViewState>
        = mutableStateOf(TeachersListViewState.Loading)
    val teacherViewState: State<TeachersListViewState>
        get() = _teacherViewState

    private val _searchBox = mutableStateOf("")
    val searchBox: State<String>
        get() = _searchBox

    private var properties = Properties().apply {
        setProperty("user", natkDB.user)
        setProperty("password", natkDB.password)
        setProperty("useUnicode", "true")
        setProperty("characterEncoding", "utf-8")
    }

    init {
        loadInfo()
    }

    fun searchChanged(
        searchFio: String
    ){
        _searchBox.value = searchFio
        loadInfo()
    }

    private fun loadInfo(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                Class.forName("com.mysql.jdbc.Driver")
                val connection = DriverManager.getConnection(
                    natkDB.url,
                    properties
                )
                _teacherViewState.value = TeachersListViewState.Loading
                val teachersList = natkDB.getTeachers(
                    connection = connection,
                    fio = searchBox.value
                )
                _teacherViewState.value = TeachersListViewState.PresentInfo(
                    listTeachers = teachersList,
                    onTeacherClick = {
                        mainNavProvider.navigateToSchedule(formatNavArgumentToNavigate(it))
                    }
                )
            } catch (ex: Exception) {
                _teacherViewState.value =
                    TeachersListViewState.Error(ex.message ?: "Неизвестная ошибка")
            }
        }
    }
}