package com.odougle.caderneta.view.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.odougle.caderneta.R
import com.odougle.caderneta.view.screens.bottomSheetDialogs.NewIncome

@ExperimentalMaterialApi
@Composable
fun AddItems(bottomState: ModalBottomSheetState) {
    var bottomSheet by remember {
        mutableStateOf(0)
    }

    when(bottomSheet){
        0 -> {
            //Options(bottomSheet)
        }
        1 -> {
            NewIncome()
        }
        else -> {

        }
    }

}

