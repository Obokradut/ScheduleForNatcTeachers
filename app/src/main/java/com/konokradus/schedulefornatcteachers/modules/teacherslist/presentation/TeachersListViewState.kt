package com.konokradus.schedulefornatcteachers.modules.teacherslist.presentation

sealed interface TeachersListViewState {
    object Loading : TeachersListViewState
    data class PresentInfo(
        val listTeachers: List<String>,
        val onTeacherClick: (String) -> Unit
    ) : TeachersListViewState
    data class Error(
        val message: String
    ) : TeachersListViewState
}