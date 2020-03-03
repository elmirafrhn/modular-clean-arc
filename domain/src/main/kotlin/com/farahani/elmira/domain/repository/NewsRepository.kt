package com.farahani.elmira.domain.repository

import com.farahani.elmira.domain.entity.ArticleObject
import io.reactivex.Single

interface NewsRepository {
    fun getTopHeadLines(country: String): Single<List<ArticleObject>>
}