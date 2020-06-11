package com.example.layered_jetpack_mvvm.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.layered_jetpack_mvvm.database.doa.RoomLiveDoa
import com.example.layered_jetpack_mvvm.database.entity.RoomLiveData

@Database(entities = [RoomLiveData::class], version = 1, exportSchema = false)
abstract class RoomLiveDatabase : RoomDatabase() {
    
    abstract fun bindingDoa(): RoomLiveDoa
    
    companion object {
        
        @Volatile private var INSTANCE: RoomLiveDatabase? = null
        
        fun getInstance(context: Context): RoomLiveDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                RoomLiveDatabase::class.java, "BindingDatabase.db")
                .build()
    }
}
