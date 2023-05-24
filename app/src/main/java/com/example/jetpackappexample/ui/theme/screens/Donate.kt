package com.example.jetpackappexample.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import com.example.jetpackappexample.viewmodel.DonateListViewModel


@Composable
fun Donate(viewModel: DonateListViewModel){

    val donateItem by viewModel.donateLiveData.observeAsState(emptyList())
    val donateItem2 by viewModel.testLiveData.observeAsState(emptyList())
    val donateItem3 by viewModel.test2LiveData.observeAsState(emptyList())


    LaunchedEffect(Unit) {
        viewModel.fetchTest2List()
    }

    Column {
        Text(text = "donate...")
        if (donateItem3.isEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            LazyColumn {
                items(donateItem3) { donateItem ->
                    Text(text = donateItem3.get(0).genres.get(0).id.toString())
                    Text(text = donateItem3.get(0).genres.get(0).name)
                    Divider() // Add a divider between items
                }
            }
        }
    }
}
