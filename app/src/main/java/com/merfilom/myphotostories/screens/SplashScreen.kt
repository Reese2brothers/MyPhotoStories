package com.merfilom.myphotostories.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.merfilom.myphotostories.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun SplashScreen(navController: NavController){
    var startAnimation by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val offsetY by animateDpAsState(
        targetValue = if (startAnimation) (-170).dp else 100.dp,
        animationSpec = tween(durationMillis = 4000), label = "offsetY"
    )
    val scalesX by animateFloatAsState(
        targetValue = if (startAnimation) 3f else 1f,
        animationSpec = tween(durationMillis = 4000), label = "scalesX"
    )
    val scalesY by animateFloatAsState(
        targetValue = if (startAnimation) 3f else 1f,
        animationSpec = tween(durationMillis = 4000), label = "scalesY"
    )
    val textscalesX by animateFloatAsState(
        targetValue = if (startAnimation) 5f else 1f,
        animationSpec = tween(durationMillis = 4000, delayMillis = 1000), label = "textscalesX",
    )
    val textscalesY by animateFloatAsState(
        targetValue = if (startAnimation) 5f else 1f,
        animationSpec = tween(durationMillis = 4000, delayMillis = 1000), label = "textscalesY"
    )
    val lentaoffsetY by animateDpAsState(
        targetValue = if (startAnimation) (-170).dp else 100.dp,
        animationSpec = tween(durationMillis = 4000), label = "lentaoffsetY"
    )
    val lentascalesX by animateFloatAsState(
        targetValue = if (startAnimation) 3f else 1f,
        animationSpec = tween(durationMillis = 4000), label = "lentascalesX"
    )
    val lentascalesY by animateFloatAsState(
        targetValue = if (startAnimation) 3f else 1f,
        animationSpec = tween(durationMillis = 4000), label = "lentascalesY"
    )

    // Запуск анимации при первом отображении
    LaunchedEffect(key1 = true) {
        startAnimation = true
        scope.launch {
            delay(5000)
            navController.navigate("MainScreen")
        }
    }

    Box(
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
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.fotik),
                contentDescription = null,
                modifier = Modifier
                    .offset(y = offsetY)
                    .graphicsLayer {
                        scaleX = scalesX
                        scaleY = scalesY
                    }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "P&V stories",
                modifier = Modifier
                    .graphicsLayer {
                        scaleX = textscalesX
                        scaleY = textscalesY
                    },
                fontSize = 12.sp,
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.plenka),
                contentDescription = null,
                modifier = Modifier
                    .offset(y = -lentaoffsetY)
                    .graphicsLayer {
                        scaleX = lentascalesX
                        scaleY = lentascalesY
                    }
            )
        }
    }
}