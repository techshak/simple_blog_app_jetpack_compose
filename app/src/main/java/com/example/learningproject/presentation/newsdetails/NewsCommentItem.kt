package com.example.learningproject.presentation.newsdetails

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningproject.R

@Composable
@Preview
fun NewsCommentItem () {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Card(
            modifier = Modifier
                .padding(5.dp)
                .size(50.dp),
            shape = CircleShape,
            elevation = 2.dp,

            ) {
            Image(
                painterResource(id = R.drawable.test),
                contentDescription = "Station Image",
                contentScale = ContentScale.FillBounds,
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
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    text = "comment.name"
                )
                Text(
                    text = "news.body",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,

                    )
                Text(
                    text = "comment.name",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,

                    )
            }


        }
    }
}