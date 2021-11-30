package com.odougle.caderneta.view.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.odougle.caderneta.R

@ExperimentalMaterialApi
@Composable
fun AddItems() {
    Column(modifier = Modifier.padding(16.dp)) {
        AddBottomSheetItem(
            drawableIconId = R.drawable.ic_income,
            contentDescription = stringResource(R.string.add_button_content_description),
            spacerHeight = 16.dp
        )
        AddBottomSheetItem(
            drawableIconId = R.drawable.ic_outlay,
            contentDescription = stringResource(R.string.outlay_button_content_description),
            spacerHeight = 16.dp
        )
        AddBottomSheetItem(
            drawableIconId = R.drawable.ic_goals,
            contentDescription = stringResource(R.string.goals_button_content_description),
            spacerHeight = 16.dp
        )

    }
}

@Composable
fun AddBottomSheetItem(
    drawableIconId: Int,
    contentDescription: String,
    spacerHeight: Dp,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = true) {

            }

    ) {
        Icon(
            painter = painterResource(id = drawableIconId),
            contentDescription = contentDescription
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = contentDescription)
    }
    Spacer(modifier = Modifier.height(spacerHeight))
}

//https://dev.to/davidibrahim/how-to-use-multiple-bottom-sheets-in-android-compose-382p