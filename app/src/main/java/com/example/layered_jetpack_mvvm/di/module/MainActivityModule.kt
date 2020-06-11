package com.example.layered_jetpack_mvvm.di.module

import android.app.Activity
import com.example.layered_jetpack_mvvm.features.landingPage.entity.SelectionList
import com.example.layered_jetpack_mvvm.features.landingPage.ui.MainActivity
import com.example.layered_jetpack_mvvm.features.landingPage.viewmodel.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MainActivityModule {
    
    companion object {
        @Provides
        fun provideMainViewModel(selectionList: SelectionList): MainActivityViewModel =
            MainActivityViewModel(selectionList)
        
        @Provides
        fun provideSelectionList(): SelectionList = SelectionList()
    }
    
    @Binds
    abstract fun provideMainView(mainActivity: MainActivity): Activity
    
}