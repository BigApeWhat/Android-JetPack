package com.example.layered_jetpack_mvvm.features.navigation.datamodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FormEntryData(val name: String?, val address: String?, val phone: String?): Parcelable {
    fun getErrorMessage(): String {
        val field = when {
            name.isNullOrBlank() -> { "name" }
            address.isNullOrBlank() -> { "address" }
            else -> { "phone" }
        }
        return "The field $field does not have a valid entry"
    }
    
    override fun toString(): String = "Hello $name which lives on $address. May I call you at $phone"
    
}