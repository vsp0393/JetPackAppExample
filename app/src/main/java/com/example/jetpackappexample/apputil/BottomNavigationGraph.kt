package com.example.jetpackappexample.apputil

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackappexample.ui.theme.screens.Donate
import com.example.jetpackappexample.ui.theme.screens.Service
import com.example.jetpackappexample.ui.theme.screens.homeScreen
import com.example.jetpackappexample.viewmodel.DonateListViewModel


@Composable
fun BottomNavGraph(navController: NavHostController, viewModel: ViewModel) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationScreen.Home.route
    ) {
        composable(route = BottomNavigationScreen.Home.route) {
            homeScreen()
        }
        composable(route = BottomNavigationScreen.Service.route) {
            Service()
        }
        composable(route = BottomNavigationScreen.Donate.route) {
            Donate(viewModel = DonateListViewModel())
        }
    }
}

