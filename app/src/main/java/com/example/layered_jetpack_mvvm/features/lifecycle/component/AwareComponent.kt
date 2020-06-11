package com.example.layered_jetpack_mvvm.features.lifecycle.component

import androidx.lifecycle.Lifecycle

class AwareComponent (private val lifecycle: Lifecycle, private val callback: (text: String) -> Unit) {
    
    fun something() {
        when {
            lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED) -> {
                callback("Created Activity")
            }
            lifecycle.currentState.isAtLeast(Lifecycle.State.DESTROYED) -> {
                callback("Destroyed Activity")
            }
            else -> {
                callback("Unknown Activity")
            }
        }
    }
}