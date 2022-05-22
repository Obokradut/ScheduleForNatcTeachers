package com.konokradus.schedulefornatcteachers.shared.domain.di

import android.content.Context
import com.konokradus.schedulefornatcteachers.shared.domain.services.teachersstorage.ITeachersStorage
import com.konokradus.schedulefornatcteachers.shared.domain.services.teachersstorage.TeachersStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class Services {
    @Singleton
    @Provides
    fun provideTeacherStorage(@ApplicationContext appContext: Context): ITeachersStorage = TeachersStorage(appContext)
}