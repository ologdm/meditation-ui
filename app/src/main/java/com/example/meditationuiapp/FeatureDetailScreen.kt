package com.example.meditationuiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meditationuiapp.ui.theme.AquaBlue
import com.example.meditationuiapp.ui.theme.DeepBlue
import com.example.meditationuiapp.ui.theme.TextWhite


// padding:
//  top 30
//  start 15 /end 15
//  related no
// vertical with spacers

// TODO 
//  proportions up to related ok!
//  feature internal proportion ok 
//  

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
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(layoutHorizPadding)
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        Text(
            text = "Best practice meditations",
            color = AquaBlue,
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodyMedium,
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

        // sez 4 descrizione
        FeatureSection(featureElements, onFeatureClick = { }, sectionTitle = "Related")

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
    modifier: Modifier = Modifier
) {
    Column(

    ) {
        Row() { }
        Text()
        Row() { }
    }
}

