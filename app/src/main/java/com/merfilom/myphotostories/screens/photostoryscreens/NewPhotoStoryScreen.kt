package com.merfilom.myphotostories.screens.photostoryscreens

import android.net.Uri
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.merfilom.myphotostories.domain.models.photomodels.*
import com.merfilom.myphotostories.viewmodels.photoviewmodels.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPhotoStoryScreen(navController: NavController, photoKey: String){
    val context = LocalContext.current
    var bigText = rememberSaveable { mutableStateOf("") }
    var bigPhoto = rememberSaveable { mutableStateOf<Uri?>(null) }
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
    val photos1 by viewModel1.photos1.collectAsState(initial = emptyList())
    val photos2 by viewModel2.photos2.collectAsState(initial = emptyList())
    val photos3 by viewModel3.photos3.collectAsState(initial = emptyList())
    val photos4 by viewModel4.photos4.collectAsState(initial = emptyList())
    val photos5 by viewModel5.photos5.collectAsState(initial = emptyList())
    val photos6 by viewModel6.photos6.collectAsState(initial = emptyList())
    val photos7 by viewModel7.photos7.collectAsState(initial = emptyList())
    val photos8 by viewModel8.photos8.collectAsState(initial = emptyList())
    val photos9 by viewModel9.photos9.collectAsState(initial = emptyList())
    val photos10 by viewModel10.photos10.collectAsState(initial = emptyList())
    val photos11 by viewModel11.photos11.collectAsState(initial = emptyList())
    val photos12 by viewModel12.photos12.collectAsState(initial = emptyList())
    val photos13 by viewModel13.photos13.collectAsState(initial = emptyList())
    val photos14 by viewModel14.photos14.collectAsState(initial = emptyList())
    val photos15 by viewModel15.photos15.collectAsState(initial = emptyList())
    val photos16 by viewModel16.photos16.collectAsState(initial = emptyList())
    val photos17 by viewModel17.photos17.collectAsState(initial = emptyList())
    val photos18 by viewModel18.photos18.collectAsState(initial = emptyList())
    val photos19 by viewModel19.photos19.collectAsState(initial = emptyList())
    val photos20 by viewModel20.photos20.collectAsState(initial = emptyList())
    val photos21 by viewModel21.photos21.collectAsState(initial = emptyList())
    val photos22 by viewModel22.photos22.collectAsState(initial = emptyList())
    val photos23 by viewModel23.photos23.collectAsState(initial = emptyList())
    val photos24 by viewModel24.photos24.collectAsState(initial = emptyList())
    val photos25 by viewModel25.photos25.collectAsState(initial = emptyList())
    val photos26 by viewModel26.photos26.collectAsState(initial = emptyList())
    val photos27 by viewModel27.photos27.collectAsState(initial = emptyList())
    val photos28 by viewModel28.photos28.collectAsState(initial = emptyList())
    val photos29 by viewModel29.photos29.collectAsState(initial = emptyList())
    val photos30 by viewModel30.photos30.collectAsState(initial = emptyList())
    val photos31 by viewModel31.photos31.collectAsState(initial = emptyList())
    val photos32 by viewModel32.photos32.collectAsState(initial = emptyList())
    val photos33 by viewModel33.photos33.collectAsState(initial = emptyList())
    val photos34 by viewModel34.photos34.collectAsState(initial = emptyList())
    val photos35 by viewModel35.photos35.collectAsState(initial = emptyList())
    val photos36 by viewModel36.photos36.collectAsState(initial = emptyList())
    val photos37 by viewModel37.photos37.collectAsState(initial = emptyList())
    val photos38 by viewModel38.photos38.collectAsState(initial = emptyList())
    val photos39 by viewModel39.photos39.collectAsState(initial = emptyList())
    val photos40 by viewModel40.photos40.collectAsState(initial = emptyList())
    val photos41 by viewModel41.photos41.collectAsState(initial = emptyList())
    val photos42 by viewModel42.photos42.collectAsState(initial = emptyList())
    val photos43 by viewModel43.photos43.collectAsState(initial = emptyList())
    val photos44 by viewModel44.photos44.collectAsState(initial = emptyList())
    val photos45 by viewModel45.photos45.collectAsState(initial = emptyList())
    val photos46 by viewModel46.photos46.collectAsState(initial = emptyList())
    val photos47 by viewModel47.photos47.collectAsState(initial = emptyList())
    val photos48 by viewModel48.photos48.collectAsState(initial = emptyList())
    val photos49 by viewModel49.photos49.collectAsState(initial = emptyList())
    val photos50 by viewModel50.photos50.collectAsState(initial = emptyList())
    val photos51 by viewModel51.photos51.collectAsState(initial = emptyList())
    val photos52 by viewModel52.photos52.collectAsState(initial = emptyList())
    val photos53 by viewModel53.photos53.collectAsState(initial = emptyList())
    val photos54 by viewModel54.photos54.collectAsState(initial = emptyList())
    val photos55 by viewModel55.photos55.collectAsState(initial = emptyList())
    val photos56 by viewModel56.photos56.collectAsState(initial = emptyList())
    val photos57 by viewModel57.photos57.collectAsState(initial = emptyList())
    val photos58 by viewModel58.photos58.collectAsState(initial = emptyList())
    val photos59 by viewModel59.photos59.collectAsState(initial = emptyList())
    val photos60 by viewModel60.photos60.collectAsState(initial = emptyList())
    val photos61 by viewModel61.photos61.collectAsState(initial = emptyList())
    val photos62 by viewModel62.photos62.collectAsState(initial = emptyList())
    val photos63 by viewModel63.photos63.collectAsState(initial = emptyList())
    val photos64 by viewModel64.photos64.collectAsState(initial = emptyList())
    val photos65 by viewModel65.photos65.collectAsState(initial = emptyList())
    val photos66 by viewModel66.photos66.collectAsState(initial = emptyList())
    val photos67 by viewModel67.photos67.collectAsState(initial = emptyList())
    val photos68 by viewModel68.photos68.collectAsState(initial = emptyList())
    val photos69 by viewModel69.photos69.collectAsState(initial = emptyList())
    val photos70 by viewModel70.photos70.collectAsState(initial = emptyList())
    val photos71 by viewModel71.photos71.collectAsState(initial = emptyList())
    val photos72 by viewModel72.photos72.collectAsState(initial = emptyList())
    val photos73 by viewModel73.photos73.collectAsState(initial = emptyList())
    val photos74 by viewModel74.photos74.collectAsState(initial = emptyList())
    val photos75 by viewModel75.photos75.collectAsState(initial = emptyList())
    val photos76 by viewModel76.photos76.collectAsState(initial = emptyList())
    val photos77 by viewModel77.photos77.collectAsState(initial = emptyList())
    val photos78 by viewModel78.photos78.collectAsState(initial = emptyList())
    val photos79 by viewModel79.photos79.collectAsState(initial = emptyList())
    val photos80 by viewModel80.photos80.collectAsState(initial = emptyList())
    val photos81 by viewModel81.photos81.collectAsState(initial = emptyList())
    val photos82 by viewModel82.photos82.collectAsState(initial = emptyList())
    val photos83 by viewModel83.photos83.collectAsState(initial = emptyList())
    val photos84 by viewModel84.photos84.collectAsState(initial = emptyList())
    val photos85 by viewModel85.photos85.collectAsState(initial = emptyList())
    val photos86 by viewModel86.photos86.collectAsState(initial = emptyList())
    val photos87 by viewModel87.photos87.collectAsState(initial = emptyList())
    val photos88 by viewModel88.photos88.collectAsState(initial = emptyList())
    val photos89 by viewModel89.photos89.collectAsState(initial = emptyList())
    val photos90 by viewModel90.photos90.collectAsState(initial = emptyList())
    val photos91 by viewModel91.photos91.collectAsState(initial = emptyList())
    val photos92 by viewModel92.photos92.collectAsState(initial = emptyList())
    val photos93 by viewModel93.photos93.collectAsState(initial = emptyList())
    val photos94 by viewModel94.photos94.collectAsState(initial = emptyList())
    val photos95 by viewModel95.photos95.collectAsState(initial = emptyList())
    val photos96 by viewModel96.photos96.collectAsState(initial = emptyList())
    val photos97 by viewModel97.photos97.collectAsState(initial = emptyList())
    val photos98 by viewModel98.photos98.collectAsState(initial = emptyList())
    val photos99 by viewModel99.photos99.collectAsState(initial = emptyList())
    val photos100 by viewModel100.photos100.collectAsState(initial = emptyList())
    val showDialog = remember { mutableStateOf(false) }
    val showDialogItems = remember { mutableStateOf(false) }
    var currentIndex = rememberSaveable { mutableStateOf(0) }
    var indexToDelete by remember { mutableStateOf(-1) }
    val listState = rememberLazyListState()

    BackHandler {
        navController.navigate("MainScreen")
    }

BoxWithConstraints(
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
    val isPortrait = maxWidth < maxHeight
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        BigPhoto(modifier = if (isPortrait) Modifier.weight(1f) else Modifier.height(350.dp),
            bigPhoto.value, bigText.value, navController)
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
                "pfirst" -> photos1
                "psecond" -> photos2
                "pthird" -> photos3
                "pfourth" -> photos4
                "pfifth" -> photos5
                "psixth" -> photos6
                "pseventh" -> photos7
                "peighth" -> photos8
                "pninth" -> photos9
                "ptenth" -> photos10
                "peleventh" -> photos11
                "ptwelfth" -> photos12
                "pthirteenth" -> photos13
                "pfourteenth" -> photos14
                "pfifteenth" -> photos15
                "psixteenth" -> photos16
                "pseventeenth" -> photos17
                "peighteenth" -> photos18
                "pnineteenth" -> photos19
                "ptwentieth" -> photos20
                "ptwentyfirst" -> photos21
                "ptwentysecond" -> photos22
                "ptwentythird" -> photos23
                "ptwentyfourth" -> photos24
                "ptwentyfifth" -> photos25
                "ptwentysixth" -> photos26
                "ptwentyseventh" -> photos27
                "ptwentyeighth" -> photos28
                "ptwentyninth" -> photos29
                "pthirtieth" -> photos30
                "pthirtyfirst" -> photos31
                "pthirtysecond" -> photos32
                "pthirtythird" -> photos33
                "pthirtyfourth" -> photos34
                "pthirtyfifth" -> photos35
                "pthirtysixth" -> photos36
                "pthirtyseventh" -> photos37
                "pthirtyeighth" -> photos38
                "pthirtyninth" -> photos39
                "pfortieth" -> photos40
                "pfortyfirst" -> photos41
                "pfortysecond" -> photos42
                "pfortythird" -> photos43
                "pfortyfourth" -> photos44
                "pfortyfifth" -> photos45
                "pfortysixth" -> photos46
                "pfortyseventh" -> photos47
                "pfortyeighth" -> photos48
                "pfortyninth" -> photos49
                "pfiftieth" -> photos50
                "pfiftyfirst" -> photos51
                "pfiftysecond" -> photos52
                "pfiftythird" -> photos53
                "pfiftyfourth" -> photos54
                "pfiftyfifth" -> photos55
                "pfiftysixth" -> photos56
                "pfiftyseventh" -> photos57
                "pfiftyeighth" -> photos58
                "pfiftyninth" -> photos59
                "psixtieth" -> photos60
                "psixtyfirst" -> photos61
                "psixtysecond" -> photos62
                "psixtythird" -> photos63
                "psixtyfourth" -> photos64
                "psixtyfifth" -> photos65
                "psixtysixth" -> photos66
                "psixtyseventh" -> photos67
                "psixtyeighth" -> photos68
                "psixtyninth" -> photos69
                "pseventieth" -> photos70
                "pseventyfirst" -> photos71
                "pseventysecond" -> photos72
                "pseventythird" -> photos73
                "pseventyfourth" -> photos74
                "pseventyfifth" -> photos75
                "pseventysixth" -> photos76
                "pseventyseventh" -> photos77
                "pseventyeighth" -> photos78
                "pseventyninth" -> photos79
                "peightieth" -> photos80
                "peightyfirst" -> photos81
                "peightysecond" -> photos82
                "peightythird" -> photos83
                "peightyfourth" -> photos84
                "peightyfifth" -> photos85
                "peightysixth" -> photos86
                "peightyseventh" -> photos87
                "peightyeighth" -> photos88
                "peightyninth" -> photos89
                "pninetieth" -> photos90
                "pninetyfirst" -> photos91
                "pninetysecond" -> photos92
                "pninetythird" -> photos93
                "pninetyfourth" -> photos94
                "pninetyfifth" -> photos95
                "pninetysixth" -> photos96
                "pninetyseventh" -> photos97
                "pninetyeighth" -> photos98
                "pninetyninth" -> photos99
                "phundredth" -> photos100
                else -> emptyList()
            }
            LaunchedEffect(photos) {
                when(photoKey){
                    "pfirst" -> {
                        if (photos1.isNotEmpty()) {
                            bigPhoto.value = photos1.last().image.toUri()
                            bigText.value = photos1.last().content
                            listState.animateScrollToItem(index = photos1.size - 1)
                        }
                    }
                    "psecond" -> {
                        if (photos2.isNotEmpty()) {
                            bigPhoto.value = photos2.last().image.toUri()
                            bigText.value = photos2.last().content
                            listState.animateScrollToItem(index = photos2.size - 1)
                        }
                    }
                    "pthird" -> {
                        if (photos3.isNotEmpty()) {
                            bigPhoto.value = photos3.last().image.toUri()
                            bigText.value = photos3.last().content
                            listState.animateScrollToItem(index = photos3.size - 1)
                        }
                    }
                    "pfourth" -> {
                        if (photos4.isNotEmpty()) {
                            bigPhoto.value = photos4.last().image.toUri()
                            bigText.value = photos4.last().content
                            listState.animateScrollToItem(index = photos4.size - 1)
                        }
                    }
                    "pfifth" -> {
                        if (photos5.isNotEmpty()) {
                            bigPhoto.value = photos5.last().image.toUri()
                            bigText.value = photos5.last().content
                            listState.animateScrollToItem(index = photos5.size - 1)
                        }
                    }
                    "psixth" -> {
                        if (photos6.isNotEmpty()) {
                            bigPhoto.value = photos6.last().image.toUri()
                            bigText.value = photos6.last().content
                            listState.animateScrollToItem(index = photos6.size - 1)
                        }
                    }
                    "pseventh" -> {
                        if (photos7.isNotEmpty()) {
                            bigPhoto.value = photos7.last().image.toUri()
                            bigText.value = photos7.last().content
                            listState.animateScrollToItem(index = photos7.size - 1)
                        }
                    }
                    "peighth" -> {
                        if (photos8.isNotEmpty()) {
                            bigPhoto.value = photos8.last().image.toUri()
                            bigText.value = photos8.last().content
                            listState.animateScrollToItem(index = photos8.size - 1)
                        }
                    }
                    "pninth" -> {
                        if (photos9.isNotEmpty()) {
                            bigPhoto.value = photos9.last().image.toUri()
                            bigText.value = photos9.last().content
                            listState.animateScrollToItem(index = photos9.size - 1)
                        }
                    }
                    "ptenth" -> {
                        if (photos10.isNotEmpty()) {
                            bigPhoto.value = photos10.last().image.toUri()
                            bigText.value = photos10.last().content
                            listState.animateScrollToItem(index = photos10.size - 1)
                        }
                    }
                    "peleventh" -> {
                        if (photos11.isNotEmpty()) {
                            bigPhoto.value = photos11.last().image.toUri()
                            bigText.value = photos11.last().content
                            listState.animateScrollToItem(index = photos11.size - 1)
                        }
                    }
                    "ptwelfth" -> {
                        if (photos12.isNotEmpty()) {
                            bigPhoto.value = photos12.last().image.toUri()
                            bigText.value = photos12.last().content
                            listState.animateScrollToItem(index = photos12.size - 1)
                        }
                    }
                    "pthirteenth" -> {
                        if (photos13.isNotEmpty()) {
                            bigPhoto.value = photos13.last().image.toUri()
                            bigText.value = photos13.last().content
                            listState.animateScrollToItem(index = photos13.size - 1)
                        }
                    }
                    "pfourteenth" -> {
                        if (photos14.isNotEmpty()) {
                            bigPhoto.value = photos14.last().image.toUri()
                            bigText.value = photos14.last().content
                            listState.animateScrollToItem(index = photos14.size - 1)
                        }
                    }
                    "pfifteenth" -> {
                        if (photos15.isNotEmpty()) {
                            bigPhoto.value = photos15.last().image.toUri()
                            bigText.value = photos15.last().content
                            listState.animateScrollToItem(index = photos15.size - 1)
                        }
                    }
                    "psixteenth" -> {
                        if (photos16.isNotEmpty()) {
                            bigPhoto.value = photos16.last().image.toUri()
                            bigText.value = photos16.last().content
                            listState.animateScrollToItem(index = photos16.size - 1)
                        }
                    }
                    "pseventeenth" -> {
                        if (photos17.isNotEmpty()) {
                            bigPhoto.value = photos17.last().image.toUri()
                            bigText.value = photos17.last().content
                            listState.animateScrollToItem(index = photos17.size - 1)
                        }
                    }
                    "peighteenth" -> {
                        if (photos18.isNotEmpty()) {
                            bigPhoto.value = photos18.last().image.toUri()
                            bigText.value = photos18.last().content
                            listState.animateScrollToItem(index = photos18.size - 1)
                        }
                    }
                    "pnineteenth" -> {
                        if (photos19.isNotEmpty()) {
                            bigPhoto.value = photos19.last().image.toUri()
                            bigText.value = photos19.last().content
                            listState.animateScrollToItem(index = photos19.size - 1)
                        }
                    }
                    "ptwentieth" -> {
                        if (photos20.isNotEmpty()) {
                            bigPhoto.value = photos20.last().image.toUri()
                            bigText.value = photos20.last().content
                            listState.animateScrollToItem(index = photos20.size - 1)
                        }
                    }
                    "ptwentyfirst" -> {
                        if (photos21.isNotEmpty()) {
                            bigPhoto.value = photos21.last().image.toUri()
                            bigText.value = photos21.last().content
                            listState.animateScrollToItem(index = photos21.size - 1)
                        }
                    }
                    "ptwentysecond" -> {
                        if (photos22.isNotEmpty()) {
                            bigPhoto.value = photos22.last().image.toUri()
                            bigText.value = photos22.last().content
                            listState.animateScrollToItem(index = photos22.size - 1)
                        }
                    }
                    "ptwentythird" -> {
                        if (photos23.isNotEmpty()) {
                            bigPhoto.value = photos23.last().image.toUri()
                            bigText.value = photos23.last().content
                            listState.animateScrollToItem(index = photos23.size - 1)
                        }
                    }
                    "ptwentyfourth" -> {
                        if (photos24.isNotEmpty()) {
                            bigPhoto.value = photos24.last().image.toUri()
                            bigText.value = photos24.last().content
                            listState.animateScrollToItem(index = photos24.size - 1)
                        }
                    }
                    "ptwentyfifth" -> {
                        if (photos25.isNotEmpty()) {
                            bigPhoto.value = photos25.last().image.toUri()
                            bigText.value = photos25.last().content
                            listState.animateScrollToItem(index = photos25.size - 1)
                        }
                    }
                    "ptwentysixth" -> {
                        if (photos26.isNotEmpty()) {
                            bigPhoto.value = photos26.last().image.toUri()
                            bigText.value = photos26.last().content
                            listState.animateScrollToItem(index = photos26.size - 1)
                        }
                    }
                    "ptwentyseventh" -> {
                        if (photos27.isNotEmpty()) {
                            bigPhoto.value = photos27.last().image.toUri()
                            bigText.value = photos27.last().content
                            listState.animateScrollToItem(index = photos27.size - 1)
                        }
                    }
                    "ptwentyeighth" -> {
                        if (photos28.isNotEmpty()) {
                            bigPhoto.value = photos28.last().image.toUri()
                            bigText.value = photos28.last().content
                            listState.animateScrollToItem(index = photos28.size - 1)
                        }
                    }
                    "ptwentyninth" -> {
                        if (photos29.isNotEmpty()) {
                            bigPhoto.value = photos29.last().image.toUri()
                            bigText.value = photos29.last().content
                            listState.animateScrollToItem(index = photos29.size - 1)
                        }
                    }
                    "pthirtieth" -> {
                        if (photos30.isNotEmpty()) {
                            bigPhoto.value = photos30.last().image.toUri()
                            bigText.value = photos30.last().content
                            listState.animateScrollToItem(index = photos30.size - 1)
                        }
                    }
                    "pthirtyfirst" -> {
                        if (photos31.isNotEmpty()) {
                            bigPhoto.value = photos31.last().image.toUri()
                            bigText.value = photos31.last().content
                            listState.animateScrollToItem(index = photos31.size - 1)
                        }
                    }
                    "pthirtysecond" -> {
                        if (photos32.isNotEmpty()) {
                            bigPhoto.value = photos32.last().image.toUri()
                            bigText.value = photos32.last().content
                            listState.animateScrollToItem(index = photos32.size - 1)
                        }
                    }
                    "pthirtythird" -> {
                        if (photos33.isNotEmpty()) {
                            bigPhoto.value = photos33.last().image.toUri()
                            bigText.value = photos33.last().content
                            listState.animateScrollToItem(index = photos33.size - 1)
                        }
                    }
                    "pthirtyfourth" -> {
                        if (photos34.isNotEmpty()) {
                            bigPhoto.value = photos34.last().image.toUri()
                            bigText.value = photos34.last().content
                            listState.animateScrollToItem(index = photos34.size - 1)
                        }
                    }
                    "pthirtyfifth" -> {
                        if (photos35.isNotEmpty()) {
                            bigPhoto.value = photos35.last().image.toUri()
                            bigText.value = photos35.last().content
                            listState.animateScrollToItem(index = photos35.size - 1)
                        }
                    }
                    "pthirtysixth" -> {
                        if (photos36.isNotEmpty()) {
                            bigPhoto.value = photos36.last().image.toUri()
                            bigText.value = photos36.last().content
                            listState.animateScrollToItem(index = photos36.size - 1)
                        }
                    }
                    "pthirtyseventh" -> {
                        if (photos37.isNotEmpty()) {
                            bigPhoto.value = photos37.last().image.toUri()
                            bigText.value = photos37.last().content
                            listState.animateScrollToItem(index = photos37.size - 1)
                        }
                    }
                    "pthirtyeighth" -> {
                        if (photos38.isNotEmpty()) {
                            bigPhoto.value = photos38.last().image.toUri()
                            bigText.value = photos38.last().content
                            listState.animateScrollToItem(index = photos38.size - 1)
                        }
                    }
                    "pthirtyninth" -> {
                        if (photos39.isNotEmpty()) {
                            bigPhoto.value = photos39.last().image.toUri()
                            bigText.value = photos39.last().content
                            listState.animateScrollToItem(index = photos39.size - 1)
                        }
                    }
                    "pfortieth" -> {
                        if (photos40.isNotEmpty()) {
                            bigPhoto.value = photos40.last().image.toUri()
                            bigText.value = photos40.last().content
                            listState.animateScrollToItem(index = photos40.size - 1)
                        }
                    }
                    "pfortyfirst" -> {
                        if (photos41.isNotEmpty()) {
                            bigPhoto.value = photos41.last().image.toUri()
                            bigText.value = photos41.last().content
                            listState.animateScrollToItem(index = photos41.size - 1)
                        }
                    }
                    "pfortysecond" -> {
                        if (photos42.isNotEmpty()) {
                            bigPhoto.value = photos42.last().image.toUri()
                            bigText.value = photos42.last().content
                            listState.animateScrollToItem(index = photos42.size - 1)
                        }
                    }
                    "pfortythird" -> {
                        if (photos43.isNotEmpty()) {
                            bigPhoto.value = photos43.last().image.toUri()
                            bigText.value = photos43.last().content
                            listState.animateScrollToItem(index = photos43.size - 1)
                        }
                    }
                    "pfortyfourth" -> {
                        if (photos44.isNotEmpty()) {
                            bigPhoto.value = photos44.last().image.toUri()
                            bigText.value = photos44.last().content
                            listState.animateScrollToItem(index = photos44.size - 1)
                        }
                    }
                    "pfortyfifth" -> {
                        if (photos45.isNotEmpty()) {
                            bigPhoto.value = photos45.last().image.toUri()
                            bigText.value = photos45.last().content
                            listState.animateScrollToItem(index = photos45.size - 1)
                        }
                    }
                    "pfortysixth" -> {
                        if (photos46.isNotEmpty()) {
                            bigPhoto.value = photos46.last().image.toUri()
                            bigText.value = photos46.last().content
                            listState.animateScrollToItem(index = photos46.size - 1)
                        }
                    }
                    "pfortyseventh" -> {
                        if (photos47.isNotEmpty()) {
                            bigPhoto.value = photos47.last().image.toUri()
                            bigText.value = photos47.last().content
                            listState.animateScrollToItem(index = photos47.size - 1)
                        }
                    }
                    "pfortyeighth" -> {
                        if (photos48.isNotEmpty()) {
                            bigPhoto.value = photos48.last().image.toUri()
                            bigText.value = photos48.last().content
                            listState.animateScrollToItem(index = photos48.size - 1)
                        }
                    }
                    "pfortyninth" -> {
                        if (photos49.isNotEmpty()) {
                            bigPhoto.value = photos49.last().image.toUri()
                            bigText.value = photos49.last().content
                            listState.animateScrollToItem(index = photos49.size - 1)
                        }
                    }
                    "pfiftieth" -> {
                        if (photos50.isNotEmpty()) {
                            bigPhoto.value = photos50.last().image.toUri()
                            bigText.value = photos50.last().content
                            listState.animateScrollToItem(index = photos50.size - 1)
                        }
                    }
                    "pfiftyfirst" -> {
                        if (photos51.isNotEmpty()) {
                            bigPhoto.value = photos51.last().image.toUri()
                            bigText.value = photos51.last().content
                            listState.animateScrollToItem(index = photos51.size - 1)
                        }
                    }
                    "pfiftysecond" -> {
                        if (photos52.isNotEmpty()) {
                            bigPhoto.value = photos52.last().image.toUri()
                            bigText.value = photos52.last().content
                            listState.animateScrollToItem(index = photos52.size - 1)
                        }
                    }
                    "pfiftythird" -> {
                        if (photos53.isNotEmpty()) {
                            bigPhoto.value = photos53.last().image.toUri()
                            bigText.value = photos53.last().content
                            listState.animateScrollToItem(index = photos53.size - 1)
                        }
                    }
                    "pfiftyfourth" -> {
                        if (photos54.isNotEmpty()) {
                            bigPhoto.value = photos54.last().image.toUri()
                            bigText.value = photos54.last().content
                            listState.animateScrollToItem(index = photos54.size - 1)
                        }
                    }
                    "pfiftyfifth" -> {
                        if (photos55.isNotEmpty()) {
                            bigPhoto.value = photos55.last().image.toUri()
                            bigText.value = photos55.last().content
                            listState.animateScrollToItem(index = photos55.size - 1)
                        }
                    }
                    "pfiftysixth" -> {
                        if (photos56.isNotEmpty()) {
                            bigPhoto.value = photos56.last().image.toUri()
                            bigText.value = photos56.last().content
                            listState.animateScrollToItem(index = photos56.size - 1)
                        }
                    }
                    "pfiftyseventh" -> {
                        if (photos57.isNotEmpty()) {
                            bigPhoto.value = photos57.last().image.toUri()
                            bigText.value = photos57.last().content
                            listState.animateScrollToItem(index = photos57.size - 1)
                        }
                    }
                    "pfiftyeighth" -> {
                        if (photos58.isNotEmpty()) {
                            bigPhoto.value = photos58.last().image.toUri()
                            bigText.value = photos58.last().content
                            listState.animateScrollToItem(index = photos58.size - 1)
                        }
                    }
                    "pfiftyninth" -> {
                        if (photos59.isNotEmpty()) {
                            bigPhoto.value = photos59.last().image.toUri()
                            bigText.value = photos59.last().content
                            listState.animateScrollToItem(index = photos59.size - 1)
                        }
                    }
                    "psixtieth" -> {
                        if (photos60.isNotEmpty()) {
                            bigPhoto.value = photos60.last().image.toUri()
                            bigText.value = photos60.last().content
                            listState.animateScrollToItem(index = photos60.size - 1)
                        }
                    }
                    "psixtyfirst" -> {
                        if (photos61.isNotEmpty()) {
                            bigPhoto.value = photos61.last().image.toUri()
                            bigText.value = photos61.last().content
                            listState.animateScrollToItem(index = photos61.size - 1)
                        }
                    }
                    "psixtysecond" -> {
                        if (photos62.isNotEmpty()) {
                            bigPhoto.value = photos62.last().image.toUri()
                            bigText.value = photos62.last().content
                            listState.animateScrollToItem(index = photos62.size - 1)
                        }
                    }
                    "psixtythird" -> {
                        if (photos63.isNotEmpty()) {
                            bigPhoto.value = photos63.last().image.toUri()
                            bigText.value = photos63.last().content
                            listState.animateScrollToItem(index = photos63.size - 1)
                        }
                    }
                    "psixtyfourth" -> {
                        if (photos64.isNotEmpty()) {
                            bigPhoto.value = photos64.last().image.toUri()
                            bigText.value = photos64.last().content
                            listState.animateScrollToItem(index = photos64.size - 1)
                        }
                    }
                    "psixtyfifth" -> {
                        if (photos65.isNotEmpty()) {
                            bigPhoto.value = photos65.last().image.toUri()
                            bigText.value = photos65.last().content
                            listState.animateScrollToItem(index = photos65.size - 1)
                        }
                    }
                    "psixtysixth" -> {
                        if (photos66.isNotEmpty()) {
                            bigPhoto.value = photos66.last().image.toUri()
                            bigText.value = photos66.last().content
                            listState.animateScrollToItem(index = photos66.size - 1)
                        }
                    }
                    "psixtyseventh" -> {
                        if (photos67.isNotEmpty()) {
                            bigPhoto.value = photos67.last().image.toUri()
                            bigText.value = photos67.last().content
                            listState.animateScrollToItem(index = photos67.size - 1)
                        }
                    }
                    "psixtyeighth" -> {
                        if (photos68.isNotEmpty()) {
                            bigPhoto.value = photos68.last().image.toUri()
                            bigText.value = photos68.last().content
                            listState.animateScrollToItem(index = photos68.size - 1)
                        }
                    }
                    "psixtyninth" -> {
                        if (photos69.isNotEmpty()) {
                            bigPhoto.value = photos69.last().image.toUri()
                            bigText.value = photos69.last().content
                            listState.animateScrollToItem(index = photos69.size - 1)
                        }
                    }
                    "pseventieth" -> {
                        if (photos70.isNotEmpty()) {
                            bigPhoto.value = photos70.last().image.toUri()
                            bigText.value = photos70.last().content
                            listState.animateScrollToItem(index = photos70.size - 1)
                        }
                    }
                    "pseventyfirst" -> {
                        if (photos71.isNotEmpty()) {
                            bigPhoto.value = photos71.last().image.toUri()
                            bigText.value = photos71.last().content
                            listState.animateScrollToItem(index = photos71.size - 1)
                        }
                    }
                    "pseventysecond" -> {
                        if (photos72.isNotEmpty()) {
                            bigPhoto.value = photos72.last().image.toUri()
                            bigText.value = photos72.last().content
                            listState.animateScrollToItem(index = photos72.size - 1)
                        }
                    }
                    "pseventythird" -> {
                        if (photos73.isNotEmpty()) {
                            bigPhoto.value = photos73.last().image.toUri()
                            bigText.value = photos73.last().content
                            listState.animateScrollToItem(index = photos73.size - 1)
                        }
                    }
                    "pseventyfourth" -> {
                        if (photos74.isNotEmpty()) {
                            bigPhoto.value = photos74.last().image.toUri()
                            bigText.value = photos74.last().content
                            listState.animateScrollToItem(index = photos74.size - 1)
                        }
                    }
                    "pseventyfifth" -> {
                        if (photos75.isNotEmpty()) {
                            bigPhoto.value = photos75.last().image.toUri()
                            bigText.value = photos75.last().content
                            listState.animateScrollToItem(index = photos75.size - 1)
                        }
                    }
                    "pseventysixth" -> {
                        if (photos76.isNotEmpty()) {
                            bigPhoto.value = photos76.last().image.toUri()
                            bigText.value = photos76.last().content
                            listState.animateScrollToItem(index = photos76.size - 1)
                        }
                    }
                    "pseventyseventh" -> {
                        if (photos77.isNotEmpty()) {
                            bigPhoto.value = photos77.last().image.toUri()
                            bigText.value = photos77.last().content
                            listState.animateScrollToItem(index = photos77.size - 1)
                        }
                    }
                    "pseventyeighth" -> {
                        if (photos78.isNotEmpty()) {
                            bigPhoto.value = photos78.last().image.toUri()
                            bigText.value = photos78.last().content
                            listState.animateScrollToItem(index = photos78.size - 1)
                        }
                    }
                    "pseventyninth" -> {
                        if (photos79.isNotEmpty()) {
                            bigPhoto.value = photos79.last().image.toUri()
                            bigText.value = photos79.last().content
                            listState.animateScrollToItem(index = photos79.size - 1)
                        }
                    }
                    "peightieth" -> {
                        if (photos80.isNotEmpty()) {
                            bigPhoto.value = photos80.last().image.toUri()
                            bigText.value = photos80.last().content
                            listState.animateScrollToItem(index = photos80.size - 1)
                        }
                    }
                    "peightyfirst" -> {
                        if (photos81.isNotEmpty()) {
                            bigPhoto.value = photos81.last().image.toUri()
                            bigText.value = photos81.last().content
                            listState.animateScrollToItem(index = photos81.size - 1)
                        }
                    }
                    "peightysecond" -> {
                        if (photos82.isNotEmpty()) {
                            bigPhoto.value = photos82.last().image.toUri()
                            bigText.value = photos82.last().content
                            listState.animateScrollToItem(index = photos82.size - 1)
                        }
                    }
                    "peightythird" -> {
                        if (photos83.isNotEmpty()) {
                            bigPhoto.value = photos83.last().image.toUri()
                            bigText.value = photos83.last().content
                            listState.animateScrollToItem(index = photos83.size - 1)
                        }
                    }
                    "peightyfourth" -> {
                        if (photos84.isNotEmpty()) {
                            bigPhoto.value = photos84.last().image.toUri()
                            bigText.value = photos84.last().content
                            listState.animateScrollToItem(index = photos84.size - 1)
                        }
                    }
                    "peightyfifth" -> {
                        if (photos85.isNotEmpty()) {
                            bigPhoto.value = photos85.last().image.toUri()
                            bigText.value = photos85.last().content
                            listState.animateScrollToItem(index = photos85.size - 1)
                        }
                    }
                    "peightysixth" -> {
                        if (photos86.isNotEmpty()) {
                            bigPhoto.value = photos86.last().image.toUri()
                            bigText.value = photos86.last().content
                            listState.animateScrollToItem(index = photos86.size - 1)
                        }
                    }
                    "peightyseventh" -> {
                        if (photos87.isNotEmpty()) {
                            bigPhoto.value = photos87.last().image.toUri()
                            bigText.value = photos87.last().content
                            listState.animateScrollToItem(index = photos87.size - 1)
                        }
                    }
                    "peightyeighth" -> {
                        if (photos88.isNotEmpty()) {
                            bigPhoto.value = photos88.last().image.toUri()
                            bigText.value = photos88.last().content
                            listState.animateScrollToItem(index = photos88.size - 1)
                        }
                    }
                    "peightyninth" -> {
                        if (photos89.isNotEmpty()) {
                            bigPhoto.value = photos89.last().image.toUri()
                            bigText.value = photos89.last().content
                            listState.animateScrollToItem(index = photos89.size - 1)
                        }
                    }
                    "pninetieth" -> {
                        if (photos90.isNotEmpty()) {
                            bigPhoto.value = photos90.last().image.toUri()
                            bigText.value = photos90.last().content
                            listState.animateScrollToItem(index = photos90.size - 1)
                        }
                    }
                    "pninetyfirst" -> {
                        if (photos91.isNotEmpty()) {
                            bigPhoto.value = photos91.last().image.toUri()
                            bigText.value = photos91.last().content
                            listState.animateScrollToItem(index = photos91.size - 1)
                        }
                    }
                    "pninetysecond" -> {
                        if (photos92.isNotEmpty()) {
                            bigPhoto.value = photos92.last().image.toUri()
                            bigText.value = photos92.last().content
                            listState.animateScrollToItem(index = photos92.size - 1)
                        }
                    }
                    "pninetythird" -> {
                        if (photos93.isNotEmpty()) {
                            bigPhoto.value = photos93.last().image.toUri()
                            bigText.value = photos93.last().content
                            listState.animateScrollToItem(index = photos93.size - 1)
                        }
                    }
                    "pninetyfourth" -> {
                        if (photos94.isNotEmpty()) {
                            bigPhoto.value = photos94.last().image.toUri()
                            bigText.value = photos94.last().content
                            listState.animateScrollToItem(index = photos94.size - 1)
                        }
                    }
                    "pninetyfifth" -> {
                        if (photos95.isNotEmpty()) {
                            bigPhoto.value = photos95.last().image.toUri()
                            bigText.value = photos95.last().content
                            listState.animateScrollToItem(index = photos95.size - 1)
                        }
                    }
                    "pninetysixth" -> {
                        if (photos96.isNotEmpty()) {
                            bigPhoto.value = photos96.last().image.toUri()
                            bigText.value = photos96.last().content
                            listState.animateScrollToItem(index = photos96.size - 1)
                        }
                    }
                    "pninetyseventh" -> {
                        if (photos97.isNotEmpty()) {
                            bigPhoto.value = photos97.last().image.toUri()
                            bigText.value = photos97.last().content
                            listState.animateScrollToItem(index = photos97.size - 1)
                        }
                    }
                    "pninetyeighth" -> {
                        if (photos98.isNotEmpty()) {
                            bigPhoto.value = photos98.last().image.toUri()
                            bigText.value = photos98.last().content
                            listState.animateScrollToItem(index = photos98.size - 1)
                        }
                    }
                    "pninetyninth" -> {
                        if (photos99.isNotEmpty()) {
                            bigPhoto.value = photos99.last().image.toUri()
                            bigText.value = photos99.last().content
                            listState.animateScrollToItem(index = photos99.size - 1)
                        }
                    }
                    "phundredth" -> {
                        if (photos100.isNotEmpty()) {
                            bigPhoto.value = photos100.last().image.toUri()
                            bigText.value = photos100.last().content
                            listState.animateScrollToItem(index = photos100.size - 1)
                        }
                    }
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
                                            .align(Alignment.TopStart)
                                            .padding(start = 4.dp, top = 4.dp)
                                            .background(colorResource(id = R.color.transparentwhite),
                                                CircleShape)
                                        ){
                                            val formattedDate = extractAndFormatDate(changedImage)
                                            Text(
                                                text = formattedDate,
                                                modifier = Modifier.padding(4.dp),
                                                fontSize = 10.sp,
                                                color = colorResource(id = R.color.black),
                                                fontWeight = FontWeight.Bold,
                                            )
                                        }
                                        Box(modifier = Modifier
                                            .size(32.dp)
                                            .align(Alignment.TopEnd)
                                            .padding(4.dp)
                                            .background(
                                                colorResource(id = R.color.transparentwhite),
                                                CircleShape
                                            )
                                            .clickable {
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
                                                                       "pfirst" -> {
                                                                           val photo1 = Photo1(content = photos1[indexToDelete].content, image = photos1[indexToDelete].image)
                                                                           viewModel1.deleteNewPhoto(photo1, context)
                                                                           photos1.toMutableList().apply { removeAt(indexToDelete) }
                                                                           if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                               currentIndex.value -= 1
                                                                           }
                                                                           bigPhoto.value = photos1[currentIndex.value].image.toUri()
                                                                           bigText.value = photos1[currentIndex.value].content
                                                                       }
                                                                        "psecond" -> {
                                                                            val photo2 = Photo2(content = photos2[indexToDelete].content, image = photos2[indexToDelete].image)
                                                                            viewModel2.deleteNewPhoto(photo2, context)
                                                                            photos2.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos2[currentIndex.value].image.toUri()
                                                                            bigText.value = photos2[currentIndex.value].content
                                                                        }
                                                                        "pthird" -> {
                                                                            val photo3 = Photo3(content = photos3[indexToDelete].content, image = photos3[indexToDelete].image)
                                                                            viewModel3.deleteNewPhoto(photo3, context)
                                                                            photos3.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos3[currentIndex.value].image.toUri()
                                                                            bigText.value = photos3[currentIndex.value].content
                                                                        }
                                                                        "pfourth" -> {
                                                                            val photo4 = Photo4(content = photos4[indexToDelete].content, image = photos4[indexToDelete].image)
                                                                            viewModel4.deleteNewPhoto(photo4, context)
                                                                            photos4.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos4[currentIndex.value].image.toUri()
                                                                            bigText.value = photos4[currentIndex.value].content
                                                                        }
                                                                        "pfifth" -> {
                                                                            val photo5 = Photo5(content = photos5[indexToDelete].content, image = photos5[indexToDelete].image)
                                                                            viewModel5.deleteNewPhoto(photo5, context)
                                                                            photos5.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos5[currentIndex.value].image.toUri()
                                                                            bigText.value = photos5[currentIndex.value].content
                                                                        }
                                                                        "psixth" -> {
                                                                            val photo6 = Photo6(content = photos6[indexToDelete].content, image = photos6[indexToDelete].image)
                                                                            viewModel6.deleteNewPhoto(photo6, context)
                                                                            photos6.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos6[currentIndex.value].image.toUri()
                                                                            bigText.value = photos6[currentIndex.value].content
                                                                        }
                                                                        "pseventh" -> {
                                                                            val photo7 = Photo7(content = photos7[indexToDelete].content, image = photos7[indexToDelete].image)
                                                                            viewModel7.deleteNewPhoto(photo7, context)
                                                                            photos7.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos7[currentIndex.value].image.toUri()
                                                                            bigText.value = photos7[currentIndex.value].content
                                                                        }
                                                                        "peighth" -> {
                                                                            val photo8 = Photo8(content = photos8[indexToDelete].content, image = photos8[indexToDelete].image)
                                                                            viewModel8.deleteNewPhoto(photo8, context)
                                                                            photos8.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos8[currentIndex.value].image.toUri()
                                                                            bigText.value = photos8[currentIndex.value].content
                                                                        }
                                                                        "pninth" -> {
                                                                            val photo9 = Photo9(content = photos9[indexToDelete].content, image = photos9[indexToDelete].image)
                                                                            viewModel9.deleteNewPhoto(photo9, context)
                                                                            photos9.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos9[currentIndex.value].image.toUri()
                                                                            bigText.value = photos9[currentIndex.value].content
                                                                        }
                                                                        "ptenth" -> {
                                                                            val photo10 = Photo10(content = photos10[indexToDelete].content, image = photos10[indexToDelete].image)
                                                                            viewModel10.deleteNewPhoto(photo10, context)
                                                                            photos10.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos10[currentIndex.value].image.toUri()
                                                                            bigText.value = photos10[currentIndex.value].content
                                                                        }
                                                                        "peleventh" -> {
                                                                            val photo11 = Photo11(content = photos11[indexToDelete].content, image = photos11[indexToDelete].image)
                                                                            viewModel11.deleteNewPhoto(photo11, context)
                                                                            photos11.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos11[currentIndex.value].image.toUri()
                                                                            bigText.value = photos11[currentIndex.value].content
                                                                        }
                                                                        "ptwelfth" -> {
                                                                            val photo12 = Photo12(content = photos12[indexToDelete].content, image = photos12[indexToDelete].image)
                                                                            viewModel12.deleteNewPhoto(photo12, context)
                                                                            photos12.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos12[currentIndex.value].image.toUri()
                                                                            bigText.value = photos12[currentIndex.value].content
                                                                        }
                                                                        "pthirteenth" -> {
                                                                            val photo13 = Photo13(content = photos13[indexToDelete].content, image = photos13[indexToDelete].image)
                                                                            viewModel13.deleteNewPhoto(photo13, context)
                                                                            photos13.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos13[currentIndex.value].image.toUri()
                                                                            bigText.value = photos13[currentIndex.value].content
                                                                        }
                                                                        "pfourteenth" -> {
                                                                            val photo14 = Photo14(content = photos14[indexToDelete].content, image = photos14[indexToDelete].image)
                                                                            viewModel14.deleteNewPhoto(photo14, context)
                                                                            photos14.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos14[currentIndex.value].image.toUri()
                                                                            bigText.value = photos14[currentIndex.value].content
                                                                        }
                                                                        "pfifteenth" -> {
                                                                            val photo15 = Photo15(content = photos15[indexToDelete].content, image = photos15[indexToDelete].image)
                                                                            viewModel15.deleteNewPhoto(photo15, context)
                                                                            photos15.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos15[currentIndex.value].image.toUri()
                                                                            bigText.value = photos15[currentIndex.value].content
                                                                        }
                                                                        "psixteenth" -> {
                                                                            val photo16 = Photo16(content = photos16[indexToDelete].content, image = photos16[indexToDelete].image)
                                                                            viewModel16.deleteNewPhoto(photo16, context)
                                                                            photos16.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos16[currentIndex.value].image.toUri()
                                                                            bigText.value = photos16[currentIndex.value].content
                                                                        }
                                                                        "pseventeenth" -> {
                                                                            val photo17 = Photo17(content = photos17[indexToDelete].content, image = photos17[indexToDelete].image)
                                                                            viewModel17.deleteNewPhoto(photo17, context)
                                                                            photos17.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos17[currentIndex.value].image.toUri()
                                                                            bigText.value = photos17[currentIndex.value].content
                                                                        }
                                                                        "peighteenth" -> {
                                                                            val photo18 = Photo18(content = photos18[indexToDelete].content, image = photos18[indexToDelete].image)
                                                                            viewModel18.deleteNewPhoto(photo18, context)
                                                                            photos18.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos18[currentIndex.value].image.toUri()
                                                                            bigText.value = photos18[currentIndex.value].content
                                                                        }
                                                                        "pnineteenth" -> {
                                                                            val photo19 = Photo19(content = photos19[indexToDelete].content, image = photos19[indexToDelete].image)
                                                                            viewModel19.deleteNewPhoto(photo19, context)
                                                                            photos19.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos19[currentIndex.value].image.toUri()
                                                                            bigText.value = photos19[currentIndex.value].content
                                                                        }
                                                                        "ptwentieth" -> {
                                                                            val photo20 = Photo20(content = photos20[indexToDelete].content, image = photos20[indexToDelete].image)
                                                                            viewModel20.deleteNewPhoto(photo20, context)
                                                                            photos20.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos20[currentIndex.value].image.toUri()
                                                                            bigText.value = photos20[currentIndex.value].content
                                                                        }
                                                                        "ptwentyfirst" -> {
                                                                            val photo21 = Photo21(content = photos21[indexToDelete].content, image = photos21[indexToDelete].image)
                                                                            viewModel21.deleteNewPhoto(photo21, context)
                                                                            photos21.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos21[currentIndex.value].image.toUri()
                                                                            bigText.value = photos21[currentIndex.value].content
                                                                        }
                                                                        "ptwentysecond" -> {
                                                                            val photo22 = Photo22(content = photos22[indexToDelete].content, image = photos22[indexToDelete].image)
                                                                            viewModel22.deleteNewPhoto(photo22, context)
                                                                            photos22.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos22[currentIndex.value].image.toUri()
                                                                            bigText.value = photos22[currentIndex.value].content
                                                                        }
                                                                        "ptwentythird" -> {
                                                                            val photo23 = Photo23(content = photos23[indexToDelete].content, image = photos23[indexToDelete].image)
                                                                            viewModel23.deleteNewPhoto(photo23, context)
                                                                            photos23.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos23[currentIndex.value].image.toUri()
                                                                            bigText.value = photos23[currentIndex.value].content
                                                                        }
                                                                        "ptwentyfourth" -> {
                                                                            val photo24 = Photo24(content = photos24[indexToDelete].content, image = photos24[indexToDelete].image)
                                                                            viewModel24.deleteNewPhoto(photo24, context)
                                                                            photos24.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos24[currentIndex.value].image.toUri()
                                                                            bigText.value = photos24[currentIndex.value].content
                                                                        }
                                                                        "ptwentyfifth" -> {
                                                                            val photo25 = Photo25(content = photos25[indexToDelete].content, image = photos25[indexToDelete].image)
                                                                            viewModel25.deleteNewPhoto(photo25, context)
                                                                            photos25.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos25[currentIndex.value].image.toUri()
                                                                            bigText.value = photos25[currentIndex.value].content
                                                                        }
                                                                        "ptwentysixth" -> {
                                                                            val photo26 = Photo26(content = photos26[indexToDelete].content, image = photos26[indexToDelete].image)
                                                                            viewModel26.deleteNewPhoto(photo26, context)
                                                                            photos26.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos26[currentIndex.value].image.toUri()
                                                                            bigText.value = photos26[currentIndex.value].content
                                                                        }
                                                                        "ptwentyseventh" -> {
                                                                            val photo27 = Photo27(content = photos27[indexToDelete].content, image = photos27[indexToDelete].image)
                                                                            viewModel27.deleteNewPhoto(photo27, context)
                                                                            photos27.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos27[currentIndex.value].image.toUri()
                                                                            bigText.value = photos27[currentIndex.value].content
                                                                        }
                                                                        "ptwentyeighth" -> {
                                                                            val photo28 = Photo28(content = photos28[indexToDelete].content, image = photos28[indexToDelete].image)
                                                                            viewModel28.deleteNewPhoto(photo28, context)
                                                                            photos28.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos28[currentIndex.value].image.toUri()
                                                                            bigText.value = photos28[currentIndex.value].content
                                                                        }
                                                                        "ptwentyninth" -> {
                                                                            val photo29 = Photo29(content = photos29[indexToDelete].content, image = photos29[indexToDelete].image)
                                                                            viewModel29.deleteNewPhoto(photo29, context)
                                                                            photos29.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos29[currentIndex.value].image.toUri()
                                                                            bigText.value = photos29[currentIndex.value].content
                                                                        }
                                                                        "pthirtieth" -> {
                                                                            val photo30 = Photo30(content = photos30[indexToDelete].content, image = photos30[indexToDelete].image)
                                                                            viewModel30.deleteNewPhoto(photo30, context)
                                                                            photos30.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos30[currentIndex.value].image.toUri()
                                                                            bigText.value = photos30[currentIndex.value].content
                                                                        }
                                                                        "pthirtyfirst" -> {
                                                                            val photo31 = Photo31(content = photos31[indexToDelete].content, image = photos31[indexToDelete].image)
                                                                            viewModel31.deleteNewPhoto(photo31, context)
                                                                            photos31.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos31[currentIndex.value].image.toUri()
                                                                            bigText.value = photos31[currentIndex.value].content
                                                                        }
                                                                        "pthirtysecond" -> {
                                                                            val photo32 = Photo32(content = photos32[indexToDelete].content, image = photos32[indexToDelete].image)
                                                                            viewModel32.deleteNewPhoto(photo32, context)
                                                                            photos32.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos32[currentIndex.value].image.toUri()
                                                                            bigText.value = photos32[currentIndex.value].content
                                                                        }
                                                                        "pthirtythird" -> {
                                                                            val photo33 = Photo33(content = photos33[indexToDelete].content, image = photos33[indexToDelete].image)
                                                                            viewModel33.deleteNewPhoto(photo33, context)
                                                                            photos33.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos33[currentIndex.value].image.toUri()
                                                                            bigText.value = photos33[currentIndex.value].content
                                                                        }
                                                                        "pthirtyfourth" -> {
                                                                            val photo34 = Photo34(content = photos34[indexToDelete].content, image = photos34[indexToDelete].image)
                                                                            viewModel34.deleteNewPhoto(photo34, context)
                                                                            photos34.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos34[currentIndex.value].image.toUri()
                                                                            bigText.value = photos34[currentIndex.value].content
                                                                        }
                                                                        "pthirtyfifth" -> {
                                                                            val photo35 = Photo35(content = photos35[indexToDelete].content, image = photos35[indexToDelete].image)
                                                                            viewModel35.deleteNewPhoto(photo35, context)
                                                                            photos35.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos35[currentIndex.value].image.toUri()
                                                                            bigText.value = photos35[currentIndex.value].content
                                                                        }
                                                                        "pthirtysixth" -> {
                                                                            val photo36 = Photo36(content = photos36[indexToDelete].content, image = photos36[indexToDelete].image)
                                                                            viewModel36.deleteNewPhoto(photo36, context)
                                                                            photos36.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos36[currentIndex.value].image.toUri()
                                                                            bigText.value = photos36[currentIndex.value].content
                                                                        }
                                                                        "pthirtyseventh" -> {
                                                                            val photo37 = Photo37(content = photos37[indexToDelete].content, image = photos37[indexToDelete].image)
                                                                            viewModel37.deleteNewPhoto(photo37, context)
                                                                            photos37.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos37[currentIndex.value].image.toUri()
                                                                            bigText.value = photos37[currentIndex.value].content
                                                                        }
                                                                        "pthirtyeighth" -> {
                                                                            val photo38 = Photo38(content = photos38[indexToDelete].content, image = photos38[indexToDelete].image)
                                                                            viewModel38.deleteNewPhoto(photo38, context)
                                                                            photos38.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos38[currentIndex.value].image.toUri()
                                                                            bigText.value = photos38[currentIndex.value].content
                                                                        }
                                                                        "pthirtyninth" -> {
                                                                            val photo39 = Photo39(content = photos39[indexToDelete].content, image = photos39[indexToDelete].image)
                                                                            viewModel39.deleteNewPhoto(photo39, context)
                                                                            photos39.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos39[currentIndex.value].image.toUri()
                                                                            bigText.value = photos39[currentIndex.value].content
                                                                        }
                                                                        "pfourtieth" -> {
                                                                            val photo40 = Photo40(content = photos40[indexToDelete].content, image = photos40[indexToDelete].image)
                                                                            viewModel40.deleteNewPhoto(photo40, context)
                                                                            photos40.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos40[currentIndex.value].image.toUri()
                                                                            bigText.value = photos40[currentIndex.value].content
                                                                        }
                                                                        "pfourtyfirst" -> {
                                                                            val photo41 = Photo41(content = photos41[indexToDelete].content, image = photos41[indexToDelete].image)
                                                                            viewModel41.deleteNewPhoto(photo41, context)
                                                                            photos41.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos41[currentIndex.value].image.toUri()
                                                                            bigText.value = photos41[currentIndex.value].content
                                                                        }
                                                                        "pfourtysecond" -> {
                                                                            val photo42 = Photo42(content = photos42[indexToDelete].content, image = photos42[indexToDelete].image)
                                                                            viewModel42.deleteNewPhoto(photo42, context)
                                                                            photos42.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos42[currentIndex.value].image.toUri()
                                                                            bigText.value = photos42[currentIndex.value].content
                                                                        }
                                                                        "pfourtythird" -> {
                                                                            val photo43 = Photo43(content = photos43[indexToDelete].content, image = photos43[indexToDelete].image)
                                                                            viewModel43.deleteNewPhoto(photo43, context)
                                                                            photos43.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos43[currentIndex.value].image.toUri()
                                                                            bigText.value = photos43[currentIndex.value].content
                                                                        }
                                                                        "pfourtyfourth" -> {
                                                                            val photo44 = Photo44(content = photos44[indexToDelete].content, image = photos44[indexToDelete].image)
                                                                            viewModel44.deleteNewPhoto(photo44, context)
                                                                            photos44.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos44[currentIndex.value].image.toUri()
                                                                            bigText.value = photos44[currentIndex.value].content
                                                                        }
                                                                        "pfourtyfifth" -> {
                                                                            val photo45 = Photo45(content = photos45[indexToDelete].content, image = photos45[indexToDelete].image)
                                                                            viewModel45.deleteNewPhoto(photo45, context)
                                                                            photos45.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos45[currentIndex.value].image.toUri()
                                                                            bigText.value = photos45[currentIndex.value].content
                                                                        }
                                                                        "pfourtysixth" -> {
                                                                            val photo46 = Photo46(content = photos46[indexToDelete].content, image = photos46[indexToDelete].image)
                                                                            viewModel46.deleteNewPhoto(photo46, context)
                                                                            photos46.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos46[currentIndex.value].image.toUri()
                                                                            bigText.value = photos46[currentIndex.value].content
                                                                        }
                                                                        "pfourtyseventh" -> {
                                                                            val photo47 = Photo47(content = photos47[indexToDelete].content, image = photos47[indexToDelete].image)
                                                                            viewModel47.deleteNewPhoto(photo47, context)
                                                                            photos47.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos47[currentIndex.value].image.toUri()
                                                                            bigText.value = photos47[currentIndex.value].content
                                                                        }
                                                                        "pfourtyeighth" -> {
                                                                            val photo48 = Photo48(content = photos48[indexToDelete].content, image = photos48[indexToDelete].image)
                                                                            viewModel48.deleteNewPhoto(photo48, context)
                                                                            photos48.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos48[currentIndex.value].image.toUri()
                                                                            bigText.value = photos48[currentIndex.value].content
                                                                        }
                                                                        "pfourtyninth" -> {
                                                                            val photo49 = Photo49(content = photos49[indexToDelete].content, image = photos49[indexToDelete].image)
                                                                            viewModel49.deleteNewPhoto(photo49, context)
                                                                            photos49.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos49[currentIndex.value].image.toUri()
                                                                            bigText.value = photos49[currentIndex.value].content
                                                                        }
                                                                        "pfiftieth" -> {
                                                                            val photo50 = Photo50(content = photos50[indexToDelete].content, image = photos50[indexToDelete].image)
                                                                            viewModel50.deleteNewPhoto(photo50, context)
                                                                            photos50.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos50[currentIndex.value].image.toUri()
                                                                            bigText.value = photos50[currentIndex.value].content
                                                                        }
                                                                        "pfiftyfirst" -> {
                                                                            val photo51 = Photo51(content = photos51[indexToDelete].content, image = photos51[indexToDelete].image)
                                                                            viewModel51.deleteNewPhoto(photo51, context)
                                                                            photos51.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos51[currentIndex.value].image.toUri()
                                                                            bigText.value = photos51[currentIndex.value].content
                                                                        }
                                                                        "pfiftysecond" -> {
                                                                            val photo52 = Photo52(content = photos52[indexToDelete].content, image = photos52[indexToDelete].image)
                                                                            viewModel52.deleteNewPhoto(photo52, context)
                                                                            photos52.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos52[currentIndex.value].image.toUri()
                                                                            bigText.value = photos52[currentIndex.value].content
                                                                        }
                                                                        "pfiftythird" -> {
                                                                            val photo53 = Photo53(content = photos53[indexToDelete].content, image = photos53[indexToDelete].image)
                                                                            viewModel53.deleteNewPhoto(photo53, context)
                                                                            photos53.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos53[currentIndex.value].image.toUri()
                                                                            bigText.value = photos53[currentIndex.value].content
                                                                        }
                                                                        "pfiftyfourth" -> {
                                                                            val photo54 = Photo54(content = photos54[indexToDelete].content, image = photos54[indexToDelete].image)
                                                                            viewModel54.deleteNewPhoto(photo54, context)
                                                                            photos54.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos54[currentIndex.value].image.toUri()
                                                                            bigText.value = photos54[currentIndex.value].content
                                                                        }
                                                                        "pfiftyfifth" -> {
                                                                            val photo55 = Photo55(content = photos55[indexToDelete].content, image = photos55[indexToDelete].image)
                                                                            viewModel55.deleteNewPhoto(photo55, context)
                                                                            photos55.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos55[currentIndex.value].image.toUri()
                                                                            bigText.value = photos55[currentIndex.value].content
                                                                        }
                                                                        "pfiftysixth" -> {
                                                                            val photo56 = Photo56(content = photos56[indexToDelete].content, image = photos56[indexToDelete].image)
                                                                            viewModel56.deleteNewPhoto(photo56, context)
                                                                            photos56.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos56[currentIndex.value].image.toUri()
                                                                            bigText.value = photos56[currentIndex.value].content
                                                                        }
                                                                        "pfiftyseventh" -> {
                                                                            val photo57 = Photo57(content = photos57[indexToDelete].content, image = photos57[indexToDelete].image)
                                                                            viewModel57.deleteNewPhoto(photo57, context)
                                                                            photos57.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos57[currentIndex.value].image.toUri()
                                                                            bigText.value = photos57[currentIndex.value].content
                                                                        }
                                                                        "pfiftyeighth" -> {
                                                                            val photo58 = Photo58(content = photos58[indexToDelete].content, image = photos58[indexToDelete].image)
                                                                            viewModel58.deleteNewPhoto(photo58, context)
                                                                            photos58.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos58[currentIndex.value].image.toUri()
                                                                            bigText.value = photos58[currentIndex.value].content
                                                                        }
                                                                        "pfiftyninth" -> {
                                                                            val photo59 = Photo59(content = photos59[indexToDelete].content, image = photos59[indexToDelete].image)
                                                                            viewModel59.deleteNewPhoto(photo59, context)
                                                                            photos59.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos59[currentIndex.value].image.toUri()
                                                                            bigText.value = photos59[currentIndex.value].content
                                                                        }
                                                                        "psixtieth" -> {
                                                                            val photo60 = Photo60(content = photos60[indexToDelete].content, image = photos60[indexToDelete].image)
                                                                            viewModel60.deleteNewPhoto(photo60, context)
                                                                            photos60.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos60[currentIndex.value].image.toUri()
                                                                            bigText.value = photos60[currentIndex.value].content
                                                                        }
                                                                        "psixtyfirst" -> {
                                                                            val photo61 = Photo61(content = photos61[indexToDelete].content, image = photos61[indexToDelete].image)
                                                                            viewModel61.deleteNewPhoto(photo61, context)
                                                                            photos61.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos61[currentIndex.value].image.toUri()
                                                                            bigText.value = photos61[currentIndex.value].content
                                                                        }
                                                                        "psixtysecond" -> {
                                                                            val photo62 = Photo62(content = photos62[indexToDelete].content, image = photos62[indexToDelete].image)
                                                                            viewModel62.deleteNewPhoto(photo62, context)
                                                                            photos62.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos62[currentIndex.value].image.toUri()
                                                                            bigText.value = photos62[currentIndex.value].content
                                                                        }
                                                                        "psixtythird" -> {
                                                                            val photo63 = Photo63(content = photos63[indexToDelete].content, image = photos63[indexToDelete].image)
                                                                            viewModel63.deleteNewPhoto(photo63, context)
                                                                            photos63.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos63[currentIndex.value].image.toUri()
                                                                            bigText.value = photos63[currentIndex.value].content
                                                                        }
                                                                        "psixtyfourth" -> {
                                                                            val photo64 = Photo64(content = photos64[indexToDelete].content, image = photos64[indexToDelete].image)
                                                                            viewModel64.deleteNewPhoto(photo64, context)
                                                                            photos64.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos64[currentIndex.value].image.toUri()
                                                                            bigText.value = photos64[currentIndex.value].content
                                                                        }
                                                                        "psixtyfifth" -> {
                                                                            val photo65 = Photo65(content = photos65[indexToDelete].content, image = photos65[indexToDelete].image)
                                                                            viewModel65.deleteNewPhoto(photo65, context)
                                                                            photos65.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos65[currentIndex.value].image.toUri()
                                                                            bigText.value = photos65[currentIndex.value].content
                                                                        }
                                                                        "psixtysixth" -> {
                                                                            val photo66 = Photo66(content = photos66[indexToDelete].content, image = photos66[indexToDelete].image)
                                                                            viewModel66.deleteNewPhoto(photo66, context)
                                                                            photos66.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos66[currentIndex.value].image.toUri()
                                                                            bigText.value = photos66[currentIndex.value].content
                                                                        }
                                                                        "psixtyseventh" -> {
                                                                            val photo67 = Photo67(content = photos67[indexToDelete].content, image = photos67[indexToDelete].image)
                                                                            viewModel67.deleteNewPhoto(photo67, context)
                                                                            photos67.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos67[currentIndex.value].image.toUri()
                                                                            bigText.value = photos67[currentIndex.value].content
                                                                        }
                                                                        "psixtyeighth" -> {
                                                                            val photo68 = Photo68(content = photos68[indexToDelete].content, image = photos68[indexToDelete].image)
                                                                            viewModel68.deleteNewPhoto(photo68, context)
                                                                            photos68.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos68[currentIndex.value].image.toUri()
                                                                            bigText.value = photos68[currentIndex.value].content
                                                                        }
                                                                        "psixtyninth" -> {
                                                                            val photo69 = Photo69(content = photos69[indexToDelete].content, image = photos69[indexToDelete].image)
                                                                            viewModel69.deleteNewPhoto(photo69, context)
                                                                            photos69.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos69[currentIndex.value].image.toUri()
                                                                            bigText.value = photos69[currentIndex.value].content
                                                                        }
                                                                        "pseventieth" -> {
                                                                            val photo70 = Photo70(content = photos70[indexToDelete].content, image = photos70[indexToDelete].image)
                                                                            viewModel70.deleteNewPhoto(photo70, context)
                                                                            photos70.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos70[currentIndex.value].image.toUri()
                                                                            bigText.value = photos70[currentIndex.value].content
                                                                        }
                                                                        "pseventyfirst" -> {
                                                                            val photo71 = Photo71(content = photos71[indexToDelete].content, image = photos71[indexToDelete].image)
                                                                            viewModel71.deleteNewPhoto(photo71, context)
                                                                            photos71.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos71[currentIndex.value].image.toUri()
                                                                            bigText.value = photos71[currentIndex.value].content
                                                                        }
                                                                        "pseventysecond" -> {
                                                                            val photo72 = Photo72(content = photos72[indexToDelete].content, image = photos72[indexToDelete].image)
                                                                            viewModel72.deleteNewPhoto(photo72, context)
                                                                            photos72.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos72[currentIndex.value].image.toUri()
                                                                            bigText.value = photos72[currentIndex.value].content
                                                                        }
                                                                        "pseventythird" -> {
                                                                            val photo73 = Photo73(content = photos73[indexToDelete].content, image = photos73[indexToDelete].image)
                                                                            viewModel73.deleteNewPhoto(photo73, context)
                                                                            photos73.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos73[currentIndex.value].image.toUri()
                                                                            bigText.value = photos73[currentIndex.value].content
                                                                        }
                                                                        "pseventyfourth" -> {
                                                                            val photo74 = Photo74(content = photos74[indexToDelete].content, image = photos74[indexToDelete].image)
                                                                            viewModel74.deleteNewPhoto(photo74, context)
                                                                            photos74.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos74[currentIndex.value].image.toUri()
                                                                            bigText.value = photos74[currentIndex.value].content
                                                                        }
                                                                        "pseventyfifth" -> {
                                                                            val photo75 = Photo75(content = photos75[indexToDelete].content, image = photos75[indexToDelete].image)
                                                                            viewModel75.deleteNewPhoto(photo75, context)
                                                                            photos75.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos75[currentIndex.value].image.toUri()
                                                                            bigText.value = photos75[currentIndex.value].content
                                                                        }
                                                                        "pseventysixth" -> {
                                                                            val photo76 = Photo76(content = photos76[indexToDelete].content, image = photos76[indexToDelete].image)
                                                                            viewModel76.deleteNewPhoto(photo76, context)
                                                                            photos76.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos76[currentIndex.value].image.toUri()
                                                                            bigText.value = photos76[currentIndex.value].content
                                                                        }
                                                                        "pseventyseventh" -> {
                                                                            val photo77 = Photo77(content = photos77[indexToDelete].content, image = photos77[indexToDelete].image)
                                                                            viewModel77.deleteNewPhoto(photo77, context)
                                                                            photos77.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos77[currentIndex.value].image.toUri()
                                                                            bigText.value = photos77[currentIndex.value].content
                                                                        }
                                                                        "pseventyeighth" -> {
                                                                            val photo78 = Photo78(content = photos78[indexToDelete].content, image = photos78[indexToDelete].image)
                                                                            viewModel78.deleteNewPhoto(photo78, context)
                                                                            photos78.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos78[currentIndex.value].image.toUri()
                                                                            bigText.value = photos78[currentIndex.value].content
                                                                        }
                                                                        "pseventyninth" -> {
                                                                            val photo79 = Photo79(content = photos79[indexToDelete].content, image = photos79[indexToDelete].image)
                                                                            viewModel79.deleteNewPhoto(photo79, context)
                                                                            photos79.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos79[currentIndex.value].image.toUri()
                                                                            bigText.value = photos79[currentIndex.value].content
                                                                        }
                                                                        "peightieth" -> {
                                                                            val photo80 = Photo80(content = photos80[indexToDelete].content, image = photos80[indexToDelete].image)
                                                                            viewModel80.deleteNewPhoto(photo80, context)
                                                                            photos80.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos80[currentIndex.value].image.toUri()
                                                                            bigText.value = photos80[currentIndex.value].content
                                                                        }
                                                                        "peightyfirst" -> {
                                                                            val photo81 = Photo81(content = photos81[indexToDelete].content, image = photos81[indexToDelete].image)
                                                                            viewModel81.deleteNewPhoto(photo81, context)
                                                                            photos81.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos81[currentIndex.value].image.toUri()
                                                                            bigText.value = photos81[currentIndex.value].content
                                                                        }
                                                                        "peightysecond" -> {
                                                                            val photo82 = Photo82(content = photos82[indexToDelete].content, image = photos82[indexToDelete].image)
                                                                            viewModel82.deleteNewPhoto(photo82, context)
                                                                            photos82.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos82[currentIndex.value].image.toUri()
                                                                            bigText.value = photos82[currentIndex.value].content
                                                                        }
                                                                        "peightythird" -> {
                                                                            val photo83 = Photo83(content = photos83[indexToDelete].content, image = photos83[indexToDelete].image)
                                                                            viewModel83.deleteNewPhoto(photo83, context)
                                                                            photos83.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos83[currentIndex.value].image.toUri()
                                                                            bigText.value = photos83[currentIndex.value].content
                                                                        }
                                                                        "peightyfourth" -> {
                                                                            val photo84 = Photo84(content = photos84[indexToDelete].content, image = photos84[indexToDelete].image)
                                                                            viewModel84.deleteNewPhoto(photo84, context)
                                                                            photos84.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos84[currentIndex.value].image.toUri()
                                                                            bigText.value = photos84[currentIndex.value].content
                                                                        }
                                                                        "peightyfifth" -> {
                                                                            val photo85 = Photo85(content = photos85[indexToDelete].content, image = photos85[indexToDelete].image)
                                                                            viewModel85.deleteNewPhoto(photo85, context)
                                                                            photos85.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos85[currentIndex.value].image.toUri()
                                                                            bigText.value = photos85[currentIndex.value].content
                                                                        }
                                                                        "peightysixth" -> {
                                                                            val photo86 = Photo86(content = photos86[indexToDelete].content, image = photos86[indexToDelete].image)
                                                                            viewModel86.deleteNewPhoto(photo86, context)
                                                                            photos86.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos86[currentIndex.value].image.toUri()
                                                                            bigText.value = photos86[currentIndex.value].content
                                                                        }
                                                                        "peightyseventh" -> {
                                                                            val photo87 = Photo87(content = photos87[indexToDelete].content, image = photos87[indexToDelete].image)
                                                                            viewModel87.deleteNewPhoto(photo87, context)
                                                                            photos87.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos87[currentIndex.value].image.toUri()
                                                                            bigText.value = photos87[currentIndex.value].content
                                                                        }
                                                                        "peightyeighth" -> {
                                                                            val photo88 = Photo88(content = photos88[indexToDelete].content, image = photos88[indexToDelete].image)
                                                                            viewModel88.deleteNewPhoto(photo88, context)
                                                                            photos88.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos88[currentIndex.value].image.toUri()
                                                                            bigText.value = photos88[currentIndex.value].content
                                                                        }
                                                                        "peightyninth" -> {
                                                                            val photo89 = Photo89(content = photos89[indexToDelete].content, image = photos89[indexToDelete].image)
                                                                            viewModel89.deleteNewPhoto(photo89, context)
                                                                            photos89.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos89[currentIndex.value].image.toUri()
                                                                            bigText.value = photos89[currentIndex.value].content
                                                                        }
                                                                        "pninetieth" -> {
                                                                            val photo90 = Photo90(content = photos90[indexToDelete].content, image = photos90[indexToDelete].image)
                                                                            viewModel90.deleteNewPhoto(photo90, context)
                                                                            photos90.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos90[currentIndex.value].image.toUri()
                                                                            bigText.value = photos90[currentIndex.value].content
                                                                        }
                                                                        "pninetyfirst" -> {
                                                                            val photo91 = Photo91(content = photos91[indexToDelete].content, image = photos91[indexToDelete].image)
                                                                            viewModel91.deleteNewPhoto(photo91, context)
                                                                            photos91.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos91[currentIndex.value].image.toUri()
                                                                            bigText.value = photos91[currentIndex.value].content
                                                                        }
                                                                        "pninetysecond" -> {
                                                                            val photo92 = Photo92(content = photos92[indexToDelete].content, image = photos92[indexToDelete].image)
                                                                            viewModel92.deleteNewPhoto(photo92, context)
                                                                            photos92.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos92[currentIndex.value].image.toUri()
                                                                            bigText.value = photos92[currentIndex.value].content
                                                                        }
                                                                        "pninetythird" -> {
                                                                            val photo93 = Photo93(content = photos93[indexToDelete].content, image = photos93[indexToDelete].image)
                                                                            viewModel93.deleteNewPhoto(photo93, context)
                                                                            photos93.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos93[currentIndex.value].image.toUri()
                                                                            bigText.value = photos93[currentIndex.value].content
                                                                        }
                                                                        "pninetyfourth" -> {
                                                                            val photo94 = Photo94(content = photos94[indexToDelete].content, image = photos94[indexToDelete].image)
                                                                            viewModel94.deleteNewPhoto(photo94, context)
                                                                            photos94.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos94[currentIndex.value].image.toUri()
                                                                            bigText.value = photos94[currentIndex.value].content
                                                                        }
                                                                        "pninetyfifth" -> {
                                                                            val photo95 = Photo95(content = photos95[indexToDelete].content, image = photos95[indexToDelete].image)
                                                                            viewModel95.deleteNewPhoto(photo95, context)
                                                                            photos95.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos95[currentIndex.value].image.toUri()
                                                                            bigText.value = photos95[currentIndex.value].content
                                                                        }
                                                                        "pninetysixth" -> {
                                                                            val photo96 = Photo96(content = photos96[indexToDelete].content, image = photos96[indexToDelete].image)
                                                                            viewModel96.deleteNewPhoto(photo96, context)
                                                                            photos96.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos96[currentIndex.value].image.toUri()
                                                                            bigText.value = photos96[currentIndex.value].content
                                                                        }
                                                                        "pninetyseventh" -> {
                                                                            val photo97 = Photo97(content = photos97[indexToDelete].content, image = photos97[indexToDelete].image)
                                                                            viewModel97.deleteNewPhoto(photo97, context)
                                                                            photos97.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos97[currentIndex.value].image.toUri()
                                                                            bigText.value = photos97[currentIndex.value].content
                                                                        }
                                                                        "pninetyeighth" -> {
                                                                            val photo98 = Photo98(content = photos98[indexToDelete].content, image = photos98[indexToDelete].image)
                                                                            viewModel98.deleteNewPhoto(photo98, context)
                                                                            photos98.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos98[currentIndex.value].image.toUri()
                                                                            bigText.value = photos98[currentIndex.value].content
                                                                        }
                                                                        "pninetyninth" -> {
                                                                            val photo99 = Photo99(content = photos99[indexToDelete].content, image = photos99[indexToDelete].image)
                                                                            viewModel99.deleteNewPhoto(photo99, context)
                                                                            photos99.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos99[currentIndex.value].image.toUri()
                                                                            bigText.value = photos99[currentIndex.value].content
                                                                        }
                                                                        "phundredth" -> {
                                                                            val photo100 = Photo100(content = photos100[indexToDelete].content, image = photos100[indexToDelete].image)
                                                                            viewModel100.deleteNewPhoto(photo100, context)
                                                                            photos100.toMutableList().apply { removeAt(indexToDelete) }
                                                                            if (currentIndex.value == indexToDelete && indexToDelete > 0) {
                                                                                currentIndex.value -= 1
                                                                            }
                                                                            bigPhoto.value = photos100[currentIndex.value].image.toUri()
                                                                            bigText.value = photos100[currentIndex.value].content
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
        BottomButtons(Modifier, navController, { showDialog.value = true }, photoKey)
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
                                "pfirst" -> { viewModel1.deleteAll1Photo(context)
                                    viewModel1.deleteStoryById(photoKey)}
                                "psecond" -> { viewModel2.deleteAll2Photo(context)
                                    viewModel1.deleteStoryById(photoKey)}
                                "pthird" -> {viewModel3.deleteAll3Photo(context)
                                    viewModel1.deleteStoryById(photoKey)}
                                "pfourth" -> {viewModel4.deleteAll4Photo(context)
                                    viewModel1.deleteStoryById(photoKey)}
                                "pfifth" -> {viewModel5.deleteAll5Photo(context)
                                    viewModel1.deleteStoryById(photoKey)}
                                "psixth" -> {
                                    viewModel6.deleteAll6Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pseventh" -> {
                                    viewModel7.deleteAll7Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peighth" -> {
                                    viewModel8.deleteAll8Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pninth" -> {
                                    viewModel9.deleteAll9Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "ptenth" -> {
                                    viewModel10.deleteAll10Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peleventh" -> {
                                    viewModel11.deleteAll11Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "ptwelfth" -> {
                                    viewModel12.deleteAll12Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pthirteenth" -> {
                                    viewModel13.deleteAll13Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfourteenth" -> {
                                    viewModel14.deleteAll14Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfifteenth" -> {
                                    viewModel15.deleteAll15Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "psixteenth" -> {
                                    viewModel16.deleteAll16Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pseventeenth" -> {
                                    viewModel17.deleteAll17Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peighteenth" -> {
                                    viewModel18.deleteAll18Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pnineteenth" -> {
                                    viewModel19.deleteAll19Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "ptwentieth" -> {
                                    viewModel20.deleteAll20Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "ptwentyfirst" -> {
                                    viewModel21.deleteAll21Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "ptwentysecond" -> {
                                    viewModel22.deleteAll22Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "ptwentythird" -> {
                                    viewModel23.deleteAll23Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "ptwentyfourth" -> {
                                    viewModel24.deleteAll24Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "ptwentyfifth" -> {
                                    viewModel25.deleteAll25Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "ptwentysixth" -> {
                                    viewModel26.deleteAll26Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "ptwentyseventh" -> {
                                    viewModel27.deleteAll27Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "ptwentyeighth" -> {
                                    viewModel28.deleteAll28Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "ptwentyninth" -> {
                                    viewModel29.deleteAll29Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pthirtieth" -> {
                                    viewModel30.deleteAll30Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pthirtyfirst" -> {
                                    viewModel31.deleteAll31Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pthirtysecond" -> {
                                    viewModel32.deleteAll32Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pthirtythird" -> {
                                    viewModel33.deleteAll33Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pthirtyfourth" -> {
                                    viewModel34.deleteAll34Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pthirtyfifth" -> {
                                    viewModel35.deleteAll35Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pthirtysixth" -> {
                                    viewModel36.deleteAll36Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pthirtyseventh" -> {
                                    viewModel37.deleteAll37Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pthirtyeighth" -> {
                                    viewModel38.deleteAll38Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pthirtyninth" -> {
                                    viewModel39.deleteAll39Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfourtieth" -> {
                                    viewModel40.deleteAll40Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfourtyfirst" -> {
                                    viewModel41.deleteAll41Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfourtysecond" -> {
                                    viewModel42.deleteAll42Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfourtythird" -> {
                                    viewModel43.deleteAll43Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfourtyfourth" -> {
                                    viewModel44.deleteAll44Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfourtyfifth" -> {
                                    viewModel45.deleteAll45Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfourtysixth" -> {
                                    viewModel46.deleteAll46Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfourtyseventh" -> {
                                    viewModel47.deleteAll47Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfourtyeighth" -> {
                                    viewModel48.deleteAll48Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfourtyninth" -> {
                                    viewModel49.deleteAll49Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfiftieth" -> {
                                    viewModel50.deleteAll50Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfiftyfirst" -> {
                                    viewModel51.deleteAll51Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfiftysecond" -> {
                                    viewModel52.deleteAll52Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfiftythird" -> {
                                    viewModel53.deleteAll53Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfiftyfourth" -> {
                                    viewModel54.deleteAll54Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfiftyfifth" -> {
                                    viewModel55.deleteAll55Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfiftysixth" -> {
                                    viewModel56.deleteAll56Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfiftyseventh" -> {
                                    viewModel57.deleteAll57Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfiftyeighth" -> {
                                    viewModel58.deleteAll58Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pfiftyninth" -> {
                                    viewModel59.deleteAll59Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "psixtieth" -> {
                                    viewModel60.deleteAll60Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "psixtyfirst" -> {
                                    viewModel61.deleteAll61Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "psixtysecond" -> {
                                    viewModel62.deleteAll62Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "psixtythird" -> {
                                    viewModel63.deleteAll63Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "psixtyfourth" -> {
                                    viewModel64.deleteAll64Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "psixtyfifth" -> {
                                    viewModel65.deleteAll65Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "psixtysixth" -> {
                                    viewModel66.deleteAll66Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "psixtyseventh" -> {
                                    viewModel67.deleteAll67Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "psixtyeighth" -> {
                                    viewModel68.deleteAll68Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "psixtyninth" -> {
                                    viewModel69.deleteAll69Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pseventieth" -> {
                                    viewModel70.deleteAll70Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pseventyfirst" -> {
                                    viewModel71.deleteAll71Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pseventysecond" -> {
                                    viewModel72.deleteAll72Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pseventythird" -> {
                                    viewModel73.deleteAll73Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pseventyfourth" -> {
                                    viewModel74.deleteAll74Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pseventyfifth" -> {
                                    viewModel75.deleteAll75Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pseventysixth" -> {
                                    viewModel76.deleteAll76Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pseventyseventh" -> {
                                    viewModel77.deleteAll77Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pseventyeighth" -> {
                                    viewModel78.deleteAll78Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pseventyninth" -> {
                                    viewModel79.deleteAll79Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peightieth" -> {
                                    viewModel80.deleteAll80Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peightyfirst" -> {
                                    viewModel81.deleteAll81Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peightysecond" -> {
                                    viewModel82.deleteAll82Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peightythird" -> {
                                    viewModel83.deleteAll83Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peightyfourth" -> {
                                    viewModel84.deleteAll84Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peightyfifth" -> {
                                    viewModel85.deleteAll85Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peightysixth" -> {
                                    viewModel86.deleteAll86Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peightyseventh" -> {
                                    viewModel87.deleteAll87Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peightyeighth" -> {
                                    viewModel88.deleteAll88Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "peightyninth" -> {
                                    viewModel89.deleteAll89Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pninetieth" -> {
                                    viewModel90.deleteAll90Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pninetyfirst" -> {
                                    viewModel91.deleteAll91Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pninetysecond" -> {
                                    viewModel92.deleteAll92Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pninetythird" -> {
                                    viewModel93.deleteAll93Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pninetyfourth" -> {
                                    viewModel94.deleteAll94Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pninetyfifth" -> {
                                    viewModel95.deleteAll95Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pninetysixth" -> {
                                    viewModel96.deleteAll96Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pninetyseventh" -> {
                                    viewModel97.deleteAll97Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pninetyeighth" -> {
                                    viewModel98.deleteAll98Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "pninetyninth" -> {
                                    viewModel99.deleteAll99Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
                                "phundredth" -> {
                                    viewModel100.deleteAll100Photo(context)
                                    viewModel1.deleteStoryById(photoKey)
                                }
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
@RequiresApi(Build.VERSION_CODES.O)
fun extractAndFormatDate(uriString: String): String {
    val regex = Regex("""JPEG_(\d{8})_""")
    val matchResult = regex.find(uriString)
    val dateString = matchResult?.groups?.get(1)?.value ?: return "Date not found"
    val date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyyMMdd"))
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    return date.format(formatter)
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
fun BigPhoto(modifier: Modifier, bigPhoto : Uri?, bigText : String, navController: NavController) {
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
            Row(
                modifier = Modifier.fillMaxWidth().padding(end = 8.dp, top = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Box(modifier = Modifier.clickable {
                    navController.navigate("ScreenBigPhoto/${Uri.encode(bigPhoto.toString())}")
                }
                    .size(42.dp)
                    .align(Alignment.CenterVertically)
                    .padding(4.dp)
                    .background(colorResource(id = R.color.transparentwhite), CircleShape
                    )){
                    Image(painter = painterResource(id = R.drawable.baseline_fullscreen_24), contentDescription = "delete", modifier = Modifier.size(35.dp))
                }
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
fun BottomButtons(modifier: Modifier, navController: NavController, deleteStory : () -> Unit, photoKey : String) {
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
                modifier = modifier.clickable {
                    if(photoKey == "pfirst"){
                        navController.navigate("KeyAddNewPhotoScreen/pfirst")
                    }
                    if(photoKey == "psecond"){
                        navController.navigate("KeyAddNewPhotoScreen/psecond")
                    }
                    if(photoKey == "pthird"){
                        navController.navigate("KeyAddNewPhotoScreen/pthird")
                    }
                    if(photoKey == "pfourth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfourth")
                    }
                    if(photoKey == "pfifth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfifth")
                    }
                    if(photoKey == "psixth"){
                        navController.navigate("KeyAddNewPhotoScreen/psixth")
                    }
                    if(photoKey == "pseventh"){
                        navController.navigate("KeyAddNewPhotoScreen/pseventh")
                    }
                    if(photoKey == "peighth"){
                        navController.navigate("KeyAddNewPhotoScreen/peighth")
                    }
                    if(photoKey == "pninth"){
                        navController.navigate("KeyAddNewPhotoScreen/pninth")
                    }
                    if(photoKey == "ptenth"){
                        navController.navigate("KeyAddNewPhotoScreen/ptenth")
                    }
                    if(photoKey == "peleventh"){
                        navController.navigate("KeyAddNewPhotoScreen/peleventh")
                    }
                    if(photoKey == "ptwelfth"){
                        navController.navigate("KeyAddNewPhotoScreen/ptwelfth")
                    }
                    if(photoKey == "pthirteenth"){
                        navController.navigate("KeyAddNewPhotoScreen/pthirteenth")
                    }
                    if(photoKey == "pfourteenth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfourteenth")
                    }
                    if(photoKey == "pfifteenth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfifteenth")
                    }
                    if(photoKey == "psixteenth"){
                        navController.navigate("KeyAddNewPhotoScreen/psixteenth")
                    }
                    if(photoKey == "pseventeenth"){
                        navController.navigate("KeyAddNewPhotoScreen/pseventeenth")
                    }
                    if(photoKey == "peighteenth"){
                        navController.navigate("KeyAddNewPhotoScreen/peighteenth")
                    }
                    if(photoKey == "pnineteenth"){
                        navController.navigate("KeyAddNewPhotoScreen/pnineteenth")
                    }
                    if(photoKey == "ptwentieth"){
                        navController.navigate("KeyAddNewPhotoScreen/ptwentieth")
                    }
                    if(photoKey == "ptwentyfirst"){
                        navController.navigate("KeyAddNewPhotoScreen/ptwentyfirst")
                    }
                    if(photoKey == "ptwentysecond"){
                        navController.navigate("KeyAddNewPhotoScreen/ptwentysecond")
                    }
                    if(photoKey == "ptwentythird"){
                        navController.navigate("KeyAddNewPhotoScreen/ptwentythird")
                    }
                    if(photoKey == "ptwentyfourth"){
                        navController.navigate("KeyAddNewPhotoScreen/ptwentyfourth")
                    }
                    if(photoKey == "ptwentyfifth"){
                        navController.navigate("KeyAddNewPhotoScreen/ptwentyfifth")
                    }
                    if(photoKey == "ptwentysixth"){
                        navController.navigate("KeyAddNewPhotoScreen/ptwentysixth")
                    }
                    if(photoKey == "ptwentyseventh"){
                        navController.navigate("KeyAddNewPhotoScreen/ptwentyseventh")
                    }
                    if(photoKey == "ptwentyeighth"){
                        navController.navigate("KeyAddNewPhotoScreen/ptwentyeighth")
                    }
                    if(photoKey == "ptwentyninth"){
                        navController.navigate("KeyAddNewPhotoScreen/ptwentyninth")
                    }
                    if(photoKey == "pthirtieth"){
                        navController.navigate("KeyAddNewPhotoScreen/pthirtieth")
                    }
                    if(photoKey == "pthirtyfirst"){
                        navController.navigate("KeyAddNewPhotoScreen/pthirtyfirst")
                    }
                    if(photoKey == "pthirtysecond"){
                        navController.navigate("KeyAddNewPhotoScreen/pthirtysecond")
                    }
                    if(photoKey == "pthirtythird"){
                        navController.navigate("KeyAddNewPhotoScreen/pthirtythird")
                    }
                    if(photoKey == "pthirtyfourth"){
                        navController.navigate("KeyAddNewPhotoScreen/pthirtyfourth")
                    }
                    if(photoKey == "pthirtyfifth"){
                        navController.navigate("KeyAddNewPhotoScreen/pthirtyfifth")
                    }
                    if(photoKey == "pthirtysixth"){
                        navController.navigate("KeyAddNewPhotoScreen/pthirtysixth")
                    }
                    if(photoKey == "pthirtyseventh"){
                        navController.navigate("KeyAddNewPhotoScreen/pthirtyseventh")
                    }
                    if(photoKey == "pthirtyeighth"){
                        navController.navigate("KeyAddNewPhotoScreen/pthirtyeighth")
                    }
                    if(photoKey == "pthirtyninth"){
                        navController.navigate("KeyAddNewPhotoScreen/pthirtyninth")
                    }
                    if(photoKey == "pfourtieth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfourtieth")
                    }
                    if(photoKey == "pfourtyfirst"){
                        navController.navigate("KeyAddNewPhotoScreen/pfourtyfirst")
                    }
                    if(photoKey == "pfourtysecond"){
                        navController.navigate("KeyAddNewPhotoScreen/pfourtysecond")
                    }
                    if(photoKey == "pfourtythird"){
                        navController.navigate("KeyAddNewPhotoScreen/pfourtythird")
                    }
                    if(photoKey == "pfourtyfourth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfourtyfourth")
                    }
                    if(photoKey == "pfourtyfifth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfourtyfifth")
                    }
                    if(photoKey == "pfourtysixth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfourtysixth")
                    }
                    if(photoKey == "pfourtyseventh"){
                        navController.navigate("KeyAddNewPhotoScreen/pfourtyseventh")
                    }
                    if(photoKey == "pfourtyeighth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfourtyeighth")
                    }
                    if(photoKey == "pfourtyninth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfourtyninth")
                    }
                    if(photoKey == "pfiftieth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfiftieth")
                    }
                    if(photoKey == "pfiftyfirst"){
                        navController.navigate("KeyAddNewPhotoScreen/pfiftyfirst")
                    }
                    if(photoKey == "pfiftysecond"){
                        navController.navigate("KeyAddNewPhotoScreen/pfiftysecond")
                    }
                    if(photoKey == "pfiftythird"){
                        navController.navigate("KeyAddNewPhotoScreen/pfiftythird")
                    }
                    if(photoKey == "pfiftyfourth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfiftyfourth")
                    }
                    if(photoKey == "pfiftyfifth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfiftyfifth")
                    }
                    if(photoKey == "pfiftysixth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfiftysixth")
                    }
                    if(photoKey == "pfiftyseventh"){
                        navController.navigate("KeyAddNewPhotoScreen/pfiftyseventh")
                    }
                    if(photoKey == "pfiftyeighth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfiftyeighth")
                    }
                    if(photoKey == "pfiftyninth"){
                        navController.navigate("KeyAddNewPhotoScreen/pfiftyninth")
                    }
                    if(photoKey == "psixtieth"){
                        navController.navigate("KeyAddNewPhotoScreen/psixtieth")
                    }
                    if(photoKey == "psixtyfirst"){
                        navController.navigate("KeyAddNewPhotoScreen/psixtyfirst")
                    }
                    if(photoKey == "psixtysecond"){
                        navController.navigate("KeyAddNewPhotoScreen/psixtysecond")
                    }
                    if(photoKey == "psixtythird"){
                        navController.navigate("KeyAddNewPhotoScreen/psixtythird")
                    }
                    if(photoKey == "psixtyfourth"){
                        navController.navigate("KeyAddNewPhotoScreen/psixtyfourth")
                    }
                    if(photoKey == "psixtyfifth"){
                        navController.navigate("KeyAddNewPhotoScreen/psixtyfifth")
                    }
                    if(photoKey == "psixtysixth"){
                        navController.navigate("KeyAddNewPhotoScreen/psixtysixth")
                    }
                    if(photoKey == "psixtyseventh"){
                        navController.navigate("KeyAddNewPhotoScreen/psixtyseventh")
                    }
                    if(photoKey == "psixtyeighth"){
                        navController.navigate("KeyAddNewPhotoScreen/psixtyeighth")
                    }
                    if(photoKey == "psixtyninth"){
                        navController.navigate("KeyAddNewPhotoScreen/psixtyninth")
                    }
                    if(photoKey == "pseventieth"){
                        navController.navigate("KeyAddNewPhotoScreen/pseventieth")
                    }
                    if(photoKey == "pseventyfirst"){
                        navController.navigate("KeyAddNewPhotoScreen/pseventyfirst")
                    }
                    if(photoKey == "pseventysecond"){
                        navController.navigate("KeyAddNewPhotoScreen/pseventysecond")
                    }
                    if(photoKey == "pseventythird"){
                        navController.navigate("KeyAddNewPhotoScreen/pseventythird")
                    }
                    if(photoKey == "pseventyfourth"){
                        navController.navigate("KeyAddNewPhotoScreen/pseventyfourth")
                    }
                    if(photoKey == "pseventyfifth"){
                        navController.navigate("KeyAddNewPhotoScreen/pseventyfifth")
                    }
                    if(photoKey == "pseventysixth"){
                        navController.navigate("KeyAddNewPhotoScreen/pseventysixth")
                    }
                    if(photoKey == "pseventyseventh"){
                        navController.navigate("KeyAddNewPhotoScreen/pseventyseventh")
                    }
                    if(photoKey == "pseventyeighth"){
                        navController.navigate("KeyAddNewPhotoScreen/pseventyeighth")
                    }
                    if(photoKey == "pseventyninth"){
                        navController.navigate("KeyAddNewPhotoScreen/pseventyninth")
                    }
                    if(photoKey == "peightieth"){
                        navController.navigate("KeyAddNewPhotoScreen/peightieth")
                    }
                    if(photoKey == "peightyfirst"){
                        navController.navigate("KeyAddNewPhotoScreen/peightyfirst")
                    }
                    if(photoKey == "peightysecond"){
                        navController.navigate("KeyAddNewPhotoScreen/peightysecond")
                    }
                    if(photoKey == "peightythird"){
                        navController.navigate("KeyAddNewPhotoScreen/peightythird")
                    }
                    if(photoKey == "peightyfourth"){
                        navController.navigate("KeyAddNewPhotoScreen/peightyfourth")
                    }
                    if(photoKey == "peightyfifth"){
                        navController.navigate("KeyAddNewPhotoScreen/peightyfifth")
                    }
                    if(photoKey == "peightysixth"){
                        navController.navigate("KeyAddNewPhotoScreen/peightysixth")
                    }
                    if(photoKey == "peightyseventh"){
                        navController.navigate("KeyAddNewPhotoScreen/peightyseventh")
                    }
                    if(photoKey == "peightyeighth"){
                        navController.navigate("KeyAddNewPhotoScreen/peightyeighth")
                    }
                    if(photoKey == "peightyninth"){
                        navController.navigate("KeyAddNewPhotoScreen/peightyninth")
                    }
                    if(photoKey == "pninetieth"){
                        navController.navigate("KeyAddNewPhotoScreen/pninetieth")
                    }
                    if(photoKey == "pninetyfirst"){
                        navController.navigate("KeyAddNewPhotoScreen/pninetyfirst")
                    }
                    if(photoKey == "pninetysecond"){
                        navController.navigate("KeyAddNewPhotoScreen/pninetysecond")
                    }
                    if(photoKey == "pninetythird"){
                        navController.navigate("KeyAddNewPhotoScreen/pninetythird")
                    }
                    if(photoKey == "pninetyfourth"){
                        navController.navigate("KeyAddNewPhotoScreen/pninetyfourth")
                    }
                    if(photoKey == "pninetyfifth"){
                        navController.navigate("KeyAddNewPhotoScreen/pninetyfifth")
                    }
                    if(photoKey == "pninetysixth"){
                        navController.navigate("KeyAddNewPhotoScreen/pninetysixth")
                    }
                    if(photoKey == "pninetyseventh"){
                        navController.navigate("KeyAddNewPhotoScreen/pninetyseventh")
                    }
                    if(photoKey == "pninetyeighth"){
                        navController.navigate("KeyAddNewPhotoScreen/pninetyeighth")
                    }
                    if(photoKey == "pninetyninth"){
                        navController.navigate("KeyAddNewPhotoScreen/pninetyninth")
                    }
                    if(photoKey == "phundredth"){
                        navController.navigate("KeyAddNewPhotoScreen/phundredth")
                    }
                }
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
