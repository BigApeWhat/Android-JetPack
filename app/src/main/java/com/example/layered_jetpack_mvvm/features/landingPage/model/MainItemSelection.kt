package com.example.layered_jetpack_mvvm.features.landingPage.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MainItemSelection (@StringRes val title: Int, @ColorRes val fontColor: Int, @DrawableRes val image: Int)