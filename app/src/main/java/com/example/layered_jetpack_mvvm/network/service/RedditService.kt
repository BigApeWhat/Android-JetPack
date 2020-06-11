package com.example.layered_jetpack_mvvm.network.service

import com.example.layered_jetpack_mvvm.network.reddit.response.RedditApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditService {
    @GET("/r/aww/hot.json")
    fun getPosts(
        @Query("limit") loadSize: Int = 30,
        @Query("after") after: String? = null,
        @Query("before") before: String? = null
    ): Call<RedditApiResponse>
}