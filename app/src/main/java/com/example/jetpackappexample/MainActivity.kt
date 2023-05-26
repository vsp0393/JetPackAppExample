package com.example.jetpackappexample

import android.app.Application
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackappexample.apputil.perferencesdatastore.DataStorePreferences
import com.example.jetpackappexample.ui.theme.BottomNavBarDemoTheme
import com.example.jetpackappexample.ui.theme.screens.LoginScreen
import com.example.jetpackappexample.ui.theme.screens.MainScreen
import com.example.jetpackappexample.ui.theme.screens.OtpViewScreen
import com.example.jetpackappexample.ui.theme.screens.SignupScreen
import com.example.jetpackappexample.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first

class MainActivity : ComponentActivity() {
    private lateinit var myViewModel: LoginViewModel
    private lateinit var dataStore: DataStore<Preferences>
    val myApp = application as MyApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        //dataStore = preferencesDataStore("app_preferences")


        setContent {
            BottomNavBarDemoTheme {
                myViewModel.email.observe(this) { email ->
                    // Use the email value here
                   Toast.makeText(this@MainActivity,"$email",Toast.LENGTH_SHORT).show()
                }
                LoginApplication()

            }
        }
    }
}

@Composable
fun LoginApplication() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login_page", builder = {
        composable("login_page", content = { LoginScreen(navController = navController) })
        composable("main_screen", content = { MainScreen(navController = navController)})
        composable("otp_screen", content = { OtpViewScreen(navController = navController) })
        composable("signup_screen", content = { SignupScreen(navController = navController) })
    })
}