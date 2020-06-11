package com.example.layered_jetpack_mvvm

import com.example.layered_jetpack_mvvm.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MainApplication: DaggerApplication() {
    
    override fun onCreate() {
        super.onCreate()
        initResources()
    }
    
    fun initResources() {
        // If you would have application resources
    }
    
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerApplicationComponent.builder().application(this).build()
    
}
