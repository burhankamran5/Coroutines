package com.naveed.coroutines.ui

import androidx.activity.compose.BackHandler
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun RememberCoroutineScope(navController: NavController){
    Text(text = " Remember Coroutine Scope Screen", fontSize = 20.sp)
}