package com.example.layered_jetpack_mvvm.di.module

import android.app.Activity
import com.example.layered_jetpack_mvvm.features.paging.ui.PagingActivity
import com.example.layered_jetpack_mvvm.features.paging.viewmodel.PagingViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class PagingModule {
    
    companion object {
        @Provides
        fun providePagingViewModel(): PagingViewModel = PagingViewModel()
    }
    
    @Binds
    abstract fun providePagingView(pagingActivity: PagingActivity): Activity
    
}