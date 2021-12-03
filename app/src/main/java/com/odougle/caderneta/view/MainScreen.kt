package com.odougle.caderneta.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.internal.ComposableLambda
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.odougle.caderneta.R
import com.odougle.caderneta.util.DEFAULT_PADDING
import com.odougle.caderneta.util.SHAPE
import com.odougle.caderneta.util.SPACER_HEIGHT
import com.odougle.caderneta.view.components.CadernetaBottomAppBar
import com.odougle.caderneta.view.components.CadernetaTopAppBar
import com.odougle.caderneta.view.navigation.BottomNavGraph
import com.odougle.caderneta.view.screens.AddItems
import com.odougle.caderneta.view.screens.bottomSheetDialogs.NewIncome

@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val selectionAux = remember{ mutableStateOf(0)}
    var selection by remember {
        mutableStateOf(0)
    }
    val content: @Composable (() -> Unit) = {
        Options(selection = selectionAux)
    }

    var sheetContent by remember { mutableStateOf(content) }

    ModalBottomSheetLayout(
        sheetState = bottomState,
        sheetShape = SHAPE,
        sheetContent = {
            sheetContent()
        }
    ) {
        BottomNavGraph(navHostController = navController)

        when (selection) {
            1 -> {
                sheetContent = { NewIncome() }
            }
        }

        if (bottomState.isVisible) {

        }else{
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(enabled = true) {
                    selection.value = 1
                }

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_income),
                contentDescription = stringResource(id = R.string.income_button_content_description)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(id = R.string.add_new_income_text))
        }
        Spacer(modifier = Modifier.height(SPACER_HEIGHT))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(enabled = true) {
                    selection.value = 2
                }

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outlay),
                contentDescription = stringResource(id = R.string.outlay_button_content_description)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(id = R.string.add_new_outlay_text))
        }
        Spacer(modifier = Modifier.height(SPACER_HEIGHT))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(enabled = true) {
                    selection.value = 3
                }

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_goals),
                contentDescription = stringResource(id = R.string.income_button_content_description)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(id = R.string.add_new_goals_text))
        }
        Spacer(modifier = Modifier.height(SPACER_HEIGHT))

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
