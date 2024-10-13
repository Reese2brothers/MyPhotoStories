package com.merfilom.myphotostories.screens.photostoryscreens

import android.content.Context
import android.net.Uri
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty
import com.merfilom.myphotostories.domain.models.photomodels.Story1
import com.merfilom.myphotostories.domain.models.photomodels.StoryEmpty
import com.merfilom.myphotostories.viewmodels.photoviewmodels.*
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmptyNewPhotoStoryScreen(navController: NavController){
    val context = LocalContext.current
    var bigText = rememberSaveable { mutableStateOf("") }
    var bigPhoto = rememberSaveable { mutableStateOf<Uri?>(null) }
    val viewModel: PhotoEmptyViewModel = hiltViewModel()
    val photosEmpty by viewModel.photosEmpty.collectAsState(initial = emptyList())
    val showDialog = remember { mutableStateOf(false) }
    val showDialogItems = remember { mutableStateOf(false) }
    var currentIndex = rememberSaveable { mutableStateOf(0) }
    var indexToDelete by remember { mutableStateOf(-1) }

    val sharedPreferences = context.getSharedPreferences("photo_prefs", Context.MODE_PRIVATE)
    val lastViewedIndexEmpty = sharedPreferences.getInt("last_viewed_index", 0)

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
            EmptyBigPhoto(Modifier.weight(1f), bigPhoto.value, bigText.value)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.Transparent)
                    .padding(4.dp),
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
            ) {
                LaunchedEffect(photosEmpty) {
                    if (photosEmpty.isNotEmpty()) {
                        currentIndex.value = if (lastViewedIndexEmpty < photosEmpty.size) lastViewedIndexEmpty else 0
                        bigPhoto.value = photosEmpty[currentIndex.value].image.toUri()
                        bigText.value = photosEmpty[currentIndex.value].content
                    } else {
                        bigPhoto.value = null
                        bigText.value = ""
                    }
                }
                DisposableEffect(Unit) {
                    onDispose {
                        sharedPreferences.edit().putInt("last_viewed_index2", currentIndex.value).apply()
                    }
                }
                LazyRow(modifier = Modifier
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
                    itemsIndexed(photosEmpty) { index,  item ->
                        Card(
                            modifier = Modifier
                                .width(140.dp)
                                .fillMaxHeight()
                                .padding(top = 2.dp, bottom = 2.dp, start = 2.dp, end = 2.dp)
                                .background(Color.Transparent),
                            shape = RoundedCornerShape(8.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                            onClick = {
                                if(item.image.isNotEmpty()){
                                    bigPhoto.value = item.image.toUri()
                                    bigText.value = item.content
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
                                                .data(item.image)
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
                                                                    val photoEmpty = PhotoEmpty(content = photosEmpty[indexToDelete].content, image = photosEmpty[indexToDelete].image)
                                                                    viewModel.deleteNewPhoto(photoEmpty, context)
                                                                    photosEmpty.toMutableList().apply { removeAt(indexToDelete) }
                                                                    if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                        currentIndex.value -= 1
                                                                    }
                                                                    bigPhoto.value = photosEmpty[currentIndex.value].image.toUri()
                                                                    bigText.value = photosEmpty[currentIndex.value].content
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
                                                text = item.content ?: "",
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
            EmptyBottomButtons(Modifier, navController, { showDialog.value = true }, context)
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
                                viewModel.deleteAllEmptyPhoto(context)
                                bigPhoto.value = null
                                bigText.value = ""
                                showDialog.value = false
                                viewModel.insertNewPhotoStory(storyEmpty = StoryEmpty(photoStoryEmpty =
                                PhotoEmpty(content = photosEmpty.toString(), image = photosEmpty.toString())))
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
@Composable
fun EmptyBigPhoto(modifier: Modifier, bigPhoto : Uri?, bigText : String) {
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
                    colorResource(id = R.color.orange)
                )))
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
fun EmptyBottomButtons(modifier: Modifier, navController: NavController, deleteStory : () -> Unit, context: Context) {
    val viewModel: PhotoEmptyViewModel = hiltViewModel()
    val viewModel1: Photo1ViewModel = hiltViewModel()
    val viewModel2: Photo2ViewModel = hiltViewModel()
    val viewModel3: Photo3ViewModel = hiltViewModel()
    val viewModel4: Photo4ViewModel = hiltViewModel()
    val viewModel5: Photo5ViewModel = hiltViewModel()
    val viewModel6: Photo6ViewModel = hiltViewModel()
    val viewModel7: Photo7ViewModel = hiltViewModel()
    val viewModel8: Photo8ViewModel = hiltViewModel()
    val viewModel9: Photo9ViewModel = hiltViewModel()
    val viewModel10: Photo10ViewModel = hiltViewModel()
    val viewModel11: Photo11ViewModel = hiltViewModel()
    val viewModel12: Photo12ViewModel = hiltViewModel()
    val viewModel13: Photo13ViewModel = hiltViewModel()
    val viewModel14: Photo14ViewModel = hiltViewModel()
    val viewModel15: Photo15ViewModel = hiltViewModel()
    val viewModel16: Photo16ViewModel = hiltViewModel()
    val viewModel17: Photo17ViewModel = hiltViewModel()
    val viewModel18: Photo18ViewModel = hiltViewModel()
    val viewModel19: Photo19ViewModel = hiltViewModel()
    val viewModel20: Photo20ViewModel = hiltViewModel()
    val viewModel21: Photo21ViewModel = hiltViewModel()
    val viewModel22: Photo22ViewModel = hiltViewModel()
    val viewModel23: Photo23ViewModel = hiltViewModel()
    val viewModel24: Photo24ViewModel = hiltViewModel()
    val viewModel25: Photo25ViewModel = hiltViewModel()
    val viewModel26: Photo26ViewModel = hiltViewModel()
    val viewModel27: Photo27ViewModel = hiltViewModel()
    val viewModel28: Photo28ViewModel = hiltViewModel()
    val viewModel29: Photo29ViewModel = hiltViewModel()
    val viewModel30: Photo30ViewModel = hiltViewModel()
    val viewModel31: Photo31ViewModel = hiltViewModel()
    val viewModel32: Photo32ViewModel = hiltViewModel()
    val viewModel33: Photo33ViewModel = hiltViewModel()
    val viewModel34: Photo34ViewModel = hiltViewModel()
    val viewModel35: Photo35ViewModel = hiltViewModel()
    val viewModel36: Photo36ViewModel = hiltViewModel()
    val viewModel37: Photo37ViewModel = hiltViewModel()
    val viewModel38: Photo38ViewModel = hiltViewModel()
    val viewModel39: Photo39ViewModel = hiltViewModel()
    val viewModel40: Photo40ViewModel = hiltViewModel()
    val viewModel41: Photo41ViewModel = hiltViewModel()
    val viewModel42: Photo42ViewModel = hiltViewModel()
    val viewModel43: Photo43ViewModel = hiltViewModel()
    val viewModel44: Photo44ViewModel = hiltViewModel()
    val viewModel45: Photo45ViewModel = hiltViewModel()
    val viewModel46: Photo46ViewModel = hiltViewModel()
    val viewModel47: Photo47ViewModel = hiltViewModel()
    val viewModel48: Photo48ViewModel = hiltViewModel()
    val viewModel49: Photo49ViewModel = hiltViewModel()
    val viewModel50: Photo50ViewModel = hiltViewModel()
    val viewModel51: Photo51ViewModel = hiltViewModel()
    val viewModel52: Photo52ViewModel = hiltViewModel()
    val viewModel53: Photo53ViewModel = hiltViewModel()
    val viewModel54: Photo54ViewModel = hiltViewModel()
    val viewModel55: Photo55ViewModel = hiltViewModel()
    val viewModel56: Photo56ViewModel = hiltViewModel()
    val viewModel57: Photo57ViewModel = hiltViewModel()
    val viewModel58: Photo58ViewModel = hiltViewModel()
    val viewModel59: Photo59ViewModel = hiltViewModel()
    val viewModel60: Photo60ViewModel = hiltViewModel()
    val viewModel61: Photo61ViewModel = hiltViewModel()
    val viewModel62: Photo62ViewModel = hiltViewModel()
    val viewModel63: Photo63ViewModel = hiltViewModel()
    val viewModel64: Photo64ViewModel = hiltViewModel()
    val viewModel65: Photo65ViewModel = hiltViewModel()
    val viewModel66: Photo66ViewModel = hiltViewModel()
    val viewModel67: Photo67ViewModel = hiltViewModel()
    val viewModel68: Photo68ViewModel = hiltViewModel()
    val viewModel69: Photo69ViewModel = hiltViewModel()
    val viewModel70: Photo70ViewModel = hiltViewModel()
    val viewModel71: Photo71ViewModel = hiltViewModel()
    val viewModel72: Photo72ViewModel = hiltViewModel()
    val viewModel73: Photo73ViewModel = hiltViewModel()
    val viewModel74: Photo74ViewModel = hiltViewModel()
    val viewModel75: Photo75ViewModel = hiltViewModel()
    val viewModel76: Photo76ViewModel = hiltViewModel()
    val viewModel77: Photo77ViewModel = hiltViewModel()
    val viewModel78: Photo78ViewModel = hiltViewModel()
    val viewModel79: Photo79ViewModel = hiltViewModel()
    val viewModel80: Photo80ViewModel = hiltViewModel()
    val viewModel81: Photo81ViewModel = hiltViewModel()
    val viewModel82: Photo82ViewModel = hiltViewModel()
    val viewModel83: Photo83ViewModel = hiltViewModel()
    val viewModel84: Photo84ViewModel = hiltViewModel()
    val viewModel85: Photo85ViewModel = hiltViewModel()
    val viewModel86: Photo86ViewModel = hiltViewModel()
    val viewModel87: Photo87ViewModel = hiltViewModel()
    val viewModel88: Photo88ViewModel = hiltViewModel()
    val viewModel89: Photo89ViewModel = hiltViewModel()
    val viewModel90: Photo90ViewModel = hiltViewModel()
    val viewModel91: Photo91ViewModel = hiltViewModel()
    val viewModel92: Photo92ViewModel = hiltViewModel()
    val viewModel93: Photo93ViewModel = hiltViewModel()
    val viewModel94: Photo94ViewModel = hiltViewModel()
    val viewModel95: Photo95ViewModel = hiltViewModel()
    val viewModel96: Photo96ViewModel = hiltViewModel()
    val viewModel97: Photo97ViewModel = hiltViewModel()
    val viewModel98: Photo98ViewModel = hiltViewModel()
    val viewModel99: Photo99ViewModel = hiltViewModel()
    val viewModel100: Photo100ViewModel = hiltViewModel()
    val photosEmpty by viewModel.photosEmpty.collectAsState(initial = emptyList())
    val scope = rememberCoroutineScope()
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
                    scope.launch {
                        when {
                            viewModel1.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfirst"))
                                viewModel.copyInto1(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel2.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psecond"))
                                viewModel.copyInto2(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel3.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pthird"))
                                viewModel.copyInto3(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel4.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfourth"))
                                viewModel.copyInto4(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel5.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfifth"))
                                viewModel.copyInto5(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel6.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psixth"))
                                viewModel.copyInto6(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel7.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pseventh"))
                                viewModel.copyInto7(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel8.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peighth"))
                                viewModel.copyInto8(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel9.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pninth"))
                                viewModel.copyInto9(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel10.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "ptenth"))
                                viewModel.copyInto10(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel11.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peleventh"))
                                viewModel.copyInto11(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel12.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "ptwelfth"))
                                viewModel.copyInto12(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel13.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pthirteenth"))
                                viewModel.copyInto13(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel14.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfourteenth"))
                                viewModel.copyInto14(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel15.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfifteenth"))
                                viewModel.copyInto15(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel16.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psixteenth"))
                                viewModel.copyInto16(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel17.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pseventeenth"))
                                viewModel.copyInto17(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel18.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peighteenth"))
                                viewModel.copyInto18(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel19.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pnineteenth"))
                                viewModel.copyInto19(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel20.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "ptwentieth"))
                                viewModel.copyInto20(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel21.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "ptwentyfirst"))
                                viewModel.copyInto21(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel22.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "ptwentysecond"))
                                viewModel.copyInto22(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel23.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "ptwentythird"))
                                viewModel.copyInto23(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel24.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "ptwentyfourth"))
                                viewModel.copyInto24(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel25.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "ptwentyfifth"))
                                viewModel.copyInto25(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel26.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "ptwentysixth"))
                                viewModel.copyInto26(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel27.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "ptwentyseventh"))
                                viewModel.copyInto27(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel28.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "ptwentyeighth"))
                                viewModel.copyInto28(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel29.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "ptwentyninth"))
                                viewModel.copyInto29(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel30.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pthirtieth"))
                                viewModel.copyInto30(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel31.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pthirtyfirst"))
                                viewModel.copyInto31(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel32.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pthirtysecond"))
                                viewModel.copyInto32(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel33.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pthirtythird"))
                                viewModel.copyInto33(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel34.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pthirtyfourth"))
                                viewModel.copyInto34(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel35.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pthirtyfifth"))
                                viewModel.copyInto35(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel36.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pthirtysixth"))
                                viewModel.copyInto36(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel37.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pthirtyseventh"))
                                viewModel.copyInto37(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel38.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pthirtyeighth"))
                                viewModel.copyInto38(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel39.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pthirtyninth"))
                                viewModel.copyInto39(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel40.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfortieth"))
                                viewModel.copyInto40(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel41.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfortyfirst"))
                                viewModel.copyInto41(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel42.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfortysecond"))
                                viewModel.copyInto42(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel43.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfortythird"))
                                viewModel.copyInto43(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel44.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfortyfourth"))
                                viewModel.copyInto44(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel45.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfortyfifth"))
                                viewModel.copyInto45(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel46.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfortysixth"))
                                viewModel.copyInto46(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel47.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfortyseventh"))
                                viewModel.copyInto47(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel48.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfortyeighth"))
                                viewModel.copyInto48(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel49.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfortyninth"))
                                viewModel.copyInto49(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel50.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfiftieth"))
                                viewModel.copyInto50(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel51.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfiftyfirst"))
                                viewModel.copyInto51(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel52.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfiftysecond"))
                                viewModel.copyInto52(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel53.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfiftythird"))
                                viewModel.copyInto53(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel54.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfiftyfourth"))
                                viewModel.copyInto54(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel55.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfiftyfifth"))
                                viewModel.copyInto55(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel56.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfiftysixth"))
                                viewModel.copyInto56(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel57.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfiftyseventh"))
                                viewModel.copyInto57(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel58.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfiftyeighth"))
                                viewModel.copyInto58(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel59.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pfiftyninth"))
                                viewModel.copyInto59(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel60.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psixtieth"))
                                viewModel.copyInto60(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel61.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psixtyfirst"))
                                viewModel.copyInto61(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel62.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psixtysecond"))
                                viewModel.copyInto62(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel63.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psixtythird"))
                                viewModel.copyInto63(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel64.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psixtyfourth"))
                                viewModel.copyInto64(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel65.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psixtyfifth"))
                                viewModel.copyInto65(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel66.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psixtysixth"))
                                viewModel.copyInto66(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel67.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psixtyseventh"))
                                viewModel.copyInto67(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel68.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psixtyeighth"))
                                viewModel.copyInto68(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel69.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "psixtyninth"))
                                viewModel.copyInto69(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel70.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pseventieth"))
                                viewModel.copyInto70(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel71.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pseventyfirst"))
                                viewModel.copyInto71(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel72.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pseventysecond"))
                                viewModel.copyInto72(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel73.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pseventythird"))
                                viewModel.copyInto73(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel74.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pseventyfourth"))
                                viewModel.copyInto74(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel75.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pseventyfifth"))
                                viewModel.copyInto75(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel76.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pseventysixth"))
                                viewModel.copyInto76(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel77.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pseventyseventh"))
                                viewModel.copyInto77(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel78.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pseventyeighth"))
                                viewModel.copyInto78(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel79.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pseventyninth"))
                                viewModel.copyInto79(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel80.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peightieth"))
                                viewModel.copyInto80(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel81.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peightyfirst"))
                                viewModel.copyInto81(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel82.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peightysecond"))
                                viewModel.copyInto82(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel83.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peightythird"))
                                viewModel.copyInto83(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel84.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peightyfourth"))
                                viewModel.copyInto84(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel85.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peightyfifth"))
                                viewModel.copyInto85(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel86.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peightysixth"))
                                viewModel.copyInto86(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel87.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peightyseventh"))
                                viewModel.copyInto87(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel88.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peightyeighth"))
                                viewModel.copyInto88(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel89.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "peightyninth"))
                                viewModel.copyInto89(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel90.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pninetieth"))
                                viewModel.copyInto90(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel91.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pninetyfirst"))
                                viewModel.copyInto91(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel92.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pninetysecond"))
                                viewModel.copyInto92(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel93.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pninetythird"))
                                viewModel.copyInto93(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel94.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pninetyfourth"))
                                viewModel.copyInto94(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel95.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pninetyfifth"))
                                viewModel.copyInto95(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel96.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pninetysixth"))
                                viewModel.copyInto96(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel97.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pninetyseventh"))
                                viewModel.copyInto97(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel98.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pninetyeighth"))
                                viewModel.copyInto98(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel99.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "pninetyninth"))
                                viewModel.copyInto99(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                            viewModel100.isTableEmpty() -> {
                                viewModel1.insertNewPhotoStory(story1 = Story1(image = photosEmpty.toString(), idName = "phundredth"))
                                viewModel.copyInto100(context)
                                viewModel.deleteAllEmptyPhoto(context = context)
                            }
                        }
                    }
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
