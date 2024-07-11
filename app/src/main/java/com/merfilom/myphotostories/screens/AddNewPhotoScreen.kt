package com.merfilom.myphotostories.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.merfilom.myphotostories.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AddNewPhotoScreen(){
    val currentText = rememberSaveable { mutableStateOf("") }

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
                    Image(painter = painterResource(id = R.drawable.photo), contentDescription = "newphoto",
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
                    Icon(imageVector = Icons.Default.Clear, contentDescription = "clear")
                },
                placeholder = {
                    Text(text = "Enter a description of the photo...", fontSize = 14.sp,)
                }
                )
            MovePanel()
        }
    }
}

@Composable
fun MovePanel() {
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
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.baseline_camera_24), contentDescription = "camera", modifier = Modifier.size(30.dp))
                Text(text = "camera",  Modifier.align(alignment = Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Bold)
            }
            Column (
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(imageVector = Icons.Default.Add, contentDescription = "add", modifier = Modifier.size(30.dp))
                Text(text = "add photo",  Modifier.align(alignment = Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Bold)
            }
            Column (
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
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
                horizontalAlignment = Alignment.CenterHorizontally
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
