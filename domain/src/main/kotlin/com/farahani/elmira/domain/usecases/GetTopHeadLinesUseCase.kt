package com.farahani.elmira.domain.usecases

import com.farahani.elmira.domain.base.BaseUseCase
import com.farahani.elmira.domain.entity.ArticleObject
import com.farahani.elmira.domain.repository.NewsRepository
import com.farahani.elmira.domain.transformer.STransformer
import io.reactivex.Single

class GetTopHeadLinesUseCase(
    private val repository: NewsRepository,
    private val transformer: STransformer<List<ArticleObject>>
) : BaseUseCase<String, List<ArticleObject>> {
    override fun execute(request: String): Single<List<ArticleObject>> =
        repository.getTopHeadLines(request).compose(transformer)
}