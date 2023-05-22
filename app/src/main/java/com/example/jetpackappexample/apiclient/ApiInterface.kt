package com.example.jetpackappexample.apiclient

import com.calvarytemple.models.donatemodels.DonageModel
import retrofit2.Call
import retrofit2.http.GET

@JvmSuppressWildcards
interface ApiInterface {

    @GET("donate/")
    fun getDonateList(): Call<DonageModel?>
}