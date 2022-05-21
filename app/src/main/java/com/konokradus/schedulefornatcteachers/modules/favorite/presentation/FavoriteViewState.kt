package com.konokradus.schedulefornatcteachers.modules.favorite.presentation

sealed interface FavoriteViewState {
    object Loading : FavoriteViewState
    data class PresentInfo(
        val listFavoriteTeachers: List<String>,
        val onFavoriteTeacherClick: (String) -> Unit
    ) : FavoriteViewState
    data class Error(
        val massage: String
    ) : FavoriteViewState
}