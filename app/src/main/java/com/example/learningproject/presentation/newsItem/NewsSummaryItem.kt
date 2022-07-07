package com.example.learningproject.presentation.newsItem

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.learningproject.R
import com.example.learningproject.data.remote.dto.PostInfoDto

@Composable
fun NewsSummaryItem(
    news:PostInfoDto,
    onClick: () -> Unit,
) {

    var favourite by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray)
            .clickable( onClick = onClick ),
    ) {
        Card(
            modifier = Modifier
                .padding(5.dp)
                .size(20.dp),
            shape = CircleShape,
            elevation = 2.dp,

        ) {
            Image(
                painterResource(id = R.drawable.test),
                contentDescription = "Station Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(100.dp)
            )

        }
        Box (
            modifier = Modifier
                .padding(10.dp)
                ){
            Column{
                Text(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    text = news.title
                )
                Text(
                    text = news.body
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