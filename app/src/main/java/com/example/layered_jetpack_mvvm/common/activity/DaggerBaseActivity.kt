package com.example.layered_jetpack_mvvm.common.activity

import android.os.Bundle
import androidx.annotation.LayoutRes

abstract class DaggerBaseActivity: DaggerAppCompatActivity() {
    
    @LayoutRes
    protected abstract fun getLayout(): Int
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (setupContent()) {
            setContentView(getLayout())
        }
    }
    
    open fun setupContent(): Boolean {
        return true
    }
}