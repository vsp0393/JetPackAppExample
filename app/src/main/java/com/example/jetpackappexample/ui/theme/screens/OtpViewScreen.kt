package com.example.jetpackappexample.ui.theme.screens

import android.view.Surface
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackappexample.R
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackappexample.ui.theme.OtpTextField
import com.example.jetpackappexample.ui.theme.OtpTextFieldTheme
import com.example.jetpackappexample.ui.theme.md_theme_dark_appbg

@Composable
fun OtpViewScreen(navController: NavController) {
    var otpValue by remember { mutableStateOf("") }
    val mContext = LocalContext.current
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
    Box(modifier = Modifier.wrapContentHeight().padding(0.dp,100.dp,0.dp,0.dp),
        contentAlignment = Alignment.Center) {
        Column(
            Modifier
                .wrapContentHeight()
                .align(Center)
        ) {
            Image(
                painterResource(R.drawable.padlock),
                contentDescription = "",
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
                    .align(CenterHorizontally),
                contentScale = ContentScale.FillBounds,
            )
            Spacer(modifier = Modifier.height(50.dp))

            OtpTextFieldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .wrapContentHeight()
                        .background(Color.Transparent).align(CenterHorizontally)
                        .padding(20.dp), color = Color.Transparent
                ) {

                    OtpTextField(otpText = otpValue, onOtpTextChange = { value, otpInputFilled ->
                        otpValue = value
                    })
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, 50.dp)
            )
            {
                Button(
                    onClick = {

                        Toast.makeText(mContext, "$otpValue", Toast.LENGTH_SHORT).show()
                        navController.navigate("main_screen") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    },
                    Modifier
                        .fillMaxWidth()
                        .height(45.dp)
                        .align(Alignment.BottomCenter),
                    colors = ButtonDefaults.buttonColors(md_theme_dark_appbg),
                    shape = RoundedCornerShape(size = 20.dp),
                    border = BorderStroke(2.dp, Color.Black),
                ) {
                    Text("Submit", color = Color.Gray, fontSize = 16.sp)
                }
            }
        }

    }
}

/*
@Preview(showSystemUi = true)
@Composable
fun showView() {


}*/
