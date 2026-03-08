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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meditationuiapp.ui.theme.AquaBlue
import com.example.meditationuiapp.ui.theme.ButtonBlue
import com.example.meditationuiapp.ui.theme.DarkerButtonBlue
import com.example.meditationuiapp.ui.theme.DeepBlue
import com.example.meditationuiapp.ui.theme.LightRed
import com.example.meditationuiapp.ui.theme.TextWhite


// TODO
// devo avere una lista con for each per avere elementi selezionabili
val navigationItems = listOf(
    Pair(R.drawable.ic_home, "Home"),
    Pair(R.drawable.ic_bubble, "Meditate"),
    Pair(R.drawable.ic_moon, "Sleep"),
    Pair(R.drawable.ic_music, "Music"),
    Pair(R.drawable.ic_profile, "Profile"),
)

val chipList = listOf("Sweet sleep", "Insomnia", "Depression")


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onFeatureClick: (featureId: Int) -> Unit,
    // TODO viewmodel ok
    viewModel: HomeScreenViewModel = viewModel()
) {
    // TODO viewmodel ok
    val features = viewModel.features.collectAsStateWithLifecycle().value // CORRETTO?



    Box(
        modifier = modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column {
            //
            Spacer(modifier = Modifier.padding(bottom = 20.dp))
            // 1
            GreetingSection("Dimitri")
            //
            Spacer(modifier = Modifier.padding(bottom = 36.dp))
            // 2
            ChipSection(chipList)
            //
            Spacer(modifier = Modifier.padding(bottom = 32.dp))
            // 3
            CurrentMeditation(title = "Daily Thought", subTitle = "Meditation  •  3-10 min")  // OK
            //
            Spacer(modifier = Modifier.padding(bottom = 50.dp))
            // 4
            FeaturesSection(features, onFeatureClick = { id ->
                onFeatureClick(id)
            })
            // bottom delimitato 100dp da 'LazyVerticalGrid -> contentPadding'

        }
        BottomMenu(
            navigationItems,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

// i padding si sommano!!


// --------- 1° SECTION ---------------------------------------------- TODO OK
@Composable
fun GreetingSection(
    name: String = "Mario",
) {
    Row(
        // voglio mettere gli elementi ai lati della riga
        horizontalArrangement = Arrangement.SpaceBetween, // spingi elementi ai lati
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
//            .background(ButtonBlue) // preview
//            .padding(15.dp) // old
//            .padding(bottom = 6.dp) // old
            .padding(horizontal = 15.dp) // new with spacers


    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good morning, $name",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                style = typography.titleMedium,
                color = TextWhite,
            )

            Spacer(Modifier.padding(bottom = 15.dp))

            Text(
                text = "We wish you have a good day!",
                style = typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
                color = AquaBlue,
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = null,
            tint = TextWhite, // colore standard
            // alternative
//            tint = AquaBlue, // colore da color
//            tint = MaterialTheme.colorScheme.primary, // colore generato da M3
            modifier = Modifier.size(24.dp)
        )
    }
}


// --------- 2° SECTION ---------------------------------------------- TODO
@Composable
fun ChipSection(
    chips: List<String>
) {
    // unico per il gruppo
    var selectedChipIndex by remember { mutableStateOf(0) }

    LazyRow(
//        Modifier.background(Color.DarkGray) // preview
    ) {
        // items = componente di compose
        items(chips.size) { index ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    // with spacesrs
                    .padding(start = 15.dp) // esterno
                    .clickable { // azione al click
                        selectedChipIndex = index
                    }
                    .clip(RoundedCornerShape(12.dp)) // rotondità
                    .background(
                        if (selectedChipIndex == index) ButtonBlue
                        else DarkerButtonBlue
                    )
                    .padding(
                        vertical = 16.dp,
                        horizontal = 16.dp
                    )
            ) {
                Text(
                    chips[index],
                    color = TextWhite,
//                    fontStyle = ,// no
                    style = typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    letterSpacing = 1.5.sp
                )
            }
        }
    }
}


// --------- 3° SECTION ----------------------------------------------
@Composable
fun CurrentMeditation(
    color: Color = LightRed,
    title: String,
    subTitle: String
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
//            .background(Color.White) // preview
            .padding(horizontal = 15.dp) // external vertical with spacers
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .padding(horizontal = 18.dp, vertical = 26.dp) // internal
            .fillMaxWidth()

    ) {
        Column() {
            Text(
                text = title,
                style = typography.titleMedium,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp,
                fontSize = 20.sp,
                color = TextWhite
            )

            Spacer(Modifier.padding(bottom = 10.dp))

            Text(
                text = subTitle,
                style = typography.bodySmall,
//                fontWeight = FontWeight.SemiBold,
                color = TextWhite,
                fontSize = 14.sp
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(44.dp)
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

// ---------4° SECTION ----------------------------------------------
// LazyVerticalGrid,
// LazyVerticalStaggeredGrid
@Composable
fun FeaturesSection(
    features: List<Feature>,
    onFeatureClick: (featureId: Int) -> Unit,
    sectionTitle: String = "Featured",
) {
    Column(
//        modifier = Modifier.padding(top = 20.dp) // moved su Spacer
    ) {
        // 1 elemento
        Text(
            text = sectionTitle,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            fontSize = 28.sp,
            modifier = Modifier.padding(horizontal = 15.dp)
        )

        Spacer(modifier = Modifier.padding(bottom = 15.dp))

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
            contentPadding = PaddingValues(
                start = 7.5.dp,
                end = 7.5.dp,
                bottom = 100.dp
            ),
            modifier = Modifier.fillMaxHeight()
//                .fillMaxWidth() // no
        ) {
            // count, itemCount lambda -> obbligatori
//            items(features.size) {
            items(features) { feature ->
                Box(
                    modifier = Modifier.clickable {
                        onFeatureClick(feature.id)
                    }
                ) {
                    FeatureItem(feature = feature)
                }
            }
        }
    }

}


// Canvas for waves
// BoxWithConstraints
// ha i default settati per home page
@Composable
fun FeatureItem(
    feature: Feature,
    aspectRatio: Float = 1f, // forma, 1f=quadrato
    externalContainerPadding: PaddingValues = PaddingValues(7.5.dp), // 7.5 default per home page
    internalContainerPadding: PaddingValues = PaddingValues(
        vertical = 24.dp,
        horizontal = 20.dp
    ), // default per home page
    showTitle: Boolean = true,
    titleSize: TextUnit = 20.sp,
    iconSize: Dp = 22.dp,
    buttonTextSize: TextUnit = 13.sp, // // 12 default per home page
    buttonPadding: PaddingValues = PaddingValues(vertical = 10.dp, horizontal = 20.dp),
    modifier: Modifier = Modifier
) {
    // main component -----------
    // struttura interna: elementi sovrapposti
    BoxWithConstraints(
        modifier = modifier
            .padding(externalContainerPadding) // default 7.5dp
            .aspectRatio(aspectRatio) // forma, 1f=quadrato
            .clip(RoundedCornerShape(16.dp))
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
                .padding(internalContainerPadding) // // default per home page v=24, h=18
        ) {

            if (showTitle) {
                Text(
                    text = feature.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontSize = titleSize,
                    letterSpacing = 0.5.sp,
                    lineHeight = 30.sp, // piu spazio tra le righe
                    modifier = Modifier
                        .align(Alignment.TopStart) //
                )
            }


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {

                Icon(
                    painter = painterResource(id = feature.iconId),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
//                        .align(Alignment.BottomStart)
                        .size(iconSize) // 24, default
                )

                // default text
                Text(
                    text = "Start",
                    color = TextWhite,
                    fontSize = buttonTextSize,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
//                        .align(Alignment.BottomEnd)
                        .clip(RoundedCornerShape(14.dp))
                        .background(color = ButtonBlue, shape = RoundedCornerShape(12.dp))
                        .padding(buttonPadding) // margine interno, personalizzabile
                        .clickable {
                            // TODO da solo
                            //  open detail view
                        }
                )
            }

        }
    }
}


// -------------- BOTTOM MENU -----------------------------------------------------------------------
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

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
//    BottomMenu(navigationItems)
    HomeScreen(onFeatureClick = {})
}


