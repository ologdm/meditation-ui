package com.example.meditationuiapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay


// only for HomePage, FeatureDetail
// simple backstack with 2 screens

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier // passare il modifier a tutti i figli nel navDisplay
) {
    // 1. backstack
//    val backStack = rememberNavBackStack(Root.HomePage, Root.FeatureDetail(1))
    val backStack = rememberNavBackStack(Root.HomePage)

    // 2. navDisplay
    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) {
                backStack.removeLastOrNull()
            } // TODO !! doesen't work, click back still exits from app
        },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(), // mantiene lo stato dei composable tra navigazioni
            rememberViewModelStoreNavEntryDecorator() // senza il viewmodel non ha scope l'entry ma l'activity
        ),
        entryProvider = entryProvider {
            entry<Root.HomePage> { navKey ->
                HomeScreen(modifier = modifier, onFeatureClick = { featureId ->
                    backStack.add(Root.FeatureDetail(id = featureId))
                })
            }

            entry<Root.FeatureDetail> { navKey ->
                // TODO: ok
                FeatureDetailScreen(
                    modifier = modifier,
                    id = navKey.id,
                    onBackClick = { backStack.removeLastOrNull() }
                ) // passa id al viewmodel Detail
            }
        }
    )
}

