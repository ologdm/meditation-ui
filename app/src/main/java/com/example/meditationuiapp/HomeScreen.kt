package com.example.meditationuiapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationuiapp.ui.theme.AquaBlue
import com.example.meditationuiapp.ui.theme.Beige1
import com.example.meditationuiapp.ui.theme.Beige2
import com.example.meditationuiapp.ui.theme.Beige3
import com.example.meditationuiapp.ui.theme.BlueViolet1
import com.example.meditationuiapp.ui.theme.BlueViolet2
import com.example.meditationuiapp.ui.theme.BlueViolet3
import com.example.meditationuiapp.ui.theme.ButtonBlue
import com.example.meditationuiapp.ui.theme.DarkerButtonBlue
import com.example.meditationuiapp.ui.theme.DeepBlue
import com.example.meditationuiapp.ui.theme.LightGreen1
import com.example.meditationuiapp.ui.theme.LightGreen2
import com.example.meditationuiapp.ui.theme.LightGreen3
import com.example.meditationuiapp.ui.theme.LightRed
import com.example.meditationuiapp.ui.theme.OrangeYellow1
import com.example.meditationuiapp.ui.theme.OrangeYellow2
import com.example.meditationuiapp.ui.theme.OrangeYellow3
import com.example.meditationuiapp.ui.theme.TextWhite

// TODO: note
//  per le grafiche sugli elementi:
//      - meditaz corrente - si puo fare con vari generatori immagini vettoriali
//      - featured - onde generate con compose


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            // 1
            GreetingSection("Dimitri")

            // 2
            ChipSection(listOf("SweetSleep", "Insomnia", "Depression"))

            // 3
            CurrentMeditation(text1 = "Daily Thought", text2 = "Meditation • 3-10 min")

            // 4
            FeatureSection(
                listOf(
                    Feature(
                        title = "Sleep Meditation",
                        iconId = R.drawable.ic_headphone,
                        lightColor = BlueViolet1,
                        mediumColor = BlueViolet2,
                        darkColor = BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        iconId = R.drawable.ic_videocam,
                        lightColor = LightGreen1,
                        mediumColor = LightGreen2,
                        darkColor = LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        iconId = R.drawable.ic_headphone,
                        lightColor = OrangeYellow1,
                        mediumColor = OrangeYellow2,
                        darkColor = OrangeYellow3
                    ),
                    Feature(
                        title = "Calming Sounds",
                        iconId = R.drawable.ic_headphone,
                        lightColor = Beige1,
                        mediumColor = Beige2,
                        darkColor = Beige3
                    ),
                    // ecc
                )
            )
        }
        // 5 ultimo
        BottomMenu(
            items,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}


// --------- 1° SECTION ----------------------------------------------
@Composable
fun GreetingSection(
    name: String = "Dude"
) {
    Row(
        // voglio mettere gli elementi ai lati della riga
        horizontalArrangement = Arrangement.SpaceBetween, // spingi elementi ai lati
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
//            tint = MaterialTheme.colorScheme.primary, // colore generato da M3
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
        // items = componente di compose
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


// 3° sezione
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

// 4° sezione
// LazyVerticalGrid,
// LazyVerticalStaggeredGrid
@Composable
fun FeatureSection(
    features: List<Feature>
) {
    Column(

    ) {
        // 1 elemento
        Text(
            text = "Featured",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            modifier = Modifier.padding(15.dp)
        )

        /** LazyVerticalGrid -> e cambiata nella ultime versioni
         * firma attuale di base */
        // cells -> diventa columns
//        LazyVerticalGrid(
//            columns: GridCells,
//            modifier: Modifier = Modifier,
//        contentPadding: PaddingValues = PaddingValues(0.dp),
//        horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
//        verticalArrangement: Arrangement.Vertical = Arrangement.Top,
//        content: LazyGridScope.() -> Unit
//        )

        // 2 elemento
        LazyVerticalGrid(
            // GridCells -> Fixed, FixedSize, Adaptive
            columns = GridCells.Fixed(2),
            // 100 perche voglio che lascia spazio alla nav bar
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
//                .fillMaxWidth() // no
        ) {
            // count, itemCount lambda -> obbligatori
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }

}


// Canvas for waves
// BoxWithConstraints
//
@Composable
fun FeatureItem(
    feature: Feature
) {
    // main component -----------
    // struttura interna: elementi sovrapposti
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp) // 7.5dp
            .aspectRatio(1f) // forma, 1f=quadrato
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor) // strato inferione
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // medium colored path
        // !! definisco i punto per le linee divisorie
        val mediumPoint1 = Offset(0f, height * 0.3f)
        val mediumPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumPoint4 = Offset(width * 0.7f, height * 0.7f)
        val mediumPoint5 = Offset(width * 1.4f, -height.toFloat())

        // funzone specifica per grafica
        val mediumColorPath = Path().apply {
            moveTo(mediumPoint1.x, mediumPoint1.y)
            standardQuadFromTo(mediumPoint1, mediumPoint2)
            standardQuadFromTo(mediumPoint2, mediumPoint3)
            standardQuadFromTo(mediumPoint3, mediumPoint4)
            standardQuadFromTo(mediumPoint4, mediumPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // 1. first layer
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColorPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }

        // secondo layer
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                lineHeight = 26.sp, // piu spazio tra le righe
                modifier = Modifier
                    .align(Alignment.TopStart) //
            )

            // default painter, contentDescription
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
            )

            // default text
            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = ButtonBlue, shape = RoundedCornerShape(12.dp))
                    .padding(vertical = 6.dp, horizontal = 16.dp) // margine interno
                    .clickable {
                        // TODO da solo
                        //  open detail view
                    }
            )
        }
    }
}

@Composable
fun BottomMenu(
    items: List<Pair<Int, String>>, // TODO refactor
    modifier: Modifier = Modifier, // uso sulle row se necessario
    startSelectedElement: Int = 0, // default su home
    selectedIconColor: Color = ButtonBlue,
    selectedTextColor: Color = TextWhite,
    defaultTextColor: Color = AquaBlue
) {
    var selectedNavIndex by remember {
        mutableIntStateOf(startSelectedElement)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween, // space
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue) // TODO background solo per test
            .padding(vertical = 10.dp, horizontal = 20.dp) // interno al background

    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = items[index],
                isSelected = index == selectedNavIndex,
                selectedIconColor = selectedIconColor,
                selectedTextColor = selectedTextColor,
                defaultTextColor = defaultTextColor,
                onItemCLick = {
                    selectedNavIndex = index
                }
            )
        }

    }
}


@Composable
fun BottomMenuItem(
    item: Pair<Int, String>,
    isSelected: Boolean,
    selectedIconColor: Color = ButtonBlue,
    selectedTextColor: Color = TextWhite,
    defaultTextColor: Color = AquaBlue,
    onItemCLick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable {
                onItemCLick()
            }
    ) {
        Icon(
            painter = painterResource(item.first),
            contentDescription = item.second,
            tint = if (isSelected) selectedTextColor else defaultTextColor,
            modifier = Modifier
                .size(40.dp)
                .background(
                    color = if (isSelected) selectedIconColor else Color.Transparent,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp)
        )

        Text(
            item.second,
            color = if (isSelected) selectedTextColor else defaultTextColor,
            modifier = Modifier
                .padding(top = 8.dp)
        )

    }

}


// TODO con navigationBar !!!!!!
//@Composable
//fun BottomMenu1() {
//    NavigationBar {
//        NavigationBarItem(
//            selected = true,
//            onClick = { },
//            icon = { Icon(R.drawable.ic_home, contentDescription = "Home") },
//            label = { Text("Home") }
//        )
//    }
//}


// -------------------- PREVIEW ----------------------------------------------
//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen()
//}


//@Preview(showBackground = true)
//@Composable
//fun FeaturePreview() {
//    FeatureItem(
//        Feature(
//            title = "Sleep meditation",
//            iconId = R.drawable.ic_headphone,
//            lightColor = BlueViolet1,
//            mediumColor = BlueViolet2,
//            darkColor = BlueViolet3
//        )
//    )
//}

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    BottomMenu(items)
}


// devo avere una lista con for each per avere elementi selezionabili
val items = listOf(
    Pair(R.drawable.ic_home, "Home"),
    Pair(R.drawable.ic_bubble, "Meditate"),
    Pair(R.drawable.ic_moon, "Sleep"),
    Pair(R.drawable.ic_music, "Music"),
    Pair(R.drawable.ic_profile, "Profile"),
)


