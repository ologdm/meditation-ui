package com.example.meditationuiapp

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meditationuiapp.ui.theme.AquaBlue
import com.example.meditationuiapp.ui.theme.DeepBlue
import com.example.meditationuiapp.ui.theme.TextWhite
import com.example.meditationuiapp.ui.theme.Typography


// padding:
//  top 30
//  start 15 /end 15
//  related no
// vertical with spacers

// TODO 
//  proportions up to related ok!
//  feature internal proportion ok 
//  info section
// refacor elementi

@Preview
@Composable
fun detailPreview(modifier: Modifier = Modifier) {
    FeatureDetailScreen(id = 1, modifier = modifier)
}


@Composable
fun FeatureDetailScreen(
    id: Int,
    // todo viewmodel ok
    viewModel: FeatureDetailViewModel = viewModel {
        FeatureDetailViewModel(id)
    },
    modifier: Modifier = Modifier
) {
    val layoutHorizPadding = PaddingValues(horizontal = 15.dp)

    val state = viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DeepBlue)
            .padding(top = 10.dp)
    ) {

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        //sez  1
        TopSection(
            modifier = Modifier
                .padding(
                    start = 12.dp, // arrow alignment
                    end = 15.dp // star alignment
                )
        )

        Spacer(modifier = Modifier.padding(bottom = 40.dp))

        // sez 2
        Text(
            text = state.value.title,
            color = TextWhite,
            fontSize = 30.sp,
//            style = typography.titleLarge,
            modifier = Modifier.padding(layoutHorizPadding)
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        Text(
            text = "Best practice meditations",
            color = AquaBlue,
            fontSize = 16.sp,
//            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(layoutHorizPadding)
        )

        Spacer(modifier = Modifier.padding(vertical = 10.dp))


        // sez 3
        FeatureItem(
            featureElements[0],
            aspectRatio = 1.4f, // pers
            showTitle = false,
            externalContainerPadding = PaddingValues(0.dp),
            internalContainerPadding = PaddingValues(
                vertical = 24.dp,
                horizontal = 24.dp
            ), // custom detail
            buttonPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp),
            buttonTextSize = 20.sp,
            iconSize = 24.dp,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .padding(layoutHorizPadding)
        )

        Spacer(modifier = Modifier.padding(bottom = 20.dp))

        // sez 4 descrizione
        InfoDetailSection(
            modifier = Modifier.padding(layoutHorizPadding),
            feature = state.value
        )

        Spacer(modifier = Modifier.padding(vertical = 18.dp))

        HorizontalDivider(
            color = AquaBlue,
            modifier = Modifier.padding(layoutHorizPadding)
        )

        Spacer(modifier = Modifier.padding(vertical = 18.dp))

        // sez 5
        FeaturesSection(featureElements, onFeatureClick = { }, sectionTitle = "Related")

    }

}

// --------------------------------------------------------------------------
@Composable
fun TopSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_button),
            contentDescription = null,
            tint = AquaBlue,
            modifier = Modifier.size(28.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_star_temporary),
            contentDescription = null,
            tint = TextWhite,
        )
    }
}


@Composable
fun InfoDetailSection(
    modifier: Modifier = Modifier,
    feature: Feature
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
//            .background(Color.White)
    ) {

        Text(
            text = "${feature.category}   •   ${feature.time} min",
//            fontSize = 14.sp,
            color = AquaBlue,
            style = Typography.bodyMedium
        )

        Spacer(Modifier.padding(bottom = 12.dp))

        Text(
            text = feature.description,
//            fontSize = 16.sp,
            color = AquaBlue,
            style = Typography.bodyMedium
        )

        Spacer(Modifier.padding(bottom = 20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
//            Text(
//                text = "X XXXXXX ",
//                fontSize = 16.sp,
//                color = AquaBlue
//            )
//
//            // alternative to Arrangement.SpaceBetween
////            Spacer(modifier = Modifier.weight(1f))
//
//            Text(
//                text = "X XXXXXX ",
//                fontSize = 16.sp,
//                color = AquaBlue
//            )

            // saved
            QuantityContainer(
                painterResource = R.drawable.ic_star_temporary,
                iconSize = 22.dp,
                qty = feature.savedQty,
                typeText = "Saved",
            )

            // listening
            QuantityContainer(
                painterResource = R.drawable.ic_headphone,
                iconSize = 18.dp,
                qty = feature.listenQty,
                typeText = "Listening",
            )
        }
    }
}


@Composable
fun QuantityContainer(
    modifier: Modifier = Modifier,
//    feature: Feature,
    painterResource: Int,
    iconSize: Dp,
    qty: Int,
    typeText: String,
    color: Color = TextWhite
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = painterResource),
            contentDescription = null,
            tint = color,
            modifier = Modifier
                .padding(end = 12.dp)
                .size(iconSize)
        )

        Text(
            text = "$qty $typeText",
//            fontSize = 14.sp,
            color = color,
            style = Typography.bodySmall.copy(fontSize = 16.sp)
        )
    }
}


// Notes Arrangement:
//  SpaceAround → spazio attorno agli elementi (anche ai bordi)
//  SpaceBetween → primo a sinistra, ultimo a destra
//  SpaceEvenly → spazio uguale ovunque

