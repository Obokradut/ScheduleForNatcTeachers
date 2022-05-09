package com.konokradus.schedulefornatcteachers.modules.schedule.domain

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konokradus.schedulefornatcteachers.shared.domain.services.NatkDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

@HiltViewModel
class TeachersListViewModel
@Inject
constructor(
    private val natkDB: NatkDB
) : ViewModel() {
    var teachersList = mutableStateOf(listOf<String>())

    init {
        viewModelScope.launch(Dispatchers.IO){
            teachersList.value = natkDB.getAllTeachers()
        }
    }
}