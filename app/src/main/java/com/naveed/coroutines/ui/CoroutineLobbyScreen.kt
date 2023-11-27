package com.naveed.coroutines.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.naveed.coroutines.AsyncComparisonScreen
import com.naveed.coroutines.CoroutineScopeComparison
import com.naveed.coroutines.RememberCoroutineComparison


@Composable
fun CoroutineLobbyScreen(navController: NavController) {
    LobbyContent(
        onRememberCoroutineScopeClicked = { navController.navigate(RememberCoroutineComparison.route) },
        onAsyncComparisonClicked = { navController.navigate(AsyncComparisonScreen.route) },
        onCoroutineScopeClicked = { navController.navigate(CoroutineScopeComparison.route) }
    )
}

@Composable
fun LobbyContent(
    onRememberCoroutineScopeClicked: (() -> Unit)? = null,
    onAsyncComparisonClicked: (() -> Unit)? = null,
    onCoroutineScopeClicked: (() -> Unit)? = null,
) {
    Column() {
        Text(
            text = "Remember coroutine scope",
            modifier = Modifier
                .clickable {
                    onRememberCoroutineScopeClicked?.invoke()
                }
                .padding(24.dp)
        )
        Text(
            text = "Async comparison",
            modifier = Modifier
                .clickable {
                    onAsyncComparisonClicked?.invoke()
                }
                .padding(24.dp)
        )
        Text(
            text = "Coroutine scope",
            modifier = Modifier
                .clickable {
                    onCoroutineScopeClicked?.invoke()
                }
                .padding(24.dp)
        )
    }

}

