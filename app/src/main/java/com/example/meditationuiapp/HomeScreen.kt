package com.example.meditationuiapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationuiapp.ui.theme.BlueViolet1
import com.example.meditationuiapp.ui.theme.ButtonBlue
import com.example.meditationuiapp.ui.theme.DarkerButtonBlue
import com.example.meditationuiapp.ui.theme.DeepBlue
import com.example.meditationuiapp.ui.theme.LightRed
import com.example.meditationuiapp.ui.theme.TextWhite

// TODO: note
//  per le grafiche sugli elementi:
//      - meditaz corrente - si puo fare con vari generatori immagini vettoriali
//      - featured - onde generate con compose


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            // 1
            GreetingSection()
            // 2
            ChipSection(
                listOf("SweetSleep", "Insomnia", "Depression")
            )
            // 3
            CurrentMeditation(text1 = "Daily Thought", text2 = "Meditation • 3-10 min")
        }
    }
}


// 1° sezione
@Composable
fun GreetingSection(
    name: String = "Dimitri"
) {

    Row(
        // voglio mettere gli elementi ai lati della riga
        horizontalArrangement = Arrangement.SpaceBetween, // metti elementi ai bordi
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
//            .background(ButtonBlue) // preview
            .padding(15.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = "Good morning, $name",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
//                fontStyle = // no
                style = MaterialTheme.typography.titleMedium,
                color = TextWhite
            )

            Text(
                text = "We wish you have a good day!",
                style = MaterialTheme.typography.bodyLarge,
                color = TextWhite
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = null,
            tint = Color.White, // colore standard
            // alternative
//            tint = AquaBlue, // colore da color
//            tint = MaterialTheme.colorScheme.primary, // colore da color
            modifier = Modifier.size(24.dp)
        )
    }
}


// 2° sezione
@Composable
fun ChipSection(
    chips: List<String>
) {
    // unico per il gruppo
    var selectedChipIndex by remember { mutableStateOf(0) }

    LazyRow(
        Modifier.background(Color.DarkGray)
    ) {
        items(chips.size) { it ->

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp) // esterno
                    .clickable { // azione al click
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(15.dp)) // rotondità
                    .background(
                        if (selectedChipIndex == it) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(15.dp)
            ) {
                Text(
                    chips[it],
                    color = TextWhite,
//                    fontStyle = ,// no
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 20.sp
                )
            }

        }
    }
}


// 2° sezione
@Composable
fun CurrentMeditation(
    color: Color = LightRed,
    text1: String,
    text2: String
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(Color.White)
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()

    ) {
        Column() {
            Text(
                text = text1,
                style = MaterialTheme.typography.titleMedium,
                color = TextWhite
            )
            Text(
                text = text2,
                style = MaterialTheme.typography.bodySmall,
                color = TextWhite
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)

        ) {

            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(14.dp)
            )
        }


    }
}

