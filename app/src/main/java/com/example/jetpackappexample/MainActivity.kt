package com.example.jetpackappexample

import android.content.Intent
import android.graphics.Paint.Align
import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import android.view.Surface
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackappexample.ui.theme.BottomNavBarDemoTheme
import com.example.jetpackappexample.ui.theme.screens.LoginScreen
import com.example.jetpackappexample.ui.theme.screens.MainScreen
import com.example.jetpackappexample.ui.theme.screens.OtpViewScreen
import com.example.jetpackappexample.ui.theme.screens.SignupScreen


class MainActivity : ComponentActivity() {
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
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login_page", builder = {
        composable("login_page", content = { LoginScreen(navController = navController) })
        composable("main_screen", content = { MainScreen(navController = navController) })
        composable("otp_screen", content = { OtpViewScreen(navController = navController) })
        composable("signup_screen", content = { SignupScreen(navController = navController) })
    })
}