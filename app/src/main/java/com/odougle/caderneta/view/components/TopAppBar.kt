package com.odougle.caderneta.view.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun <T> TopAppBar(
    title: @Composable() () -> Unit,
    actionData: List<T>,
    color: Color = MaterialTheme.colors.primary,
    navigationIcon: @Composable() (() -> Unit)? = null,
    action: @Composable() (T) -> Unit
) {

}