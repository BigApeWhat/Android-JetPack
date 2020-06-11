package com.example.layered_jetpack_mvvm.features.paging.datasource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.layered_jetpack_mvvm.network.reddit.model.RedditPost
import com.example.layered_jetpack_mvvm.network.reddit.response.RedditApiResponse
import com.example.layered_jetpack_mvvm.network.service.RedditService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RedditDataSource @Inject constructor(val redditService: RedditService) : PageKeyedDataSource<String, RedditPost>() {
    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String, RedditPost>) {
        redditService.getPosts(loadSize = params.requestedLoadSize)
            .enqueue(object : Callback<RedditApiResponse> {
            
                override fun onFailure(call: Call<RedditApiResponse>?, t: Throwable?) {
                    Log.e("RedditDataSource", "Failed to fetch data!")
                }
            
                override fun onResponse(
                    call: Call<RedditApiResponse>?,
                    response: Response<RedditApiResponse>
                ) {
                
                    val listing = response.body()?.data
                    val redditPosts = listing?.children?.map { it.data }
                    callback.onResult(redditPosts ?: listOf(), listing?.before, listing?.after)
                }
            })
    }
    
    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, RedditPost>) {
        redditService.getPosts(loadSize = params.requestedLoadSize, after = params.key)
            .enqueue(object : Callback<RedditApiResponse> {
            
                override fun onFailure(call: Call<RedditApiResponse>?, t: Throwable?) {
                    Log.e("RedditDataSource", "Failed to fetch data!")
                }
            
                override fun onResponse(
                    call: Call<RedditApiResponse>?,
                    response: Response<RedditApiResponse>) {
                
                    val listing = response.body()?.data
                    val items = listing?.children?.map { it.data }
                    callback.onResult(items ?: listOf(), listing?.after)
                }
            })
    }
    
    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, RedditPost>) {
        redditService.getPosts(loadSize = params.requestedLoadSize, before = params.key)
            .enqueue(object : Callback<RedditApiResponse> {
            
                override fun onFailure(call: Call<RedditApiResponse>?, t: Throwable?) {
                    Log.e("RedditDataSource", "Failed to fetch data!")
                }
            
                override fun onResponse(
                    call: Call<RedditApiResponse>?,
                    response: Response<RedditApiResponse>) {
                
                    val listing = response.body()?.data
                    val items = listing?.children?.map { it.data }
                    callback.onResult(items ?: listOf(), listing?.before)
                }
            })
    }
}