package com.example.learningproject.presentation.newsdetails

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NewsDetailsScreen (
    viewModel: CommentsViewModel = hiltViewModel(),
){
    var favourite by remember {
        mutableStateOf(false)
    }

    viewModel.getComments(1)
    val commentState = viewModel.commentState

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


                Column(
                    modifier = Modifier
                        .background(Color.Black)
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(10.dp, 20.dp, 10.dp, 10.dp),
                        text = "Headline says alot of things about blah blah blah",
                        color = Color.White,
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

                    LazyColumn{
                        items(commentState.commentList.size){i->
                            val comment = commentState.commentList[i]
                            NewsCommentItem(
                                comment=comment
                            )
                            if(i < commentState.commentList.size){
                                Divider(
                                    modifier = Modifier
                                        .padding(16.dp )
                                )
                            }
                        }

                    }
                }



        }

    }
}