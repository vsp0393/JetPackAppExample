package com.example.jetpackappexample

import android.content.Intent
import android.graphics.Paint.Align
import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackappexample.ui.theme.screens.LoginScreen
import com.example.jetpackappexample.ui.theme.screens.OtpViewScreen
import com.example.jetpackappexample.ui.theme.screens.SignupScreen
import com.example.jetpackappexample.ui.theme.screens.homeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                LoginApplication()
            }
        }

    @Composable
    fun LoginApplication(){
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "login_page", builder = {
            composable("login_page", content = { LoginScreen(navController = navController) })
            composable("home_screen", content = { homeScreen(navController = navController) })
            composable("otp_screen", content = { OtpViewScreen(navController = navController) })
            composable("signup_screen", content = { SignupScreen(navController = navController)})
        })
    }
}



