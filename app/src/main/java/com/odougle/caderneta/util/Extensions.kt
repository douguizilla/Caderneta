package com.odougle.caderneta.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Int.fromStringRes() : String{
    return stringResource(id = this)
}


fun String.parseToDP() =
    if(this.length < 5){
        (this.length * 13).dp
    }else if(this.length < 10){
        (this.length * 10).dp
    }else{
        (this.length * 8).dp
    }
