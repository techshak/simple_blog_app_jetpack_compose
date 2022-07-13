package com.example.learningproject.presentation.newsItem

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.learningproject.R
import com.example.learningproject.data.remote.dto.PostInfoDto
import com.example.learningproject.navigation.Screens
import com.example.learningproject.utils.Resource

@Composable
fun NewsListScreen (
    navController: NavController,
    viewModel: NewsItemViewModel = hiltViewModel(),
) {
 val state = viewModel.state


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
               color = colorResource(id = R.color.brand_secondary),
               fontWeight = FontWeight.Bold,
               fontSize = 20.sp,
               fontStyle = FontStyle.Italic,
               modifier = Modifier
                   .padding(10.dp)
                   .align(Alignment.Start)
           )
           Spacer(modifier = Modifier.width(4.dp))

           if(state.isLoading){
               CircularProgressIndicator(
                   modifier = Modifier
                       .size(100.dp)
                       .padding(10.dp)
               )
           }

           LazyColumn {
               items(state.postList.size){ i ->
                   val post = state.postList[i]
                   NewsSummaryItem(
                       news = post,
                       onClick = {navController.navigate(Screens.DetailsScreen.route)}
                   )
                   if(i < state.postList.size){
                       Divider(
                       )
                   }

               }
           }
       }

   }

}