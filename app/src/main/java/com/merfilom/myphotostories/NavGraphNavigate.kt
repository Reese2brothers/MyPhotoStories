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
import com.merfilom.myphotostories.screens.KeyAddNewPhotoScreen
import com.merfilom.myphotostories.screens.MainScreen
import com.merfilom.myphotostories.screens.MenuScreen
import com.merfilom.myphotostories.screens.NewPhotoStoryScreen
import com.merfilom.myphotostories.screens.NewVideoStoryScreen
import com.merfilom.myphotostories.screens.ScreenBigPhoto
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
        composable("NewPhotoStoryScreen/{photoKey}",
            arguments = listOf(navArgument("photoKey") { type = NavType.StringType })
        ) { backStackEntry ->
            val photoKey = backStackEntry.arguments?.getString("photoKey") ?: ""
            NewPhotoStoryScreen(navController, photoKey)
        }
        composable("ScreenBigPhoto/{biggerPhoto}",
            arguments = listOf(navArgument("biggerPhoto") { type = NavType.StringType })
        ) { backStackEntry ->
            val biggerPhoto = backStackEntry.arguments?.getString("biggerPhoto") ?: ""
            ScreenBigPhoto(navController, biggerPhoto, context)
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
        composable("KeyAddNewPhotoScreen/{keyPhoto}",
            arguments = listOf(navArgument("keyPhoto") { type = NavType.StringType })
        ) { backStackEntry ->
            val keyPhoto = backStackEntry.arguments?.getString("keyPhoto") ?: ""
            KeyAddNewPhotoScreen(navController, keyPhoto)
        }
        composable("EmptyNewPhotoStoryScreen") { EmptyNewPhotoStoryScreen(navController) }
    }
}
