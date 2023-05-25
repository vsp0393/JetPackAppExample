package com.example.jetpackappexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackappexample.ui.theme.BottomNavBarDemoTheme
import com.example.jetpackappexample.ui.theme.screens.LoginScreen
import com.example.jetpackappexample.ui.theme.screens.MainScreen
import com.example.jetpackappexample.ui.theme.screens.OtpViewScreen
import com.example.jetpackappexample.ui.theme.screens.SignupScreen
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : ComponentActivity() {


    private var isLoading: Boolean by mutableStateOf(false)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavBarDemoTheme {
                LoginApplication()
            }
        }
    }
}

@Composable
fun LoginApplication() {
    val viewModel: ViewModel? = null
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login_page", builder = {
        composable("login_page", content = { LoginScreen(navController = navController) })
        composable("main_screen", content = { MainScreen(navController = navController)})
        composable("otp_screen", content = { OtpViewScreen(navController = navController) })
        composable("signup_screen", content = { SignupScreen(navController = navController) })
    })
}