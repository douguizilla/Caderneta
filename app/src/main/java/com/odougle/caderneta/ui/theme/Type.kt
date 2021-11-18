package com.odougle.caderneta.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.odougle.caderneta.R

// Set of Material typography styles to start with

val Bernadette = FontFamily(Font(R.font.bernadette))
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Bernadette,
        fontSize = 24.sp,
        color = Color.DarkGray
    )
)