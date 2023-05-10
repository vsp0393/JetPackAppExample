package com.example.jetpackappexample.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackappexample.R
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.example.jetpackappexample.ui.theme.md_theme_dark_appbg
import com.example.jetpackappexample.ui.theme.md_theme_light_primary

@Composable
fun loginScreen(navController: NavController)
{
    var textUserName by remember { mutableStateOf(TextFieldValue("")) }
    var textPass by remember { mutableStateOf(TextFieldValue("")) }

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
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(PaddingValues(0.dp, 0.dp, 0.dp, 200.dp)),
        contentAlignment = Alignment.BottomEnd)
    {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(PaddingValues(20.dp, 100.dp, 20.dp, 0.dp)),
            verticalArrangement = Arrangement.spacedBy(15.dp)

        ) {
            OutlinedTextField(
                value = textUserName,
                onValueChange = {
                    textUserName = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = md_theme_dark_appbg,
                    textColor = Color.White,
                    cursorColor = Color.Black, disabledBorderColor = Color.Gray, focusedBorderColor = Color.Black
                ), placeholder = { Text(text = "Phone Number") }

            )
            OutlinedTextField(
                value = textPass,
                onValueChange = {
                    textPass = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = md_theme_dark_appbg,
                    textColor = Color.White,
                    cursorColor = Color.Black,disabledBorderColor = Color.Gray, focusedBorderColor = Color.Black
                ),placeholder = { Text(text = "Password") }
            )
            Button(
                onClick = {
                    navController.navigate("home_screen"){
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }

                },
                modifier = Modifier
                    .shadow(0.dp)
                    .fillMaxWidth()
                    .height(45.dp)
                    .background(md_theme_dark_appbg),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(2.dp, Color.Gray),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = null
            ) {
                Box(modifier = Modifier.fillMaxSize())
                Text("Submit", color = (Color.White), fontSize = 16.sp )
            }
        }
    }
}

fun onClickHandle(navController: NavController)
{
    navController.navigate("home_screen"){
        popUpTo(navController.graph.startDestinationId)
        launchSingleTop = true
    }
}