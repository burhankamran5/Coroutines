package com.naveed.coroutines.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.naveed.coroutines.Coroutines
import com.naveed.coroutines.MainScreen


@Composable
fun MainScreenComposable(navController: NavController) {
    Button(onClick = { navController.navigate(Coroutines.route) }) {
        Text(text = "Coroutines", fontSize = 20.sp, textAlign = TextAlign.Center)
    }
}