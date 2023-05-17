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
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackappexample.R
import androidx.navigation.NavController
import com.example.jetpackappexample.ui.theme.md_theme_dark_appbg

@Composable
fun LoginScreen(navController: NavController) {
    val gradient = Brush.horizontalGradient(listOf(Color(0xFF28D8A3), Color(0xFF00BEB2)))
    var passwordVisibility by remember { mutableStateOf(false) }
    val mContext = LocalContext.current
    var mEmail by remember { mutableStateOf("") }
    var mPassword by remember { mutableStateOf("") }
    val maxChar = 30

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_dark_appbg),
    )
    Image(
        painterResource(R.drawable.imagebg),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.FillBounds,
    )
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Center
    )
    {
        Column(
            Modifier
                .wrapContentHeight()
                .align(CenterEnd)
        ) {
            Image(
                painterResource(R.drawable.usericon),
                contentDescription = "",
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
                    .align(CenterHorizontally),
                contentScale = ContentScale.FillBounds,
            )
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(PaddingValues(20.dp, 50.dp, 20.dp, 0.dp)),
                verticalArrangement = Arrangement.spacedBy(15.dp)

            ) {
                OutlinedTextField(
                    value = mEmail,
                    onValueChange = {
                        if (it.length <= maxChar) mEmail = it
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
                    ), placeholder = {
                        Text(text = "Email Id")
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                    textStyle = TextStyle.Default.copy(fontSize = 14.sp)

                )
                OutlinedTextField(
                    value = mPassword,
                    onValueChange = {
                        mPassword = it
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
                    ), placeholder = { Text(text = "Password") },
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                    textStyle = TextStyle.Default.copy(fontSize = 14.sp)
                )
                Spacer(modifier = Modifier.height(0.dp))

                Button(
                    onClick = {
                        if (mEmail.isEmpty()) {
                            Toast.makeText(mContext, "Please enter your registered email", Toast.LENGTH_SHORT)
                                .show()
                        }else if (mPassword.isEmpty()) {
                            Toast.makeText(mContext, "Please enter your Password", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(mContext, "Successfully Login", Toast.LENGTH_SHORT)
                                .show()
                            navController.navigate("home_screen") {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        }

                    },
                    Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    colors = ButtonDefaults.buttonColors(md_theme_dark_appbg),
                    shape = RoundedCornerShape(size = 20.dp),
                    border = BorderStroke(2.dp, Color.Black),
                ) {
                    Text("Submit", color = Color.Gray, fontSize = 16.sp)
                }
                TextButton(onClick = {
             navController.navigate("signup_screen") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                } }
                , contentPadding = PaddingValues(0.dp),modifier = Modifier.wrapContentHeight().defaultMinSize(minHeight = 2.dp).padding(5.dp,0.dp,0.dp,0.dp),
                ) {
                    Text(
                        text = "Click to Create New Account!",
                        color = md_theme_dark_appbg,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

    }
}



