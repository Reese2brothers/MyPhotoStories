package com.merfilom.myphotostories.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.Uri
import android.util.Log
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.merfilom.myphotostories.R
import com.merfilom.myphotostories.viewmodels.Photo1ViewModel
import com.merfilom.myphotostories.viewmodels.Photo2ViewModel
import com.merfilom.myphotostories.viewmodels.Photo3ViewModel
import com.merfilom.myphotostories.viewmodels.Photo4ViewModel
import com.merfilom.myphotostories.viewmodels.Photo5ViewModel

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(context : Context, navController: NavController) {
    val activity = LocalContext.current as? Activity
    val viewModel1: Photo1ViewModel = hiltViewModel()
    val viewModel2: Photo2ViewModel = hiltViewModel()
    val viewModel3: Photo3ViewModel = hiltViewModel()
    val viewModel4: Photo4ViewModel = hiltViewModel()
    val viewModel5: Photo5ViewModel = hiltViewModel()
    val stories1 by viewModel1.stories1.collectAsState(initial = emptyList())

    BackHandler {
        activity?.finishAffinity()
    }

    LaunchedEffect(Unit) {
        viewModel1.getAll1NewPhotoStory()
        viewModel2.getAll2NewPhotoStory()
        viewModel3.getAll3NewPhotoStory()
        viewModel4.getAll4NewPhotoStory()
        viewModel5.getAll5NewPhotoStory()
    }

    Box(
        Modifier.fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
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
            ) {
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
                        Image(
                            painter = painterResource(id = R.drawable.photo),
                            contentDescription = "label",
                            modifier = Modifier.size(60.dp)
                        )
                        Text(
                            text = "P&V Stories", Modifier.padding(end = 8.dp),
                            fontSize = 24.sp,
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .padding(end = 4.dp, bottom = 8.dp)
                        .wrapContentWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { navController.navigate("MenuScreen") }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_menu_24),
                            contentDescription = "menu",
                            modifier = Modifier.size(30.dp)
                        )
                        Text(
                            text = "menu", Modifier.padding(start = 6.dp, end = 8.dp),
                            fontSize = 10.sp,
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { (context as Activity).finishAffinity() }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_output_24),
                            contentDescription = "exit",
                            modifier = Modifier.size(30.dp)
                        )
                        Text(
                            text = "exit", Modifier.padding(start = 6.dp, end = 8.dp),
                            fontSize = 10.sp,
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Bold
                        )
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
                    Column(
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
                            )
                    ) {
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
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.fotik),
                                contentDescription = "photo",
                                Modifier
                                    .size(55.dp)
                                    .padding(top = 8.dp)
                            )
                            Text(
                                "Your\n      Photo\n           Stories",
                                Modifier.padding(top = 4.dp, end = 8.dp, bottom = 4.dp),
                                fontSize = 16.sp,
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                        ) {
                            item { AddNewPhotoStory(navController) }
                            itemsIndexed(stories1) { index, item ->
                                Card(
                                    modifier = Modifier.fillMaxWidth().height(150.dp).padding(4.dp).background(Color.Transparent),
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                    onClick = {
                                        if (item.toString().contains("pfirst")) {
                                            navController.navigate("NewPhotoStoryScreen/pfirst")
                                        }
                                        if(item.toString().contains("psecond")){
                                            navController.navigate("NewPhotoStoryScreen/psecond")
                                        }
                                        if(item.toString().contains("pthird")){
                                            navController.navigate("NewPhotoStoryScreen/pthird")
                                        }
                                        if(item.toString().contains("pfourth")){
                                            navController.navigate("NewPhotoStoryScreen/pfourth")
                                        }
                                        if(item.toString().contains("pfifth")){
                                            navController.navigate("NewPhotoStoryScreen/pfifth")
                                        }
                                    }
                                ) {
                                    Box(
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
                                        Image(
                                            painter = painterResource(id = R.drawable.photofold),
                                            contentDescription = "photofold",
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .padding(8.dp)
                                                .graphicsLayer { rotationY = -15f },
                                            contentScale = ContentScale.Crop
                                        )
                                            val imageUri = item.image.toUri()
                                            val targetPath = "content://com.merfilom.myphotostories.fileprovider"
                                        if (imageUri.toString().contains(targetPath)) {
                                            val fileName = imageUri.toString().substringAfter("JPEG").substringBefore(".jpg") + ".jpg"
                                            val fullUri = Uri.parse("$targetPath/my_images/transfered_images/JPEG$fileName")
                                                AsyncImage(
                                                model = ImageRequest.Builder(context).data(fullUri)
                                                    .crossfade(true).build(),
                                                contentDescription = "item_photo",
                                                modifier = Modifier.fillMaxSize().padding(
                                                    top = 36.dp,
                                                    start = 16.dp,
                                                    end = 24.dp,
                                                    bottom = 12.dp
                                                ).graphicsLayer {
                                                    rotationY = 15f
                                                    rotationX = 15f
                                                },
                                                contentScale = ContentScale.Crop
                                            )
                                        } else {
                                            Text(
                                                "No image available",
                                                modifier = Modifier.fillMaxSize().padding(4.dp)
                                            )
                                        }
                                    }
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
                    Column(
                        Modifier.background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    colorResource(id = R.color.orange),
                                    colorResource(id = R.color.white),
                                    colorResource(id = R.color.orange)
                                )
                            )
                        )
                    ) {
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
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.plenka),
                                contentDescription = "video",
                                Modifier
                                    .size(60.dp)
                                    .padding(top = 4.dp)
                            )
                            Text(
                                "Your\n      Video\n           Stories",
                                Modifier.padding(top = 4.dp, end = 8.dp, bottom = 4.dp),
                                fontSize = 16.sp,
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            item {
                                AddNewVideoStory(navController)
                            }
                            items(0) { item ->
                                Card(
                                    Modifier
                                        .fillMaxWidth()
                                        .height(100.dp)
                                        .padding(8.dp)
                                        .background(Color.Transparent),
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                                ) {

                                }
                            }
                        }
                    }
                }
            }
            Row(
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
            ) {

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
    onClick = {navController.navigate("EmptyNewPhotoStoryScreen")}
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
