package com.example.layered_jetpack_mvvm.features.landingPage.viewmodel

import androidx.lifecycle.ViewModel
import com.example.layered_jetpack_mvvm.features.landingPage.entity.SelectionList
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private var selectionListEntity: SelectionList) : ViewModel() {
    
    fun getSelectionListData() = selectionListEntity.getSelectionList()
    
}
