package com.example.layered_jetpack_mvvm.features.room.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.layered_jetpack_mvvm.database.entity.RoomLiveData
import com.example.layered_jetpack_mvvm.database.repository.RoomLiveRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RoomViewModel @Inject constructor(private val repo: RoomLiveRepository) : ViewModel() {
    private val disposable = CompositeDisposable()
    val liveData: MutableLiveData<List<RoomLiveData>> = MutableLiveData()
    
    fun checkAddFields(vararg field: String): Boolean = field.any { it.isBlank() }
    
    fun reloadData() {
        disposable.add(loadDataFlowable()
            .subscribe {
                if (it.isEmpty()) {
                    saveDataList(createDataList())
                } else {
                    liveData.setValue(it)
                }
            }
        )
    }
    
    fun saveDataEntry(dataItem: RoomLiveData) {
        disposable.add(repo.saveSingleDataEntry(dataItem)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                reloadData()
            })
    }
    
    fun deleteById(id: String) {
        disposable.add(repo.deleteById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                reloadData()
            })
    }
    
    private fun loadDataFlowable(): Flowable<List<RoomLiveData>> {
        return getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
    
    private fun saveDataList(dataList: List<RoomLiveData>) {
        disposable.add(saveData(dataList)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                liveData.setValue(dataList)
            })
    }
    
    private fun createDataList(): List<RoomLiveData> {
        val list: MutableList<RoomLiveData> = mutableListOf()
        list.add(RoomLiveData("1", "First", "Im special"))
        list.add(RoomLiveData("2", "second", "Im not special"))
        return list
    }
    
    private fun saveData(dataList: List<RoomLiveData>): Completable {
        return repo.saveListDataEntry(dataList)
    }
    
    private fun getData(): Flowable<List<RoomLiveData>> {
        return repo.getBindingData()
    }
    
    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
    
}
