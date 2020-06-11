package com.example.layered_jetpack_mvvm.di.module

import android.app.Activity
import com.example.layered_jetpack_mvvm.features.databinding.ui.DataBindingActivity
import com.example.layered_jetpack_mvvm.features.databinding.viewmodel.DataBindingViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DataBindingActivityModule {
    
    companion object {
        @Provides
        fun provideDataBindingViewModel(): DataBindingViewModel =
            DataBindingViewModel()
        
    }
    
    @Binds
    abstract fun provideDataBindingView(dataBindingActivity: DataBindingActivity): Activity
    
}