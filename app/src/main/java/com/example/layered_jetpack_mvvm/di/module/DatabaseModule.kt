package com.example.layered_jetpack_mvvm.di.module

import android.content.Context
import com.example.layered_jetpack_mvvm.database.db.RoomLiveDatabase
import dagger.Module
import dagger.Provides

@Module
abstract class DatabaseModule {
    
    companion object {
        @Provides
        fun provideBindingDatabase(context: Context): RoomLiveDatabase = RoomLiveDatabase.getInstance(context)
    }
}