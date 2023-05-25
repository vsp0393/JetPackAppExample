package com.example.jetpackappexample.apputil.perferencesdatastore

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class DataStorePreferences(val context: Context) : Application()
{
    val PREFERENCE_NAME = "MyDataStore"

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)

   suspend fun saveEmail(email: String) {

       try {
           context.dataStore.edit { mutablePreferences ->
               mutablePreferences[PreferenceKey.EMAIL_PREFERENCE] = email
               Log.d("TAG", "saveEmail: "+mutablePreferences[PreferenceKey.EMAIL_PREFERENCE])
           }
       } catch (e: Exception) {
           // Handle any exceptions here
           // For example, log the error or perform error handling
           e.printStackTrace()
           Log.d("TAG", "saveEmail: "+e.printStackTrace()
           )
       }
    }

    fun readString(key: String): Flow<String> {
        return context.dataStore.data.map{ pref ->
            pref[stringPreferencesKey(key)] ?: ""
        }
    }

    suspend fun getEmail(): String? {
        val preferences = context.dataStore.data.first()
        return preferences[PreferenceKey.EMAIL_PREFERENCE]
    }

}