package com.example.layered_jetpack_mvvm.common.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {
    
    private var activity: AppCompatActivity? = null
    
    @LayoutRes
    protected abstract fun getLayout(): Int
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayout(), container, false)
    }
    
    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity = context as AppCompatActivity
    }
    
    override fun onDetach() {
        super.onDetach()
        activity = null
    }
    
    open fun getBaseActivity(): AppCompatActivity? {
        return activity
    }
}