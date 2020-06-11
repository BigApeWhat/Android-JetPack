package com.example.layered_jetpack_mvvm.di.component

import android.app.Application
import com.example.layered_jetpack_mvvm.di.module.ActivityBuilder
import com.example.layered_jetpack_mvvm.di.module.ContextModule
import com.example.layered_jetpack_mvvm.di.module.DatabaseModule
import com.example.layered_jetpack_mvvm.di.module.RepositoryModule
import com.example.layered_jetpack_mvvm.di.module.RetrofitModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityBuilder::class, AndroidInjectionModule::class, DatabaseModule::class, RepositoryModule::class, ContextModule::class, RetrofitModule::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {
    
    @Component.Builder
    interface Builder {
        
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }
}