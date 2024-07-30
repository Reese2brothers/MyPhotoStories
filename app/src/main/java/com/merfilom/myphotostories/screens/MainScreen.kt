package com.merfilom.myphotostories.screens

import android.app.Activity
import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.merfilom.myphotostories.R
import com.merfilom.myphotostories.domain.models.photomodels.Story1
import com.merfilom.myphotostories.viewmodels.Photo1ViewModel
import dagger.hilt.android.AndroidEntryPoint



@Composable
fun MainScreen(context : Context, navController: NavController){
    val listState = rememberLazyListState()
    val activity = LocalContext.current as? Activity
    val viewModel: Photo1ViewModel = hiltViewModel()
    val stories by viewModel.stories.collectAsState()

    // Обработчик кнопки "Назад"
    BackHandler {
        activity?.finishAffinity()
    }

    Box(
        Modifier.fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row (
                Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(id = R.color.orange),
                                colorResource(id = R.color.white),
                                colorResource(id = R.color.orange)
                            )
                        )
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Card(
                    Modifier
                        .background(Color.Transparent)
                        .padding(start = 4.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                ) {
                    Row(
                        Modifier.background(Color.White),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = painterResource(id = R.drawable.photo), contentDescription = "label",
                            modifier = Modifier.size(60.dp))
                        Text(text = "P&V Stories",  Modifier.padding(end = 8.dp),
                            fontSize = 24.sp,
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Bold)
                    }
                }
                Row (
                    modifier = Modifier
                        .padding(end = 4.dp, bottom = 8.dp)
                        .wrapContentWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { navController.navigate("MenuScreen") }
                    ) {
                        Image(painter = painterResource(id = R.drawable.baseline_menu_24), contentDescription = "menu",
                            modifier = Modifier.size(30.dp))
                        Text(text = "menu",  Modifier.padding(start = 6.dp, end = 8.dp),
                            fontSize = 10.sp,
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Bold)
                    }
                    Column (
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { (context as Activity).finishAffinity() }
                    ){
                        Image(painter = painterResource(id = R.drawable.baseline_output_24), contentDescription = "exit",
                        modifier = Modifier.size(30.dp))
                        Text(text = "exit",  Modifier.padding(start = 6.dp, end = 8.dp),
                            fontSize = 10.sp,
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Bold)
                    }


                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.White),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    Modifier
                        .weight(1f)
                        .padding(start = 4.dp, top = 4.dp, bottom = 4.dp, end = 2.dp)
                        .background(Color.Transparent),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                ) {
                    Column (
                        Modifier
                            .wrapContentWidth()
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = listOf(
                                        colorResource(id = R.color.orange),
                                        colorResource(id = R.color.white),
                                        colorResource(id = R.color.orange)
                                    )
                                )
                            )){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(65.dp)
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(
                                                colorResource(id = R.color.orange),
                                                colorResource(id = R.color.white),
                                                colorResource(id = R.color.orange)
                                            )
                                        )
                                    ),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ){
                                Image(painter = painterResource(id = R.drawable.fotik), contentDescription = "photo",
                                    Modifier
                                        .size(55.dp)
                                        .padding(top = 8.dp))
                                Text("Your\n      Photo\n           Stories",
                                    Modifier.padding(top = 4.dp, end = 8.dp, bottom = 4.dp),
                                    fontSize = 16.sp,
                                    color = colorResource(id = R.color.black),
                                    fontWeight = FontWeight.Bold,
                                   )
                            }
                        LazyColumn(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(), state = listState) {
                            item {
                                AddNewPhotoStory(navController)
                            }
                            items(stories) {  item ->
                                Card(
                                    Modifier
                                        .fillMaxWidth()
                                        .height(100.dp)
                                        .padding(8.dp)
                                        .background(Color.Transparent),
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                                ){

                                }
                            }
                        }
                    }
                }
                Card(
                    Modifier
                        .weight(1f)
                        .padding(start = 2.dp, top = 4.dp, bottom = 4.dp, end = 4.dp)
                        .background(Color.Transparent),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                ) {
                    Column (Modifier.background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(id = R.color.orange),
                                colorResource(id = R.color.white),
                                colorResource(id = R.color.orange)
                            )
                        )
                    )){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(65.dp)
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(
                                                colorResource(id = R.color.orange),
                                                colorResource(id = R.color.white),
                                                colorResource(id = R.color.orange)
                                            )
                                        )
                                    ),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ){
                                Image(painter = painterResource(id = R.drawable.plenka), contentDescription = "video",
                                    Modifier
                                        .size(60.dp)
                                        .padding(top = 4.dp))
                                Text("Your\n      Video\n           Stories",
                                    Modifier.padding(top = 4.dp, end = 8.dp, bottom = 4.dp),
                                    fontSize = 16.sp,
                                    color = colorResource(id = R.color.black),
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        LazyColumn(modifier = Modifier.fillMaxSize(), state = listState) {
                            item {
                                AddNewVideoStory(navController)
                            }
                            items(0) {  item ->
                                Card(
                                    Modifier
                                        .fillMaxWidth()
                                        .height(100.dp)
                                        .padding(8.dp)
                                        .background(Color.Transparent),
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                                ){

                                }
                            }
                        }
                    }
                }
            }
            Row (
                Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(id = R.color.white),
                                colorResource(id = R.color.orange)
                            )
                        )
                    )
            ){

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewPhotoStory(navController: NavController){
Card (
    modifier = Modifier
        .padding(4.dp)
        .background(Color.Transparent)
        .height(100.dp),
    shape = RoundedCornerShape(8.dp),
    border = BorderStroke(1.dp, color = Color.Black),
    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
    onClick = {navController.navigate("NewPhotoStoryScreen")}
){
Column(
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    colorResource(id = R.color.orange),
                    colorResource(id = R.color.white),
                    colorResource(id = R.color.orange)
                )
            )
        )
) {
    Image(imageVector = Icons.Default.Add, contentDescription = "addnewphotostory", modifier = Modifier.size(50.dp))
    Text("Add new story",
        Modifier.align(alignment = Alignment.CenterHorizontally),
        fontSize = 16.sp,
        color = colorResource(id = R.color.black),
        fontWeight = FontWeight.Bold,
    )
}
}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewVideoStory(navController: NavController){
    Card (
        modifier = Modifier
            .padding(4.dp)
            .background(Color.Transparent)
            .height(100.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, color = Color.Black),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        onClick = {navController.navigate("NewVideoStoryScreen")}
    ){
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.orange),
                            colorResource(id = R.color.white),
                            colorResource(id = R.color.orange)
                        )
                    )
                )
        ) {
            Image(imageVector = Icons.Default.Add, contentDescription = "addnewvideostory", modifier = Modifier.size(50.dp))
            Text("Add new story",
                Modifier.align(alignment = Alignment.CenterHorizontally),
                fontSize = 16.sp,
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.Bold,
            )
        }
    }
}