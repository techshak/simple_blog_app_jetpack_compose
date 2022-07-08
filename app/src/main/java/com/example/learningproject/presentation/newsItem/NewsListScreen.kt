package com.example.learningproject.presentation.newsItem

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun NewsListScreen (
    navController: NavController,
    viewModel: NewsItemViewModel = hiltViewModel(),
) {
    val posts = viewModel.postListResponse
    val visibility = viewModel.isLoading

   Row(
       modifier = Modifier
           .fillMaxWidth()
           .fillMaxHeight()
   ) {
       Column (
           modifier = Modifier
               .fillMaxSize(),
               horizontalAlignment = Alignment.CenterHorizontally
               ){
           Text(
               text = "Simple Blog App",
               color = Color.Red,
               fontWeight = FontWeight.Bold,
               fontSize = 20.sp,
               fontStyle = FontStyle.Italic,
               modifier = Modifier
                   .padding(10.dp)
                   .align(Alignment.Start)
           )
           Spacer(modifier = Modifier.width(4.dp))

           if(visibility){
               CircularProgressIndicator(
                   modifier = Modifier
                       .size(100.dp)
                       .padding(10.dp)
               )
           }

           LazyColumn {
               itemsIndexed(
                   items = posts
               ){index: Int, item ->
                   NewsSummaryItem(news = item, onClick = {})
               }
           }
       }

   }

}