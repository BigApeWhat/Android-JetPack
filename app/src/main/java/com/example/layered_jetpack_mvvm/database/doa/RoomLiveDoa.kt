package com.example.layered_jetpack_mvvm.database.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.layered_jetpack_mvvm.database.entity.RoomLiveData
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface RoomLiveDoa {
    @Insert(onConflict = REPLACE)
    fun save(bindingdata: RoomLiveData): Completable
    
    @Insert(onConflict = REPLACE)
    fun saveList(listData: List<RoomLiveData>): Completable
    
    @Query("DELETE FROM roomlivedata WHERE id = :id")
    fun deleteById(id: String): Completable
    
    @Query("SELECT * FROM roomlivedata")
    fun load(): Flowable<List<RoomLiveData>>
}
