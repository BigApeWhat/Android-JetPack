package com.example.layered_jetpack_mvvm.features.databinding.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class UseBinding : BaseObservable() {
    @get:Bindable
    var varPass : String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.varPass)
        }
}