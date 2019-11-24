package com.gyosanila.mymoviejetpack.core.services

import com.gyosanila.mymoviejetpack.BuildConfig
import com.gyosanila.mymoviejetpack.core.common.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitService {
    inline fun <reified I> movieAPI() : I {
        return builder(Constant.MovieAPIUrl)
    }
    inline fun <reified I> builder(api: String) : I {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
        val okHttp = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(api)
                .client(okHttp)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(I::class.java)
    }
}