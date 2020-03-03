package com.farahani.elmira.data.network

import com.farahani.elmira.data.NewsDataService
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class NetworkModule {

    @Provides
    @Reusable
    fun newsDataService(dataServiceProvider: DataServiceProvider) =
        dataServiceProvider.create(NewsDataService::class.java)
}