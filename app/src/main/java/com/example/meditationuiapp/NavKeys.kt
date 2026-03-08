package com.example.meditationuiapp

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Root : NavKey {

    @Serializable
    data object HomePage : Root

    @Serializable
    data class FeatureDetail(val id: Int) : Root
}
