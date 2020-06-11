package com.example.layered_jetpack_mvvm.features.databinding.ui

import androidx.lifecycle.ViewModel
import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.common._interface.ActivityViewModel
import com.example.layered_jetpack_mvvm.common.activity.DaggerBaseActivity
import com.example.layered_jetpack_mvvm.features.databinding.viewmodel.DataBindingViewModel
import javax.inject.Inject

class DataBindingActivity : DaggerBaseActivity(), ActivityViewModel {
    @Inject
    lateinit var viewModel: DataBindingViewModel
    
    override fun getLayout(): Int = R.layout.activity_data_binding
    
    override fun getViewModel(): ViewModel = viewModel

}
