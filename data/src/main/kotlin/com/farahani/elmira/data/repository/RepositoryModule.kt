package com.farahani.elmira.data.repository

import com.farahani.elmira.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun newsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}