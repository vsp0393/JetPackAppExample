package com.example.jetpackappexample.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.jetpackappexample.apputil.perferencesdatastore.DataStorePreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.*
import com.example.jetpackappexample.apputil.perferencesdatastore.PreferenceKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlin.properties.ReadOnlyProperty

class LoginViewModel(application: Application):AndroidViewModel(application) {

    private val context = application.applicationContext
    private val Context.dataStore by preferencesDataStore("app_preferences")
   fun performEmailSave(email:String) {

        viewModelScope.launch(Dispatchers.IO) {
            context.dataStore.edit { preferences ->
                preferences[PreferenceKey.EMAIL_PREFERENCE] = email
            }
        }
    }

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    init {
        getEmail()
    }

    private fun getEmail() {
        viewModelScope.launch {
            val emailFromDataStore = getUserEmail()
            _email.postValue(emailFromDataStore.toString())
        }
    }
   fun performLoginState(loginState:String) {

        viewModelScope.launch(Dispatchers.IO) {
            context.dataStore.edit { preferences ->
                preferences[PreferenceKey.EMAIL_PREFERENCE] = loginState
            }
        }
    }

    suspend fun getUserEmail(): Flow<String> {
        return  context.dataStore.data
            .map { preferences ->
                preferences[PreferenceKey.EMAIL_PREFERENCE]?:""
            }
    }
}