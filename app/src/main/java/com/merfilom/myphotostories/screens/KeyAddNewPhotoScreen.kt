package com.merfilom.myphotostories.screens

import android.Manifest
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.merfilom.myphotostories.R
import com.merfilom.myphotostories.domain.models.photomodels.Photo1
import com.merfilom.myphotostories.domain.models.photomodels.Photo2
import com.merfilom.myphotostories.domain.models.photomodels.Photo3
import com.merfilom.myphotostories.domain.models.photomodels.Photo4
import com.merfilom.myphotostories.domain.models.photomodels.Photo5
import com.merfilom.myphotostories.domain.models.photomodels.PhotoEmpty
import com.merfilom.myphotostories.viewmodels.Photo1ViewModel
import com.merfilom.myphotostories.viewmodels.Photo2ViewModel
import com.merfilom.myphotostories.viewmodels.Photo3ViewModel
import com.merfilom.myphotostories.viewmodels.Photo4ViewModel
import com.merfilom.myphotostories.viewmodels.Photo5ViewModel
import com.merfilom.myphotostories.viewmodels.PhotoEmptyViewModel
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun KeyAddNewPhotoScreen(navController: NavController, keyPhoto : String){
    val currentText = rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current
    var selectedImageUri by rememberSaveable { mutableStateOf<Uri?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            selectedImageUri?.let {
                bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, it)
            }
        }
    }
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            uri?.let { selectedImageUri = keySaveImageToFile(context, it) }
        }
    )
    val legacyPhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let { selectedImageUri = keySaveImageToFile(context, it) }
        }
    )
    val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(
            Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.CAMERA
        )
    } else {
        arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
    }
    val permissionState = rememberMultiplePermissionsState(permissions.toList())

    LaunchedEffect(Unit) {
        permissionState.launchMultiplePermissionRequest()
    }

    if (permissionState.allPermissionsGranted) {
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
        ){
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Card(
                    Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .background(Color.Transparent)
                        .padding(4.dp),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                ) {
                    bitmap?.let {
                        val highQualityBitmap = it.copy(Bitmap.Config.ARGB_8888, true)
                        highQualityBitmap.prepareToDraw()
                        Image(
                            bitmap = highQualityBitmap?.asImageBitmap()!!,
                            contentDescription = "cameraBitmap",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                    selectedImageUri?.let { uri ->
                        AsyncImage(
                            model = ImageRequest.Builder(context)
                                .data(uri)
                                .crossfade(true)
                                .build(),
                            contentDescription = "item_photo",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    } ?: run {
                        Image(
                            painter = painterResource(id = R.drawable.photo),
                            contentDescription = "newphoto",
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
                                )
                        )
                    }
                }
                TextField(
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = colorResource(id = R.color.orange),
                        cursorColor = colorResource(id = R.color.black),
                        unfocusedIndicatorColor = colorResource(id = R.color.black),
                        focusedIndicatorColor = colorResource(id = R.color.black),
                        textColor = colorResource(id = R.color.black)
                    ),
                    value = currentText.value, onValueChange = { newValue ->
                        currentText.value = newValue
                    },
                    keyboardActions = KeyboardActions(onDone = {

                    }),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(start = 4.dp, end = 4.dp),
                    textStyle = TextStyle(fontSize = 20.sp),
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "clear",
                            modifier = Modifier.clickable { currentText.value = "" })
                    },
                    placeholder = {
                        Text(text = "Enter a description of the photo...", fontSize = 14.sp,)
                    }
                )
                KeyMovePanel ({
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        photoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                    } else {
                        legacyPhotoPickerLauncher.launch("image/*")
                    }
                }, { val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
                    val storageDir: File = context.getExternalFilesDir(null)!!
                    val photoFile = File.createTempFile(
                        "JPEG_${timeStamp}_",
                        ".jpg",
                        storageDir
                    )
                    val uri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", photoFile)
                    selectedImageUri = uri
                    cameraLauncher.launch(uri)},
                    {selectedImageUri = null
                        bitmap = null}, currentText.value, selectedImageUri, navController, keyPhoto)
            }
        }
    } else {
        //Toast.makeText(context, "Permissions are required to display photos!", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun KeyMovePanel(launchPhotoPicker: () -> Unit, launchPhotoCameraPicker: () -> Unit, deleteBigPhoto: () -> Unit,
              currentText : String, selectedImageUri : Uri?, navController: NavController, keyPhoto : String
) {
    val viewModel1: Photo1ViewModel = hiltViewModel()
    val viewModel2: Photo2ViewModel = hiltViewModel()
    val viewModel3: Photo3ViewModel = hiltViewModel()
    val viewModel4: Photo4ViewModel = hiltViewModel()
    val viewModel5: Photo5ViewModel = hiltViewModel()

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
                modifier = Modifier.clickable { launchPhotoCameraPicker() }
            ){
                Image(painter = painterResource(id = R.drawable.baseline_camera_24), contentDescription = "camera", modifier = Modifier.size(30.dp))
                Text(text = "camera",  Modifier.align(alignment = Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Bold)
            }
            Column (
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable { launchPhotoPicker() }
            ){
                Image(imageVector = Icons.Default.Add, contentDescription = "add", modifier = Modifier.size(30.dp))
                Text(text = "add photo",  Modifier.align(alignment = Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Bold)
            }
            Column (
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    deleteBigPhoto()
                }
            ){
                Image(imageVector = Icons.Default.Delete, contentDescription = "delete",
                    modifier = Modifier.size(25.dp))
                Text(text = "delete photo",  Modifier.align(alignment = Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Bold)
            }
            Column (
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.clickable {
                    if(keyPhoto == "pfirst"){
                        viewModel1.insertNewPhoto(photo1 = Photo1(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfirst")
                    }
                    if(keyPhoto == "psecond"){
                        viewModel2.insertNewPhoto(photo2 = Photo2(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psecond")
                    }
                    if(keyPhoto == "pthird"){
                        viewModel3.insertNewPhoto(photo3 = Photo3(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pthird")
                    }
                    if(keyPhoto == "pfourth"){
                        viewModel4.insertNewPhoto(photo4 = Photo4(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfourth")
                    }
                    if(keyPhoto == "pfifth"){
                        viewModel5.insertNewPhoto(photo5 = Photo5(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfifth")
                    }
                }
            ){
                Image(painter = painterResource(id = R.drawable.baseline_save_24), contentDescription = "savePhoto", modifier = Modifier.size(25.dp))
                Text(text = "save photo",  Modifier.align(alignment = Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}

fun keySaveImageToFile(context: Context, uri: Uri): Uri {
    val inputStream = context.contentResolver.openInputStream(uri)
    val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
    val storageDir: File = File(context.getExternalFilesDir(null), "transfered_images")
    if (!storageDir.exists()) {
        storageDir.mkdirs()
    }
    val photoFile = File(storageDir, "JPEG_${timeStamp}.jpg")
    if (!photoFile.exists()) {
        val outputStream = FileOutputStream(photoFile)
        inputStream?.copyTo(outputStream)
        inputStream?.close()
        outputStream.close()
    }
    return FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", photoFile)
}