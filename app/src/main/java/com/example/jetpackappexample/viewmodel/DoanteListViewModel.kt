package com.example.jetpackappexample.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.calvarytemple.models.donatemodels.DonateDataModel
import com.calvarytemple.models.donatemodels.DonateMainModel
import com.example.jetpackappexample.Repository
import com.example.jetpackappexample.apputil.DataState
import com.example.jetpackappexample.models.donatemodels.testmodel.Data
import com.example.jetpackappexample.models.donatemodels.testmodel.TestModel
import com.example.jetpackappexample.models.donatemodels.testmodel2.Genres
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DonateListViewModel : ViewModel() {

    private val repository = Repository()

    private val _donateMutableLiveData = MutableLiveData<List<DonateDataModel>>()
    val donateLiveData: LiveData<List<DonateDataModel>> = _donateMutableLiveData

    fun fetchDonateList() {
        viewModelScope.launch {
            try {
                val donateDataCall = repository.getCreditCards()
                _donateMutableLiveData.value = donateDataCall
            } catch (e: Exception) {
                // Handle error
            }
        }
    }


    private val testMutableLiveData = MutableLiveData<List<Data>>()
    val testLiveData: LiveData<List<Data>> = testMutableLiveData

    fun fetchTestList() {
        viewModelScope.launch {
            try {
                val testDataCall = repository.getTestData()
                testMutableLiveData.value = testDataCall
                Log.d("TAG", "testMutableLiveData:"+testDataCall)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    private val test2MutableLiveData = MutableLiveData<List<Genres>>()
    val test2LiveData: LiveData<List<Genres>> = test2MutableLiveData

    fun fetchTest2List() {
        viewModelScope.launch {
            try {
                val test2DataCall = repository.getTest2Data()
                test2MutableLiveData.value = test2DataCall
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}