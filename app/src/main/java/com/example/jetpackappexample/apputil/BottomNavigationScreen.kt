package com.example.jetpackappexample.apputil

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.jetpackappexample.R
import com.example.jetpackappexample.viewmodel.DonateListViewModel

sealed class BottomNavigationScreen(
    val route: String, val icon: Int, val label: String,
    viewModel: ViewModel?
) {

    object Home : BottomNavigationScreen(

        route = "home",
        label = "Home",
        icon = R.drawable._09113,
        viewModel = null
    )

    object Donate : BottomNavigationScreen(
        route = "donate",
        label = "Donate",
        icon = R.drawable.donation_7850,
        viewModel = DonateListViewModel(Application())

    )
    object Service : BottomNavigationScreen(
        route = "service",
        label = "Service",
        icon = R.drawable.shopping_bag_option_icon,
        viewModel = null
    )
}