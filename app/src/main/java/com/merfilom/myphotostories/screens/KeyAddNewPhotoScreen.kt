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
import com.merfilom.myphotostories.domain.models.photomodels.*
import com.merfilom.myphotostories.viewmodels.photoviewmodels.*
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
                    if(keyPhoto == "psixth"){
                        viewModel6.insertNewPhoto(photo6 = Photo6(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psixth")
                    }
                    if(keyPhoto == "pseventh"){
                        viewModel7.insertNewPhoto(photo7 = Photo7(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pseventh")
                    }
                    if(keyPhoto == "peighth"){
                        viewModel8.insertNewPhoto(photo8 = Photo8(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peighth")
                    }
                    if(keyPhoto == "pninth"){
                        viewModel9.insertNewPhoto(photo9 = Photo9(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pninth")
                    }
                    if(keyPhoto == "ptenth"){
                        viewModel10.insertNewPhoto(photo10 = Photo10(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/ptenth")
                    }
                    if(keyPhoto == "peleventh"){
                        viewModel11.insertNewPhoto(photo11 = Photo11(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peleventh")
                    }
                    if(keyPhoto == "ptwelfth"){
                        viewModel12.insertNewPhoto(photo12 = Photo12(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/ptwelfth")
                    }
                    if(keyPhoto == "pthirteenth"){
                        viewModel13.insertNewPhoto(photo13 = Photo13(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pthirteenth")
                    }
                    if(keyPhoto == "pfourteenth"){
                        viewModel14.insertNewPhoto(photo14 = Photo14(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfourteenth")
                    }
                    if(keyPhoto == "pfifteenth"){
                        viewModel15.insertNewPhoto(photo15 = Photo15(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfifteenth")
                    }
                    if(keyPhoto == "psixteenth"){
                        viewModel16.insertNewPhoto(photo16 = Photo16(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psixteenth")
                    }
                    if(keyPhoto == "pseventeenth"){
                        viewModel17.insertNewPhoto(photo17 = Photo17(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pseventeenth")
                    }
                    if(keyPhoto == "peighteenth"){
                        viewModel18.insertNewPhoto(photo18 = Photo18(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peighteenth")
                    }
                    if(keyPhoto == "pnineteenth"){
                        viewModel19.insertNewPhoto(photo19 = Photo19(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pnineteenth")
                    }
                    if(keyPhoto == "ptwentieth"){
                        viewModel20.insertNewPhoto(photo20 = Photo20(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/ptwentieth")
                    }
                    if(keyPhoto == "ptwentyfirst"){
                        viewModel21.insertNewPhoto(photo21 = Photo21(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/ptwentyfirst")
                    }
                    if(keyPhoto == "ptwentysecond"){
                        viewModel22.insertNewPhoto(photo22 = Photo22(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/ptwentysecond")
                    }
                    if(keyPhoto == "ptwentythird"){
                        viewModel23.insertNewPhoto(photo23 = Photo23(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/ptwentythird")
                    }
                    if(keyPhoto == "ptwentyfourth"){
                        viewModel24.insertNewPhoto(photo24 = Photo24(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/ptwentyfourth")
                    }
                    if(keyPhoto == "ptwentyfifth"){
                        viewModel25.insertNewPhoto(photo25 = Photo25(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/ptwentyfifth")
                    }
                    if(keyPhoto == "ptwentysixth"){
                        viewModel26.insertNewPhoto(photo26 = Photo26(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/ptwentysixth")
                    }
                    if(keyPhoto == "ptwentyseventh"){
                        viewModel27.insertNewPhoto(photo27 = Photo27(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/ptwentyseventh")
                    }
                    if(keyPhoto == "ptwentyeighth"){
                        viewModel28.insertNewPhoto(photo28 = Photo28(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/ptwentyeighth")
                    }
                    if(keyPhoto == "ptwentyninth"){
                        viewModel29.insertNewPhoto(photo29 = Photo29(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/ptwentyninth")
                    }
                    if(keyPhoto == "pthirtieth"){
                        viewModel30.insertNewPhoto(photo30 = Photo30(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pthirtieth")
                    }
                    if(keyPhoto == "pthirtyfirst"){
                        viewModel31.insertNewPhoto(photo31 = Photo31(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pthirtyfirst")
                    }
                    if(keyPhoto == "pthirtysecond"){
                        viewModel32.insertNewPhoto(photo32 = Photo32(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pthirtysecond")
                    }
                    if(keyPhoto == "pthirtythird"){
                        viewModel33.insertNewPhoto(photo33 = Photo33(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pthirtythird")
                    }
                    if(keyPhoto == "pthirtyfourth"){
                        viewModel34.insertNewPhoto(photo34 = Photo34(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pthirtyfourth")
                    }
                    if(keyPhoto == "pthirtyfifth"){
                        viewModel35.insertNewPhoto(photo35 = Photo35(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pthirtyfifth")
                    }
                    if(keyPhoto == "pthirtysixth"){
                        viewModel36.insertNewPhoto(photo36 = Photo36(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pthirtysixth")
                    }
                    if(keyPhoto == "pthirtyseventh"){
                        viewModel37.insertNewPhoto(photo37 = Photo37(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pthirtyseventh")
                    }
                    if(keyPhoto == "pthirtyeighth"){
                        viewModel38.insertNewPhoto(photo38 = Photo38(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pthirtyeighth")
                    }
                    if(keyPhoto == "pthirtyninth"){
                        viewModel39.insertNewPhoto(photo39 = Photo39(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pthirtyninth")
                    }
                    if(keyPhoto == "pfortieth"){
                        viewModel40.insertNewPhoto(photo40 = Photo40(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfortieth")
                    }
                    if(keyPhoto == "pfortyfirst"){
                        viewModel41.insertNewPhoto(photo41 = Photo41(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfortyfirst")
                    }
                    if(keyPhoto == "pfortysecond"){
                        viewModel42.insertNewPhoto(photo42 = Photo42(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfortysecond")
                    }
                    if(keyPhoto == "pfortythird"){
                        viewModel43.insertNewPhoto(photo43 = Photo43(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfortythird")
                    }
                    if(keyPhoto == "pfortyfourth"){
                        viewModel44.insertNewPhoto(photo44 = Photo44(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfortyfourth")
                    }
                    if(keyPhoto == "pfortyfifth"){
                        viewModel45.insertNewPhoto(photo45 = Photo45(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfortyfifth")
                    }
                    if(keyPhoto == "pfortysixth"){
                        viewModel46.insertNewPhoto(photo46 = Photo46(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfortysixth")
                    }
                    if(keyPhoto == "pfortyseventh"){
                        viewModel47.insertNewPhoto(photo47 = Photo47(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfortyseventh")
                    }
                    if(keyPhoto == "pfortyeighth"){
                        viewModel48.insertNewPhoto(photo48 = Photo48(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfortyeighth")
                    }
                    if(keyPhoto == "pfortyninth"){
                        viewModel49.insertNewPhoto(photo49 = Photo49(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfortyninth")
                    }
                    if(keyPhoto == "pfiftieth"){
                        viewModel50.insertNewPhoto(photo50 = Photo50(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfiftieth")
                    }
                    if(keyPhoto == "pfiftyfirst"){
                        viewModel51.insertNewPhoto(photo51 = Photo51(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfiftyfirst")
                    }
                    if(keyPhoto == "pfiftysecond"){
                        viewModel52.insertNewPhoto(photo52 = Photo52(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfiftysecond")
                    }
                    if(keyPhoto == "pfiftythird"){
                        viewModel53.insertNewPhoto(photo53 = Photo53(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfiftythird")
                    }
                    if(keyPhoto == "pfiftyfourth"){
                        viewModel54.insertNewPhoto(photo54 = Photo54(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfiftyfourth")
                    }
                    if(keyPhoto == "pfiftyfifth"){
                        viewModel55.insertNewPhoto(photo55 = Photo55(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfiftyfifth")
                    }
                    if(keyPhoto == "pfiftysixth"){
                        viewModel56.insertNewPhoto(photo56 = Photo56(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfiftysixth")
                    }
                    if(keyPhoto == "pfiftyseventh"){
                        viewModel57.insertNewPhoto(photo57 = Photo57(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfiftyseventh")
                    }
                    if(keyPhoto == "pfiftyeighth"){
                        viewModel58.insertNewPhoto(photo58 = Photo58(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfiftyeighth")
                    }
                    if(keyPhoto == "pfiftyninth"){
                        viewModel59.insertNewPhoto(photo59 = Photo59(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pfiftyninth")
                    }
                    if(keyPhoto == "psixtieth"){
                        viewModel60.insertNewPhoto(photo60 = Photo60(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psixtieth")
                    }
                    if(keyPhoto == "psixtyfirst"){
                        viewModel61.insertNewPhoto(photo61 = Photo61(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psixtyfirst")
                    }
                    if(keyPhoto == "psixtysecond"){
                        viewModel62.insertNewPhoto(photo62 = Photo62(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psixtysecond")
                    }
                    if(keyPhoto == "psixtythird"){
                        viewModel63.insertNewPhoto(photo63 = Photo63(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psixtythird")
                    }
                    if(keyPhoto == "psixtyfourth"){
                        viewModel64.insertNewPhoto(photo64 = Photo64(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psixtyfourth")
                    }
                    if(keyPhoto == "psixtyfifth"){
                        viewModel65.insertNewPhoto(photo65 = Photo65(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psixtyfifth")
                    }
                    if(keyPhoto == "psixtysixth"){
                        viewModel66.insertNewPhoto(photo66 = Photo66(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psixtysixth")
                    }
                    if(keyPhoto == "psixtyseventh"){
                        viewModel67.insertNewPhoto(photo67 = Photo67(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psixtyseventh")
                    }
                    if(keyPhoto == "psixtyeighth"){
                        viewModel68.insertNewPhoto(photo68 = Photo68(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psixtyeighth")
                    }
                    if(keyPhoto == "psixtyninth"){
                        viewModel69.insertNewPhoto(photo69 = Photo69(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/psixtyninth")
                    }
                    if(keyPhoto == "pseventieth"){
                        viewModel70.insertNewPhoto(photo70 = Photo70(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pseventieth")
                    }
                    if(keyPhoto == "pseventyfirst"){
                        viewModel71.insertNewPhoto(photo71 = Photo71(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pseventyfirst")
                    }
                    if(keyPhoto == "pseventysecond"){
                        viewModel72.insertNewPhoto(photo72 = Photo72(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pseventysecond")
                    }
                    if(keyPhoto == "pseventythird"){
                        viewModel73.insertNewPhoto(photo73 = Photo73(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pseventythird")
                    }
                    if(keyPhoto == "pseventyfourth"){
                        viewModel74.insertNewPhoto(photo74 = Photo74(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pseventyfourth")
                    }
                    if(keyPhoto == "pseventyfifth"){
                        viewModel75.insertNewPhoto(photo75 = Photo75(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pseventyfifth")
                    }
                    if(keyPhoto == "pseventysixth"){
                        viewModel76.insertNewPhoto(photo76 = Photo76(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pseventysixth")
                    }
                    if(keyPhoto == "pseventyseventh"){
                        viewModel77.insertNewPhoto(photo77 = Photo77(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pseventyseventh")
                    }
                    if(keyPhoto == "pseventyeighth"){
                        viewModel78.insertNewPhoto(photo78 = Photo78(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pseventyeighth")
                    }
                    if(keyPhoto == "pseventyninth"){
                        viewModel79.insertNewPhoto(photo79 = Photo79(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pseventyninth")
                    }
                    if(keyPhoto == "peightieth"){
                        viewModel80.insertNewPhoto(photo80 = Photo80(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peightieth")
                    }
                    if(keyPhoto == "peightyfirst"){
                        viewModel81.insertNewPhoto(photo81 = Photo81(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peightyfirst")
                    }
                    if(keyPhoto == "peightysecond"){
                        viewModel82.insertNewPhoto(photo82 = Photo82(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peightysecond")
                    }
                    if(keyPhoto == "peightythird"){
                        viewModel83.insertNewPhoto(photo83 = Photo83(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peightythird")
                    }
                    if(keyPhoto == "peightyfourth"){
                        viewModel84.insertNewPhoto(photo84 = Photo84(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peightyfourth")
                    }
                    if(keyPhoto == "peightyfifth"){
                        viewModel85.insertNewPhoto(photo85 = Photo85(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peightyfifth")
                    }
                    if(keyPhoto == "peightysixth"){
                        viewModel86.insertNewPhoto(photo86 = Photo86(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peightysixth")
                    }
                    if(keyPhoto == "peightyseventh"){
                        viewModel87.insertNewPhoto(photo87 = Photo87(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peightyseventh")
                    }
                    if(keyPhoto == "peightyeighth"){
                        viewModel88.insertNewPhoto(photo88 = Photo88(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peightyeighth")
                    }
                    if(keyPhoto == "peightyninth"){
                        viewModel89.insertNewPhoto(photo89 = Photo89(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/peightyninth")
                    }
                    if(keyPhoto == "pninetieth"){
                        viewModel90.insertNewPhoto(photo90 = Photo90(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pninetieth")
                    }
                    if(keyPhoto == "pninetyfirst"){
                        viewModel91.insertNewPhoto(photo91 = Photo91(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pninetyfirst")
                    }
                    if(keyPhoto == "pninetysecond"){
                        viewModel92.insertNewPhoto(photo92 = Photo92(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pninetysecond")
                    }
                    if(keyPhoto == "pninetythird"){
                        viewModel93.insertNewPhoto(photo93 = Photo93(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pninetythird")
                    }
                    if(keyPhoto == "pninetyfourth"){
                        viewModel94.insertNewPhoto(photo94 = Photo94(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pninetyfourth")
                    }
                    if(keyPhoto == "pninetyfifth"){
                        viewModel95.insertNewPhoto(photo95 = Photo95(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pninetyfifth")
                    }
                    if(keyPhoto == "pninetysixth"){
                        viewModel96.insertNewPhoto(photo96 = Photo96(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pninetysixth")
                    }
                    if(keyPhoto == "pninetyseventh"){
                        viewModel97.insertNewPhoto(photo97 = Photo97(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pninetyseventh")
                    }
                    if(keyPhoto == "pninetyeighth"){
                        viewModel98.insertNewPhoto(photo98 = Photo98(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pninetyeighth")
                    }
                    if(keyPhoto == "pninetyninth"){
                        viewModel99.insertNewPhoto(photo99 = Photo99(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/pninetyninth")
                    }
                    if(keyPhoto == "phundredth"){
                        viewModel100.insertNewPhoto(photo100 = Photo100(content = currentText, image = selectedImageUri.toString()))
                        navController.navigate("NewPhotoStoryScreen/phundredth")
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