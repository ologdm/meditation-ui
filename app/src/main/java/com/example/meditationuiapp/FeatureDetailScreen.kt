package com.example.meditationuiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meditationuiapp.ui.theme.AquaBlue
import com.example.meditationuiapp.ui.theme.DeepBlue
import com.example.meditationuiapp.ui.theme.TextWhite


@Composable
fun FeatureDetailScreen(
    id: Int,
    // todo viewmodel ok
    viewModel: FeatureDetailViewModel = viewModel {
        FeatureDetailViewModel(id)
    },
    modifier: Modifier = Modifier
) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
//                .padding(top = 20.dp)
//                .background(Color.DarkGray),

        ) {
            TopSection()

            Text(
                text = state.value.title,
                color = TextWhite,
                fontSize = 30.sp,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Text(
                text = "Best practice meditations",
                color = AquaBlue,
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodyMedium,
            )

            Spacer(modifier = Modifier.padding(vertical = 10.dp))

            FeatureItem(
                featureElements[0],
                aspectRatio = 1.35f,
                modifier = Modifier.padding(vertical = 20.dp)
            )

        }


    }
}

@Preview
@Composable
fun detailPreview(modifier: Modifier = Modifier) {
    FeatureDetailScreen(id = 1, modifier = modifier)
}


@Composable
fun TopSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
//            .background(Color.Red)
            .padding(vertical = 30.dp)
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_button),
            contentDescription = null,
            tint = TextWhite,
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
fun RelatedSection(modifier: Modifier = Modifier) {
    // TODO:  
}
