package com.merfilom.myphotostories.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.merfilom.myphotostories.R


@Composable
fun NewPhotoStoryScreen(navController: NavController){
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
        BigPhoto(Modifier.weight(1f))
        PhotoOfCurrentStory()
        BottomButtons(Modifier, navController)
    }

}
}

@Composable
fun BigPhoto(modifier: Modifier) {
    Card(
        modifier.fillMaxWidth().background(Color.Transparent).padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column (Modifier.fillMaxWidth().background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    colorResource(id = R.color.orange),
                    colorResource(id = R.color.white),
                    colorResource(id = R.color.orange)))),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = painterResource(id = R.drawable.photo), contentDescription = "bigphoto",
                Modifier.fillMaxWidth().weight(1f))
            Text(text = "text of description",
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally).padding(8.dp),
                fontSize = 24.sp,
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.Bold)
        }
    }
}
@Composable
fun PhotoOfCurrentStory() {
    Card(
        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.Transparent)
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        LazyRow(
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
        ){
            items(0) {  item ->
                Card(
                    Modifier
                        .width(140.dp)
                        .height(180.dp)
                        .padding(4.dp)
                        .background(Color.Transparent),
                    shape = RoundedCornerShape(8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
                ){
                    Column(
                        Modifier.background(brush = Brush.horizontalGradient(
                            colors = listOf(
                                colorResource(id = R.color.orange),
                                colorResource(id = R.color.white),
                                colorResource(id = R.color.orange)
                            )
                        ))
                    ) {
                        Image(painter = painterResource(id = R.drawable.photo), contentDescription = "item_photo")
                        Text(text = "add new photo",  Modifier.align(alignment = Alignment.CenterHorizontally),
                            fontSize = 14.sp,
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}
@Composable
fun BottomButtons(modifier: Modifier, navController: NavController) {
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
                horizontalAlignment = Alignment.CenterHorizontally
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
