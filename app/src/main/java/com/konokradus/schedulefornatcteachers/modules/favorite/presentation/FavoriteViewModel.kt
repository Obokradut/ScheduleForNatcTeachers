package com.konokradus.schedulefornatcteachers.modules.favorite.presentation

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases.SearchFavoriteTeachersUseCase
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases.formatNavArgumentToNavigate
import com.konokradus.schedulefornatcteachers.navigation.schedule.main.IScheduleMainNavProvider
import com.konokradus.schedulefornatcteachers.shared.domain.services.NatkDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.sql.DriverManager
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel
@Inject
constructor(
    private val mainNavProvider: IScheduleMainNavProvider,
    private val searchFavoriteTeachers: SearchFavoriteTeachersUseCase
) : ViewModel() {
    private val _favoriteViewState: MutableState<FavoriteViewState>
        = mutableStateOf(FavoriteViewState.Loading)
    val favoriteViewState: State<FavoriteViewState>
        get() = _favoriteViewState

    private val _searchBox = mutableStateOf("")
    val searchBox: State<String>
        get() = _searchBox

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
        viewModelScope.launch(){
            try {
                _favoriteViewState.value = FavoriteViewState.Loading
                val teachersList = searchFavoriteTeachers(_searchBox.value)
                _favoriteViewState.value = FavoriteViewState.PresentInfo(
                    listFavoriteTeachers = teachersList,
                    onFavoriteTeacherClick = {
                        mainNavProvider.navigateToSchedule(formatNavArgumentToNavigate(it))
                    }
                )
            } catch (ex: Exception) {
                _favoriteViewState.value =
                    FavoriteViewState.Error(ex.message ?: "Неизвестная ошибка")
            }
        }
    }
}