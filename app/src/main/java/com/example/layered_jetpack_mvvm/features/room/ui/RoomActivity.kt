package com.example.layered_jetpack_mvvm.features.room.ui

import androidx.lifecycle.ViewModel
import com.example.layered_jetpack_mvvm.R
import com.example.layered_jetpack_mvvm.common._interface.ActivityViewModel
import com.example.layered_jetpack_mvvm.common.activity.DaggerBaseActivity
import com.example.layered_jetpack_mvvm.features.room.viewmodel.RoomViewModel
import javax.inject.Inject

class RoomActivity : DaggerBaseActivity(), ActivityViewModel {
    @Inject
    lateinit var viewModel: RoomViewModel
    
    override fun getLayout(): Int = R.layout.activity_room
    
    override fun getViewModel(): ViewModel = viewModel
}
