package com.example.jetpackappexample.apputil.perferencesdatastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStorePreferences()
/*private val dataStore: DataStore<PreferenceKey>*/
{
    companion object
    {
        val EMAIL_PREFERENCE = stringPreferencesKey("email")

    }

   val PREFERENCE_NAME = "MyDataStore"
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREFERENCE_NAME)

    suspend fun Context.saveUsername(email: String) {
        dataStore.edit { preferences ->
            preferences[EMAIL_PREFERENCE] = email
        }
    }

    fun Context.readString(key: String): Flow<String> {
        return dataStore.data.map{ pref ->
            pref[stringPreferencesKey(key)] ?: ""
        }
    }

}