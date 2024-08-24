package com.merfilom.myphotostories.screens

import android.content.Context
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.merfilom.myphotostories.R
import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import com.merfilom.myphotostories.domain.models.photomodels.Photo2
import com.merfilom.myphotostories.domain.models.photomodels.Photo3
import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.models.photomodels.Story1
import com.merfilom.myphotostories.viewmodels.Photo1ViewModel
import com.merfilom.myphotostories.viewmodels.Photo2ViewModel
import com.merfilom.myphotostories.viewmodels.Photo3ViewModel
import com.merfilom.myphotostories.viewmodels.Photo4ViewModel
import com.merfilom.myphotostories.viewmodels.Photo5ViewModel
import okhttp3.internal.filterList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPhotoStoryScreen(navController: NavController, photoKey: Int){
    val context = LocalContext.current
    var bigText = rememberSaveable { mutableStateOf("") }
    var bigPhoto = rememberSaveable { mutableStateOf<Uri?>(null) }
    val viewModel1: Photo1ViewModel = hiltViewModel()
    val viewModel2: Photo2ViewModel = hiltViewModel()
    val viewModel3: Photo3ViewModel = hiltViewModel()
    val viewModel4: Photo4ViewModel = hiltViewModel()
    val viewModel5: Photo5ViewModel = hiltViewModel()
    val photos1 by viewModel1.photos1.collectAsState(initial = emptyList())
    val photos2 by viewModel2.photos2.collectAsState(initial = emptyList())
    val photos3 by viewModel3.photos3.collectAsState(initial = emptyList())
    val photos4 by viewModel4.photos4.collectAsState(initial = emptyList())
    val photos5 by viewModel5.photos5.collectAsState(initial = emptyList())
    val stories1 by viewModel1.stories1.collectAsState(initial = emptyList())
    val showDialog = remember { mutableStateOf(false) }
    val showDialogItems = remember { mutableStateOf(false) }
    var currentIndex = rememberSaveable { mutableStateOf(0) }
    var indexToDelete by remember { mutableStateOf(-1) }

    val sharedPreferences = context.getSharedPreferences("photo_prefs", Context.MODE_PRIVATE)
    val lastViewedIndex = sharedPreferences.getInt("last_viewed_index", 0)
    val listState = rememberLazyListState(initialFirstVisibleItemIndex = lastViewedIndex)

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
            val photos = when (photoKey) {
                1 -> photos1
                2 -> photos2
                3 -> photos3
                4 -> photos4
                5 -> photos5
                else -> emptyList()
            }
            Log.d("TAG", "photos: $photos")
            LaunchedEffect(photos) {
                   currentIndex.value = if (lastViewedIndex < photos.size) lastViewedIndex else 0
                  // bigPhoto.value = photos[currentIndex.value].image.toUri()
                   //bigText.value = photos[currentIndex.value].content
                    bigPhoto.value = null
                    bigText.value = ""
            }
            DisposableEffect(Unit) {
                onDispose {
                    sharedPreferences.edit().putInt("last_viewed_index", currentIndex.value).apply()
                }
            }
                LazyRow(state = listState,
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
                ){
                    itemsIndexed(photos) { index,  item ->
                        val (content, image) = parsePhotoString(item.toString())
                        val changedImage = image.replace("/images/", "/transfered_images/")
                        Card(
                            modifier = Modifier
                                .width(140.dp)
                                .fillMaxHeight()
                                .padding(top = 2.dp, bottom = 2.dp, start = 2.dp, end = 2.dp)
                                .background(Color.Transparent),
                            shape = RoundedCornerShape(8.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                            onClick = {
                                if(image.isNotEmpty()){
                                    bigPhoto.value = changedImage.toUri()
                                    bigText.value = content
                                    currentIndex.value = index
                                }
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
                                        .fillMaxSize()
                                        .background(Color.Transparent),
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                                ){
                                    Box{
                                        AsyncImage(
                                            model = ImageRequest.Builder(context)
                                                .data(changedImage.toUri())
                                                .crossfade(true)
                                                .build(),
                                            contentDescription = "item_photo",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Box(modifier = Modifier
                                            .size(32.dp)
                                            .align(Alignment.TopEnd)
                                            .padding(4.dp)
                                            .background(
                                                colorResource(id = R.color.transparentwhite),
                                                CircleShape
                                            )
                                            .clickable {
                                                currentIndex.value = index
                                                indexToDelete = index
                                                showDialogItems.value = true
                                            },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            if (showDialogItems.value) {
                                                AlertDialog(
                                                    onDismissRequest = {
                                                        showDialogItems.value = false
                                                    },
                                                    containerColor = colorResource(id = R.color.orange),
                                                    title = { Text("Confirmation", color = colorResource(id = R.color.black)) },
                                                    text = {
                                                        Text(
                                                            "Are you sure you want to delete this photo?",
                                                            color = colorResource(id = R.color.black)
                                                        )
                                                    },
                                                    confirmButton = {
                                                        Button(colors = ButtonDefaults.buttonColors(
                                                            containerColor = colorResource(
                                                                id = R.color.black
                                                            )
                                                        ),
                                                            onClick = {
                                                                if (indexToDelete >= 0) {
                                                                    when(photoKey){
                                                                       1 -> {
                                                                           val photo1 = Photo1(content = photos1[indexToDelete].content, image = photos1[indexToDelete].image)
                                                                           viewModel1.deleteNewPhoto(photo1, context)
                                                                           photos1.toMutableList().apply { removeAt(indexToDelete) }
                                                                           if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                               currentIndex.value -= 1
                                                                           }
                                                                           bigPhoto.value = photos1[currentIndex.value].image.toUri()
                                                                           bigText.value = photos1[currentIndex.value].content
                                                                       }
                                                                        2 -> {
                                                                            val photo2 = Photo2(content = photos2[indexToDelete].content, image = photos2[indexToDelete].image)
                                                                            viewModel2.deleteNewPhoto(photo2, context)
                                                                            photos2.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos2[currentIndex.value].image.toUri()
                                                                            bigText.value = photos2[currentIndex.value].content
                                                                        }
                                                                        3 -> {
                                                                            val photo3 = Photo3(content = photos3[indexToDelete].content, image = photos3[indexToDelete].image)
                                                                            viewModel3.deleteNewPhoto(photo3, context)
                                                                            photos3.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos3[currentIndex.value].image.toUri()
                                                                            bigText.value = photos3[currentIndex.value].content
                                                                        }
                                                                        4 -> {
                                                                            val photo4 = Photo4(content = photos4[indexToDelete].content, image = photos4[indexToDelete].image)
                                                                            viewModel4.deleteNewPhoto(photo4, context)
                                                                            photos4.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos4[currentIndex.value].image.toUri()
                                                                            bigText.value = photos4[currentIndex.value].content
                                                                        }
                                                                        5 -> {
                                                                            val photo5 = Photo5(content = photos5[indexToDelete].content, image = photos5[indexToDelete].image)
                                                                            viewModel5.deleteNewPhoto(photo5, context)
                                                                            photos5.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos5[currentIndex.value].image.toUri()
                                                                            bigText.value = photos5[currentIndex.value].content
                                                                        }
                                                                    }
                                                                }
                                                                showDialogItems.value = false
                                                            }) {
                                                            Text("Yes", color = colorResource(id = R.color.orange), fontSize = 16.sp)
                                                        }
                                                    },
                                                    dismissButton = {
                                                        Button(colors = ButtonDefaults.buttonColors(
                                                            containerColor = colorResource(
                                                                id = R.color.black
                                                            )
                                                        ),
                                                            onClick = {
                                                                showDialogItems.value = false
                                                            }) {
                                                            Text("Cancel", color = colorResource(id = R.color.orange), fontSize = 16.sp)
                                                        }
                                                    }
                                                )
                                            }
                                            Image(imageVector = Icons.Default.Delete, contentDescription = "delete", modifier = Modifier.size(25.dp))
                                        }
                                        Box(modifier = Modifier
                                            .fillMaxWidth()
                                            .align(Alignment.BottomCenter)
                                            .background(colorResource(id = R.color.transparentwhite)),
                                            contentAlignment = Alignment.BottomCenter
                                        ) {
                                                Text(
                                                    text = content,
                                                    modifier = Modifier.padding(4.dp),
                                                    fontSize = 14.sp,
                                                    color = colorResource(id = R.color.black),
                                                    fontWeight = FontWeight.Bold,
                                                    maxLines = 1,
                                                    overflow = TextOverflow.Ellipsis
                                                )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
        }
        BottomButtons(Modifier, navController, { showDialog.value = true })
        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = {
                    showDialog.value = false
                },
                containerColor = colorResource(id = R.color.orange),
                title = { Text("Confirmation", color = colorResource(id = R.color.black)) },
                text = {
                    Text(
                        "Are you sure you want to delete all photos?",
                        color = colorResource(id = R.color.black)
                    )
                },
                confirmButton = {
                    Button(colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(
                            id = R.color.black
                        )
                    ),
                        onClick = {
                            when(photoKey){
                                1 -> { viewModel1.deleteAll1Photo(context)
                                    viewModel1.deleteStoryById(photoKey)}
                                    //viewModel1.storyIdChange() }
                                2 -> { viewModel2.deleteAll2Photo(context)
                                    viewModel1.deleteStoryById(photoKey)}
                                    //viewModel1.storyIdChange()}
                                3 -> {viewModel3.deleteAll3Photo(context)
                                    viewModel1.deleteStoryById(photoKey)}
                                    //viewModel1.storyIdChange()}
                                4 -> {viewModel4.deleteAll4Photo(context)
                                    viewModel1.deleteStoryById(photoKey)}
                                    //viewModel1.storyIdChange()}
                                5 -> {viewModel5.deleteAll5Photo(context)
                                    viewModel1.deleteStoryById(photoKey)}
                                    //viewModel1.storyIdChange()}
                            }
                            bigPhoto.value = null
                            bigText.value = ""
                            showDialog.value = false
                            navController.navigate("MainScreen")
                        }) {
                        Text("Yes", color = colorResource(id = R.color.orange), fontSize = 16.sp)
                    }
                },
                dismissButton = {
                    Button(colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(
                            id = R.color.black
                        )
                    ),
                        onClick = {
                            showDialog.value = false
                        }) {
                        Text("Cancel", color = colorResource(id = R.color.orange), fontSize = 16.sp)
                    }
                }
            )
        }
    }
}
}
fun parsePhotoString(photoString: String): Pair<String, String> {
    val regex = """content=(.+?),\s*image=(.+)\)""".toRegex()
    val matchResult = regex.find(photoString)
    if (matchResult != null) {
        val (content, image) = matchResult.destructured
        return Pair(content, image)
    } else {
        return Pair("", "")
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
        Box (
            modifier = Modifier.background( brush = Brush.verticalGradient(
                colors = listOf(
                    colorResource(id = R.color.orange),
                    colorResource(id = R.color.white),
                    colorResource(id = R.color.orange))))
        ){
            if(bigPhoto == null){
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(bigPhoto ?: R.drawable.photo)
                            .crossfade(true)
                            .build(),
                        contentDescription = "bigphoto",
                        modifier = Modifier.fillMaxSize(),
                    )
                } else {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(bigPhoto)
                            .crossfade(true)
                            .build(),
                        contentDescription = "bigphoto",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .align(Alignment.BottomCenter)
                    .background(colorResource(id = R.color.transparentwhite))
                        ) {
                            Text(
                                text = bigText,
                                modifier = Modifier.padding(8.dp),
                                fontSize = 20.sp,
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center)
                        }
                    }
    }
}
@Composable
fun BottomButtons(modifier: Modifier, navController: NavController, deleteStory : () -> Unit) {
    val viewModel: Photo1ViewModel = hiltViewModel()
    val photos1 by viewModel.photos1.collectAsState(initial = emptyList())
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
                    //viewModel.insertNewPhotoStory(story1 = Story1(photoStory1 = Photo1(content = photos1.toString(), image = photos1.toString())))
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
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { deleteStory() }
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
