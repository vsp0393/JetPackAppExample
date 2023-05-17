package com.example.jetpackappexample.ui.theme.screens

import android.view.Surface
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackappexample.R
import androidx.compose.material.Surface
import androidx.navigation.NavController
import com.example.jetpackappexample.ui.theme.OtpTextField
import com.example.jetpackappexample.ui.theme.OtpTextFieldTheme
import com.example.jetpackappexample.ui.theme.md_theme_dark_appbg

@Composable
fun OtpViewScreen(navController: NavController)
{
    var otpValue by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_dark_appbg),
    )
    Image(
        painterResource(R.drawable.imagebg),
        contentDescription = "",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds,
    )
    OtpTextFieldTheme{
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .wrapContentHeight()
                .background(Color.Transparent)
                .padding(20.dp),
            color = Color.White
        ) {
            

            OtpTextField(
                otpText = otpValue,
                onOtpTextChange = { value, otpInputFilled ->
                    otpValue = value
                }
            )
        }
    }
}