package com.farahani.elmira.data.mappers

import com.farahani.elmira.data.entity.Article
import com.farahani.elmira.domain.entity.ArticleObject

fun Article.map() = ArticleObject(
    source,
    author,
    title,
    description,
    url,
    urlToImage,
    publishedAt,
    content
)