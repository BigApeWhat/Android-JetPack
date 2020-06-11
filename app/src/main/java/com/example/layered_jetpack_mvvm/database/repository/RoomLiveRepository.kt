package com.example.layered_jetpack_mvvm.database.repository

import com.example.layered_jetpack_mvvm.database.doa.RoomLiveDoa
import com.example.layered_jetpack_mvvm.database.entity.RoomLiveData
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RoomLiveRepository @Inject constructor(
    private val roomLiveDao: RoomLiveDoa
) {
    
    fun getBindingData(): Flowable<List<RoomLiveData>> {
        return roomLiveDao.load()
    }
    
    fun deleteById(id: String): Completable {
        return roomLiveDao.deleteById(id)
    }
    
    fun saveListDataEntry(dataList: List<RoomLiveData>): Completable {
        return roomLiveDao.saveList(dataList)
    }
    
    fun saveSingleDataEntry(data: RoomLiveData): Completable {
        return roomLiveDao.save(data)
    }
}
