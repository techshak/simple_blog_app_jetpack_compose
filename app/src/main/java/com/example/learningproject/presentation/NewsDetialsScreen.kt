package com.example.learningproject.presentation

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningproject.R

@Composable
@Preview
fun Details (){
    var favourite by remember {
        mutableStateOf(false)
    }

    Column (
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White)
            ){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            shape = RectangleShape,
            elevation = 2.dp,


            ) {
                Image(
                    painterResource(id = R.drawable.test),
                    contentDescription = "Station Image",
                    contentScale = ContentScale.FillBounds,
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(10.dp,20.dp,10.dp,10.dp),
                        text = "Headline says alot of things about blah blah blah",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )

                    IconToggleButton(
                        checked = favourite,
                        onCheckedChange = {favourite = it},
                        modifier = Modifier
                            .align(Alignment.End)
                    ) {
                        val tint by
                        animateColorAsState(if(!favourite)
                            Color.Gray else Color.Red )
                        Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "Localized",
                            tint = tint,
                            modifier = Modifier
                                .size(20.dp)
                        )
                    }
                }



        }

    }
}