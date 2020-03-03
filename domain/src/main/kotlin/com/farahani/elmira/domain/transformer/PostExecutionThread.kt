package com.farahani.elmira.domain.transformer

import io.reactivex.Scheduler

interface PostExecutionThread {

    fun scheduler(): Scheduler
}