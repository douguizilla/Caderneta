package com.odougle.caderneta.features.presentation.screens.lazycolumns.items

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.odougle.caderneta.ui.theme.MyGreen

@Composable
fun IncomeItem(
    tag: String,
    description: String,
    date: String,
    value: String,
    color: MutableState<Color>,
    backgroundColor: MutableState<Color>
) {
    BaseItem(
        tag = tag,
        description = description,
        date = date,
        value = value,
        isValuePositive = true,
        color = color.value,
        backgroundColor = backgroundColor.value
    )
}