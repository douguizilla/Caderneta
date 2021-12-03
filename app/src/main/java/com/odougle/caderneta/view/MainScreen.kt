package com.odougle.caderneta.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.odougle.caderneta.R
import com.odougle.caderneta.util.DEFAULT_PADDING
import com.odougle.caderneta.util.TOP_START_AND_TOP_END_ROUNDED_CORNER_SHAPE
import com.odougle.caderneta.util.SPACER_HEIGHT
import com.odougle.caderneta.view.components.CadernetaBottomAppBar
import com.odougle.caderneta.view.components.CadernetaTopAppBar
import com.odougle.caderneta.view.navigation.BottomNavGraph
import com.odougle.caderneta.view.screens.bottomSheetDialogs.NewIncome

@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    val selectionAux = remember { mutableStateOf(0) }
    var selection by remember { mutableStateOf(0) }

    val content: @Composable (() -> Unit) = {
        Options(selection = selectionAux)
    }

    var sheetContent by remember { mutableStateOf(content) }

    ModalBottomSheetLayout(
        sheetState = bottomState,
        sheetShape = TOP_START_AND_TOP_END_ROUNDED_CORNER_SHAPE,
        sheetContent = {
            sheetContent()
        }
    ) {
        BottomNavGraph(navHostController = navController)

        when (selection) {
            1 -> {
                sheetContent = { NewIncome(bottomSheetState = bottomState) }
            }
        }

        if (bottomState.isVisible) {

        } else {
            selection = 0
            selectionAux.value = 0
            sheetContent = {
                Options(selection = selectionAux)
            }
        }

        selection = selectionAux.value

        Scaffold(
            topBar = { CadernetaTopAppBar() },
            bottomBar = {
                CadernetaBottomAppBar(
                    navController = navController,
                    bottomState = bottomState
                )
            }
        ) {
            BottomNavGraph(navHostController = navController)
        }


    }
}

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
