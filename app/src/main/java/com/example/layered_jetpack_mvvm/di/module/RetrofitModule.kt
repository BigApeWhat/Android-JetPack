package com.example.layered_jetpack_mvvm.di.module

import com.example.layered_jetpack_mvvm.network.service.RedditService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class RetrofitModule {
    
    companion object {
        private val BASE_URL = "https://www.reddit.com/"
        
        @Provides
        fun createService(): RedditService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RedditService::class.java)
        }
    }

}