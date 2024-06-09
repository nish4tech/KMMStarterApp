package com.ip.mobile.android.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    onNextClick: () -> Unit
) {
    val viewModel = koinViewModel<RocketLaunchViewModel>()
    val launches by viewModel.launchState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when(launches) {
            is RocketLaunchScreenState.Success -> {
                Text(text = "Data came -> ${(launches as RocketLaunchScreenState.Success).data.size}")
            }
            is RocketLaunchScreenState.Error -> {
                Text("Error")
            }
            else -> {
                Text("Loading")
            }
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = onNextClick) {
            Text("Next")
        }
    }
    //App()
}