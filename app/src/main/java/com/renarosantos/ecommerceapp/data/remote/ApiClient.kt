package com.renarosantos.ecommerceapp.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    private val BASE_URL = "https://us-central1-android-course-api.cloudfunctions.net/"

    fun getClient() : ProductService {
        val httpclient = OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpclient)
            .build()
            .create(ProductService::class.java)
    }
}