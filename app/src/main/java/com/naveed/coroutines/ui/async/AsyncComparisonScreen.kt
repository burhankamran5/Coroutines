package com.naveed.coroutines.ui.async

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AsyncComparisonScreen(
    viewModel: AsyncComparisonViewModel = hiltViewModel(),
) {
    val deferred1Value by viewModel.deferred1Flow.collectAsStateWithLifecycle()
    val deferred2Value by viewModel.deferred2Flow.collectAsStateWithLifecycle()
    val job1Value by viewModel.job1flow.collectAsStateWithLifecycle()
    val job2Value by viewModel.job2flow.collectAsStateWithLifecycle()


    var restart by remember {
        mutableStateOf(false)
    }


    key(restart) {
        var asyncsLaunched by remember { mutableStateOf(false) }
        var coroutinesLaunched by remember { mutableStateOf(false) }
        Column() {
            Button(
                colors = if (asyncsLaunched) ButtonDefaults.buttonColors(
                    contentColor = Color.White
                ) else ButtonDefaults.buttonColors(),
                modifier = Modifier.padding(horizontal = 16.dp),
                onClick = {
                    asyncsLaunched = true
                    viewModel.launchAsyncs()
                }
            ) {
                Text(if (asyncsLaunched) "Async Launched" else "Launch Async")
            }

            Button(
                colors = if (coroutinesLaunched) ButtonDefaults.buttonColors(
                    contentColor = Color.White
                ) else ButtonDefaults.buttonColors(),
                modifier = Modifier.padding(horizontal = 16.dp),
                onClick = {
                    coroutinesLaunched = true
                    viewModel.launchCoroutines()
                }
            ) {
                Text(if (coroutinesLaunched) "Coroutine Launched" else " Launch Coroutines!")
            }
            ProgressBarWithCancel(progress = deferred1Value, label = "Async # 1",
                onCancelClick = {
                    viewModel.cancelAsync1()
                })

            ProgressBarWithCancel(progress = deferred2Value,
                label = "Async # 2",
                onCancelClick = {
                    viewModel.cancelAsync2()
                })

            ProgressBarWithCancel(progress = job1Value,
                label = "Coroutine # 1",
                onCancelClick = {
                    viewModel.cancelCoroutine1()
                })

            ProgressBarWithCancel(progress = job2Value,
                label = "Coroutine # 2",
                onCancelClick = {
                    viewModel.cancelCoroutine2()
                })

            Button(
                modifier = Modifier
                    .padding(top = 16.dp),
                onClick = {
                    viewModel.clear()
                    restart = !restart
                }) {
                Text("Restart")
            }
        }
    }


}

@Composable
fun ProgressBar(
    modifier: Modifier = Modifier,
    progress: Float,
) {

    val progressAnimDuration = 300
    val progressAnimation by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(
            durationMillis = progressAnimDuration,
            easing = FastOutSlowInEasing
        ),
        label = ""
    )
    LinearProgressIndicator(
        progress = progressAnimation,
        modifier = modifier
            .padding(horizontal = 16.dp)
            .height(32.dp)
            .clip(RoundedCornerShape(16.dp))
    )
}

@Composable
fun ProgressBarWithCancel(
    modifier: Modifier = Modifier,
    progress: Float,
    label: String,
    onCancelClick: () -> Unit
) {

    var cancelled by remember { mutableStateOf(false) }
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            text = label,
            fontSize = 20.sp
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProgressBar(
                modifier = modifier
                    .weight(1.5f / 3f),
                progress = progress
            )

            Button(
                colors = if (cancelled) ButtonDefaults.buttonColors(
                    contentColor = Color.Black,

                    )
                else ButtonDefaults.buttonColors(),
                modifier = Modifier
                    .weight(1f / 3f)
                    .padding(horizontal = 16.dp),
                onClick = {
                    cancelled = true
                    onCancelClick()
                }) {
                Text(if (cancelled) "Cancelled" else "Cancel")
            }
        }
    }

}
