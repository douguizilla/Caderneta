package com.odougle.caderneta.view.screens.lazycolumns.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun IncomeItem(
    tag: String,
    description: String,
    date: String,
    value: String,
    color: Color = Color.Green
) {
    BaseItem(
        tag = tag,
        description = description,
        date = date,
        value = value,
        isValuePositive = true,
        color = color
    )
}