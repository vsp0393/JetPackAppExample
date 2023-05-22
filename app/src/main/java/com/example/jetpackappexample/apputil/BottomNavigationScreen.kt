package com.example.jetpackappexample.apputil

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.core.content.ContextCompat
import com.example.jetpackappexample.R

sealed class BottomNavigationScreen(val route:String, val icon: Int, val label:String) {

    object Home:BottomNavigationScreen(

        route = "home",
        label = "Home",
        icon = R.drawable._09113
    )
    object Donate:BottomNavigationScreen(
        route = "donate",
        label = "Donate",
        icon = R.drawable.donation_7850
    )
    object Service:BottomNavigationScreen(
        route = "service",
        label = "Service",
        icon = R.drawable.shopping_bag_option_icon
    )
}