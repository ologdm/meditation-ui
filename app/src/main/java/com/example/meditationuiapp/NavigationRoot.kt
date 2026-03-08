package com.example.meditationuiapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay


// only for HomePage, FeatureDetail
// simple backstack with 2 screens

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier // passare il modifier a tutti i figli nel navDisplay
) {
    // 1. backstack
    val backStack = rememberNavBackStack(Root.HomePage)

    // 2. navDisplay
    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) backStack.removeLastOrNull()
        },
//        entryDecorators = TODO
        entryProvider = entryProvider {
            entry<Root.HomePage> { navKey ->
                HomeScreen(modifier = modifier, onFeatureClick = { featureId ->
                    backStack.add(Root.FeatureDetail(id = featureId)) // TODO
                })
            }

            entry<Root.FeatureDetail> { navKey ->
                // TODO:
                FeatureDetailScreen(navKey.id) // passa id al viewmodel Detail
            }
        }
    )
}

