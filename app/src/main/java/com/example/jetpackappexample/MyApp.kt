package com.example.jetpackappexample

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

class MyApp : Application() {

    private val Context.dataStore by preferencesDataStore(name = "app_preferences")

    lateinit var dataStore: DataStore<Preferences>
        private set

    override fun onCreate() {
        super.onCreate()

        dataStore = applicationContext.dataStore
    }
}