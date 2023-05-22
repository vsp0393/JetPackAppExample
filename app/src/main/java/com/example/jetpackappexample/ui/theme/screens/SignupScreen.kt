package com.example.jetpackappexample.ui.theme.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jetpackappexample.R
import com.example.jetpackappexample.ui.theme.md_theme_dark_appbg

@Composable
fun SignupScreen(navController: NavController) {
    var mMobileNumber by remember { mutableStateOf("") }
    val maxChar = 10
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
    Column(
        Modifier
            .padding(20.dp, 0.dp)
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painterResource(R.drawable.usericon),
            contentDescription = "",
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.FillBounds,
        )
        Text(
            text = "Enter Your Mobile Number",
            color = md_theme_dark_appbg,
            fontSize = 12.sp,
            modifier = Modifier.padding(5.dp, 50.dp, 0.dp, 10.dp)
        )
        OutlinedTextField(
            value = mMobileNumber,
            onValueChange = {
                if (it.length <= maxChar) mMobileNumber = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = md_theme_dark_appbg,
                textColor = Color.White,
                cursorColor = Color.Black,
                disabledBorderColor = Color.Gray,
                focusedBorderColor = Color.Black
            ),
            placeholder = {
                Text(text = "Phone Number")
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            textStyle = TextStyle.Default.copy(fontSize = 14.sp)

        )
        Box(modifier = Modifier.fillMaxHeight().padding(0.dp,0.dp,0.dp,50.dp))
        {

            Button(
                onClick = {
                    if (mMobileNumber.isEmpty()) {
                        Toast.makeText(mContext, "Please enter your mobile number.", Toast.LENGTH_SHORT)
                            .show()
                    } else if (mMobileNumber.length < 10 ||mMobileNumber.startsWith("0")) {
                        Toast.makeText(mContext, "Please enter valid mobile number", Toast.LENGTH_SHORT)
                            .show()
                    }
                    else {
                        Toast.makeText(mContext, "Successfully Login", Toast.LENGTH_SHORT)
                            .show()
                        navController.navigate("otp_screen") {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                            navController.popBackStack()
                        }
                    }

                },
                Modifier
                    .fillMaxWidth()
                    .height(45.dp).align(Alignment.BottomCenter),
                colors = ButtonDefaults.buttonColors(md_theme_dark_appbg),
                shape = RoundedCornerShape(size = 20.dp),
                border = BorderStroke(2.dp, Color.Black),
            ) {
                Text("Submit", color = Color.Gray, fontSize = 16.sp)
            }
        }
    }
}