package com.farahani.elmira.domain.base

import io.reactivex.Single

interface BaseUseCase<REQ, RES> {

    fun execute(request: REQ): Single<RES>
}