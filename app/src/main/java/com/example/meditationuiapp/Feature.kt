package com.example.meditationuiapp

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val id: Int,
    val title: String, // Sleep meditation
    @DrawableRes val iconId: Int,
    // 3 colori per fare l'immagine custom
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color,

    // detail category
    val subtitle: String, // Best practice meditations
    val category : String, // Sleep music
    val time : String, // 45 min
    val description: String, // Ease the mind into a restful night's sleep with these deep, amblent tones
    val savedQty : Int, // 12,542
    val listenQty : Int, // 43,453
)