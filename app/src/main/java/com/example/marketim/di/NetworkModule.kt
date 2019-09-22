package com.example.marketim.di

import com.example.marketim.api.ApiService
import com.example.marketim.util.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created on 9/22/2019
 * @author wmramazan
 */
val networkModule = module {
    factory<Interceptor> {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }

    factory { OkHttpClient.Builder().addInterceptor(get<Interceptor>()).build() }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    factory { get<Retrofit>().create(ApiService::class.java) }
}