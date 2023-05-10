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
import com.example.jetpackappexample.ui.theme.screens.homeScreen
import com.example.jetpackappexample.ui.theme.screens.loginScreen
import com.example.jetpackappexample.ui.theme.screens.onClickHandle

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
            composable("login_page", content = { loginScreen(navController = navController) })
            composable("home_screen", content = { homeScreen(navController = navController) })
            //composable("reset_page", content = { ResetPage(navController = navController) })
        })
    }
}



