package com.example.layered_jetpack_mvvm.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomLiveData(
    @PrimaryKey val id: String,
    val name: String,
    val description: String
)
