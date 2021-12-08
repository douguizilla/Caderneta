package com.odougle.caderneta.view.screens.bottomSheetDialogs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.odougle.caderneta.R
import com.odougle.caderneta.util.DEFAULT_PADDING
import com.odougle.caderneta.util.SPACER_HEIGHT

@Composable
fun Options(selection: MutableState<Int>) {
    Column(modifier = Modifier.padding(DEFAULT_PADDING)) {
        AddBottomSheetItem(
            drawableIconId = R.drawable.ic_income,
            label = stringResource(id = R.string.add_new_income_text),
            contentDescription = stringResource(R.string.income_button_content_description),
            option = 1,
            selection = selection
        )

        AddBottomSheetItem(
            drawableIconId = R.drawable.ic_outlay,
            label = stringResource(id = R.string.add_new_outlay_text),
            contentDescription = stringResource(R.string.outlay_button_content_description),
            option = 2,
            selection = selection
        )

        AddBottomSheetItem(
            drawableIconId = R.drawable.ic_goals,
            label = stringResource(id = R.string.add_new_goals_text),
            contentDescription = stringResource(id = R.string.income_button_content_description),
            option = 3,
            selection = selection
        )

    }
}

@Composable
fun AddBottomSheetItem(
    drawableIconId: Int,
    label: String,
    contentDescription: String,
    spacerHeight: Dp = SPACER_HEIGHT,
    option: Int,
    selection: MutableState<Int>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = true) {
                selection.value = option
            }

    ) {
        Icon(
            painter = painterResource(id = drawableIconId),
            contentDescription = contentDescription
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label)
    }
    Spacer(modifier = Modifier.height(spacerHeight))
}

//https://dev.to/davidibrahim/how-to-use-multiple-bottom-sheets-in-android-compose-382p
