package com.odougle.caderneta.view.screens.lazycolumns.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.odougle.caderneta.ui.theme.MyGreen

@Composable
fun IncomeItem(
    tag: String,
    description: String,
    date: String,
    value: String,
    color: Color = MyGreen
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