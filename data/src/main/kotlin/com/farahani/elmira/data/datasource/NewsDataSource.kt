package com.farahani.elmira.data.datasource

import com.farahani.elmira.domain.entity.ArticleObject
import io.reactivex.Single

interface NewsDataSource {

    fun getTopHeadLines(country: String): Single<List<ArticleObject>>
}