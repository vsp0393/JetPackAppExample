package com.example.jetpackappexample

import android.util.Log
import com.calvarytemple.models.donatemodels.DonateDataModel
import com.calvarytemple.models.donatemodels.DonateMainModel
import com.example.jetpackappexample.apiclient.ApiInterface
import com.example.jetpackappexample.apiclient.MyApiClient
import com.example.jetpackappexample.apputil.DataState
import com.example.jetpackappexample.models.donatemodels.testmodel.Data
import com.example.jetpackappexample.models.donatemodels.testmodel.TestModel
import com.example.jetpackappexample.models.donatemodels.testmodel2.Genres
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.math.log

class Repository@Inject constructor(
)
{
    private val itemDetailService = MyApiClient.createService(ApiInterface::class.java)

    suspend fun getCreditCards(): List<DonateDataModel> {
        return itemDetailService.getDonateList()
    }

    suspend fun getTestData(): List<Data> {
        return itemDetailService.getTestList()
    }

    suspend fun getTest2Data(): List<Genres> {
        return listOf(itemDetailService.genreList())
    }
}