package com.farahani.elmira.data.datasource

import com.farahani.elmira.data.BuildConfig
import com.farahani.elmira.data.NewsDataService
import com.farahani.elmira.data.mappers.map
import com.farahani.elmira.domain.entity.ArticleObject
import io.reactivex.Single

class NewsDataSourceImpl(
    private val service: NewsDataService
) : NewsDataSource {

    override fun getTopHeadLines(country: String): Single<List<ArticleObject>> =
        service.getTopHeadLines(country, BuildConfig.API_KEY).map {
            it.map { article -> article.map() }
        }
}