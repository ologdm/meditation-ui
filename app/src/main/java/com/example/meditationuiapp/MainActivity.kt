package com.example.meditationuiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.navigation3.ui.NavDisplay
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
                Scaffold(
                    containerColor = DeepBlue
                ) { padding ->
                    NavigationRoot(
                        modifier = Modifier
                            .padding(padding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}