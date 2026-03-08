package com.example.meditationuiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun FeatureDetailScreen(
    id: Int,
    // todo viewmodel ok
    viewModel: FeatureDetailViewModel = viewModel {
        FeatureDetailViewModel(id)
    },
    modifier: Modifier = Modifier
) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue.copy(alpha = 0.3f)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Detail Screen is ${state.value.title}")
    }
}
