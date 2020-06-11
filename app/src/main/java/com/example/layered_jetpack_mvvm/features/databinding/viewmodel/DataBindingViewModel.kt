package com.example.layered_jetpack_mvvm.features.databinding.viewmodel

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModel
import com.example.layered_jetpack_mvvm.features.databinding.model.UseBinding
import javax.inject.Inject

class DataBindingViewModel @Inject constructor() : ViewModel() {
    private val binds = UseBinding()
    
    fun getBindings(): UseBinding {
        return binds
    }
    
    fun updateVarPass(temp: String) {
        binds.varPass = temp
    }
    
    fun getTextChangeListener(): TextWatcher = object: TextWatcher {
        override fun afterTextChanged(text: Editable) {
            binds.varPass = text.toString()
        }
    
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }
}
