package com.farahani.elmira.data

import com.farahani.elmira.data.entity.Article
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsDataService {

    @GET(value = "${BuildConfig.BASE_API_URL}/v2/top-headlines")
    fun getTopHeadLines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Single<List<Article>>
}