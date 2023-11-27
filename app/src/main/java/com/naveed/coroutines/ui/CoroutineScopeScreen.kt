package com.naveed.coroutines.ui

import androidx.activity.compose.BackHandler
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.math.log

@Composable
fun CoroutineScopeScreen(navController: NavController){
Text(text = "Coroutine Scope Screen", fontSize = 20.sp)
    BackHandler {
        navController.popBackStack()
    }
}