package com.example.meditationuiapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.meditationuiapp.R

// personalizzata
val gothicA1Family = FontFamily(
    listOf(
        Font(R.font.gothica1_regular, FontWeight.Normal),
        Font(R.font.gothica1_medium, FontWeight.Medium),
        Font(R.font.gothica1_semibold, FontWeight.SemiBold),
        Font(R.font.gothica1_bold, FontWeight.Bold),
        Font(R.font.gothica1_black, FontWeight.Black),
    )
)



val Typography = Typography(
    // h1
    titleLarge = TextStyle( // es Featured, Detail Sleep Meditation
        color = TextWhite,
        fontFamily = gothicA1Family,
        fontWeight = FontWeight.Black,
        fontSize = 26.sp,
        letterSpacing = 1.7.sp
    ),

    // h2
    titleMedium = TextStyle( // es Good Morning, Daily, Feature title?
        color = TextWhite,
        fontFamily = gothicA1Family,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        letterSpacing = 1.5.sp
    ),

    // body1
    bodyLarge = TextStyle( // es daily subtitle, detail description
        color = AquaBlue,
        fontFamily = gothicA1Family,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp, // era 16.sp
//        lineHeight = 24.sp,
        letterSpacing = 1.sp
    ),
    // body2
    bodyMedium = TextStyle( // others
        color = AquaBlue,
        fontFamily = gothicA1Family,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp, //
        letterSpacing = 1.sp
    ),


    /*
     * NOTES: bodyLarge vs bodyMedium
     *  cambio fontSize, ma hanno anche 'lineHeight' e 'letterSpacing' diversi; quindi aplicati in questo modo hanno risultati diversi
        Text(
            text = "Abc,
            style = typography.bodyLarge,
            fontSize = 18.sp
    )

        Text(
            text = "Abc,
            style = typography.bodyLarge,
            fontSize = 18.sp
    )
     */



    // esempio
    /*
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)