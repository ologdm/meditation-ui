package com.example.meditationuiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.example.meditationuiapp.ui.theme.DeepBlue
import com.example.meditationuiapp.ui.theme.MeditationUiAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Colora status e nav bar con colore sfondo manualmente
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(DeepBlue.toArgb()),
            navigationBarStyle = SystemBarStyle.dark(DeepBlue.toArgb())
        )
        setContent {
            MeditationUiAppTheme {
                HomeScreen(
                    // Aggiunge solo il padding necessario
                    modifier = Modifier
                        .navigationBarsPadding()
                        .systemBarsPadding()
                )
            }
        }
    }
}