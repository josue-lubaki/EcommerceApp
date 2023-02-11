package com.renarosantos.ecommerceapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    fun getClient() : ProductService {
        val httpclient = okhttp3.OkHttpClient.Builder().build()

        return Retrofit.Builder()
            .baseUrl("https://us-central1-android-course-api.cloudfunctions.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpclient)
            .build()
            .create(ProductService::class.java)
    }
}