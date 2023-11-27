package com.naveed.coroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.naveed.coroutines.ui.async.AsyncComparisonScreen
import com.naveed.coroutines.ui.CoroutineLobbyScreen
import com.naveed.coroutines.ui.CoroutineScopeScreen
import com.naveed.coroutines.ui.MainScreenComposable
import com.naveed.coroutines.ui.RememberCoroutineScope
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = MainScreen.route,
                    modifier = Modifier,
                    enterTransition = {
                        EnterTransition.None
                    }, exitTransition = {
                        ExitTransition.None
                    }) {
                    setUpNavigation(navController)
                }
        }
    }


    fun NavGraphBuilder.setUpNavigation(navController: NavHostController) {

        composable(route = MainScreen.route) {
            MainScreenComposable(navController)
        }
        composable(route = Coroutines.route) {
            CoroutineLobbyScreen(navController)
        }
        composable(route = AsyncComparisonScreen.route){
        AsyncComparisonScreen()
        }
        composable(route = CoroutineScopeComparison.route){
            CoroutineScopeScreen(navController)
        }
        composable(route = RememberCoroutineComparison.route){
           RememberCoroutineScope(navController)
        }

    }
}
