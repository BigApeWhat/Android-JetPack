package com.example.layered_jetpack_mvvm.di.module

import com.example.layered_jetpack_mvvm.database.db.RoomLiveDatabase
import com.example.layered_jetpack_mvvm.database.doa.RoomLiveDoa
import dagger.Module
import dagger.Provides

@Module
abstract class RepositoryModule {
    companion object {
        @Provides
        fun provideRoomDoa(roomLiveDatabase: RoomLiveDatabase): RoomLiveDoa = roomLiveDatabase.bindingDoa()
    }
}