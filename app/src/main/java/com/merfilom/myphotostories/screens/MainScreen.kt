package com.merfilom.myphotostories.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
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
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.merfilom.myphotostories.viewmodels.photoviewmodels.Photo1ViewModel
import kotlinx.coroutines.launch

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(context : Context, navController: NavController) {
    val activity = LocalContext.current as? Activity
    val viewModel1: Photo1ViewModel = hiltViewModel()
    val stories1 by viewModel1.stories1.collectAsState(initial = emptyList())
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val sharedPreferences = context.getSharedPreferences("app_photo_prefs", Context.MODE_PRIVATE)
    var lastClickedIndex by remember { mutableStateOf(loadLastClickedIndex(sharedPreferences)) }

    BackHandler {
        activity?.finishAffinity()
    }

    LaunchedEffect(Unit) {
        viewModel1.getAll1NewPhotoStory()
    }
    LaunchedEffect(stories1) {
        if (lastClickedIndex != -1) {
            coroutineScope.launch {
                listState.animateScrollToItem(index = lastClickedIndex)
            }
        }
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
                        LazyColumn(state = listState,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                        ) {
                            item { AddNewPhotoStory(navController) }
                            itemsIndexed(stories1) { index, item ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(160.dp)
                                        .padding(4.dp)
                                        .background(Color.Transparent),
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                                    onClick = {
                                        lastClickedIndex = stories1.indexOf(item)
                                        saveLastClickedIndex(sharedPreferences, lastClickedIndex)
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
                                        if (item.toString().contains("psixth")) {
                                            navController.navigate("NewPhotoStoryScreen/psixth")
                                        }
                                        if (item.toString().contains("pseventh")) {
                                            navController.navigate("NewPhotoStoryScreen/pseventh")
                                        }
                                        if (item.toString().contains("peighth")) {
                                            navController.navigate("NewPhotoStoryScreen/peighth")
                                        }
                                        if (item.toString().contains("pninth")) {
                                            navController.navigate("NewPhotoStoryScreen/pninth")
                                        }
                                        if (item.toString().contains("ptenth")) {
                                            navController.navigate("NewPhotoStoryScreen/ptenth")
                                        }
                                        if (item.toString().contains("peleventh")) {
                                            navController.navigate("NewPhotoStoryScreen/peleventh")
                                        }
                                        if (item.toString().contains("ptwelfth")) {
                                            navController.navigate("NewPhotoStoryScreen/ptwelfth")
                                        }
                                        if (item.toString().contains("pthirteenth")) {
                                            navController.navigate("NewPhotoStoryScreen/pthirteenth")
                                        }
                                        if (item.toString().contains("pfourteenth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfourteenth")
                                        }
                                        if (item.toString().contains("pfifteenth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfifteenth")
                                        }
                                        if (item.toString().contains("psixteenth")) {
                                            navController.navigate("NewPhotoStoryScreen/psixteenth")
                                        }
                                        if (item.toString().contains("pseventeenth")) {
                                            navController.navigate("NewPhotoStoryScreen/pseventeenth")
                                        }
                                        if (item.toString().contains("peighteenth")) {
                                            navController.navigate("NewPhotoStoryScreen/peighteenth")
                                        }
                                        if (item.toString().contains("pnineteenth")) {
                                            navController.navigate("NewPhotoStoryScreen/pnineteenth")
                                        }
                                        if (item.toString().contains("ptwentieth")) {
                                            navController.navigate("NewPhotoStoryScreen/ptwentieth")
                                        }
                                        if (item.toString().contains("ptwentyfirst")) {
                                            navController.navigate("NewPhotoStoryScreen/ptwentyfirst")
                                        }
                                        if (item.toString().contains("ptwentysecond")) {
                                            navController.navigate("NewPhotoStoryScreen/ptwentysecond")
                                        }
                                        if (item.toString().contains("ptwentythird")) {
                                            navController.navigate("NewPhotoStoryScreen/ptwentythird")
                                        }
                                        if (item.toString().contains("ptwentyfourth")) {
                                            navController.navigate("NewPhotoStoryScreen/ptwentyfourth")
                                        }
                                        if (item.toString().contains("ptwentyfifth")) {
                                            navController.navigate("NewPhotoStoryScreen/ptwentyfifth")
                                        }
                                        if (item.toString().contains("ptwentysixth")) {
                                            navController.navigate("NewPhotoStoryScreen/ptwentysixth")
                                        }
                                        if (item.toString().contains("ptwentyseventh")) {
                                            navController.navigate("NewPhotoStoryScreen/ptwentyseventh")
                                        }
                                        if (item.toString().contains("ptwentyeighth")) {
                                            navController.navigate("NewPhotoStoryScreen/ptwentyeighth")
                                        }
                                        if (item.toString().contains("ptwentyninth")) {
                                            navController.navigate("NewPhotoStoryScreen/ptwentyninth")
                                        }
                                        if (item.toString().contains("pthirtieth")) {
                                            navController.navigate("NewPhotoStoryScreen/pthirtieth")
                                        }
                                        if (item.toString().contains("pthirtyfirst")) {
                                            navController.navigate("NewPhotoStoryScreen/pthirtyfirst")
                                        }
                                        if (item.toString().contains("pthirtysecond")) {
                                            navController.navigate("NewPhotoStoryScreen/pthirtysecond")
                                        }
                                        if (item.toString().contains("pthirtythird")) {
                                            navController.navigate("NewPhotoStoryScreen/pthirtythird")
                                        }
                                        if (item.toString().contains("pthirtyfourth")) {
                                            navController.navigate("NewPhotoStoryScreen/pthirtyfourth")
                                        }
                                        if (item.toString().contains("pthirtyfifth")) {
                                            navController.navigate("NewPhotoStoryScreen/pthirtyfifth")
                                        }
                                        if (item.toString().contains("pthirtysixth")) {
                                            navController.navigate("NewPhotoStoryScreen/pthirtysixth")
                                        }
                                        if (item.toString().contains("pthirtyseventh")) {
                                            navController.navigate("NewPhotoStoryScreen/pthirtyseventh")
                                        }
                                        if (item.toString().contains("pthirtyeighth")) {
                                            navController.navigate("NewPhotoStoryScreen/pthirtyeighth")
                                        }
                                        if (item.toString().contains("pthirtyninth")) {
                                            navController.navigate("NewPhotoStoryScreen/pthirtyninth")
                                        }
                                        if (item.toString().contains("pfortieth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfortieth")
                                        }
                                        if (item.toString().contains("pfortyfirst")) {
                                            navController.navigate("NewPhotoStoryScreen/pfortyfirst")
                                        }
                                        if (item.toString().contains("pfortysecond")) {
                                            navController.navigate("NewPhotoStoryScreen/pfortysecond")
                                        }
                                        if (item.toString().contains("pfortythird")) {
                                            navController.navigate("NewPhotoStoryScreen/pfortythird")
                                        }
                                        if (item.toString().contains("pfortyfourth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfortyfourth")
                                        }
                                        if (item.toString().contains("pfortyfifth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfortyfifth")
                                        }
                                        if (item.toString().contains("pfortysixth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfortysixth")
                                        }
                                        if (item.toString().contains("pfortyseventh")) {
                                            navController.navigate("NewPhotoStoryScreen/pfortyseventh")
                                        }
                                        if (item.toString().contains("pfortyeighth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfortyeighth")
                                        }
                                        if (item.toString().contains("pfortyninth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfortyninth")
                                        }
                                        if (item.toString().contains("pfiftieth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfiftieth")
                                        }
                                        if (item.toString().contains("pfiftyfirst")) {
                                            navController.navigate("NewPhotoStoryScreen/pfiftyfirst")
                                        }
                                        if (item.toString().contains("pfiftysecond")) {
                                            navController.navigate("NewPhotoStoryScreen/pfiftysecond")
                                        }
                                        if (item.toString().contains("pfiftythird")) {
                                            navController.navigate("NewPhotoStoryScreen/pfiftythird")
                                        }
                                        if (item.toString().contains("pfiftyfourth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfiftyfourth")
                                        }
                                        if (item.toString().contains("pfiftyfifth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfiftyfifth")
                                        }
                                        if (item.toString().contains("pfiftysixth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfiftysixth")
                                        }
                                        if (item.toString().contains("pfiftyseventh")) {
                                            navController.navigate("NewPhotoStoryScreen/pfiftyseventh")
                                        }
                                        if (item.toString().contains("pfiftyeighth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfiftyeighth")
                                        }
                                        if (item.toString().contains("pfiftyninth")) {
                                            navController.navigate("NewPhotoStoryScreen/pfiftyninth")
                                        }
                                        if (item.toString().contains("psixtieth")) {
                                            navController.navigate("NewPhotoStoryScreen/psixtieth")
                                        }
                                        if (item.toString().contains("psixtyfirst")) {
                                            navController.navigate("NewPhotoStoryScreen/psixtyfirst")
                                        }
                                        if (item.toString().contains("psixtysecond")) {
                                            navController.navigate("NewPhotoStoryScreen/psixtysecond")
                                        }
                                        if (item.toString().contains("psixtythird")) {
                                            navController.navigate("NewPhotoStoryScreen/psixtythird")
                                        }
                                        if (item.toString().contains("psixtyfourth")) {
                                            navController.navigate("NewPhotoStoryScreen/psixtyfourth")
                                        }
                                        if (item.toString().contains("psixtyfifth")) {
                                            navController.navigate("NewPhotoStoryScreen/psixtyfifth")
                                        }
                                        if (item.toString().contains("psixtysixth")) {
                                            navController.navigate("NewPhotoStoryScreen/psixtysixth")
                                        }
                                        if (item.toString().contains("psixtyseventh")) {
                                            navController.navigate("NewPhotoStoryScreen/psixtyseventh")
                                        }
                                        if (item.toString().contains("psixtyeighth")) {
                                            navController.navigate("NewPhotoStoryScreen/psixtyeighth")
                                        }
                                        if (item.toString().contains("psixtyninth")) {
                                            navController.navigate("NewPhotoStoryScreen/psixtyninth")
                                        }
                                        if (item.toString().contains("pseventieth")) {
                                            navController.navigate("NewPhotoStoryScreen/pseventieth")
                                        }
                                        if (item.toString().contains("pseventyfirst")) {
                                            navController.navigate("NewPhotoStoryScreen/pseventyfirst")
                                        }
                                        if (item.toString().contains("pseventysecond")) {
                                            navController.navigate("NewPhotoStoryScreen/pseventysecond")
                                        }
                                        if (item.toString().contains("pseventythird")) {
                                            navController.navigate("NewPhotoStoryScreen/pseventythird")
                                        }
                                        if (item.toString().contains("pseventyfourth")) {
                                            navController.navigate("NewPhotoStoryScreen/pseventyfourth")
                                        }
                                        if (item.toString().contains("pseventyfifth")) {
                                            navController.navigate("NewPhotoStoryScreen/pseventyfifth")
                                        }
                                        if (item.toString().contains("pseventysixth")) {
                                            navController.navigate("NewPhotoStoryScreen/pseventysixth")
                                        }
                                        if (item.toString().contains("pseventyseventh")) {
                                            navController.navigate("NewPhotoStoryScreen/pseventyseventh")
                                        }
                                        if (item.toString().contains("pseventyeighth")) {
                                            navController.navigate("NewPhotoStoryScreen/pseventyeighth")
                                        }
                                        if (item.toString().contains("pseventyninth")) {
                                            navController.navigate("NewPhotoStoryScreen/pseventyninth")
                                        }
                                        if (item.toString().contains("peightieth")) {
                                            navController.navigate("NewPhotoStoryScreen/peightieth")
                                        }
                                        if (item.toString().contains("peightyfirst")) {
                                            navController.navigate("NewPhotoStoryScreen/peightyfirst")
                                        }
                                        if (item.toString().contains("peightysecond")) {
                                            navController.navigate("NewPhotoStoryScreen/peightysecond")
                                        }
                                        if (item.toString().contains("peightythird")) {
                                            navController.navigate("NewPhotoStoryScreen/peightythird")
                                        }
                                        if (item.toString().contains("peightyfourth")) {
                                            navController.navigate("NewPhotoStoryScreen/peightyfourth")
                                        }
                                        if (item.toString().contains("peightyfifth")) {
                                            navController.navigate("NewPhotoStoryScreen/peightyfifth")
                                        }
                                        if (item.toString().contains("peightysixth")) {
                                            navController.navigate("NewPhotoStoryScreen/peightysixth")
                                        }
                                        if (item.toString().contains("peightyseventh")) {
                                            navController.navigate("NewPhotoStoryScreen/peightyseventh")
                                        }
                                        if (item.toString().contains("peightyeighth")) {
                                            navController.navigate("NewPhotoStoryScreen/peightyeighth")
                                        }
                                        if (item.toString().contains("peightyninth")) {
                                            navController.navigate("NewPhotoStoryScreen/peightyninth")
                                        }
                                        if (item.toString().contains("pninetieth")) {
                                            navController.navigate("NewPhotoStoryScreen/pninetieth")
                                        }
                                        if (item.toString().contains("pninetyfirst")) {
                                            navController.navigate("NewPhotoStoryScreen/pninetyfirst")
                                        }
                                        if (item.toString().contains("pninetysecond")) {
                                            navController.navigate("NewPhotoStoryScreen/pninetysecond")
                                        }
                                        if (item.toString().contains("pninetythird")) {
                                            navController.navigate("NewPhotoStoryScreen/pninetythird")
                                        }
                                        if (item.toString().contains("pninetyfourth")) {
                                            navController.navigate("NewPhotoStoryScreen/pninetyfourth")
                                        }
                                        if (item.toString().contains("pninetyfifth")) {
                                            navController.navigate("NewPhotoStoryScreen/pninetyfifth")
                                        }
                                        if (item.toString().contains("pninetysixth")) {
                                            navController.navigate("NewPhotoStoryScreen/pninetysixth")
                                        }
                                        if (item.toString().contains("pninetyseventh")) {
                                            navController.navigate("NewPhotoStoryScreen/pninetyseventh")
                                        }
                                        if (item.toString().contains("pninetyeighth")) {
                                            navController.navigate("NewPhotoStoryScreen/pninetyeighth")
                                        }
                                        if (item.toString().contains("pninetyninth")) {
                                            navController.navigate("NewPhotoStoryScreen/pninetyninth")
                                        }
                                        if (item.toString().contains("phundredth")) {
                                            navController.navigate("NewPhotoStoryScreen/phundredth")
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
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.End,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "${index + 1}/100",
                                                modifier = Modifier.padding(end = 4.dp),
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
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
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .padding(
                                                        top = 36.dp,
                                                        start = 16.dp,
                                                        end = 24.dp,
                                                        bottom = 12.dp
                                                    )
                                                    .graphicsLayer {
                                                        rotationY = 15f
                                                        rotationX = 15f
                                                    },
                                                contentScale = ContentScale.Crop
                                            )
                                        } else {
                                            Text(
                                                "No image available",
                                                modifier = Modifier
                                                    .fillMaxSize()
                                                    .padding(4.dp)
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
fun saveLastClickedIndex(sharedPreferences: SharedPreferences, index: Int) {
    sharedPreferences.edit().putInt("last_clicked_index", index).apply()
}

fun loadLastClickedIndex(sharedPreferences: SharedPreferences): Int {
    return sharedPreferences.getInt("last_clicked_index", -1)
}