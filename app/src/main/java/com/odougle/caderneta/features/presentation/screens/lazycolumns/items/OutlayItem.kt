package com.odougle.caderneta.features.presentation.screens.lazycolumns.items

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.odougle.caderneta.ui.theme.MyRed

@Composable
fun OutlayItem(
    tag: String,
    description: String,
    date: String,
    value: String,
    color: Color = MyRed
    ) {
        BaseItem(
            tag = tag,
            description = description,
            date = date,
            value = value,
            isValuePositive = false,
            color = color,
            backgroundColor = MaterialTheme.colors.background
        )
    }