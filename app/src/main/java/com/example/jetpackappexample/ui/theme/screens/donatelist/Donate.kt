package com.example.jetpackappexample.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackappexample.ui.theme.md_theme_dark_inverseSurface
import com.example.jetpackappexample.ui.theme.md_theme_donate
import com.example.jetpackappexample.ui.theme.md_theme_light_outline
import com.example.jetpackappexample.viewmodel.DonateListViewModel


@Composable
fun Donate(){
    val viewModel: DonateListViewModel = viewModel()
    val donateItem by viewModel.donateLiveData.observeAsState(emptyList())
    val donateItem2 by viewModel.testLiveData.observeAsState(emptyList())
    val donateItem3 by viewModel.test2LiveData.observeAsState(emptyList())



    LaunchedEffect(Unit) {
        viewModel.fetchTest2List()
    }

    Column {
        if (donateItem3.isEmpty()) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            LazyColumn {
                items(donateItem3) { donateItem ->
                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(10.dp, 5.dp)
                            .border(
                                BorderStroke(
                                    1.dp,
                                    md_theme_light_outline
                                )
                            )
                    )
                    {
                        Column(
                            Modifier
                                .background(Color.White)
                                .wrapContentHeight()
                                .padding(0.dp, 0.dp, 0.dp, 20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(md_theme_donate)
                                    .padding(10.dp, 12.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {

                                Text(
                                    text = donateItem3.get(0).genres.get(0).name,
                                    Modifier.wrapContentWidth(),
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    textAlign = TextAlign.Center,
                                    fontWeight = FontWeight.Bold,
                                )

                            }
                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = donateItem3.get(0).genres.get(0).id.toString(),
                                Modifier.wrapContentWidth(),
                                color = Color.Black,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Normal,
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Button(
                                onClick = {},
                                Modifier.border(1.dp, Color.White),
                                colors = ButtonDefaults.buttonColors(md_theme_dark_inverseSurface),
                                shape = RoundedCornerShape(100.dp)
                            ) {
                                Text(
                                    text = "Give",
                                    Modifier.padding(start = 15.dp),
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Image(
                                    painterResource(id = com.example.jetpackappexample.R.drawable.baseline_arrow_forward_24),
                                    contentDescription = "Give",
                                    alignment = Alignment.Center,
                                    colorFilter = ColorFilter.tint(Color.White),
                                    modifier = Modifier
                                        .size(20.dp)
                                        .padding(2.dp)
                                        .width(30.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
