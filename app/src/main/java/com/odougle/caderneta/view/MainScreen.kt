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
import com.odougle.caderneta.view.screens.bottomSheetDialogs.NewOutlay
import com.odougle.caderneta.view.screens.bottomSheetDialogs.Options

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
        modifier = Modifier.fillMaxSize(),
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
            2 ->{
                sheetContent = { NewOutlay(bottomSheetState = bottomState) }
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
            modifier = Modifier.fillMaxSize(),
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