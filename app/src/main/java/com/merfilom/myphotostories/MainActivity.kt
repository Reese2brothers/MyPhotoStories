package com.merfilom.myphotostories

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.rememberNavController
import com.merfilom.myphotostories.screens.MainScreen
import com.merfilom.myphotostories.screens.SplashScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenStatusBar(colorResource(id = R.color.black))
            val navController = rememberNavController()
            NavGraphNavigate(this, navController)
        }
    }
}




