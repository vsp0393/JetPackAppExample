package com.example.jetpackappexample.apiclient

import com.calvarytemple.models.donatemodels.DonateDataModel
import com.calvarytemple.models.donatemodels.DonateMainModel
import com.example.jetpackappexample.models.donatemodels.testmodel.Data
import com.example.jetpackappexample.models.donatemodels.testmodel.TestModel
import com.example.jetpackappexample.models.donatemodels.testmodel2.Genres
import retrofit2.http.GET
import retrofit2.http.Query

@JvmSuppressWildcards
interface ApiInterface {

    @GET("donate/")
    fun getDonateList(): List<DonateDataModel>

    @GET("cards/xy1-1")
    suspend fun getTestList(): List<Data>

    @GET("genre/movie/list")
    suspend fun genreList(@Query("api_key") api_key: String = MyApiClient.API_KEY):Genres
}