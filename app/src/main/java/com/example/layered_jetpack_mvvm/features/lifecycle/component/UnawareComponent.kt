package com.example.layered_jetpack_mvvm.features.lifecycle.component

class UnawareComponent (private val callback: () -> Unit) {

    fun something() {
        callback()
    }
}