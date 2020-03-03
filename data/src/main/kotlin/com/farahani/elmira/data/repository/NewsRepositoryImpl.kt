package com.farahani.elmira.data.repository

import com.farahani.elmira.data.datasource.NewsDataSource
import com.farahani.elmira.domain.entity.ArticleObject
import com.farahani.elmira.domain.repository.NewsRepository
import io.reactivex.Single

class NewsRepositoryImpl(
    private val newsDataSource: NewsDataSource
) : NewsRepository {
    override fun getTopHeadLines(country: String): Single<List<ArticleObject>> =
        newsDataSource.getTopHeadLines(country)
}