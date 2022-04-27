package com.konokradus.schedulefornatcteachers.shared.domain.di

import com.konokradus.schedulefornatcteachers.navigation.schedule.IScheduleDrawerNavProvider
import com.konokradus.schedulefornatcteachers.navigation.schedule.IScheduleMainNavProvider
import com.konokradus.schedulefornatcteachers.navigation.schedule.ScheduleDrawerNavProvider
import com.konokradus.schedulefornatcteachers.navigation.schedule.ScheduleMainNavProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent :: class)
@Module
class Navigation {
    @Singleton
    @Provides
    fun provideScheduleMainNavigation(): IScheduleMainNavProvider = ScheduleMainNavProvider()

    @Singleton
    @Provides
    fun provideScheduleDrawerNavigation(): IScheduleDrawerNavProvider = ScheduleDrawerNavProvider()
}