package com.farahani.elmira.domain.transformer

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.schedulers.Schedulers

class STransformerImpl<T>(
    private val threadExecutor: ThreadExecutor,
    private val postExecutionThread: PostExecutionThread
) : STransformer<T>() {
    override fun apply(upstream: Single<T>): SingleSource<T> =
        upstream.subscribeOn(Schedulers.from(threadExecutor))
            .observeOn(postExecutionThread.scheduler())
}