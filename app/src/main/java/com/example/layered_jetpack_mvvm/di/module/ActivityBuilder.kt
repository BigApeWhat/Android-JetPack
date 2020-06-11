package com.example.layered_jetpack_mvvm.di.module

import com.example.layered_jetpack_mvvm.features.databinding.ui.DataBindingActivity
import com.example.layered_jetpack_mvvm.features.paging.ui.PagingActivity
import com.example.layered_jetpack_mvvm.features.room.ui.RoomActivity
import com.example.layered_jetpack_mvvm.features.landingPage.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity
    
    @ContributesAndroidInjector(modules = [RepositoryModule::class])
    abstract fun bindRoomActivity(): RoomActivity
    
    @ContributesAndroidInjector
    abstract fun bindDataBindActivity(): DataBindingActivity
    
    @ContributesAndroidInjector(modules = [PagingModule::class])
    abstract fun bindPagingActivity(): PagingActivity
    
}