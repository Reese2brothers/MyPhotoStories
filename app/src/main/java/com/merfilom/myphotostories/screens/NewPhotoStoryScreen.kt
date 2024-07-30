package com.merfilom.myphotostories.screens

import android.net.Uri
import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
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
import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import com.merfilom.myphotostories.domain.models.photomodels.Story1
import com.merfilom.myphotostories.viewmodels.Photo1ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPhotoStoryScreen(navController: NavController){
    val context = LocalContext.current
    var bigText = rememberSaveable { mutableStateOf("") }
    var bigPhoto = rememberSaveable { mutableStateOf<Uri?>(null) }
    val viewModel: Photo1ViewModel = hiltViewModel()
    val photos1 by viewModel.photos1.collectAsState(initial = emptyList())

Box(
    Modifier
        .fillMaxSize()
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
    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        BigPhoto(Modifier.weight(1f), bigPhoto.value, bigText.value)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Transparent)
                .padding(4.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            LazyRow(
                modifier = Modifier.fillMaxSize().background(
                        brush = Brush.verticalGradient(colors = listOf(
                                colorResource(id = R.color.orange),
                                colorResource(id = R.color.white),
                                colorResource(id = R.color.orange))))
            ){
                items(photos1) {  item ->
                    Card(
                        modifier = Modifier
                            .width(140.dp)
                            .fillMaxHeight()
                            .padding(4.dp)
                            .background(Color.Transparent),
                        shape = RoundedCornerShape(8.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                        onClick = {
                            Log.d("TAG", "item.image for big : ${item.image}")
                            Log.d("TAG", "bigPhotoBefore : ${bigPhoto.value}")
                            bigPhoto.value = item.image.toUri()
                            Log.d("TAG", "bigPhotoAfter : ${bigPhoto.value}")
                            bigText.value = item.content
                        }
                    ){
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxSize()
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
                            Card (
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(4.dp)
                                    .background(Color.Transparent),
                                shape = RoundedCornerShape(8.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                            ){
                                Log.d("TAG", "item.image : ${item.image}")
                                AsyncImage(
                                    model = ImageRequest.Builder(context)
                                        .data(item.image)
                                        .crossfade(true)
                                        .build(),
                                    contentDescription = "item_photo",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }

                            Text(text = item.content,
                                modifier = Modifier
                                    .align(alignment = Alignment.CenterHorizontally)
                                    .padding(bottom = 4.dp),
                                fontSize = 14.sp,
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
        BottomButtons(Modifier, navController)
    }
}
}
@Composable
fun BigPhoto(modifier: Modifier, bigPhoto : Uri?, bigText : String) {
    Card(
        modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column (
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
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Card (
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
                    .background(Color.Transparent),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
            ){
                Box (
                    modifier = Modifier.background( brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.orange),
                            colorResource(id = R.color.white),
                            colorResource(id = R.color.orange)
                        )
                    ))
                ){
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(bigPhoto ?: R.drawable.photo)
                            .crossfade(true)
                            .build(),
                        contentDescription = "bigphoto",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

            }

            Text(text = bigText,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(8.dp),
                fontSize = 24.sp,
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.Bold)
        }
    }
}
@Composable
fun BottomButtons(modifier: Modifier, navController: NavController) {
    val viewModel: Photo1ViewModel = hiltViewModel()
    Card(
        Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Transparent)
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Row (
            Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.orange),
                            colorResource(id = R.color.white),
                            colorResource(id = R.color.orange)
                        )
                    )
                ),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column (
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.clickable { navController.navigate("AddNewPhotoScreen")}
            ){
                Image(imageVector = Icons.Default.Add, contentDescription = "addnew", modifier = Modifier.size(30.dp))
                Text(text = "add new photo",  Modifier.align(alignment = Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Bold)
            }
            Column (
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    val story1 = Story1(photoStory1 = Photo1(content = viewModel.getAll1NewPhoto().toString(), image = viewModel.getAll1NewPhoto().toString()))
                    viewModel.insertNewPhotoStory(story1 = story1)
                    navController.navigate("MainScreen")
                }
            ){
                Image(painter = painterResource(id = R.drawable.baseline_save_24), contentDescription = "save",
                    modifier = Modifier.size(25.dp))
                Text(text = "save story",  Modifier.align(alignment = Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Bold)
            }
            Column (
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(imageVector = Icons.Default.Delete, contentDescription = "deleteStory", modifier = Modifier.size(25.dp))
                Text(text = "delete story",  Modifier.align(alignment = Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}
