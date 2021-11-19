package com.odougle.caderneta.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun Int.fromStringRes() : String{
    return stringResource(id = this)
}