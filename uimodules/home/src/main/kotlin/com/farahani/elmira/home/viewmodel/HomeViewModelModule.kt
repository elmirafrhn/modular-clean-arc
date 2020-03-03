package com.farahani.elmira.home.viewmodel

import com.farahani.elmira.presentation.common.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by elmira on 12, February, 2020
 */

@Module
abstract class HomeViewModelModule{

    @Binds
    @PerActivity
    @IntoMap
    @ViewModelKey

}