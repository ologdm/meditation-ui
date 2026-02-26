package com.example.meditationuiapp

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    // 3 colori per fare l'immagine custom
    val lightColor : Color,
    val mediumColor : Color,
    val darkColor : Color
)