package com.merfilom.myphotostories.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import com.merfilom.myphotostories.R

@Preview(showBackground = true)
@Composable
fun MainScreen(){
    val listState = rememberLazyListState()

    Box(
        Modifier.fillMaxSize()
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row (Modifier.fillMaxWidth().height(70.dp).background(
                        brush = Brush.verticalGradient(colors = listOf(
                                colorResource(id = R.color.orange),
                                colorResource(id = R.color.white)))),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Card(
                    Modifier
                        .background(Color.Transparent)
                        .padding(start = 8.dp),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(width = 2.dp, color = Color.Black)
                ) {
                    Row(
                        Modifier.background(Color.White),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = painterResource(id = R.drawable.photo), contentDescription = "label",
                            modifier = Modifier.size(60.dp))
                        Text(text = "Your Stories",  Modifier.padding(end = 8.dp),
                            fontSize = 24.sp,
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Bold)
                    }
                }
                Row (
                    modifier = Modifier.padding(end = 8.dp, bottom = 8.dp).wrapContentWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(painter = painterResource(id = R.drawable.baseline_menu_24), contentDescription = "menu",
                            modifier = Modifier.size(35.dp))
//                        Text(text = "menu",  Modifier.padding(end = 8.dp),
//                            fontSize = 10.sp,
//                            color = colorResource(id = R.color.black),
//                            fontWeight = FontWeight.Bold)
                    }
                    Column (
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Image(painter = painterResource(id = R.drawable.baseline_output_24), contentDescription = "exit",
                        modifier = Modifier.size(30.dp))
//                        Text(text = "exit",  Modifier.padding(end = 8.dp),
//                            fontSize = 10.sp,
//                            color = colorResource(id = R.color.black),
//                            fontWeight = FontWeight.Bold)
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
                        .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 4.dp)
                        .background(Color.Transparent),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Box (
                        Modifier
                            .wrapContentWidth()
                            .background(
                                brush = Brush.radialGradient(
                                    colors = listOf(
                                        colorResource(id = R.color.white),
                                        colorResource(id = R.color.orange)
                                    ),
                                    radius = 1000f
                                )
                            )){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(65.dp)
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(
                                                colorResource(id = R.color.white),
                                                colorResource(id = R.color.orange)
                                            )
                                        )
                                    ),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ){
                                Image(painter = painterResource(id = R.drawable.fotik), contentDescription = "photo",
                                    Modifier
                                        .size(55.dp)
                                        .padding(top = 8.dp))
                                Text("Your\n      Photo\n           Stories",
                                    Modifier.padding(top = 4.dp, end = 8.dp, bottom = 4.dp),
                                    fontSize = 16.sp,
                                    color = colorResource(id = R.color.black),
                                    fontWeight = FontWeight.Bold,
                                   )
                            }
                        LazyColumn(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(), state = listState) {
                            items(0) {  item ->
                                Card(
                                    Modifier
                                        .fillMaxWidth()
                                        .height(100.dp)
                                        .padding(8.dp)
                                        .background(Color.Transparent),
                                    shape = RoundedCornerShape(8.dp)
                                ){

                                }
                            }
                        }
                    }
                }
                Card(
                    Modifier
                        .weight(1f)
                        .padding(start = 4.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
                        .background(Color.Transparent),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Box (Modifier.background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                colorResource(id = R.color.white),
                                colorResource(id = R.color.orange)
                            ),
                            radius = 1000f
                        )
                    )){
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(65.dp)
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(
                                                colorResource(id = R.color.white),
                                                colorResource(id = R.color.orange)
                                            )
                                        )
                                    ),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ){
                                Image(painter = painterResource(id = R.drawable.plenka), contentDescription = "video",
                                    Modifier
                                        .size(60.dp)
                                        .padding(top = 4.dp))
                                Text("Your\n      Video\n           Stories",
                                    Modifier.padding(top = 4.dp, end = 8.dp, bottom = 4.dp),
                                    fontSize = 16.sp,
                                    color = colorResource(id = R.color.black),
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        LazyColumn(modifier = Modifier.fillMaxSize(), state = listState) {
                            items(0) {  item ->
                                Card(
                                    Modifier
                                        .fillMaxWidth()
                                        .height(100.dp)
                                        .padding(8.dp)
                                        .background(Color.Transparent),
                                    shape = RoundedCornerShape(8.dp)
                                ){

                                }
                            }
                        }
                    }
                }
            }
            Row (
                Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                colorResource(id = R.color.white),
                                colorResource(id = R.color.orange)
                            )
                        )
                    )
            ){

            }
        }
    }
}