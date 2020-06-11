package com.example.layered_jetpack_mvvm.di.module

import com.example.layered_jetpack_mvvm.features.paging.datasource.RedditDataSource
import com.example.layered_jetpack_mvvm.network.service.RedditService
import dagger.Module
import dagger.Provides

@Module
abstract class PagingDataSource {
    companion object {
        @Provides
        fun provideRedditDataSource(redditService: RedditService): RedditDataSource = RedditDataSource(redditService)
    }
}