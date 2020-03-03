package com.farahani.elmira.data

import com.farahani.elmira.data.network.NetworkModule
import com.farahani.elmira.data.repository.RepositoryModule
import dagger.Module

@Module(
    includes = [
        RepositoryModule::class,
        NetworkModule::class
    ]
)
abstract class DataModule