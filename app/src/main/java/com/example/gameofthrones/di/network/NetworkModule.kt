package com.example.gameofthrones.di.network

import com.example.gameofthrones.api.GameOfThronesService
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers

object NetworkModule {

    @JvmStatic
    @Provides
    @Reusable
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @JvmStatic
    @Provides
    @Reusable
    fun providesOKHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addNetworkInterceptor(loggingInterceptor).build()
    }

    @JvmStatic
    @Provides
    @Reusableso
    fun providesRetrofitService(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("https://www.anapioficeandfire.com/api")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okHttpClient)
            .build()
    }

    @JvmStatic
    @Provides
    @Reusable
    fun providesGameOfThronesService(retrofitService: Retrofit): GameOfThronesService {
        return retrofitService.create(GameOfThronesService::class.java)
    }

}