package com.example.jetpackappexample.ui.theme.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Donate(){
    Column(
        modifier = Modifier
            .background(Color.Gray)
    ) {
        // Header
        Text(text = "Test Donate")
    }
}
