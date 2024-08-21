package com.merfilom.myphotostories

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.merfilom.myphotostories.screens.AddNewPhotoScreen
import com.merfilom.myphotostories.screens.EmptyNewPhotoStoryScreen
import com.merfilom.myphotostories.screens.MainScreen
import com.merfilom.myphotostories.screens.MenuScreen
import com.merfilom.myphotostories.screens.NewPhotoStoryScreen
import com.merfilom.myphotostories.screens.NewVideoStoryScreen
import com.merfilom.myphotostories.screens.SplashScreen

@Composable
fun NavGraphNavigate(context : Context, navController: NavHostController) {

    NavHost(navController = navController, startDestination = "SplashScreen"){
        composable("SplashScreen"){
            SplashScreen(navController = navController)
        }
        composable("MainScreen"){
            MainScreen(context, navController = navController)
        }
        composable("NewPhotoStoryScreen"){
            NewPhotoStoryScreen(navController = navController)
        }
        composable("NewVideoStoryScreen"){
            NewVideoStoryScreen(navController = navController)
        }
        composable("MenuScreen"){
            MenuScreen(navController = navController)
        }
        composable("AddNewPhotoScreen"){
            AddNewPhotoScreen(navController = navController)
        }
        composable("EmptyNewPhotoStoryScreen") { EmptyNewPhotoStoryScreen(navController) }
    }
}
