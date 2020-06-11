package com.example.layered_jetpack_mvvm.network.reddit.model

import com.google.gson.annotations.SerializedName

data class RedditPost (
    val key: String,
    val title: String,
    val score: Int,
    val author: String,
    @SerializedName("num_comments")
    val commentCount: Int
)
