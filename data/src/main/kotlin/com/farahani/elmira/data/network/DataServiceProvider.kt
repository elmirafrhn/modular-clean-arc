package com.farahani.elmira.data.network

import android.app.Application
import android.os.Build
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.farahani.elmira.data.BuildConfig
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataServiceProvider @Inject constructor(
    private val application: Application
) {
    fun <T> create(service: Class<T>): T =
        retrofit(TIME_OUT).create(service)

    private fun retrofit(type: Long): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClientBuilder(type).build())
        .build()


    private fun okHttpClientBuilder(timeout: Long): OkHttpClient.Builder {
        val builder = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(httpLoggingInterceptor())

        if (BuildConfig.DEBUG) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                builder.addInterceptor(ChuckInterceptor(application.applicationContext))

            builder.addNetworkInterceptor(StethoInterceptor())
        }

        return builder
    }

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG)
            interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    companion object {
        const val TIME_OUT: Long = 30
    }
}