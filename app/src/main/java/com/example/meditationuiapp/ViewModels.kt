package com.example.meditationuiapp

import androidx.lifecycle.ViewModel
import com.example.meditationuiapp.ui.theme.Beige1
import com.example.meditationuiapp.ui.theme.Beige2
import com.example.meditationuiapp.ui.theme.Beige3
import com.example.meditationuiapp.ui.theme.BlueViolet1
import com.example.meditationuiapp.ui.theme.BlueViolet2
import com.example.meditationuiapp.ui.theme.BlueViolet3
import com.example.meditationuiapp.ui.theme.LightGreen1
import com.example.meditationuiapp.ui.theme.LightGreen2
import com.example.meditationuiapp.ui.theme.LightGreen3
import com.example.meditationuiapp.ui.theme.OrangeYellow1
import com.example.meditationuiapp.ui.theme.OrangeYellow2
import com.example.meditationuiapp.ui.theme.OrangeYellow3
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow



class HomeScreenViewModel : ViewModel() {
    private val _features = MutableStateFlow(featureElements)
    val features = _features.asStateFlow()

}


class FeatureDetailViewModel(
    featureId: Int
) : ViewModel() {
    val features = featureElements

    private val _state = MutableStateFlow(features.first { it.id == featureId })
    val state = _state.asStateFlow()

    //
    fun getRelatedFeatures() = featureElements.shuffled()
}




// ------------------------------------------------------------------------------------------------------
val featureElements = listOf(
    Feature(
        id = 1,
        title = "Sleep Meditation",
        subtitle = "Best practice meditations",
        iconId = R.drawable.ic_headphone,
        lightColor = BlueViolet1,
        mediumColor = BlueViolet2,
        darkColor = BlueViolet3,
        category = "Sleep Music",
        time = "45",
        description = "Ease the mind into a restful night's sleep with these deep, ambient tones.",
        savedQty = 12542,
        listenQty = 43453
    ),
    Feature(
        id = 2,
        title = "Tips for Sleeping",
        subtitle = "Healthy sleep habits",
        iconId = R.drawable.ic_videocam,
        lightColor = LightGreen1,
        mediumColor = LightGreen2,
        darkColor = LightGreen3,
        category = "Sleep Guide",
        time = "12",
        description = "Practical techniques and habits to help you fall asleep faster and improve sleep quality.",
        savedQty = 8543,
        listenQty = 21432
    ),
    Feature(
        id = 3,
        title = "Night Island",
        subtitle = "Peaceful island sounds" ,
        iconId = R.drawable.ic_headphone,
        lightColor = OrangeYellow1,
        mediumColor = OrangeYellow2,
        darkColor = OrangeYellow3,
        category = "Nature Sounds",
        time = "30",
        description = "Relax with gentle waves, soft wind, and distant night sounds from a peaceful island.",
        savedQty = 9631,
        listenQty = 28764
    ),
    Feature(
        id = 4,
        title = "Calming Sounds",
        subtitle = "Relaxing ambient audio",
        iconId = R.drawable.ic_headphone,
        lightColor = Beige1,
        mediumColor = Beige2,
        darkColor = Beige3,
        category = "Relaxing Audio",
        time = "50",
        description = "A collection of soothing sounds designed to reduce stress and calm the mind.",
        savedQty = 14221,
        listenQty = 51234
    )
)


