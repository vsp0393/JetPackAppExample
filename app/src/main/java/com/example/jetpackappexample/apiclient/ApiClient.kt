package com.example.jetpackappexample.apiclient

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object MyApiClient {

    const val TEST_BASE_SERVER_URL = "https://api.staging.calvarytemple.in/v1/"

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(TEST_BASE_SERVER_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val MY_API_SERVICE : ApiInterface by lazy{
        retrofit.create(ApiInterface::class.java)
    }

}