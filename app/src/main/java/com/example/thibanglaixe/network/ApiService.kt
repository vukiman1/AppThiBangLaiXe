package com.example.thibanglaixe.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {
    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://demo5395718.mockable.io/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
    val api by lazy{
        retrofit.create(ApiClient::class.java)
    }
}
