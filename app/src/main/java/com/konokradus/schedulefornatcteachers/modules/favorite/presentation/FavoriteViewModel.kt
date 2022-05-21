package com.konokradus.schedulefornatcteachers.modules.favorite.presentation

import android.content.SharedPreferences
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.konokradus.schedulefornatcteachers.modules.schedule.domain.usecases.GetLessonItemGroup
import com.konokradus.schedulefornatcteachers.shared.domain.services.NatkDB
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel
@Inject
constructor(
    private val natkDB: NatkDB,
    private val getLessonItemGroup: GetLessonItemGroup
) : ViewModel() {
    private val _favoriteViewState: MutableState<FavoriteViewState>
        = mutableStateOf(FavoriteViewState.Loading)
    val favoriteViewState: State<FavoriteViewState>
        get() = _favoriteViewState

    private var properties = Properties().apply {
        setProperty("user", natkDB.user)
        setProperty("password", natkDB.password)
        setProperty("useUnicode", "true")
        setProperty("characterEncoding", "utf-8")
    }
}