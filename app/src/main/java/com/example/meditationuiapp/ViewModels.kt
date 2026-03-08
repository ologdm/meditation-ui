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
}


//data class FeatureDetailState(
//    val feature: Feature
//)


// ----------------------------------------
val featureElements = listOf(
    Feature(
        id = 1,
        title = "Sleep Meditation",
        iconId = R.drawable.ic_headphone,
        lightColor = BlueViolet1,
        mediumColor = BlueViolet2,
        darkColor = BlueViolet3
    ),
    Feature(
        id = 2,
        title = "Tips for sleeping",
        iconId = R.drawable.ic_videocam,
        lightColor = LightGreen1,
        mediumColor = LightGreen2,
        darkColor = LightGreen3
    ),
    Feature(
        id = 3,
        title = "Night island",
        iconId = R.drawable.ic_headphone,
        lightColor = OrangeYellow1,
        mediumColor = OrangeYellow2,
        darkColor = OrangeYellow3
    ),
    Feature(
        id = 4,
        title = "Calming Sounds",
        iconId = R.drawable.ic_headphone,
        lightColor = Beige1,
        mediumColor = Beige2,
        darkColor = Beige3
    )
)


