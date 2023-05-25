package com.example.jetpackappexample.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackappexample.R
import com.example.jetpackappexample.models.donatemodels.testmodel2.Genres
import com.example.jetpackappexample.ui.theme.*

@Composable
fun DonateListItemView(donateItem3: List<Genres>) {
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
                    text = "",
                    Modifier.wrapContentWidth(),
                    color = Color.White,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )

            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "dataModel.description",
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
                    painterResource(id = R.drawable.baseline_arrow_forward_24),
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