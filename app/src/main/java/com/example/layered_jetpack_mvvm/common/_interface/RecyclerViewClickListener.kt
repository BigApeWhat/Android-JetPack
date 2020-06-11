package com.example.layered_jetpack_mvvm.common._interface

import android.view.View

interface RecyclerViewClickListener {
    fun recyclerViewPositionClicked(view: View, position: Int)
}