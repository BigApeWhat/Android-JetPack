package com.example.layered_jetpack_mvvm.common.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.internal.Beta
import javax.inject.Inject

@Beta
abstract class DaggerAppCompatActivity : AppCompatActivity(), HasAndroidInjector {
    
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }
    
    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}
