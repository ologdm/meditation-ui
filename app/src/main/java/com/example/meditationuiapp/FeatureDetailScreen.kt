package com.example.meditationuiapp

import android.graphics.drawable.Icon
import android.util.Log.d
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontWeight
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
import java.util.Locale


// padding:
//  top 30
//  start 15 /end 15
//  related no padding
// vertical with spacers

@Preview
@Composable
fun detailPreview(modifier: Modifier = Modifier) {
    FeatureDetailScreen(id = 1, modifier = modifier, onBackClick = {})
}


@Composable
fun FeatureDetailScreen(
    id: Int,
    // todo viewmodel ok
    viewModel: FeatureDetailViewModel = viewModel {
        FeatureDetailViewModel(id)
    },
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val layoutHorizPadding = PaddingValues(horizontal = 15.dp)

    val state = viewModel.state.collectAsStateWithLifecycle()

//    val scrollState = rememberScrollState() // corretto?
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DeepBlue)
            .padding(top = 10.dp)
//            .verticalScroll(scrollState) // TODO
    ) {

        Spacer(Modifier.height(10.dp))

        //sez  1
        TopSection(
            modifier = Modifier
                .padding(
                    start = 12.dp, // arrow alignment
                    end = 15.dp // star alignment
                ),
            onBackClick = {
                onBackClick()
            }
        )

        Spacer(Modifier.height(40.dp))

        // sez 2
        Text(
            text = state.value.title,
            style = typography.titleLarge,
            modifier = Modifier.padding(layoutHorizPadding)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Best practice meditations",
            style = typography.bodyLarge,
            fontWeight = FontWeight.SemiBold, // custom
            modifier = Modifier.padding(layoutHorizPadding)
        )

        Spacer(Modifier.height(20.dp))

        // sez 3
        FeatureItem(
            feature = state.value,
            aspectRatio = 1.45f, // custom
            showTitle = false,
            externalContainerPadding = PaddingValues(0.dp),
            internalContainerPadding = PaddingValues(
                vertical = 24.dp,
                horizontal = 24.dp
            ),
            buttonPadding = PaddingValues(vertical = 18.dp, horizontal = 16.dp),
            buttonTextSize = 16.sp,
            iconSize = 24.dp,
            modifier = Modifier
                .padding(vertical = 8.dp)
                .padding(layoutHorizPadding)
        )

        Spacer(Modifier.height(25.dp))

        // sez 4
        InfoDetailSection(
            modifier = Modifier.padding(layoutHorizPadding),
            feature = state.value
        )

        Spacer(modifier = Modifier.height(40.dp))

        HorizontalDivider(
            color = Color.DarkGray,
            modifier = Modifier.padding(layoutHorizPadding)
        )

        Spacer(Modifier.height(40.dp))

        // sez 5
        FeaturesSection(relatedElements, onFeatureClick = { }, sectionTitle = "Related")

    }
}


// --------------------------------------------------------------------------
@Composable
fun TopSection(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
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
            tint = TextWhite,
            modifier = Modifier
                .size(28.dp)
                .clickable {
                    onBackClick()
                }
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = null,
            tint = TextWhite,
            modifier = Modifier
                .size(20.dp)
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
            style = typography.bodyMedium
        )

        Spacer(Modifier.height(20.dp))

        Text(
            text = feature.description,
            style = Typography.bodyLarge,
            lineHeight = 24.sp // custom
        )

        Spacer(Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // saved
            QuantityContainer(
                painterResource = R.drawable.ic_star,
                iconSize = 20.dp,
                qty = feature.savedQty,
                typeText = "Saved",
            )

            // alternative to Arrangement.SpaceBetween
////            Spacer(modifier = Modifier.weight(1f))

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
                .padding(end = 16.dp)
                .size(iconSize)
        )

        Text(
            text = "${String.format(Locale.US, "%,d", qty)} $typeText",
            style = typography.bodyMedium,
            color = color,
        )
    }
}


// Notes Arrangement:
//  SpaceAround → spazio attorno agli elementi (anche ai bordi)
//  SpaceBetween → primo a sinistra, ultimo a destra
//  SpaceEvenly → spazio uguale ovunque

